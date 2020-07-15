//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}trlFeeNum"/>
 *         &lt;element ref="{}trlFeeAmount"/>
 *         &lt;element ref="{}trlFeeName"/>
 *         &lt;element ref="{}trlFeeDepNum"/>
 *         &lt;element ref="{}trlFeeDepName"/>
 *         &lt;element ref="{}trlFeeCat"/>
 *         &lt;element ref="{}trlFeeIdentifier" minOccurs="0"/>
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
    "trlFeeNum",
    "trlFeeAmount",
    "trlFeeName",
    "trlFeeDepNum",
    "trlFeeDepName",
    "trlFeeCat",
    "trlFeeIdentifier"
})
@XmlRootElement(name = "trlFee")
public class TrlFee {

    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger trlFeeNum;
    @XmlElement(required = true)
    protected BigDecimal trlFeeAmount;
    @XmlElement(required = true)
    protected String trlFeeName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger trlFeeDepNum;
    @XmlElement(required = true)
    protected String trlFeeDepName;
    @XmlElement(required = true)
    protected TrlFeeCat trlFeeCat;
    protected String trlFeeIdentifier;

    /**
     * Gets the value of the trlFeeNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrlFeeNum() {
        return trlFeeNum;
    }

    /**
     * Sets the value of the trlFeeNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrlFeeNum(BigInteger value) {
        this.trlFeeNum = value;
    }

    /**
     * Gets the value of the trlFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrlFeeAmount() {
        return trlFeeAmount;
    }

    /**
     * Sets the value of the trlFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrlFeeAmount(BigDecimal value) {
        this.trlFeeAmount = value;
    }

    /**
     * Gets the value of the trlFeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlFeeName() {
        return trlFeeName;
    }

    /**
     * Sets the value of the trlFeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlFeeName(String value) {
        this.trlFeeName = value;
    }

    /**
     * Gets the value of the trlFeeDepNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrlFeeDepNum() {
        return trlFeeDepNum;
    }

    /**
     * Sets the value of the trlFeeDepNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrlFeeDepNum(BigInteger value) {
        this.trlFeeDepNum = value;
    }

    /**
     * Gets the value of the trlFeeDepName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlFeeDepName() {
        return trlFeeDepName;
    }

    /**
     * Sets the value of the trlFeeDepName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlFeeDepName(String value) {
        this.trlFeeDepName = value;
    }

    /**
     * Gets the value of the trlFeeCat property.
     * 
     * @return
     *     possible object is
     *     {@link TrlFeeCat }
     *     
     */
    public TrlFeeCat getTrlFeeCat() {
        return trlFeeCat;
    }

    /**
     * Sets the value of the trlFeeCat property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrlFeeCat }
     *     
     */
    public void setTrlFeeCat(TrlFeeCat value) {
        this.trlFeeCat = value;
    }

    /**
     * Gets the value of the trlFeeIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlFeeIdentifier() {
        return trlFeeIdentifier;
    }

    /**
     * Sets the value of the trlFeeIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlFeeIdentifier(String value) {
        this.trlFeeIdentifier = value;
    }

}
