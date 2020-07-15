//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *     &lt;extension base="{}trTickNum">
 *       &lt;attribute name="transType" type="{}recallTransactionType" default="sale" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "trRecall")
public class TrRecall
    extends TrTickNum
{

    @XmlAttribute(name = "transType")
    protected RecallTransactionType transType;

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link RecallTransactionType }
     *     
     */
    public RecallTransactionType getTransType() {
        if (transType == null) {
            return RecallTransactionType.SALE;
        } else {
            return transType;
        }
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecallTransactionType }
     *     
     */
    public void setTransType(RecallTransactionType value) {
        this.transType = value;
    }

}