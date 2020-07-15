/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.couponcfg;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Coupon site configuration.
 * @author ashutosh_b1
 * 
 */
public class CouponConfig implements IEntityObject, ISalesEntityVisitable {

    private static final long serialVersionUID = 7742061106028949067L;

    private CouponConfigPK pk;
    private CouponProcessingLevel processingLevel;
    private boolean allowNegativeTransTotal;

    public CouponConfig() {
    }

    public boolean isPKValid() {
        if (this.pk == null) {
            this.pk = new CouponConfigPK();
        }
        return this.pk.isValid();
    }

    public void setAttributes(IEntityObject obj) {
        CouponConfig lObj = (CouponConfig) obj;
        lObj.pk = this.pk;
        lObj.processingLevel = this.processingLevel;
        lObj.allowNegativeTransTotal = this.allowNegativeTransTotal;
    }

    /**
     * Validates an entity object's attributes.
     * @throws Exception If validation fails.
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid CouponConfig: " + this.pk);
        }
    }

    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }

    /**
     * Return a reference to the IEntityPk.
     * @return A reference to the IEntityPK.
     */
    public IEntityPK getPK() {
        return this.pk;
    }

    /**
     * Set the primary key.
     * @param pk The primary key value.
     */
    public void setPK(IEntityPK pk) {
        this.pk = (CouponConfigPK) pk;
    }

    /**
     * @return the supportedLevel
     */
    public CouponProcessingLevel getProcessingLevel() {
        return processingLevel;
    }

    /**
     * @param supportedLevel the supportedLevel to set
     */
    public void setProcessingLevel(CouponProcessingLevel processingLevel) {
        this.processingLevel = processingLevel;
    }

    /**
     * @return the allowNegativeTransTotal
     */
    public boolean isAllowNegativeTransTotal() {
        return allowNegativeTransTotal;
    }

    /**
     * @param allowNegativeTransTotal the allowNegativeTransTotal to set
     */
    public void setAllowNegativeTransTotal(boolean allowNegativeTransTotal) {
        this.allowNegativeTransTotal = allowNegativeTransTotal;
    }
}
