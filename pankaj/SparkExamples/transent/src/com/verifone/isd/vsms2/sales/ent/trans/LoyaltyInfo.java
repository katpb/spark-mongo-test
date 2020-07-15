/*
 * LoyaltyInfo.java
 *
 * Created on March 28, 2007, 11:16 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.verifone.isd.vsms2.fuel.ent.util.AuthorizeFuelingPosition;
import com.verifone.isd.vsms2.fuel.ent.util.PpgDiscDetails;
import com.verifone.isd.vsms2.net.ent.PromotionReasonEnum;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.NetworkRes;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Volume;

/**
 *
 * @author Steven_F2
 */
public class LoyaltyInfo extends DiscountInfo implements Serializable {
	private static final long serialVersionUID = -1133810857283348070L;
	
	// List of supported price tiers
	private static Set<Integer> priceTiers;
	
	static {
		priceTiers = new HashSet<Integer>();
		priceTiers.add(AuthorizeFuelingPosition.MOP_CASH);
		priceTiers.add(AuthorizeFuelingPosition.MOP_CREDIT);
	}
	
	private Volume preFuelLimit;	// Volume limit for PPG discount
    private String programID;  	// Loyalty program (FEP) identifer
    private String programName;	// Optional description of the loyalty program
    private int programPrecedence;	// Optional program precedence when DiscountMode is same
    private String rewardID;	// Reward ID (price adjustment ID) specific to a loyalty program
    private PromotionReasonEnum promotionReason;	// promotion reason sent by EPS
    private PpgDiscDetails ppgDetails;	// Multi-grade discounts for fuel prepay
    private boolean partialDiscountAllowed = true;	// If partial discount is allowed due to precedence rules
    private Map<Integer, PpgDiscDetails> priceTierPpgDetails; // Unique PPG discounts based on price tier
    private MoneyAmount appliedDiscount;	// For PPG type discount, indicates effective total discount
    private int productCode;	// product code used for ticket level discount
    private String epsName;		// to identify the EPS which gave this loyalty discount
    private boolean aboveSite;	// indicates site level vs. above site loyalty

    /** Creates a new instance of LoyaltyInfo */
    public LoyaltyInfo() {
    	priceTierPpgDetails = new HashMap<Integer, PpgDiscDetails>();
    }

	/**
	 * @return the preFuelLimit
	 */
	public Volume getPreFuelLimit() {
		return preFuelLimit;
	}

	/**
	 * @param limit the preFuelLimit to set
	 */
	public void setPreFuelLimit(Volume limit) {
		this.preFuelLimit = limit;
	}

	/**
	 * @return the programID
	 */
	public String getProgramID() {
		return programID;
	}

	/**
	 * @param programID the programID to set
	 */
	public void setProgramID(String programID) {
		this.programID = programID;
	}

	/**
	 * @return the rewardID
	 */
	public String getRewardID() {
		return rewardID;
	}

	/**
	 * @param rewardID the rewardID to set
	 */
	public void setRewardID(String rewardID) {
		this.rewardID = rewardID;
	}

	/**
	 * @return the ppgDetails
	 */
	public PpgDiscDetails getPpgDetails() {
		return ppgDetails;
	}

	/**
	 * @param ppgDetails the ppgDetails to set
	 */
	public void setPpgDetails(PpgDiscDetails ppgDetails) {
		this.ppgDetails = ppgDetails;
	}
	
	/**
	 * Return PPG discount details for the given price tier
	 * 
	 * @param priceTier
	 * @return PPG discount details for the given price tier
	 */
	public PpgDiscDetails getPpgDiscDetails(int priceTier) {
		PpgDiscDetails priceTierPpg = priceTierPpgDetails.get(priceTier);
		if (priceTierPpg == null) {
			priceTierPpg = ppgDetails;
		}
		return priceTierPpg;
	}
	
	/**
	 * Set PPG discount details for the given price tier
	 * 
	 * @param priceTier
	 * @param priceTierPpg
	 */
	public void setPpgDetails(int priceTier, PpgDiscDetails priceTierPpg) {
		if (priceTierPpg != null) {
			priceTierPpgDetails.put(priceTier, priceTierPpg);
		}
	}
	
	/**
	 * @return the partialDiscountAllowed
	 */
	public boolean isPartialDiscountAllowed() {
		return partialDiscountAllowed;
	}

