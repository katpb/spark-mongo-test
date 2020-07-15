package com.verifone.isd.vsms2.fuel.ent;

/**
 *  Base visitor class for XML serialization and parsing. This class provides stub
 *  functions for the visit() method of all the visited objects 
 *	except the root object (i.e., the fuelSite domain object). XML processing 
 *  starts at the root object.
 *  Inheriting visitor classes should implement the visit() methods for
 *  the visited objects of interest.
 *
 *  The method visit() is the implementation of the Visitor pattern.
 *  A new visit() method for the appropriate domain object has to be registered with
 *  this base class if a new domain object is added and it has to be XML serialized/ parsed
 *
 *  Clients interested in obtaining XML serialized data should instantiate the appropriate 
 *  visitor subclass and call SAXWriter#writeSAX() passing the visitor as a parameter.
 *
 *  e.g.
 *	<pre>
 *  	SAXWriter sw = new SAXWriter(sm.getOutputStream());
 *		UserAdminXMLVisitor v = new UserAdminXMLVisitor();
 *      sw.writeSAX(v);
 *	</pre>
 *
 *  @author "mailto:marleen_d1@verifone.com"
 *  @version 1.0 Copyright(c) 2003 Verifone,Inc. All Rights Reserved
 */

public interface IFuelEntityVisitable
{
    public void accept(FuelEntityVisitor v) throws Exception;
}
