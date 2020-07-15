/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Generic exception that is used to inform clients of invalid method parameters passed.
 * @author bhanu_n2
 */
public class InvalidParamException extends Exception {
    /** Creates a new instance of InvalidParamException */
    public InvalidParamException() {
        super();
    }
    
    /**
     * Creates a new instance of InvalidParamException
     * @param message error message
     */
    public InvalidParamException(String message) {
        super(message);
    }
}
