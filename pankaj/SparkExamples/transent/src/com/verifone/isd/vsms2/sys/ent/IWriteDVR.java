/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz production version
 * Created April 2, 2004                                      David C. Brown
 *
 * Define an interface that exposes just the means to write to the DVR
 * so that other components won't add antecedents about Jpos, etc.
 */

package com.verifone.isd.vsms2.sys.ent;


/**
 * Provide an interface to the DVR device without making calling class keep
 * Jpos components as antecedants.  There is a factory method to return a
 * reference to an implementation of this interface.  All data should be
 * formatted as required and passed as an argument, where it will be copied
 * directly to the output port.
 *
 * Methods support return values to describe the status of the operation.  The
 * are two variations of the write method -- immediate and placed in a queue
 * with possibly several others awaiting output.  <B>NOTE</B> there is no
 * guarantee that the implementation will honor the request!
 *
 * @author	David C. Brown
 * @version	1.0
 * @since	beta
 */

public interface IWriteDVR {

	/** STATUS: request could not be completed */

	public static final int	DVR_FAIL = -1;

	/** STATUS: request is in FIFO queue */

	public static final int	DVR_QUEUED = 0;

	/** STATUS: request has been output to device */

	public static final int	DVR_DONE = 1;

	/** Allow the request to queue (FIFO) with others */

	public static final int	DVR_MODE_QUEUE = 0;

	/** Attempt to display the request immediately */

	public static final int	DVR_MODE_IMMEDIATE = 1;

	/**
	 * Prints the formatted string to the DVR port.  Status returned.
	 * Rather than force appliations to know about Jpos the more generic
	 * Exception class is thrown.
	 *
	 * @param		dvrtxt Text to write to device.
	 * @return		int One of <code>DVR_FAIL, DVR_QUEUED, or DVR_DONE</code> constants returned.
	 * @exception	Exception  Thrown on any errors writing to device.
	 */

	public int writeDVR(String dvrtxt) throws Exception;

	/**
	 * Specify whether to queue the output or print immediately to
	 * the DVR facility.  Rather than force appliations to know about
	 * Jpos the more generic Exception class is thrown.
	 *
	 * @param		queueMode One of <code>DVR_MODE_QUEUE or DVR_MODE_IMMEDIATE</code> should be specified.
	 * @param		dvrtxt Text to write to device.
	 * @return		int One of <code>DVR_FAIL, DVR_QUEUED, or DVR_DONE</code> constants returned.
	 * @exception	Exception  Thrown on any errors writing to device.
	 */

	public int writeDVR(int queueMode, String dvrtxt) throws Exception;
}
