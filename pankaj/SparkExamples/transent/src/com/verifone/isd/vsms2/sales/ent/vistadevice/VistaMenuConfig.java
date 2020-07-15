package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Menu Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaMenuConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 3727349047290906687L;
	private int menuID;
	public VistaMenuConfig() { 
	}
	
	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}


	public VistaMenuConfig(int menuID) {
		this.menuID = menuID; 
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return null;
	}

	@Override
	public void setPK(IEntityPK pk) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaMenuConfig config = (VistaMenuConfig) obj;
		config.setMenuID(this.menuID);
	}

	@Override
	public void validate() throws Exception {
		if(this.menuID < 0) {
			throw new Exception("Invalid Department Number : " + this.menuID);
		}
	}

	@Override
	public boolean isPKValid() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof VistaMenuConfig)) {
			return false;
		}
		
		VistaMenuConfig config = (VistaMenuConfig) obj;
		if(this.menuID != config.menuID) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash += hash * 12 + this.menuID;
		return hash;
	}
}
