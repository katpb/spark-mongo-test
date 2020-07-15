package com.verifone.isd.vsms2.net.ent;

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
 *  @author "mailto:bhanu_narayanan@hp.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */

public abstract class NetEntityVisitor {
    /**
     * Visitor method for object of type NetBatchConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netBatchConfig the NetBatchConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetBatchConfigBase netBatchConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetCCardConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netCCardConfig the NetCCardConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any error is
     * encountered
     */
    public void visit(NetCCardConfigBase netCCardConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetDealerConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netDealerConfig the NetDealerConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any error is
     * encountered
     */
    public void visit(NetDealerConfigBase netDealerConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetDebitConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netDebitConfig the NetDebitConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetDebitConfigBase netDebitConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetEBTConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netEBTConfig the NetEBTConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetEBTConfigBase netEBTConfig) throws Exception {
    }

    /**
     * Visitor method for object of type NetPhoneConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netPhoneConfig the NetPhoneConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetPhoneConfigBase netPhoneConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetPrepaidConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netPrepaidConfig the NetPrepaidConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetPrepaidConfigBase netPrepaidConfig) throws Exception {
    }
    
    /**
     * Visitor method for object of type NetworkConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param networkConfig the NetworkConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetworkConfigBase networkConfig) throws Exception {
    }
}