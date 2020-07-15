package com.verifone.isd.vsms2.sales.ent.vistadevice;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.MOPCodeConfig;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Group Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaGroupConfig implements IEntityObject, ISalesEntityVisitable{

	private static final long serialVersionUID = -2396743824091531154L;
	public static final int MAX_GROUPS = 32;
	private VistaGroupConfigPK pk;
	private String name;
	private List<MOPCodeConfig> enabledMOPCodes;
	private List<VistaDepartmentConfig> enabledDepartments;
	private List<VistaMenuConfig> menuConfig;

	public 	VistaGroupConfig(){
		enabledMOPCodes = new ArrayList<MOPCodeConfig>();
		enabledDepartments = new ArrayList<VistaDepartmentConfig>();
		menuConfig = new ArrayList<VistaMenuConfig>();
	}
	
	public VistaGroupConfig(VistaGroupConfigPK vistaGroupConfigPK) {
		this.pk= vistaGroupConfigPK;
		enabledMOPCodes = new ArrayList<MOPCodeConfig>();
		enabledDepartments = new ArrayList<VistaDepartmentConfig>();
		menuConfig = new ArrayList<VistaMenuConfig>();
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (VistaGroupConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaGroupConfig terminalCfg = (VistaGroupConfig) obj;
		
		terminalCfg.setPK(this.pk);
		terminalCfg.setName(this.name);
		terminalCfg.setMenuConfig(this.menuConfig);
		terminalCfg.setEnabledMOPCodes(this.enabledMOPCodes);
		terminalCfg.setEnabledDepartments(this.enabledDepartments);
	}

	public List<VistaMenuConfig> getMenuConfig() {
		return menuConfig;
	}

	public void setMenuConfig(List<VistaMenuConfig> expandedMenus) {
		this.menuConfig = expandedMenus;
	}


	public List<MOPCodeConfig> getEnabledMOPCodes() {
		return this.enabledMOPCodes;
	}
	
	public void setEnabledMOPCodes(List<MOPCodeConfig> mopCodes) {
		this.enabledMOPCodes = mopCodes;
	}
	
	public List<VistaDepartmentConfig> getEnabledDepartments() {
		return enabledDepartments;
	}

	public void setEnabledDepartments(List<VistaDepartmentConfig> enabledDepartments) {
		this.enabledDepartments = enabledDepartments;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}


	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid Vista Group ID : " + this.pk);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaGroupConfig)) {
			return false;
		}
		VistaGroupConfig vistaGroupConfig = (VistaGroupConfig) obj;
		if(vistaGroupConfig.getPK() == null || ((VistaGroupConfigPK)vistaGroupConfig.getPK()).getId() != this.pk.getId())
		{
			return false;
		}
		if(vistaGroupConfig.getEnabledDepartments() == null || !(vistaGroupConfig.getEnabledDepartments().equals(this.getEnabledDepartments()))) {
			return false;
		}
		if(vistaGroupConfig.getName() == null || !(vistaGroupConfig.getName().equals(this.getName()))) {
			return false;
		}
		if(vistaGroupConfig.getEnabledMOPCodes() == null || !(vistaGroupConfig.getEnabledMOPCodes().equals(this.getEnabledMOPCodes()))) {
			return false;
		}
		if(vistaGroupConfig.getMenuConfig() == null || !(vistaGroupConfig.getMenuConfig().equals(this.getMenuConfig()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 34;
		hash += hash * 6 + this.pk.getId();
		hash += hash * 6 + this.getEnabledDepartments().hashCode();
		hash += hash * 6 + this.getEnabledMOPCodes().hashCode();
		hash += hash * 6 + this.getMenuConfig().hashCode();
		hash += hash * 6 + this.getName().hashCode();	
		return hash;
	}
}
