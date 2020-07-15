/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * The ActionType class provides an enumeration of the various possible values
 * for 'type' attribute of an Action entity.
 * 
 * @author Sudesh_s1
 *  
 */
public class ActionType implements Serializable {
    private static final long serialVersionUID = 3078166767768304306L;

    private String name;

    protected ActionType(String name) {
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

    public static ActionType ALERT_CASHIER = new ActionType("alertCashier");
    public static ActionType APPLY_BLUE_LAW = new ActionType("applyBlueLaw");
    public static ActionType ID_CHECK = new ActionType("idCheck");
    public static ActionType JOURNAL_EVENT = new ActionType("journalEvent");
    public static ActionType VETO = new ActionType("veto");
    public static ActionType KITCHEN_PRINT = new ActionType("kitchenPrint");
    public static ActionType KIOSK = new ActionType("kiosk");
    public static ActionType FOOD_SERVICE = new ActionType("foodService");
    public static ActionType ADD_ITEM = new ActionType("addItem");
    public static ActionType RECEIPTMSG = new ActionType("receiptMsg");
    public static ActionType SECURITY_LEVEL = new ActionType("securityLevel");
    public static ActionType RECEIPTHDR = new ActionType("receiptHdr");
    public static ActionType RESTRICT_DEPT = new ActionType("restrictDept");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final ActionType[] VALUES = { ALERT_CASHIER, APPLY_BLUE_LAW,
             ID_CHECK, JOURNAL_EVENT, VETO, KITCHEN_PRINT ,KIOSK,FOOD_SERVICE,
             ADD_ITEM, RECEIPTMSG, SECURITY_LEVEL, RECEIPTHDR, RESTRICT_DEPT};

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
    public static final ActionType getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /**
     * Getter for all the NWPromptStateConstants objects
     * @return array of NWPromptStateConstantss
     */
    public static final ActionType[] getObjects() {
        ActionType[] codes = new ActionType[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }
}
