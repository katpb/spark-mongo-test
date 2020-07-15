package com.verifone.isd.vsms2.sys.ent.employee;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;

/**
 *  entity class for Employee
 *
 *  @author "mailto:ranga_rangarajan@hp.com"
 *  @version 1.0 Copyright(c) 2000-2001 Hewlett-Packard Company, All Rights Reserved
 */
public class Employee implements IEntityObject, ISystemEntityVisitable {
    static final long serialVersionUID = -7285675504120477638L;
    public static final int MAX_PASSWORD_SIZE = 20; 
    /*Changes for PETROCUST-553*/
    public static final int MAX_EMPLOYEES = 100;
    
    private EmployeePK ID;
    private String name;
    private String number;
    private SecurityLevel securityLevel;
    private String password;
    private boolean isCashier;
    private String langCode;
    
    /**
     * Default constructor...
     */
    public Employee() {
    }
    
    /**
     * Argument Constructor...
     * 
     * @param ID
     */
    public Employee(EmployeePK ID) {
    	this.ID = ID;
    }
    
    public String getName() {
        return (this.name == null) ? "" : this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNumber() {
        return (this.number == null) ? "" : this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public SecurityLevel getSecurityLevel() {
        return (this.securityLevel == null) ? SecurityLevel.LEVEL_0 : this.securityLevel;
    }
    
    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isCashier() {
        return this.isCashier;
    }
    
    public void setCashier(boolean isCashier) {
        this.isCashier = isCashier;
    }
    
    /**
     * @return Returns the langCode.
     */
    public String getLangCode() {
        return langCode;
    }
    /**
     * @param langCode The langCode to set.
     */
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid employee: " +this.ID);
        }
    }
    
    /*
    public void accept(DataSetXMLVisitor v) throws SAXException {
        v.visit(this);
    }
     **/
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        Employee eObj = (Employee) obj;
        eObj.setPK(this.getPK());
        eObj.setName(this.getName());
        eObj.setNumber(this.getNumber());
        eObj.setSecurityLevel(this.getSecurityLevel());
        eObj.setCashier(this.isCashier());
        eObj.setPassword(this.getPassword());
        eObj.setLangCode(this.getLangCode());
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (EmployeePK)pk;
    }
    
    public void accept(ISystemEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /**
     * Get the Employee SysID from EmployeePK.
     * 
     * @return
     */
    public int getEmployeeSysID() {
    	return this.ID.getValue();
    }
}
