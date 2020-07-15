package com.verifone.isd.vsms2.sales.ent.popdiscount;

import java.util.Date;

/**
 * Helper object for schedule by date
 */
 public class PopScheduleByDate implements IPopScheduleType
{    
    private Date startDate;
    private Date endDate;
    
    /**
     * No-args constructor
     * @throws Exception if object cannot be created
     */    
    public PopScheduleByDate() {
    }

    /**
     * Getter for startDate property
     * @return Start date
     */    
    public Date getStartDate()
    {
        return this.startDate;
    }
    
    /**
     * Setter for startDate property
     * @param start Start date
     */    
    public void setStartDate(Date start)
    {
        this.startDate = start;
    }
    
    /**
     * Getter for endDate property
     * @return End date
     */    
    public Date getEndDate()
    {
        return this.endDate;
    }
    
    /**
     * Setter for endDate property
     * @param end End date
     */    
    public void setEndDate(Date end)
    {
        this.endDate = end;
    }
}