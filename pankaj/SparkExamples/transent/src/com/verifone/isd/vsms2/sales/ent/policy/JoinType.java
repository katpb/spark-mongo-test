/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * The JoinType class provides an enumeration of the various possible values for
 * 'joinType' attribute of a Condition.
 * 
 * @author Sudesh_s1
 *  
 */
public class JoinType implements Serializable {
    
    static final long serialVersionUID = -5150396876276360132L;

    private String name;

    protected JoinType(String name) {
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

    public static JoinType AND = new JoinType("AND");
    public static JoinType OR = new JoinType("OR");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final JoinType[] VALUES = { AND, OR };

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
    public static final JoinType getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /**
     * Getter for all the NWPromptStateConstants objects
     * @return array of NWPromptStateConstantss
     */
    public static final JoinType[] getObjects() {
        JoinType[] codes = new JoinType[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }

    /**
     * Test method
     * @param args params to the test
     */
    public static void main(String[] args) {
        JoinType[] states = JoinType.getObjects();
        for (int i = 0; i < states.length; i++) {
            System.out.println("JoinType: " + states[i].getOrdinal()
                    + " name = " + states[i].toString());
        }
    }
}
