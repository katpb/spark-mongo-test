/*
 * AcctValidationIndexDef.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.net.ent;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/** Type-safe enumeration of Card Definitions
 * This class will assign the proper values for each application to all
 * card definitions in the application.  It is possible that not
 * all card types will be defined for every application, in fact this is
 * expected as not all apps accept all cards.
 * @author Bhanu_N2
 */
public class AcctValidationIndexDef implements java.io.Serializable
{
	private static final long serialVersionUID = -478894370638829712L;
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDef.class);
    private transient int value;
    private transient String name;
    private static int UNDEFINED = -1;
    private static Properties prop = null;
    private boolean valid;

    private static synchronized void readProps() {
        if (prop == null) {
            String propFile = "AcctValidationIndexDef.prop";
            prop = new Properties();
            FileInputStream fis = null;
            // Read properties file.
            try {
                fis = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
                prop.load(fis);
            } catch (IOException e) {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDef.class).error( "Error loading AcctValidationIndexDef.prop file:" + propFile + " " + e.getMessage());
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
     * @param name Card Name code's name
     */
    protected AcctValidationIndexDef(String name) {
        readProps();
        String indexValue = prop.getProperty(name);

        if (indexValue != null && indexValue.length() > 0) {
            this.value = Integer.parseInt(indexValue.trim(), 10);      // From properties file.
            this.valid = true;
        } else {
            this.value = UNDEFINED;
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDef.class).error( "AcctValidationIndexDef property:" + name + " Defaulting to Undefined (-1)");
        }
        this.name = name;
    }

//    protected abstract Object getProcessor();

    /** Override toString() method to provide the Card def's name
     * @return card definition name
     */
    public String toString() {
        return (this.name + ":" + this.value);
    }

    /** Getter for card def value
     * @return card def value
     */
    public int getValue() {
        return this.value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isValid() {
        return this.valid;
    }

    /**
     * This method returns a AcctValidationIndexDef object with a value matching
     * the value parameter.  Note: this is not the object at the ordinal
     * position but the object containing a matching value.
     * @param value - The value to match to the objects value property.
     * @throws Exception if a value match is not found.
     * @return A AcctValidationIndexDef object.
     */    
     public static AcctValidationIndexDef getFromValue(int value) throws Exception
     {
        AcctValidationIndexDef[] defs = AcctValidationIndexDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].value == value) {
                return (defs[i]);
            }
        }                 
        
        String msg = "Acct Validation Index:" + value + " not found in AcctValidationIndexDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDef.class).error( msg);
        throw new Exception(msg);
     }
     
     public static AcctValidationIndexDef getFromName(String name) throws Exception
     {
        AcctValidationIndexDef[] defs = AcctValidationIndexDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].name.equals(name)) {
                return (defs[i]);
            }
        }                 
        
        String msg = "Acct Validation Index:" + name + " not found in AcctValidationIndexDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDef.class).error( msg);
        throw new Exception(msg);
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
    //  from a AcctValidationIndexDef.prop file unique to each application.
    public static AcctValidationIndexDef CHK_NONE       = new AcctValidationIndexDef("CHK_NONE");
    public static AcctValidationIndexDef CHK_LUHN       = new AcctValidationIndexDef("CHK_LUHN");
    public static AcctValidationIndexDef CHK_MASTERCARD = new AcctValidationIndexDef("CHK_MASTERCARD");
    public static AcctValidationIndexDef CHK_WXPRESS    = new AcctValidationIndexDef("CHK_WXPRESS");
    public static AcctValidationIndexDef CHK_VISA       = new AcctValidationIndexDef("CHK_VISA");
    public static AcctValidationIndexDef CHK_CUSTOM     = new AcctValidationIndexDef("CHK_CUSTOM");
    public static AcctValidationIndexDef CHK_CALIF      = new AcctValidationIndexDef("CHK_CALIF");
    public static AcctValidationIndexDef CHK_PHH        = new AcctValidationIndexDef("CHK_PHH");
    public static AcctValidationIndexDef CHK_IAS        = new AcctValidationIndexDef("CHK_IAS");
    public static AcctValidationIndexDef CHK_AMOCO      = new AcctValidationIndexDef("CHK_AMOCO");
    public static AcctValidationIndexDef CHK_AMOCO_MULTI= new AcctValidationIndexDef("CHK_AMOCO_MULTI");
    public static AcctValidationIndexDef CHK_UNIVERSAL  = new AcctValidationIndexDef("CHK_UNIVERSAL");
    public static AcctValidationIndexDef CHK_DISCOVER   = new AcctValidationIndexDef("CHK_DISCOVER");
    public static AcctValidationIndexDef CHK_GSA        = new AcctValidationIndexDef("CHK_GSA");
    public static AcctValidationIndexDef CHK_VOYAGER    = new AcctValidationIndexDef("CHK_VOYAGER");
    public static AcctValidationIndexDef CHK_AMEX       = new AcctValidationIndexDef("CHK_AMEX");
    public static AcctValidationIndexDef CHK_FMGC       = new AcctValidationIndexDef("CHK_FMGC");
    public static AcctValidationIndexDef CHK_FUELMN     = new AcctValidationIndexDef("CHK_FUELMN");
    public static AcctValidationIndexDef CHK_DONLN      = new AcctValidationIndexDef("CHK_DONLN");
    public static AcctValidationIndexDef CHK_MCFLT      = new AcctValidationIndexDef("CHK_MCFLT");
    public static AcctValidationIndexDef CHK_MCPURC     = new AcctValidationIndexDef("CHK_MCPURC");
    public static AcctValidationIndexDef CHK_PREPAID    = new AcctValidationIndexDef("CHK_PREPAID");
    public static AcctValidationIndexDef CHK_VISAFLT	= new AcctValidationIndexDef("CHK_VISAFLT");
    public static AcctValidationIndexDef CHK_ENMARK		= new AcctValidationIndexDef("CHK_ENMARK");
    public static AcctValidationIndexDef CHK_PNS		= new AcctValidationIndexDef("CHK_PNS");
    public static AcctValidationIndexDef CHK_MOTOMART	= new AcctValidationIndexDef("CHK_MOTOMART");
    public static AcctValidationIndexDef CHK_GATE 		= new AcctValidationIndexDef("CHK_GATE");
    public static AcctValidationIndexDef CHK_TCH_LT 	= new AcctValidationIndexDef("CHK_TCH_LT");
    public static AcctValidationIndexDef CHK_FLEET_ONE 	= new AcctValidationIndexDef("CHK_FLEET_ONE");
    public static AcctValidationIndexDef CHK_METROSPLASH = new AcctValidationIndexDef("CHK_METROSPLASH");
    public static AcctValidationIndexDef CHK_BP = new AcctValidationIndexDef("CHK_BP");
    public static AcctValidationIndexDef CHK_API = new AcctValidationIndexDef("CHK_API");
    public static AcctValidationIndexDef CHK_GULF = new AcctValidationIndexDef("CHK_GULF");
    public static AcctValidationIndexDef CHK_SUNOCO = new AcctValidationIndexDef("CHK_SUNOCO");
    public static AcctValidationIndexDef CHK_SUN_CANADA = new AcctValidationIndexDef("CHK_SUN_CANADA");
    public static AcctValidationIndexDef CHK_TESORO = new AcctValidationIndexDef("CHK_TESORO");
    public static AcctValidationIndexDef CHK_BUYPROP = new AcctValidationIndexDef("CHK_BUYPROP");
    public static AcctValidationIndexDef CHK_GASCRD = new AcctValidationIndexDef("CHK_GASCRD");
    public static AcctValidationIndexDef CHK_CENEX = new AcctValidationIndexDef("CHK_CENEX");
    public static AcctValidationIndexDef CHK_DMD = new AcctValidationIndexDef("CHK_DMD");
    public static AcctValidationIndexDef CHK_UDSFLEET = new AcctValidationIndexDef("CHK_UDSFLEET");
    public static AcctValidationIndexDef CHK_VALERO = new AcctValidationIndexDef("CHK_VALERO");
    public static AcctValidationIndexDef CHK_TEX = new AcctValidationIndexDef("CHK_TEX");
    public static AcctValidationIndexDef CHK_SHELL = new AcctValidationIndexDef("CHK_SHELL");
    public static AcctValidationIndexDef CHK_CHEVRON = new AcctValidationIndexDef("CHK_CHEVRON");
    public static AcctValidationIndexDef CHK_ROADSMITH = new AcctValidationIndexDef("CHK_ROADSMITH");
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //card Def's ; auto-incremented

    //  As of 1/19/2005 these are the cards defined for ADS and Buypass.  As more apps
    //  are developed this list could grow.
    private static final AcctValidationIndexDef[] VALUES = {
        CHK_NONE, CHK_LUHN, CHK_MASTERCARD, CHK_WXPRESS , CHK_VISA , CHK_CUSTOM,
        CHK_CALIF, CHK_PHH, CHK_IAS, CHK_AMOCO, CHK_AMOCO_MULTI,
        CHK_UNIVERSAL, CHK_DISCOVER, CHK_GSA, CHK_VOYAGER , CHK_AMEX,
        CHK_FMGC , CHK_FUELMN, CHK_DONLN, CHK_MCFLT, CHK_MCPURC,
        CHK_PREPAID, CHK_VISAFLT, CHK_ENMARK, CHK_PNS, CHK_MOTOMART, CHK_GATE, CHK_TCH_LT,
		CHK_FLEET_ONE,CHK_METROSPLASH, CHK_BP, CHK_API, CHK_GULF, CHK_SUNOCO, CHK_SUN_CANADA,
		CHK_TESORO, CHK_BUYPROP, CHK_GASCRD, CHK_CENEX, CHK_DMD, CHK_UDSFLEET, CHK_VALERO,
                CHK_TEX, CHK_SHELL, CHK_CHEVRON, CHK_ROADSMITH
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

    /** Method to get the AcctValidationIndexDef.object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return AcctValidationIndexDef.object representing the ordinal
     */
    protected static AcctValidationIndexDef getObject(int ordinal) {
        if (ordinal >= 0 && ordinal < VALUES.length)
            return VALUES[ordinal];
        return null;
    }

    /** Getter for all the AcctValidationIndexDef.objects
     * @return array of Card Definitions
     */
    protected static AcctValidationIndexDef[] getObjects() {
        AcctValidationIndexDef[] defs = new AcctValidationIndexDef[VALUES.length];
        System.arraycopy(VALUES, 0, defs, 0, VALUES.length);
        return defs;
    }

    /** Test method
     * @param args params to the test
     */

    public static void main(String[] args) {
        AcctValidationIndexDef[] defs = AcctValidationIndexDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("Code: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }

        System.out.println("AcctValidationIndexDef.CHK_NONE:" + AcctValidationIndexDef.CHK_NONE.toString() + ", value:" + AcctValidationIndexDef.CHK_NONE.getValue());
        System.out.println("AcctValidationIndexDef.CHK_LUHN:" + AcctValidationIndexDef.CHK_LUHN.toString() + ", value:" + AcctValidationIndexDef.CHK_LUHN.getValue());
        System.out.println("AcctValidationIndexDef.CHK_MASTERCARD:" + AcctValidationIndexDef.CHK_MASTERCARD.toString() + ", value:" + AcctValidationIndexDef.CHK_MASTERCARD.getValue());
        System.out.println("AcctValidationIndexDef.CHK_WXPRESS :" + AcctValidationIndexDef.CHK_WXPRESS .toString() + ", value:" + AcctValidationIndexDef.CHK_WXPRESS .getValue());
        System.out.println("AcctValidationIndexDef.CHK_VISA :" + AcctValidationIndexDef.CHK_VISA .toString() + ", value:" + AcctValidationIndexDef.CHK_VISA .getValue());
        System.out.println("AcctValidationIndexDef.CHK_CUSTOM:" + AcctValidationIndexDef.CHK_CUSTOM.toString() + ", value:" + AcctValidationIndexDef.CHK_CUSTOM.getValue());
        System.out.println("AcctValidationIndexDef.CHK_CALIF:" + AcctValidationIndexDef.CHK_CALIF.toString() + ", value:" + AcctValidationIndexDef.CHK_CALIF.getValue());
        System.out.println("AcctValidationIndexDef.CHK_PHH:" + AcctValidationIndexDef.CHK_PHH.toString() + ", value:" + AcctValidationIndexDef.CHK_PHH.getValue());
        System.out.println("AcctValidationIndexDef.CHK_IAS:" + AcctValidationIndexDef.CHK_IAS.toString() + ", value:" + AcctValidationIndexDef.CHK_IAS.getValue());
        System.out.println("AcctValidationIndexDef.CHK_AMOCO:" + AcctValidationIndexDef.CHK_AMOCO.toString() + ", value:" + AcctValidationIndexDef.CHK_AMOCO.getValue());
        System.out.println("AcctValidationIndexDef.CHK_AMOCO_MULTI:" + AcctValidationIndexDef.CHK_AMOCO_MULTI.toString() + ", value:" + AcctValidationIndexDef.CHK_AMOCO_MULTI.getValue());
        System.out.println("AcctValidationIndexDef.CHK_UNIVERSAL:" + AcctValidationIndexDef.CHK_UNIVERSAL.toString() + ", value:" + AcctValidationIndexDef.CHK_UNIVERSAL.getValue());
        System.out.println("AcctValidationIndexDef.CHK_DISCOVER:" + AcctValidationIndexDef.CHK_DISCOVER.toString() + ", value:" + AcctValidationIndexDef.CHK_DISCOVER.getValue());
        System.out.println("AcctValidationIndexDef.CHK_GSA:" + AcctValidationIndexDef.CHK_GSA.toString() + ", value:" + AcctValidationIndexDef.CHK_GSA.getValue());
        System.out.println("AcctValidationIndexDef.CHK_VOYAGER :" + AcctValidationIndexDef.CHK_VOYAGER .toString() + ", value:" + AcctValidationIndexDef.CHK_VOYAGER .getValue());
        System.out.println("AcctValidationIndexDef.CHK_AMEX:" + AcctValidationIndexDef.CHK_AMEX.toString() + ", value:" + AcctValidationIndexDef.CHK_AMEX.getValue());
        System.out.println("AcctValidationIndexDef.CHK_FMGC :" + AcctValidationIndexDef.CHK_FMGC .toString() + ", value:" + AcctValidationIndexDef.CHK_FMGC .getValue());
        System.out.println("AcctValidationIndexDef.CHK_FUELMN:" + AcctValidationIndexDef.CHK_FUELMN.toString() + ", value:" + AcctValidationIndexDef.CHK_FUELMN.getValue());
        System.out.println("AcctValidationIndexDef.CHK_DONLN:" + AcctValidationIndexDef.CHK_DONLN.toString() + ", value:" + AcctValidationIndexDef.CHK_DONLN.getValue());
        System.out.println("AcctValidationIndexDef.CHK_MCFLT:" + AcctValidationIndexDef.CHK_MCFLT.toString() + ", value:" + AcctValidationIndexDef.CHK_MCFLT.getValue());
        System.out.println("AcctValidationIndexDef.CHK_MCPURC:" + AcctValidationIndexDef.CHK_MCPURC.toString() + ", value:" + AcctValidationIndexDef.CHK_MCPURC.getValue());
        System.out.println("AcctValidationIndexDef.CHK_PREPAID:" + AcctValidationIndexDef.CHK_PREPAID.toString() + ", value:" + AcctValidationIndexDef.CHK_PREPAID.getValue());
        System.out.println("AcctValidationIndexDef.CHK_VISAFLT:" + AcctValidationIndexDef.CHK_VISAFLT.toString() + ", value:" + AcctValidationIndexDef.CHK_VISAFLT.getValue());
        System.out.println("AcctValidationIndexDef.CHK_ENMARK:" + AcctValidationIndexDef.CHK_ENMARK.toString() + ", value:" + AcctValidationIndexDef.CHK_ENMARK.getValue());
        System.out.println("AcctValidationIndexDef.CHK_PNS:" + AcctValidationIndexDef.CHK_PNS.toString() + ", value:" + AcctValidationIndexDef.CHK_PNS.getValue());
        System.out.println("AcctValidationIndexDef.CHK_MOTOMART:" + AcctValidationIndexDef.CHK_MOTOMART.toString() + ", value:" + AcctValidationIndexDef.CHK_MOTOMART.getValue());
        System.out.println("AcctValidationIndexDef.CHK_GATE:" + AcctValidationIndexDef.CHK_GATE.toString() + ", value:" + AcctValidationIndexDef.CHK_GATE.getValue());
        System.out.println("AcctValidationIndexDef.CHK_TCH_LT:" + AcctValidationIndexDef.CHK_TCH_LT.toString() + ", value:" + AcctValidationIndexDef.CHK_TCH_LT.getValue());
        System.out.println("AcctValidationIndexDef.CHK_FLEET_ONE:" + AcctValidationIndexDef.CHK_FLEET_ONE.toString() + ", value:" + AcctValidationIndexDef.CHK_FLEET_ONE.getValue());
        System.out.println("AcctValidationIndexDef.CHK_BP:" + AcctValidationIndexDef.CHK_BP.toString() + ", value:" + AcctValidationIndexDef.CHK_BP.getValue());
        System.out.println("AcctValidationIndexDef.CHK_API:" + AcctValidationIndexDef.CHK_API.toString() + ", value:" + AcctValidationIndexDef.CHK_API.getValue());
        System.out.println("AcctValidationIndexDef.CHK_GULF:" + AcctValidationIndexDef.CHK_GULF.toString() + ", value:" + AcctValidationIndexDef.CHK_GULF.getValue());
        System.out.println("AcctValidationIndexDef.CHK_SUNOCO:" + AcctValidationIndexDef.CHK_SUNOCO.toString() + ", value:" + AcctValidationIndexDef.CHK_SUNOCO.getValue());
        System.out.println("AcctValidationIndexDef.CHK_SUN_CANADA:" + AcctValidationIndexDef.CHK_SUN_CANADA.toString() + ", value:" + AcctValidationIndexDef.CHK_SUN_CANADA.getValue());
        System.out.println("AcctValidationIndexDef.CHK_TESORO:" + AcctValidationIndexDef.CHK_TESORO.toString() + ", value:" + AcctValidationIndexDef.CHK_TESORO.getValue());
        System.out.println("AcctValidationIndexDef.CHK_BUYPROP:" + AcctValidationIndexDef.CHK_BUYPROP.toString() + ", value:" + AcctValidationIndexDef.CHK_BUYPROP.getValue());
        System.out.println("AcctValidationIndexDef.CHK_GASCRD:" + AcctValidationIndexDef.CHK_GASCRD.toString() + ", value:" + AcctValidationIndexDef.CHK_GASCRD.getValue());
        System.out.println("AcctValidationIndexDef.CHK_CENEX:" + AcctValidationIndexDef.CHK_CENEX.toString() + ", value:" + AcctValidationIndexDef.CHK_CENEX.getValue());
        System.out.println("AcctValidationIndexDef.CHK_DMD:" + AcctValidationIndexDef.CHK_DMD.toString() + ", value:" + AcctValidationIndexDef.CHK_DMD.getValue());
        System.out.println("AcctValidationIndexDef.CHK_UDSFLEET:" + AcctValidationIndexDef.CHK_UDSFLEET.toString() + ", value:" + AcctValidationIndexDef.CHK_UDSFLEET.getValue());
        System.out.println("AcctValidationIndexDef.CHK_VALERO:" + AcctValidationIndexDef.CHK_VALERO.toString() + ", value:" + AcctValidationIndexDef.CHK_VALERO.getValue());
        System.out.println("AcctValidationIndexDef.CHK_TEX:" + AcctValidationIndexDef.CHK_TEX.toString() + ", value:" + AcctValidationIndexDef.CHK_TEX.getValue());
        System.out.println("AcctValidationIndexDef.CHK_SHELL:" + AcctValidationIndexDef.CHK_SHELL.toString() + ", value:" + AcctValidationIndexDef.CHK_SHELL.getValue());
        System.out.println("AcctValidationIndexDef.CHK_CHEVRON:" + AcctValidationIndexDef.CHK_CHEVRON.toString() + ", value:" + AcctValidationIndexDef.CHK_CHEVRON.getValue());
        System.out.println("AcctValidationIndexDef.CHK_ROADSMITH:" + AcctValidationIndexDef.CHK_ROADSMITH.toString() + ", value:" + AcctValidationIndexDef.CHK_ROADSMITH.getValue());
    }
}
