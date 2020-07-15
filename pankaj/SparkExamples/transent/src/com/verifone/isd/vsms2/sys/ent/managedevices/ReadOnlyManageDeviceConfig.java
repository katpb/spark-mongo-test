package com.verifone.isd.vsms2.sys.ent.managedevices;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;

/**
 * Read Only Entity class for Manage Devices Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class ReadOnlyManageDeviceConfig extends ManageDeviceConfig {
	
	private static final long serialVersionUID = -5184541135125953266L;

	public ReadOnlyManageDeviceConfig(ManageDeviceConfigPK ID) throws Exception {
        super(ID);
    }
    
    public ReadOnlyManageDeviceConfig(final ReadOnlyManageDeviceConfig manageDeviceConfig)throws Exception{
    	super((ManageDeviceConfigPK)manageDeviceConfig.getPK());
    }
    
    @Override
    public void setAttributes(IEntityObject obj) {
        super.setAttributes(obj);
    }
    
	@Override
	public void accept(ISystemEntityVisitor v) throws Exception {
		v.visit(this);
	}
}
