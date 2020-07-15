/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha
 * Created October 2, 2003                                    David C. Brown
 *
 * Create an interface that need only supply an execute method.  The method
 * is allowed to throw a JposException with the understanding that whoever
 * called it will be able to clean up.
 */

package com.verifone.isd.vsms2.sys.util.printq;

import jpos.JposException;

/**
 * Trivial interface to describe the printer command pattern.
 */

public interface IPrintRqst {
	public void execute() throws JposException;
}
