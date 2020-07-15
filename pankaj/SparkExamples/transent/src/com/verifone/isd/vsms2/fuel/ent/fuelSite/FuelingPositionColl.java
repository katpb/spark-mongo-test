package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

/**
 *  Collection class for the fueling position objects. This is a singleton.
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelingPositionColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    
	private  Logger logger
            = LoggerFactory.getLogger(FuelingPositionColl.class);
    private Vector fuelingPositions = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = 163874544950903639L;
    
    /**
     *  default constructor
     */
    FuelingPositionColl() {
        fuelingPositions = new Vector();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    @Override
	public void setElements(Enumeration newElements) {
        int i;
        
        while (newElements.hasMoreElements()) {
            IFuelingPosition newPosn = ((IFuelingPosition)newElements.nextElement());
            addElement(newPosn);
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((IFuelingPosition)elementAt(i)).getID();
        }
        
        boolean found = false;
        for (i = 0; i < allID.length; i++) {
            found = false;
                if (allID[i] == -1) {
                    found = true;
                    break;
                }
            if (found == false) {
                IFuelingPosition remPosn = (IFuelingPosition)get(allID[i]);
                if (remPosn != null) {
                    removeElement(remPosn);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    @Override
	public int getMaximumSize() {
    	return IFuelSite.DEFAULT_MAX_POSITIONS;
    }
    
    /**
     *  No change taken in the current version
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#setMaximumSize(int)
     */
    @Override
	public void setMaximumSize(int maxSize) {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elementAt(int index)
     */
    @Override
	public Object elementAt(int index) {
        return fuelingPositions.elementAt(index);
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    @Override
	public Enumeration elements() {
        return fuelingPositions.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    @Override
	public int getCount() {
        return fuelingPositions.size();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    @Override
	public void addElement(Object nFP) {
    	if (nFP instanceof FuelingPosition) {
            FuelingPosition newFP = (FuelingPosition)nFP;
            FuelingPosition tmpPosn = (FuelingPosition) get(newFP.getID());
            if (tmpPosn == null) {
                int tmpSize = getCount();
                IFuelingPosition tstPosn = null;
                for (int i = 0; i < tmpSize; i++) {
                    tstPosn = (FuelingPosition)elementAt(i);
                    if (tstPosn.getID() > newFP.getID()) {
                        fuelingPositions.insertElementAt(newFP, i);
                        break;
                    }
                }
                tstPosn = (FuelingPosition)get(newFP.getID());
                if (tstPosn == null) {
                    fuelingPositions.addElement(newFP);
                }
            }
            else {
                try {
                    tmpPosn.setHoses(newFP.getHoses());
                    tmpPosn.setCurrencyLimit(newFP.getCurrencyLimit());
                    tmpPosn.setSlowFlowOffset(newFP.getSlowFlowOffset());
                    tmpPosn.setServiceLevel(newFP.getServiceLevel());
                    tmpPosn.setMOP(newFP.getMOP());
                    tmpPosn.setAttributes(newFP.getAttributes());
                    tmpPosn.setBlendType(newFP.getBlendType());
                    tmpPosn.setVolumeLimit(newFP.getVolumeLimit());
                    tmpPosn.setMinimumPPU(newFP.getMinimumPPU());
                    tmpPosn.setSpiIP(newFP.getSpiIP());
                    tmpPosn.setPrepayOnly(newFP.isPrepayOnly());
                    tmpPosn.setDcrInDispenser(newFP.isDcrInDispenser());
                    tmpPosn.setHandleUpCalling(newFP.isHandleUpCalling());
                    tmpPosn.setFullServicePresetAtPump(newFP.isFullServicePresetAtPump());
                    tmpPosn.setPayAtPumpOnly(newFP.isPayAtPumpOnly());
                }
                catch (FuelException e) {
                    logger.error("Caught Fuel Exception",e );
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    @Override
	public boolean removeElement(Object remFP) {
        int index = fuelingPositions.indexOf(remFP);
        
        if (index >= 0) {
            return fuelingPositions.removeElement(remFP);
        }
        else {
            return false;
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#indexOf(Object)
     */
    @Override
	public int indexOf(Object obj) {
        int index = -1;
        if (obj instanceof IFuelingPosition) {
            int count = fuelingPositions.size();
            for (int i = 0; i < count; i++) {
                IFuelingPosition cmpFP = (IFuelingPosition)fuelingPositions.elementAt(i);
                if (cmpFP.getID() == ((IFuelingPosition)obj).getID()) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#get(Object)
     */
    @Override
	public Object get(Object objID) {
        return this.get(((Integer)objID).intValue());
    }
    
    public Object get(int ObjID) {
        int count = fuelingPositions.size();
        for (int i = 0; i < count; i++) {
            IFuelingPosition cmpFP = (IFuelingPosition)fuelingPositions.elementAt(i);
            if (cmpFP.getID() == ObjID) {
                return cmpFP;
            }
        }
        return null;
    }
    
    /** Method to compare to FuelingPositionColl objects for equality
	 * @param obj FuelingPositionColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelingPositionColl)) {
				return false;
			}
			FuelingPositionColl aFuelingPositionColl = (FuelingPositionColl) obj;
			
			return new EqualsBuilder().append(this.fuelingPositions, aFuelingPositionColl.fuelingPositions)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.fuelingPositions)
		  		  .toHashCode();
	}
}
