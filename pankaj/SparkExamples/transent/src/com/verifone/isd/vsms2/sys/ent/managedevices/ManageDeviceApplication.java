package com.verifone.isd.vsms2.sys.ent.managedevices;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.function.Function;
/**
 * Entity class for Manage Devices Application
 * 
 * @author MadhusudhanB1
 *
 */
public class ManageDeviceApplication implements IEntityObject, ISystemEntityVisitable {

		private static final long serialVersionUID = -3145672424507989789L;
		private ManageDeviceApplicationPK pk;
		private List<String> functions = null;
		
		public ManageDeviceApplication() {
			functions = new ArrayList<>();
		}
		
		public ManageDeviceApplication(ManageDeviceApplicationPK pk) {
			this.pk = pk;
			functions = new ArrayList<>();
		}

		@Override
		public void accept(ISystemEntityVisitor v) throws Exception {
		}

		@Override
		public IEntityPK getPK() {
			return pk;
		}

		@Override
		public void setPK(IEntityPK pk) {
			this.pk = (ManageDeviceApplicationPK) pk;
		}

		@Override
		public void setAttributes(IEntityObject obj) {
			ManageDeviceApplication config = (ManageDeviceApplication) obj;
			config.setPK(this.pk);
			config.setFunctions(this.functions);
		}

		@Override
		public void validate() throws Exception {
			if(!isPKValid()) {
				throw new Exception("Invalid Register ID : " + this.pk);
			}
		}

		@Override
		public boolean isPKValid() {
			return (this.pk == null) ? false : this.pk.isValid();
		}
		
		public List<Function> getFunctions() {
			
		        List<Function> fns = new ArrayList<>();
		        for (String fName : this.functions) {
		            Function f = Function.get(fName);
		            if (f != null) {
						fns.add(f);
					}
		        }
		        return fns;
		}

		public void setFunctions(List<String> functions) {
			this.functions = functions;
		}
	}
