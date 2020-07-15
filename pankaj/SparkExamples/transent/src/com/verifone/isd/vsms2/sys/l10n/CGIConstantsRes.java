package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class CGIConstantsRes extends ListResourceBundle {

  public static String DATA_DEPT_RPT = "DATA_DEPT_RPT";
  public static String DATA_SUMMARY_RPT = "DATA_SUMMARY_RPT";
  public static String DATA_TAX_RPT = "DATA_TAX_RPT";
  public static String DATA_LOYALTY_RPT = "DATA_LOYALTY_RPT";
  public static String DATA_HOURLY_RPT = "DATA_HOURLY_RPT";
  public static String DATA_NETWORK_RPT = "DATA_NETWORK_RPT";
  public static String DATA_NETPROD_RPT = "DATA_NETPROD_RPT";
  public static String DATA_PROP_CARD_RPT = "DATA_PROP_CARD_RPT";
  public static String DATA_PROP_PROD_RPT = "DATA_PROP_PROD_RPT";
  public static String DATA_DEAL_RPT = "DATA_DEAL_RPT";
  public static String DATA_POPDISC_RPT = "DATA_POPDISC_RPT";
  public static String DATA_PLU_RPT = "DATA_PLU_RPT";
  public static String DATA_PLUPROMO_RPT = "DATA_PLUPROMO_RPT";
  public static String DATA_CATEGORY_RPT = "DATA_CATEGORY_RPT";
  public static String DATA_DCRSTAT_RPT = "DATA_DCRSTAT_RPT";
  public static String DATA_FPTEST_RPT = "DATA_FPTEST_RPT";
  public static String DATA_FP_RPT = "DATA_FP_RPT";
  public static String DATA_FPRUN_RPT = "DATA_FPRUN_RPT";
  public static String DATA_PRODPLVL_RPT = "DATA_PRODPLVL_RPT";
  public static String DATA_SLPLVL_RPT = "DATA_SLPLVL_RPT";
  public static String DATA_TIERPROD_RPT = "DATA_TIERPROD_RPT";
  public static String DATA_AUTOCOL_RPT = "DATA_AUTOCOL_RPT";
  public static String DATA_CASHACCT_RPT = "DATA_CASHACCT_RPT";
  public static String DATA_TANK_RPT = "DATA_TANK_RPT";
  public static String DATA_TANKMON_RPT = "DATA_TANKMON_RPT";
  public static String DATA_TANKREC_RPT = "DATA_TANKREC_RPT";
  public static String DATA_CARWASH_RPT = "DATA_CARWASH_RPT";
  public static String DATA_MO_DEVICE_RPT = "DATA_MO_DEVICE_RPT";
  public static String DATA_NETWORKTOTALS = "DATA_NETWORKTOTALS";
  public static String DATA_PAYROLL_RPT = "DATA_PAYROLL_RPT";
  public static String DATA_BATCH_SUMMARY = "DATA_BATCH_SUMMARY";
  public static String DATA_BATCH_TOTALS = "DATA_BATCH_TOTALS";
  public static String DATA_ECHECK_RPT = "DATA_ECHECK_RPT";
  public static String DATA_NET_LOYALTY = "DATA_NETWORK_LOYALTY";
  public static String DATA_PREPAID_TOTALS = "DATA_PREPAID_TOTALS";
  public static String DATA_STORE_COMMERCIAL_RPT = "DATA_STORE_COMMERCIAL_RPT";
  public static String DATA_STORE_FORWARD_RPT = "DATA_STORE_FORWARD_RPT";
  public static String DATA_TOTALS_SUMMARY_RPT = "DATA_TOTALS_SUMMARY_RPT";
  public static String DATA_REFUND_UNDERRUN_RPT = "DATA_REFUND_UNDERRUN_RPT";
  public static String CGI_PARSE_ERROR = "CGI_PARSE_ERROR";  
  public static String CGI_INERNAL_ERROR = "CGI_INERNAL_ERROR";
  public static String CGI_TIME_OUT = "CGI_TIME_OUT";
  public static String ALL_DCRS_NOT_IDLE = "ALL_DCRS_NOT_IDLE";
  
	public Object[][] getContents() {
	  return contents;
	}

    static private final Object[][] contents = {
         { DATA_DEPT_RPT,      "Department"},
         { DATA_SUMMARY_RPT,   "Summary By Register"},
         { DATA_TAX_RPT,       "Tax"},
         { DATA_LOYALTY_RPT,   "Loyalty"},
         { DATA_HOURLY_RPT,    "Hourly"},
         { DATA_NETWORK_RPT,   "Network"},
         { DATA_NETPROD_RPT,   "Network Product"},
         { DATA_PROP_CARD_RPT, "Proprietary Network Card"},
         { DATA_PROP_PROD_RPT, "Proprietary Network Product"},
         { DATA_DEAL_RPT,      "Deal"},
         { DATA_POPDISC_RPT,   "POP Fuel Discount"},
         { DATA_PLU_RPT,       "PLU"},
         { DATA_PLUPROMO_RPT,  "PLU Promo"},
         { DATA_CATEGORY_RPT,  "Category"},
         { DATA_DCRSTAT_RPT,   "Fuel DCR Statistics"},
         { DATA_FPTEST_RPT,    "FP Hose Test Report"},
         { DATA_FP_RPT,        "FP Hose Report"},
         { DATA_FPRUN_RPT,     "FP Hose Running Report"},
         { DATA_PRODPLVL_RPT,  "Product/Price Level Report"},
         { DATA_SLPLVL_RPT,    "Service Level/Price Level Report"},
         { DATA_TIERPROD_RPT,  "Tier Product Report"},
         { DATA_AUTOCOL_RPT,   "Autocollect Report"},
         { DATA_CASHACCT_RPT,  "Cash Acceptor Report"},
         { DATA_TANK_RPT,      "Fuel Tank"},
         { DATA_TANKMON_RPT,   "Tank Monitor Report"},
         { DATA_TANKREC_RPT,   "Tank Reconciliation Report"},
         { DATA_CARWASH_RPT,   "Car wash Report"},
         { DATA_MO_DEVICE_RPT, "Money Order Device Report"},
         { DATA_NETWORKTOTALS, "Network Totals"},
         { DATA_PAYROLL_RPT,   "Payroll Report"},
         { DATA_BATCH_SUMMARY, "Batch Summary Report"},
         { DATA_BATCH_TOTALS,  "Batch Totals Report"},
         { DATA_NET_LOYALTY,   "Network Loyalty Discount Report"},
         { DATA_PREPAID_TOTALS,  "Prepaid Totals Report"},
         { DATA_STORE_COMMERCIAL_RPT, "Store Commercial"},
         { DATA_STORE_FORWARD_RPT, "Store Forward"},
         { DATA_TOTALS_SUMMARY_RPT, "Totals Summary"},
         { DATA_REFUND_UNDERRUN_RPT, "Refund Underrun"},
         { DATA_ECHECK_RPT,    "eCheck Report"},
         { CGI_PARSE_ERROR,    "Parse Error"},
         { CGI_INERNAL_ERROR,    "Internal Error"},
         { CGI_TIME_OUT,    "No credential for cookie $"},      
         { ALL_DCRS_NOT_IDLE,    "All DCRs are NOT Idle"}      
    };
}

