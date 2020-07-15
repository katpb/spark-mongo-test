package com.verifone.isd.vsms2.sys.util;

/**
 * This interface is used to set a flag to ignore any exceptions at the time of backup or restore 
 *  
 * @author T_MadhusudhanB1
 *
 */
public interface IIgnoreExceptions {
	
	/**
	 * This method sets a flag to indicate backup is going on
	 */

	public void setIgnoreExceptions(boolean ignoreExecptions); 
}
