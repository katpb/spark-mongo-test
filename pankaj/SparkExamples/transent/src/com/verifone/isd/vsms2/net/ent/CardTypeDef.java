/*
 * CardTypeDef.java
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
import java.io.InputStream;

/** Type-safe enumeration of Card Definitions
 * This class will assign the proper values for each application to all
 * card definitions in the application.  It is possible that not
 * all card types will be defined for every application, in fact this is
 * expected as not all apps accept all cards.
 * @author Bhanu_N2
 */
public class CardTypeDef implements java.io.Serializable
{

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDef.class);
	private static final long serialVersionUID = -2419505101371488240L;
    private transient int value;
    private transient String name;
    private static int UNDEFINED = -1;
    private static Properties prop = null;
    private transient boolean valid;    

    static {
        String propFile = "CardTypeDef.prop";
        prop = new Properties();
        InputStream inStream = null;
        // Read properties file.
        try {
            inStream = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
            prop.load(inStream); 
        } catch (IOException e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDef.class)
                    .error( "Error loading CardTypeDef.properties file:" + propFile + " " + e.getMessage());
        }
        finally {
            if (null != inStream) {
                try {
                    inStream.close();
                }
                catch (IOException ioe) {}
            }
        }
    }
    /** Constructor to allow subclassing
     * @param name Card Name code's name
     */
    protected CardTypeDef(String name) {
        String cardValue = prop.getProperty(name);

        if (cardValue != null && cardValue.length() > 0){
            this.value = Integer.parseInt(cardValue.trim(), 10);      // From properties file.
            this.valid = true;
        } else {
            this.value = UNDEFINED;
        }
        this.name = name;
    }

