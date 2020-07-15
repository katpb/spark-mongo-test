package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity PK class for Vista Itemset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemsetConfigPK implements IEntityPK {

	private static final long serialVersionUID = 6712684209127755191L;
	private int id;
	
	public VistaItemsetConfigPK() {
		
	}
	
	public VistaItemsetConfigPK(int id) {
		this.id = id;
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
		return 35 * 25 + this.id;
	}
	
	@Override
	public boolean isValid() {
		if(this.id <= 0 || this.id > VistaItemsetConfig.MAX_ITEMSET_ID) {
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
