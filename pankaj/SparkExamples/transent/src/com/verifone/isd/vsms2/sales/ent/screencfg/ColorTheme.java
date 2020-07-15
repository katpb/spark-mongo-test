/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 17 Nov, 2004                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * This is a Value Object for a Color theme. Each ColorTheme object has an id, name,
 * foreColor, and location of the associated gif file. 
 *
 * @author  Sudesh_S1.
 * @version 1.0
 */
public class ColorTheme {
    
    private int id;
    private String name;
    private String foreColorRGB;
    private String location;
    
    /**
     * constructor
     */
    public ColorTheme() {
        super();
    }
        
    /**
     * @return Returns the foreColor.
     */
    public String getForeColorRGB() {
        return foreColorRGB;
    }
    /**
     * @param foreColor The foreColor to set.
     */
    public void setForeColorRGB(String foreColorRGB) {
        this.foreColorRGB = foreColorRGB;
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
        return "id-"+ id + ";name-" + name + ";foreColorRGB-" + foreColorRGB + ";location-" + location;
    }
}