//    protected abstract Object getProcessor();

    /** Override toString() method to provide the Card def's name
     * @return card definition name
     */
    public String toString() {
        return (this.name);
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
    
    /**
     * This method returns a CardTypeDef object with a value matching
     * the value parameter.  Note: this is not the object at the ordinal
     * position but the object containing a matching value.
     * @param value - The value to match to the objects value property.
     * @throws Exception if a value match is not found.
     * @return A CardTypeDef object.
     */    
     public static CardTypeDef getFromValue(int value) throws Exception
     {
        CardTypeDef[] defs = CardTypeDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].value == value) {
                return (defs[i]);
            }
        }                 
        
        String msg = "CardType:" + value + " not found in CardTypeDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDef.class).error( msg);
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

    //  Defined card types for use by all applications.  Individual values are set
    //  from a CardTypeDef.prop file unique to each application.
    public static CardTypeDef CARDTYPE_UNDEFINED       = new CardTypeDef("UNDEFINED");
    
    public static CardTypeDef CARDTYPE_SHELL_MC   = new CardTypeDef("SHELL_MC");
    public static CardTypeDef CARDTYPE_SHELLEXEC   = new CardTypeDef("SHELLEXEC");
    public static CardTypeDef CARDTYPE_SHLSPL  = new CardTypeDef("SHLSPL");
    public static CardTypeDef CARDTYPE_TEXACO  = new CardTypeDef("TEXACO");
    public static CardTypeDef CARDTYPE_TEX_FLEET  = new CardTypeDef("TEX_FLEET");
    public static CardTypeDef CARDTYPE_TEX_SPL  = new CardTypeDef("TEX_SPL");
    

    public static CardTypeDef CARD_CUSTOM1             = new CardTypeDef("CUSTOM1");
    public static CardTypeDef CARDTYPE_MASTERCARD      = new CardTypeDef("MASTERCARD");
    public static CardTypeDef CARDTYPE_VISA           = new CardTypeDef("VISA");
    public static CardTypeDef CARDTYPE_DEBIT = new CardTypeDef("DEBIT");
    public static CardTypeDef CARDTYPE_AMEX	 = new CardTypeDef("AMEX");
    public static CardTypeDef CARDTYPE_FEE	 = new CardTypeDef("FEE");	/* Customer Fee card */
    public static CardTypeDef CARDTYPE_DISCOVER	 = new CardTypeDef("DISCOVER");
    public static CardTypeDef CARDTYPE_SPCBIL 	 = new CardTypeDef("SPCBIL");	/* Customer special billing card */
    public static CardTypeDef CARDTYPE_MOTOR	 = new CardTypeDef("MOTOR");	/* Motor Club card */
    public static CardTypeDef CARDTYPE_PDEBIT	 = new CardTypeDef("PDEBIT");	/* Proprietary debit card */
    public static CardTypeDef CARDTYPE_WXPRESS   = new CardTypeDef("WXPRESS");	/* Wright Express card */
    public static CardTypeDef CARDTYPE_PFLEET	 = new CardTypeDef("PFLEET");	/* Proprietary fleet card */
    public static CardTypeDef CARDTYPE_PHH	 = new CardTypeDef("PHH");
    public static CardTypeDef CARDTYPE_CARTEB    = new CardTypeDef("CARTEB");	/* Carte Blanche */
    public static CardTypeDef CARDTYPE_CITMOTOR	= new CardTypeDef("CITMOTOR"); /* Carte Blanche, now CITGO Motor Card (Puerto Rico) */
    public static CardTypeDef CARDTYPE_CHECK     = new CardTypeDef("CHECK");	/* Electronic check card */
    public static CardTypeDef CARDTYPE_DINERS    = new CardTypeDef("DINERS");
    public static CardTypeDef CARDTYPE_SAFLEET	= new CardTypeDef("SAFLEET");	/* Super America Fleet card */
    public static CardTypeDef CARDTYPE_SACONSUMER	= new CardTypeDef("SACONSUMER");	/* Super America Consumer card */
    public static CardTypeDef CARDTYPE_CITFLEET2 = new CardTypeDef("CITFLEET2");
    public static CardTypeDef CARDTYPE_EBT		  = new CardTypeDef("EBT");		/* Generic EBT Card */
    public static CardTypeDef CARDTYPE_BEST 	  = new CardTypeDef("BEST");    /* Paymentech Private label - Best Petro */
    public static CardTypeDef CARDTYPE_GECC       = new CardTypeDef("GECC");  /* GECC - JCP */
    public static CardTypeDef CARDTYPE_JCB        = new CardTypeDef("JCB");  /* Japan Credit Bureau Card */
    public static CardTypeDef CARDTYPE_VISA_FLEET = new CardTypeDef("VISA_FLEET");
    public static CardTypeDef CARDTYPE_TYPE_25    = new CardTypeDef("TYPE_25");  /* Undefined */
    public static CardTypeDef CARDTYPE_GSA        = new CardTypeDef("GSA");  /* General Services Admin card */
    public static CardTypeDef CARDTYPE_SHLFLEET   = new CardTypeDef("SHLFLEET");  /* Shell Fleet card */
    public static CardTypeDef CARDTYPE_VOYAGER    = new CardTypeDef("VOYAGER");  /* Texaco Voyager FLeet card */
    public static CardTypeDef CARDTYPE_SA_VISA    = new CardTypeDef("SA_VISA");  /* Super America Visa */
    public static CardTypeDef CARDTYPE_PPREPAID	= new CardTypeDef("PPREPAID");  /* removed ucc - new prop prepaid card */
    public static CardTypeDef CARDTYPE_SVSPREPAID	= new CardTypeDef("SVSPREPAID");  /* SVS prepaid card */
    public static CardTypeDef CARDTYPE_PREPAID    = new CardTypeDef("PREPAID");  /* PrePaid card */
    public static CardTypeDef CARDTYPE_DONLEN	= new CardTypeDef("DONLEN");	/* Donlen Fleet */
    public static CardTypeDef CARDTYPE_FUELMAN	= new CardTypeDef("FUELMAN");	/* Fuelman Fleet */
    public static CardTypeDef CARDTYPE_FUELMANGAS = new CardTypeDef("FUELMANGAS");	/* Fuelman Gas card */
    public static CardTypeDef CARDTYPE_MCFLEET	= new CardTypeDef("MCFLEET");
    public static CardTypeDef CARDTYPE_MCPURCHASE = new CardTypeDef("MCPURCHASE");
    public static CardTypeDef CARDTYPE_CFI	= new CardTypeDef("CFI");

    public static CardTypeDef CARDTYPE_FLEETONE	= new CardTypeDef("FLEETONE");
    public static CardTypeDef CARDTYPE_EBT_FS	= new CardTypeDef("EBT_FS");
    public static CardTypeDef CARDTYPE_EBT_CASH	= new CardTypeDef("EBT_CASH");
    public static CardTypeDef CARDTYPE_URCONSUMER= new CardTypeDef("URCONSUMER");
    public static CardTypeDef CARDTYPE_URFLEET	= new CardTypeDef("URFLEET");
    public static CardTypeDef CARDTYPE_URPREPAID= new CardTypeDef("URPREPAID");
    public static CardTypeDef CARDTYPE_UNITED_FLEETSHARE = new CardTypeDef("UNITED_FLEETSHARE");
    public static CardTypeDef CARDTYPE_CLUB = new CardTypeDef("CLUB");			/* Paymentech Club card */
    public static CardTypeDef CARDTYPE_ENMARK = new CardTypeDef("ENMARK");		/* Paymentech Enmark card */
    public static CardTypeDef CARDTYPE_SITEOIL = new CardTypeDef("SITEOIL");	/* Paymentech private label - Site Oil */
    public static CardTypeDef CARDTYPE_SIMONSON = new CardTypeDef("SIMONSON");	/* Paymentech private lavel - Simonson */
    public static CardTypeDef CARDTYPE_MOTOMART = new CardTypeDef("MOTOMART");	/* Motomart card */
    public static CardTypeDef CARDTYPE_GATE = new CardTypeDef("GATE");	        /* Gate Fleet card */
    public static CardTypeDef CARDTYPE_TCRS = new CardTypeDef("TCRS");	        /* Irving Oil Canadian (Trans Canada Retail Services) */
    public static CardTypeDef CARDTYPE_TCH_LT = new CardTypeDef("TCH_LT");	    /* Irving Oil Light */
    public static CardTypeDef CARDTYPE_ROADSMITH = new CardTypeDef("ROADSMITH"); /* WEX Roadsmith */
    public static CardTypeDef CARDTYPE_UDS_FLEET = new CardTypeDef("UDS_FLEET"); /* Buypass UDS Fleet */
    public static CardTypeDef CARDTYPE_INTLAUTO = new CardTypeDef("INTLAUTO"); /* Buypass International Auto */
    public static CardTypeDef CARDTYPE_MSPREPAID = new CardTypeDef("MSPREPAID"); /* Citgo - Prepaid MetroSplash */
    public static CardTypeDef CARDTYPE_PP_METROSPLASH = new CardTypeDef("PP_METROSPLASH"); /* Card Type used by ADS */

    public static CardTypeDef CARDTYPE_SIN_FLEET = new CardTypeDef("SIN_FLEET");
    public static CardTypeDef CARDTYPE_SVC = new CardTypeDef("SVC");
    public static CardTypeDef CARDTYPE_SINCLAIR = new CardTypeDef("SINCLAIR");
    public static CardTypeDef CARDTYPE_CENEX_PROP = new CardTypeDef("CENEX_PROP");
    public static CardTypeDef CARDTYPE_TESORO_AK = new CardTypeDef("TESORO_AK");
    public static CardTypeDef CARDTYPE_CALIF = new CardTypeDef("CALIF");
    public static CardTypeDef CARDTYPE_UNITED_REF = new CardTypeDef("UNITED_REF");
    public static CardTypeDef CARDTYPE_FLEETSMART = new CardTypeDef("FLEETSMART");
    public static CardTypeDef CARDTYPE_KIEL = new CardTypeDef("KIEL");
    public static CardTypeDef CARDTYPE_VISAFLEET = new CardTypeDef("VISAFLEET");
    public static CardTypeDef CARDTYPE_GASCARD = new CardTypeDef("GASCARD");
    public static CardTypeDef CARDTYPE_DM_UCC = new CardTypeDef("DM_UCC");
    public static CardTypeDef CARDTYPE_UNIV = new CardTypeDef("UNIV");
    public static CardTypeDef CARDTYPE_CXPRESS = new CardTypeDef("CXPRESS");
    public static CardTypeDef CARDTYPE_GULF = new CardTypeDef("GULF");
    public static CardTypeDef CARDTYPE_SUNOCO = new CardTypeDef("SUNOCO_CARD");
    public static CardTypeDef CARDTYPE_SUNOCO_FLEET = new CardTypeDef("SUNOCO_FLEET");
    public static CardTypeDef CARDTYPE_GENERIC_BP = new CardTypeDef("GENERIC_BP");
    public static CardTypeDef CARDTYPE_DMD_PROP = new CardTypeDef("DMD_PROP");
    public static CardTypeDef CARDTYPE_VALERO_PROP = new CardTypeDef("VALERO_PROP");
    public static CardTypeDef CARDTYPE_VALERO_FLEET = new CardTypeDef("VALERO_FLEET");
    public static CardTypeDef CARDTYPE_SVC_1 = new CardTypeDef("SVC_1");
    public static CardTypeDef CARDTYPE_SVC_2 = new CardTypeDef("SVC_2");
    public static CardTypeDef CARDTYPE_SVC_3 = new CardTypeDef("SVC_3");
    public static CardTypeDef CARDTYPE_SVC_4 = new CardTypeDef("SVC_4");
    public static CardTypeDef CARDTYPE_SVC_5 = new CardTypeDef("SVC_5");

    public static CardTypeDef CARDTYPE_MTEC_FLEET1 = new CardTypeDef("MTEC_FLEET1");
    public static CardTypeDef CARDTYPE_MTEC_FLEET2 = new CardTypeDef("MTEC_FLEET2");
    public static CardTypeDef CARDTYPE_MTEC_FLEET3 = new CardTypeDef("MTEC_FLEET3");
    public static CardTypeDef CARDTYPE_MTEC_FLEET4 = new CardTypeDef("MTEC_FLEET4");
    
    public static CardTypeDef CARDTYPE_MTEC_FLEET5 = new CardTypeDef("MTEC_FLEET5");
    public static CardTypeDef CARDTYPE_MTEC_FLEET6 = new CardTypeDef("MTEC_FLEET6");
    public static CardTypeDef CARDTYPE_MTEC_FLEET7 = new CardTypeDef("MTEC_FLEET7");
    public static CardTypeDef CARDTYPE_MTEC_FLEET8 = new CardTypeDef("MTEC_FLEET8");
    public static CardTypeDef CARDTYPE_MTEC_FLEET9 = new CardTypeDef("MTEC_FLEET9");
    public static CardTypeDef CARDTYPE_MTEC_FLEET10 = new CardTypeDef("MTEC_FLEET10");
    public static CardTypeDef CARDTYPE_MTEC_FLEET11 = new CardTypeDef("MTEC_FLEET11");
    public static CardTypeDef CARDTYPE_MTEC_FLEET12 = new CardTypeDef("MTEC_FLEET12");
    public static CardTypeDef CARDTYPE_MTEC_FLEET13 = new CardTypeDef("MTEC_FLEET13");
    public static CardTypeDef CARDTYPE_MTEC_FLEET14 = new CardTypeDef("MTEC_FLEET14");
    public static CardTypeDef CARDTYPE_MTEC_FLEET15 = new CardTypeDef("MTEC_FLEET15");
    
	public static CardTypeDef CARDTYPE_SHELLNEW0 = new CardTypeDef("SHELLNEW0");   	
    public static CardTypeDef CARDTYPE_SHELLNEW1 = new CardTypeDef("SHELLNEW1");
    public static CardTypeDef CARDTYPE_SHELLNEW2 = new CardTypeDef("SHELLNEW2");
    public static CardTypeDef CARDTYPE_SHELLNEW3 = new CardTypeDef("SHELLNEW3");
    public static CardTypeDef CARDTYPE_SHELLNEW4 = new CardTypeDef("SHELLNEW4");
    public static CardTypeDef CARDTYPE_SHELLNEW5 = new CardTypeDef("SHELLNEW5");
    public static CardTypeDef CARDTYPE_SHELLNEW6 = new CardTypeDef("SHELLNEW6");
    public static CardTypeDef CARDTYPE_SHELLNEW7 = new CardTypeDef("SHELLNEW7");
    public static CardTypeDef CARDTYPE_SHELLNEW8 = new CardTypeDef("SHELLNEW8");
    public static CardTypeDef CARDTYPE_SHELLNEW9 = new CardTypeDef("SHELLNEW9");
	public static CardTypeDef CARDTYPE_UNKNOWN      = new CardTypeDef("UNKNOWN");
    public static CardTypeDef CARDTYPE_SH_SHELL = new CardTypeDef("SHELL");
    public static CardTypeDef CARDTYPE_SH_CANADA_FLT = new CardTypeDef("CANADA_FLT");
	public static CardTypeDef CARDTYPE_SH_LOYALTY_A = new CardTypeDef("LOYALTY_A");
	public static CardTypeDef CARDTYPE_SH_LOYALTY_B = new CardTypeDef("LOYALTY_B");
	public static CardTypeDef CARDTYPE_SH_CASH = new CardTypeDef("CASH");
	public static CardTypeDef CARDTYPE_SH_PREPAID_A = new CardTypeDef("PREPAID_A");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT13 = new CardTypeDef("CUSTOM_FLT13");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT14 = new CardTypeDef("CUSTOM_FLT14");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT15 = new CardTypeDef("CUSTOM_FLT15");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT16 = new CardTypeDef("CUSTOM_FLT16");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT17 = new CardTypeDef("CUSTOM_FLT17");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT18 = new CardTypeDef("CUSTOM_FLT18");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT19 = new CardTypeDef("CUSTOM_FLT19");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT20 = new CardTypeDef("CUSTOM_FLT20");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT21 = new CardTypeDef("CUSTOM_FLT21");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT22 = new CardTypeDef("CUSTOM_FLT22");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT23 = new CardTypeDef("CUSTOM_FLT23");
	public static CardTypeDef CARDTYPE_CUSTOM_FLT24 = new CardTypeDef("CUSTOM_FLT24");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //card Def's ; auto-incremented

    //  As of 1/19/2005 these are the cards defined for ADS and Buypass.  As more apps
    //  are developed this list could grow.
    private static final CardTypeDef[] VALUES = {
        CARDTYPE_UNDEFINED, CARDTYPE_SHELL_MC, CARDTYPE_SHELLEXEC, CARDTYPE_SHLSPL, 
        CARDTYPE_TEXACO, CARDTYPE_TEX_FLEET, CARDTYPE_TEX_SPL, 
        CARD_CUSTOM1, CARDTYPE_MASTERCARD, CARDTYPE_VISA, CARDTYPE_DEBIT , CARDTYPE_AMEX , CARDTYPE_FEE,
        CARDTYPE_DISCOVER , CARDTYPE_SPCBIL , CARDTYPE_MOTOR , CARDTYPE_PDEBIT , CARDTYPE_WXPRESS , CARDTYPE_PFLEET ,
        CARDTYPE_PHH , CARDTYPE_CARTEB, CARDTYPE_CITMOTOR , CARDTYPE_CHECK , CARDTYPE_DINERS ,
        CARDTYPE_SAFLEET , CARDTYPE_SACONSUMER ,
        CARDTYPE_CITFLEET2 , CARDTYPE_EBT , CARDTYPE_BEST , CARDTYPE_GECC ,
        CARDTYPE_JCB, CARDTYPE_VISA_FLEET, CARDTYPE_TYPE_25, CARDTYPE_GSA, CARDTYPE_SHLFLEET, CARDTYPE_VOYAGER,
        CARDTYPE_SA_VISA, CARDTYPE_PPREPAID, CARDTYPE_SVSPREPAID, CARDTYPE_PREPAID, CARDTYPE_DONLEN, CARDTYPE_FUELMAN, CARDTYPE_FUELMANGAS,
        CARDTYPE_MCFLEET, CARDTYPE_MCPURCHASE, CARDTYPE_CFI, CARDTYPE_FLEETONE, CARDTYPE_EBT_FS, CARDTYPE_EBT_CASH,
        CARDTYPE_URCONSUMER, CARDTYPE_URFLEET, CARDTYPE_URPREPAID, CARDTYPE_UNITED_FLEETSHARE, CARDTYPE_CLUB,
		CARDTYPE_ENMARK, CARDTYPE_SITEOIL, CARDTYPE_SIMONSON, CARDTYPE_MOTOMART,
		CARDTYPE_GATE, CARDTYPE_TCRS, CARDTYPE_TCH_LT, CARDTYPE_ROADSMITH, CARDTYPE_UDS_FLEET, CARDTYPE_INTLAUTO,
        CARDTYPE_MSPREPAID, CARDTYPE_PP_METROSPLASH, CARDTYPE_SIN_FLEET, CARDTYPE_SVC, CARDTYPE_SINCLAIR, 
        CARDTYPE_CENEX_PROP, CARDTYPE_TESORO_AK, CARDTYPE_CALIF, CARDTYPE_UNITED_REF, CARDTYPE_FLEETSMART,
		CARDTYPE_KIEL, CARDTYPE_VISAFLEET, CARDTYPE_GASCARD, CARDTYPE_DM_UCC, CARDTYPE_UNIV, 
		CARDTYPE_CXPRESS, CARDTYPE_GULF, CARDTYPE_SUNOCO, CARDTYPE_SUNOCO_FLEET, CARDTYPE_GENERIC_BP, CARDTYPE_DMD_PROP, CARDTYPE_VALERO_PROP, 
		CARDTYPE_VALERO_FLEET, CARDTYPE_SVC_1, CARDTYPE_SVC_2, CARDTYPE_SVC_3, CARDTYPE_SVC_4, CARDTYPE_SVC_5, 
        CARDTYPE_MTEC_FLEET1,
        CARDTYPE_MTEC_FLEET2, CARDTYPE_MTEC_FLEET3, CARDTYPE_MTEC_FLEET4, CARDTYPE_MTEC_FLEET5, CARDTYPE_MTEC_FLEET6,
        CARDTYPE_MTEC_FLEET7, CARDTYPE_MTEC_FLEET8, CARDTYPE_MTEC_FLEET9, CARDTYPE_MTEC_FLEET10, CARDTYPE_MTEC_FLEET11,
        CARDTYPE_MTEC_FLEET12, CARDTYPE_MTEC_FLEET13, CARDTYPE_MTEC_FLEET14, CARDTYPE_MTEC_FLEET15,
    	CARDTYPE_SHELLNEW0, CARDTYPE_SHELLNEW1, CARDTYPE_SHELLNEW2, CARDTYPE_SHELLNEW3, 
    	CARDTYPE_SHELLNEW4, CARDTYPE_SHELLNEW5, CARDTYPE_SHELLNEW6, CARDTYPE_SHELLNEW7, 
    	CARDTYPE_SHELLNEW8, CARDTYPE_SHELLNEW9, CARDTYPE_UNKNOWN, CARDTYPE_SH_SHELL, 
    	CARDTYPE_SH_CANADA_FLT, CARDTYPE_SH_LOYALTY_A, CARDTYPE_SH_LOYALTY_B, 
    	CARDTYPE_SH_CASH, CARDTYPE_SH_PREPAID_A,
    	CARDTYPE_CUSTOM_FLT13, CARDTYPE_CUSTOM_FLT14, CARDTYPE_CUSTOM_FLT15, CARDTYPE_CUSTOM_FLT16,
    	CARDTYPE_CUSTOM_FLT17, CARDTYPE_CUSTOM_FLT18, CARDTYPE_CUSTOM_FLT19, CARDTYPE_CUSTOM_FLT20,
    	CARDTYPE_CUSTOM_FLT21, CARDTYPE_CUSTOM_FLT22, CARDTYPE_CUSTOM_FLT23, CARDTYPE_CUSTOM_FLT24 
    };

    public static final CardTypeDef CARDTYPE_MTEC_MIN = CARDTYPE_MTEC_FLEET1;
    public static final CardTypeDef CARDTYPE_MTEC_MAX = CARDTYPE_MTEC_FLEET15;    
    
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
    
    public boolean isValid() {
        return this.valid;
    }

    /** Method to get the CardTypeDef.object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return CardTypeDef.object representing the ordinal
     */
    protected static CardTypeDef getObject(int ordinal) {
        if (ordinal < 0 || ordinal >= VALUES.length) {
            return null;
        }
        return VALUES[ordinal];
    }
    
    public static CardTypeDef getObjectByName(String name) throws Exception {
        CardTypeDef[] defs = CardTypeDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].name.equals(name)) {
                return (defs[i]);
            }
        }                 
        String msg = "CardType:" + name + " not found in CardTypeDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDef.class).error( msg);
        throw new Exception(msg);        
    }

    /** Getter for all the CardTypeDef.objects
     * @return array of Card Definitions
     */
    public static CardTypeDef[] getObjects() {
        CardTypeDef[] defs = new CardTypeDef[VALUES.length];
        System.arraycopy(VALUES, 0, defs, 0, VALUES.length);
        return defs;
    }

    /** Test method
     * @param args params to the test
     */

    public static void main(String[] args) {
        CardTypeDef[] defs = CardTypeDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("Code: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }

        System.out.println("CardTypeDef.CARDTYPE_UNDEFINED:" + CardTypeDef.CARDTYPE_UNDEFINED.toString() + ", value:" + CardTypeDef.CARDTYPE_UNDEFINED.getValue());
        System.out.println("CardTypeDef.CARD_CUSTOM1:" + CardTypeDef.CARD_CUSTOM1.toString() + ", value:" + CardTypeDef.CARD_CUSTOM1.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MASTERCARD:" + CardTypeDef.CARDTYPE_MASTERCARD.toString() + ", value:" + CardTypeDef.CARDTYPE_MASTERCARD.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VISA:" + CardTypeDef.CARDTYPE_VISA.toString() + ", value:" + CardTypeDef.CARDTYPE_VISA.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DEBIT:" + CardTypeDef.CARDTYPE_DEBIT.toString() + ", value:" + CardTypeDef.CARDTYPE_DEBIT.getValue());
        System.out.println("CardTypeDef.CARDTYPE_AMEX:" + CardTypeDef.CARDTYPE_AMEX.toString() + ", value:" + CardTypeDef.CARDTYPE_AMEX.getValue());
        System.out.println("CardTypeDef.CARDTYPE_FEE:" + CardTypeDef.CARDTYPE_FEE.toString() + ", value:" + CardTypeDef.CARDTYPE_FEE.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DISCOVER:" + CardTypeDef.CARDTYPE_DISCOVER.toString() + ", value:" + CardTypeDef.CARDTYPE_DISCOVER.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SPCBIL:" + CardTypeDef.CARDTYPE_SPCBIL.toString() + ", value:" + CardTypeDef.CARDTYPE_SPCBIL.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MOTOR:" + CardTypeDef.CARDTYPE_MOTOR.toString() + ", value:" + CardTypeDef.CARDTYPE_MOTOR.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PDEBIT:" + CardTypeDef.CARDTYPE_PDEBIT.toString() + ", value:" + CardTypeDef.CARDTYPE_PDEBIT.getValue());
        System.out.println("CardTypeDef.CARDTYPE_WXPRESS:" + CardTypeDef.CARDTYPE_WXPRESS.toString() + ", value:" + CardTypeDef.CARDTYPE_WXPRESS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PFLEET:" + CardTypeDef.CARDTYPE_PFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_PFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PHH:" + CardTypeDef.CARDTYPE_PHH.toString() + ", value:" + CardTypeDef.CARDTYPE_PHH.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CARTEB:" + CardTypeDef.CARDTYPE_CARTEB.toString() + ", value:" + CardTypeDef.CARDTYPE_CARTEB.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CITMOTOR:" + CardTypeDef.CARDTYPE_CITMOTOR.toString() + ", value:" + CardTypeDef.CARDTYPE_CITMOTOR.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CHECK:" + CardTypeDef.CARDTYPE_CHECK.toString() + ", value:" + CardTypeDef.CARDTYPE_CHECK.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DINERS:" + CardTypeDef.CARDTYPE_DINERS.toString() + ", value:" + CardTypeDef.CARDTYPE_DINERS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SAFLEET:" + CardTypeDef.CARDTYPE_SAFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_SAFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SACONSUMER:" + CardTypeDef.CARDTYPE_SACONSUMER.toString() + ", value:" + CardTypeDef.CARDTYPE_SACONSUMER.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CITFLEET2:" + CardTypeDef.CARDTYPE_CITFLEET2.toString() + ", value:" + CardTypeDef.CARDTYPE_CITFLEET2.getValue());
        System.out.println("CardTypeDef.CARDTYPE_EBT:" + CardTypeDef.CARDTYPE_EBT.toString() + ", value:" + CardTypeDef.CARDTYPE_EBT.getValue());
        System.out.println("CardTypeDef.CARDTYPE_BEST:" + CardTypeDef.CARDTYPE_BEST.toString() + ", value:" + CardTypeDef.CARDTYPE_BEST.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GECC:" + CardTypeDef.CARDTYPE_GECC.toString() + ", value:" + CardTypeDef.CARDTYPE_GECC.getValue());
        System.out.println("CardTypeDef.CARDTYPE_JCB:" + CardTypeDef.CARDTYPE_JCB.toString() + ", value:" + CardTypeDef.CARDTYPE_JCB.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VISA_FLEET:" + CardTypeDef.CARDTYPE_VISA_FLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_VISA_FLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_TYPE_25:" + CardTypeDef.CARDTYPE_TYPE_25.toString() + ", value:" + CardTypeDef.CARDTYPE_TYPE_25.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GSA:" + CardTypeDef.CARDTYPE_GSA.toString() + ", value:" + CardTypeDef.CARDTYPE_GSA.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHLFLEET:" + CardTypeDef.CARDTYPE_SHLFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_SHLFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VOYAGER:" + CardTypeDef.CARDTYPE_VOYAGER.toString() + ", value:" + CardTypeDef.CARDTYPE_VOYAGER.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SA_VISA:" + CardTypeDef.CARDTYPE_SA_VISA.toString() + ", value:" + CardTypeDef.CARDTYPE_SA_VISA.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PPREPAID:" + CardTypeDef.CARDTYPE_PPREPAID.toString() + ", value:" + CardTypeDef.CARDTYPE_PPREPAID.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVSPREPAID:" + CardTypeDef.CARDTYPE_SVSPREPAID.toString() + ", value:" + CardTypeDef.CARDTYPE_SVSPREPAID.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PREPAID:" + CardTypeDef.CARDTYPE_PREPAID.toString() + ", value:" + CardTypeDef.CARDTYPE_PREPAID.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DONLEN:" + CardTypeDef.CARDTYPE_DONLEN.toString() + ", value:" + CardTypeDef.CARDTYPE_DONLEN.getValue());
        System.out.println("CardTypeDef.CARDTYPE_FUELMAN:" + CardTypeDef.CARDTYPE_FUELMAN.toString() + ", value:" + CardTypeDef.CARDTYPE_FUELMAN.getValue());
        System.out.println("CardTypeDef.CARDTYPE_FUELMANGAS:" + CardTypeDef.CARDTYPE_FUELMANGAS.toString() + ", value:" + CardTypeDef.CARDTYPE_FUELMANGAS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MCFLEET:" + CardTypeDef.CARDTYPE_MCFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_MCFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MCPURCHASE:" + CardTypeDef.CARDTYPE_MCPURCHASE.toString() + ", value:" + CardTypeDef.CARDTYPE_MCPURCHASE.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CFI:" + CardTypeDef.CARDTYPE_CFI.toString() + ", value:" + CardTypeDef.CARDTYPE_CFI.getValue());
        System.out.println("CardTypeDef.CARDTYPE_FLEETONE:" + CardTypeDef.CARDTYPE_FLEETONE.toString() + ", value:" + CardTypeDef.CARDTYPE_FLEETONE.getValue());
        System.out.println("CardTypeDef.CARDTYPE_EBT_FS:" + CardTypeDef.CARDTYPE_EBT_FS.toString() + ", value:" + CardTypeDef.CARDTYPE_EBT_FS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_EBT_CASH:" + CardTypeDef.CARDTYPE_EBT_CASH.toString() + ", value:" + CardTypeDef.CARDTYPE_EBT_CASH.getValue());
        System.out.println("CardTypeDef.CARDTYPE_URCONSUMER:" + CardTypeDef.CARDTYPE_URCONSUMER.toString() + ", value:" + CardTypeDef.CARDTYPE_URCONSUMER.getValue());
        System.out.println("CardTypeDef.CARDTYPE_URFLEET:" + CardTypeDef.CARDTYPE_URFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_URFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_URPREPAID:" + CardTypeDef.CARDTYPE_URPREPAID.toString() + ", value:" + CardTypeDef.CARDTYPE_URPREPAID.getValue());
        System.out.println("CardTypeDef.CARDTYPE_UNITED_FLEETSHARE:" + CardTypeDef.CARDTYPE_UNITED_FLEETSHARE.toString() + ", value:" + CardTypeDef.CARDTYPE_UNITED_FLEETSHARE.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CLUB:" + CardTypeDef.CARDTYPE_CLUB.toString() + ", value:" + CardTypeDef.CARDTYPE_CLUB.getValue());
        System.out.println("CardTypeDef.CARDTYPE_ENMARK:" + CardTypeDef.CARDTYPE_ENMARK.toString() + ", value:" + CardTypeDef.CARDTYPE_ENMARK.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SITEOIL:" + CardTypeDef.CARDTYPE_SITEOIL.toString() + ", value:" + CardTypeDef.CARDTYPE_SITEOIL.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SIMONSON:" + CardTypeDef.CARDTYPE_SIMONSON.toString() + ", value:" + CardTypeDef.CARDTYPE_SIMONSON.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MOTOMART:" + CardTypeDef.CARDTYPE_MOTOMART.toString() + ", value:" + CardTypeDef.CARDTYPE_MOTOMART.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GATE:" + CardTypeDef.CARDTYPE_GATE.toString() + ", value:" + CardTypeDef.CARDTYPE_GATE.getValue());
        System.out.println("CardTypeDef.CARDTYPE_TCRS:" + CardTypeDef.CARDTYPE_TCRS.toString() + ", value:" + CardTypeDef.CARDTYPE_TCRS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_TCH_LT:" + CardTypeDef.CARDTYPE_TCH_LT.toString() + ", value:" + CardTypeDef.CARDTYPE_TCH_LT.getValue());
        System.out.println("CardTypeDef.CARDTYPE_ROADSMITH:" + CardTypeDef.CARDTYPE_ROADSMITH.toString() + ", value:" + CardTypeDef.CARDTYPE_ROADSMITH.getValue());
        System.out.println("CardTypeDef.CARDTYPE_UDS_FLEET:" + CardTypeDef.CARDTYPE_UDS_FLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_UDS_FLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_INTLAUTO:" + CardTypeDef.CARDTYPE_INTLAUTO.toString() + ", value:" + CardTypeDef.CARDTYPE_INTLAUTO.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MSPREPAID:" + CardTypeDef.CARDTYPE_MSPREPAID.toString() + ", value:" + CardTypeDef.CARDTYPE_MSPREPAID.getValue());
        System.out.println("CardTypeDef.CARDTYPE_PP_METROSPLASH:" + CardTypeDef.CARDTYPE_PP_METROSPLASH.toString() + ", value:" + CardTypeDef.CARDTYPE_PP_METROSPLASH.getValue());

        System.out.println("CardTypeDef.CARDTYPE_SIN_FLEET:" + CardTypeDef.CARDTYPE_SIN_FLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_SIN_FLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SINCLAIR:" + CardTypeDef.CARDTYPE_SINCLAIR.toString() + ", value:" + CardTypeDef.CARDTYPE_SINCLAIR.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CENEX_PROP:" + CardTypeDef.CARDTYPE_CENEX_PROP.toString() + ", value:" + CardTypeDef.CARDTYPE_CENEX_PROP.getValue());
        System.out.println("CardTypeDef.CARDTYPE_TESORO_AK:" + CardTypeDef.CARDTYPE_TESORO_AK.toString() + ", value:" + CardTypeDef.CARDTYPE_TESORO_AK.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CALIF:" + CardTypeDef.CARDTYPE_CALIF.toString() + ", value:" + CardTypeDef.CARDTYPE_CALIF.getValue());
        System.out.println("CardTypeDef.CARDTYPE_UNITED_REF:" + CardTypeDef.CARDTYPE_UNITED_REF.toString() + ", value:" + CardTypeDef.CARDTYPE_UNITED_REF.getValue());
        System.out.println("CardTypeDef.CARDTYPE_FLEETSMART:" + CardTypeDef.CARDTYPE_FLEETSMART.toString() + ", value:" + CardTypeDef.CARDTYPE_FLEETSMART.getValue());
        System.out.println("CardTypeDef.CARDTYPE_KIEL:" + CardTypeDef.CARDTYPE_KIEL.toString() + ", value:" + CardTypeDef.CARDTYPE_KIEL.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VISAFLEET:" + CardTypeDef.CARDTYPE_VISAFLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_VISAFLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GASCARD:" + CardTypeDef.CARDTYPE_GASCARD.toString() + ", value:" + CardTypeDef.CARDTYPE_GASCARD.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DM_UCC:" + CardTypeDef.CARDTYPE_DM_UCC.toString() + ", value:" + CardTypeDef.CARDTYPE_DM_UCC.getValue());
        System.out.println("CardTypeDef.CARDTYPE_UNIV:" + CardTypeDef.CARDTYPE_UNIV.toString() + ", value:" + CardTypeDef.CARDTYPE_UNIV.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CXPRESS:" + CardTypeDef.CARDTYPE_CXPRESS.toString() + ", value:" + CardTypeDef.CARDTYPE_CXPRESS.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GULF:" + CardTypeDef.CARDTYPE_GULF.toString() + ", value:" + CardTypeDef.CARDTYPE_GULF.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SUNOCO:" + CardTypeDef.CARDTYPE_SUNOCO.toString() + ", value:" + CardTypeDef.CARDTYPE_SUNOCO.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SUNOCO_FLEET:" + CardTypeDef.CARDTYPE_SUNOCO_FLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_SUNOCO_FLEET.getValue());
        System.out.println("CardTypeDef.CARDTYPE_GENERIC_BP:" + CardTypeDef.CARDTYPE_GENERIC_BP.toString() + ", value:" + CardTypeDef.CARDTYPE_GENERIC_BP.getValue());
        System.out.println("CardTypeDef.CARDTYPE_DMD_PROP:" + CardTypeDef.CARDTYPE_DMD_PROP.toString() + ", value:" + CardTypeDef.CARDTYPE_DMD_PROP.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VALERO_PROP:" + CardTypeDef.CARDTYPE_VALERO_PROP.toString() + ", value:" + CardTypeDef.CARDTYPE_DMD_PROP.getValue());
        System.out.println("CardTypeDef.CARDTYPE_VALERO_FLEET:" + CardTypeDef.CARDTYPE_VALERO_FLEET.toString() + ", value:" + CardTypeDef.CARDTYPE_DMD_PROP.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC_1:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC_1.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC_2:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC_2.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC_3:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC_3.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC_4:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC_4.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SVC_5:" + CardTypeDef.CARDTYPE_SVC.toString() + ", value:" + CardTypeDef.CARDTYPE_SVC_5.getValue());

        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET1:" + CardTypeDef.CARDTYPE_MTEC_FLEET1.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET1.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET2:" + CardTypeDef.CARDTYPE_MTEC_FLEET2.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET2.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET3:" + CardTypeDef.CARDTYPE_MTEC_FLEET3.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET3.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET4:" + CardTypeDef.CARDTYPE_MTEC_FLEET4.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET4.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET5:" + CardTypeDef.CARDTYPE_MTEC_FLEET5.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET5.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET6:" + CardTypeDef.CARDTYPE_MTEC_FLEET6.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET6.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET7:" + CardTypeDef.CARDTYPE_MTEC_FLEET7.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET7.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET8:" + CardTypeDef.CARDTYPE_MTEC_FLEET8.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET8.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET9:" + CardTypeDef.CARDTYPE_MTEC_FLEET9.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET9.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET10:" + CardTypeDef.CARDTYPE_MTEC_FLEET10.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET10.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET11:" + CardTypeDef.CARDTYPE_MTEC_FLEET11.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET11.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET12:" + CardTypeDef.CARDTYPE_MTEC_FLEET12.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET12.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET13:" + CardTypeDef.CARDTYPE_MTEC_FLEET13.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET13.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET14:" + CardTypeDef.CARDTYPE_MTEC_FLEET14.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET14.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_FLEET15:" + CardTypeDef.CARDTYPE_MTEC_FLEET15.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_FLEET15.getValue());
        System.out.println("CardTypeDef.CARDTYPE_MTEC_MAX:" + CardTypeDef.CARDTYPE_MTEC_MAX.toString() + ", value:" + CardTypeDef.CARDTYPE_MTEC_MAX.getValue());
		
	System.out.println("CardTypeDef.CARDTYPE_SHELL_MC:" + CardTypeDef.CARDTYPE_SHELL_MC.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELL_MC.getValue());
	System.out.println("CardTypeDef.CARDTYPE_SHELLEXEC:" + CardTypeDef.CARDTYPE_SHELLEXEC.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLEXEC.getValue());
	System.out.println("CardTypeDef.CARDTYPE_SHLSPL:" + CardTypeDef.CARDTYPE_SHLSPL.toString() + ", value:" + CardTypeDef.CARDTYPE_SHLSPL.getValue());
	System.out.println("CardTypeDef.CARDTYPE_SHELLNEW0:" + CardTypeDef.CARDTYPE_SHELLNEW0.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW0.getValue());
	System.out.println("CardTypeDef.CARDTYPE_SHELLNEW1:" + CardTypeDef.CARDTYPE_SHELLNEW1.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW1.getValue());
	System.out.println("CardTypeDef.CARDTYPE_SHELLNEW2:" + CardTypeDef.CARDTYPE_SHELLNEW2.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW2.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW3:" + CardTypeDef.CARDTYPE_SHELLNEW3.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW3.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW4:" + CardTypeDef.CARDTYPE_SHELLNEW4.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW4.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW5:" + CardTypeDef.CARDTYPE_SHELLNEW5.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW5.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW6:" + CardTypeDef.CARDTYPE_SHELLNEW6.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW6.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW7:" + CardTypeDef.CARDTYPE_SHELLNEW7.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW7.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW8:" + CardTypeDef.CARDTYPE_SHELLNEW8.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW8.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SHELLNEW9:" + CardTypeDef.CARDTYPE_SHELLNEW9.toString() + ", value:" + CardTypeDef.CARDTYPE_SHELLNEW9.getValue());
        System.out.println("CardTypeDef.CARDTYPE_UNKNOWN:" + CardTypeDef.CARDTYPE_UNKNOWN.toString() + ", value:" + CardTypeDef.CARDTYPE_UNKNOWN.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_SHELL:" + CardTypeDef.CARDTYPE_SH_SHELL.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_SHELL.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_CANADA_FLT:" + CardTypeDef.CARDTYPE_SH_CANADA_FLT.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_CANADA_FLT.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_LOYALTY_A:" + CardTypeDef.CARDTYPE_SH_LOYALTY_A.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_LOYALTY_A.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_LOYALTY_B:" + CardTypeDef.CARDTYPE_SH_LOYALTY_B.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_LOYALTY_B.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_CASH:" + CardTypeDef.CARDTYPE_SH_CASH.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_CASH.getValue());
        System.out.println("CardTypeDef.CARDTYPE_SH_PREPAID_A:" + CardTypeDef.CARDTYPE_SH_PREPAID_A.toString() + ", value:" + CardTypeDef.CARDTYPE_SH_PREPAID_A.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT13:" + CardTypeDef.CARDTYPE_CUSTOM_FLT13.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT13.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT14:" + CardTypeDef.CARDTYPE_CUSTOM_FLT14.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT14.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT15:" + CardTypeDef.CARDTYPE_CUSTOM_FLT15.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT15.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT16:" + CardTypeDef.CARDTYPE_CUSTOM_FLT16.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT16.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT17:" + CardTypeDef.CARDTYPE_CUSTOM_FLT17.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT17.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT18:" + CardTypeDef.CARDTYPE_CUSTOM_FLT18.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT18.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT19:" + CardTypeDef.CARDTYPE_CUSTOM_FLT19.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT19.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT20:" + CardTypeDef.CARDTYPE_CUSTOM_FLT20.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT20.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT21:" + CardTypeDef.CARDTYPE_CUSTOM_FLT21.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT21.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT22:" + CardTypeDef.CARDTYPE_CUSTOM_FLT22.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT22.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT23:" + CardTypeDef.CARDTYPE_CUSTOM_FLT23.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT23.getValue());
        System.out.println("CardTypeDef.CARDTYPE_CUSTOM_FLT24:" + CardTypeDef.CARDTYPE_CUSTOM_FLT24.toString() + ", value:" + CardTypeDef.CARDTYPE_CUSTOM_FLT24.getValue());
    }
}
