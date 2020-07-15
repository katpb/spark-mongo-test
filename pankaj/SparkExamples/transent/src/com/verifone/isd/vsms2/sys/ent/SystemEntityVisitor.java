package com.verifone.isd.vsms2.sys.ent;

import com.verifone.isd.vsms2.sys.ent.deviceversion.DeviceVersionInfo;
import com.verifone.isd.vsms2.sys.ent.dispenser.Dispenser;
import com.verifone.isd.vsms2.sys.ent.dispenserinterface.DispenserInterface;
import com.verifone.isd.vsms2.sys.ent.employee.Employee;
import com.verifone.isd.vsms2.sys.ent.keybd.Key;
import com.verifone.isd.vsms2.sys.ent.managedevices.ManageDeviceConfig;
import com.verifone.isd.vsms2.sys.ent.middlewareversion.MiddlewareVersionInfo;
import com.verifone.isd.vsms2.sys.ent.peripheral.Peripheral;
import com.verifone.isd.vsms2.sys.ent.pinentrydevice.PinEntryDevice;
import com.verifone.isd.vsms2.sys.ent.posterminalcfg.POSTerminal;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityCtrl;
/**
 * Base visitor class for XML serialization of dataset domain
 * objects. This class provides stub functions for the visit()
 * method of all the visited objects. Inheriting visitor classes
 * should implement the visit() methods for the visited objects
 * of interest.
 *
 * Method visit() is the implementation of Visitor pattern.
 * A new visit() method for the appropriate dataset domain object has
 * to be registered with this base class if a new domain object is
 * added and it has to be XML serialized/ parsed.
 *
 * Clients interested in obtaining XML serialized data should
 * instantiate the appropriate visitor subclass and call
 * SAXWriter#writeSAX() passing the visitor as a parameter.
 *
 *  e.g.,
 *	<pre>
 *      XMLViewMgr viewMgr = new XMLViewMgr();
 *      ISAXSerializable v = new RegisterConfigXMLVisitor();
 *      SAXWriter sw = new SAXWriter(sm.getOutputStream());
 *      viewMgr.setSAXWriter(sw);
 *      viewMgr.setISAXSerializable(v);
 *      viewMgr.perform();
 *	</pre>
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
  */

public abstract class SystemEntityVisitor implements ISystemEntityVisitor{
   
    
    /**
     * Visitor method for object of type SecurityCtrl.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param sctrl the SecurityCtrl object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any error is
     * encountered
     */
    public void visit(SecurityCtrl sctrl) throws Exception {
    }
    
    /**
     * Visitor method for object of type Employee.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param emp the Employee object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Employee emp) throws Exception {
    }
    
    /**
     * Visitor method for object of type Key.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param key the Key object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Key key) throws Exception {
    }  
      
    /**
     * Visitor method for DeviceVersionInfo
     * @param deviceVersionInfo
     * @throws Exception
     */
    public void visit(DeviceVersionInfo deviceVersionInfo) throws Exception {
    }
    
    /**
     * Visitor method for Dispenser
     * @param dispenser
     * @throws Exception
     */
    public void visit(Dispenser dispenser) throws Exception {
    }
    
    /**
     * Visitor method for DispenserInterface
     * @param dispenserInterface
     * @throws Exception
     */
    public void visit(DispenserInterface dispenserInterface) throws Exception {
    }
    
    /**
     * Visitor method for MiddlewareVersionInfo
     * @param middlewareVersionInfo
     * @throws Exception
     */
    public void visit(MiddlewareVersionInfo middlewareVersionInfo) throws Exception {
    }
    
    /**
     * Visitor method for Device
     * @param dispenser
     * @throws Exception
     */
    public void visit(Peripheral device) throws Exception {
    }
    
    /**
     * Visitor method for PinEntryDevice
     * @param pinEntryDevice
     * @throws Exception
     */
    public void visit(PinEntryDevice pinEntryDevice) throws Exception {
    }
    
    /**
     * Visitor method for posTerminal configuration
     * @param posTerminal
     * @throws Exception
     */
    public void visit(POSTerminal posTerminal) throws Exception {
    }
 
    /**
     * Visitor method for Manage Devices
     * @param device
     * @throws Exception
     */
    public void visit(ManageDeviceConfig device) throws Exception {
    }

}