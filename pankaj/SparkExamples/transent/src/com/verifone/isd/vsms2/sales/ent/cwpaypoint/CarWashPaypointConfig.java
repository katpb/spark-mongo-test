package com.verifone.isd.vsms2.sales.ent.cwpaypoint;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 *  entity class for CarWashPaypointConfig
 *
 *  @author Aaron_S1
 *  @version 1.0 Copyright(c) 2007 VeriFone, Inc., All Rights Reserved
 */
public class CarWashPaypointConfig implements IEntityObject, ISalesEntityVisitable {


    private CarWashPaypointConfigPK ID;
    private int dayClosePeriod;
    private int networkTimeout;

    private Hashtable bays;  // hashtable of CarWashBays
                   
    /**
     * Constructor
     */    
    public CarWashPaypointConfig() {
        this.bays = new Hashtable();
    }

    /**
     * Method to validate the primary key
     * @return true if PK is valid
     */    
    public boolean isPKValid() {
        if (this.ID == null) {
            this.ID = new CarWashPaypointConfigPK();
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
        this.ID = (CarWashPaypointConfigPK)pk;
    }
    
    /**
     * Getter for the dayClosePeriod
     * @return day close period
     */    
    public int getDayClosePeriod() {
        return this.dayClosePeriod;
    }
    
    /**
     * Setter for the dayClosePeriod
     * @param dayclosePd day close period
     */    
    public void setDayClosePeriod(int dayclosePd) {
        this.dayClosePeriod = dayclosePd;
    }
    
    /**
     * Getter for the networkTimeout
     * @return network timeout
     */    
    public int getNetworkTimeout() {
        return this.networkTimeout;
    }
    
    /**
     * Setter for the networkTimeout
     * @param networkTimeout network timeout
     */    
    public void setNetworkTimeout(int networkTimeout) {
        this.networkTimeout = networkTimeout;
    }
    
    /**
     * Getter for a specific car wash bay
     * @param bayID bay number of CarWashBay object to be returned
     * @throws Exception if invalid bay number is requested
     * @return requested CarWashBay object
     */    
    public CarWashBay getCarWashBay(int bayID) throws Exception {
        return (CarWashBay)bays.get(new Integer(bayID));
    }

    /**
     * Getter for the car wash bay list
     * @return enumeration of the car wash bays
     */    
    public Enumeration getCarWashBays() {
        return bays.elements();
    }
    
    /**
     * Setter for the car wash bay list
     * @param bays enumeration of the car wash bays
     */    
    public void setCarWashBays(Enumeration bays) {
        this.bays.clear();
        if (bays != null) {
            while(bays.hasMoreElements()) {
                CarWashBay bay = (CarWashBay)bays.nextElement();
                this.bays.put(new Integer(bay.getID()), bay);
            }
        }
    }
    
    /**
     * Method to clone an instance with the current object's values
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        CarWashPaypointConfig dObj = (CarWashPaypointConfig) obj;
        dObj.setDayClosePeriod(this.getDayClosePeriod());
        dObj.setNetworkTimeout(this.getNetworkTimeout());
        dObj.setCarWashBays(this.getCarWashBays());
        dObj.setPK(this.getPK());
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
            throw new Exception ("Invalid ID for Match: " +this.ID);
        }
        if (this.getDayClosePeriod() < 1) {
            throw new Exception ("Invalid Day Close Period: " + this.getDayClosePeriod());
        }
        if (this.getNetworkTimeout() < 1) {
            throw new Exception ("Invalid Network Timeout: " + this.getNetworkTimeout());
        }

        Enumeration elems = bays.elements();
        while (elems.hasMoreElements()) {
            CarWashBay bay = (CarWashBay)elems.nextElement();
            bay.validate();
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