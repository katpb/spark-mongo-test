package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity PK class for Vista Group Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaGroupConfigPK implements IEntityPK{
	private static final long serialVersionUID = 220082258109948306L;
	private int id;

	public VistaGroupConfigPK() {
		
	}
	
	public VistaGroupConfigPK(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof VistaGroupConfigPK) {
			return (this.id == ((VistaGroupConfigPK) obj).id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 87 * 17 + this.id;
	}
	
	@Override
	public boolean isValid() {
		return (this.id > 0 && this.id <= VistaGroupConfig.MAX_GROUPS);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
