/*
 * EntryMethodDef.java
 *
 * Created on March 3, 2003
 */

package com.verifone.isd.vsms2.net.ent;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/** Type-safe enumeration of Entry Method Definitions
 * This class will assign the proper values for each application to all
 * entry moethod definitions in the application.  It is possible that not
 * all entry method types will be defined for every application, in fact this is
 * expected and the entry method's values (as required by each network will differ)
 * may well be unique for each app or at least each network.
 * @author Bhanu_N2
 */
public class EntryMethodDef implements java.io.Serializable
{
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.EntryMethodDef.class);
	private static final long serialVersionUID = -31712428873911860L;
    private transient int value;
    private transient String name;
    private String methodDescription;
    private boolean disallowCustomerPayment; /* customer cannot choose this payment entry method - only cashier can */ 

    private static int UNDEFINED = -1;
    private static Properties prop = null;

    private static synchronized void readProps() {
        if (prop == null){
            String propFile = "EntryMethodDef.prop";
            prop = new Properties();
            FileInputStream fis = null;
            // Read properties file.
            try {
                fis = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
                prop.load(fis);
            } catch (IOException e) {
            	/* No need to log as this file is not required in EPS environment */
            }
            finally {
                if (null != fis) {
                    try {
                        fis.close();
                    }
                    catch (IOException ioe) {}
                }
            }            
        }        
    }
    /** Constructor to allow subclassing
     * @param name Entry Method Name code's name
     * @param description Description for the entry method.  Mainly for receipt printing. 0=swipe, 1=manual, 2=DCR.
     */
    protected EntryMethodDef(String name, String description) {
        readProps();

        String val = prop.getProperty(name);

        if (val != null && val.length() > 0){
            try {
                this.value = Integer.parseInt(val.trim());      // From properties file.
            } catch (Exception oopsItsNotAnInt) {
                try {
					this.value = Integer.parseInt(val.trim(), 16);      // From properties file.
                } catch (Exception itsNotHexEither) {
                    this.value = UNDEFINED;        // Doesn't seem to be a valid entry method
                }
            }
        } else {
            this.value = UNDEFINED;
        }
        this.name = name;
		if ((description != null) && (description.length() > 0)) {
			this.methodDescription = description;
		} else {
			this.methodDescription = "Unknown";
		}
    }
    
    /**
	 * @param name
	 * @param methodDescription
	 * @param disallowCustomerPayment
	 */
	public EntryMethodDef(String name, String methodDescription,
			boolean disallowCustomerPayment) {
		this(name, methodDescription);
		this.disallowCustomerPayment = disallowCustomerPayment;
	}

