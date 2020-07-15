/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 May, 2009                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sys.ent.report.grouplist;

/**
 * A PeriodReport entity represents an instance of 'reportNameML' element in
 * grouplist.xml
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class PeriodReport {

    private String name;
    private boolean period1;
    private boolean period2;
    private boolean period3;
    private boolean period4;

    /**
     * default constructor that assigns this report to all four periods.
     */
    public PeriodReport() {
	name = "";
    }

    /**
     * @param forPeriod1
     * @param forPeriod2
     * @param forPeriod3
     * @param forPeriod4
     */
    public PeriodReport(boolean period1, boolean period2,
            boolean period3, boolean period4) {
        super();
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.period4 = period4;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the period1
     */
    public boolean isPeriod1() {
        return period1;
    }

    /**
     * @param period1 the period1 to set
     */
    public void setPeriod1(boolean period1) {
        this.period1 = period1;
    }

    /**
     * @return the period2
     */
    public boolean isPeriod2() {
        return period2;
    }

    /**
     * @param period2 the period2 to set
     */
    public void setPeriod2(boolean period2) {
        this.period2 = period2;
    }

    /**
     * @return the period3
     */
    public boolean isPeriod3() {
        return period3;
    }

    /**
     * @param period3 the period3 to set
     */
    public void setPeriod3(boolean period3) {
        this.period3 = period3;
    }

    /**
     * @return the period4
     */
    public boolean isPeriod4() {
        return period4;
    }

    /**
     * @param period4 the period4 to set
     */
    public void setPeriod4(boolean period4) {
        this.period4 = period4;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof PeriodReport) {
            return this.name.equals(((PeriodReport) obj).name);
        }
        return false;
    }
   
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.name == null) ? 0 : this.name.hashCode());
    }
}
