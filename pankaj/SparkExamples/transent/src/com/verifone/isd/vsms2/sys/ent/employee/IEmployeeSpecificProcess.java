package com.verifone.isd.vsms2.sys.ent.employee;

/**
 * 
 *
 */
public interface IEmployeeSpecificProcess {
    public void setEmployee(Employee curEmployee);
    public void validateEmployee() throws Exception;
	
}
