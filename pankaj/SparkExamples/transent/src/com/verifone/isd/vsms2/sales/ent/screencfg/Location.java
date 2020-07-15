/*
 * Location.java
 *
 * Created on July 29, 2010, 10:29 AM
 */

package com.verifone.isd.vsms2.sales.ent.screencfg;


/** Type-safe enumeration of Zone Locations
 * 
 * @author Ganesh_k1
 */
public class Location implements java.io.Serializable {
    
    private static final long serialVersionUID = 6504120738972655710L;
    private transient String name;
    private transient boolean receiptLocation = false;
    private transient boolean panelLocation = false;
    
    /** Constructor 
     * @param name Zone Location name
     */
    private Location(String name, boolean receiptLocation, boolean panelLocation) {	
        this.name = name;
        this.receiptLocation = receiptLocation;
        this.panelLocation = panelLocation;
    }
        
    /** Override toString() method to provide the Zone Location name
     * @return Zone Location
     */    
    public String toString() {
        return "Location - " + this.name + "isReceiptLocation - " + this.receiptLocation;
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
    
    public static Location TOP             = new Location("TOP", false, true);
    public static Location BOTTOM           = new Location("BOTTOM", false, true);
    public static Location LEFT            = new Location("LEFT", true, false);
    public static Location RIGHT            = new Location("RIGHT", true, false);
    public static Location CENTER            = new Location("CENTER", false, false);
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; 
    
    private static final Location[] VALUES = { TOP,
	    BOTTOM, LEFT, RIGHT,CENTER };
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
        
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }       
    
    /** Getter for all the Location objects
     * @return array of Location
     */    
    public static Location[] getObjects() {                
        return VALUES;
    }
    
    /**
     * This method will retun a Location based on the location
     * @param location
     * @return
     */
    public static Location getObjectByLocationName(String location) {
	Location[] Locations = Location.getObjects();
	Location reqdLocation = null;
        for (int i = 0; i < Locations.length; i++) {
            if (Locations[i].name.equals(location)) {
        	reqdLocation = Locations[i];
                break;
            }
        }
        return reqdLocation;
    }
    
    /**
     * @return the Zone Location name
     */
    public String getLocationName() {
        return name;
    }
    
    /**
     * @return the receiptLocation
     */
    public boolean isReceiptLocation() {
        return receiptLocation;
    } 
    
    /**
     * @return the panelLocation
     */
    public boolean isPanelLocation() {
        return panelLocation;
    }
    
    /** Test method
     * @param args params to the test
     */    
    public static void main(String[] args) {
        Location[] locations = Location.getObjects();
        for (int i = 0; i < locations.length; i++) {
            System.out.println(locations[i].toString());
        }
    }       
}
