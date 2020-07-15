/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * The OperationType class provides an enumeration of the various possible
 * values for 'type' attribute of an Operation entity.
 * 
 * @author Sudesh_s1
 *  
 */
public class OperationType implements Serializable {

    static final long serialVersionUID = -7068475869212225862L;
    

    private String name;

    protected OperationType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    /**
     * Prevent subclasses from overriding Object.hashCode() to ensure the
     * following contract of typesafe enum: "All equal objects of the enumerated
     * type are also identical i.e., a.equals(b) iff a==b". Thus, it is enough
     * to do an == instead of the expensive Object.equals method
     * @return Value returned by super class's hashCode() method
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * Prevent subclasses from overriding Object.equals to ensure the following
     * contract of typesafe enum: "All equal objects of the enumerated type are
     * also identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an ==
     * instead of the expensive Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static OperationType PLU = new OperationType("plu");
    public static OperationType DEPT = new OperationType("dept");
    public static OperationType MOP = new OperationType("mop");
    public static OperationType PRODCODE = new OperationType("prodCode");
    public static OperationType DATE = new OperationType("date");
    public static OperationType DATE_TIME = new OperationType("dateTime");
    public static OperationType TIME = new OperationType("time");
    public static OperationType DAY_OF_WEEK = new OperationType("dayOfWeek");
    public static OperationType AMOUNT = new OperationType("amt");
    public static OperationType QUANTITY = new OperationType("qty");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final OperationType[] VALUES = { PLU, DEPT, MOP, PRODCODE, DATE,
            DATE_TIME, TIME, DAY_OF_WEEK, AMOUNT, QUANTITY };

    /**
     * Method to prevent duplicate constants from coexisting as a result of
     * deserialization (ensures that only a single object represents each enum
     * constant. This method is automatically invoked by the serialization
     * mechanism. Without this method, Object.equals() method would be more
     * involved and not a straightforward super.equals() which does just a ==
     * check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }

    /**
     * Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }

    /**
     * Method to get the NWPromptStateConstants object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return NWPromptStateConstants object representing the ordinal
     */
    public static final OperationType getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /**
     * Getter for all the NWPromptStateConstants objects
     * @return array of NWPromptStateConstantss
     */
    public static final OperationType[] getObjects() {
        OperationType[] codes = new OperationType[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }

    /**
     * Test method
     * @param args params to the test
     */
    public static void main(String[] args) {
        OperationType[] states = OperationType.getObjects();
        for (int i = 0; i < states.length; i++) {
            System.out.println("OperationType: " + states[i].getOrdinal()
                    + " name = " + states[i].toString());
        }
    }
}
