/*
 * PayrollEntryInfo.java
 *
 * Created on August 12, 2005, 1:26 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.ent.payroll.JobCode;
import java.io.Serializable;

/**
 * Value object to validate/ provide details for Payroll functions on Topaz
 * @author  bhanu_n2
 */
public class PayrollEntryInfo implements Serializable {
    static final long serialVersionUID = 7225481829566647321L;
    /**
     * Holds value of property employeeId.
     */
    private String employeeId;
    
    /**
     * Holds value of property operation.
     */
    private TransactionType operation;
    
    /**
     * Holds value of property jobCode.
     */
    private JobCode jobCode;
    
    /** Creates a new instance of PayrollEntryInfo */
    public PayrollEntryInfo() {
    }
    
    /**
     * Getter for property employeeId.
     * @return Value of property employeeId.
     */
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    /**
     * Setter for property employeeId.
     * @param employeeId New value of property employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * Getter for property operation.
     * @return Value of property operation.
     */
    public TransactionType getOperation() {
        return this.operation;
    }
    
    /**
     * Setter for property operation.
     * @param operation New value of property operation.
     */
    public void setOperation(TransactionType operation) {
        this.operation = operation;
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
