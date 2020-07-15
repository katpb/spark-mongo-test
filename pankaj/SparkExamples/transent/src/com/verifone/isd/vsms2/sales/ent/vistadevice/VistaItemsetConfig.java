package com.verifone.isd.vsms2.sales.ent.vistadevice;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Itemset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemsetConfig implements IEntityObject, ISalesEntityVisitable {
	
	private static final long serialVersionUID = 2197280734783647552L;
	private VistaItemsetConfigPK pk;
	private String name;
	private String iconName;
	private String colorCode;
	private List<VistaItemsetSubsetConfig> itemSubsets;

	public static final int ITEMSET_NAME_LENGTH = 12; 
	public static final int MAX_ITEMSET_ID = 99;
	public static final int MAX_COLOR_CODE = 7;
	public static final String [] COLOR_CODES = new String[] {"#2D8F63", "#607FB2", "#AA3939", "#AA5C39", "#AA7539", "#865131", "#666666"};
	
	public VistaItemsetConfig() {
		itemSubsets = new ArrayList<VistaItemsetSubsetConfig>();
	}
	
	public VistaItemsetConfig(VistaItemsetConfigPK pk) {
		this.pk = pk;
		itemSubsets = new ArrayList<VistaItemsetSubsetConfig>();
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
		this.pk = (VistaItemsetConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaItemsetConfig itemsetConfig = (VistaItemsetConfig) obj;
		itemsetConfig.setPK(pk);
		itemsetConfig.setName(name);
		itemsetConfig.setIconName(iconName);
		itemsetConfig.setColorCode(colorCode);
		itemsetConfig.setItemSubsets(itemSubsets);
	}

	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid Itemset ID : " + this.pk.getId());
		}
		
		if(name == null || name.trim().length() > ITEMSET_NAME_LENGTH) {
			throw new Exception("Invalid itemset name : " + this.name);
		}
		
		if(colorCode == null || colorCode.trim().length() > MAX_COLOR_CODE) {
			throw new Exception("Invalid itemset color code : " + this.name);
		}
		
		for(VistaItemsetSubsetConfig itemSubset : this.itemSubsets) {
			itemSubset.validate();
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaItemsetConfig)) {
			return false;
		}
		VistaItemsetConfig itemsetConfig = (VistaItemsetConfig) obj;
		if(itemsetConfig.getPK() == null || ((VistaItemsetConfigPK)itemsetConfig.getPK()).getId() != this.pk.getId())
		{
			return false;
		}
		if(itemsetConfig.getName() == null || !itemsetConfig.getName().equals(this.name)) {
			return false;
		}
		if(itemsetConfig.getIconName() == null || !itemsetConfig.getIconName().equals(this.iconName)) {
			return false;
		}
		if(itemsetConfig.getColorCode() == null || !itemsetConfig.getColorCode().equals(this.colorCode)) {
			return false;
		}
		
		for(VistaItemsetSubsetConfig itemSubset : itemsetConfig.getItemSubsets()) {
			if(!this.itemSubsets.contains(itemSubset)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 23;
		hash += hash * 23 + this.pk.getId();
		hash += hash * 4 + name.length(); 
		hash += hash * 7 + colorCode.length();
		hash += hash * 9 + 	iconName.length();	
		return hash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<VistaItemsetSubsetConfig> getItemSubsets() {
		return itemSubsets;
	}

	public void setItemSubsets(List<VistaItemsetSubsetConfig> itemSubsets) {
		this.itemSubsets = itemSubsets;
	}
}
