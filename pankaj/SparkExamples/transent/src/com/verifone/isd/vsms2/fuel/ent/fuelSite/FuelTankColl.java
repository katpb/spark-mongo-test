package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Collection class for the fuel tank objects. This is a singleton.
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelTankColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    private FuelTank[] tanks = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -1490924238376559554L;
    
    /**
     *  default constructor
     */
    FuelTankColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_TANKS];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelTank newTank = ((FuelTank)newElements.nextElement());
            int newID = newTank.getID();
            addElement(newTank);
            
            for (i = 0; i < newElemCnt; i++) {
                if (newElemID[i] == newID)
                    break;
            }
            if (i == newElemCnt)
                newElemID[newElemCnt++] = newID;
            
            int mfID = ((FuelTank)newTank).getManifoldID();
            if (mfID > 0) {
                FuelTank mfTank = (FuelTank)get(mfID);
                if (mfTank == null) {
                    mfTank = new FuelTank(mfID, "", 0);
                    addElement(mfTank);
                }
                for (i = 0;i < newElemCnt; i++) {
                    if (newElemID[i] == mfID)
                        break;
                }
                if (i == newElemCnt)
                    newElemID[newElemCnt++] = mfID;
            }
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelTank)elementAt(i)).getID();
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
                FuelTank remTank = (FuelTank)get(allID[i]);
                if (remTank != null) {
                    removeElement(remTank);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_TANKS;
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
        if (tanks != null) {
            return tanks[index];
        }
        return null;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    public Enumeration elements() {
        Vector list = new Vector();
        if (tanks != null) {
            for (int i = 0; i < tanks.length; i++) {
                list.addElement(tanks[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (tanks != null) {
            return tanks.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newTank) {
        if (newTank instanceof FuelTank) {
            int curSize = getCount();
            if (curSize == 0) {
                tanks = new FuelTank[1];
                tanks[0] = (FuelTank)newTank;
            }
            else {
                FuelTank tmpTank = (FuelTank)get(((FuelTank)newTank).getID());
                if (tmpTank == null) {
                    FuelTank[] newArr = new FuelTank[curSize+1];
                    
                    FuelTank tstTank = null;
                    for (int i = 0; i < curSize; i++) {
                        tstTank = (FuelTank)elementAt(i);
                        if (tstTank.getID() > ((FuelTank)newTank).getID()) {
                            System.arraycopy(tanks, 0, newArr, 0, i);
                            System.arraycopy(tanks, i, newArr, i+1, curSize-i);
                            newArr[i] = (FuelTank)newTank;
                            tanks = newArr;
                            break;
                        }
                    }
                    tstTank = (FuelTank) get(((FuelTank)newTank).getID());
                    if (tstTank == null) {
                        System.arraycopy(tanks, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelTank)newTank;
                        tanks = newArr;
                    }
                }
                else {
					tmpTank.setName(((FuelTank)newTank).getName());
					tmpTank.setManifoldID(((FuelTank)newTank).getManifoldID());
					tmpTank.setNAXAttributes((FuelTank)newTank);                      
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remTank) {
        if (tanks != null) {
            for (int i = 0; i < tanks.length; i++) {
                if (tanks[i].getID() == ((FuelTank)remTank).getID()) {
                    int j = tanks.length - i - 1;
                    FuelTank[] newArr = new FuelTank[tanks.length -1];
                    if (i > 0) {
                        System.arraycopy(tanks, 0, newArr, 0, i);
                    }
                    System.arraycopy(tanks, i + 1, newArr, i, j);
                    tanks = newArr;
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
        if (obj instanceof FuelTank) {
            if (tanks != null) {
                for (int i = 0; i < tanks.length; i++) {
                    if (tanks[i].getID() == ((FuelTank)obj).getID()) {
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
        if (tanks != null) {
            for (int i = 0; i < tanks.length; i++) {
                if (tanks[i].getID() == ObjID) {
                    return tanks[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to FuelTankColl objects for equality
	 * @param obj FuelTankColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelTankColl)) {
				return false;
			}
			FuelTankColl aTankColl = (FuelTankColl) obj;
			
			return new EqualsBuilder().append(this.tanks, aTankColl.tanks)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.tanks)
		  		  .toHashCode();
	}
}


