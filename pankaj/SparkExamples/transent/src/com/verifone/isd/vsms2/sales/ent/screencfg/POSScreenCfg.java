package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POSScreenCfg {

	private Date creationdate;
	private int registerId;
	private boolean isZonedFuelControl=false;
	private boolean isOneTouchApprove=false;
	private boolean isOneTouchClaim=false;
	private List<PrepayButton> prePaybuttonList = new ArrayList<PrepayButton>();
	private List<Screen> screenList = new ArrayList<POSScreenCfg.Screen>();
	private String fuelPanelName;
	private String parkedMenuPanelName;
	
	public POSScreenCfg() {		
	}

	public Date getCreationDate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public boolean isZonedFuelControl() {
		return isZonedFuelControl;
	}

	public void setZonedFuelControl(boolean isZonedFuelControl) {
		this.isZonedFuelControl = isZonedFuelControl;
	}

	public boolean isOneTouchApprove() {
		return isOneTouchApprove;
	}

	public void setOneTouchApprove(boolean isOneTouchApprove) {
		this.isOneTouchApprove = isOneTouchApprove;
	}

	public boolean isOneTouchClaim() {
		return isOneTouchClaim;
	}

	public void setOneTouchClaim(boolean isOneTouchClaim) {
		this.isOneTouchClaim = isOneTouchClaim;
	}

	public List<PrepayButton> getPrePaybuttonList() {		
		return prePaybuttonList;
	}

	public void addPrePaybuttonList(List<PrepayButton> prePaybuttonList) {
		this.prePaybuttonList = prePaybuttonList;
	}
	
	public void addPrePaybutton(PrepayButton prepayButton) {
		this.prePaybuttonList.add(prepayButton);
	}
	
	public Screen[] getScreenArr() {
		return screenList.toArray(new Screen[0]);
	}

	public void addScreen(Screen screen) {
		this.screenList.add(screen);
	}

	public String getFuelPanelName() {
		return fuelPanelName;
	}

	public void setFuelPanelName(String fuelPanelName) {
		this.fuelPanelName = fuelPanelName;
	}

	public String getParkedMenuPanelName() {
		return parkedMenuPanelName;
	}

	public void setParkedMenuPanelName(String parkedMenuPanelName) {
		this.parkedMenuPanelName = parkedMenuPanelName;
	}

	// Inner screen class
	public class Screen {		
		private String screenName;
		public String getScreenName() {
			return screenName;
		}
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}	
	}

	
}
