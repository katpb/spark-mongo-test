package com.verifone.isd.vsms2.sales.ent.vendcfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author VadirajaC1
 * 
 */
public class VendingIsland implements IEntityObject {

	private static final int MAX_FUEL_POS_CONFIGURABLE = 3;
	private static final int MAX_PLU_CONFIGURABLE = 40;

	private VendingIslandPK pk;
	private int sysID;
	private String label;
	private boolean enabled;
        private int columns;

	private List<Integer> fuelingPositionsList;
	private Map<Integer, PluPK> vendingPLUMap;

	public VendingIsland() {
		fuelingPositionsList = new ArrayList<Integer>(MAX_FUEL_POS_CONFIGURABLE);
		vendingPLUMap = new HashMap<Integer, PluPK>(MAX_PLU_CONFIGURABLE);
	}

	public int getSysID() {
		return sysID;
	}

	public void setSysID(int sysID) {
		this.sysID = sysID;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

	/**
	 * @return the vendingPLUMap
	 */
	public Map<Integer, PluPK> getVendingPLUMap() {
		return vendingPLUMap;
	}

	public void setVendingPLUMap(Map<Integer, PluPK> vendingPLUMap) {
		this.vendingPLUMap = vendingPLUMap;
	}

	/**
	 * @return the fuelingPositionsList
	 */
	public List<Integer> getFuelingPositionsList() {
		return fuelingPositionsList;
	}

	public void setFuelingPositionsList(List<Integer> fuelingPositionsList) {
		this.fuelingPositionsList = fuelingPositionsList;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" | sysID = ").append(sysID);
		sb.append(" | label = ").append(label);
		sb.append(" | enabled = ").append(enabled);
		
		for (Integer fuelPos : fuelingPositionsList) {
			sb.append(" | fuelPos = ").append(fuelPos);
		}
		
		for (Entry<Integer, PluPK> pluEntry : vendingPLUMap.entrySet()) {
			sb.append(" | PLU - SysID = ").append(pluEntry.getKey()).append(", PLU = ").append(pluEntry.getValue().toString());
		}
		
		return sb.toString();
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (VendingIslandPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VendingIsland islandObj = (VendingIsland) obj;

		islandObj.setEnabled(this.isEnabled());
		islandObj.setLabel(this.getLabel());
		islandObj.setSysID(this.getSysID());
		islandObj.setFuelingPositionsList(this.getFuelingPositionsList());
		islandObj.setVendingPLUMap(this.getVendingPLUMap());
	}

	@Override
	public void validate() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPKValid() {
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + this.sysID;
		hash = 37 * hash + (this.label != null ? this.label.hashCode() : 0);
		hash = 37 * hash + (this.enabled ? 1 : 0);
		hash = 37 * hash + (this.fuelingPositionsList != null ? this.fuelingPositionsList.hashCode() : 0);
		hash = 37 * hash + (this.vendingPLUMap != null ? this.vendingPLUMap.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VendingIsland other = (VendingIsland) obj;
		if (this.sysID != other.sysID) {
			return false;
		}
		if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
			return false;
		}
		if (this.enabled != other.enabled) {
			return false;
		}
		if (this.fuelingPositionsList != other.fuelingPositionsList && (this.fuelingPositionsList == null || !this.fuelingPositionsList.equals(other.fuelingPositionsList))) {
			return false;
		}
		if (this.vendingPLUMap != other.vendingPLUMap && (this.vendingPLUMap == null || !this.vendingPLUMap.equals(other.vendingPLUMap))) {
			return false;
		}
		return true;
	}
}
