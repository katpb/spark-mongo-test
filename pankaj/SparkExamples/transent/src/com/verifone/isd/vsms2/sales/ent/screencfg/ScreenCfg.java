/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class represents the complete screen configuration for a Topaz register
 * in a given system. The screen configuration can contain one or more screens
 * for a specific register.
 *
 * @author T_pankajM2.
 * @version 2.0
 */
public class ScreenCfg {

	private Date creationDate;	
	private TreeMap<Integer, Screen> screens;
	
	/**
	 * default constructor.
	 */
	public ScreenCfg() {
		screens = new TreeMap<Integer, Screen>();
	}

	/**
	 * 
	 * @param screen - add screen
	 */
	public void addScreen(Screen screen) {
		screens.put(screen.getScreenID(), screen);
	}

	/**
	 * @return Returns the screen for a given index.
	 */
	public Screen getScreen(int screenIndex) {
		return screens.values().toArray(new Screen[0])[screenIndex];
	}

	/**
	 * @return Returns the screens.
	 */
	public Screen[] getScreens() {
		return (Screen[]) screens.values().toArray(new Screen[0]);
	}

	/**
	 * @return Returns the creationDate.
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate The creationDate to set.
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return Returns the number of screens.
	 */
	public int getNumScreens() {
		return screens.size();
	}
	/**
	 * Checks if the assigned screen id is already present.
	 * 
	 * @param screenID
	 * @return true/false.
	 */
	public boolean containSceenID(int screenID) {
		if (screens.containsKey(screenID)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the screen name is already added.
	 * 
	 * @param screenName
	 * @return
	 */
	public boolean containScreenName(String screenName) {

		for (Screen screen : screens.values()) {
			if (screen.getName().equals(screenName)) {
				return true;
			}
		}
		return false;
	}	

	public Screen getScreenByName (String screenName) {		
		return screens.values().stream().filter(screen -> screen.getName().equals(screenName)).findFirst().orElse(null);
	}
	
	

	public int getMaxScreenId() {
		return screens.lastKey();
		
	}

	//Inner screen class.
	public class Screen {

		private String name;
		private int screenID;
		private Map<Integer, List<Panel>> panelMap;

		/**
		 * constructor
		 */
		public Screen() {		
			panelMap = new HashMap<Integer, List<Panel>>();
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

		/**
		 * 
		 * @param panel - add new panel.
		 */
		public void addPanel(Panel panel) {
			List<Panel> panelList = panelMap.get(panel.getPosition());
			if (panelList == null) {
				panelList = new ArrayList<Panel>();				
			}
			panelList.add(panel);
			this.panelMap.put(panel.getPosition(), panelList);
		}

		/**
		 * 
		 * @return screen id.
		 */
		public int getScreenID() {
			return screenID;
		}

		/**
		 * 
		 * @param screenID - set screen id.
		 */
		public void setScreenID(int screenID) {
			this.screenID = screenID;
		}

		/**
		 * 
		 * @return panel list.
		 */
		public Map<Integer, List<Panel>> getPanelMap() {
			return panelMap;
		}
		
		
		public Panel[] getAllPanels() {			
			List<Panel> panelList = new ArrayList<Panel>();
			panelMap.values().forEach((lst)->{				
				lst.forEach((panel)->{
					panelList.add(panel);
				});
			});
									
			return panelList.toArray(new Panel[0]);
		}
	}

}