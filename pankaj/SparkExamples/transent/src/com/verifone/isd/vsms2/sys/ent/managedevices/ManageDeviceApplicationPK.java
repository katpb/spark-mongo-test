package com.verifone.isd.vsms2.sys.ent.managedevices;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary Key class for Manage Devices Application
 * 
 * @author MadhusudhanB1
 *
 */
public class ManageDeviceApplicationPK implements IEntityPK {

	private static final long serialVersionUID = 5149745965869142885L;
	private ManageDeviceApplicationType id;
	
	public ManageDeviceApplicationPK(ManageDeviceApplicationType id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof ManageDeviceApplicationPK) {
			return (this.id.equals(((ManageDeviceApplicationPK) obj).id));
		}
		return false;
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	public ManageDeviceApplicationType getId() {
		return id;
	}

	public void setId(ManageDeviceApplicationType id) {
		this.id = id;
	}


}
