/**
 * 
 */
package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * @author anindya_d1
 * 
 */
public class PpgDiscDetails implements Serializable, Cloneable {

	private static final long serialVersionUID = 8120098607550453344L;
	/**
	 * Holds discount details for each discounted grade with fuel product number
	 * as key
	 */
	private Map<Integer, MoneyAmount> discAmtsByProdNum;
	/**
	 * Holds discount details for each discounted grade with fuel NACS product
	 * code as key
	 */
	private Map<Integer, MoneyAmount> discAmtsByProdNacsCode;

	/**
     * 
     */
	public PpgDiscDetails() {
		discAmtsByProdNum = new HashMap<Integer, MoneyAmount>();
		discAmtsByProdNacsCode = new HashMap<Integer, MoneyAmount>();
	}

	/**
	 * Store the PPG discount amount for the given fuel product number
	 * 
	 * @param prodNum
	 *            fuel product number
	 * @param discAmount
	 *            PPG discount amount for the given fuel grade
	 */
	public void addDiscForGrade(int prodNum, int prodNacsCode,
			MoneyAmount discAmount) {
		discAmtsByProdNum.put(prodNum, discAmount);
		discAmtsByProdNacsCode.put(prodNacsCode, discAmount);
	}

	/**
	 * Provide an API to clear unnecessary PPG discount elements once a grade
	 * was selected due to gallon limit or card restrictions. The assumption is
	 * that PPG discount amounts were already received for several grades but
	 * POS needed to enforce grade selection later.
	 * 
	 * @param prodNum
	 *            fuel product number
	 * @param prodNacsCode
	 *            NACS product code for the fuel grade
	 */
	public void retainSelectedGradeDiscount(int prodNum, int prodNacsCode) {
		MoneyAmount gradeDiscount = discAmtsByProdNum.get(prodNum);
		resetDiscounts();
		if (gradeDiscount != null) {
			discAmtsByProdNum.put(prodNum, gradeDiscount);
			discAmtsByProdNacsCode.put(prodNacsCode, gradeDiscount);
		}
	}

	/**
	 * Return the PPG discount amount for the given fuel product number
	 * 
	 * @param grade
	 *            fuel product number
	 * @return PPG discount amount for the given fuel grade
	 */
	public MoneyAmount getDiscForProdNum(int prodNum) {
		return discAmtsByProdNum.get(prodNum);
	}

	/**
	 * Return the PPG discount amount for the given fuel product nacs code
	 * 
	 * @param grade
	 *            fuel nacs code
	 * @return PPG discount amount for the given fuel grade
	 */
	public MoneyAmount getDiscForNacsCode(int prodNacsCode) {
		return discAmtsByProdNacsCode.get(prodNacsCode);
	}

	/**
	 * Return the number of the PPG discount elements. If this is empty, it
	 * indicates that no PPG discount was applied on the PrepayItemLine.
	 * 
	 * @return the number of PPG discount elements
	 */
	public int getNumDiscounts() {
		return discAmtsByProdNum.size();
	}
	
	/**
	 * Reset all previously given PPG discount amounts to 0 to indicate that the
	 * discount could not be used due to stacking or minimum price-per-gallon
	 * restrictions
	 */
	public void resetDiscounts() {
		discAmtsByProdNum.clear();
		discAmtsByProdNacsCode.clear();
	}

	/**
	 * Implement Cloneable interface
	 * 
	 * @return the cloned object
	 */
	public Object clone() {
		PpgDiscDetails ppgDetails = null;
		try {
			ppgDetails = (PpgDiscDetails) (super.clone());
		} catch (CloneNotSupportedException badclone) {
			throw new InternalError(badclone.toString());
		}
		ppgDetails.discAmtsByProdNum = this.discAmtsByProdNum;
		ppgDetails.discAmtsByProdNacsCode = this.discAmtsByProdNacsCode;
		return ppgDetails;
	}

	/**
	 * @return the discAmtsByProdNum
	 */
	public Map<Integer, MoneyAmount> getDiscAmtsByProdNum() {
		return discAmtsByProdNum;
	}
}
