package com.verifone.isd.vsms2.sales.ent.vistadevice;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Terminal Preview Itemset Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaTerminalPreviewItemsetConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = -9144197781495711278L;
	private int itemsetId;
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
		VistaTerminalPreviewItemsetConfig itemset = (VistaTerminalPreviewItemsetConfig) obj;
		
		itemset.setItemsetId(itemsetId);
		itemset.setOrderNumber(orderNumber);
	}

	@Override
	public void validate() throws Exception {
		if(this.itemsetId <= 0 || this.itemsetId > VistaItemsetConfig.MAX_ITEMSET_ID) {
			throw new Exception("Invalid Itemset ID : " + this.itemsetId);
		}
	}

	@Override
	public boolean isPKValid() {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaTerminalPreviewItemsetConfig)) {
			return false;
		}
		VistaTerminalPreviewItemsetConfig itemsetConfig = (VistaTerminalPreviewItemsetConfig) obj;
		
		if(itemsetConfig.getItemsetId() != this.itemsetId) {
			return false;
		}
		if(itemsetConfig.getOrderNumber() != this.orderNumber) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 65;
		hash += hash * 45 + itemsetId;
		hash += hash * 76 + orderNumber;
		
		return hash;
	}
	
	public int getItemsetId() {
		return itemsetId;
	}

	public void setItemsetId(int itemsetId) {
		this.itemsetId = itemsetId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
