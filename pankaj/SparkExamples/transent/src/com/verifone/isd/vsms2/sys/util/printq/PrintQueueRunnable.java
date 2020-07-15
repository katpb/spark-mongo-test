/*
 *  2010 Copyright Verifone, Inc. All Rights preserved.
 * 
 *  VERIFONE PROPRIETARY/CONFIDENTIAL
 * 
 *  Copying or distributing without the written consent of Verifone, Inc
 *  is not permitted.
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import com.verifone.isd.vsms2.sys.util.JposFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import java.util.LinkedList;
import jpos.JposConst;
import jpos.JposException;
import jpos.POSPrinterControl112;
import jpos.config.JposEntry;
import jpos.config.JposEntryRegistry;
import jpos.loader.JposServiceLoader;

/**
 *  This class processes queued print requests.
 *
 * @author Joe
 */
class PrintQueueRunnable extends Thread implements IPrintQueueStatus {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.printq.PrintQueueRunnable.class);
    /**
     * The queued collection of posted printer requests.
     */
    private LinkedList requests;

    /**
     * The control to the JPOS PRinter.
     */
    private POSPrinterControl112 thePrinter;

    /**
     * The number of attempts processing a failed print requests.
     * <p>
     * If this value $gt;= {@link #MAX_RETRIES}, the requests fails.
     */
    int retries = 0;

    /**
     * Number of attempts recovering from error events received when processing a print request.
     * <p>
     * If this value $gt;= {@link #MAX_ERROR_EVENT_RETRIES}, the requests fails.
     */
    int errorRetries = 0;

    /**
     * The listener for either OutputCompleteEvents, ErrorEvents, or
     * DirectIOEvents the the JPOS printer.
     */
    private PrinterOutputCompleteListener outputCompleteListener;

    /**
     * The listener for StatusUPdateEvents from the JPOS Printer.
     */
    private PrinterStatusUpdateListener printerStatusListener;

    /**
     * The number of retries to allow when JposExceptions are caught.
     * If this value is equal to zero, then no retries are attempted.
     */
    static final int MAX_RETRIES = 0;

    /**
     * The number of retries following the reception of an ErrorEvent
     * when waiting for an output complete event.
     * If this value is equal to zero, then no retries are attempted.
     */
    static final int MAX_ERROR_EVENT_RETRIES = 0;

    private boolean keepRunning = true;

    private static int constructorCallCount = 0;

    /**
     * Maximum jobs that can be queued.
     * <p>
     * The method {@link #addJob(IPrintRqst , Pjob)} will set the
     * {@link Pjob#status} to {@link Pjob#FAILED} if the job to be added
     * will exceed this value.
     *
     * @see #addJob(IPrintRqst, Pjob)
     */
    private int maxJobs;

    /**
     * Indicates when this queue manager is currently printing a request
     * (<code>true</code>) or is idle  - no requests pending (<code>false</code>).
     */
    private boolean busy = false;

    /**
     * Indicates that this runnable is exitting and no further job postings are allowed.
     */
    private boolean exitting = false;

    /**
     * Constructor with argument specifying maximum outstanding queued jobs.
     * <p>
     * The <i>thePrinter</i> argument must have the following properties set for
     * proper operation of print requests.
     * <ul>
     *   <li> deviceEnabled set to <code>true</code>.
     *   <li> powerNotify set to <code>JposConst.JPOS_PN_ENABLE</code>.
     * </ul>
     * These properties will be set by the
     * <b><code>com.verifone.isd.topaz.sys.app.printer.PrinterMonitor</code></b>.
     * That monitor is instantiated at application startup.
     * <p>
     * This class will only be created when a print job request is posted
     * by {@link PrinterMgr#addJob(IPrintRqst, Pjob)}.
     * <p>
     * The reason for this is that we cannot have two separate threads trying
     * to configure the printer because of the potential that a JposException
     * will be thrown if the powerNotify property is modified when the
     * deviceEnabled property is true.
     * <p>
     * For all developers, please consider this notice and do trust that the
     * PrinterMonitor will set the printer correctly!
     * <p>
     * The following properties will bet set as described and will not cause a
     * JposException to be thrown when being set but may cause unexpected
     * behaviors if code design assumes that they are or will be set to other
     * values.
     * <ul>
     *   <li> asyncMode set to <code>true</code>.
     *   <li> freezeEvents set to <code>false</code>.
     * </ul>
     *
     * @param maxJobs The maximum outstanding queued jobs permitted.
     * @param thePrinter The JPOS printer control this manager is to use.
     * @throws JposException Thrown on any errors calling the printer's methods.
     */
    PrintQueueRunnable(POSPrinterControl112 thePrinter, int maxJobs)
            throws JposException
    {
        int myInstanceCount = 0;
        synchronized(PrintQueueRunnable.class)
        {
            myInstanceCount = constructorCallCount++;
        }

        JposEntryRegistry jer = JposServiceLoader.getManager().getEntryRegistry();
        JposEntry anEntry = jer.getJposEntry( PrinterMgr.DEFAULT_RECEIPT_LOGICALNAME );
        if (anEntry != null)
        {
            JposEntry.Prop aProp = anEntry.getProp( "debugFlags" );
            if (aProp != null)
            {
                String debugFlagsValue = aProp.getValueAsString();
                try {
                    PrinterMgr.setDebugFlags(Integer.parseInt( debugFlagsValue ));
                } catch (Throwable t) { }
            }

            StringBuffer sb = new StringBuffer();
            sb.append(anEntry.getLogicalName());
            sb.append(String.valueOf(myInstanceCount));
            super.setName(sb.toString());  // Give the thread a name
        }

        requests = new LinkedList();
        this.maxJobs = maxJobs;
        this.thePrinter = thePrinter;

        if (!thePrinter.getDeviceEnabled())
        {
            logger.warn(
                    "PrintQueueRunnable(): Printer's deviceEnabled is not set to true");
        }

        if ((thePrinter.getCapPowerReporting() != JposConst.JPOS_PR_NONE)
            && (thePrinter.getPowerNotify() != JposConst.JPOS_PN_ENABLED))
        {
            logger.warn(
                    "PrintQueueRunnable(): Printer's powerNotify is not enabled");
        }

        if (!thePrinter.getAsyncMode())
        {
            logger.warn(
                    "PrintQueueRunnable(): Printer's asyncMode is false; setting it to true.");
            thePrinter.setAsyncMode(true);
        }

        if (thePrinter.getFreezeEvents())
        {
            logger.warn(
                    "PrintQueueRunnable(): Printer's freezeEvents is true; setting it to false.");
            thePrinter.setFreezeEvents(false);
        }

        outputCompleteListener = new PrinterOutputCompleteListener(this);
        thePrinter.addOutputCompleteListener(outputCompleteListener);
        thePrinter.addDirectIOListener(outputCompleteListener);
        thePrinter.addErrorListener(outputCompleteListener);

        printerStatusListener = new PrinterStatusUpdateListener(thePrinter, this);
        thePrinter.addStatusUpdateListener(printerStatusListener);

    }

    /**
     * Constructor whose default maximum outstanding queued jobs is
     * {@link PrinterMgr#MAX_PJOBS}.
     * <p>
     * NOTICE: Please see the discussion at
     * {@link PrintQueueRunnable#PrintQueueRunnable(jpos.POSPrinterControl112, int)}
     * about how the printer is configured before calling
     * any constructors of this class.
     *
     * @param thePrinter The JPOS printer control this manager is to use.
     *
     * @throws JposException Thrown on any errors calling the printer's methods.
     */
    PrintQueueRunnable(POSPrinterControl112 thePrinter)
            throws JposException
    {
        this(thePrinter, PrinterMgr.MAX_PJOBS);
    }

    /**
     * Constructor whose default maximum outstanding queued jobs is
     * {@link PrinterMgr#MAX_PJOBS} and uses the printer referenced by
     * {@link PrinterMgr#DEFAULT_RECEIPT_LOGICALNAME}.
     * <p>
     * NOTICE: Please see the discussion at
     * {@link PrintQueueRunnable#PrintQueueRunnable(jpos.POSPrinterControl112, int)}
     * about how the printer is configured before calling
     * any constructors of this class.
     *
     * @throws JposException Thrown on any errors instantiating the printer
     *                       or calling its methods.
     */
    PrintQueueRunnable()
            throws JposException
    {
        this((POSPrinterControl112) JposFactory.getInstance(PrinterMgr.DEFAULT_RECEIPT_LOGICALNAME),
                PrinterMgr.MAX_PJOBS);
    }

    /**
     * The runnable entry point that will consume posted print requests.
     */
    public void run()
    {
        boolean	fail = false;

        int oldOutputID = -1;
        while(isKeepRunning())
        {
			fail = false;

            Pjob aJob = null;
            PrintQueueRunnable.PrinterJob pJobcb = null;
            try {
                pJobcb = getNextJob();
                if (pJobcb == null)
                {
                    continue;
                }

                aJob = pJobcb.job;

                try {
                    retries = 0;
                    errorRetries = 0;
                    oldOutputID = thePrinter.getOutputID();
                    if ((PrinterMgr.debugFlags & JposFactory.DEBUG_FLAG_PRINT_MGR) != 0)
                    {
                        logger.debug(
                            "PrintQueueRunnable: Running job id:" + oldOutputID + ", count = " + getJobCount());
                    }

                    aJob.stime =
                        System.currentTimeMillis();
                } catch (JposException jpe) {
                    aJob.status = -1;	// flag failure
                    aJob.jpx = jpe;	// Give caller ref to exception
                    fail = true;
                }

                while(!fail && isKeepRunning())
                {
                    try
                    {
                        printerStatusListener.waitForOnline(-1); // Wait for printer to come online

                        if (!isKeepRunning())
                        {
                            fail = true;
                            break;
                        }

                        outputCompleteListener.clear();
                        oldOutputID = thePrinter.getOutputID();
                        pJobcb.getRequest().execute(); 		// HOOK into command pattern

//                        try
//                        {
//                            Thread.sleep(250);
//                        } catch (InterruptedException iex) { }

                        int newOutputID = thePrinter.getOutputID();

                        // If previous and next output IDs are the same, then
                        // there will NOT be an output complete event.
                        // This might happen the job only does a directIO call
                        // to the printer.
                        if (oldOutputID != newOutputID)
                        {
                            outputCompleteListener.waitForOutputIDToComplete(newOutputID);
                        }

                        if (!isKeepRunning())
                        {
                            fail = true;
                            break;
                        }

                        if (outputCompleteListener.errorCode != 0)
                        {
                            throw new JposException(outputCompleteListener.errorCode,
                                                    outputCompleteListener.errorExtend,
                                                    thePrinter.getErrorString());
                        } else {
                            // Successful job was printed - exit retry loop.
                            break;
                        }

                    } catch (JposException jpe) {
                        ++retries;
                        if (retries >= MAX_RETRIES)
                        {
                            logger.error( "PrintQueueRunnable: JPOS FAILURE Max retries reached!");
                            aJob.status = -1;	// flag failure
                            aJob.jpx = jpe;	// Give caller ref to exception
                            fail = true;
                        } else
                        {
                            logger.debug( "PrintQueueRunnable: JPOS FAILURE Detected! Attempting Retry # " + retries);
                            continue;
                        }
                    } catch (Throwable e)
                    {
                        logger.error( "PrintQueueRunnable: ", e);

                        aJob.jpx = new JposException(JposConst.JPOS_E_FAILURE,
                            "General exception caught while excecuting Pjob! "
                            + e.getMessage());
                        aJob.status = -1;	// flag failure
                        fail = true;
                    }

                }

                aJob.etime = System.currentTimeMillis();

            } finally {

                outputCompleteListener.clear();

                if (!fail) {
                    /*
                     * Once print job completes make sure this
                     * transaction is updated with the final status
                     */

                    if (aJob != null)
                    {
                        aJob.status = 0;
                        aJob.jpx = null;	// Indicate no exceptions exist
                    }
                }

                if ((PrinterMgr.debugFlags & JposFactory.DEBUG_FLAG_PRINT_MGR) != 0)
                {
                    logger.debug(
                        "PrintQueueRunnable: Finished last PJob, count = " + getJobCount());
                }

                if (aJob != null)
                {
                    aJob.sendNotify();
                }
            }

        }   // End of while(keepRunning) block

        // Perform clean up; we're exitting...
        thePrinter.removeOutputCompleteListener(outputCompleteListener);
        thePrinter.removeErrorListener(outputCompleteListener);
        thePrinter.removeDirectIOListener(outputCompleteListener);
        thePrinter.removeStatusUpdateListener(printerStatusListener);

        outputCompleteListener.signal();
        printerStatusListener.signal();

        // Following local and synchronized block is to keep Coverity "Happy"
        boolean wipeQueue = false;
        synchronized(this)
        {
            wipeQueue = !keepRunning;
            exitting = true;
        }

        // If runnnable is instructed (via stopRunning()) to exit, throw away any queued jobs
        // and notify each job that it failed.
        if (wipeQueue)
        {
            PrintQueueRunnable.PrinterJob[] theJobs = new PrintQueueRunnable.PrinterJob[0];
            synchronized(this)
            {
                theJobs = (PrintQueueRunnable.PrinterJob[]) requests.toArray(theJobs);
                requests.clear();
            }

            for (int i = 0; i < theJobs.length; i++)
            {
                PrinterJob printerJob = theJobs[i];
                theJobs[i] = null;
                printerJob.getJob().status = Pjob.FAILED;
                printerJob.getJob().sendNotify();
            }
        }
    }

    /**
     * Add a print request to the queue.
     * <p>
     * If the posting of this request to the queue would cause the number
     * of outstanding request to exceed {@link #maxJobs}, then
     * {@link Pjob#status} is set to {@link Pjob#FAILED} and the method
     * immediately returns.
     *
     * @param request The implementation whose method
     *                {@link IPrintRqst#execute()} will be called when consumed
     *                by the <code>run()</code> method.
     * @param job The job manager for this request.
     */
    public void addJob(IPrintRqst request, Pjob job)
    {
        PrintQueueRunnable.PrinterJob aJob =
                new PrintQueueRunnable.PrinterJob(request, job);

        boolean failure = true;
        int jobCount = 0;
        synchronized(this)
        {
            if ((requests.size() < maxJobs) && keepRunning && !exitting)
            {
                setBusy(true);
                job.status = Pjob.QUEUED;
                requests.addLast(aJob);
                failure = false;
                notifyAll();
            }

            jobCount = requests.size();
        }

        if (failure)
        {
            StringBuffer sb = new StringBuffer();
            sb.append("PrintQueueRunnable.addJob(): Print queue full! ");
			sb.append( String.valueOf(jobCount));
            logger.error( sb.toString());
			job.status = Pjob.FAILED;
            job.sendNotify();
        }
    }

    /**
     * Get the next request in the queue.
     * @return The next request. <code>null</code> if no more jobs.
     */
    PrintQueueRunnable.PrinterJob getNextJob()
    {
        PrintQueueRunnable.PrinterJob pJobcb = null;

        synchronized(this)
        {
            while(keepRunning && requests.isEmpty())
            {
                setBusy(false);
                try
                {
                    wait();
                } catch(Exception e) { }
            }

            if (keepRunning && !requests.isEmpty())
            {
                pJobcb = (PrintQueueRunnable.PrinterJob) requests.removeFirst();
            }
        }

        return pJobcb;

    }

    /**
     * Get whether this runnable is to keep running.
     * @return <code>true</code> if this runnable is to keep running.
     *         <code>false</code> if this runnable is notified to stop.
     */
    public boolean isKeepRunning()
    {
        boolean retVal = false;
        synchronized(this)
        {
            retVal = keepRunning;
        }

        return retVal;
    }

    /**
     * Get whether a request is being printer or queue is idle.
     * @return <code>true</code> if a request is being printed or
     *         <code>false</code> if idle - no requests pending.
     */
    public boolean isBusy()
    {
        return busy;
    }

    /**
     * Set whether a request is being printer or no requests are pending.
     * @param busy <code>true</code> if a request is being printed or
     *         <code>false</code> if idle - no requests pending.
     */
    protected void setBusy(boolean busy)
    {
        if (this.busy != busy)
        {
            boolean newBusy = busy;
            this.busy = busy;
            PrinterMgr.notifyStatusListeners(newBusy);
        }
    }

    /**
     * Instruct this runnable to exit.
     * @todo Signal listeners about the ending of this runnable
     */
    public void stopRunning()
    {
        synchronized(this)
        {
            keepRunning = false;
            notifyAll();
        }

        outputCompleteListener.signal();
        printerStatusListener.signal();
    }

    /**
     * Get number of jobs enqueued
     * @return The number of elements in {@link #requests}.
     */
    public synchronized int getJobCount()
    {
        return requests.size();
    }

    /**
     * Determine if queue is empty.
     * @return <code>true</code> if there are no requests pending.
     */
    public synchronized boolean isEmpty()
    {
        return !keepRunning || requests.isEmpty();
    }

    /**
     * Get the error retry counter value.
     * @return the errorRetries
     */
    public int getErrorRetries()
    {
        return errorRetries;
    }

    /**
     * Get the error retry counter value.
     * @return the errorRetries
     */
    public int nextErrorRetry()
    {
        return ++errorRetries;
    }

    /**
     * @return the retries
     */
    public int getRetries()
    {
        return retries;
    }

    /**
     * Object managed by the {@link PrintQueueRunnable#requests
     *                       request queue container}.
     */
    protected class PrinterJob
    {
        private IPrintRqst request;
        private Pjob job;

        /**
         * Default Constructor.
         * @param request The print request handler.
         * @param job The job status entity object.
         */
        public PrinterJob(IPrintRqst request, Pjob job)
        {
            this.request = request;
            this.job = job;
        }

        /**
         * Get the print request handler.
         * @return An implementation of the handler.
         */
        public IPrintRqst getRequest()
        {
            return this.request;
        }

        /**
         * Get the job status entity object.
         * @return Entity user uses with associated request handler.
         */
        public Pjob getJob()
        {
            return this.job;
        }
    }
}
