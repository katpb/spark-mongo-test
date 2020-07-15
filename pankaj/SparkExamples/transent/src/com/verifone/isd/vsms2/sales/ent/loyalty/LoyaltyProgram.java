/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created on Oct 21, 2010                                     jabbar_p1
*/

package com.verifone.isd.vsms2.sales.ent.loyalty;

import java.io.Serializable;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * This class acts as type safe enumerations for loyalty programs. It holds both program name 
 * and the corresponding gempro code.
 * 
 * @author jabbar_p1
 */
public final class LoyaltyProgram implements Serializable {
	private static final long serialVersionUID = 7820910646508631869L;
	private transient String programName;
	private transient int gemproProgramCode;
	private transient short precedence;
	private static int nextOrdinal = 0;
	private final int ordinal = nextOrdinal++; 
	
	
	public static LoyaltyProgram NONE = new LoyaltyProgram("NO_LOYALTY", 0);
	public static LoyaltyProgram EPS = new LoyaltyProgram("EPS_LOYALTY", 1);
	public static LoyaltyProgram VCMG = new LoyaltyProgram("VCMG", 2);
	public static LoyaltyProgram EXCENTUS = new LoyaltyProgram("EXCENTUS", 3);
	public static LoyaltyProgram PCATS01 = new LoyaltyProgram("PCATS01", 4);
	public static LoyaltyProgram PCATS02 = new LoyaltyProgram("PCATS02", 5);
	public static LoyaltyProgram PCATS03 = new LoyaltyProgram("PCATS03", 6);
	public static LoyaltyProgram PCATS04 = new LoyaltyProgram("PCATS04", 7);
	public static LoyaltyProgram ALL_PROGRAMS = new LoyaltyProgram("ALL_PROGRAMS", 8);
	
	private static final LoyaltyProgram [] values =  {NONE, EPS, VCMG, EXCENTUS, PCATS01, PCATS02, PCATS03, PCATS04, ALL_PROGRAMS };
	
	private LoyaltyProgram(String programName, int code) {
		this.programName = programName;
		gemproProgramCode = code;
		try {
			precedence = Short.parseShort(SysPropertyFactory.getProperty(programName));
		}catch(Exception e){
			precedence = 0;
		}
	}
	
	/**
	 * Returns the name of the program.
	 *  
	 * @return name of the program.
	 */
	public String getProgramName() {
		return programName;
	}
	
	/**
	 * Returns the precedence of the program.
	 *  
	 * @return precedence of the program.
	 */
	public short getPrecedence() {
		return precedence;
	}
	
	/**
	 * Returns the program code.
	 * 
	 * @return gempro code.
	 */
	public int getGemproProgramCode() {
		return gemproProgramCode;
	}
	
	/**
	 * Return LoyaltyProgram of corresponding ProgramID 
	 * Failure case will return NONE.
	 * @param programID
	 * @return LoyaltyProgram
	 */
	public static LoyaltyProgram getLoyaltyProgram(String programID){
		for (LoyaltyProgram value : values) {
			if(value.getProgramName().equalsIgnoreCase(programID)){
				return value;
			}
		}
		return NONE;
	}
	
	/**
	 * Return LoyaltyProgram of corresponding gemproProgramCode
	 * Failure case will return NONE.
	 * @param programCode
	 * @return
	 */
	public static LoyaltyProgram getLoyaltyProgram(int  gemproProgramCode){
		for (LoyaltyProgram value : values) {
			if(value.getGemproProgramCode() == gemproProgramCode){
				return value;
			}
		}
		return NONE;
	}
	
	public String toString(){
		return programName;
	}
	
	/** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
	Object readResolve() throws java.io.ObjectStreamException {
        return values[ordinal]; // Canonicalize
    }   
	
}
