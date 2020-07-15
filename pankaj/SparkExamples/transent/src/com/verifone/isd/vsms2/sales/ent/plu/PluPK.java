/*
 * PluPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 * Modified on August 23, 2005 by David Ezell
 *      added setValue(String,String) method.
 */

package com.verifone.isd.vsms2.sales.ent.plu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for Plu
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class PluPK implements IEntityPK {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PluPK.class);
    
    static final long serialVersionUID = -4984889454086933916L;
    /** UPC length
     */
    public static final int GEMPRO_UPC_LENGTH = 12;
    public static final int UPC_LENGTH = 14;
    
    /** Modifier length
     */
    public static final int MODIFIER_LENGTH = 3;
    /** Primary key of the PLU is upc followed by modifier
     */
    public static final int ID_LENGTH = UPC_LENGTH + MODIFIER_LENGTH;
    private static final int GEMPRO_ID_LENGTH = GEMPRO_UPC_LENGTH + MODIFIER_LENGTH;
    
    /** Pattern for empty modifier string (used in string formatting) */
    public static final String EMPTY_MODIFIER_STR = "000";
    /** Pattern for empty UPC string (used in string formatting) */
    public static final String EMPTY_UPC_STR = "00000000000000";
    
    private String pluNr;
    private String manufacturerCode ;
    private String familyCode ;
    
    /** Helper field to specify the modifier key press count; not to be persisted */
    private int seqNr = 0; // Not to be persisted - only for query purposes
    
    /** Creates a new instance of PluPK */
    public PluPK() {
    }
    
    /** Constructor
     * @param pluNr plu number
     */
    public PluPK(String pluNr) {    	
        setValue(pluNr);
    }
    
    /** Constructor
     * @param pluNr plu number
     * @param modifier modifier
     */
    public PluPK(String pluNr, String modifier) throws Exception {
        setValue(pluNr, modifier);
    }
    /** Getter for plu number
     * @return plu number
     */
    public String getValue() {
        return this.pluNr;
    }
    
    /** Get the UPC portion of the PLU
     * @return UPC portion of the PLU
     */
    public String getUpc() {
        return this.pluNr.substring(0, UPC_LENGTH);
    }
    
    /** Get the PLU's modifier
     * @return plu modifier
     */
    public String getModifier() {
        return this.pluNr.substring(UPC_LENGTH);
    }
    
    /** String representation of the plu number
     * @return plu number as a string
     */
    public String toString() {
        return this.pluNr;
    }
    
    /** Converts the pluNr representation to Gempro format
     * @return gempro format PLU string
     */
    public String getGemproValue() {
        int pluOffset = 0;
        int modifierOffset = GEMPRO_UPC_LENGTH;
        if(this.pluNr.length() == ID_LENGTH) {
            pluOffset = 1;
            modifierOffset = UPC_LENGTH;
        }
        return pluNr.substring(pluOffset, pluOffset + GEMPRO_UPC_LENGTH) +
        pluNr.substring(modifierOffset, modifierOffset + MODIFIER_LENGTH);
    }
    
    /** Converts the UPC representation to Gempro format
     * @return gempro format UPC string
     */
    public String getGemproUpc() {
        int offset = 0;
        if(this.pluNr.length() == ID_LENGTH) {
            offset = 1;
        }
        return pluNr.substring(offset, offset + GEMPRO_UPC_LENGTH);
    }
    
    /** Method to compare two PluPK objects for equality
     * @param obj object to compare with
     * @return true if both objects represent the same plu
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof PluPK) {
            PluPK cObj = (PluPK)obj;
            return this.pluNr.equals(cObj.pluNr);
        }
        return false;
    }
    
    /** Method to compare two PluPK objects for equality
     * @param obj object to compare with
     * @return true if both objects represent the same plu
     */
    public boolean equals(Object obj) {
        if (obj instanceof PluPK) {
            PluPK cObj = (PluPK)obj;
            return this.pluNr.equals(cObj.pluNr);
        }
        return false;
    }
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.pluNr == null) ? 0 : this.pluNr.hashCode());
    }
    
    /** Method to validate the object
     * @return true if the plu number is valid
     */
    public boolean isValid() {
        return ((this.pluNr != null) && (Long.parseLong(this.pluNr) != 0));
    }
    
    /** Setter used to specify the modify key press count for querying PLU from the database;
     * normally this is used to perform remote PLU lookups with the modify key press count
     * so that corresponding PLU object is returned.
     * @param seqNr modify key press count
     */
    public void setSeqNr(int seqNr) {
        this.seqNr = seqNr;
    }
    
    /** Getter for the modify key press count used in querying PLU from the database;
     * normally this is used to perform remote PLU lookups with the modify key press count
     * so that corresponding PLU object is returned.
     * @return the modify key press count
     */
    public int getSeqNr() {
        return this.seqNr;
    }
    
    /** Setter for property value.
     * @param pluNr New value of property value.
     */
    public void setValue(String pluNr) {
        this.pluNr = pluNr;
        /**
         * If the pluNr is 15 digits it means that is is in the Ruby normalized
         * form and must be converted to a 14 digit GTIN + 3 digit modifier
         */
        int length = this.pluNr.length();
        if (GEMPRO_ID_LENGTH >= length) {
            if (GEMPRO_ID_LENGTH > length) { 
				/**
				 * for smaller strings, treat the whole string as PLU #, left
				 * pad with 0's; make the modifier 000.
				 */
                StringBuffer sb = new StringBuffer();
                sb.append(this.pluNr);
                if (GEMPRO_UPC_LENGTH >= length) {
                    sb.append(EMPTY_MODIFIER_STR);
                }
                this.pluNr = sb.toString();
                length = this.pluNr.length();
                if (GEMPRO_ID_LENGTH > length) {
                    sb = new StringBuffer();
                    sb.append(EMPTY_UPC_STR.substring(0, GEMPRO_ID_LENGTH - length));
                    sb.append(this.pluNr);
                    this.pluNr = sb.toString();
                }
            }
            //          System.out.println("UPC = " +this.pluNr);
            int checksum = 0;
            int mult = 3;
            for (int i = 11; i >= 0; i--) {
                checksum += ((int) this.pluNr.charAt(i) - 48) * mult;
                mult = mult == 3 ? 1 : 3;
            }
            checksum = ((10 - checksum % 10) % 10);
            String pluNrtmp = new String("0" + this.pluNr.substring(0, 12) +
            checksum + this.pluNr.substring(12, 15));
            this.pluNr = pluNrtmp;
        }
        //code added for getting manufacturerCode and familyCode
        //change based on Sunrise Compliance changes on PLU numbers.
		//manufacturer ID in PLU number is chars 3-7
		//family Code in PLU number is chars 8-10
		this.manufacturerCode = this.pluNr.substring(3, 8);
		this.familyCode = this.pluNr.substring(8, 11);
    }
    /** Setter for property value.
     * @param pluNr string that holds the plu number
     * @param modifier string that holds the modifier
     */
    public void setValue(String pluNr,String modifier) throws Exception {
        if (modifier == null) {
            modifier = "";
        }
        /**
         * If the pluNr is 15 digits it means that it is in the Ruby normalized
         * form and must be converted to a 14 digit GTIN + 3 digit modifier
         */
        int length = pluNr.length();
        
        StringBuffer sb = new StringBuffer(ID_LENGTH);
        if (GEMPRO_UPC_LENGTH > length) {
            int pad = GEMPRO_UPC_LENGTH - length  - 1;
            for (int i = 0; i < pad; i++) {
                sb.append('0');
            }
        } else if (UPC_LENGTH < length) {
            throw new Exception("pluNr ["+pluNr+"] is too long");
        }
        sb.append(pluNr);
        
        length = modifier.length();
        if (MODIFIER_LENGTH >= length) {
            int pad = MODIFIER_LENGTH - length;
            
            for (int i = 0; i < pad; i++) {
                sb.append('0');
            }
        } else {
            throw new Exception("modifier ["+modifier+"] is too long");
        }
        sb.append(modifier);
        this.setValue(sb.toString());
    }

	/**
	 * @return the pluManufactCode
	 */
	public String getManufacturerCode() {
		return manufacturerCode;
	}

	/**
	 * @return the pluFamCode
	 */
	public String getFamilyCode() {
		return familyCode;
	}
    
    /*
    public static void main(String[] args) {
        System.out.println("      12345678901234567890");
        System.out.println("INP = " +args[0]);
        PluPK pk = new PluPK(args[0]);
        System.out.println("PLU = " + pk.pluNr);
    }*/
}
