package com.verifone.isd.vsms2.sys.util;

/**
 * This exception is thrown when a wrong department is assigned to any dataset   
 *  
 * @author T_MadhusudhanB1
 *
 */

public class InvalidItemException extends Exception {
	private static final long serialVersionUID = 634335652420661450L;

	public InvalidItemException() {
        super();
    }
    
	public InvalidItemException(String message){
		super(message);
		
	}
}
