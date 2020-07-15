package com.verifone.isd.vsms2.sys.ent.managedevices;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary Key class for Manage Devices Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class ManageDeviceConfigPK implements IEntityPK {

	private static final long serialVersionUID = 8814402492800786009L;
	private int id;
	
	public ManageDeviceConfigPK(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof ManageDeviceConfigPK) {
			return (this.id == ((ManageDeviceConfigPK) obj).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 87 * 17 + this.id;
	}
	
	@Override
	public boolean isValid() {
		return (this.id >= ManageDeviceConfig.MIN_TERMINAL_ID && 
				this.id <= ManageDeviceConfig.MAX_TERMINAL_ID);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
