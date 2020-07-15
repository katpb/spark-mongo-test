package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity PK class for Vista Item Subset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemSubsetConfigPK implements IEntityPK {

	private static final long serialVersionUID = -7210011605582478537L;
	private int id;
	
	public VistaItemSubsetConfigPK() {
		
	}
	
	public VistaItemSubsetConfigPK(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof VistaItemSubsetConfigPK) {
			return (this.id == ((VistaItemSubsetConfigPK) obj).getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 45 * 25 + this.id;
	}
	
	@Override
	public boolean isValid() {
		if(this.id <= 0 || this.id > VistaItemSubsetConfig.MAX_SUBSET_ID) {
			return false;
		}
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
