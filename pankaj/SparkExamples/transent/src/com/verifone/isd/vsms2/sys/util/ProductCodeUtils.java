package com.verifone.isd.vsms2.sys.util;

public class ProductCodeUtils {

	public static final int SPLIT_TENDER_PRODCODE = 913;
	public static final int TAX_PRODCODE = 950;
	public static final int CASHBACK_PRODCODE = 955;
	public static final int EPS_LOY_TRAN_DISC_PRODCODE = 904;
	public static final int EPS_LOY_TRAN_DISC_PRODCODE_LOW = 900;
	public static final int EPS_LOY_TRAN_DISC_PRODCODE_HIGH = 904;
	public static final int OTHER_TRAN_DISC_PRODCODE = 905;
	public static final int FUEL_DISC_PRODCODE = 947;
	public static final int NON_FUEL_DISC_PRODCODE = 948;
	public static final int FEE_PRODCODE_START = 957;
	public static final int FEE_PRODCODE_END = 961;
	public static final int CAR_WASH_PROD_CODE = 102;
	public static final int FUEL_PRODCODE_START = 1;
	public static final int FUEL_PRODCODE_END = 99;
	
	/**
	 * Check if provided product code is in range of fuel product code.
	 * @param prodCode
	 * @return true if provided product code is in range of fuel product code.
	 */
	public static boolean isFuelProductCode(int prodCode){
		return (prodCode >= FUEL_PRODCODE_START && prodCode <= FUEL_PRODCODE_END);
	}
	
	/**
	 * Check if provided product code is in range of fee product code.
	 * @param prodCode
	 * @return true if provided product code is in range of fee product code.
	 */
	public static boolean isFeeProductCode(int prodCode){
		return (prodCode >= FEE_PRODCODE_START && prodCode <= FEE_PRODCODE_END);
	}
	
	/**
	 * It check the provided product is car wash product code
	 * @param prodCode
	 * @return true if provided product code is a car wash product code.
	 */
	public static boolean isCarWashProductCode(int prodCode){
		return (prodCode == CAR_WASH_PROD_CODE);
	}
}
