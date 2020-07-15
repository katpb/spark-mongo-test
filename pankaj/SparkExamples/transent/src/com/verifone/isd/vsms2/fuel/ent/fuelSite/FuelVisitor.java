package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

import java.io.Serializable;

/**
 *  Base visitor class for XML serialization. This class provides stub
 *  functions for the visit() method of all the visited objects
 *	except the root object (i.e., the fuelSite domain object). XML processing
 *  starts at the root object.
 *  Inheriting visitor classes should implement the visit() methods for
 *  the visited objects of interest.
 *
 *  The method visit() is the implementation of the Visitor pattern.
 *  A new visit() method for the appropriate domain object has to be registered with
 *  this base class if a new domain object is added and it has to be XML serialized.
 *
 *  Clients interested in obtaining XML serialized data should instantiate the appropriate
 *  visitor subclass and call SAXWriter#writeSAX() passing the visitor as a parameter.
 *
 *  e.g.
 *	<pre>
 *  	SAXWriter sw = new SAXWriter(sm.getOutputStream());
 *		FuelSiteInfoXMLVisitor v = new FuelSiteInfoXMLVisitor();
 *      sw.writeSAX(v);
 *	</pre>
 *
 *  It is the responsibility of the ISAXSerializable object and/or the
 *  appropriate visit() methods to traverse thro' the object tree.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */

public abstract class FuelVisitor {
    private Logger logger
            = LoggerFactory.getLogger(FuelVisitor.class);
    
    /**
     * Visitor method for the root object. To be implemented by subclasses.
     * @param fuelSite the root object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(IFuelSite fuelSite) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelingPosition. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param fuelPos the FuelingPosition object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(IFuelingPosition fuelPos) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelHose. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param hose the FuelHose object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelHose hose) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelMOP. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param mop the FuelMOP object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelMOP mop) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelProduct. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param prod the FuelProduct object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelProduct prod) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelServiceLevel. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param sl the FuelServiceLevel object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelServiceLevel sl) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelTank. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param tank the FuelTank object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelTank tank) throws SAXException {
    }
    
    /**
     * Visitor method for object of type NAXFuelProduct. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param product the NAXFuelProduct object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(NAXFuelProduct product) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelTier. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param tier the FuelTier object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelTier tier) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelBlendType. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param blend the FuelBlendType object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelBlendType blend) throws SAXException {
    }
    
    /**
     * Visitor method for object of type FuelTransaction. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param txn the FuelTransaction object
     * @exception org.xml.sax.SAXException thrown by visitor if any error is encountered
     */
    public void visit(FuelTransaction txn) throws SAXException {
    }
}
