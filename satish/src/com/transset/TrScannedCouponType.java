//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trScannedCouponType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trScannedCouponType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="couponDisc" type="{}couponDiscountType" maxOccurs="unbounded"/>
 *         &lt;element name="couponDiscTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trScannedCouponType", propOrder = {
    "couponDisc",
    "couponDiscTotal"
})
public class TrScannedCouponType {

    @XmlElement(required = true)
    protected List<CouponDiscountType> couponDisc;
    @XmlElement(required = true)
    protected BigDecimal couponDiscTotal;

    /**
     * Gets the value of the couponDisc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the couponDisc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCouponDisc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CouponDiscountType }
     * 
     * 
     */
    public List<CouponDiscountType> getCouponDisc() {
        if (couponDisc == null) {
            couponDisc = new ArrayList<CouponDiscountType>();
        }
        return this.couponDisc;
    }

    /**
     * Gets the value of the couponDiscTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCouponDiscTotal() {
        return couponDiscTotal;
    }

    /**
     * Sets the value of the couponDiscTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCouponDiscTotal(BigDecimal value) {
        this.couponDiscTotal = value;
    }

}
