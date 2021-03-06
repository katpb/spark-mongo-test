//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for popCodesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="popCodesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="popCodeAutoGen" type="{}popCodeAutoGenType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numCodes" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="discDef" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "popCodesType", propOrder = {
    "popCodeAutoGen"
})
public class PopCodesType {

    protected List<PopCodeAutoGenType> popCodeAutoGen;
    @XmlAttribute(name = "numCodes")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numCodes;
    @XmlAttribute(name = "discDef")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger discDef;

    /**
     * Gets the value of the popCodeAutoGen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the popCodeAutoGen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPopCodeAutoGen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PopCodeAutoGenType }
     * 
     * 
     */
    public List<PopCodeAutoGenType> getPopCodeAutoGen() {
        if (popCodeAutoGen == null) {
            popCodeAutoGen = new ArrayList<PopCodeAutoGenType>();
        }
        return this.popCodeAutoGen;
    }

    /**
     * Gets the value of the numCodes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumCodes() {
        return numCodes;
    }

    /**
     * Sets the value of the numCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumCodes(BigInteger value) {
        this.numCodes = value;
    }

    /**
     * Gets the value of the discDef property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscDef() {
        return discDef;
    }

    /**
     * Sets the value of the discDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscDef(BigInteger value) {
        this.discDef = value;
    }

}
