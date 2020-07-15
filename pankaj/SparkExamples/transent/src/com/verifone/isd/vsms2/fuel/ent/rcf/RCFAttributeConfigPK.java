package com.verifone.isd.vsms2.fuel.ent.rcf;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class RCFAttributeConfigPK implements IEntityPK {

	private static final long serialVersionUID = 3473400565819859876L;
	
	private int id;

	public RCFAttributeConfigPK(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof RCFAttributeConfigPK) {
			RCFAttributeConfigPK cObj = (RCFAttributeConfigPK)obj;
            return (this.id == cObj.id);
        }
        return false;
	}
	
	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		int hc = 17 * 47;
		hc = (37 * hc) + (this.id * 19);        

		return hc;
	}

	@Override
	public boolean isValid() {
		return (this.id > 0 && this.id <= RCFAttributeConfig.MAX_FUEL_POS);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	/*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return String.valueOf(this.id);
    }
}
