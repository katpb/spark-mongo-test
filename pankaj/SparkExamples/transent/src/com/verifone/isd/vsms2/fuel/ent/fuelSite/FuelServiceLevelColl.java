package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Collection class for the fuel service level objects. 
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelServiceLevelColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    private FuelServiceLevel[] serviceLevels = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    //static final long serialVersionUID = 4775753583211344904L;
    
    /**
     *  default constructor
     */
    FuelServiceLevelColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_SERVICELEVELS];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelServiceLevel newSL = ((FuelServiceLevel)newElements.nextElement());
            addElement(newSL);
            newElemID[newElemCnt++] = newSL.getID();
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelServiceLevel)elementAt(i)).getID();
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
                FuelServiceLevel remSL = (FuelServiceLevel)get(allID[i]);
                if (remSL != null) {
                    removeElement(remSL);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_SERVICELEVELS;
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
        if (serviceLevels != null) {
            return serviceLevels[index];
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
        if (serviceLevels != null) {
            for (int i = 0; i < serviceLevels.length; i++) {
                list.addElement(serviceLevels[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (serviceLevels != null) {
            return serviceLevels.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newSL) throws ArrayIndexOutOfBoundsException {
        if (newSL instanceof FuelServiceLevel) {
            int curSize = getCount();
            if (curSize == 0) {
                serviceLevels = new FuelServiceLevel[1];
                serviceLevels[0] = (FuelServiceLevel)newSL;
            }
            else {
                FuelServiceLevel tmpSL = (FuelServiceLevel) get(((FuelServiceLevel)newSL).getID());
                if (tmpSL == null) {
                    FuelServiceLevel[] newArr = new FuelServiceLevel[curSize+1];
                    
                    FuelServiceLevel tstSL = null;
                    for (int i = 0; i < curSize; i++) {
                        tstSL = (FuelServiceLevel)elementAt(i);
                        if (tstSL.getID() > ((FuelServiceLevel)newSL).getID()) {
                            System.arraycopy(serviceLevels, 0, newArr, 0, i);
                            System.arraycopy(serviceLevels, i, newArr, i+1, curSize-i);
                            newArr[i] = (FuelServiceLevel)newSL;
                            serviceLevels = newArr;
                            break;
                        }
                    }
                    tstSL = (FuelServiceLevel) get(((FuelServiceLevel)newSL).getID());
                    if (tstSL == null) {
                        System.arraycopy(serviceLevels, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelServiceLevel)newSL;
                        serviceLevels = newArr;
                    }
                }
                else {
                    tmpSL.setName(((FuelServiceLevel)newSL).getName());
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remSL) {
        if (serviceLevels != null) {
            for (int i = 0; i < serviceLevels.length; i++) {
                if (serviceLevels[i].getID() == ((FuelServiceLevel)remSL).getID()) {
                    int j = serviceLevels.length - i - 1;
                    FuelServiceLevel[] newArr = new FuelServiceLevel[serviceLevels.length -1];
                    if (i > 0) {
                        System.arraycopy(serviceLevels, 0, newArr, 0, i);
                    }
                    System.arraycopy(serviceLevels, i + 1, newArr, i, j);
                    serviceLevels = newArr;
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
        if (obj instanceof FuelServiceLevel) {
            if (serviceLevels != null) {
                for (int i = 0; i < serviceLevels.length; i++) {
                    if (serviceLevels[i].getID() == ((FuelServiceLevel)obj).getID()) {
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
        if (serviceLevels != null) {
            for (int i = 0; i < serviceLevels.length; i++) {
                if (serviceLevels[i].getID() == ObjID) {
                    return serviceLevels[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to FuelServiceLevelColl objects for equality
	 * @param obj FuelServiceLevelColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelServiceLevelColl)) {
				return false;
			}
			FuelServiceLevelColl aServiceLevelColl = (FuelServiceLevelColl) obj;
			
			return new EqualsBuilder().append(this.serviceLevels, aServiceLevelColl.serviceLevels)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.serviceLevels)
		  		  .toHashCode();
	}
}

