/*
 * EasyIDData.java
 *
 * Created on January 15, 2004, 4:35 PM
 */

package com.verifone.isd.vsms2.sales.ent.easyid;

/** Data containing the parsed information from a scanned ID card (eother by the
 * MSR or Scanner) by the EasiID processor, class EasyID
 * @author Joe_H5
 */
public class EasyIDData implements java.io.Serializable {
    
    static final long serialVersionUID = -5271035104239995380L;

    String  expMonth = "";       /* expiration month */
    String  expYear = "";        /* expiration year */
    String  birthDay = "";       /* birth day */
    String  birthMonth = "";     /* birth month */
    String  birthYear = "";      /* birth year */
    String  state = "";          /* state abbreviation */
    int     validate = 0;          /* indicates special validation required */
    String  firstName = "";
    String  middleName = "";
    String  lastName = "";
    String  driverId = "";
 

    /** Creates a new instance of EasyIDData */
    public EasyIDData() {
    }

    /** Expiration month in two digit format
     * @return The expiration month
     */    
    public String getExpMonth() {
        return expMonth;
    }
    
    /**
     * Setter for expiration month
     * @param month Expiration month in two digit format
     */    
    public void setExpMonth(String month) {
        this.expMonth = month;
    }

    /** Expiration year in two digit format
     * @return The expiration year
     */    
    public String getExpYear() {
        return expYear;
    }
    
    /**
     * Setter for expiration year
     * @param year Expiration year in two digit format
     */    
    public void setExpYear(String year) {
        this.expYear = year;
    }

    /** Birth day in two digit format
     * @return The birth day
     */    
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * Birth month in two digit format
     * @return The birth month
     */    
    public String getBirthMonth() {
        return birthMonth;
    }
    
    /**
     * Setter for birth month
     * @param month Birth month in two digit format
     */    
    public void setBirthMonth(String month) {
        this.birthMonth = month;
    }

    /** Birth year in two digit format
     * @return The birth day
     */    
    public String getBirthYear() {
        return birthYear;
    }

    /** The state the card was issued in; two letter code
     * @return two letter state id
     */    
    public String getState() {
        return state;
    }

    /**
     * Setter for card issuing state
     * @param state Two letter state code
     */    
    public void setState(String state) {
        this.state = state;
    }

    /** Special validation flags. (Not used - so far)
     * @return validation flags
     */    
    public int getvalidate() {
        return validate;
    }
    
    /**
     * Setter for first name
     * @param first name string
     */    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Getter for first name
     * @return String firstName
     */    
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Setter for middle name
     * @param middle name string
     */    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /** Getter for middle name
     * @return String middle name
     */    
    public String getMiddleName() {
        return middleName;
    }
    
    /**
     * Setter for last name
     * @param last name string
     */    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Getter for last name
     * @return String last name
     */    
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Setter for driverId
     * @param driverId string
     */    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    /** Getter for driverId
     * @return String driverId
     */    
    public String getDriverId() {
        return driverId;
    }

    /**
     * Convert current object to a string
     * @return String representation of this object
     */    
    public String toString() {
        java.lang.StringBuffer aBuffer = new java.lang.StringBuffer();

        aBuffer.append( "\n    expMonth: " + expMonth );
        aBuffer.append( "\n     expYear: " + expYear );
        aBuffer.append( "\n    birthDay: " + birthDay );
        aBuffer.append( "\n  birthMonth: " + birthMonth );
        aBuffer.append( "\n   birthYear: " + birthYear );
        aBuffer.append( "\n       state: " + state );
        aBuffer.append( "\n    validate: " + validate );
        aBuffer.append( "\n   firstName: " + firstName );
        aBuffer.append( "\n  middleName: " + middleName );
        aBuffer.append( "\n    lastName: " + lastName );
        aBuffer.append( "\n    driverId: " + driverId );
        
        return aBuffer.toString();
    }
}
