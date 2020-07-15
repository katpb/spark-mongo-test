/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bhanu_a1
 */
enum RubyReport implements ReportDetails {

    SUMMARY("summary", FunctionRes.RUBYREPT_SUMMARY),
    DEPARTMENT("department", FunctionRes.RUBYREPT_DEPT),
    TAX("tax", FunctionRes.RUBYREPT_TAX),
    LOYALTY("loyalty", FunctionRes.RUBYREPT_LOYALTY),
    HOURLY("hourly", FunctionRes.RUBYREPT_HOURLY),
    NETWORK("network", FunctionRes.RUBYREPT_NETWORK),
    NETPROD("netProd", FunctionRes.RUBYREPT_NETPROD),
    ALLPROD("allProd", FunctionRes.RUBYREPT_ALLPROD),
    DEAL("deal", FunctionRes.RUBYREPT_DEAL),
    POPDISC("popDisc", FunctionRes.RUBYREPT_POPDISC),
    POPDEFN("popDef", FunctionRes.RUBYREPT_POPDEFN),
    POPPRGM("popdiscprgmrpt", FunctionRes.RUBYREPT_POPPRGM),
    PLU("plu", FunctionRes.RUBYREPT_PLU),
    PLUPROMO("pluPromo", FunctionRes.RUBYREPT_PLUPROMO),
    CATEGORY("category", FunctionRes.RUBYREPT_CATEGORY),
    DCRSTAT("dcrStat", FunctionRes.RUBYREPT_DCRSTAT),
    FPTEST("fpHoseTest", FunctionRes.RUBYREPT_FPTEST),
    FP("fpHose", FunctionRes.RUBYREPT_FP),
    FPRUN("fpHoseRunning", FunctionRes.RUBYREPT_FPRUN),
    PRODPLVL("prPriceLvl", FunctionRes.RUBYREPT_PRODPLVL),
    SLPLVL("slPriceLvl", FunctionRes.RUBYREPT_SLPLVL),
    FPDISPENSER("fpDispenser", FunctionRes.RUBYREPT_FPDISPENSER),
    TIERPROD("tierProduct", FunctionRes.RUBYREPT_TIERPROD),
    AUTOCOL("autoCollect", FunctionRes.RUBYREPT_AUTOCOL),
    CASHACCT("cashAcc", FunctionRes.RUBYREPT_CASHACCT),
    TANK("tank", FunctionRes.RUBYREPT_TANK),
    PROP_CARD("propCard", FunctionRes.RUBYREPT_PROP_CARD),
    PROP_PROD("propProd", FunctionRes.RUBYREPT_PROP_PROD),
    TANKMON("tankMonitor", FunctionRes.RUBYREPT_TANKMON),
    TANKREC("tankRec", FunctionRes.RUBYREPT_TANKREC),
    CARWASH("carWash", FunctionRes.RUBYREPT_CARWASH),
    MO_DEVICE("moneyOrderDev", FunctionRes.RUBYREPT_MO_DEVICE),
    PAYROLL("payroll", FunctionRes.RUBYREPT_PAYROLL),
    ECHECK("eCheck", FunctionRes.RUBYREPT_ECHECK),
    PREPAID_TOTALS("prepaidTotals", FunctionRes.RUBYREPT_PREPAID_TOTALS),
    CWPP("cwPaypoint", FunctionRes.RUBYREPT_CWPP),
    ESAFEEOD("esafeeod", FunctionRes.RUBYREPT_ESAFEEOD),
    ESAFECNT("esafecontent", FunctionRes.RUBYREPT_ESAFECNT),
    BLEND_PROD("blendProduct", FunctionRes.RUBYREPT_BLEND_PROD),
    DASHBOARD("dashboard", FunctionRes.RUBYREPT_DASHBOARD);
    
    private String reptname;
    private String descriptionKey;
    
    private static List<ReportDetails> coresvcsReports = new ArrayList<ReportDetails>(
    										Arrays.asList(SUMMARY, DEPARTMENT, TAX, LOYALTY,
    														HOURLY, NETWORK, NETPROD, ALLPROD,
    														DEAL, DEAL, POPDEFN, POPPRGM,
    														PLU, PLUPROMO, CATEGORY, PROP_CARD,
    														PROP_CARD, DASHBOARD));
    
    private static List<ReportDetails> fccReports = new ArrayList<ReportDetails>(
											Arrays.asList(DCRSTAT, FPTEST, FP, FPRUN,
															PRODPLVL, SLPLVL, FPDISPENSER, TIERPROD,
															AUTOCOL, CASHACCT, TANK, TANKMON,
															TANKREC, CARWASH, CWPP, BLEND_PROD));
    
    private static List<ReportDetails> stcReports = new ArrayList<ReportDetails>(
											Arrays.asList(MO_DEVICE, ECHECK, PREPAID_TOTALS, ESAFEEOD, ESAFECNT));
    
    private static List<ReportDetails> posReports = new ArrayList<ReportDetails>(Arrays.asList(PAYROLL));

    private RubyReport(String reptname, String descriptionKey) {
        this.reptname = reptname;
        this.descriptionKey = descriptionKey;
    }

    /**
     * @return the name
     */
    public String getName() {
        return reptname;
    }

    /**
     * @return the descriptionKey
     */
    public String getDescriptionKey() {
        return descriptionKey;
    }
    
    public static final List<ReportDetails> getCoresvcsReports() {
    	return coresvcsReports;
    }
    
    public static final List<ReportDetails> getFCCReports() {
    	return fccReports;
    }
    
    public static final List<ReportDetails> getSTCReports() {
    	return stcReports;
    }
    
    public static final List<ReportDetails> getPOSReports() {
    	return posReports;
    }
}
