package com.verifone.isd.vsms2.sales.ent.imagecfg;

import java.util.regex.Pattern;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.managedevices.ManageDeviceApplicationType;

public class ImageConfigPK implements IEntityPK {

	private static final long serialVersionUID = -7428569876194075462L;
	public static final String IMAGE_NAME_REG_EX = "^[a-zA-Z0-9 _-]+$";
	private String name;
	private ManageDeviceApplicationType applicationType;

	public ImageConfigPK(String name, ManageDeviceApplicationType applicationType ) {
		this.name = name;
		this.applicationType = applicationType;
	}
	@Override
	public boolean isValid() {
		if(name == null || name.trim().length() <= 0 || name.length() > ImageConfig.IMAGE_NAME_MAX_LENGTH
				|| !Pattern.matches(IMAGE_NAME_REG_EX, name)) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManageDeviceApplicationType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(ManageDeviceApplicationType applicationType) {
		this.applicationType = applicationType;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof ImageConfigPK) {
			ImageConfigPK pk = ((ImageConfigPK) obj);
			return (this.name.equals(pk.name) && this.applicationType == pk.applicationType);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = this.name.hashCode();
		hashCode += this.applicationType != null ? this.applicationType.hashCode() : 0;
		
		return hashCode;
	}
	
    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return name + " : " + applicationType.getAppTypeStringType();
    }
}
