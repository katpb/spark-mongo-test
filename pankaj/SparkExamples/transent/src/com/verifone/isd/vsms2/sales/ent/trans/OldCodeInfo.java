/*
 * OldCodeInfo.java
 *
 * Created on January 12, 2004, 9:46 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 *
 * @author  BHANU NARAYANAN
 */
public class OldCodeInfo implements java.io.Serializable {
    static final long serialVersionUID = 2839613076444042204L;
    /** Holds value of property popCodeInfo. */
    private PopCodeInfo popCodeInfo;
    
    /** Holds value of property oldCodeUsed. */
    private boolean oldCodeUsed;
    
    /** Holds value of property redeemedCodeDtls. */
    private RedeemedCodeDtls redeemedCodeDtls;
    
    /** Holds value of property unusedCodeDtls. */
    private AddlCodeDtls unusedCodeDtls;
    
    /** Holds value of property codeRejectionMsg. */
    private String codeRejectionMsg;
    
    /** Creates a new instance of OldCodeInfo */
    public OldCodeInfo() {
    }
    
    /** Getter for property popCodeInfo.
     * @return Value of property popCodeInfo.
     *
     */
    public PopCodeInfo getPopCodeInfo() {
        return this.popCodeInfo;
    }
    
    /** Setter for property popCodeInfo.
     * @param popCodeInfo New value of property popCodeInfo.
     *
     */
    public void setPopCodeInfo(PopCodeInfo popCodeInfo) {
        this.popCodeInfo = popCodeInfo;
    }
    
    /** Getter for property oldCodeUsed.
     * @return Value of property oldCodeUsed.
     *
     */
    public boolean isOldCodeUsed() {
        return this.oldCodeUsed;
    }
    
    /** Setter for property oldCodeUsed.
     * @param oldCodeUsed New value of property oldCodeUsed.
     *
     */
    public void setOldCodeUsed(boolean oldCodeUsed) {
        this.oldCodeUsed = oldCodeUsed;
    }
    
    /** Getter for property redeemedCodeDtls.
     * @return Value of property redeemedCodeDtls.
     *
     */
    public RedeemedCodeDtls getRedeemedCodeDtls() {
        return this.redeemedCodeDtls;
    }
    
    /** Setter for property redeemedCodeDtls.
     * @param redeemedCodeDtls New value of property redeemedCodeDtls.
     *
     */
    public void setRedeemedCodeDtls(RedeemedCodeDtls redeemedCodeDtls) {
        this.redeemedCodeDtls = redeemedCodeDtls;
    }
    
    /** Getter for property unusedCodeDtls.
     * @return Value of property unusedCodeDtls.
     *
     */
    public AddlCodeDtls getUnusedCodeDtls() {
        return this.unusedCodeDtls;
    }
    
    /** Setter for property unusedCodeDtls.
     * @param unusedCodeDtls New value of property unusedCodeDtls.
     *
     */
    public void setUnusedCodeDtls(AddlCodeDtls unusedCodeDtls) {
        this.unusedCodeDtls = unusedCodeDtls;
    }
    
    /** Getter for property codeRejectionMsg.
     * @return Value of property codeRejectionMsg.
     *
     */
    public String getCodeRejectionMsg() {
        return this.codeRejectionMsg;
    }
    
    /** Setter for property codeRejectionMsg.
     * @param codeRejectionMsg New value of property codeRejectionMsg.
     *
     */
    public void setCodeRejectionMsg(String codeRejectionMsg) {
        this.codeRejectionMsg = codeRejectionMsg;
    }
    
}
