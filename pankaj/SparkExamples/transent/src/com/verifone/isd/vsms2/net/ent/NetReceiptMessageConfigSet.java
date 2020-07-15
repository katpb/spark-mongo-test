package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;
import java.util.Vector;

/**
 *  This is a config set class for storing a set of NetReceiptMessageConfig instances.
 * @author  shanavas_p1
 */
public class NetReceiptMessageConfigSet implements Serializable {

    private static final long serialVersionUID = 840885708850276898L;
    public static final int NETWORK_DCR_PRINT_TRAILER = 0;
    public static final int NETWORK_POS_PRINT_TRAILER = 1;
    
    
    private int receiptType;    
    private Vector netReceiptMessage;
    
    /** Creates a new instance of NetCCardConfigSet */
    public NetReceiptMessageConfigSet() {
        this.netReceiptMessage = new Vector();      
    }
    /**
     * 
     * @return number of records
     */
    public int getNumRecords() {
        return this.netReceiptMessage.size();
    }
    /**
     * 
     * @return the receipt set
     */
    public Vector getNetCCSet() {
        return this.netReceiptMessage;
    }
    /**
     * finds a perticular record exist or not
     * @param record
     * @return
     */
    public boolean recordExists(INetReceiptMessageConfig record) {
        return(this.netReceiptMessage.contains(record));
    }
    /**
     * Add a new recor to the record set
     * @param record
     */
    public void addRecordToSet(INetReceiptMessageConfig record) {
        int currentIndex = netReceiptMessage.indexOf(record);
        if (currentIndex < 0) {
            netReceiptMessage.addElement(record);
        }
        else {
            netReceiptMessage.setElementAt(record, currentIndex);
        }
    }
    /**
     * removes a record from the set
     * @param record
     */
    public void removeRecordFromSet(INetReceiptMessageConfig record) {
        this.netReceiptMessage.removeElement(record);
    }
    /**
     * Add a new set to this set
     * @param recordSet
     */
    public void addSetToSet(NetReceiptMessageConfigSet recordSet) {
	NetReceiptMessageConfig[] otherSet = recordSet.toArray();
        for (int i = 0; i < otherSet.length; i++) {
            this.addRecordToSet(otherSet[i]);
        }
    }
    /**
     * 
     * @return an array of NetReceiptMessageConfig instances from the set
     */
    public NetReceiptMessageConfig[] toArray() {
        return (NetReceiptMessageConfig[]) this.netReceiptMessage.toArray(new NetReceiptMessageConfig[0]);
    }

    /**
     * @return the recieptType
     */
    public int getRecieptType() {
        return receiptType;
    }

    /**
     * @param recieptType the recieptType to set
     */
    public void setRecieptType(int recieptType) {
        this.receiptType = recieptType;
    }    
}