	/**
	 * @param partialDiscountAllowed the partialDiscountAllowed to set
	 */
	public void setPartialDiscountAllowed(boolean partialDiscountAllowed) {
		this.partialDiscountAllowed = partialDiscountAllowed;
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		/*
		 * If program name or program id is available, return it as program
		 * name. Otherwise use a default program name depending on whether it is
		 * loyalty or payment based discount and whether it is above site or
		 * site level (via EPS) discount.
		 */
		if ((programName == null) || programName.isEmpty()) {
			if ((programID == null) || programID.isEmpty()) {
				if (isPaymentBasedDiscount()) {
					return ((aboveSite) ? LocalizedRB.getNetworkRes(NetworkRes.DEFAULT_ASA_HOST_DISCOUNT)
							: LocalizedRB.getNetworkRes(NetworkRes.DEFAULT_EPS_HOST_DISCOUNT));
				} else {
					return ((aboveSite) ? LocalizedRB.getNetworkRes(NetworkRes.DEFAULT_ASA_LOYALTY)
							: LocalizedRB.getNetworkRes(NetworkRes.DEFAULT_EPS_LOYALTY));
				}
			}
			return programID;
		}
		return programName;
	}

	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the programPrecedence
	 */
	public int getProgramPrecedence() {
		return programPrecedence;
	}

	/**
	 * @param programPrecedence the programPrecedence to set
	 */
	public void setProgramPrecedence(int programPrecedence) {
		this.programPrecedence = programPrecedence;
	}

	/**
	 * @return the appliedDiscount
	 */
	public MoneyAmount getAppliedDiscount() {
		if (appliedDiscount == null) {
			return super.getDiscountAmount();
		}
		return appliedDiscount;
	}

	/**
	 * @param appliedDiscount the appliedDiscount to set
	 */
	public void setAppliedDiscount(MoneyAmount appliedDiscount) {
		this.appliedDiscount = appliedDiscount;
	}

	/**
	 * @return the epsName
	 */
	public String getEpsName() {
		return epsName;
	}

	/**
	 * @param epsName the epsName to set
	 */
	public void setEpsName(String epsName) {
		this.epsName = epsName;
	}

	/**
	 * @return the productCode
	 */
	public int getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the promotionReason
	 */
	public PromotionReasonEnum getPromotionReason() {
		return promotionReason;
	}

	/**
	 * @param promotionReason the promotionReason to set
	 */
	public void setPromotionReason(PromotionReasonEnum promotionReason) {
		this.promotionReason = promotionReason;
	}

	/**
	 * Return the PPG discount amount for a given fuel product number
	 * 
	 * @param prodNum
	 *            fuel product number
	 * @return unit discount amount for the given product, null if there is no
	 *         discount
	 */
	public MoneyAmount getPpgDiscByGrade(int prodNum) {
		MoneyAmount unitDisc = null;
		if (ppgDetails != null) {
			unitDisc = ppgDetails.getDiscForProdNum(prodNum);
		}
		return unitDisc;
	}
	
	/**
	 * Return the PPG discount for a given price tier and given fuel product
	 * number
	 * 
	 * @param priceTier
	 * @param prodNum
	 * @return the PPG discount amount for the given price tier and fuel product
	 *         number
	 */
	public MoneyAmount getPpgDiscByGrade(int priceTier, int prodNum) {
		MoneyAmount unitDisc = null;
		PpgDiscDetails priceTierPpg = priceTierPpgDetails.get(priceTier);
		if (priceTierPpg != null) {
			unitDisc = priceTierPpg.getDiscForProdNum(prodNum);
		}
		/*
		 * If we are unable to find based on price tier, use old method to
		 * figure out discount amount for the grade (same for all price tiers)
		 */
		if (unitDisc == null) {
			unitDisc = getPpgDiscByGrade(prodNum);
		}
		return unitDisc;
	}
	
	/**
	 * Return the PPG discount amount for a given NACS product code
	 * 
	 * @param prodCode
	 *            NACS code of the fuel product
	 * @return unit discount amount for the given product code, null if there is
	 *         no discount
	 */
	public MoneyAmount getPpgDiscByProdcode(int prodCode) {
		MoneyAmount unitDisc = null;
		if (ppgDetails != null) {
			unitDisc = ppgDetails.getDiscForNacsCode(prodCode);
		}
		return unitDisc;
	}
	
