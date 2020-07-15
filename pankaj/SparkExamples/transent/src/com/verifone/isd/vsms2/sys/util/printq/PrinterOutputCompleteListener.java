package com.verifone.isd.vsms2.sys.util.printq;

import com.verifone.isd.vsms2.sys.util.JposFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import jpos.events.DirectIOEvent;
import jpos.events.ErrorEvent;

/**
 * Listener class implementing output event listeners for JPOS printer service.
 */
class PrinterOutputCompleteListener implements jpos.events.OutputCompleteListener,
                                        jpos.events.DirectIOListener,
                                        jpos.events.ErrorListener
{

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrinterOutputCompleteListener.class);
    /**
     * Collection of outputIDs that have been printed by the printer service.
     */
    protected LinkedList outputIDs = new LinkedList();
    /**
     * Flag signifying the a DirectIOEvent notification from the
     * JPOS Printer service occurred.
     */
    protected boolean directIOEventOccured = false;
    /**
     * Flag signifying that an ErrorEvent notification from the
     * JPOS Printer service occurred.
     */
    protected boolean errorHappened = false;
    /**
     * Value set by the ErrorEvent notification.
     */
    protected int errorCode = 0;
    /**
     * Value set by the ErrorEvent notification.
     */
    protected int errorExtend = 0;

    /**
     * The queue thread this listener is listening for.
     */
    protected IPrintQueueStatus ptrQthrd;

    protected static final int MAX_OUTPUTIDS_IN_LIST = 10;

    /**
     * Default constructor.
     * @param ptrQthrd The PrinterQueueRunnable that &quot;owns&quot; this object.
     */
    PrinterOutputCompleteListener(IPrintQueueStatus ptrQthrd)
    {
        this.ptrQthrd = ptrQthrd;
    }

    public synchronized void outputCompleteOccurred(jpos.events.OutputCompleteEvent outputCompleteEvent)
    {
        //            logger.info("PrinterOutputCompleteListener: Completion for " + outputCompleteEvent.getOutputID());
        // Save output ID that was completed
        outputIDs.addLast(new Integer(outputCompleteEvent.getOutputID()));
        // If queue is full, discard oldest ID
        if (outputIDs.size() > MAX_OUTPUTIDS_IN_LIST)
        {
            try
            {
                outputIDs.removeFirst();
            } catch (NoSuchElementException nse)
            {
            }
        }
        notifyAll();
    }

    /**
     * Will wait for given output ID to complete or error.
     * <p>
     * This method &quot;waits forever&quot; until there is an
     * OutputCompleteEvent or an ErrorEvent dispatched from the service.
     * JPOS specifications say that the service <u>will</u> deliver one of
     * these events for services where asynchronous output is enabled.
     * @param outputID The  POSPrinter outputID to wait for.
     */
    public synchronized void waitForOutputIDToComplete(int outputID)
    {
        if ((PrinterMgr.debugFlags & JposFactory.DEBUG_FLAG_PRINT_MGR) != 0)
        {
            logger.debug(
                         "PrintQueueRunnable.PrintOutputCompleteListener: Waiting for OutputID: "
                         + outputID);
        }
        while (ptrQthrd.isKeepRunning())
        {
            if (errorHappened)
            {
                errorHappened = false;
                logger.debug(
                             "PrintQueueRunnable.PrintOutputCompleteListener: Error happened while waiting for OutputID: " + outputID);
                return;
            }
            errorCode = 0;
            errorExtend = 0;
            // If there are completion ID's in queue
            if (outputIDs.size() > 0)
            {
                Integer testID = new Integer(outputID);
                if (outputIDs.contains(testID))
                {
                    while(outputIDs.contains(testID))
                    {
                        outputIDs.remove(testID);
                    }
                    if ((PrinterMgr.debugFlags & JposFactory.DEBUG_FLAG_PRINT_MGR) != 0)
                    {
                        logger.debug(
                                     "PrintQueueRunnable.PrintOutputCompleteListener: Job completed for OutputID: "
                                     + outputID);
                    }
                    return;
                }
            }
            if (directIOEventOccured)
            {
                if ((PrinterMgr.debugFlags & JposFactory.DEBUG_FLAG_PRINT_MGR) != 0)
                {
                    logger.debug(
                                 "PrintQueueRunnable.PrintOutputCompleteListener: DirectIO Completed for outputID "
                                 + outputID);
                }
                directIOEventOccured = false;
                return;
            }
            try
            {
                //					wait(waitTime);
                wait();
            } catch (InterruptedException iex)
            {
            }
        }
    }

    public synchronized void directIOOccurred(DirectIOEvent directIOEvent)
    {
        directIOEventOccured = true;
        notifyAll();
    }

    /**
     * Reset any management flags for next notifications.
     */
    public synchronized void clear()
    {
        errorHappened = false;
        errorCode = 0;
        errorExtend = 0;
        directIOEventOccured = false;
    }

    public void errorOccurred(ErrorEvent e)
    {
        synchronized (this)
        {
            ptrQthrd.nextErrorRetry();
            if (ptrQthrd.getErrorRetries() >= PrintQueueRunnable.MAX_ERROR_EVENT_RETRIES)
            {
                errorHappened = true;
                errorCode = e.getErrorCode();
                errorExtend = e.getErrorCodeExtended();
                notifyAll();
            } else
            {
                // tell service that it can retry printing...
                e.setErrorResponse(jpos.JposConst.JPOS_ER_RETRY);
            }
        }
        int retries = 0;
        synchronized(this)
        {
            retries = ptrQthrd.getRetries();
            logger.debug(
                    "PrintOutputCompleteListener: PRINTER ERROR happened - "
                    + " errCode:" + e.getErrorCode()
                    + " errExt: " + e.getErrorCodeExtended()
                    + " reties:" + retries);
        }
    }

    /**
     * Synchronized call to notifyAll() method of this object.
     */
    public synchronized void signal()
    {
        outputIDs.clear();
        notifyAll();
    }
}
