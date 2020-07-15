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

/**
 * Interface of a print request queue manager used by
 * {@link PrinterOutputCompleteListener} and {@link PrinterStatusUpdateListener}.
 *
 * @see PrinterOutputCompleteListener#PrinterOutputCompleteListener(IPrintQueueStatus)
 * @see PrinterStatusUpdateListener#PrinterStatusUpdateListener(jpos.POSPrinterControl112, IPrintQueueStatus)
 */
interface IPrintQueueStatus {

    /**
     * Get the error retry counter value.
     * @return the errorRetries
     */
    int getErrorRetries();

    /**
     * Get number of jobs enqueued
     * @return The number of currently enqueued for printing.
     */
    int getJobCount();

    /**
     * Get the number of attempts processing a failed print requests.
     * @return the retries
     */
    int getRetries();

    /**
     * Get whether this runnable is to keep running.
     * @return <code>true</code> if this runnable is to keep running.
     * <code>false</code> if this runnable is notified to stop.
     */
    boolean isKeepRunning();

    /**
     * Get number of attempts recovering from error events received when
     * processing a print request.
     * @return the errorRetries
     */
    int nextErrorRetry();

}
