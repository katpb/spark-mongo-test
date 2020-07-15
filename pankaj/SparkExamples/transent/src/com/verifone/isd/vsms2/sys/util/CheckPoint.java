/*
 * CheckPoint.java
 *
 * Created on March 17, 2004, 2:50 PM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Utility class to check point entry and exit of method calls and their frequency. Typically used as a debugging tool, this class can help identify black holes where methods never return back.
 * @author Bhanu_N2
 */
public class CheckPoint {
    
    /** Holds value of property name. */
    private String name;
    
    /** Holds value of property entryCount. */
    private long entryCount;
    
    /** Holds value of property exitCount. */
    private long exitCount;
    
    /**
     * Creates a new instance of CheckPoint
     * @param name name for the check point
     */
    public CheckPoint(String name) {
        this.setName(name);
    }
    
    /** Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.name;
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     *
     */
    public void setName(String name) {
        this.name = "CheckPoint_" +name;
    }
    
    /** Getter for property entryCount.
     * @return Value of property entryCount.
     *
     */
    public long getEntryCount() {
        return this.entryCount;
    }
    
    /** Setter for property entryCount.
     * @param entryCount New value of property entryCount.
     *
     */
    public void setEntryCount(long entryCount) {
        this.entryCount = entryCount;
    }
    
    /**
     * Increment entry count
     */
    public void incrEntryCount() {
        this.entryCount++;
    }
    
    /**
     * Increment exit count
     */
    public void incrExitCount() {
        this.exitCount++;
    }    
    
    /** Getter for property exitCount.
     * @return Value of property exitCount.
     *
     */
    public long getExitCount() {
        return this.exitCount;
    }
    
    /** Setter for property exitCount.
     * @param exitCount New value of property exitCount.
     *
     */
    public void setExitCount(long exitCount) {
        this.exitCount = exitCount;
    }
    
    /**
     * Implementation method to provide check point details as a readable string
     * @return string representation of the check point data
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.name);
        sb.append(" # in = ");
        sb.append(this.entryCount);
        sb.append(" # out = ");
        sb.append(this.exitCount);
        return sb.toString();
    }
}
