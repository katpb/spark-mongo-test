package com.verifone.isd.vsms2.fuel.ent;

import com.verifone.isd.vsms2.fuel.ent.rcf.RCFAttributeConfig;
import com.verifone.isd.vsms2.fuel.ent.rcf.RCFConfig;
import com.verifone.isd.vsms2.fuel.ent.totals.FuelTotals;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.IFuelSite;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelServiceLevel;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelMOP;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelTank;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelHose;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelProduct;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.IFuelingPosition;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelBlendType;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelTier;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.NAXFuelProduct;

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
 *  @author "mailto:Marleen_D1@verifone.com"
 *  @version 1.0 Copyright(c) 2003 Verifone Company, All Rights Reserved
 */

public abstract class FuelEntityVisitor {
         
    /**
     * Visitor method for object of type FuelTotals
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param fuelTot the FuelTotals object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(FuelTotals fuelTot) throws Exception {
    }    
    
    /**
     * Visitor method for the root object. To be implemented by subclasses.
     * @param fuelSite the root object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(IFuelSite fuelSite) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelingPosition. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param fuelPos the FuelingPosition object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(IFuelingPosition fuelPos) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelHose. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param hose the FuelHose object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelHose hose) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelMOP. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param mop the FuelMOP object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelMOP mop) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelProduct. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param prod the FuelProduct object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelProduct prod) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelServiceLevel. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param sl the FuelServiceLevel object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelServiceLevel sl) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelTank. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param tank the FuelTank object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelTank tank) throws Exception {
    }
    
    /**
     * Visitor method for object of type NAXFuelProduct. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param prod the NAXFuelProduct object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(NAXFuelProduct prod) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelTier. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param tier the FuelTier object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelTier tier) throws Exception {
    }
    
    /**
     * Visitor method for object of type FuelBlendType. Default behavior is no-op.
     * To be implemented by subclasses if any special processing is required.
     * @param blend the FuelBlendType object
     * @exception org.xml.sax.Exception thrown by visitor if any error is encountered
     */
    public void visit(FuelBlendType blend) throws Exception {
    }
    

    /**
     * Visitor method for Rapid Change Fuel Configuration
     * @param rcfConfig
     * @throws Exception
     */
    public void visit(RCFConfig rcfConfig) throws Exception {
    }

    /**
     * Visitor method for Rapid Change Fuel Attributes Configuration
     * @param rcfFPConfig
     * @throws Exception
     */
    public void visit(RCFAttributeConfig rcfFPConfig) throws Exception {
    }
	
}