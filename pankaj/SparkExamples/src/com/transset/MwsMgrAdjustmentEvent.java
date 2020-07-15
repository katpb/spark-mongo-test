//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}trHeader"/>
 *         &lt;element name="adjustedCashier" type="{}cashierType"/>
 *         &lt;element ref="{}amount"/>
 *         &lt;element name="periodType" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="periodSeq" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="periodCloseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{}mgrAdjustmentType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trHeader",
    "adjustedCashier",
    "amount",
    "periodType",
    "periodSeq",
    "periodCloseDate"
})
@XmlRootElement(name = "mwsMgrAdjustmentEvent")
public class MwsMgrAdjustmentEvent {

    @XmlElement(required = true)
    protected TrHeaderType trHeader;
    @XmlElement(required = true)
    protected CashierType adjustedCashier;
    @XmlElement(required = true)
    protected Amount amount;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger periodType;
    @XmlSchemaType(name = "unsignedInt")
    protected Long periodSeq;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodCloseDate;
    @XmlAttribute(name = "type", required = true)
    protected MgrAdjustmentType type;

    /**
     * Gets the value of the trHeader property.
     * 
     * @return
     *     possible object is
     *     {@link TrHeaderType }
     *     
     */
    public TrHeaderType getTrHeader() {
        return trHeader;
    }

    /**
     * Sets the value of the trHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrHeaderType }
     *     
     */
    public void setTrHeader(TrHeaderType value) {
        this.trHeader = value;
    }

    /**
     * Gets the value of the adjustedCashier property.
     * 
     * @return
     *     possible object is
     *     {@link CashierType }
     *     
     */
    public CashierType getAdjustedCashier() {
        return adjustedCashier;
    }

    /**
     * Sets the value of the adjustedCashier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashierType }
     *     
     */
    public void setAdjustedCashier(CashierType value) {
        this.adjustedCashier = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setAmount(Amount value) {
        this.amount = value;
    }

    /**
     * Gets the value of the periodType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodType() {
        return periodType;
    }

    /**
     * Sets the value of the periodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodType(BigInteger value) {
        this.periodType = value;
    }

    /**
     * Gets the value of the periodSeq property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPeriodSeq() {
        return periodSeq;
    }

    /**
     * Sets the value of the periodSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPeriodSeq(Long value) {
        this.periodSeq = value;
    }

    /**
     * Gets the value of the periodCloseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodCloseDate() {
        return periodCloseDate;
    }

    /**
     * Sets the value of the periodCloseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodCloseDate(XMLGregorianCalendar value) {
        this.periodCloseDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link MgrAdjustmentType }
     *     
     */
    public MgrAdjustmentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link MgrAdjustmentType }
     *     
     */
    public void setType(MgrAdjustmentType value) {
        this.type = value;
    }

}