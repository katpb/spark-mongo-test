package com.verifone.isd.vsms2.net.ent;

public class NetReceiptOutMessageConfig extends NetReceiptMessageConfig{
    
   
    private static final long serialVersionUID = -4785154516042355160L;

    public NetReceiptOutMessageConfig() {
	super(); 
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        
        if (!isPKValid()) {
            throw new Exception("validate:Invalid NetReceiptMessageConfigPK number: " +this.getPK());
        }
        if (this.receiptLine ==null ||this.receiptLine.length()== 0 ||this.receiptLine.length() > NetReceiptMessageConfig.OUTSIDE_MAXRECEIPTLINELENGTH){
            throw new Exception("validate:Invalid receipt line length " +this.getReceiptLine());
        }       
    }
}
