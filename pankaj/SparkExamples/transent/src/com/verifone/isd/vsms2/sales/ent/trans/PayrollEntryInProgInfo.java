/*
 * ClockInEntryInfo.java
 *
 * Created on August 12, 2005, 2:30 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.ent.payroll.JobCode;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author  bhanu_n2
 */
public class PayrollEntryInProgInfo extends PayrollEntryInfo {
    static final long serialVersionUID = 5918884892551503728L;
    /**
     * Holds value of property beginTime.
     */
    private Date beginTime;
    private ArrayList completedSessions;
    
    /** Creates a new instance of ClockInEntryInfo */
    public PayrollEntryInProgInfo() {
        this.completedSessions = new ArrayList();
    }
    
    /**
     * Getter for property beginTime.
     * @return Value of property beginTime.
     */
    public Date getBeginTime() {
        return this.beginTime;
    }
    
    /**
     * Setter for property beginTime.
     * @param beginTime New value of property beginTime.
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public void addCompletedSession(ClockSession session) {
        this.completedSessions.add(session);
    }
    
    public ClockSession[] getCompletedSessions() {
        return (ClockSession[])this.completedSessions.toArray(new ClockSession[0]);
    }
}
