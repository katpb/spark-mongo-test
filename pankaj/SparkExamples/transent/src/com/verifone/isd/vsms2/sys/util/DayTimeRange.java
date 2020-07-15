/*
 * DayTimeRange.java
 *
 * Created on September 12, 2002, 10:03 AM
 */

package com.verifone.isd.vsms2.sys.util;

import java.io.Serializable;
/**
 * Utility class to represent time range within a day
 * @author  Bhanu_N2
 */
public class DayTimeRange implements Serializable {
	static final long serialVersionUID = 3573401048734666175L;
    private int startHour;
    private int startMinute;
    private int startSecond;
    private int endHour;
    private int endMinute;
    private int endSecond;

    /**
     * Constructor to provide the range with second granularity
     * @param startHour start hour
     * @param endHour end hour
     * @param startMinute start minute
     * @param endMinute end minute
     * @param startSecond start second
     * @param endSecond end second
     * @throws java.lang.Exception if any of the parameters is invalid
     */
    public DayTimeRange(int startHour, int endHour, int startMinute, int endMinute, int startSecond, int endSecond) throws Exception
    {
        if ((startHour < 0) || (startHour > 23) || (endHour < 0) || (endHour > 23) ||
            (startMinute < 0) || (startMinute > 59) || (endMinute < 0) || (endMinute > 59) ||
            (startSecond < 0) || (startSecond > 59) || (endSecond < 0) || (endSecond > 59))
        {
            throw new Exception ("Invalid value for hour, minute or second");
        }
        this.startHour = startHour;
        this.endHour = endHour;    
        this.startMinute = startMinute;
        this.endMinute = endMinute;    
        this.startSecond = startSecond;
        this.endSecond = endSecond;    
    }
    
    /**
     * Constructor to provide the range with minute granularity.
     * @param startHour start hour
     * @param endHour end hour
     * @param startMinute start minute
     * @param endMinute end minute
     * @throws java.lang.Exception if any of the parameters is invalid
     */
    public DayTimeRange(int startHour, int endHour, int startMinute, int endMinute) throws Exception
    {
        this(startHour, endHour, startMinute, endMinute, 0, 0);
    }

    /**
     * Constructor to provide the range with hour granularity.
     * @param startHour start hour
     * @param endHour end hour
     * @throws java.lang.Exception if any of the parameters is invalid
     */
    public DayTimeRange(int startHour, int endHour) throws Exception
    {
        this(startHour, endHour, 0, 0, 0, 0);
    }
    
    /**
     * No-args constructor
     */
    public DayTimeRange()
    {
    }
    
    /**
     * Getter for start hour of the range
     * @return start hour
     */
    public int getStartHour()
    {
        return this.startHour;
    }
    
    /**
     * Getter for start minute of the range
     * @return start minute
     */
    public int getStartMinute()
    {
        return this.startMinute;
    }
    
    /**
     * Getter for start second of the range
     * @return start second
     */
    public int getStartSecond()
    {
        return this.startSecond;
    }
    
    /**
     * Getter for end hour of the range
     * @return end hour
     */
    public int getEndHour()
    {
        return this.endHour;
    }
    
    /**
     * Getter for end minute of the range
     * @return end minute
     */
    public int getEndMinute()
    {
        return this.endMinute;
    }
    
    /**
     * Getter for end second of the range
     * @return end second
     */
    public int getEndSecond()
    {
        return this.endSecond;
    }
    
    /**
     * Setter for start hour of the range
     * @param startHour start hour
     * @throws java.lang.Exception on invalid parameter
     */
    public void setStartHour(int startHour) throws Exception
    {
        if ((startHour < 0) || (startHour > 23))
            throw new Exception ("Invalid start hour value");
        this.startHour = startHour;            
    }
    
    /**
     * Setter for start minute of the range
     * @param startMinute start minute
     * @throws java.lang.Exception on invalid parameter
     */
    public void setStartMinute(int startMinute) throws Exception
    {
        if ((startMinute < 0) || (startMinute > 59))
            throw new Exception ("Invalid start minute value");
        this.startMinute = startMinute;            
    }
    
    /**
     * Setter for start second of the range
     * @param startSecond start second
     * @throws java.lang.Exception on invalid parameter
     */
    public void setStartSecond(int startSecond) throws Exception
    {
        if ((startSecond < 0) || (startSecond > 59))
            throw new Exception ("Invalid start second value");
        this.startSecond = startSecond;            
    }
    
    /**
     * Setter for end hour of the range
     * @param endHour end hour
     * @throws java.lang.Exception on invalid parameter
     */
    public void setEndHour(int endHour) throws Exception
    {
        if ((endHour < 0) || (endHour > 23))
            throw new Exception ("Invalid end hour value");
            this.endHour = endHour;
    }
    
    /**
     * Setter for end minute of the range
     * @param endMinute end minute
     * @throws java.lang.Exception on invalid parameter
     */
    public void setEndMinute(int endMinute) throws Exception
    {
        if ((endMinute < 0) || (endMinute > 59))
            throw new Exception ("Invalid end minute value");
            this.endMinute = endMinute;
    }
    
    /**
     * Setter for end second of the range
     * @param endSecond end second
     * @throws java.lang.Exception on invalid parameter
     */
    public void setEndSecond(int endSecond) throws Exception
    {
        if ((endSecond < 0) || (endSecond > 59))
            throw new Exception ("Invalid end second value");
            this.endSecond = endSecond;
    }    
}
