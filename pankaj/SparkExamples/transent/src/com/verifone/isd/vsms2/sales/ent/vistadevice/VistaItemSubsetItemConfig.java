package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista ItemSubset Item Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemSubsetItemConfig implements IEntityObject, ISalesEntityVisitable {
	private static final long serialVersionUID = -3148166063684125539L;
	private int itemId;
	private String name;
	private String iconName;
	private ItemTypeEnum itemType;
	private boolean hotItem;
	private String itemChoice;
	private int orderNumber;
	
	public static final int ITEM_NAME_LENGTH = 36; 
	public static final int MAX_ITEM_ID = 9999;
	
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
	
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaItemSubsetItemConfig subsetItem = (VistaItemSubsetItemConfig) obj;
		
		subsetItem.setItemId(itemId);
		subsetItem.setName(name);
		subsetItem.setIconName(iconName);
		subsetItem.setItemType(itemType);
		subsetItem.setHotItem(hotItem);
		subsetItem.setItemChoice(itemChoice);
		subsetItem.setOrderNumber(orderNumber);
	}

	@Override
	public void validate() throws Exception {
		if(this.itemId <= 0 || this.itemId > MAX_ITEM_ID) {
			throw new Exception("Invalid item ID : " + this.itemId);
		}
		
		if(name == null || name.trim().length() > ITEM_NAME_LENGTH) {
			throw new Exception("Invalid item name : " + this.name);
		}
	}

	@Override
	public boolean isPKValid() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaItemSubsetItemConfig)) {
			return false;
		}
		VistaItemSubsetItemConfig itemSubsetItemConfig = (VistaItemSubsetItemConfig) obj;
		if(itemSubsetItemConfig.getItemId() != this.itemId) {
			return false;
		}
		if(itemSubsetItemConfig.getName() == null || !itemSubsetItemConfig.getName().equals(this.name)) {
			return false;
		}
		if(itemSubsetItemConfig.getIconName() == null || !itemSubsetItemConfig.getIconName().equals(this.iconName)) {
			return false;
		}
		if(itemSubsetItemConfig.getItemType() == null || itemSubsetItemConfig.getItemType() != this.itemType) {
			return false;
		}
		if(itemSubsetItemConfig.isHotItem() != this.hotItem) {
			return false;
		}
		if(itemSubsetItemConfig.getItemChoice() == null || !itemSubsetItemConfig.getItemChoice().equals(this.itemChoice)) {
			return false;
		}
		if(itemSubsetItemConfig.getOrderNumber() != this.orderNumber) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 342;
		hash += hash * 6 + itemId;
		hash += hash * 2 + name.length();
		hash += hash * 3 + iconName.length();
		hash += hash * 4 + itemType.getOrdinal();
		hash += hash * 8 + itemChoice.length();
		hash += hash * 1 + orderNumber;
		
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

	public ItemTypeEnum getItemType() {
		return itemType;
	}

	public void setItemType(ItemTypeEnum itemType) {
		this.itemType = itemType;
	}

	public boolean isHotItem() {
		return hotItem;
	}

	public void setHotItem(boolean hotItem) {
		this.hotItem = hotItem;
	}

	public String getItemChoice() {
		return itemChoice;
	}

	public void setItemChoice(String itemChoice) {
		this.itemChoice = itemChoice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
