package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.managedevices.ManageDeviceConfig;

/**
 * Entity PK class for Vista Terminal Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaTerminalPK implements IEntityPK {

	private static final long serialVersionUID = 8155527826011598121L;
	private int id;
	
	public VistaTerminalPK(int id) {
		this.id = id;
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
	
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof VistaTerminalPK) {
			return (this.id == ((VistaTerminalPK) obj).id);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 77 * 17 + this.id;
	}
	
    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return String.valueOf(this.id);
    }

}
