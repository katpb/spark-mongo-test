package com.verifone.isd.vsms2.sales.ent.cwcfg;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.DisplayOrderType;

/**
 *  entity class for CarWashConfig
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public class CarWashConfig implements IEntityObject, ISalesEntityVisitable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5055614314489500430L;
	
    /**
     * Minimum number of days a car wash code may be valid
     */    
    public static final int MIN_DAYS_VALID = 0;
    /**
     * Maximum number of days a car wash code may be valid
     */    
    public static final int MAX_DAYS_VALID = 99;
    private static final String EMPTY_PLU = new PluPK("").getValue();
    
    private CarWashConfigPK ID;
    private boolean isEnabled;
    private DepartmentPK department;
    private boolean isPromptBefore;
    private boolean isPromptAfter;
    private boolean isMenuPresentation;
    private DisplayOrderType displayOrder;
    private int daysValid;
    private boolean isRyko;

    private Map<Integer, CarWashKey> keys;
                   
    /**
     * Constructor
     */    
    public CarWashConfig() {
        this.keys = new LinkedHashMap<Integer, CarWashKey>();
    }

    /**
     * Method to validate the primary key
     * @return true if PK is valid
     */    
    public boolean isPKValid() {
        if (this.ID == null) {
            this.ID = new CarWashConfigPK();
        }
        return this.ID.isValid();
    }
    
    /**
     * Getter for the primary key
     * @return primary key object
     */    
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /**
     * Setter for the primary key
     * @param pk primary key object
     */    
    public void setPK(IEntityPK pk) {
        this.ID = (CarWashConfigPK)pk;
    }
    
    /**
     * Getter for car wash enable status
     * @return true, if car wash is enabled
     */    
    public boolean isEnabled() {
        return this.isEnabled;
    }
    
    /**
     * Setter for car wash enabled status
     * @param isTrue if true, enable car wash support
     */    
    public void setEnabled(boolean isTrue) {
        this.isEnabled = isTrue;
    }

    /**
     * Getter for car wash department property
     * @return department object for car wash
     */    
    public DepartmentPK getDepartment() {
        return this.department;
    }
    
    /**
     * Setter for car wash department property
     * @param setting DepartmentPK object
     */    
    public void setDepartment(DepartmentPK setting) {
        this.department = setting;
    }
    
    /**
     * Getter for promptBefore property
     * @return if true, prompt for car wash before fueling
     */    
    public boolean isPromptBefore() {
        return this.isPromptBefore;
    }
    
    /**
     * Setter for promptBefore property
     * @param isTrue if true, prompt for car wash before fueling
     */    
    public void setPromptBefore(boolean isTrue) {
        this.isPromptBefore = isTrue;
    }

    /**
     * Getter for promptAfter property
     * @return if true, prompt for car wash after fueling
     */    
    public boolean isPromptAfter() {
        return this.isPromptAfter;
    }
    
    /**
     * Setter for promptAfter property
     * @param isTrue if true, prompt for car wash after fueling
     */    
    public void setPromptAfter(boolean isTrue) {
        this.isPromptAfter = isTrue;
    }

    /**
     * Getter for the menuPresentation property
     * @return if true, car wash selection is a menu rather than a series of prompts
     */    
    public boolean isMenuPresentation() {
        return this.isMenuPresentation;
    }
    
    /**
     * Setter for the menuPresentation property
     * @param isTrue if true, car wash selection is a menu rather than a series of prompts
     */    
    public void setMenuPresentation(boolean isTrue) {
        this.isMenuPresentation = isTrue;
    }

    /**
     * Getter for displayOrder property
     * @return DisplayOrderType object
     */    
    public DisplayOrderType getDisplayOrder() {
        return this.displayOrder;
    }
    
    /**
     * Setter for displayOrder property
     * @param setting DisplayOrderType object
     */    
    public void setDisplayOrder(DisplayOrderType setting) {
        this.displayOrder = setting;
    }

    /**
     * Getter for daysValid property
     * @return Number of days car wash code is valid
     */    
    public int getDaysValid() {
        return this.daysValid;
    }
    
    /**
     * Setter for daysValid property
     * @param setting Number of days car wash code is valid
     */    
    public void setDaysValid(int setting) {
        this.daysValid = setting;
    }

    /**
     * Getter for ryko property
     * @return set to true if using a Ryko car wash
     */    
    public boolean isRyko() {
        return this.isRyko;
    }
    
    /**
     * Setter for ryko property
     * @param isTrue set to true if using a Ryko car wash
     */    
    public void setRyko(boolean isTrue) {
        this.isRyko = isTrue;
    }

    /**
     * Getter for a specific car wash key
     * @param keyID key number of CarWashKey object to be returned
     * @throws Exception if invalid key number is requested
     * @return requested CarWashKey object
     */    
    public CarWashKey getCarWashKey(int keyID) {
        return (CarWashKey)keys.get(new Integer(keyID));
    }
    
    /**
     * Add a new CarWashKey object
     * @param key CarWashKey object to be added
     * @throws Exception on error in adding the object
     */    
    public void addCarWashKey(CarWashKey key) {
        if (null == key) {
            return;
        }
        Integer keyId = new Integer(key.getID());
        try {
            key.validate();
            PluPK pk = key.getPLU();
            if (null == pk || pk.getValue().equals(EMPTY_PLU)) {
                keys.remove(keyId);
            }
            else {
                keys.put(keyId, key);
            }
        }
        catch (Exception e) {
            keys.remove(keyId);
        }
    }
    
    /**
     * Getter for the car wash key list
     * @return enumeration of the car wash keys
     */    
    public Collection<CarWashKey> getCarWashKeys() {
        return keys.values();
    }
    
    /**
     * Setter for the car wash key list
     * @param keys enumeration of the car wash keys
     */    
    public void setCarWashKeys(Collection<CarWashKey> keys) {
        this.keys.clear();
        if (keys != null) {
            for(CarWashKey key : keys) {
                this.addCarWashKey(key);
            }
        }
    }
    
    /**
     * Method to clone an instance with the current object's values
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        CarWashConfig dObj = (CarWashConfig) obj;
        dObj.setEnabled(this.isEnabled());
        dObj.setDepartment(this.getDepartment());
        dObj.setPromptBefore(this.isPromptBefore());
        dObj.setPromptAfter(this.isPromptAfter());
        dObj.setMenuPresentation(this.isMenuPresentation());
        dObj.setDisplayOrder(this.getDisplayOrder());
        dObj.setDaysValid(this.getDaysValid());
        dObj.setCarWashKeys(this.getCarWashKeys());
    }

    /**
     * Concrete method to validate the primary key of the entity object
     * @return true if primary key is valid
     */
    public boolean isIDValid() {
        return true;
    }
    
    /**
     * Validator for the entitie's attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception ("Invalid ID for Car wash: " +this.ID);
        }
        if (department.getValue() != 0) {
            if (!(department.isValid())) {
                throw new Exception("Invalid Department: " + department + " for Car Wash");
            }
        }
        if ((daysValid < MIN_DAYS_VALID) || (daysValid > MAX_DAYS_VALID)) {
            throw new Exception("Invalid Days Valid: " + daysValid + " for Car Wash");
        }
        Collection<CarWashKey> elems = keys.values();
        for(CarWashKey key: elems) {
            key.validate();
        }
    }
    
    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}