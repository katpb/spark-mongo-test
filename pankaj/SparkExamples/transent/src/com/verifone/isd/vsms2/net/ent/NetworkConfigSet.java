/*
 * NetworkConfigSet.java
 *
 * Created on February 14, 2003, 12:33 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.io.Serializable;

import java.util.Vector;

/**
 *
 * @author  Anindya_D1
 */
public class NetworkConfigSet implements Serializable
{
    static final long serialVersionUID = 6671183042921251386L;
    
    private static final String NETWORK_CONFIG = "networkConfig";
    
    // Class to hold individual network configuration
    private Class networkConfigClass;
    
    private Vector netSet;
    
    /** Creates a new instance of NetworkConfigSet */
    public NetworkConfigSet()
    {
        this.netSet = new Vector();
        try
        {
            String networkConfigClassName = SysPropertyFactory.getProperty("network.config.class");
            networkConfigClass = Class.forName(networkConfigClassName);
        }
        catch (Exception e)
        {
            System.err.println("Exception NetworkConfigSet() "+e.getMessage());
        }
    }
    
    public boolean recordExists(INetworkConfig newRecord)
    {
        return(this.netSet.contains(newRecord));
    }
    
    public void addRecordToSet(INetworkConfig newRecord) {
        this.netSet.addElement(newRecord);
    }

    public void removeRecordFromSet(INetworkConfig newRecord)
    {
        this.netSet.removeElement(newRecord);
    }
    
    public INetworkConfig[] toArray() {
        return (INetworkConfig[]) this.netSet.toArray(new INetworkConfig[0]);
    }
}
