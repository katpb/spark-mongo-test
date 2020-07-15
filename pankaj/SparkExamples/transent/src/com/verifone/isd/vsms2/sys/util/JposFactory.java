/*
 * JposFactory.java
 *
 * Created on December 11, 2002, 10:29 AM
 */

package com.verifone.isd.vsms2.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.lang.reflect.*;

import java.io.File;

import jpos.BaseControl;
import jpos.JposConst;
import jpos.JposException;
import jpos.config.JposEntry;
import jpos.config.JposEntryRegistry;
import jpos.config.simple.SimpleEntry;
import jpos.loader.JposServiceLoader;
import jpos.loader.JposServiceManager;

/**
 * Factory class to manage JavaPOS (JPos) controls.  The controls that have been
 * created are singleton instances. Every control created has been "opened".  This
 * means that they are connected to a JavaPOS service and that service is ready to
 * or already has communicated with the actual device. The controls are usually
 * "claimed". In JavaPOS terms, "claimed" means that no other controls can connect
 * to the service.  There have been problems with using multiple controls to a single
 * instance of a service because of third party implementations of those services.
 * It just doesn't work! Hence, this factory was created to provide the single
 * instance of a control that the application can use throughtout.<br/><br/>
 * 
 * JavaPOS is the Java implementation of UnifiedPOS (UPOS).<br/><br/>
 * 
 * To understand the general usage of a JavaPOS device and their specific behaviors,
 * the reader is encourage to reference
 * <a href="{@docRoot}/isdSys/mw/java/apis/ibm/jpos/jcl/notes/upos_spec1.10_02102006.pdf"  target="_blank">
 * UnifiedPOS Retail Peripheral Architecture
 * </a>.
 * 
 * Factory class to create instances as requested for Jpos controls. If an
 * instance already exists, then that instance is returned.
 */
