/*
 * ScannerConst.java
 *
 * Created on May 20, 2011, 3:29 PM
 */

package com.verifone.isd.vsms2.sys.util;


/** Type-safe enumeration for jpos.ScannerConst
 * This is to remove dependency on jpos.ScannerConst.
 * @author Ganesh_k1
 */
public class ScannerConst implements java.io.Serializable {
    
    private static final long serialVersionUID = 6504120738972655710L;
    
    public static final int SCAN_SDT_UPCA = 101;
    public static final int SCAN_SDT_UPCE = 102;
    public static final int SCAN_SDT_EAN8 = 103;
    public static final int SCAN_SDT_EAN13 = 104;
    
    private transient int number; 
    private transient String encoding;
    
    /** Constructor.
     * @param number ScannerConst number
     * @param encoding encoding
     */
    private ScannerConst(int number,String encoding) {	
        this.number = number;
        this.encoding = encoding;
    }
        
    /** Override toString() method to provide the ScannerConst number.
     * @return ScannerConst Number
     */    
    public String toString() {
        return "ScannerConst - " + this.number + " " + encoding;
    }    
    
    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enumber:
     * "All equal objects of the enumbererated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    /** Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enumber:
     * "All equal objects of the enumbererated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public static final ScannerConst UPCA = new ScannerConst(101,"A");
    public static final ScannerConst UPCE = new ScannerConst(102,"E");
    public static final ScannerConst EAN8 = new ScannerConst(103,"EAN");
    public static final ScannerConst EAN13 = new ScannerConst(104,"EAN");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; 
    
    private static final ScannerConst[] VALUES = { UPCA,
        UPCE, EAN8, EAN13 };
    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enumber constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enumber array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }     
        
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }       
    
    /** Getter for all the ScannerConst objects.
     * @return array of ScannerConst
     */    
    public static ScannerConst[] getObjects() {                
        return VALUES;
    }
    
    /**
     * This method will retun a ScannerConst based on the number.
     * @param ScannerConst
     * @return scanner constant
     */
    public static ScannerConst getObjectByScannerConstNumber(int number) {
	ScannerConst[] scannerConsts = ScannerConst.getObjects();
	ScannerConst reqdScannerConst = null;
        for (int i = 0; i < scannerConsts.length; i++) {
            if (scannerConsts[i].number == number) {
        	reqdScannerConst = scannerConsts[i];
                break;
            }
        }
        return reqdScannerConst;
    }
    
    /**
     * This method will retun a ScannerConst based on the encoding.
     * 
     * @param encoding
     * @return scanner constant
     */
    public static ScannerConst getObjectByScannerConstEncoding(String encoding) {
        ScannerConst[] scannerConsts = ScannerConst.getObjects();
        ScannerConst reqdScannerConst = null;
        for (int i = 0; i < scannerConsts.length; i++) {
            if (scannerConsts[i].encoding.equals(encoding)) {
                reqdScannerConst = scannerConsts[i];
                break;
            }
        }
        return reqdScannerConst;
    }
    
    /**
     * @return the ScannerConst number
     */
    public int getScannerConstNumberber() {
        return number;
    }
    
    /**
     * @return the ScannerConst encoding
     */
    public String getScannerConstEncoding() {
        return encoding;
    } 
}
