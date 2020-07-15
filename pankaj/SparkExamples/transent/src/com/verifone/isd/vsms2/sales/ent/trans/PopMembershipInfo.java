package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType;

/**
 *
 * @author  BHANU NARAYANAN
 */
public class PopMembershipInfo implements java.io.Serializable {
    static final long serialVersionUID = -4860763685188564265L;
    
    /** Holds value of property entryMethod. */
    private EntryMethod entryMethod;
    
    /** Holds value of property entryAtDCR. */
    private boolean entryAtDCR;
    
    /** Holds value of property memberId. */
    private String memberId;
    
    /** Holds value of property memberDiscountType. */
    private IPopDiscountType memberDiscountType;
    
    /** Creates a new instance of PopMembershipInfo */
    public PopMembershipInfo() {
    }
    
    /** Getter for property entryMethod.
     * @return Value of property entryMethod.
     *
     */
    public EntryMethod getEntryMethod() {
        return this.entryMethod;
    }
    
    /** Setter for property entryMethod.
     * @param entryMethod New value of property entryMethod.
     *
     */
    public void setEntryMethod(EntryMethod entryMethod) {
        this.entryMethod = entryMethod;
    }
    
    /** Getter for property entryAtDCR.
     * @return Value of property entryAtDCR.
     *
     */
    public boolean isEntryAtDCR() {
        return this.entryAtDCR;
    }
    
    /** Setter for property entryAtDCR.
     * @param entryAtDCR New value of property entryAtDCR.
     *
     */
    public void setEntryAtDCR(boolean entryAtDCR) {
        this.entryAtDCR = entryAtDCR;
    }
    
    /** Getter for property memberId.
     * @return Value of property memberId.
     *
     */
    public String getMemberId() {
        return this.memberId;
    }
    
    /** Setter for property memberId.
     * @param memberId New value of property memberId.
     *
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    /** Getter for property memberDiscountType.
     * @return Value of property memberDiscountType.
     */
    public IPopDiscountType getMemberDiscountType() {
        return this.memberDiscountType;
    }
    
    /** Setter for property memberDiscountType.
     * @param memberDiscountType New value of property memberDiscountType.
     */
    public void setMemberDiscountType(IPopDiscountType memberDiscountType) {
        this.memberDiscountType = memberDiscountType;
    }
    
}
