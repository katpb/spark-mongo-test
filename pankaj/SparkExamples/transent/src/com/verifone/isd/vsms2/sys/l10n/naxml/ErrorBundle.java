/*
 * Project  : NAXML
 * File     : ErrorBundle.java
 * Version  : 3.0
 * Author   : Govarthanan
 * Copyright (c) VeriFone, Inc.
 * All rights reserved.
 */
package com.verifone.isd.vsms2.sys.l10n.naxml;

import java.util.ListResourceBundle;

/**
 * This is the Resource Bundle class Used for the VFI Exceptions
 */
public class ErrorBundle extends ListResourceBundle {

    public static String JAXBEXCEP = "JAXBEXCEP";
    public static String IOEXCEP = "IOEXCEP";

    public static String RECORDACTION_EXCEP = "RECORDACTION_EXCEP";
    public static String EMPTY_RECORDSET = "EMPTY_RECORDSET";

    public static String TAXRECEIPTDESCEXCEP = "TAXRECEIPTDESCEXCEP";
    public static String TAXSYMBOLEXCEP = "TAXSYMBOLEXCEP";
    public static String TAXRATEEXCEP = "TAXRATEEXCEP";
    public static String TAXNOTFOUNDEXCEP = "TAXNOTFOUNDEXCEP";
    public static String TAXLEVELINCLUDEDIDEXCEP = "TAXLEVELINCLUDEDIDEXCEP";
    public static String TAXSTRATEGYEXCEP = "TAXSTRATEGYEXCEP";

    public static String VFIPRODUCTCODEEXCP = "VFIPRODUCTCODEEXCP";
    public static String WEEKDAYAVAILABILTYEXCP = "WEEKDAYAVAILABILTYEXCP";
    public static String MINIMUMCUSTOMERAGEEXCP = "MINIMUMCUSTOMERAGEEXCP";
    public static String SECONDBLUELAWSTARTEXCP = "SECONDBLUELAWSTARTEXCP";
    public static String WEEKDAYSNUMBEREXCP = "WEEKDAYSNUMBEREXCP";
    public static String ORDERINGOFELEMENTSEXCP = "ORDERINGOFELEMENTSEXCP";
    public static String INVALITDATAEXCP = "INVALITDATAEXCP";
    public static String ITEMLISTMORE = "ITEMLISTMORE";
    public static String EITHEROFBLUELAWSDOESNOTEXIST
            = "EITHEROFBLUELAWSDOESNOTEXIST";
    public static String NOTALLWEEKDAYPRESENT = "NOTALLWEEKDAYPRESENT";
    public static String EXTENSION_SCHEMA_MISMATCH
            = "EXTENSION_SCHEMA_MISMATCH";
    public static String INVALIDCOMBOITEMLIST = "INVALIDCOMBOITEMLIST";
    public static String JAXBEXCEP2 = "JAXBEXCEP2";
	public static String ITEMLISTID = "ITEMLISTID";
	public static String ILTDETAILCOMMONERROR = "ILTDETAILCOMMONERROR";
	public static String POSCODEMCTCODEERROR = "POSCODEMCTCODEERROR";
	public static String PLUDEPTERROR = "PLUDEPTERROR";
	public static String INVALIDPRODUCTCODE = "INVALIDPRODUCTCODE";


    static final Object[][] contents = {

        {JAXBEXCEP, "Jaxb Exception"},
        {IOEXCEP, "IOException"},
        {RECORDACTION_EXCEP, "Unsupported RecordAction:{1}"},
        {EMPTY_RECORDSET, "Empty Recordset. No data available."},
        {TAXRECEIPTDESCEXCEP, "TaxReceiptDesccription is " +
            "Mandatory to set it to Name " +
            "of Tax Object"},
        {TAXSYMBOLEXCEP, "TaxSymbol is Mandatory to set it " +
            "to Indicator of Tax Object"},
        {TAXRATEEXCEP, "TaxRate is Mandatory to set it to " +
            "RatePercent of Tax Object"},
        {TAXNOTFOUNDEXCEP, "Unable to retrieve Tax for the key {1}"},
        {TAXLEVELINCLUDEDIDEXCEP, "TaxLevelIncludedID-{1} should be" +
            " less than TaxLevelID-{2} and " +
            "TaxLevelIncludedID shouldn't be zero "},
        {TAXSTRATEGYEXCEP, "Invalid Tax StrategyID-{1}"},
        {VFIPRODUCTCODEEXCP, "Unable to find VFI ProductCode for the " +
            "corresponding {1} from mapping file"},
        {WEEKDAYAVAILABILTYEXCP, "No:of weekday availibility elements" +
            " should be greater than or equal to 7 and" +
            " less than 28"},
        {MINIMUMCUSTOMERAGEEXCP, "The posted MinimumCustomerAge {1} did not " +
            "match the existing one"},
        {EITHEROFBLUELAWSDOESNOTEXIST, "No valid data available for " +
            "either BlueLaw1 or BlueLaw2"},
        {SECONDBLUELAWSTARTEXCP, "Second blue law does not start with Sunday"},
        {WEEKDAYSNUMBEREXCP, "Invalid number of weekdays for BlueLaw"},
        {ORDERINGOFELEMENTSEXCP, "Wrong ordering of " +
            "WeekdayAvailability elements"},
        {INVALITDATAEXCP, "Invalid data for the Day {1}"},
        {NOTALLWEEKDAYPRESENT, "Not all weekdays are present"},
        {EXTENSION_SCHEMA_MISMATCH,
         "Invalid instance according the NAXML Extension Schema. {1}"},
        {INVALIDCOMBOITEMLIST , "Invalid COMBOITEMLIST. {1}"},
        {JAXBEXCEP2, "JAXBException. {1}"},
        {ITEMLISTID, "ItemListID is Mandatory according to NAXML"},
        {ITEMLISTMORE, "ItemList can be only one set according to NAXML"},
        {ILTDETAILCOMMONERROR, "According to VFI it is mandatory that any one "+
        	"of POSCode or MerchandiseCode should be posted. The ILTDetails "+
        	"which violate this rule are {1} and a ILTDetail should not have "+
        	"been posted for both PromoItemListPLU & PromoItemListDepartment. "+
				"The ILTDetails which violate this rule are {2}"},
		{POSCODEMCTCODEERROR, "According to VFI a POSCode or MerchandiseCode " +
			"is Mandatory, The ILTDetails which violate this rule are {1}"},
		{PLUDEPTERROR, "According to VFI a ILTDetail should not have been " +
			"posted for both PromoItemListPLU & PromoItemListDepartment, " +
			"The ILTDetails which violate this rule are {1}"},
	    {INVALIDPRODUCTCODE, "PaymentSystemsProductCode should be numeric according to NAXML"}
    };

    /**
     * Returns a two dimensional object array with the messages
     * for VFI Exceptions
     */
    protected Object[][] getContents() {
        return contents;
    }
}
