/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha
 * Created October 2, 2003                                    David C. Brown
 *
 * We are now the job in charge of the printer.  Data is printed in
 * transaction mode -- it is buffered until the print transaction is closed
 * and then streams rapidly from the device.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.JposFactory;

import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;

/**
 * Abstract class to help implement transaction-mode Jpos printing.  The
 * lines are buffered by the driver and then sent to the printer in bulk.
 */

public abstract class PrintDriverTransaction implements IPrintRqst {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrintDriverTransaction.class);
	protected POSPrinter	prn;

	/**
	 * Helper method to set up the system Jpos printer and then
	 * allow implementation to supply the data.  All implementing
	 * classes have complete access to the Jpos printer while the
	 * queue has activated that job.
	 *
	 * @exception	JposException
	 */

	@Override
	public void execute() throws JposException {

		prn = (POSPrinter)JposFactory.getInstance("VFIPrinter");
		prn.setDeviceEnabled(true);

		/*-
		 * Transaction mode printing buffers the data
		 * so that printing is substantially faster.
		 * 
		 * If this is a journal printer (i.e. TMU950) transaction
		 * mode is not used to print in both stations simultaneously.
		 */

		if (prn.getCapTransaction() && !prn.getCapJrnPresent()) {
			prn.transactionPrint(POSPrinterConst.PTR_S_RECEIPT,
				POSPrinterConst.PTR_TP_TRANSACTION);
		} else {
			logger.debug(
				"So sorry, transactions not supported on device");
		}

		sendPrintData();

		/*- Turn off transaction mode */

		try {
			if (prn.getCapTransaction() && !prn.getCapJrnPresent()) {
				prn.transactionPrint(POSPrinterConst.PTR_S_RECEIPT,
					POSPrinterConst.PTR_TP_NORMAL);
			}
		} catch (JposException jpe2) {
			logger.error(
				"POSPrinter exception turning off transation mode" + jpe2);
		}

	}

	/**
	 * Implementers can do whatever they want with the printer.
	 *
	 * @throws jpos.JposException
	 */

	public abstract void sendPrintData() throws JposException;

	/**
	 * Accessor so we can still keep our reference to the printer private.
	 *
	 * @return	POSPrinter
	 */

	public POSPrinter getPOSPrinter() {
		return prn;
	}
}
