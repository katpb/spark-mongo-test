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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="mop" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="cat" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="nacstendercode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nacstendersubcode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "paymentName")
public class PaymentName {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "mop", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger mop;
    @XmlAttribute(name = "cat", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cat;
    @XmlAttribute(name = "nacstendercode")
    protected String nacstendercode;
    @XmlAttribute(name = "nacstendersubcode")
    protected String nacstendersubcode;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the mop property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMop() {
        return mop;
    }

    /**
     * Sets the value of the mop property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMop(BigInteger value) {
        this.mop = value;
    }

    /**
     * Gets the value of the cat property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCat() {
        return cat;
    }

    /**
     * Sets the value of the cat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCat(BigInteger value) {
        this.cat = value;
    }

    /**
     * Gets the value of the nacstendercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacstendercode() {
        return nacstendercode;
    }

    /**
     * Sets the value of the nacstendercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacstendercode(String value) {
        this.nacstendercode = value;
    }

    /**
     * Gets the value of the nacstendersubcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacstendersubcode() {
        return nacstendersubcode;
    }

    /**
     * Sets the value of the nacstendersubcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacstendersubcode(String value) {
        this.nacstendersubcode = value;
    }

}