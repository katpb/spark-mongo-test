package com.verifone.isd.vsms2.sales.ent.plupromo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

import java.util.Date;
import java.io.Serializable;
import org.xml.sax.SAXException;

/** Entity class for PLU promo
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class PluPromo implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = 4025598508392822579L;
    //Max Ruby value 99.99
    private static final int MAX_DISC = 9999;
    /** Number of decimals in Quantity / MoneyAmount classes used */    
    public static final int NUM_DECIMALS = 2;
    
    private PluPK ID;
    private Date startDate;
    private Date endDate;
    private Quantity discount;
    private CarWashPromoProperties cwProps;
    
    /** Constructor
     * @param ID ID for the PLU promo
     */    
    public PluPromo(PluPK ID) {
        this.ID = ID;
    }
    
    /** No-args constructor */    
    public PluPromo() {
        this(null);
    }
    
    /** Getter for startDate property
     * @return startDate property
     */    
    public Date getStartDate() {
        return this.startDate;
    }
    
    /** Setter for startDate property
     * @param start new startDate property value
     */    
    public void setStartDate(Date start) {
        this.startDate = start;
    }
    
    /** Getter for endDate property
     * @return endDate property value
     */    
    public Date getEndDate() {
        return this.endDate;
    }
    
    /** Setter for endDate property
     * @param end new endDate property value
     */    
    public void setEndDate(Date end) {
        this.endDate = end;
    }
    
    /** Getter for discount property
     * @return discount property value
     */    
    public Quantity getDiscount() {
        return this.discount;
    }
    
    /** Setter for discount property
     * @param disc new discount property value
     */    
    public void setDiscount(Quantity disc) {
        this.discount = disc;
    }
    
    /** Getter for carwash PLU Promo properties
     * @return carwash PLU Promo properties
     */    
    public CarWashPromoProperties getCarWashProps() {
        return this.cwProps;
    }
    
    /** Setter for carwash PLU Promo properties
     * @param newProp new carwash PLU Promo properties
     */    
    public void setCarWashProps(CarWashPromoProperties newProp) {
        this.cwProps = newProp;
    }
    
    /*
    public void accept(DataSetXMLVisitor v) throws SAXException {
        v.visit(this);
    }
    */
    /** Validator for entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid PLUPromo: " +this.ID);            
        }
        this.validateDiscount();
        if (this.cwProps != null) {
            try {
                this.cwProps.validate();
            }
            catch (Exception e) {
                throw new Exception("PLUPromo: " +this.ID +" validation error - " +e.getMessage());
            }
        }
    }
    
    private void validateDiscount() throws Exception {
        if (this.discount != null) {
            if ((!(this.discount instanceof MoneyAmount)) && (!(this.discount.getUOM().equals("%"))))
                throw new Exception("PLUPromo " +this.ID +": Invalid discount type");
            long disc = this.discount.getLongValue();
            if ((disc < 0) || (disc > MAX_DISC))
                throw new Exception("Invalid discount: " +discount.toString()
                +" for PLUPromo: " +this.ID);
        }
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;        
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();          
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        PluPromo pObj = (PluPromo) obj;
        pObj.setPK(this.getPK());
        pObj.setStartDate(this.getStartDate());
        pObj.setEndDate(this.getEndDate());
        pObj.setDiscount(this.getDiscount());
        pObj.setCarWashProps(this.getCarWashProps());        
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (PluPK)pk;        
    }
    
    /** Implementation method fo visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }        
}