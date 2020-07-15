package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import java.util.Date;

/**
 * Value object to represent DB lookup data for period close
 */
public class CurrentPeriodInfo implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2388681718194788966L;

	/**
     * Holds value of property openedDate.
     */
    private Date openedDate;
    
    /**
     * Holds value of property beginTotalizer.
     */
    private long beginTotalizer;
    
    /**
     * Holds value of property endTotalizer.
     */
    private long endTotalizer;
    
    /**
     * Holds value of property periodSequence.
     */
    private int periodSequence;
    
    /**
     * Holds value of property name.
     */
    private String name;
        
    public CurrentPeriodInfo() {
    }
  
    
    /**
     * Getter for property openedDate.
     * @return Value of property openedDate.
     */
    public Date getOpenedDate() {
        return this.openedDate;
    }
    
    /**
     * Setter for property openedDate.
     * @param openedDate New value of property openedDate.
     */
    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
    }
    
    /**
     * Getter for property beginTotalizer.
     * @return Value of property beginTotalizer.
     */
    public long getBeginTotalizer() {
        return this.beginTotalizer;
    }
    
    /**
     * Setter for property beginTotalizer.
     * @param beginTotalizer New value of property beginTotalizer.
     */
    public void setBeginTotalizer(long beginTotalizer) {
        this.beginTotalizer = beginTotalizer;
    }
    
    /**
     * Getter for property endTotalizer.
     * @return Value of property endTotalizer.
     */
    public long getEndTotalizer() {
        return this.endTotalizer;
    }
    
    /**
     * Setter for property endTotalizer.
     * @param endTotalizer New value of property endTotalizer.
     */
    public void setEndTotalizer(long endTotalizer) {
        this.endTotalizer = endTotalizer;
    }
    
    /**
     * Getter for property periodSequence.
     * @return Value of property periodSequence.
     */
    public int getPeriodSequence() {
        return this.periodSequence;
    }
    
    /**
     * Setter for property periodSequence.
     * @param periodSequence New value of property periodSequence.
     */
    public void setPeriodSequence(int periodSequence) {
        this.periodSequence = periodSequence;
    }
    
    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getPeriodName() {
        return this.name;
    }
    
    /**
     * Setter for property name.
     * @param name New value of property name.
     */
    public void setPeriodName(String name) {
        this.name = name;
    }
}