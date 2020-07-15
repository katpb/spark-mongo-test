/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 09 Nov, 2010                                        Ganesh Kumar K
*/
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * This is a Value Object for a theme use. Each theme use object has an id and name.
 *
 * @author  ganesh_k1.
 * @version 1.0
 */
public class ThemeUse {
    
    private int id;
    private String name;
    
    /**
     * constructor
     */
    public ThemeUse() {
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
        return "id-"+ id + ";name-" + name;
    }
}
