/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha
 * Created October 2, 2003                                    David C. Brown
 *
 * Set up a Jpos printer, place requests on the queue and then service the
 * queue.  The exiting thread invokes the next element in the queue which
 * services its own request via a new thread.  In the event the thread dies
 * the cycle will restart with the next job as soon as a new print request
 * is placed on the queue.  Therefore the faulting job is NOT restarted.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import com.verifone.isd.vsms2.sys.util.JposFactory;
import jpos.JposException;

/**
 * Print the given request.  The request implements a command pattern, all
 * this printer system has to do is call the execute method, passing the
 * reference to this POS printer as the argument.  Whatever the actual
 * command patter chooses to do is fair game -- it has full control over
 * the printer during the course of it's thread of execution.  Once the
 * pattern returns, or receives an exception, this thread saves the status
 * in the Pjob associated with this request and starts the next job off the
 * queue.
 * <p>
 * Each thread invokes the next job and then starts a thread for that job
 * before exiting.  In the event this cycle is broken it will be renewed
 * with the next print request.
 * <p>
 * To enable Log'ing of PrinterManager messages, please see
 * {@link JposFactory#DEBUG_FLAG_PRINT_MGR}.
 * 
 * @author	David C. Brown
 * @version 1.0
 */

public class PrinterMgr {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrinterMgr.class);
    /**
     * Default JPOS Logical Name to use for the Receipt Printer.
     */
    public static final String DEFAULT_RECEIPT_LOGICALNAME = "VFIPrinter";

	/*-
	 * To prevent interleaved printer output we work out of a queue of
	 * jobs.  There is a fixed limit and once we exceed this no more
	 * jobs are allowed.  Once we pass the high-water level we send
	 * warnings.  We clear the warnings after we pass the low-water level.
	 */

    /**
     * Specifies maximum {@link Pjob jobs} to be queued for printing.
     * <p>
     */
	public static final int		MAX_PJOBS = 40;
	public static final int		LOW_WATER = 3;
	public static final int		HIGH_WATER = 15;

    /**
     * Collection of {@link PrinterMgr.StatusListener}.
     */
    protected static java.util.ArrayList statusListeners = null;

    /**
     * The thread managed printer queue that print requests are posted to.
     */
    protected static PrintQueueRunnable ptrQueue = null;

    /**
     * Debug flags retrieved from jpos.xml file found in the VFIPrinter JposEntry
     * element.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is assigned to this variable.
     */
    protected static int debugFlags = 0;

    /**
     * Get the {@link #debugFlags} value.
     * @return Bitflags set for specific areas to &quot;printLine&quot;.
     */
    public static int getDebugFlags()
    {
        return debugFlags;
    }

    /**
     * Set the {@link #debugFlags} value.
     * @param debugFLags Bitflags for specific areas to &quot;printLine&quot;.
     */
    public static void setDebugFlags(int debugFLags)
    {
        PrinterMgr.debugFlags = debugFlags;
    }

	/**
	 * Any print requests need to construct a Pjob object to hold the status
	 * for callback after the job prints, and an implementation of the printer
	 * driver that will submit data to the printer.  Jobs are placed on a
	 * queue and then a thread is created to print the job once it reaches the
	 * end of the queue.
	 *
	 * @param pr The request to {@link IPrintRqst#execute call} when its their turn.
	 * @param prn  The "signalling" class for this request.
	 * @return	Number of jobs in the queue. May or may not show currently
     *          submitted job. The queue thread may have already been scheduled
     *          to consume the submitted request by the time this method returns.
     *          -1 is returned on {@link PrintQueueRunnable queue thread}
     *          initialization errors.
     *
	 * @see PrintDriverTransaction
	 * @see PrintDriverImmediate
	 */

	public static int addJob(IPrintRqst pr, Pjob prn)
    {

        int jobcnt = -1;
        PrintQueueRunnable pq = getPrinterQueue();

        if (pq != null)
        {
            pq.addJob(pr, prn);
            jobcnt = pq.getJobCount();
        } else
        {
            prn.status = Pjob.FAILED;
            prn.sendNotify();
        }

		return jobcnt;
	}
	
	/**
	 * Method to know the total number of jobs currently present in PrintQueueRunnable's print queue
	 * @return total number of jobs in PrintQueueRunnable's queue
	 */
	public static int getPrinterJobCount() {
		int jobcnt = -1;
		PrintQueueRunnable pq = getPrinterQueue();
        if (pq != null)
        {
            jobcnt = pq.getJobCount();
        }
        return jobcnt;
	}

    /**
     * Get the singleton instance of the print requests queue thread.
     * @return The instance to use. <code>null</code> if any errors trying
     *         to instantiate {@link PrintQueueRunnable}.
     */
    private synchronized static PrintQueueRunnable getPrinterQueue()
    {
        boolean creationNeeded = false;

        // If not created or if the runnable is dying, create it
        if ((PrinterMgr.ptrQueue == null)
            || !PrinterMgr.ptrQueue.isKeepRunning()
            || !PrinterMgr.ptrQueue.isAlive())
        {
            creationNeeded = true;
        }

        if (creationNeeded)
        {
            try
            {
//                PrinterMgr.ptrQueue = new PrintQueueRunnable();
                PrintQueueRunnable qRunnable = new PrintQueueRunnable();

                // Check to see if queued jobs from an older queue need to be propagated
                if (PrinterMgr.ptrQueue != null)
                {
                    while (!PrinterMgr.ptrQueue.isEmpty())
                    {
                        PrintQueueRunnable.PrinterJob aJob = PrinterMgr.ptrQueue.getNextJob();
                        if (null == aJob)
                        {
                            break;
                        }
                        qRunnable.addJob(aJob.getRequest(), aJob.getJob());
                    }
                }
                PrinterMgr.ptrQueue = qRunnable;
                PrinterMgr.ptrQueue.start();
            } catch (JposException je)
            {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrinterMgr.class).error("PrinterMgr: JposException caught starting printer queue thread! " + je);
            }
        }

        return ptrQueue;
    }

    /**
     * Add a manager status listener.
     * @param printerMgrStatusListener The listener to be notified.
     */
    public static synchronized void addPrinterManagerStatusListener(PrinterMgr.StatusListener printerMgrStatusListener ) {
        if (PrinterMgr.statusListeners == null ) {
            PrinterMgr.statusListeners = new java.util.ArrayList();
        }

        if (!PrinterMgr.statusListeners.contains(printerMgrStatusListener))
        {
            PrinterMgr.statusListeners.add( printerMgrStatusListener );
        }

        PrintQueueRunnable pq = getPrinterQueue();
        if (pq != null)
        {
            printerMgrStatusListener.notifyPrinterMgrBusyStatus(pq.isBusy());
        }
    }

    /**
     * Remove a manager status listener.
     * @param printerMgrStatusListener The listener to be removed.
     */
    public static synchronized void removePrinterManagerStatusListener(PrinterMgr.StatusListener printerMgrStatusListener ) {
        if (PrinterMgr.statusListeners != null ) {
            PrinterMgr.statusListeners.remove( printerMgrStatusListener );
        }
   }

    /**
     * Called by {@link PrintQueueRunnable} to notify listeners of busy
     * printing requests or idle, no requests pending.
     * @param status <code>true</code> if servicing requests or
     *               <code>false</code> if no requests are pending or being printed.
     */
    static void notifyStatusListeners( boolean status ) {
        PrinterMgr.StatusListener[] theListeners = new PrinterMgr.StatusListener[0];
        synchronized(PrinterMgr.class)
        {
            if (PrinterMgr.statusListeners == null ) {
                return;
            }

            theListeners = (PrinterMgr.StatusListener[])
                    PrinterMgr.statusListeners.toArray(theListeners);
        }

        for (int i = 0; i < theListeners.length; i++)
        {
            PrinterMgr.StatusListener aListener = theListeners[i];
            try {
                aListener.notifyPrinterMgrBusyStatus(status);
            } catch( Exception e  ) {
                removePrinterManagerStatusListener(aListener);
            }
        }
    }

    /**
     * Interface defining a PrinterMgr status listener.
     * @see PrinterMgr#addPrinterManagerStatusListener(PrinterMgr.StatusListener)
     * @see PrinterMgr#removePrinterManagerStatusListener(PrinterMgr.StatusListener)
     */
    public static interface StatusListener {

        /**
         * Callback signalling status of queue management.
         * @param status <code>true</code> if servicing requests or
         *               <code>false</code> if no requests are pending or being
         *               printed.
         */
        public void notifyPrinterMgrBusyStatus( boolean status );
    }
}
