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
 *  Collection class for the fuel product objects. 
 *
 *  @see ISapphireCollection
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
class FuelProductColl implements ISapphireCollection, ISapphireCollectionCtrl, Serializable {
    
	private  Logger logger  = LoggerFactory.getLogger(FuelProductColl.class);
    private FuelProduct[] products = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -8339778347269578445L;
    
    /**
     *  default constructor
     */
    FuelProductColl() {
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl#setElements(Enumeration)
     */
    @Override
    public void setElements(Enumeration newElements) {
        int[] newElemID = new int[IFuelSite.MAX_PRODUCTS];
        int i, newElemCnt = 0;
        
        for (i = 0; i < newElemID.length; i++) {
            newElemID[i] = -1;
        }
        
        while (newElements.hasMoreElements()) {
            FuelProduct newProd = ((FuelProduct)newElements.nextElement());
            addElement(newProd);
            newElemID[newElemCnt++] = newProd.getID();
        }
        
        int currCollSize = getCount();
        int[] allID = new int[currCollSize];
        
        for (i = 0; i < allID.length; i++) {
            allID[i]= ((FuelProduct)elementAt(i)).getID();
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
                FuelProduct remProd = (FuelProduct)get(allID[i]);
                if (remProd != null) {
                    removeElement(remProd);
                }
            }
        }
    }
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#getMaximumSize()
     */
    @Override
    public int getMaximumSize() {
        return IFuelSite.MAX_PRODUCTS;
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
        if (products != null) {
            return products[index];
        }
        else {
            return null;
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#elements()
     */
    @Override
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
    @Override
    public int getCount() {
        if (products != null) {
            return products.length;
        }
        return 0;
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#addElement(Object)
     */
    @Override
    public void addElement(Object nProd) {
        if (nProd instanceof FuelProduct) {
            FuelProduct newProd = (FuelProduct)nProd;
            int curSize = getCount();
            if (curSize == 0) {
                products = new FuelProduct[1];
                products[0] = newProd;
            }
            else {
                FuelProduct tmpProd = (FuelProduct) get(newProd.getID());
                if (tmpProd == null) {
                    FuelProduct[] newArr = new FuelProduct[curSize+1];
                    
                    FuelProduct tstProd = null;
                    for (int i = 0; i < curSize; i++) {
                        tstProd = (FuelProduct)elementAt(i);
                        if (tstProd.getID() > newProd.getID()) {
                            System.arraycopy(products, 0, newArr, 0, i);
                            System.arraycopy(products, i, newArr, i+1, curSize-i);
                            newArr[i] = newProd;
                            products = newArr;
                            break;
                        }
                    }
                    tstProd = (FuelProduct) get(newProd.getID());
                    if (tstProd == null) {
                        System.arraycopy(products, 0, newArr, 0, curSize);
                        newArr[curSize] = (FuelProduct)newProd;
                        products = newArr;
                    }
                }
                else {
                    try {
                        tmpProd.setName(newProd.getName());
			tmpProd.setPPUDecPosition(newProd.getPpuDecPosition());
                        tmpProd.setPrices(newProd.getLongPrices());
                        tmpProd.setTanks(newProd.getTanks());
                        tmpProd.setDepartmentNum(newProd.getDepartmentNum());
                        tmpProd.setProdCodeNum(newProd.getProdCodeNum());
                        tmpProd.setProdNum(newProd.getProdNum());
                    }
                    catch (FuelException e) {
                        logger.error("exception "+e.getClass().getName()+" "+e.getMessage());
                    }
                }
            }
        }
    }
    
    /**
     *  @see com.verifone.isd.vsms2.sys.util.ISapphireCollection#removeElement(Object)
     */
    @Override
    public boolean removeElement(Object remProd) {
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                if (products[i].getID() == ((FuelProduct)remProd).getID()) {
                    int j = products.length - i - 1;
                    FuelProduct[] newArr = new FuelProduct[products.length -1];
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
    @Override
    public int indexOf(Object obj) {
        int index = -1;
        if (obj instanceof FuelProduct) {
            if (products != null) {
                for (int i = 0; i < products.length; i++) {
                    if (products[i].getID() == ((FuelProduct)obj).getID()) {
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
    @Override
    public Object get(Object objID) {
        return this.get(((Integer)objID).intValue());
    }
    
    /**
     * Get FuelProduct with Id ObjID 
     * @param ObjID
     * @return Object
     */
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
    
    /** Method to compare to FuelProductColl objects for equality
	 * @param obj FuelProductColl object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelProductColl)) {
				return false;
			}
			FuelProductColl aProductColl = (FuelProductColl) obj;
			
			return new EqualsBuilder().append(this.products, aProductColl.products)
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
