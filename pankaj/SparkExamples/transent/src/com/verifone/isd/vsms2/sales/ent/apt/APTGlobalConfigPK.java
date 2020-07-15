package com.verifone.isd.vsms2.sales.ent.apt;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary Key class for APT Global Config
 * 
 * @author MadhusudhanB1
 *
 */
public class APTGlobalConfigPK implements IEntityPK {

	private static final long serialVersionUID = 8155527826011598121L;
	private int id;
	
	public APTGlobalConfigPK(int id) {
		this.id = id;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof APTGlobalConfigPK) {
			return (this.id == ((APTGlobalConfigPK) obj).id);
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
