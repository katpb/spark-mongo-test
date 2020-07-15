/*
 * PartnerRP300PrinterVendorImpl.java
 *
 * Created on December 6, 2004, 5:15 PM
 */

package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.vsms2.sys.util.IJposPrinterVendor;

/**
 *	Implements the IJposPrinterVendor for the Partner RP 300 printer
 *
 * @author  Raghavendra_R1
 */
public class PartnerRP300PrinterVendorImpl implements IJposPrinterVendor {
    
    public static final String LOGICAL_NAME = "PartnerRP300";
    private static final String PORT_PROPERTY_NAME = "portName";
    
    protected String logicalName;
    
    protected String portName;


    /** Creates a new instance of PartnerRP300PrinterVendor.
     * {@link #portName} will be determined by the property set in the
     * JposEntry with logical name {@value #LOGICAL_NAME}.
     */
    public PartnerRP300PrinterVendorImpl() {
        logicalName = LOGICAL_NAME;
    }
    
    /** Creates a new instance of PartnerRP300PrinterVendor.
     * @param portName The port name the device is expected to be connect to.
     */
    public PartnerRP300PrinterVendorImpl(String portName) {
        logicalName = LOGICAL_NAME;
        this.portName = portName;
    }

    /** The logical/JposEntry name implementing class is associated with
     * @return The JposEntry logical name  */
    public String getLogicalName() {
        return logicalName;
    }
    
    /** The implementing class is to test whether the printer is attached is of
     * the expected vendor type associated with the logical name/entry
     * @return True if printer is connected and of expected vendor type
     */
    public boolean isPrinter() {
        return true;
    }
    
    /** Return the port name property that printer is connected to
     * @return port name
     */
    public String getPortName() {
        return portName;
    }
    
    /** Return the vendor's JposEntry property name that specifies the port
     * @return JposEntry.Prop name
     */
    public String getPortPropertyName() {
        return PORT_PROPERTY_NAME;
    }

}
