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
 *         &lt;element ref="{}insideSales"/>
 *         &lt;element ref="{}insideGrand"/>
 *         &lt;element ref="{}outsideSales"/>
 *         &lt;element ref="{}outsideGrand"/>
 *         &lt;element ref="{}overallSales"/>
 *         &lt;element ref="{}overallGrand"/>
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
    "insideSales",
    "insideGrand",
    "outsideSales",
    "outsideGrand",
    "overallSales",
    "overallGrand"
})
@XmlRootElement(name = "endTotals")
public class EndTotals {

    @XmlElement(required = true)
    protected BigDecimal insideSales;
    @XmlElement(required = true)
    protected BigDecimal insideGrand;
    @XmlElement(required = true)
    protected BigDecimal outsideSales;
    @XmlElement(required = true)
    protected BigDecimal outsideGrand;
    @XmlElement(required = true)
    protected BigDecimal overallSales;
    @XmlElement(required = true)
    protected BigDecimal overallGrand;

    /**
     * Gets the value of the insideSales property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInsideSales() {
        return insideSales;
    }

    /**
     * Sets the value of the insideSales property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInsideSales(BigDecimal value) {
        this.insideSales = value;
    }

    /**
     * Gets the value of the insideGrand property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInsideGrand() {
        return insideGrand;
    }

    /**
     * Sets the value of the insideGrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInsideGrand(BigDecimal value) {
        this.insideGrand = value;
    }

    /**
     * Gets the value of the outsideSales property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOutsideSales() {
        return outsideSales;
    }

    /**
     * Sets the value of the outsideSales property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOutsideSales(BigDecimal value) {
        this.outsideSales = value;
    }

    /**
     * Gets the value of the outsideGrand property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOutsideGrand() {
        return outsideGrand;
    }

    /**
     * Sets the value of the outsideGrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOutsideGrand(BigDecimal value) {
        this.outsideGrand = value;
    }

    /**
     * Gets the value of the overallSales property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverallSales() {
        return overallSales;
    }

    /**
     * Sets the value of the overallSales property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverallSales(BigDecimal value) {
        this.overallSales = value;
    }

    /**
     * Gets the value of the overallGrand property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverallGrand() {
        return overallGrand;
    }

    /**
     * Sets the value of the overallGrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverallGrand(BigDecimal value) {
        this.overallGrand = value;
    }

}
