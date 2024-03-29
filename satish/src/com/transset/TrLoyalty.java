//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.07 at 01:19:54 PM IST 
//


package com.transset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="trLoyaltyProgram" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="trloSubTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="trloAutoDisc" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="trloCustDisc" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="trloAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="trloEntryMeth" type="{}entryMethodType"/>
 *                   &lt;element name="trloAuthReply">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="40"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="trloTranType" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="trloRefundFlg" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="programID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "trLoyaltyProgram"
})
@XmlRootElement(name = "trLoyalty")
public class TrLoyalty {

    @XmlElement(required = true)
    protected List<TrLoyalty.TrLoyaltyProgram> trLoyaltyProgram;

    /**
     * Gets the value of the trLoyaltyProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trLoyaltyProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrLoyaltyProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrLoyalty.TrLoyaltyProgram }
     * 
     * 
     */
    public List<TrLoyalty.TrLoyaltyProgram> getTrLoyaltyProgram() {
        if (trLoyaltyProgram == null) {
            trLoyaltyProgram = new ArrayList<TrLoyalty.TrLoyaltyProgram>();
        }
        return this.trLoyaltyProgram;
    }


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
     *         &lt;element name="trloSubTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="trloAutoDisc" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="trloCustDisc" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="trloAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="trloEntryMeth" type="{}entryMethodType"/>
     *         &lt;element name="trloAuthReply">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="40"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="trloTranType" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="trloRefundFlg" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="programID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "trloSubTotal",
        "trloAutoDisc",
        "trloCustDisc",
        "trloAccount",
        "trloEntryMeth",
        "trloAuthReply",
        "trloTranType",
        "trloRefundFlg"
    })
    public static class TrLoyaltyProgram {

        @XmlElement(required = true)
        protected BigDecimal trloSubTotal;
        @XmlElement(required = true)
        protected BigDecimal trloAutoDisc;
        @XmlElement(required = true)
        protected BigDecimal trloCustDisc;
        @XmlElement(required = true)
        protected String trloAccount;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected EntryMethodType trloEntryMeth;
        @XmlElement(required = true)
        protected String trloAuthReply;
        protected BigInteger trloTranType;
        protected BigInteger trloRefundFlg;
        @XmlAttribute(name = "programID", required = true)
        protected String programID;

        /**
         * Gets the value of the trloSubTotal property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTrloSubTotal() {
            return trloSubTotal;
        }

        /**
         * Sets the value of the trloSubTotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTrloSubTotal(BigDecimal value) {
            this.trloSubTotal = value;
        }

        /**
         * Gets the value of the trloAutoDisc property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTrloAutoDisc() {
            return trloAutoDisc;
        }

        /**
         * Sets the value of the trloAutoDisc property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTrloAutoDisc(BigDecimal value) {
            this.trloAutoDisc = value;
        }

        /**
         * Gets the value of the trloCustDisc property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTrloCustDisc() {
            return trloCustDisc;
        }

        /**
         * Sets the value of the trloCustDisc property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTrloCustDisc(BigDecimal value) {
            this.trloCustDisc = value;
        }

        /**
         * Gets the value of the trloAccount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrloAccount() {
            return trloAccount;
        }

        /**
         * Sets the value of the trloAccount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrloAccount(String value) {
            this.trloAccount = value;
        }

        /**
         * Gets the value of the trloEntryMeth property.
         * 
         * @return
         *     possible object is
         *     {@link EntryMethodType }
         *     
         */
        public EntryMethodType getTrloEntryMeth() {
            return trloEntryMeth;
        }

        /**
         * Sets the value of the trloEntryMeth property.
         * 
         * @param value
         *     allowed object is
         *     {@link EntryMethodType }
         *     
         */
        public void setTrloEntryMeth(EntryMethodType value) {
            this.trloEntryMeth = value;
        }

        /**
         * Gets the value of the trloAuthReply property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrloAuthReply() {
            return trloAuthReply;
        }

        /**
         * Sets the value of the trloAuthReply property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrloAuthReply(String value) {
            this.trloAuthReply = value;
        }

        /**
         * Gets the value of the trloTranType property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTrloTranType() {
            return trloTranType;
        }

        /**
         * Sets the value of the trloTranType property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTrloTranType(BigInteger value) {
            this.trloTranType = value;
        }

        /**
         * Gets the value of the trloRefundFlg property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTrloRefundFlg() {
            return trloRefundFlg;
        }

        /**
         * Sets the value of the trloRefundFlg property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTrloRefundFlg(BigInteger value) {
            this.trloRefundFlg = value;
        }

        /**
         * Gets the value of the programID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProgramID() {
            return programID;
        }

        /**
         * Sets the value of the programID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProgramID(String value) {
            this.programID = value;
        }

    }

}
