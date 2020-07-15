/*
 * IJposPrinterVendor.java
 *
 * Created on December 6, 2004, 5:03 PM
 */

package com.verifone.isd.vsms2.sys.util;

/** When dealing with more than JPos POSPrinter vendor, we need to know what vendor printer is
 * connected to the Topaz.  This interface is implemented by classes that can directly 'talk'
 * to the printer device and determine if it is the printer from their
 * respective vendor.  The logical name returned from getLogicalName() is
 * associated with the JposEntry found in jpos.xml. If the method isPrinter()
 * returns true, then the associated JposEntry is the one that specifies the
 * jpos.service to communicate with the printer.
 * @author Joe_H5
 */
public interface IJposPrinterVendor {

    /** The logical/JposEntry name implementing class is associated with
     * @return The JposEntry logical name */    
    public String getLogicalName();
    
    /** The implementing class is to test whether the printer is attached is of
     * the expected vendor type associated with the logical name/entry
     * @return True if printer is connected and of expected vendor type
     */    
    public boolean isPrinter();

    /** Return the port name property that printer is connected to
     * @return port name
     */
    public String getPortName();
    
    /** Return the vendor's JposEntry property name that specifies the port
     * @return JposEntry.Prop name
     */
    public String getPortPropertyName();
}
