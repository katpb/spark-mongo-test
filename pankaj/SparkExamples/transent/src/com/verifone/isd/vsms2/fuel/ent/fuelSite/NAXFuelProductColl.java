package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;

import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Collection class for the NAX fuel product objects. This is a singleton.
 *
 *  @see ISapphireCollection
 *
 */
class NAXFuelProductColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    private NAXFuelProduct[] products = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -7218579848097593291L;
    
    /**
     *  default constructor
     */
    NAXFuelProductColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_TANKS]; //MAX_TANKS usage is intentional
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            NAXFuelProduct newProduct = ((NAXFuelProduct)newElements.nextElement());
            int newID = newProduct.getID();
            addElement(newProduct);
            newElemCnt++;
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((NAXFuelProduct)elementAt(i)).getID();
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
                NAXFuelProduct remProduct = (NAXFuelProduct)get(allID[i]);
                if (remProduct != null) {
                    removeElement(remProduct);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    public int getMaximumSize() {
        return IFuelSite.MAX_TANKS; //MAX_TANKS usage is intentional
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
        if (products != null) {
            return products[index];
        }
        return null;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    public Enumeration elements() {
        Vector list = new Vector();
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                list.addElement(products[i]);
            }
        }
        return list.elements();
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getCount()
     */
    public int getCount() {
        if (products != null) {
            return products.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    public void addElement(Object newProduct) {
        if (newProduct instanceof NAXFuelProduct) {
            int curSize = getCount();
            if (curSize == 0) {
                products = new NAXFuelProduct[1];
                products[0] = (NAXFuelProduct)newProduct;
            }
            else {
                NAXFuelProduct tmpProduct = (NAXFuelProduct)get(((NAXFuelProduct)newProduct).getID());
                if (tmpProduct == null) {
                    NAXFuelProduct[] newArr = new NAXFuelProduct[curSize+1];
                    
                    NAXFuelProduct tstProduct = null;
                    for (int i = 0; i < curSize; i++) {
                        tstProduct = (NAXFuelProduct)elementAt(i);
                        if (tstProduct.getID() > ((NAXFuelProduct)newProduct).getID()) {
                            System.arraycopy(products, 0, newArr, 0, i);
                            System.arraycopy(products, i, newArr, i+1, curSize-i);
                            newArr[i] = (NAXFuelProduct)newProduct;
                            products = newArr;
                            break;
                        }
                    }
                    tstProduct = (NAXFuelProduct) get(((NAXFuelProduct)newProduct).getID());
                    if (tstProduct == null) {
                        System.arraycopy(products, 0, newArr, 0, curSize);
                        newArr[curSize] = (NAXFuelProduct)newProduct;
                        products = newArr;
                    }
                }
                else {
                    tmpProduct.setName(((NAXFuelProduct)newProduct).getName());
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    public boolean removeElement(Object remProduct) {
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                if (products[i].getID() == ((NAXFuelProduct)remProduct).getID()) {
                    int j = products.length - i - 1;
                    NAXFuelProduct[] newArr = new NAXFuelProduct[products.length -1];
                    if (i > 0) {
                        System.arraycopy(products, 0, newArr, 0, i);
                    }
                    System.arraycopy(products, i + 1, newArr, i, j);
                    products = newArr;
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
        if (obj instanceof NAXFuelProduct) {
            if (products != null) {
                for (int i = 0; i < products.length; i++) {
                    if (products[i].getID() == ((NAXFuelProduct)obj).getID()) {
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
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                if (products[i].getID() == ObjID) {
                    return products[i];
                }
            }
        }
        return null;
    }
    
    /** Method to compare to NAXFuelProductColl objects for equality
	 * @param obj NAXFuelProductColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof NAXFuelProductColl)) {
				return false;
			}
			NAXFuelProductColl aNaxFuelProductColl = (NAXFuelProductColl) obj;
			
			return new EqualsBuilder().append(this.products, aNaxFuelProductColl.products)
									   .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.products)
		  		  .toHashCode();
	}
}


