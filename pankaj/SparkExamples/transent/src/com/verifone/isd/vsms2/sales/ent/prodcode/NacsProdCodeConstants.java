package com.verifone.isd.vsms2.sales.ent.prodcode;

import java.util.Hashtable;

/**
 * @author marleen_d1
 *
 */
public final class NacsProdCodeConstants { 
	
	public static final int DISCPRODCODE     = 900; 
	public static final int TAXPCODE         = 950;
	public static final int COUPONPCODE      = 905;
	public static final int SPLITPCODE       = 913;
	public static final int CASHBACKPCODE	 = 955;
	public static final int CASHBACKFEEPCODE = 956;
 
	private NacsProdCodeConstants(){
	}
	
	private static Hashtable epsPrepaidNACSCodes = new Hashtable();
	
    static{
    	epsPrepaidNACSCodes.put(new Integer(560), "PIN_ACTIVATE_PREPAID_CARD");
    	epsPrepaidNACSCodes.put(new Integer(561), "PIN_RETURN_PREPAID_CARD");
    	epsPrepaidNACSCodes.put(new Integer(562), "ENABLE_DEVICE_OR_HANDSET_UNLOCK");
    	epsPrepaidNACSCodes.put(new Integer(563), "DISABLE_DEVICE_OR_HANDSET_LOCK"); 
    	epsPrepaidNACSCodes.put(new Integer(564), "3RD_PARTY_PREPAID_CARD_ACTIVATE");
    	epsPrepaidNACSCodes.put(new Integer(565), "3RD_PARTY_PREPAID_CARD_RELOAD");
    	epsPrepaidNACSCodes.put(new Integer(566), "FINANCIAL_PREPAID_CARD_ACTIVATE");
    	epsPrepaidNACSCodes.put(new Integer(567), "FINANCIAL_PREPAID_CARD_RELOAD");
    	epsPrepaidNACSCodes.put(new Integer(568), "PROPREITARY_PREPAID_CARD_ACTIVATE");
    	epsPrepaidNACSCodes.put(new Integer(569), "PROPREITARY_PREPAID_CARD_RELOAD");
    	epsPrepaidNACSCodes.put(new Integer(570), "GENERAL_PURPOSE_ACTIVATE");
    	epsPrepaidNACSCodes.put(new Integer(571), "GENERAL_PURPOSE_RELOADABLE");
    	epsPrepaidNACSCodes.put(new Integer(572), "REAL_TIME_RECHARGE");
    	epsPrepaidNACSCodes.put(new Integer(573), "WIRELESS_REAL_TIME_RECHARGE");
    	epsPrepaidNACSCodes.put(new Integer(574), "SINGLE_PAYEE_BILL_PAY");
    	epsPrepaidNACSCodes.put(new Integer(575), "MULTIPLE_PAYEE_BILL_PAY");
    }
    
 /**
  * This method will check, whether a department is a EPSPrepaid department or not by checking
  * its product code has a match in NACS product code defined for EPSPrepaid departments.
  * @param productCode int.
  * @return isEpsPrepaidDept boolean.
  */
    
    public static boolean isEpsPrepaidDept(int productCode){
    	
    	boolean isEpsPrepaidDept = false;
    	if(epsPrepaidNACSCodes.get(new Integer(productCode)) != null){
    		isEpsPrepaidDept = true;
    	}
    	
    	return isEpsPrepaidDept;
    }

	public static boolean isPinActivate(int productCode) {

		boolean isPinActivate = false;
		if (isEpsPrepaidDept(productCode)
				&& (epsPrepaidNACSCodes.get(productCode).equals(
						"PIN_ACTIVATE_PREPAID_CARD"))) {
			isPinActivate = true;
		}

		return isPinActivate;
	}
}
