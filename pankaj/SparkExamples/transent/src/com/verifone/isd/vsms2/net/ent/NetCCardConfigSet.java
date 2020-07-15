/*
 * NetCCardConfigSet.java
 *
 * Created on February 14, 2003, 12:37 PM
 */

package com.verifone.isd.vsms2.net.ent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.io.Serializable;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author  Anindya_D1
 */
public class NetCCardConfigSet implements Serializable {

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetCCardConfigSet.class);
	private static final long serialVersionUID = 5070993017646396616L;
    
    private static final String NETCCARD_CONFIG = "netCCardConfig";
    
    // Class to hold individual credit card configuration
    private Class netCCardConfigClass;
    
    private Vector netCCSet;
    
    /** Creates a new instance of NetCCardConfigSet */
    public NetCCardConfigSet() {
        this.netCCSet = new Vector();
        try {
            String netCCardConfigClassName = SysPropertyFactory.getProperty("netCCard.config.class");
            netCCardConfigClass = Class.forName(netCCardConfigClassName);
        }
        catch (Exception e) {
            System.err.println("Exception NetCCardConfigSet() "+e.getMessage());
        }
    }

    public int getNumRecords() {
        return this.netCCSet.size();
    }
    
    public Vector getNetCCSet() {
        return this.netCCSet;
    }
    
    public boolean recordExists(INetCCardConfig record) {
        return(this.netCCSet.contains(record));
    }
    
    public void addRecordToSet(INetCCardConfig record) {
        int currentIndex = netCCSet.indexOf(record);
        if (currentIndex < 0) {
            netCCSet.addElement(record);
        }
        else {
            netCCSet.setElementAt(record, currentIndex);
        }
    }
    
    public void removeRecordFromSet(INetCCardConfig record) {
        this.netCCSet.removeElement(record);
    }
    
    public void addSetToSet(NetCCardConfigSet recordSet) {
        INetCCardConfig[] otherSet = recordSet.toArray();
        for (int i = 0; i < otherSet.length; i++) {
            this.addRecordToSet(otherSet[i]);
        }
    }
    
    public INetCCardConfig[] toArray() {
        return (INetCCardConfig[]) this.netCCSet.toArray(new INetCCardConfig[0]);
    }
    
    public String cardType2Name(CardTypeDef cardTypeObj) {
        String cardName = null;
        INetCCardConfig isoRecord = this.cardObj2ISORecord(cardTypeObj);
        if (isoRecord != null) {
            cardName = isoRecord.getCCName();
        }
        
        return cardName;
    }
    
    public INetCCardConfig cardObj2ISORecord(CardTypeDef cardTypeObj) {
        INetCCardConfig isoRecord = null;
        Enumeration allRecords = netCCSet.elements();
        while ((allRecords.hasMoreElements()) && (isoRecord == null)) {
            INetCCardConfig singleCardConfig = (INetCCardConfig) allRecords.nextElement();
            if (cardTypeObj == singleCardConfig.getCCTypeObj()) {
                isoRecord = singleCardConfig;
            }
        }
        
        return isoRecord;
    }
    
    public INetCCardConfig cardType2ISORecord(int cardtype) {
        INetCCardConfig isoRecord = null;
        Enumeration allRecords = netCCSet.elements();
        while ((allRecords.hasMoreElements()) && (isoRecord == null)) {
            INetCCardConfig singleCardConfig = (INetCCardConfig) allRecords.nextElement();
            if (cardtype == singleCardConfig.getCCTypeObj().getValue()) {
                isoRecord = singleCardConfig;
            }
        }
        
        return isoRecord;
    }
    
}
