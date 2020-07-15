/*
 * InvalidUPCCodeException.java
 *
 * Created on February 17, 2004, 1:27 PM
 */

package com.verifone.isd.vsms2.sys.util;

/** This exception will be thrown by the methods in ConvertUPC class if any of the
 * input strings do not meet the criteria of expected type.
 * @author Joe_H5
 */
public class InvalidUPCCodeException extends java.lang.Exception {
    
    /** Creates a new instance of InvalidUPCCodeException */
    public InvalidUPCCodeException() {
        super();
    }
    
    /**
     * Creates a new instance of InvalidUPCCodeException
     * @param message error message
     */
    public InvalidUPCCodeException(String message) {
        super(message);
    }
    
}
