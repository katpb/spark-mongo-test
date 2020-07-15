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
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trCshBkAmt" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
 *                 &lt;attribute name="mop" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="cat" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="trCshBkFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="trCshBkCancel" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    "trCshBkAmt",
    "trCshBkFee",
    "trCshBkCancel"
})
@XmlRootElement(name = "trCshBk")
public class TrCshBk {

    protected TrCshBk.TrCshBkAmt trCshBkAmt;
    protected BigDecimal trCshBkFee;
    protected BigDecimal trCshBkCancel;

    /**
     * Gets the value of the trCshBkAmt property.
     * 
     * @return
     *     possible object is
     *     {@link TrCshBk.TrCshBkAmt }
     *     
     */
    public TrCshBk.TrCshBkAmt getTrCshBkAmt() {
        return trCshBkAmt;
    }

    /**
     * Sets the value of the trCshBkAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrCshBk.TrCshBkAmt }
     *     
     */
    public void setTrCshBkAmt(TrCshBk.TrCshBkAmt value) {
        this.trCshBkAmt = value;
    }

    /**
     * Gets the value of the trCshBkFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrCshBkFee() {
        return trCshBkFee;
    }

    /**
     * Sets the value of the trCshBkFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrCshBkFee(BigDecimal value) {
        this.trCshBkFee = value;
    }

    /**
     * Gets the value of the trCshBkCancel property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrCshBkCancel() {
        return trCshBkCancel;
    }

    /**
     * Sets the value of the trCshBkCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrCshBkCancel(BigDecimal value) {
        this.trCshBkCancel = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *       &lt;attribute name="mop" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="cat" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
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
    public static class TrCshBkAmt {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(name = "mop", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger mop;
        @XmlAttribute(name = "cat", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger cat;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
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

    }

}