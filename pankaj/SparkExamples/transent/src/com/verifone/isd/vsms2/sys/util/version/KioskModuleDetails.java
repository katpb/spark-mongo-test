package com.verifone.isd.vsms2.sys.util.version;		// moved from package com.verifone.isd.vsms2.autoupgrade.ent.kiosk

import java.io.Serializable;

/**
 * Entity class that maintains version details of a module in Kiosk
 * NOTE- as of CR1141.01 only one module has been identified i.e. kiosk application
 * @author T_ManasiS1
 *
 */
public class KioskModuleDetails implements Serializable {
	
	private static final long serialVersionUID = -3615668136039713456L;
	private String moduleName;
	private String moduleVer;
	private String timeStamp;
	private String buildHash;
		
	public String getModuleName() {
		return moduleName;
	}
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getModuleVer() {
		return moduleVer;
	}
		
	public void setModuleVer(String moduleVer) {
		this.moduleVer = moduleVer;
	}
		
	public String getTimeStamp() {
		return timeStamp;
	}
		
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
		
	public String getBuildHash() {
		return buildHash;
	}
		
	public void setBuildHash(String buildHash) {
		this.buildHash = buildHash;
	}

}
