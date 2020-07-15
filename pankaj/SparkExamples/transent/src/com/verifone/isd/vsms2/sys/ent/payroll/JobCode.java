/*
 * JobCode.java
 *
 * Created on August 12, 2005, 6:59 PM
 */

package com.verifone.isd.vsms2.sys.ent.payroll;

import java.io.Serializable;
/**
 *
 * @author  bhanu_n2
 */
public class JobCode implements Serializable {
    static final long serialVersionUID = -8664098268204841852L;
    /**
     * Holds value of property id.
     */
    private int id;
    
    /**
     * Holds value of property name.
     */
    private String name;
    
    /** Creates a new instance of JobCode */
    public JobCode() {
    }
    
    /**
     * Getter for property id.
     * @return Value of property id.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Setter for property id.
     * @param id New value of property id.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
