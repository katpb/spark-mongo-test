package com.verifone.isd.vsms2.sys.util.version;	// moved from package com.verifone.isd.vsms2.autoupgrade.ent.kiosk 

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Entity class that holds kiosk version details received from individual kiosk units
 * @author T_ManasiS1
 *
 */
public class KioskVersionDetails implements Serializable {
	
	private static final long serialVersionUID = -3615668136039713654L;
	
	private int kioskSysID;
	private ArrayList<KioskModuleDetails> modulesList;

	public KioskVersionDetails() {
		modulesList = new ArrayList<KioskModuleDetails>();
	}
	
	public ArrayList<KioskModuleDetails> getModulesList() {
		return modulesList;
	}
	
	public void setModulesList(ArrayList<KioskModuleDetails> modulesList) {
		this.modulesList = modulesList;
	}
	
	public void addModule(KioskModuleDetails module) {
		if(module != null) {
			this.modulesList.add(module);
		}
	}

	public int getKioskSysID() {
		return kioskSysID;
	}
	
	public void setKioskSysID(int kioskSysID) {
		this.kioskSysID = kioskSysID;
	}

}
