/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha
 * Created February 21, 2003                                  David C. Brown
 *
 * Provide a simple way for printing to happen asynchronously, yet let the
 * application poll its status.  This way the application can track input
 * events even though it may not want to change its state until the print
 * job is done.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import jpos.JposException;

/**
 * Simple class to manage the Jpos printer job asynchronously.  A caller will
 * furnish this object and then the printer will update the status when the job
 * completes.
 *
 * @author	David C. Brown
 * @version 0.1
 */

public class Pjob {
	
	public static final int	QUEUED = 1;	/** Job still in print queue */
	public static final int DONE = 0; /** Job completed normally */
	public static final int FAILED = -1; /** Job failed, check JposException */

	/** Status = 0 is good, staus = -1 means the job failed. */

	public int	status = 0;

	/** If there was a JposException during printing here is its reference */

	public JposException	jpx = null;

	public long	stime = 0;	/** Time job was queued */
	public long etime = 0;	/** Time job completed or failed */

	/**
	 * Callback to let any threads that chose to wait on this object know
	 * the print job has completed or was otherwise ended.
	 *
	 */

	public synchronized void sendNotify() {
		notifyAll();
	}

	/**
	 * Threads that wish to block until the job completes can do so here.
	 *
	 * @return	int
	 */

	public synchronized int awaitJobEnd() throws InterruptedException {
		while (status > 0) {
			wait();
		}
		return status;
	}
}
