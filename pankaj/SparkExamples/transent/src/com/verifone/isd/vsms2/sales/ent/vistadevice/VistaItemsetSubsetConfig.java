package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Itemset Subset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaItemsetSubsetConfig implements IEntityObject, ISalesEntityVisitable {
	
	private static final long serialVersionUID = -9195973033789043372L;
	private int itemSubsetId;
	private int orderNumber;
	
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
		VistaItemsetSubsetConfig subsetItem = (VistaItemsetSubsetConfig) obj;
		
		subsetItem.setItemSubsetId(itemSubsetId);
		subsetItem.setOrderNumber(orderNumber);
	}

	@Override
	public void validate() throws Exception {
		if(this.itemSubsetId <= 0 || this.itemSubsetId > VistaItemSubsetConfig.MAX_SUBSET_ID) {
			throw new Exception("Invalid Item subset ID : " + this.itemSubsetId);
		}
	}

	@Override
	public boolean isPKValid() {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaItemsetSubsetConfig)) {
			return false;
		}
		VistaItemsetSubsetConfig itemsetSubsetConfig = (VistaItemsetSubsetConfig) obj;
		
		if(itemsetSubsetConfig.getItemSubsetId() != this.itemSubsetId) {
			return false;
		}
		if(itemsetSubsetConfig.getOrderNumber() != this.orderNumber) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 34;
		hash += hash * 23 + itemSubsetId;
		hash += hash * 43 + orderNumber;
		
		return hash;
	}

	public int getItemSubsetId() {
		return itemSubsetId;
	}

	public void setItemSubsetId(int itemSubsetId) {
		this.itemSubsetId = itemSubsetId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
