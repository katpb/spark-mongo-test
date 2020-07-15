/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 09 Nov, 2010                                        Ganesh Kumar K
*/
package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.Date;
import java.util.HashMap;

/**
 * This is a Value Object for a Theme config.  
 *
 * @author  Ganesh_k1.
 * @version 1.0
 */
public class ThemeCfg {
    
    private Date creationDate;
    private int maxScreens;
    
    private HashMap colorThemesMap = null;
    private HashMap themeSoundsMap = null;
    private HashMap themeUseMap = null;
    
    /**
     * constructor
     */
    public ThemeCfg() {
	colorThemesMap = new HashMap();
	themeSoundsMap = new HashMap();
	themeUseMap = new HashMap();
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @return the maxScreens
     */
    public int getMaxScreens() {
        return maxScreens;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @param maxScreens the maxScreens to set
     */
    public void setMaxScreens(int maxScreens) {
        this.maxScreens = maxScreens;
    }
    
    /**
     * Add color theme to the collection
     * @param theme
     */
    public void addColorTheme(ColorTheme theme) {
	colorThemesMap.put(new Integer(theme.getId()), theme);	
    }
    
   /**
    * Method to get the color theme for a given color theme id.
    * @param colorThemeID
    * @return ColorTheme
    */
    public ColorTheme getColorTheme(Integer colorThemeID) {
	return (ColorTheme)colorThemesMap.get(colorThemeID);	
    }
    
    /**
     * Add theme sound to the collection
     * @param theme
     */
    public void addThemeSound(ThemeSound theme) {
	themeSoundsMap.put(new Integer(theme.getId()), theme);	
    }
    
   /**
    * Method to get the theme sound for a given theme sound id.
    * @param themeSoundID
    * @return ThemeSound
    */
    public ThemeSound getThemeSound(Integer themeSoundID) {
	return (ThemeSound)themeSoundsMap.get(themeSoundID);	
    }
    
    /**
     * Add theme use to the collection
     * @param theme
     */
    public void addThemeUse(ThemeUse theme) {
	themeUseMap.put(new Integer(theme.getId()), theme);	
    }
    
   /**
    * Method to get the theme use for a given theme use id.
    * @param themeUseID
    * @return ThemeUse
    */
    public ThemeUse getThemeUse(Integer themeUseID) {
	return (ThemeUse)themeUseMap.get(themeUseID);	
    }
}
