/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 13 Mar, 2007                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Type-safe enumeration of menu types available in the system
 */
public class ExpandedMenuType {

    private static final int SINGLE_ROWS = 8;
    private static final int SINGLE_COLS = 4;
    private static final int DBL_HIGH_ROWS = 4;
    private static final int DBL_HIGH_COLS = 4;
    private static final int DBL_WIDE_ROWS = 8;
    private static final int DBL_WIDE_COLS = 2;
    private static final int QUAD_ROWS = 4;
    private static final int QUAD_COLS = 2;

    private String name;
    private int numRows;
    private int numCols;

    /**
     * Private constructor - do not allow subclassing
     * @param name menu type's name
     * @param maxItems maximum number of items allowed for this menu type
     */
    private ExpandedMenuType(String name, int numRows, int numCols) {
        this.name = name;
        this.numRows = numRows;
        this.numCols = numCols;
    }

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * @return the numCols
     */
    public int getNumCols() {
        return numCols;
    }

    /**
     * @return the name of this menu type
     */
    public String getName() {
		return name;
    }

    /**
     * Not required since constructor is private. Just in case.. Prevent
     * subclasses from overriding Object.hashCode() to ensure the following
     * contract of typesafe enum: "All equal objects of the enumerated type are
     * also identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an
     * == instead of the expensive Object.equals method
     * @return Value returned by super class's hashCode() method
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * Not required since constructor is private. Just in case.. Prevent
     * subclasses from overriding Object.equals to ensure the following contract
     * of typesafe enum: "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an ==
     * instead of the expensive Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static ExpandedMenuType SINGLE = new ExpandedMenuType("SINGLE",
            SINGLE_ROWS, SINGLE_COLS);
    public static ExpandedMenuType DOUBLE_HIGH = new ExpandedMenuType(
            "DBL_HIGH", DBL_HIGH_ROWS, DBL_HIGH_COLS);
    public static ExpandedMenuType DOUBLE_WIDE = new ExpandedMenuType(
            "DBL_WIDE", DBL_WIDE_ROWS, DBL_WIDE_COLS);
    public static ExpandedMenuType QUAD = new ExpandedMenuType("QUAD",
            QUAD_ROWS, QUAD_COLS);

    private static final ExpandedMenuType[] VALUES = { SINGLE, DOUBLE_HIGH,
            DOUBLE_WIDE, QUAD };

    /**
     * @param name - name of the expanded menu type
     * @return instance of ExpandedMenuType with given name if exists or ExpandedMenuType.DOUBLE_HIGH if such type doesn't exists
     */
    public static ExpandedMenuType getInstance(String name){
    	if( name != null ) {
    		for (int i = 0; i < VALUES.length; i++) {
    			if( VALUES[i].getName().equals(name) )
    				return VALUES[i];
    		}
    	}
    	return ExpandedMenuType.DOUBLE_HIGH;
    }
}
