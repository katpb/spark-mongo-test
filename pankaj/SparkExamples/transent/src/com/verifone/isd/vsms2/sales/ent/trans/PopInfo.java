package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.verifone.isd.vsms2.sys.util.ReceiptPromoType;
/**
 *
 * @author  BHANU NARAYANAN
 */
public class PopInfo implements java.io.Serializable {
    static final long serialVersionUID =  5107616271139384667L;;
    
    /** Holds value of property memberInfo. */
    private PopMembershipInfo memberInfo;
    
    /** Holds value of property oldCodeInfo. */
    private OldCodeInfo oldCodeInfo;
    
    /** Holds value of property programName. */
    private String programName;
    
    /** Holds value of property discountDetail. */
    private Map<DiscountBasis, PopDiscDetail> discountDetails;
    
    /** Holds value of property awardGenerationDetail. */
    private PopAwardGenDetail awardGenerationDetail;
    
    /** Holds value of property promoMsgType. */
    private ReceiptPromoType promoMsgType;
    
    /** Creates a new instance of PopDiscountInfo */
    public PopInfo() {
    	discountDetails = new HashMap<DiscountBasis, PopDiscDetail>();
    }
    
    /** Getter for property memberInfo.
     * @return Value of property memberInfo.
     *
     */
    public PopMembershipInfo getMemberInfo() {
        return this.memberInfo;
    }
    
    /** Setter for property memberInfo.
     * @param memberInfo New value of property memberInfo.
     *
     */
    public void setMemberInfo(PopMembershipInfo memberInfo) {
        this.memberInfo = memberInfo;
    }
    
    /** Getter for property codeInfo.
     * @return Value of property codeInfo.
     *
     */
    public OldCodeInfo getOldCodeInfo() {
        return this.oldCodeInfo;
    }
    
    /** Setter for property codeInfo.
     * @param oldCodeInfo New value of property codeInfo.
     *
     */
    public void setOldCodeInfo(OldCodeInfo oldCodeInfo) {
        this.oldCodeInfo = oldCodeInfo;
    }
    
    /** Getter for property programName.
     * @return Value of property programName.
     */
    public String getProgramName() {
        return this.programName;
    }
    
    /** Setter for property programName.
     * @param programName New value of property programName.
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }
    
    /** Getter for property discountDetail.
     * @return Value of property discountDetail.
     */
	public List<PopDiscDetail> getDiscountDetails() {
		return Arrays.asList(this.discountDetails.values().toArray(
				new PopDiscDetail[0]));
	}
    
	/**
	 * @param discountDetail
	 *            discount detail to be added
	 */
    public void addDiscountDetail(DiscountBasis basis, PopDiscDetail discountDetail) {
        this.discountDetails.put(basis, discountDetail);
    }
    
    /** Getter for property awardGenerationDetail.
     * @return Value of property awardGenerationDetail.
     */
    public PopAwardGenDetail getAwardGenerationDetail() {
        return this.awardGenerationDetail;
    }
    
    /** Setter for property awardGenerationDetail.
     * @param awardGenerationDetail New value of property awardGenerationDetail.
     */
    public void setAwardGenerationDetail(PopAwardGenDetail awardGenerationDetail) {
        this.awardGenerationDetail = awardGenerationDetail;
    }
    
    /** Getter for property promoMsgType.
     * @return Value of property promoMsgType.
     *
     */
    public ReceiptPromoType getPromoMsgType() {
        return this.promoMsgType;
    }
    
    /** Setter for property promoMsgType.
     * @param promoMsgType New value of property promoMsgType.
     *
     */
    public void setPromoMsgType(ReceiptPromoType promoMsgType) {
        this.promoMsgType = promoMsgType;
    }
    
    public boolean isPrintingReqd() {
        boolean required = false;
        
		if (((this.discountDetails != null) && !this.discountDetails.isEmpty())
				|| (this.awardGenerationDetail != null)
				|| (this.oldCodeInfo != null) || (this.memberInfo != null)) {
			required = true;
		}
        
        return required;
    }
    
}
