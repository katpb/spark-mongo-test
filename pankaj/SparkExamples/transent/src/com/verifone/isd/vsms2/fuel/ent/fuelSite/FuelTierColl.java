package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

/**
 *  Collection class for the fuel tier objects. This is a singleton.
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelTierColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    
	private Logger logger = LoggerFactory.getLogger(FuelTierColl.class);
    private FuelTier[] tiers = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -5883145243812885714L;
    
    /**
     *  default constructor
     */
    FuelTierColl() {
    }

    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_TIERS];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelTier newTier = ((FuelTier)newElements.nextElement());
            addElement(newTier);
            newElemID[newElemCnt++] = newTier.getID();
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelTier)elementAt(i)).getID();
        }
        
        boolean found = false;
        for (i = 0; i < allID.length; i++) {
            found = false;
            for (int j = 0; j < newElemID.length; j++) {
                if (allID[i] == newElemID[j]) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                FuelTier remTier = (FuelTier)get(allID[i]);
                if (remTier != null) {
                    removeElement(remTier);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_TIERS;
    }
    
    /**
     *  No change taken in the current version
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#setMaximumSize(int)
     */
    public void setMaximumSize(int maxSize) {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elementAt(int index)
     */
    public Object elementAt(int index) {
        if (tiers != null) {
            return tiers[index];
        }
        return null;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    public Enumeration elements() {
        Vector list = new Vector();
        if (tiers != null) {
            for (int i = 0; i < tiers.length; i++) {
                list.addElement(tiers[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (tiers != null) {
            return tiers.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newTier) {
        if (newTier instanceof FuelTier) {
            int curSize = getCount();
            if (curSize == 0) {
                tiers = new FuelTier[1];
                tiers[0] = (FuelTier)newTier;
            }
            else {
                FuelTier tmpTier = (FuelTier)get(((FuelTier)newTier).getID());
                if (tmpTier == null) {
                    FuelTier[] newArr = new FuelTier[curSize+1];
                    
                    FuelTier tstTier = null;
                    for (int i = 0; i < curSize; i++) {
                        tstTier = (FuelTier)elementAt(i);
                        if (tstTier.getID() > ((FuelTier)newTier).getID()) {
                            System.arraycopy(tiers, 0, newArr, 0, i);
                            System.arraycopy(tiers, i, newArr, i+1, curSize-i);
                            newArr[i] = (FuelTier)newTier;
                            tiers = newArr;
                            break;
                        }
                    }
                    tstTier = (FuelTier) get(((FuelTier)newTier).getID());
                    if (tstTier == null) {
                        System.arraycopy(tiers, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelTier)newTier;
                        tiers = newArr;
                    }
                }
                else {
                    try {
                        tmpTier.setStartHour(((FuelTier)newTier).getStartHour());
                        tmpTier.setEffectiveHours(((FuelTier)newTier).getEffectiveHours());
                    }
                    catch (FuelException e) {
                        logger.error("FuelTierColl: addElement "+e.toString());
                    }
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remTier) {
        if (tiers != null) {
            for (int i = 0; i < tiers.length; i++) {
                if (tiers[i].getID() == ((FuelTier)remTier).getID()) {
                    int j = tiers.length - i - 1;
                    FuelTier[] newArr = new FuelTier[tiers.length -1];
                    System.arraycopy(tiers, 0, newArr, 0, i);
                    if(j > 0)
                    {
                    System.arraycopy(tiers, i + 1, newArr, i, j);
                    }
                    tiers = newArr;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#indexOf(Object)
     */
    public int indexOf(Object obj) {
        int index = -1;
        if (obj instanceof FuelTier) {
            if (tiers != null) {
                for (int i = 0; i < tiers.length; i++) {
                    if (tiers[i].getID() == ((FuelTier)obj).getID()) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#get(Object)
     */
    public Object get(Object objID) {
        return this.get(((Integer)objID).intValue());
    }
    
    /**
     * Get tiers which the id matches ObjID
     * @param ObjID
     * @return Object
     */
    public Object get(int ObjID) {
        if (tiers != null) {
            for (int i = 0; i < tiers.length; i++) {
                if (tiers[i].getID() == ObjID) {
                    return tiers[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to FuelTierColl objects for equality
	 * @param obj FuelTierColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelTierColl)) {
				return false;
			}
			FuelTierColl aTierColl = (FuelTierColl) obj;
			
			return new EqualsBuilder().append(this.tiers, aTierColl.tiers)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.tiers)
		  		  .toHashCode();
	}
}

