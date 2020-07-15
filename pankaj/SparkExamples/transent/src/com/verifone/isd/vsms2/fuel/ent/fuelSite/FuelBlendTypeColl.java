package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Collection class for the fuel blend type objects.
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelBlendTypeColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    private FuelBlendType[] blenders = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -5255157496664671179L;
    
    /**
     *  default constructor
     */
    FuelBlendTypeColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_BLENDTYPES];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelBlendType newBlender = ((FuelBlendType)newElements.nextElement());
            addElement(newBlender);
            newElemID[newElemCnt++] = newBlender.getID();
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelBlendType)elementAt(i)).getID();
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
                FuelBlendType remB = (FuelBlendType)get(allID[i]);
                if (remB != null) {
                    removeElement(remB);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_BLENDTYPES;
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
        if (blenders != null) {
            return blenders[index];
        }
        else {
            return null;
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    public Enumeration elements() {
        Vector list = new Vector();
        if (blenders != null) {
            for (int i = 0; i < blenders.length; i++) {
                list.addElement(blenders[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (blenders != null) {
            return blenders.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newB) {
        if (newB instanceof FuelBlendType) {
            int curSize = getCount();
            if (curSize == 0) {
                blenders = new FuelBlendType[1];
                blenders[0] = (FuelBlendType)newB;
            }
            else {
                FuelBlendType tmpB = (FuelBlendType) get(((FuelBlendType)newB).getID());
                if (tmpB == null) {
                    FuelBlendType[] newArr = new FuelBlendType[curSize+1];
                    
                    FuelBlendType tstB = null;
                    for (int i = 0; i < curSize; i++) {
                        tstB = (FuelBlendType)elementAt(i);
                        if (tstB.getID() > ((FuelBlendType)newB).getID()) {
                            System.arraycopy(blenders, 0, newArr, 0, i);
                            System.arraycopy(blenders, i, newArr, i+1, curSize-i);
                            newArr[i] = (FuelBlendType)newB;
                            blenders = newArr;
                            break;
                        }
                    }
                    tstB = (FuelBlendType) get(((FuelBlendType)newB).getID());
                    if (tstB == null) {
                        System.arraycopy(blenders, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelBlendType)newB;
                        blenders = newArr;
                    }
                }
                else {
                    tmpB.setName(((FuelBlendType)newB).getName());
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remB) {
        if (blenders != null) {
            for (int i = 0; i < blenders.length; i++) {
                if (blenders[i].getID() == ((FuelBlendType)remB).getID()) {
                    int j = blenders.length - i - 1;
                    FuelBlendType[] newArr = new FuelBlendType[blenders.length -1];
                    if (i > 0) {
                        System.arraycopy(blenders, 0, newArr, 0, i);
                    }
                    System.arraycopy(blenders, i + 1, newArr, i, j);
                    blenders = newArr;
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
        if (obj instanceof FuelBlendType) {
            if (blenders != null) {
                for (int i = 0; i < blenders.length; i++) {
                    if (blenders[i].getID() == ((FuelBlendType)obj).getID()) {
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
    
    public Object get(int ObjID) {
        if (blenders != null) {
            for (int i = 0; i < blenders.length; i++) {
                if (blenders[i].getID() == ObjID) {
                    return blenders[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to FuelBlendTypeColl objects for equality
	 * @param obj FuelBlendTypeColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelBlendTypeColl)) {
				return false;
			}
			FuelBlendTypeColl aBlendTypeColl = (FuelBlendTypeColl) obj;
			
			return new EqualsBuilder().append(this.blenders, aBlendTypeColl.blenders)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.blenders)
		  		  .toHashCode();
	}
}

