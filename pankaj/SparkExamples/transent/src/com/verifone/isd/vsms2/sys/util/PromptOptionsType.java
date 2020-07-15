package com.verifone.isd.vsms2.sys.util;

import java.io.Serializable;


/**
 * Type-safe enumeration for Always, Never or Prompt option. It is currently 
 * being used to decide whether Customer Receipt Print is required and if 
 * required then whether we should Prompt the cashier before printing the 
 * Customer Copy.
 * 
 * ALWAYS  always perform the action
 * NEVER  never perform the action
 * PROMPT  prompt before performing the action
 * 
 * @author sunil_y1
 */
public class PromptOptionsType implements Serializable {    
    private static final long serialVersionUID = 4021687243680582408L;
    private transient String gemproValue;
    private transient String name;
    
    /**
     * Private Constructor
     * @param aName The options for receipt printing
     */
    private PromptOptionsType (String value, String aName) {
        gemproValue = value;
        name = aName;
    }
    
    /**
     * Returns the value that is used by Gempro to represent the option
     * selected for the property 
     * @return Abbreviation 'Y', 'N' or 'P'
     */
    public String getAbbreviation() {
        return this.gemproValue;
    }
    
    /**
     * Returns the full name of the option selected
     * @return
     */
    public String getOptionName() {
        return this.name;
    }
    
    /** 
     * Override toString() method to provide the receipt printing option name
     * @return The option 
     */    
    public String toString() {
        return "PromptOptionsType: " + this.name;
    }
    
    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    /** Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public static final PromptOptionsType NO = new PromptOptionsType("N", "NEVER");
    public static final PromptOptionsType YES =  new PromptOptionsType("Y", "ALWAYS");    
    public static final PromptOptionsType PROMPT =  new PromptOptionsType("P", "PROMPT");


    /// PRIVATE ////    
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //auto-incremented
    private static final PromptOptionsType[] fValues = {NO, YES, PROMPT};    

        
    /**
    * Parse text into an element of this enumeration. It can be used in
    * two ways. 
    * 1. By passing the String NEVER, ALWAYS and PROMPT. Used by Content Handler
    * 2. By passing the String N, Y and P. Used by Persist State
    *
    * @param takes one of the values 'N', 'Y' and 'P' or 'NEVER', 'ALWAYS' and 'PROMPT'.
    */
    public static PromptOptionsType valueOf(String aText){
      for (int i = 0; i < fValues.length; i++) {
          PromptOptionsType type = (PromptOptionsType)fValues[i];
          if ( aText.equals(type.getOptionName()) || aText.equals(type.getAbbreviation())){
              return type;
          }
      }
      throw new IllegalArgumentException(
        "Cannot be parsed into an enum element : '" + aText + "'"
      );
    }
    
    /** 
     * Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return fValues[ordinal]; // Canonicalize
    }     
    
    /** 
     * Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }   

    /** Getter for all the Receipt Print options
     * @return array of AlwaysNeverPromptType
     */    
    protected static PromptOptionsType[] getObjects() {
        PromptOptionsType[] options = new PromptOptionsType[fValues.length];
        System.arraycopy(fValues, 0, options, 0, fValues.length);
        return options;
    }
    
    /** Test method
     * @param args params to the test
     */    
    public static void main(String[] args) {
        PromptOptionsType[] values = PromptOptionsType.getObjects();
        for (int i = 0; i < values.length; i++) {
            System.out.println("Receipt Printing Options: " +values[i].getAbbreviation() +" name = " +values[i].getOptionName());
        }
    }
}
