/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha
 * Created October 2, 2003                                    David C. Brown
 *
 * We are now the job in charge of the printer.  Data is printed as it is
 * created.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import com.verifone.isd.vsms2.sys.util.JposFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

import jpos.POSPrinter;
import jpos.POSPrinterConst;

import jpos.JposException;

/**
 * Abstract class to help implement immediate-mode Jpos printing.  The lines
 * are sent to the printer as they are created, this is OK for short jobs but
 * will make the printer output seem slow and jerky.
 */

public abstract class PrintDriverImmediate implements IPrintRqst {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrintDriverImmediate.class);
	protected POSPrinter	prn;

	/**
	 * Helper method to set up the system Jpos printer and then
	 * allow implementation to supply the data.  All implementing
	 * classes have complete access to the Jpos printer while the
	 * queue has activated that job.
	 *
	 * @exception	JposException
	 */

	public void execute() throws JposException {

		prn = (POSPrinter)JposFactory.getInstance("VFIPrinter");
		prn.setDeviceEnabled(true);

		/*- Turn off transaction mode */

		try {
			if (prn.getCapTransaction()) {
				prn.transactionPrint(POSPrinterConst.PTR_S_RECEIPT,
					POSPrinterConst.PTR_TP_NORMAL);
			}
		} catch (JposException jpx) {
			logger.error(
				"POSPrinter exception turning off transation mode" + jpx);
		}

		sendPrintData();
	}

	/**
	 * Implementers can do whatever they want with the printer.
	 *
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