	/**
	 * Return the PPG discount amount for the given price tier and given NACS
	 * product code
	 * 
	 * @param priceTier
	 * @param prodCode
	 * @return unit discount for given price tier and given NACS product code
	 */
	public MoneyAmount getPpgDiscByProdcode(int priceTier, int prodCode) {
		MoneyAmount unitDisc = null;
		PpgDiscDetails priceTierPpg = priceTierPpgDetails.get(priceTier);
		if (priceTierPpg != null) {
			unitDisc = priceTierPpg.getDiscForNacsCode(prodCode);
		}
		/*
		 * If we are unable to find based on price tier, use old method to
		 * figure out discount amount for the grade (same for all price tiers)
		 */
		if (unitDisc == null) {
			unitDisc = getPpgDiscByProdcode(prodCode);
		}
		return unitDisc;
	}
	
	/**
	 * Retain PPG discount only for selected grade and delete others.
	 * 
	 * @param prodNum
	 * @param prodNacsCode
	 */
	public void retainSelectedGradePpgDiscount(int prodNum, int prodNacsCode) {
		if (ppgDetails != null) {
			ppgDetails.retainSelectedGradeDiscount(prodNum, prodNacsCode);
		}
		for (Integer tier : priceTiers) {
			PpgDiscDetails ppg = priceTierPpgDetails.get(tier);
			if (ppg != null) {
				ppg.retainSelectedGradeDiscount(prodNum, prodNacsCode);
			}
		}
	}
	
	/**
	 * Adjust PPG discount (unit discount) to the new amount.
	 * 
	 * @param prodNum
	 * @param nacsCode
	 * @param discount
	 */
	public void setPpgDiscByGrade(int prodNum, int nacsCode, MoneyAmount discount) {
		if (ppgDetails == null) {
			ppgDetails = new PpgDiscDetails();
		}
		ppgDetails.addDiscForGrade(prodNum, nacsCode, discount);
	}
	
	/**
	 * Adjust PPG discount for given price tier and given fuel grade to the new amount.
	 * 
	 * @param priceTier
	 * @param prodNum
	 * @param nacsCode
	 * @param discount
	 */
	public void setPpgDiscByGrade(int priceTier, int prodNum, int nacsCode, MoneyAmount discount) {
		PpgDiscDetails priceTierPpg = priceTierPpgDetails.get(priceTier);
		if (priceTierPpg == null) {
			priceTierPpg = new PpgDiscDetails();
			priceTierPpgDetails.put(priceTier, priceTierPpg);
		}
		priceTierPpg.addDiscForGrade(prodNum, nacsCode, discount);
	}
	
	/**
	 * Reset any previously given PPG discount amounts to 0 to indicate that the
	 * PPG discount could not be used due to stacking or minimum
	 * price-per-gallon restrictions.
	 */
	public void resetPpgDiscounts() {
		if (ppgDetails != null) {
			ppgDetails.resetDiscounts();
		}
		for (Integer tier : priceTiers) {
			PpgDiscDetails ppg = priceTierPpgDetails.get(tier);
			if (ppg != null) {
				ppg.resetDiscounts();
			}
		}
	}
	
	/**
	 * Determine if this LoyaltyInfo object contains PPG discount
	 * 
	 * @return true if this contains PPG discount information
	 */
	public boolean isPpgDiscount() {
		return (ppgDetails != null) || !priceTierPpgDetails.isEmpty();
	}
	
	public void deepCopy(LoyaltyInfo clone) {
		clone.programID = this.programID;
		clone.programName = this.programName;
		clone.programPrecedence = this.programPrecedence;
		clone.rewardID = this.rewardID;
		if (this.preFuelLimit != null) {
			clone.preFuelLimit = new Volume(this.preFuelLimit);
		}
		clone.promotionReason = this.promotionReason;
		if (this.appliedDiscount != null) {
			clone.appliedDiscount = new MoneyAmount(this.appliedDiscount);
		}
		clone.productCode = this.productCode;
		clone.epsName = this.epsName;
		clone.aboveSite = this.aboveSite;
		super.deepCopy(clone);
	}
	
	/**
	 * Determine if this EPS discount is based on a payment card (e.g. host
	 * discount)
	 * 
	 * @return true if this EPS discount is based on a payment card
	 */
	public boolean isPaymentBasedDiscount() {
		return (promotionReason != null) && promotionReason.isPaymentBased();
	}

	public boolean isAboveSite() {
		return aboveSite;
	}

	public void setAboveSite(boolean aboveSite) {
		this.aboveSite = aboveSite;
	}
}
