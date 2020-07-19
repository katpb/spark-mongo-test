//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}cashier"/>
 *         &lt;element ref="{}trpAmt"/>
 *         &lt;element ref="{}trTickNum"/>
 *         &lt;element ref="{}trMiscRefNum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cashier",
    "trpAmt",
    "trTickNum",
    "trMiscRefNum"
})
@XmlRootElement(name = "originalSafeDropInfo")
public class OriginalSafeDropInfo {

    @XmlElement(required = true)
    protected BaseCashierType cashier;
    @XmlElement(required = true)
    protected BigDecimal trpAmt;
    @XmlElement(required = true)
    protected TrTickNum trTickNum;
    protected String trMiscRefNum;

    /**
     * Gets the value of the cashier property.
     * 
     * @return
     *     possible object is
     *     {@link BaseCashierType }
     *     
     */
    public BaseCashierType getCashier() {
        return cashier;
    }

    /**
     * Sets the value of the cashier property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseCashierType }
     *     
     */
    public void setCashier(BaseCashierType value) {
        this.cashier = value;
    }

    /**
     * Gets the value of the trpAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrpAmt() {
        return trpAmt;
    }

    /**
     * Sets the value of the trpAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrpAmt(BigDecimal value) {
        this.trpAmt = value;
    }

    /**
     * Gets the value of the trTickNum property.
     * 
     * @return
     *     possible object is
     *     {@link TrTickNum }
     *     
     */
    public TrTickNum getTrTickNum() {
        return trTickNum;
    }

    /**
     * Sets the value of the trTickNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrTickNum }
     *     
     */
    public void setTrTickNum(TrTickNum value) {
        this.trTickNum = value;
    }

    /**
     * Gets the value of the trMiscRefNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrMiscRefNum() {
        return trMiscRefNum;
    }

    /**
     * Sets the value of the trMiscRefNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrMiscRefNum(String value) {
        this.trMiscRefNum = value;
    }

}