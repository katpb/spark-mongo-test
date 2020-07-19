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
 *         &lt;element ref="{}trlpdDescrip" minOccurs="0"/>
 *         &lt;element ref="{}trlpdPGUnit"/>
 *         &lt;element name="trlpdGrade" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element ref="{}trlpdGradeName" minOccurs="0"/>
 *         &lt;element name="trlpdVolume" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element ref="{}trlpdAmount"/>
 *         &lt;element ref="{}trlpdTime"/>
 *         &lt;element ref="{}trlpdMatch" minOccurs="0"/>
 *         &lt;element ref="{}trlpdFuelDef" minOccurs="0"/>
 *         &lt;element ref="{}trlpdCodeUsed" minOccurs="0"/>
 *         &lt;element ref="{}trlpdMemberID" minOccurs="0"/>
 *         &lt;element ref="{}trlpdMemEMeth" minOccurs="0"/>
 *         &lt;element ref="{}trlpdDiscProgramId" minOccurs="0"/>
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
    "trlpdDescrip",
    "trlpdPGUnit",
    "trlpdGrade",
    "trlpdGradeName",
    "trlpdVolume",
    "trlpdAmount",
    "trlpdTime",
    "trlpdMatch",
    "trlpdFuelDef",
    "trlpdCodeUsed",
    "trlpdMemberID",
    "trlpdMemEMeth",
    "trlpdDiscProgramId"
})
@XmlRootElement(name = "trlPopDisc")
public class TrlPopDisc {

    protected String trlpdDescrip;
    @XmlElement(required = true)
    protected BigDecimal trlpdPGUnit;
    @XmlElement(required = true)
    protected BigInteger trlpdGrade;
    protected String trlpdGradeName;
    @XmlElement(required = true)
    protected BigDecimal trlpdVolume;
    @XmlElement(required = true)
    protected BigDecimal trlpdAmount;
    @XmlElement(required = true)
    protected TrlpdTime trlpdTime;
    protected TrlpdMatch trlpdMatch;
    protected BigInteger trlpdFuelDef;
    protected String trlpdCodeUsed;
    protected String trlpdMemberID;
    protected TrlpdMemEMeth trlpdMemEMeth;
    protected BigInteger trlpdDiscProgramId;

    /**
     * Gets the value of the trlpdDescrip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlpdDescrip() {
        return trlpdDescrip;
    }

    /**
     * Sets the value of the trlpdDescrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlpdDescrip(String value) {
        this.trlpdDescrip = value;
    }

    /**
     * Gets the value of the trlpdPGUnit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrlpdPGUnit() {
        return trlpdPGUnit;
    }

    /**
     * Sets the value of the trlpdPGUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrlpdPGUnit(BigDecimal value) {
        this.trlpdPGUnit = value;
    }

    /**
     * Gets the value of the trlpdGrade property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrlpdGrade() {
        return trlpdGrade;
    }

    /**
     * Sets the value of the trlpdGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrlpdGrade(BigInteger value) {
        this.trlpdGrade = value;
    }

    /**
     * Gets the value of the trlpdGradeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlpdGradeName() {
        return trlpdGradeName;
    }

    /**
     * Sets the value of the trlpdGradeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlpdGradeName(String value) {
        this.trlpdGradeName = value;
    }

    /**
     * Gets the value of the trlpdVolume property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrlpdVolume() {
        return trlpdVolume;
    }

    /**
     * Sets the value of the trlpdVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrlpdVolume(BigDecimal value) {
        this.trlpdVolume = value;
    }

    /**
     * Gets the value of the trlpdAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrlpdAmount() {
        return trlpdAmount;
    }

    /**
     * Sets the value of the trlpdAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrlpdAmount(BigDecimal value) {
        this.trlpdAmount = value;
    }

    /**
     * Gets the value of the trlpdTime property.
     * 
     * @return
     *     possible object is
     *     {@link TrlpdTime }
     *     
     */
    public TrlpdTime getTrlpdTime() {
        return trlpdTime;
    }

    /**
     * Sets the value of the trlpdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrlpdTime }
     *     
     */
    public void setTrlpdTime(TrlpdTime value) {
        this.trlpdTime = value;
    }

    /**
     * Gets the value of the trlpdMatch property.
     * 
     * @return
     *     possible object is
     *     {@link TrlpdMatch }
     *     
     */
    public TrlpdMatch getTrlpdMatch() {
        return trlpdMatch;
    }

    /**
     * Sets the value of the trlpdMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrlpdMatch }
     *     
     */
    public void setTrlpdMatch(TrlpdMatch value) {
        this.trlpdMatch = value;
    }

    /**
     * Gets the value of the trlpdFuelDef property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrlpdFuelDef() {
        return trlpdFuelDef;
    }

    /**
     * Sets the value of the trlpdFuelDef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrlpdFuelDef(BigInteger value) {
        this.trlpdFuelDef = value;
    }

    /**
     * Gets the value of the trlpdCodeUsed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlpdCodeUsed() {
        return trlpdCodeUsed;
    }

    /**
     * Sets the value of the trlpdCodeUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlpdCodeUsed(String value) {
        this.trlpdCodeUsed = value;
    }

    /**
     * Gets the value of the trlpdMemberID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrlpdMemberID() {
        return trlpdMemberID;
    }

    /**
     * Sets the value of the trlpdMemberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrlpdMemberID(String value) {
        this.trlpdMemberID = value;
    }

    /**
     * Gets the value of the trlpdMemEMeth property.
     * 
     * @return
     *     possible object is
     *     {@link TrlpdMemEMeth }
     *     
     */
    public TrlpdMemEMeth getTrlpdMemEMeth() {
        return trlpdMemEMeth;
    }

    /**
     * Sets the value of the trlpdMemEMeth property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrlpdMemEMeth }
     *     
     */
    public void setTrlpdMemEMeth(TrlpdMemEMeth value) {
        this.trlpdMemEMeth = value;
    }

    /**
     * Gets the value of the trlpdDiscProgramId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTrlpdDiscProgramId() {
        return trlpdDiscProgramId;
    }

    /**
     * Sets the value of the trlpdDiscProgramId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTrlpdDiscProgramId(BigInteger value) {
        this.trlpdDiscProgramId = value;
    }

}