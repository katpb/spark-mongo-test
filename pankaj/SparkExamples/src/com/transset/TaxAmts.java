//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * tax amounts
 * 
 * <p>Java class for taxAmts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taxAmts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}taxAmt" minOccurs="0"/>
 *         &lt;element ref="{}taxRate" minOccurs="0"/>
 *         &lt;element ref="{}taxNet" minOccurs="0"/>
 *         &lt;element ref="{}taxInTot" minOccurs="0"/>
 *         &lt;element ref="{}taxAttribute" minOccurs="0"/>
 *         &lt;element ref="{}taxExemptAgainst" minOccurs="0"/>
 *         &lt;element ref="{}taxExempt" minOccurs="0"/>
 *         &lt;element ref="{}taxForgivenAgainst" minOccurs="0"/>
 *         &lt;element ref="{}taxForgiven" minOccurs="0"/>
 *         &lt;element ref="{}taxableRebate" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taxAmts", propOrder = {
    "taxAmtOrTaxRateOrTaxNet"
})
public class TaxAmts {

    @XmlElements({
        @XmlElement(name = "taxAmt", type = TaxAmt.class),
        @XmlElement(name = "taxRate", type = TaxRate.class),
        @XmlElement(name = "taxNet", type = TaxNet.class),
        @XmlElement(name = "taxInTot", type = TaxInTot.class),
        @XmlElement(name = "taxAttribute", type = TaxAttribute.class),
        @XmlElement(name = "taxExemptAgainst", type = TaxExemptAgainst.class),
        @XmlElement(name = "taxExempt", type = TaxExempt.class),
        @XmlElement(name = "taxForgivenAgainst", type = TaxForgivenAgainst.class),
        @XmlElement(name = "taxForgiven", type = TaxForgiven.class),
        @XmlElement(name = "taxableRebate", type = TaxableRebate.class)
    })
    protected List<Object> taxAmtOrTaxRateOrTaxNet;

    /**
     * Gets the value of the taxAmtOrTaxRateOrTaxNet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAmtOrTaxRateOrTaxNet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAmtOrTaxRateOrTaxNet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxAmt }
     * {@link TaxRate }
     * {@link TaxNet }
     * {@link TaxInTot }
     * {@link TaxAttribute }
     * {@link TaxExemptAgainst }
     * {@link TaxExempt }
     * {@link TaxForgivenAgainst }
     * {@link TaxForgiven }
     * {@link TaxableRebate }
     * 
     * 
     */
    public List<Object> getTaxAmtOrTaxRateOrTaxNet() {
        if (taxAmtOrTaxRateOrTaxNet == null) {
            taxAmtOrTaxRateOrTaxNet = new ArrayList<Object>();
        }
        return this.taxAmtOrTaxRateOrTaxNet;
    }

}