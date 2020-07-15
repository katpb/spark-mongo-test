package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

/**
 * Enumeration to capture possible exception conditions that could arise while
 * evaluating itemlines/paymentlines within an evaluateSale request.
 * @author Sudesh_S1
 */
public enum ExceptionType implements Serializable {

    CUSTOMER_DOB("customerDOB"),
    ITEM_INVALID("itemInvalid"),
    ITEM_NOT_ALLOWED("itemNotAllowed"),
    PAYMENT_NOT_ALLOWED("paymentNotAllowed"),
	CUSTOMER_NAME("customerNameRequired"),
	PROD_CODE_REQ("productCodeRequired"),
	INVALID_MOP_AMOUNT("invalidMopAmount"),
	NO_REFUND_ALLOWED("noRefundAllowed"),
	NO_CHANGE_ALLOWED("noChangeAllowed"),
	NO_MONEYORDER_PURCHASE_FOR_MOP("noMoneyOrderPurchaseForMop"),
	SALE_REQUIRED("saleRequired"),
	AMOUNT_REQUIRED("amountRequired"),
	AMOUNT_TOO_SMALL("amountTooSmall"),
	AMOUNT_TOO_LARGE("amountTooLarge"),
	MOP_INVALID_NOT_ALLOWED("mopInvalidNotAllowed"),
	NO_SPLIT_TENDER_FOR_THIS_MOP("noSplitTenderForThisMop"),
	MOP_CONFLICT("mopConflict"),
	NO_ELIGIBLE_ITEM("noEligibleItem"),
	MUST_BE_FIRST_MOP("mustBeFirstMop"),
	MUST_USE_FOOD_STAMP_NON_TAX_COUPON_AS_FIRST_MOP("mustUseFoodStampNonTaxCouponAsFirstMop"),
	INVALID_AMOUNT_ENTERED("invalidAmountEntered");

    private final String name;
    
    private ExceptionType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
