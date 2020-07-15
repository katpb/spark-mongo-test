package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Collection class for the fuel MOP objects. 
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelMOPColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    private FuelMOP[] MOPs = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -7543448515936341642L;
    
    /**
     *  default constructor
     */
    FuelMOPColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_MOPS];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelMOP newMOP = ((FuelMOP)newElements.nextElement());
            addElement(newMOP);
            newElemID[newElemCnt++] = newMOP.getID();
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelMOP)elementAt(i)).getID();
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
                FuelMOP remMOP = (FuelMOP)get(allID[i]);
                if (remMOP != null) {
                    removeElement(remMOP);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_MOPS;
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
        if (MOPs != null) {
            return MOPs[index];
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
        if (MOPs != null) {
            for (int i = 0; i < MOPs.length; i++) {
                list.addElement(MOPs[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (MOPs != null) {
            return MOPs.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newMOP) {
        if (newMOP instanceof FuelMOP) {
            int curSize = getCount();
            if (curSize == 0) {
                MOPs = new FuelMOP[1];
                MOPs[0] = (FuelMOP)newMOP;
            }
            else {
                FuelMOP tmpMOP = (FuelMOP) get(((FuelMOP)newMOP).getID());
                if (tmpMOP == null) {
                    FuelMOP[] newArr = new FuelMOP[curSize+1];
                    
                    FuelMOP tstMOP = null;
                    for (int i = 0; i < curSize; i++) {
                        tstMOP = (FuelMOP)elementAt(i);
                        if (tstMOP.getID() > ((FuelMOP)newMOP).getID()) {
                            System.arraycopy(MOPs, 0, newArr, 0, i);
                            System.arraycopy(MOPs, i, newArr, i+1, curSize-i);
                            newArr[i] = (FuelMOP)newMOP;
                            MOPs = newArr;
                            break;
                        }
                    }
                    tstMOP = (FuelMOP) get(((FuelMOP)newMOP).getID());
                    if (tstMOP == null) {
                        System.arraycopy(MOPs, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelMOP)newMOP;
                        MOPs = newArr;
                    }
                }
                else {
                    tmpMOP.setName(((FuelMOP)newMOP).getName());
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remMOP) {
        if (MOPs != null) {
            for (int i = 0; i < MOPs.length; i++) {
                if (MOPs[i].getID() == ((FuelMOP)remMOP).getID()) {
                    int j = MOPs.length - i - 1;
                    FuelMOP[] newArr = new FuelMOP[MOPs.length -1];
                    if (i > 0) {
                        System.arraycopy(MOPs, 0, newArr, 0, i);
                    }
                    System.arraycopy(MOPs, i + 1, newArr, i, j);
                    MOPs = newArr;
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
        if (obj instanceof FuelMOP) {
            if (MOPs != null) {
                for (int i = 0; i < MOPs.length; i++) {
                    if (MOPs[i].getID() == ((FuelMOP)obj).getID()) {
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
        if (MOPs != null) {
            for (int i = 0; i < MOPs.length; i++) {
                if (MOPs[i].getID() == ObjID) {
                    return MOPs[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to FuelMOPColl objects for equality
	 * @param obj FuelMOPColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelMOPColl)) {
				return false;
			}
			FuelMOPColl aMOPColl = (FuelMOPColl) obj;
			
			return new EqualsBuilder().append(this.MOPs, aMOPColl.MOPs)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.MOPs)
		  		  .toHashCode();
	}
}
