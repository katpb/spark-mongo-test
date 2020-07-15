package com.verifone.isd.vsms2.sales.ent.vistadevice;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Item Subset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemSubsetConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 6992535560443928679L;
	private VistaItemSubsetConfigPK pk;
	private String name;
	private int groupId;
	private List<VistaItemSubsetItemConfig> items;
	
	public static final int SUBSET_NAME_LENGTH = 36; 
	public static final int MAX_SUBSET_ID = 999;
	
	public VistaItemSubsetConfig() {
		items = new ArrayList<VistaItemSubsetItemConfig>();
	}
	
	public VistaItemSubsetConfig(VistaItemSubsetConfigPK pk) {
		this.pk = pk;
		items = new ArrayList<VistaItemSubsetItemConfig>();
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (VistaItemSubsetConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaItemSubsetConfig subsetConfig = (VistaItemSubsetConfig) obj;
		subsetConfig.setPK(pk);
		subsetConfig.setName(name);
		subsetConfig.setGroupId(groupId);
		subsetConfig.setItems(items);
	}

	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid item subset ID : " + this.pk.getId());
		}
		
		if(name == null || name.trim().length() > SUBSET_NAME_LENGTH) {
			throw new Exception("Invalid item subset name : " + this.name);
		}
		
		for(VistaItemSubsetItemConfig item : items) {
			item.validate();
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaItemSubsetConfig)) {
			return false;
		}
		VistaItemSubsetConfig itemSubsetConfig = (VistaItemSubsetConfig) obj;
		if(itemSubsetConfig.getPK() == null || ((VistaItemSubsetConfigPK)itemSubsetConfig.getPK()).getId() != this.pk.getId()) {
			return false;
		}
		if(itemSubsetConfig.getName() == null || !itemSubsetConfig.getName().equals(this.name)) {
			return false;
		}
		if(itemSubsetConfig.getGroupId() != this.groupId) {
			return false;
		}
		for(VistaItemSubsetItemConfig item : itemSubsetConfig.getItems()) {
			if(!items.contains(item)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 34;
		hash += hash * 6 + this.pk.getId();
		hash += hash * 4 + this.name.length();
		hash += hash * 5 + this.groupId;
		
		return hash;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VistaItemSubsetItemConfig> getItems() {
		return items;
	}

	public void setItems(List<VistaItemSubsetItemConfig> items) {
		this.items = items;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
