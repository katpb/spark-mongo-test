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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}trlTax"/>
 *         &lt;element ref="{}trlRate"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trlTaxOrTrlRate"
})
@XmlRootElement(name = "trlTaxes")
public class TrlTaxes {

    @XmlElements({
        @XmlElement(name = "trlTax", type = TrlTax.class),
        @XmlElement(name = "trlRate", type = TrlRate.class)
    })
    protected List<Object> trlTaxOrTrlRate;

    /**
     * Gets the value of the trlTaxOrTrlRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trlTaxOrTrlRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrlTaxOrTrlRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrlTax }
     * {@link TrlRate }
     * 
     * 
     */
    public List<Object> getTrlTaxOrTrlRate() {
        if (trlTaxOrTrlRate == null) {
            trlTaxOrTrlRate = new ArrayList<Object>();
        }
        return this.trlTaxOrTrlRate;
    }

}