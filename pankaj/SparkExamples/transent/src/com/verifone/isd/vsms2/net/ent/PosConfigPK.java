/**
 * 
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author Regan_D1
 *
 */
public class PosConfigPK implements IEntityPK {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2162871667814730400L;
	private String epsName ;

	public PosConfigPK(String epsName){
		this.epsName = epsName;
	}
	
	/**
	 * @return the epsName
	 */
	public String getEpsName() {
		return epsName;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#equals(com.verifone.isd.vsms2.sys.db.pres.IEntityPK)
	 */
	@Override
	public boolean equals(IEntityPK obj) {
		
		if(obj instanceof PosConfigPK)
		{
			PosConfigPK PK = (PosConfigPK) obj;
			return PK.getEpsName().equals(epsName);
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof IEntityPK){
			return this.equals((IEntityPK)obj);
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return epsName.hashCode();
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#isValid()
	 */
	@Override
	public boolean isValid() {
		return true;
	}

}
