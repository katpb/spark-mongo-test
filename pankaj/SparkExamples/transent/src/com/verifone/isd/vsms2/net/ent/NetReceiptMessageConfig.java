package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 *
 * @author  shanavas_p1
 */
public class NetReceiptMessageConfig  implements  INetReceiptMessageConfig,  Serializable {

   
    private static final long serialVersionUID = 2890705577190010694L;
    public static int INSIDE_MAXRECEIPTLINELENGTH 	= 40;  
    public static int OUTSIDE_MAXRECEIPTLINELENGTH 	= 20;
    
    public static final int RECEIPT_HEADER = 0;
    public static final int RECEIPT_FOOTER = 1;

    protected NetReceiptMessageConfigPK ID;   
    private int receiptType;
    protected String receiptLine;
    
    @Override
	public String toString()
    {
    	return receiptLine;
    }
    /** Creates a new instance of NetCCardConfig */
    public NetReceiptMessageConfig() {
	receiptLine = new String("");        
    }
    /**
     * to set the line number
     */
    @Override
	public void setRecordNr(short recordNr) {
        ID = new NetReceiptMessageConfigPK(recordNr);
    }  
    /**
     * to get the receipt line
     */
    @Override
	public String getReceiptLine() {
        return receiptLine;
    }
    /**
     * to set the receipt line
     */
    @Override
	public void setReceiptLine(String recieptLine) {
        receiptLine = recieptLine;
    }
    
    
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    @Override
	public IEntityPK getPK() {
        return ID;
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    @Override
	public void setPK(IEntityPK pk) {
        ID = (NetReceiptMessageConfigPK)pk;
    }    
    
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    @Override
	public void validate() throws Exception {
        
        if (!isPKValid()) {
            throw new Exception("validate:Invalid NetReceiptMessageConfigPK number: " +getPK());
        }
        if (receiptLine ==null ||receiptLine.length()== 0 ||receiptLine.length() > INSIDE_MAXRECEIPTLINELENGTH){
            throw new Exception("validate:Invalid receipt line length " +getReceiptLine());
        }
        
      
        
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    @Override
	public boolean isPKValid() {
        return getPK() == null ? false : getPK().isValid();
    }
    
    @Override
	public void setAttributes(IEntityObject obj) {
	NetReceiptMessageConfig netReceiptMessageConfig = (NetReceiptMessageConfig)obj;        
	netReceiptMessageConfig.ID = ID;
	netReceiptMessageConfig.receiptLine = receiptLine;
    }

    /**
	 * @return the receiptType
	 */
	public int getReceiptType() {
		return receiptType;
	}
	/**
	 * @param receiptType the receiptType to set
	 */
	public void setReceiptType(int receiptType) {
		this.receiptType = receiptType;
	}
}
