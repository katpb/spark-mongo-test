/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 09 Nov, 2010                                        Ganesh Kumar K
*/
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * This is a Value Object for a Theme Sound. Each theme sound object has an id, name,
 *  and location. 
 *
 * @author  ganesh_k1.
 * @version 1.0
 */
public class ThemeSound {
    
    private int id;
    private String name;
    private String location;
    
    /**
     * constructor
     */
    public ThemeSound() {
    }
        
    /**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return Returns the location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location The location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "id-"+ id + ";name-" + name + ";location-" + location;
    }
}
