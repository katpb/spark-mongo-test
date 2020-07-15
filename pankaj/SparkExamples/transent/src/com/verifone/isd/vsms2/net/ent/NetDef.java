/*
 * NetDef.java
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
public class NetDef implements java.io.Serializable
{
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDef.class);
	private static final long serialVersionUID = 676486245636207100L;

    private transient int value;
    private transient String name;
    private static int UNDEFINED = -1;
    private static Properties prop = null;

    static {
        String propFile = "NetDef.prop";
        prop = new Properties();
        
        InputStream inStream = null;
        // Read properties file.
        try {
            inStream = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
            prop.load(inStream);
        } catch (IOException e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDef.class)
			             .error( "Error loading NetDef.prop file:" + propFile + " " + e.getMessage());
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
    protected NetDef(String name) {
        String value = prop.getProperty(name);

        if (value != null && value.length() > 0){
            this.value = Integer.parseInt(value, 10);      // From properties file.
        }else {
            this.value = UNDEFINED;
            logger.error( "NetDef property:" + name + " Defaulting to Undefined (-1)");
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

    /**
     * This method returns a NetDef object with a value matching
     * the value parameter.  Note: this is not the object at the ordinal
     * position but the object containing a matching value.
     * @param value - The value to match to the objects value property.
     * @throws Exception if a value match is not found.
     * @return A NetDef object.
     */    
     public static NetDef getFromValue(int value) throws Exception
     {
        NetDef[] defs = NetDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            if (defs[i].value == value) {
                return (defs[i]);
            }
        }                 
        
        String msg = "Acct Validation Index:" + value + " not found in NetDef data.";
        LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDef.class).error( msg);
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
    //  from a NetDef.prop file unique to each application.
    public static NetDef NONET       = new NetDef("NONET");
    public static NetDef LOCALNET       = new NetDef("LOCALNET");
    public static NetDef NET_ONE = new NetDef("NET_ONE");
    public static NetDef NET_TWO    = new NetDef("NET_TWO");
    public static NetDef NET_THREE       = new NetDef("NET_THREE");
    public static NetDef MAXNET     = new NetDef("MAXNET");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //card Def's ; auto-incremented

    //  As of 1/19/2005 these are the cards defined for ADS and Buypass.  As more apps
    //  are developed this list could grow.
    private static final NetDef[] VALUES = {
        NONET, LOCALNET, NET_ONE, NET_TWO , NET_THREE , MAXNET
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

    /** Method to get the NetDef.object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return NetDef.object representing the ordinal
     */
    protected static NetDef getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /** Getter for all the NetDef.objects
     * @return array of Card Definitions
     */
    protected static NetDef[] getObjects() {
        NetDef[] defs = new NetDef[VALUES.length];
        System.arraycopy(VALUES, 0, defs, 0, VALUES.length);
        return defs;
    }

    /** Test method
     * @param args params to the test
     */

    public static void main(String[] args) {
        NetDef[] defs = NetDef.getObjects();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("Code: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }

        System.out.println("NetDef.NONET:" + NetDef.NONET.toString() + ", value:" + NetDef.NONET.getValue());
        System.out.println("NetDef.LOCALNET:" + NetDef.LOCALNET.toString() + ", value:" + NetDef.LOCALNET.getValue());
        System.out.println("NetDef.NET_ONE:" + NetDef.NET_ONE.toString() + ", value:" + NetDef.NET_ONE.getValue());
        System.out.println("NetDef.NET_TWO :" + NetDef.NET_TWO .toString() + ", value:" + NetDef.NET_TWO .getValue());
        System.out.println("NetDef.NET_THREE :" + NetDef.NET_THREE .toString() + ", value:" + NetDef.NET_THREE .getValue());
        System.out.println("NetDef.MAXNET:" + NetDef.MAXNET.toString() + ", value:" + NetDef.MAXNET.getValue());
    }
}
