package com.verifone.isd.vsms2.sales.ent.apt;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.managedevices.ManageDeviceConfig;

/**
 * Primary Key class for APT Terminal Config
 * 
 * @author MadhusudhanB1
 *
 */
public class APTTerminalConfigPK implements IEntityPK {

	private static final long serialVersionUID = 220082258109948306L;
	private int id;

	public APTTerminalConfigPK() {
		
	}
	
	public APTTerminalConfigPK(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof APTTerminalConfigPK) {
			return (this.id == ((APTTerminalConfigPK) obj).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 87 * 17 + this.id;
	}
	
	@Override
	public boolean isValid() {
		return (this.id >= ManageDeviceConfig.MIN_TERMINAL_ID && this.id <= ManageDeviceConfig.MAX_TERMINAL_ID);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