public class JposFactory {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class);
    private Hashtable jposControls = null;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this calls class will Log
     * initialization messages.
     */
    public static final int DEBUG_FLAG_INITIALIZATION = 1;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this class will Log
     * Authorized Printer messages.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * The value found in the property is in decimal but the use in the class
     * variable <code>debugFlags</code> is bitwise.  You may need to use your
     * hexadecimal expertise (or a calculatior if you are hex challenged) to
     * come up with the correct string to set the jpos.xml property value.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_AUTHORIZED_PRINTER = 2;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this class will Log
     * Printer Type Detection messages.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * The value found in the property is in decimal but the use in the class
     * variable <code>debugFlags</code> is bitwise.  You may need to use your
     * hexadecimal expertise (or a calculatior if you are hex challenged) to
     * come up with the correct string to set the jpos.xml property value.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_PRINTER_DETECTION = 4;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this class will Log
     * Printer Error Event messages.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * The value found in the property is in decimal but the use in the class
     * variable <code>debugFlags</code> is bitwise.  You may need to use your
     * hexadecimal expertise (or a calculatior if you are hex challenged) to
     * come up with the correct string to set the jpos.xml property value.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_PRINTER_ERROR_EVENTS = 8;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this class will Log
     * Printer Error Event messages.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * The value found in the property is in decimal but the use in the class
     * variable <code>debugFlags</code> is bitwise.  You may need to use your
     * hexadecimal expertise (or a calculatior if you are hex challenged) to
     * come up with the correct string to set the jpos.xml property value.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_PRINTER_STATUS_EVENTS = 0x10;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If numerically OR'ed to value, then this class will enabled Log'ing
     * of PrinterMgr functions.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * The value found in the property is in decimal but the use in the class
     * variable <code>debugFlags</code> is bitwise.  You may need to use your
     * hexadecimal expertise (or a calculatior if you are hex challenged) to
     * come up with the correct string to set the jpos.xml property value.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_PRINT_MGR = 0x40000000;

    /**
     * VFIPrinter JposEntry debugFlags property value bitwise flag.
     * If VFIPrinter JposEntry debugFlags property is set to this value,
     * then all print functions and events are Log'd.
     * <p>
     * If the property element named &quot;debugFlags&quot; is found in the
     * JposEntry with logicalName=&quot;VFIPrinter&quot;, that property's
     * value is used for debug flags.
     * <p>
     * If that property element is not already in the jpos.xml file, you may edit
     * the file and add the following line to &quot;VFIPrinter&quot; JposEntry
     * element:
     * <code>
     * <pre>
     *     &lt;prop name=&quot;debugFlags&quot; type=&quot;String&quot; value=&quot;{@value}&quot;/&gt;
     * </pre>
     * </code>
     */
    public static final int DEBUG_FLAG_LOG_ALL = 0x7fffffff;

	/**
	 * System property name to get a list of classes used to detect which specific
	 * printer is connected to the system.  The classes specified in the comma
	 * separated property value implement {@link IJposPrinterVendor}.
     * 
	 * @see IJposPrinterVendor
	 */
    public static final String POSPRINTER_DETECTOR_CLASSES_KEY = "jpos.POSPrinter.Detectors";

    // Fiscal printer related constants
    public static final String FISCAL_PRINTER_ENABLED_PROPNAME = "fiscal.printer.enabled";
    public static final String FISCAL_PRINTER_TYPE_PROPNAME = "fiscal.printer.type";
    public static final String FISCAL_PRINTER_NONE = "none";
    public static final String FISCAL_PRINTER_BEMA = "bema";
    
    private static final String LOGICAL_PRINTER_PROPNAME = "logicalPrinter";
    private static final String VFIPRINTER_LOGICAL_NAME = "VFIPrinter";
    private static final String VFIPRINTER_DEVICE_TYPE = "DeviceType";
    private static final String VFIPRINTER_TYPE_FISCAL = "FiscalPrinter";
    private static final String VFIPRINTER_TYPE_TMU950 = "EpsonTMU950";
    
    private static final String MSR_LOGICAL_NAME = "MSR";
    private static final String REALMSR_LOGICAL_NAME = "RealMSR";
    private static final String NULLMSR_LOGICAL_NAME = "NullMSR";
    
    private ArrayList printerVendors;
    
    private static JposFactory myInstance = null;

    private static final String NULL_PRINTER_SVC_NAME = "NullPtrSvc";

    /**
     * Collection that contains the list of JposEntry.Prop property names
     * to be ignored when comparing two JposEntries for equivalency.
     *
     * @see #compareJposEntries(jpos.config.JposEntry, jpos.config.JposEntry)
     */
    private static final Collection ignorePropNames;

    /**
     * Collection that contains the list of JposEntry.Prop property names
     * to be ignored when comparing two JposEntries for equivalency.
     *
     * @see #getPortProprtyValue(jpos.config.JposEntry)
     */
    private static final Collection portPropertyNames;

    static
    {
        portPropertyNames = new HashSet();
        portPropertyNames.add("PortName");
        portPropertyNames.add("portName");

        ignorePropNames = new HashSet();
        ignorePropNames.add(JposEntry.LOGICAL_NAME_PROP_NAME);
        ignorePropNames.addAll(portPropertyNames);
    };

    private JposFactory() {
        jposControls = new Hashtable();
        printerVendors = new ArrayList();

        String printerDetectorClassNames = null;
        try {
            printerDetectorClassNames = SysPropertyFactory.getProperty( POSPRINTER_DETECTOR_CLASSES_KEY );
        } catch( Exception e) {
        }

        if (printerDetectorClassNames != null) {
            int idx = 0;

            StringTokenizer classTokenizer = new StringTokenizer(printerDetectorClassNames, ",");

            while(classTokenizer.hasMoreTokens()) {
                String vendorDetectorClassName = classTokenizer.nextToken();

                printerVendors.add( vendorDetectorClassName );
            }
        }

        boolean msrExists = false;

        JposServiceManager jsm = JposServiceLoader.getManager();
        JposEntryRegistry jer = jsm.getEntryRegistry();
        JposEntry msrEntry = jer.getJposEntry(REALMSR_LOGICAL_NAME);
        if (msrEntry != null)
        {
            File msrOutfile = null;
            File msrInfile = null;
            JposEntry.Prop aProp = msrEntry.getProp("OutputPortName");
            if (aProp != null)
            {
                msrOutfile = new File(aProp.getValueAsString());
            }
            aProp = msrEntry.getProp("InputPortName");
            if (aProp != null)
            {
                msrInfile = new File(aProp.getValueAsString());
            }
            
            msrExists = (msrOutfile != null) && (msrInfile != null) && (msrOutfile.exists()) && (msrInfile.exists());
        }
        
        if (!msrExists)
        {
            if (jer.hasJposEntry(NULLMSR_LOGICAL_NAME))
            {
                msrEntry = jer.getJposEntry(NULLMSR_LOGICAL_NAME);
                logger.info("Using NULL JPOS MSR Service.");
            } else
            {
                logger.info("Using DEFAULT JPOS MSR Service.");
            }
        } else
        {
            logger.info("Using REAL JPOS MSR Service.");
        }

        if ((msrEntry != null) && (msrEntry instanceof SimpleEntry))
        {
            if (jer.hasJposEntry(NULLMSR_LOGICAL_NAME))
            {
                jer.removeJposEntry(MSR_LOGICAL_NAME);
            }
            msrEntry = SimpleEntry.class.cast(msrEntry).copy();
            msrEntry.modifyPropertyValue(JposEntry.LOGICAL_NAME_PROP_NAME, MSR_LOGICAL_NAME);
            jer.addJposEntry(MSR_LOGICAL_NAME, msrEntry);
        }

    }

    /**
	 * Returns with the jpos.BaseControl instance associated with the 'logicalDaviceName'.
	 * Caller must cast the returned object to expected adapter type:
	 * jpos.CashDrawer, jpos.POSPrinter, e.g.
	 * 
	 * The control returned as been "opened" and "claimed" if it isn't already.
	 * 
	 * For developement, the specific adapter type that will be created can be
	 * found in the application's jpos.xml file.  The logicalDaviceName is used as
	 * the name of the JposEntry XML element to be used.  All JposEntry elements contain
	 * an element "jpos" with attribute "category" that specifies the corresponding
	 * jpos control.
	 * i.e.
	 *    jpos category="POSPrinter" version="1.51"
	 * @param logicalDeviceName Name to use in creating the BaseControl derivative
	 * @return A jpos.BaseControl derivative instance.
	 * @throws jpos.JposException Thrown if control cannot be instantiated or service creation fails
	 */
    public static synchronized jpos.BaseControl getInstance(String logicalDeviceName) throws jpos.JposException {

        if (myInstance == null) {
            myInstance = new JposFactory();
        }

//        myInstance.showCurrentControls();
        jpos.BaseControl theControl = null;
        ControlInfo controlInfo = getUnclaimedControlInfo(logicalDeviceName);
        if (controlInfo != null) {
            if ( claimJposControl(controlInfo) == false ) {
                closeJposControl(controlInfo);
                theControl = null;
            } else {
                theControl = controlInfo.theControl;
            }
        }

        return theControl;

    }

    /**
	 * Returns with the jpos.BaseControl instance associated with the 'logicalDaviceName'. The
	 * control/service is not claimed. Application must claim , enable, disable, and release the
	 * JPOS device.
	 * 
	 * The control returned as been "opened" if it isn't already.
	 * 
	 * aller must cast the returned object to expected adapter type:
	 *                                 CashDrawer, POSPrinter, e.g.
	 * @param logicalDeviceName Name to use in creating the BaseControl derivative
	 * @return The unclaimed jpos.BaseControl instance
	 * @throws jpos.JposException Thrown if control cannot be instantiated or service creation fails
	 */
    public static synchronized jpos.BaseControl getUnclaimedInstance( String logicalDeviceName )  throws jpos.JposException {
        
        if (myInstance == null)
            myInstance = new JposFactory();

        ControlInfo controlInfo = getUnclaimedControlInfo(logicalDeviceName);
        jpos.BaseControl theControl = null;
        if (controlInfo != null) {
            theControl = controlInfo.theControl;
        }
        
        return controlInfo.theControl;

    }
    
	/**
	 * Creates a control that has not been opened nor claimed.
	 * @param jposEntry Dom object from jpos.xml for this control.
	 * @return The closed and unclaimed JavaPOS control
	 */
    private static synchronized jpos.BaseControl createJposControl( jpos.config.JposEntry jposEntry ) {

        jpos.BaseControl aControl = null;
        String controlClassName;

        /* Get device catagory and create control instance */
        String devCat = (String) jposEntry.getPropertyValue( jpos.config.JposEntry.DEVICE_CATEGORY_PROP_NAME );
        
        if ( devCat.equals( "POSKeyboard" ) ) {
            controlClassName = new String( "com.verifone.isd.topaz.jpos.extensions.POSKeyboardExtension" );
        } else if ( devCat.equals( "POSPrinter" ) ) {
            controlClassName = new String( "com.verifone.isd.vsms2.sys.util.POSPrinterExt");
        } else {
            controlClassName = new String( "jpos." + devCat );
        }

//        LoggerFactory.getLogger(com.verifone.isd.topaz.sys.util.JposFactory.class).debug( "JposFactory: Creating JPOS Control for " +
//                            jposEntry.getLogicalName() + " of class type " +
//                            controlClassName );
        try {
            Class instanceClass = Class.forName( controlClassName );
            Constructor defaultCtor = instanceClass.getConstructor( new Class[ 0 ] );
            aControl = (jpos.BaseControl) defaultCtor.newInstance( new Object[ 0 ] );
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).debug( "JposFactory: Created JPOS Control for " +
                            jposEntry.getLogicalName() );
        } catch (Exception e) {
            /* Catch all exceptions. set aControl equal to null to signal bad
               instance creation */
            aControl = null;
        }
        
        return( aControl );
    }

	/**
	 * Close the control associated with this logical device. This method will disable
	 * and release the control if need be.
	 * 
	 * The only thread that can close the control is the same one that opened it.  This
	 * is also true for the "release" of the control.
	 * @param logicalName The name of the instance of the control to close.
	 */
    public static synchronized void closeInstance( String logicalName ) {
        
        if (myInstance == null) {
            myInstance = new JposFactory();
            return;
        }
        
        ControlInfo theControl = (ControlInfo) myInstance.jposControls.get(logicalName);

        if (theControl != null ) {
            closeJposControl(theControl);
        } else {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Unable to find control Info for '" +
                               logicalName + "' to close" );
        }
    }

	/**
	 * Returns with the jpos.BaseControl instance associated with the 'logicalDaviceName'.
	 * Caller must cast the returned object to expected adapter type:
	 * jpos.CashDrawer, jpos.POSPrinter, e.g.
	 * 
	 * This method does not change the state of the control; opened, closed, claimed
	 * or enabled.
	 * @param logicalDeviceName Name to use in creating the BaseControl derivative
	 * @return A jpos.BaseControl derivative instance.
	 * @throws jpos.JposException Thrown if control cannot be instantiated or service creation fails
	 */
    public static synchronized jpos.BaseControl getControlFor( String logicalDeviceName ) throws jpos.JposException {
        jpos.BaseControl theControl = null;
        ControlInfo controlInfo = null;

        /* Create the container for instances if not already */
        if (myInstance == null) {
            myInstance = new JposFactory();
        }

        /* Find the instance of the requested control */
        controlInfo = (ControlInfo) myInstance.jposControls.get(logicalDeviceName);
        if (controlInfo == null ) {
            controlInfo =  getUnclaimedControlInfo( logicalDeviceName );
            theControl = controlInfo.theControl;
        }
        
        return theControl;
    }
    
    public static synchronized BaseControl getControlInstance(String logicalDeviceName) throws JposException
    {
        jpos.BaseControl retVal = null;
        ControlInfo controlInfo = null;

        /* Create the container for instances if not already */
        if (myInstance == null) {
            myInstance = new JposFactory();
        }
        controlInfo = (ControlInfo) myInstance.jposControls.get(logicalDeviceName);
        if (controlInfo == null ) {
            /* Through Jpos manager, find JposEntry for logical name */
            jpos.loader.JposServiceManager jposManager = jpos.loader.JposServiceLoader.getManager();
            Enumeration jposEntries = jposManager.getEntryRegistry().getEntries();

            while (jposEntries.hasMoreElements()) {
                jpos.config.JposEntry jposEntry = (jpos.config.JposEntry) jposEntries.nextElement();

                if (jposEntry.getLogicalName().equals(logicalDeviceName ) ) {
                    /* Found JposEntry, Create control */
                    // Is this for the "VFIPrinter"?

                    if (logicalDeviceName.equals( VFIPRINTER_LOGICAL_NAME )) {

                        jpos.config.JposEntry aVendor = myInstance.fixUpJposEntries(jposEntry);
                        if (aVendor == null) {
                            throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE, "No service to connect with!" );
                        }

                        jposEntry = aVendor;
                    }

                    jpos.BaseControl aControl = createJposControl( jposEntry );
                    if ( aControl == null )
                        throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE,
                                 "Unable to create control for '" + logicalDeviceName + "'" );

                    /* Save the control info for future instance requests */
                    controlInfo = new ControlInfo();
                    controlInfo.theControl = aControl;
                    controlInfo.logicalDeviceName = jposEntry.getLogicalName();
                    myInstance.jposControls.put(logicalDeviceName, controlInfo );
                }
            }
        }
        
        if (controlInfo != null)
        {
            retVal = controlInfo.theControl;
        }
        
        return retVal;
    }

    private static ControlInfo getUnclaimedControlInfo( String logicalDeviceName ) throws jpos.JposException {
        jpos.BaseControl theControl;
        ControlInfo controlInfo = null;

        synchronized(JposFactory.class)
        {
            /* Create the container for instances if not already */
            if (myInstance == null) {
                myInstance = new JposFactory();
            }
            /* Find the instance of the requested control */
            controlInfo = (ControlInfo) myInstance.jposControls.get(logicalDeviceName);
         }

        if (controlInfo != null ) {
            if ( openJposControl( controlInfo ) == false ) {
                throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE,
                         "Unable to open existing control for '" + logicalDeviceName + "'" );
            }
            return( controlInfo );
        }

        /* No instance found. Create it, save it, and return it */

        /* Through Jpos manager, find JposEntry for logical name */
        jpos.loader.JposServiceManager jposManager = jpos.loader.JposServiceLoader.getManager();
        Enumeration jposEntries = jposManager.getEntryRegistry().getEntries();

        while (jposEntries.hasMoreElements()) {
            jpos.config.JposEntry jposEntry = (jpos.config.JposEntry) jposEntries.nextElement();

            if (jposEntry.getLogicalName().equals(logicalDeviceName ) ) {
                /* Found JposEntry, Create control */
                // Is this for the "VFIPrinter"?

                if (logicalDeviceName.equals( VFIPRINTER_LOGICAL_NAME )) {

                    jpos.config.JposEntry aVendor = myInstance.fixUpJposEntries(jposEntry);
                    if (aVendor == null) {
                        throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE, "No service to connect with!" );
                    }

                    jposEntry = aVendor;
                }
                
                jpos.BaseControl aControl = createJposControl( jposEntry );
                if ( aControl == null )
                    throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE,
                             "Unable to create control for '" + logicalDeviceName + "'" );

                /* Save the control info for future instance requests */
                controlInfo = new ControlInfo();
                controlInfo.theControl = aControl;
                controlInfo.logicalDeviceName = jposEntry.getLogicalName();
                synchronized(JposFactory.class)
                {
                    myInstance.jposControls.put(logicalDeviceName, controlInfo );
                }

                if ( openJposControl( controlInfo ) == false ) {
                    throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE,
                             "Unable to open control for '" + logicalDeviceName + "'" );
                }
                /* Return the control instance to caller */
                return( controlInfo );
            }
        }
        throw new jpos.JposException(jpos.JposConst.JPOS_E_NOSERVICE,
               "Service for '" + logicalDeviceName + "' does not exist!" );
    }

    /**
     * Used for unit testing - removes a Control from the collection of
     * JPOS BaseControl derivatives.
     * @param logicalName
     * @return The BaseControl derivative that was removed. <code></code> if
     *         the control did not previously exist.
     * @throws JposException Thrown on errors trying to close the BaseControl.
     */
    static synchronized BaseControl removeControl(String logicalName) throws JposException
    {
        BaseControl aControl = null;

        if (myInstance == null) {
            myInstance = new JposFactory();
        }

        if (myInstance.jposControls.containsKey(logicalName))
        {
            ControlInfo controlInfo =
                    (ControlInfo) myInstance.jposControls.get(logicalName);

            aControl = controlInfo.theControl;
            if (aControl.getState() != JposConst.JPOS_S_CLOSED)
            {
                aControl.close();
            }

            myInstance.jposControls.remove(logicalName);

        }

        return aControl;
    }

    private static boolean openClaimControl( ControlInfo theControl ) {
        if ( openJposControl( theControl ) == true ) {
            if ( claimJposControl(theControl) == true ) {
                return true;
            }
            
            closeJposControl(theControl);
        }
        
        return false;
    }

    private static boolean openJposControl( ControlInfo theControl ) {
        if (theControl.theControl.getState() == jpos.JposConst.JPOS_S_CLOSED ) {
            try {
                theControl.theControl.open(theControl.logicalDeviceName);
            } catch (jpos.JposException je ) {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Errors opening control for '" +
                                   theControl.logicalDeviceName +"': " + je.getMessage());
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).debug( "JposFactory: Jpos error: ", je);
                return false;
            }
        }
        return true;
    }
    
    private static boolean claimJposControl( ControlInfo theControl ) {
        try {
            if (theControl.theControl.getClaimed() == false ) {
                theControl.theControl.claim(1);
            }
        } catch (jpos.JposException je ) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Errors claiming control for '" +
                               theControl.logicalDeviceName +"'");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Jpos error: " + je.getMessage());
            return false;
        }
        return true;
    }

    private static void closeJposControl( ControlInfo theControl ) {
        if (theControl.theControl.getState() != jpos.JposConst.JPOS_S_CLOSED ) {
            try {
                theControl.theControl.close();
            } catch (jpos.JposException je ) {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Errors closing control for '" +
                                   theControl.logicalDeviceName +"'");
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory: Jpos error: " + je.getMessage());
            }
        }
    }
    
    private void showCurrentControls() {
        
        java.util.Enumeration iter = jposControls.elements();
        
        while( iter.hasMoreElements() ) {
            ControlInfo theInfo = (ControlInfo) iter.nextElement();
            
            StringBuffer strBuf = new StringBuffer();

            strBuf.append( "    " + theInfo.logicalDeviceName + " - open:" );
            int theState = theInfo.theControl.getState();
            switch( theState ) {
                case jpos.JposConst.JPOS_S_BUSY:
                    strBuf.append("BUSY" );
                    break;
                case jpos.JposConst.JPOS_S_CLOSED:
                    strBuf.append("CLOSED" );
                    break;
                case jpos.JposConst.JPOS_S_ERROR:
                    strBuf.append("ERROR" );
                    break;
                case jpos.JposConst.JPOS_S_IDLE:
                    strBuf.append("IDLE" );
                    break;
                default:
                    strBuf.append( theState );
                    break;
            }

            strBuf.append("  claimed:" );
            try {
                strBuf.append( theInfo.theControl.getClaimed() );
            } catch( jpos.JposException je) {
                strBuf.append( "fault" );
            }

            strBuf.append("  enabled:" );
            try {
                strBuf.append( theInfo.theControl.getDeviceEnabled() );
            } catch( jpos.JposException je) {
                strBuf.append( "fault" );
            }

            logger.debug( "JposFactory:" + strBuf.toString() );
        }
    }

    private IJposPrinterVendor findPrinter(jpos.config.JposEntry vfiPtrEntry) {

        String commPortName = null;
        if (vfiPtrEntry != null)
        {
            commPortName = getPropertyValue(vfiPtrEntry, JposFactory.portPropertyNames);
        }


        if ((commPortName == null) || commPortName.isEmpty())
        {
            return new NullPrinterVendor();
        }

        java.util.Iterator iter = printerVendors.iterator();
        
        while( iter.hasNext() ) {
            try {
                String vendorClassName = (String) iter.next();
                Class[] argsClasses = new Class[1];
                argsClasses[0] = String.class;
                Class vendorClass = Class.forName( vendorClassName );
                java.lang.reflect.Constructor constructor  = vendorClass.getConstructor( argsClasses );
                Object[] argsObjects = new Object[] { commPortName };
                IJposPrinterVendor aVendor = (IJposPrinterVendor) constructor.newInstance( argsObjects );

                if (aVendor.isPrinter()) {
                    return aVendor;
                }
            } catch(Exception e) {
                logger.error( "JposFactor.findPrinter(): " + e);
            }
        }
        
        return null;
    }

    private jpos.config.JposEntry fixUpJposEntries ( jpos.config.JposEntry vfiPrinterEntry ) throws jpos.JposException 
    {
    	String devType = null;
    	
    	if (vfiPrinterEntry != null) {
    		devType = (String) vfiPrinterEntry.getPropertyValue(VFIPRINTER_DEVICE_TYPE);
    	}

    	if (devType != null && devType.equals(VFIPRINTER_TYPE_FISCAL)) {
    		return vfiPrinterEntry;
    	}

    	boolean saveRequired = false;
    	
        jpos.config.JposEntryRegistry theRegistry = jpos.loader.JposServiceLoader.getManager().getEntryRegistry();
        
        IJposPrinterVendor printerVendor;
        String mappedPrinterString;

    	if (vfiPrinterEntry != null) {
    		devType = (String) vfiPrinterEntry.getPropertyValue(VFIPRINTER_DEVICE_TYPE);
    	}
		if (devType != null && devType.equals(VFIPRINTER_TYPE_TMU950)) {
			String port = getPropertyValue(vfiPrinterEntry, JposFactory.portPropertyNames);
			printerVendor = new TMU950PrinterVendor(port);
		} else {
			printerVendor= findPrinter(vfiPrinterEntry);
		}

		// No "mapped" printer vendor
		if (printerVendor == null) {
			// not able to find correct jpos entry, return null
			return null;
		}
		mappedPrinterString = printerVendor.getLogicalName();
        // Now check to see if there is a vendor's logical name jpos entry
        jpos.config.JposEntry vendorEntry = theRegistry.getJposEntry( mappedPrinterString );
        
        if ( vendorEntry == null ) {
        // If there is no entry, throw service does not exist exception
            throw new jpos.JposException( jpos.JposConst.JPOS_E_NOSERVICE, "No JposEntry for logical name '" + mappedPrinterString + "'" );
        }

        // Now check to see if the "VFIPrinter" and detected vendor are NOT equivalant JposEntries...
        boolean jposEntriesAreEquivalent = false;

        String vfiPrinterPort = null, deviceType = null;
        if (vfiPrinterEntry != null)
        {
            vfiPrinterPort = getPropertyValue(vfiPrinterEntry, JposFactory.portPropertyNames);
            Collection propDevType = new HashSet();
            propDevType.add("DeviceType");
            deviceType = getPropertyValue(vfiPrinterEntry, propDevType);

            jposEntriesAreEquivalent = compareJposEntries(vfiPrinterEntry, vendorEntry);

        }

        if (!jposEntriesAreEquivalent)
        {
            // Copy vendor's entry to VFIPrinter entry.
            vfiPrinterEntry = ((SimpleEntry) vendorEntry).copy();
            // and change copied entry's logicalName to "VFIPrinter"
            vfiPrinterEntry.modifyPropertyValue(JposEntry.LOGICAL_NAME_PROP_NAME, VFIPRINTER_LOGICAL_NAME);
            saveRequired = true;
        }

		vfiPrinterEntry.addProperty("DeviceType", deviceType);
        // If it was not the Null service detected, see if commport and baudrate need to be propagated.
        if (!mappedPrinterString.equals(JposFactory.NULL_PRINTER_SVC_NAME))
        {
            // port property was not found in original VFIPrinter entry, use the detected device's port.
            if (vfiPrinterPort == null)
            {
                vfiPrinterPort = printerVendor.getPortName();
            }

            JposEntry.Prop portProp = vfiPrinterEntry.getProp(printerVendor.getPortPropertyName());
            if (portProp != null)
            {
                // Now, has port been changed?
                if (!portProp.getValueAsString().equals(vfiPrinterPort))
                {
                    // Ports have been changed, update entry
                    vfiPrinterEntry.modifyPropertyValue(portProp.getName(), vfiPrinterPort);
                    saveRequired = true;
                }
            }
        }

        /* Now we got the following:
         *   vfiPrinterEntry - The jpos entry of the detected device.
         *            This entry might have been updated with the port name and baud rate the printer is
         *            supposed to be attached to
         */
        // So, now, do we need to update the jpos.xml file?
        if ( saveRequired ) {
            
            theRegistry.modifyJposEntry(vfiPrinterEntry.getLogicalName(), vfiPrinterEntry);
            try {
                theRegistry.save();
            } catch( Exception e ) {
                throw new jpos.JposException( jpos.JposConst.JPOS_E_FAILURE, "Error trying to save the jpos.xml!", e);
            }
        }

        // return the actual, vendor supplied JposEntry
        return vfiPrinterEntry;
    }

    private boolean compareJposEntries(JposEntry vfiEntry, JposEntry vendorEntry)
    {
        if ((vfiEntry == null) || (vendorEntry == null))
        {
            return false;
        }

        boolean retVal = true;
        Iterator propIter = vfiEntry.getProps();
        while(propIter.hasNext())
        {
            JposEntry.Prop aProp = (JposEntry.Prop) propIter.next();
            String propName = aProp.getName();
            if (ignorePropNames.contains(propName))
            {
                continue;
            }
            JposEntry.Prop secondProp = vendorEntry.getProp(aProp.getName());
            if ((secondProp == null) || !aProp.equals(secondProp))
            {
                retVal = false;
                break;
            }
        }

        return retVal;
    }

    private String getPropertyValue(JposEntry jposEntry, Collection properties)
    {
        String retVal = null;

        Iterator portIter = properties.iterator();
        while(portIter.hasNext())
        {
            String propName = (String) portIter.next();
            String value = (String) jposEntry.getPropertyValue(propName);
            if (value != null)
            {
                retVal = value;
                break;
            }
        }

        return retVal;
    }
    private class NullPrinterVendor implements IJposPrinterVendor
    {

        public String getLogicalName()
        {
            return JposFactory.NULL_PRINTER_SVC_NAME;
        }

        public boolean isPrinter()
        {
            return true;
        }

        public String getPortName()
        {
            return "/dev/null/";
        }

        public String getPortPropertyName()
        {
            return "portName";
        }

        public String getVendorBaudPropValue(String baudRate)
        {
            return baudRate;
        }

        public String getVendorBaudPropName()
        {
            return "baudRate";
        }

        public String getActualBaudRate()
        {
            return "";
        }

    }

	private class TMU950PrinterVendor implements IJposPrinterVendor {
		String port;
		public TMU950PrinterVendor(String port){
			this.port = port;
		}

		@Override
		public String getLogicalName() {
			return VFIPRINTER_TYPE_TMU950;
		}

		@Override
		public boolean isPrinter() {
			return true;
		}

		@Override
		public String getPortName() {
			return port;
		}

		@Override
		public String getPortPropertyName() {
			return "PortName";
		}
	}

	/**
	 * For testing purposes only.
	 * @param Args Not used
	 */
    public static void main(String[] Args) {
        
        try {
            jpos.POSPrinter thePrinter = (jpos.POSPrinter) JposFactory.getInstance( VFIPRINTER_LOGICAL_NAME );
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).debug( "JposFactory.main: " + thePrinter.getDeviceServiceDescription() );
        } catch( Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.JposFactory.class).error( "JposFactory.main: " + e);
            e.printStackTrace();
        }
        
        try {
            Thread.sleep(5000);
        } catch( Exception e ) {
        }

        JposFactory.closeInstance( VFIPRINTER_LOGICAL_NAME );
    }
}

class ControlInfo {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.ControlInfo.class);
    public String logicalDeviceName;
    public jpos.BaseControl theControl;

    public ControlInfo() {
    }
}


