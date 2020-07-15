package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.managedevices.ManageDeviceConfig;

/**
 * Entity PK class for Vista Terminal Preview Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaTerminalPreviewConfigPK implements IEntityPK {

	private static final long serialVersionUID = -3586488016808906655L;
	private int id;
	
	public VistaTerminalPreviewConfigPK() {
		
	}
	
	public VistaTerminalPreviewConfigPK(int id) {
		this.id = id;
	}
	
	@Override
	public boolean isValid() {
		return (this.id >= ManageDeviceConfig.MIN_TERMINAL_ID && 
				this.id <= ManageDeviceConfig.MAX_TERMINAL_ID);
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof VistaItemsetConfigPK) {
			return (this.id == ((VistaItemsetConfigPK) obj).getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 123 * 25 + this.id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
