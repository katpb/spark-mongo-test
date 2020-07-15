/*
 * ClockSession.java
 *
 * Created on August 16, 2005, 12:43 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.ent.payroll.JobCode;
import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author  bhanu_n2
 */
public class ClockSession implements Serializable {
    static final long serialVersionUID = 7225481829566647321L;
    /**
     * Holds value of property beginDate.
     */
    private Date beginDate;
    
    /**
     * Holds value of property endDate.
     */
    private Date endDate;
    
    /**
     * Holds value of property jobCode.
     */
    private JobCode jobCode;
    
    /** Creates a new instance of ClockSession */
    public ClockSession() {
    }
    
    /**
     * Getter for property beginDate.
     * @return Value of property beginDate.
     */
    public Date getBeginDate() {
        return this.beginDate;
    }
    
    /**
     * Setter for property beginDate.
     * @param beginDate New value of property beginDate.
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    /**
     * Getter for property endDate.
     * @return Value of property endDate.
     */
    public Date getEndDate() {
        return this.endDate;
    }
    
    /**
     * Setter for property endDate.
     * @param endDate New value of property endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /**
     * Getter for property jobCode.
     * @return Value of property jobCode.
     */
    public JobCode getJobCode() {
        return this.jobCode;
    }
    
    /**
     * Setter for property jobCode.
     * @param jobCode New value of property jobCode.
     */
    public void setJobCode(JobCode jobCode) {
        this.jobCode = jobCode;
    }
}