//    protected abstract Object getProcessor();


	/** Override toString() method to provide the EntryMethod def's name
     * @return EntryMethod definition name
     */
    public String toString() {
        return (this.name + ":" + this.value);
    }

    /** Getter for entry method description
     * @return EntryMethod def description
     */
    public String getDescription() {
        return this.methodDescription;
    }

	/**
	 * @return the disallowCustomerPayment
	 */
	public boolean isDisallowCustomerPayment() {
		return disallowCustomerPayment;
	}
	
	/** Getter for EntryMethod def value
     * @return EntryMethod def value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * This method returns a EntryMethodDef object with a value matching
     * the value parameter.  Note: this is not the object at the ordinal
     * position but the object containing a matching value.
     * @param value - The value to match to the objects value property.
     * @throws Exception if a value match is not found.
     * @return A EntryMethodDef object.
     */    
     public static EntryMethodDef getFromValue(int value) throws Exception
     {
        EntryMethodDef[] defs = EntryMethodDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].value == value) {
                return (defs[i]);
            }
        }                 
        
        String msg = "Entry Method Index:" + value + " not found in EntryMethodDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.EntryMethodDef.class).error( msg);
        throw new Exception(msg);
     }
     
	/**
	 * Return an entry method based on matching IFSF description
	 * 
	 * @param description
	 * @return first entry method that matches description
	 */
     public static EntryMethodDef getFromDescription(String description) {
		if (description != null) {
			for (EntryMethodDef entryMode : EntryMethodDef.getObjects()) {
				if (entryMode.getDescription().equalsIgnoreCase(description)) {
					return entryMode;
				}
			}
		}
    	 return EntryMethodDef.ENTRY_SWIPE;
     }
    
    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /** Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }
    //  Defined Acct validation Indexes for use by all applications.  Individual values are set
    //  from a EntryMethodDef.prop file unique to each application.
    public static EntryMethodDef ENTRY_SWIPE       = new EntryMethodDef("ENTRY_SWIPE", "Swipe");
    public static EntryMethodDef ENTRY_MANUAL       = new EntryMethodDef("ENTRY_MANUAL", "Manual", true);
    public static EntryMethodDef ENTRY_ISLAND = new EntryMethodDef("ENTRY_ISLAND", "DCR");
    public static EntryMethodDef ENTRY_SWIPE_DL = new EntryMethodDef("ENTRY_SWIPE_DL", "Swipe");
    public static EntryMethodDef ENTRY_MANUAL_DL = new EntryMethodDef("ENTRY_MANUAL_DL", "Manual", true);
    public static EntryMethodDef ENTRY_SWIPE_TRACK1    = new EntryMethodDef("ENTRY_SWIPE_TRACK1", "Swipe");
    public static EntryMethodDef ENTRY_ISLAND_TRACK1       = new EntryMethodDef("ENTRY_ISLAND_TRACK1", "DCR");
    public static EntryMethodDef ENTRY_SWIPE_TRACK2     = new EntryMethodDef("ENTRY_SWIPE_TRACK2", "Swipe");
    public static EntryMethodDef ENTRY_ISLAND_TRACK2      = new EntryMethodDef("ENTRY_ISLAND_TRACK2", "DCR");
    public static EntryMethodDef ENTRY_SWIPE_RF        = new EntryMethodDef("ENTRY_SWIPE_RF", "RadioFrequency");
    public static EntryMethodDef ENTRY_ISLAND_RF        = new EntryMethodDef("ENTRY_ISLAND_RF", "RadioFrequency");
    public static EntryMethodDef ENTRY_SWIPE_RF_T2      = new EntryMethodDef("ENTRY_SWIPE_RF_T2", "RadioFrequency");
    public static EntryMethodDef ENTRY_ISLAND_RF_T2      = new EntryMethodDef("ENTRY_ISLAND_RF_T2", "RadioFrequency");
    public static EntryMethodDef ENTRY_MANUAL_FC = new EntryMethodDef("ENTRY_MANUAL_FC", "Manual", true);
    public static EntryMethodDef ENTRY_SWIPE_RFID = new EntryMethodDef("ENTRY_SWIPE_RFID", "RadioFrequency");
    public static EntryMethodDef ENTRY_ISLAND_RFID = new EntryMethodDef("ENTRY_ISLAND_RFID", "RadioFrequency");
    public static EntryMethodDef ENTRY_BARCODE = new EntryMethodDef("ENTRY_BARCODE", "Scanner", true);
    public static EntryMethodDef ENTRY_KEYBOARD = new EntryMethodDef("ENTRY_KEYBOARD", "Keyboard", true);
    public static EntryMethodDef ENTRY_SPEEDPASS = new EntryMethodDef("ENTRY_SPEEDPASS", "Speedpass");
    public static EntryMethodDef ENTRY_MOBILE = new EntryMethodDef("ENTRY_MOBILE", "Mobile");
    public static EntryMethodDef ENTRY_RING = new EntryMethodDef("ENTRY_RING", "RadioFrequencyNozzle");
    public static EntryMethodDef ENTRY_EMV = new EntryMethodDef("ENTRY_EMV", "SmartCard");
    public static EntryMethodDef ENTRY_EMV_CONTACTLESS = new EntryMethodDef("ENTRY_EMV_CONTACTLESS", "ContactlessSmartCard");
    public static EntryMethodDef ENTRY_SKIPPED = new EntryMethodDef("ENTRY_SKIPPED", "Skipped", true);

    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //EntryMethod Def's ; auto-incremented

    //  As of 3/3/2005 these are the entry methods defined for ADS and Citgo.  As more apps
    //  are developed this list could grow.
    private static final EntryMethodDef[] VALUES = {
        ENTRY_SWIPE, ENTRY_MANUAL, ENTRY_ISLAND, 
        ENTRY_SWIPE_DL, ENTRY_MANUAL_DL, 
        ENTRY_SWIPE_TRACK1 , ENTRY_ISLAND_TRACK1 , 
        ENTRY_SWIPE_TRACK2, ENTRY_ISLAND_TRACK2, 
        ENTRY_SWIPE_RF, ENTRY_ISLAND_RF, 
        ENTRY_SWIPE_RF_T2, ENTRY_ISLAND_RF_T2, 
        ENTRY_MANUAL_FC, ENTRY_SWIPE_RFID, ENTRY_ISLAND_RFID,
        ENTRY_BARCODE, ENTRY_KEYBOARD, ENTRY_SPEEDPASS,
        ENTRY_MOBILE, ENTRY_RING, ENTRY_EMV,ENTRY_EMV_CONTACTLESS,
        ENTRY_SKIPPED
    };

    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }

    /** Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }

    /** Method to get the EntryMethodDef.object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return EntryMethodDef.object representing the ordinal
     */
    protected static EntryMethodDef getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /** Getter for all the EntryMethodDef.objects
     * @return array of EntryMethod Definitions
     */
    protected static EntryMethodDef[] getObjects() {
        EntryMethodDef[] defs = new EntryMethodDef[VALUES.length];
        System.arraycopy(VALUES, 0, defs, 0, VALUES.length);
        return defs;
    }

    /** Test method
     * @param args params to the test
     */

    public static void main(String[] args) {
        EntryMethodDef[] defs = EntryMethodDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("Code: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }
        System.out.println("EntryMethodDef.ENTRY_SWIPE:" + EntryMethodDef.ENTRY_SWIPE.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE.getValue());
        System.out.println("EntryMethodDef.ENTRY_MANUAL:" + EntryMethodDef.ENTRY_MANUAL.toString() + ", value:" + EntryMethodDef.ENTRY_MANUAL.getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND:" + EntryMethodDef.ENTRY_ISLAND.toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND.getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_DL:" + EntryMethodDef.ENTRY_SWIPE_DL.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_DL.getValue());
        System.out.println("EntryMethodDef.ENTRY_MANUAL_DL:" + EntryMethodDef.ENTRY_MANUAL_DL.toString() + ", value:" + EntryMethodDef.ENTRY_MANUAL_DL.getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_TRACK1 :" + EntryMethodDef.ENTRY_SWIPE_TRACK1 .toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_TRACK1 .getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND_TRACK1 :" + EntryMethodDef.ENTRY_ISLAND_TRACK1 .toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND_TRACK1 .getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_TRACK2:" + EntryMethodDef.ENTRY_SWIPE_TRACK2.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_TRACK2.getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND_TRACK2:" + EntryMethodDef.ENTRY_ISLAND_TRACK2.toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND_TRACK2.getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_RF:" + EntryMethodDef.ENTRY_SWIPE_RF.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_RF.getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND_RF:" + EntryMethodDef.ENTRY_ISLAND_RF.toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND_RF.getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_RF_T2:" + EntryMethodDef.ENTRY_SWIPE_RF_T2.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_RF_T2.getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND_RF_T2:" + EntryMethodDef.ENTRY_ISLAND_RF_T2.toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND_RF_T2.getValue());
        System.out.println("EntryMethodDef.ENTRY_MANUAL_FC:" + EntryMethodDef.ENTRY_MANUAL_FC.toString() + ", value:" + EntryMethodDef.ENTRY_MANUAL_FC.getValue());
        System.out.println("EntryMethodDef.ENTRY_SWIPE_RFID:" + EntryMethodDef.ENTRY_SWIPE_RFID.toString() + ", value:" + EntryMethodDef.ENTRY_SWIPE_RFID.getValue());
        System.out.println("EntryMethodDef.ENTRY_ISLAND_RFID:" + EntryMethodDef.ENTRY_ISLAND_RFID.toString() + ", value:" + EntryMethodDef.ENTRY_ISLAND_RFID.getValue());
        System.out.println("EntryMethodDef.ENTRY_MOBILE:" + EntryMethodDef.ENTRY_MOBILE.toString() + ", value:" + EntryMethodDef.ENTRY_MOBILE.getValue());
        System.out.println("EntryMethodDef.ENTRY_RING:" + EntryMethodDef.ENTRY_RING.toString() + ", value:" + EntryMethodDef.ENTRY_RING.getValue());
        System.out.println("EntryMethodDef.ENTRY_EMV:" + EntryMethodDef.ENTRY_EMV.toString() + ", value:" + EntryMethodDef.ENTRY_EMV.getValue());
        System.out.println("EntryMethodDef.ENTRY_EMV_CONTACTLESS:" + EntryMethodDef.ENTRY_EMV_CONTACTLESS.toString() + ", value:" + EntryMethodDef.ENTRY_EMV_CONTACTLESS.getValue());
        System.out.println("EntryMethodDef.ENTRY_SKIPPED:" + EntryMethodDef.ENTRY_SKIPPED.toString() + ", value:" + EntryMethodDef.ENTRY_SKIPPED.getValue());

    }
}
