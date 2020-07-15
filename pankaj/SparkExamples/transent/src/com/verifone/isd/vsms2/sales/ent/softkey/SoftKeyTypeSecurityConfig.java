
package com.verifone.isd.vsms2.sales.ent.softkey;

import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;
import com.verifone.isd.vsms2.sys.error.VFIException;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;

import org.xml.sax.SAXException;

/**
 * Entity class for SoftKeyType Security Config
 * @author Medha_K1
 *
 */
public class SoftKeyTypeSecurityConfig implements IEntityObject, java.io.Serializable {

	private static final long serialVersionUID = 2572081128054255273L;
	private SoftKeyTypeSecurityConfigPK key;
	private SecurityLevel secLevel;

	public SoftKeyTypeSecurityConfig() {

	}

	public SoftKeyTypeSecurityConfig(final SoftKeyTypeSecurityConfigPK key, final SecurityLevel secLevel) {
		this.key = key;
		this.secLevel = secLevel;

	}

	public SecurityLevel getSecLevel() {
		return secLevel;
	}

	public void setSecLevel(final SecurityLevel secLevel) {
		this.secLevel = secLevel;
	}

	@Override
	public IEntityPK getPK() {
		return key;
	}

	@Override
	public void setPK(final IEntityPK pk) {
		key = (SoftKeyTypeSecurityConfigPK) pk;
	}

	@Override
	public void setAttributes(final IEntityObject obj) {

		final SoftKeyTypeSecurityConfig cObj = (SoftKeyTypeSecurityConfig) obj;
		cObj.setPK(getPK());
		cObj.setSecLevel(secLevel);

	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new VFIException(TopazRes.INVALID_SOFTKEYTYPE, LocalizedRB.TOPAZ_RESOURCE);
		}
		
		if (secLevel == null || (secLevel.getOrdinal() < SecurityLevel.MINIMUM.getOrdinal()
				|| secLevel.getOrdinal() > SecurityLevel.MAXIMUM.getOrdinal())) {
			throw new VFIException(TopazRes.INVALID_SECURITY_LEVEL + key.getValue().getCode(), LocalizedRB.TOPAZ_RESOURCE);
		}

	}

	@Override
	public boolean isPKValid() {
		return (key!= null && key.isValid());
	}

	public void accept(final SalesEntityVisitor softKeyTypeSecurityConfigXMLVisitor) throws SAXException {
		softKeyTypeSecurityConfigXMLVisitor.visit(this);
	}

}
