package com.verifone.isd.vsms2.sales.ent.popdiscount;

/**
 * Helper object for schedule by day
 */
public class PopScheduleByDay implements IPopScheduleType
{    
    /**
     * Number of days in a week
     */    
    public static final int NUM_WEEKDAYS = 7;

    private boolean[] isWeekDayActive;
    
    /**
     * No-args constructor
     */    
    public PopScheduleByDay() {
        this.isWeekDayActive = new boolean[PopScheduleByDay.NUM_WEEKDAYS];
    }

    /**
     * Getter for isWeekdayActive property
     * @param weekDay Day of week
     * @return True if day is active
     */    
    public boolean isWeekDayActive(int weekDay) {
        return this.isWeekDayActive[weekDay - 1];
    }
    
    /**
     * Setter for isWeekdayActive property
     * @param weekDay Day of week
     * @param isTrue If true, activate day
     */    
    public void setWeekDayActive(int weekDay, boolean isTrue) {
        this.isWeekDayActive[weekDay - 1] = isTrue;
    }
}