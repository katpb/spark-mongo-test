/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 * The OperatorType class provides an enumeration of the various possible values
 * for 'operator' attribute of an Operation entity.
 * 
 * @author Sudesh_s1
 *  
 */
public class OperatorType implements Serializable {
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.policy.OperatorType.class);
    
	private static final long serialVersionUID = 3933651037497134328L;


    private String name;

    protected OperatorType(String name) {
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

    public static OperatorType EQUAL_TO = new OperatorType("equal to");
    public static OperatorType GREATER_THAN = new OperatorType("greater than");
    public static OperatorType GREATER_THAN_OR_EQUAL_TO = new OperatorType(
            "greater than or equal to");
    public static OperatorType LESS_THAN = new OperatorType("less than");
    public static OperatorType LESS_THAN_OR_EQUAL_TO = new OperatorType(
            "less than or equal to");
    public static OperatorType BETWEEN = new OperatorType("between");
    public static OperatorType LIKE = new OperatorType("like");
    public static OperatorType NOT_EQUAL_TO = new OperatorType("not equal to");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final OperatorType[] VALUES = { EQUAL_TO, GREATER_THAN,
            GREATER_THAN_OR_EQUAL_TO, LESS_THAN, LESS_THAN_OR_EQUAL_TO,
            BETWEEN, LIKE, NOT_EQUAL_TO };

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
    public static final OperatorType getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /**
     * This method is to get the OperatorType object by providing the name of OperatorType.
     * @param name
     * @return OperatorType for the given name.
     */
    public static OperatorType getObjectByName(String name) {
	OperatorType[] types = OperatorType.getObjects();
	OperatorType reqdType = null;
        for (int i = 0; i < types.length; i++) {
            if (types[i].name.equals(name)) {
        	reqdType = types[i];
                break;
            }
        }
        if (reqdType == null)
		LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.policy.OperatorType.class).error("OperatorType:getObjectByName invalid Operator type: "+ name);
        return reqdType;
    }
    
    /**
     * Getter for all the NWPromptStateConstants objects
     * @return array of NWPromptStateConstantss
     */
    public static final OperatorType[] getObjects() {
        OperatorType[] codes = new OperatorType[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }

    /**
     * Test method
     * @param args params to the test
     */
    public static void main(String[] args) {
        OperatorType[] states = OperatorType.getObjects();
        for (int i = 0; i < states.length; i++) {
            System.out.println("OperatorType: " + states[i].getOrdinal()
                    + " name = " + states[i].toString());
        }
    }
}
