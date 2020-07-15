
package com.verifone.isd.vsms2.sales.ent.softkey;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * PK for Soft Key Type security config
 * 
 * @author Medha_K1
 *
 */
public class SoftKeyTypeSecurityConfigPK implements IEntityPK {
	static final long serialVersionUID = -4070256954345034854L;
	private SoftKeyType softKeyType;

	public SoftKeyTypeSecurityConfigPK() {
	}

	public SoftKeyTypeSecurityConfigPK(final SoftKeyType softKeyCode) {
		softKeyType = softKeyCode;
	}

	@Override
	public boolean equals(final IEntityPK obj) {
		if (obj instanceof SoftKeyTypeSecurityConfigPK) {
			final SoftKeyTypeSecurityConfigPK pk = (SoftKeyTypeSecurityConfigPK) obj;
			return (softKeyType.equals(pk.softKeyType));
		}
		return false;
	}

	@Override
	public boolean equals(final Object obj) {
		if ((obj instanceof IEntityPK)) {
			return this.equals((IEntityPK) obj);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return ((softKeyType != null) && (softKeyType.getCode() != null));
	}

	@Override
	public String toString() {
		return softKeyType.toString();
	}

	public SoftKeyType getValue() {
		return softKeyType;
	}

	@Override
	public int hashCode() {
		final int hc = 37 * 17;
		return hc + ((softKeyType == null) ? 0 : softKeyType.hashCode());
	}
}
