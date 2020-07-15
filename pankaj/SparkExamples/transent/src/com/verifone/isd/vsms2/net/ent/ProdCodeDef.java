/*
 * Created on Aug 31, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.net.ent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.io.InputStream;

/**
 * @author Anindya_D1
 * 
 * Typesafe enumeration for product code values which differ from application to
 * application. This is a superset of all product codes across all applications.
 * This class will load the product values from a property file specific to the
 * application.
 */
public class ProdCodeDef implements java.io.Serializable {

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.ProdCodeDef.class);
	private static final long serialVersionUID = 2691097307396270080L;

	private transient int value;

	private transient String name;

	private static int UNDEFINED = -1;

	private static Properties prop = null;

	private transient boolean valid;

        static {
            String propFile = "ProdCodeDef.prop";
            prop = new Properties();
            
            InputStream inStream = null;
            // Read properties file.
            try {
                inStream = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
                prop.load(inStream);
            } catch (IOException e) {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.ProdCodeDef.class)
				        .error(
                        "Error loading ProdCodeDef.properties file:" + propFile + " " + e.getMessage());
            }
            finally {
                if (null != inStream) {
                    try {
                        inStream.close();
                    }
                    catch (IOException ioe) {}
                }
            }
        }
	/**
	 * Constructor to allow subclassing
	 * 
	 * @param name
	 *            Prodcode's name
	 */
	protected ProdCodeDef(String name) {
		String prodValue = prop.getProperty(name);

		if (prodValue != null && prodValue.length() > 0) {
			this.value = Integer.parseInt(prodValue.trim(), 10); // From properties file.
			this.valid = true;
		} else {
			this.value = UNDEFINED;
		}
		this.name = name;
	}
        
	/**
	 * Override toString() method to provide the ProdCodeDef's name
	 * 
	 * @return prodcode definition name
	 */
	public String toString() {
		return (this.name);
	}

	/**
	 * Getter for prodcode def value
	 * 
	 * @return prodcode def value
	 */
	public int getValue() {
		return this.value;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * This method returns a ProdCodeDef.object with a value matching the value
	 * parameter. Note: this is not the object at the ordinal position but the
	 * object containing a matching value.
	 * 
	 * @param value -
	 *            The value to match to the objects value property.
	 * @throws Exception
	 *             if a value match is not found.
	 * @return A ProdCodeDef object.
	 */
	public static ProdCodeDef getFromValue(int value) throws Exception {
		ProdCodeDef[] defs = ProdCodeDef.getObjects();
		for (int i = 0; i < defs.length; i++) {
			if (defs[i].value == value) {
				return (defs[i]);
			}
		}

		String msg = "ProdCode:" + value + " not found in ProdCodeDef data.";
		LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.ProdCodeDef.class).error( msg);
		throw new Exception(msg);
	}

	/**
	 * Prevent subclasses from overriding Object.hashCode() to ensure the
	 * following contract of typesafe enum: "All equal objects of the enumerated
	 * type are also identical i.e., a.equals(b) iff a==b". Thus, it is enough
	 * to do an == instead of the expensive Object.equals method
	 * 
	 * @return Value returned by super class's hashCode() method
	 */
	public final int hashCode() {
		return super.hashCode();
	}

	/**
	 * Prevent subclasses from overriding Object.equals to ensure the following
	 * contract of typesafe enum: "All equal objects of the enumerated type are
	 * also identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an ==
	 * instead of the expensive Object.equals method
	 * 
	 * @param obj
	 *            Object to be compared for equality
	 * @return true if the compared instance satisfies == test
	 */
	public final boolean equals(Object obj) {
		return super.equals(obj);
	}

	public static ProdCodeDef FUELPCODE = new ProdCodeDef("FUELPCODE");

	public static ProdCodeDef KEROPCODE = new ProdCodeDef("KEROPCODE");

	public static ProdCodeDef DSLPCODE = new ProdCodeDef("DSLPCODE");

	public static ProdCodeDef MDSEPCODE = new ProdCodeDef("MDSEPCODE");

	public static ProdCodeDef BATTACCPCODE = new ProdCodeDef("BATTACCPCODE");

	public static ProdCodeDef LABORPCODE = new ProdCodeDef("LABORPCODE");

	public static ProdCodeDef TIRESPCODE = new ProdCodeDef("TIRESPCODE");

	public static ProdCodeDef OILPCODE = new ProdCodeDef("OILPCODE");

	public static ProdCodeDef LUBEPCODE = new ProdCodeDef("LUBEPCODE");

	public static ProdCodeDef COUPONPCODE = new ProdCodeDef("COUPONPCODE");

	public static ProdCodeDef CNGPCODE = new ProdCodeDef("CNGPCODE");

	public static ProdCodeDef TAXPCODE = new ProdCodeDef("TAXPCODE");

	public static ProdCodeDef WASHPCODE = new ProdCodeDef("WASHPCODE");

	public static ProdCodeDef TOWPCODE = new ProdCodeDef("TOWPCODE");

	public static ProdCodeDef REPAIRPCODE = new ProdCodeDef("REPAIRPCODE");

	public static ProdCodeDef AUTOPARTSPCODE = new ProdCodeDef("AUTOPARTSPCODE");

	public static ProdCodeDef AUTOMDSEPCODE = new ProdCodeDef("AUTOMDSEPCODE");

	public static ProdCodeDef DSLFSPCODE = new ProdCodeDef("DSLFSPCODE");

	public static ProdCodeDef CIGSPCODE = new ProdCodeDef("CIGSPCODE");

	public static ProdCodeDef TOBACCOPCODE = new ProdCodeDef("TOBACCOPCODE");

	public static ProdCodeDef BEERPCODE = new ProdCodeDef("BEERPCODE");

	public static ProdCodeDef WINEPCODE = new ProdCodeDef("WINEPCODE");

	public static ProdCodeDef LIQOURPCODE = new ProdCodeDef("LIQOURPCODE");

	public static ProdCodeDef PREPAIDPCODE = new ProdCodeDef("PREPAIDPCODE");

	public static ProdCodeDef ANTIFREZPCODE = new ProdCodeDef("ANTIFREZPCODE");

	public static ProdCodeDef FUELADJPOS = new ProdCodeDef("FUELADJPOS");

	public static ProdCodeDef FUELADJNEG = new ProdCodeDef("FUELADJNEG");

	public static ProdCodeDef UNLEADEDFUELPCODE = new ProdCodeDef(
			"UNLEADEDFUELPCODE");

	public static ProdCodeDef POWERPLUSFUELPCODE = new ProdCodeDef(
			"POWERPLUSFUELPCODE");

	public static ProdCodeDef REGULARFUELPCODE = new ProdCodeDef(
			"REGULARFUELPCODE");

	public static ProdCodeDef POWERPREMIUMFUEPCODE = new ProdCodeDef(
			"POWERPREMIUMFUEPCODE");

	public static ProdCodeDef AVGASFUELPCODE = new ProdCodeDef("AVGASFUELPCODE");

	public static ProdCodeDef AVGETFUELPCODE = new ProdCodeDef("AVGETFUELPCODE");

	public static ProdCodeDef MARINEFUELPCODE = new ProdCodeDef(
			"MARINEFUELPCODE");

	public static ProdCodeDef MANUALFUELPCODE = new ProdCodeDef(
			"MANUALFUELPCODE");

	public static ProdCodeDef BEERWINEPCODE = new ProdCodeDef("BEERWINEPCODE");

	public static ProdCodeDef GROCERYPCODE = new ProdCodeDef("GROCERYPCODE");

	public static ProdCodeDef OILCHANGESPCODE = new ProdCodeDef(
			"OILCHANGESPCODE");

	public static ProdCodeDef OILFILTERSPCODE = new ProdCodeDef(
			"OILFILTERSPCODE");

	public static ProdCodeDef AUTOINSPECTIONPCODE = new ProdCodeDef(
			"AUTOINSPECTIONPCODE");

	public static ProdCodeDef WORKORDERPCODE = new ProdCodeDef("WORKORDERPCODE");

	public static ProdCodeDef QSRPCODE = new ProdCodeDef("QSRPCODE");

	public static ProdCodeDef PREMIUMDIESELPCODE = new ProdCodeDef(
			"PREMIUMDIESELPCODE");

	public static ProdCodeDef OFFROADDIESELPCODE = new ProdCodeDef(
			"OFFROADDIESELPCODE");

	public static ProdCodeDef MISCNONTAXPCODE = new ProdCodeDef(
			"MISCNONTAXPCODE");

	public static ProdCodeDef MONEYORDERPCODE = new ProdCodeDef(
			"MONEYORDERPCODE");

	public static ProdCodeDef MONEYORDERFEEPCODE = new ProdCodeDef(
			"MONEYORDERFEEPCODE");

	public static ProdCodeDef LOTTERYPCODE = new ProdCodeDef("LOTTERYPCODE");

	public static ProdCodeDef UN_ETHANOL5_7PCODE = new ProdCodeDef(
			"UN_ETHANOL5_7PCODE");

	public static ProdCodeDef MID_ETHANOL5_7PCODE = new ProdCodeDef(
			"MID_ETHANOL5_7PCODE");

	public static ProdCodeDef PRE_ETHANOL5_7PCODE = new ProdCodeDef(
			"PRE_ETHANOL5_7PCODE");

	public static ProdCodeDef UN_ETHANOL7_7PCODE = new ProdCodeDef(
			"UN_ETHANOL7_7PCODE");

	public static ProdCodeDef MID_ETHANOL7_7PCODE = new ProdCodeDef(
			"MID_ETHANOL7_7PCODE");

	public static ProdCodeDef PRE_ETHANOL7_7PCODE = new ProdCodeDef(
			"PRE_ETHANOL7_7PCODE");

	public static ProdCodeDef UN_ETHANOL10PCODE = new ProdCodeDef(
			"UN_ETHANOL10PCODE");

	public static ProdCodeDef MID_ETHANOL10PCODE = new ProdCodeDef(
			"MID_ETHANOL10PCODE");

	public static ProdCodeDef PRE_ETHANOL10PCODE = new ProdCodeDef(
			"PRE_ETHANOL10PCODE");

	public static ProdCodeDef HYDROGENPCODE = new ProdCodeDef("HYDROGENPCODE");

	public static ProdCodeDef OTHERTENDERPCODE = new ProdCodeDef(
			"OTHERTENDERPCODE");

	public static ProdCodeDef NETDISCOUNTPCODE = new ProdCodeDef(
			"NETDISCOUNTPCODE");
	
	public static ProdCodeDef PTAXPCODE = new ProdCodeDef("PTAXPCODE");

	public static ProdCodeDef PCASHPCODE = new ProdCodeDef("PCASHPCODE");

	public static ProdCodeDef PACCTPCODE = new ProdCodeDef("PACCTPCODE");
	
	public static ProdCodeDef NTAXPCODE = new ProdCodeDef("NTAXPCODE");

	public static ProdCodeDef NDISCPCODE = new ProdCodeDef("NDISCPCODE");

	public static ProdCodeDef NCASHPCODE = new ProdCodeDef("NCASHPCODE");

	public static ProdCodeDef NACCTPCODE = new ProdCodeDef("NACCTPCODE");
	
	public static ProdCodeDef NCHECKPCODE = new ProdCodeDef("NCHECKPCODE");

	public static ProdCodeDef NFOODSTAMPPCODE = new ProdCodeDef(
			"NFOODSTAMPPCODE");

	public static ProdCodeDef PCASHBACKPCODE = new ProdCodeDef("PCASHBACKPCODE");

	public static ProdCodeDef POTHERTENDERPCODE = new ProdCodeDef(
			"POTHERTENDERPCODE");

	public static ProdCodeDef NOTHERTENDERPCODE = new ProdCodeDef(
			"NOTHERTENDERPCODE");

	public static ProdCodeDef NCASHBACKPCODE = new ProdCodeDef("NCASHBACKPCODE");

	public static ProdCodeDef PREM1PCODE = new ProdCodeDef("PREM1PCODE");
	public static ProdCodeDef REGFSPCODE = new ProdCodeDef("REGFSPCODE");
	public static ProdCodeDef UNLFSPCODE = new ProdCodeDef("UNLFSPCODE");
	public static ProdCodeDef PREM1FSPCODE = new ProdCodeDef("PREM1FSPCODE");
	public static ProdCodeDef MID1PCODE = new ProdCodeDef("MID1PCODE");
	public static ProdCodeDef MID1FSPCODE = new ProdCodeDef("MID1FSPCODE");
	public static ProdCodeDef MID2PCODE = new ProdCodeDef("MID2PCODE");
	public static ProdCodeDef MID2FSPCODE = new ProdCodeDef("MID2FSPCODE");
	public static ProdCodeDef MID3PCODE = new ProdCodeDef("MID3PCODE");
	public static ProdCodeDef MID3FSPCODE = new ProdCodeDef("MID3FSPCODE");
	public static ProdCodeDef PREM2PCODE = new ProdCodeDef("PREM2PCODE");
	public static ProdCodeDef PREM2FSPCODE = new ProdCodeDef("PREM2FSPCODE");
	public static ProdCodeDef DSL2PCODE = new ProdCodeDef("DSL2PCODE");
	public static ProdCodeDef DSL2FSPCODE = new ProdCodeDef("DSL2FSPCODE");
	public static ProdCodeDef GASOHOLPCODE = new ProdCodeDef("GASOHOLPCODE");
	public static ProdCodeDef DISCOUNTPCODE = new ProdCodeDef("DISCOUNTPCODE");
	public static ProdCodeDef ETHANOLPCODE = new ProdCodeDef("ETHANOLPCODE");
	public static ProdCodeDef E85PCODE = new ProdCodeDef("E85PCODE");
	public static ProdCodeDef MISCSERVPCODE = new ProdCodeDef("MISCSERVPCODE");
	public static ProdCodeDef ETHANOLFSPCODE = new ProdCodeDef("ETHANOLFSPCODE");
	public static ProdCodeDef ETHANOL2PCODE = new ProdCodeDef("ETHANOL2PCODE");
	public static ProdCodeDef ETHANOL2FSPCODE = new ProdCodeDef("ETHANOL2FSPCODE");
	public static ProdCodeDef ETHANOL3PCODE = new ProdCodeDef("ETHANOL3PCODE");
	public static ProdCodeDef ETHANOL3FSPCODE = new ProdCodeDef("ETHANOL3FSPCODE");
	public static ProdCodeDef GASOHOLFSPCODE = new ProdCodeDef("GASOHOLFSPCODE");
	public static ProdCodeDef GASOHOL2PCODE = new ProdCodeDef("GASOHOL2PCODE");
	public static ProdCodeDef GASOHOL2FSPCODE = new ProdCodeDef("GASOHOL2FSPCODE");
	public static ProdCodeDef GASOHOL3PCODE = new ProdCodeDef("GASOHOL3PCODE");
	public static ProdCodeDef GASOHOL3FSPCODE = new ProdCodeDef("GASOHOL3FSPCODE");
	public static ProdCodeDef PREPFOODPCODE = new ProdCodeDef("PREPFOODPCODE");
	public static ProdCodeDef RESTAURANTPCODE = new ProdCodeDef("RESTAURANTPCODE");
	public static ProdCodeDef MILKPCODE = new ProdCodeDef("MILKPCODE");
	public static ProdCodeDef BEVERAGEPCODE = new ProdCodeDef("BEVERAGEPCODE");
	public static ProdCodeDef TOBACCOOUTLETPCODE = new ProdCodeDef("TOBACCOOUTLETPCODE");
	public static ProdCodeDef PREPFOODCOSTPCODE = new ProdCodeDef("PREPFOODCOSTPCODE");
	public static ProdCodeDef UN_ETHANOL5_7FSPCODE = new ProdCodeDef("UN_ETHANOL5_7FSPCODE");
	public static ProdCodeDef MID_ETHANOL5_7FSPCODE = new ProdCodeDef("MID_ETHANOL5_7FSPCODE");
	public static ProdCodeDef PRE_ETHANOL5_7FSPCODE = new ProdCodeDef("PRE_ETHANOL5_7FSPCODE");
	public static ProdCodeDef UN_ETHANOL7_7FSPCODE = new ProdCodeDef("UN_ETHANOL7_7FSPCODE");
	public static ProdCodeDef MID_ETHANOL7_7FSPCODE = new ProdCodeDef("MID_ETHANOL7_7FSPCODE");
	public static ProdCodeDef PRE_ETHANOL7_7FSPCODE = new ProdCodeDef("PRE_ETHANOL7_7FSPCODE");
	public static ProdCodeDef UN_ETHANOL10FSPCODE = new ProdCodeDef("UN_ETHANOL10FSPCODE");
	public static ProdCodeDef MID_ETHANOL10FSPCODE = new ProdCodeDef("MID_ETHANOL10FSPCODE");
	public static ProdCodeDef PRE_ETHANOL10FSPCODE = new ProdCodeDef("PRE_ETHANOL10FSPCODE");
	public static ProdCodeDef FARMDSLPCODE = new ProdCodeDef("FARMDSLPCODE");
	public static ProdCodeDef PROPANEPCODE = new ProdCodeDef("PROPANEPCODE");
	public static ProdCodeDef NONFARMDSLPCODE = new ProdCodeDef("NONFARMDSLPCODE");
	public static ProdCodeDef TRUCKSCALEPCODE = new ProdCodeDef("TRUCKSCALEPCODE");
	public static ProdCodeDef ADDITIONALPCODE = new ProdCodeDef("ADDITIONALPCODE");
	public static ProdCodeDef DYEDDSLPCODE = new ProdCodeDef("DYEDDSLPCODE");
	public static ProdCodeDef LOWSULFBIOPCODE = new ProdCodeDef("LOWSULFBIOPCODE");

// NACs Product codes added for exxonmobil

	public static ProdCodeDef UNLEADED1PCODE = new ProdCodeDef("UNLEADED1PCODE");
	public static ProdCodeDef UNLEADED2PCODE = new ProdCodeDef("UNLEADED2PCODE");
	public static ProdCodeDef UNLEADED3PCODE = new ProdCodeDef("UNLEADED3PCODE");
	public static ProdCodeDef UNLEADED4PCODE = new ProdCodeDef("UNLEADED4PCODE");
	public static ProdCodeDef UNLEADED5PCODE = new ProdCodeDef("UNLEADED5PCODE");
	public static ProdCodeDef METHANOL57PCODE = new ProdCodeDef("METHANOL57PCODE");
	public static ProdCodeDef PLUSMETH57PCODE = new ProdCodeDef("PLUSMETH57PCODE");
	public static ProdCodeDef SUPERMETH57PCODE = new ProdCodeDef("SUPERMETH57PCODE");
	public static ProdCodeDef METHANOL77PCODE = new ProdCodeDef("METHANOL77PCODE");
	public static ProdCodeDef PLUSMETH77PCODE = new ProdCodeDef("PLUSMETH77PCODE");
	public static ProdCodeDef ETHANOL57PCODE = new ProdCodeDef("ETHANOL57PCODE");
	public static ProdCodeDef PLUSETHANOL57PCODE = new ProdCodeDef("PLUSETHANOL57PCODE");
	public static ProdCodeDef SUPERETHANOL57PCODE = new ProdCodeDef("SUPERETHANOL57PCODE");
	public static ProdCodeDef ETHANOL77PCODE = new ProdCodeDef("ETHANOL77PCODE");
	public static ProdCodeDef PLUSETHANOL77PCODE = new ProdCodeDef("PLUSETHANOL77PCODE");
	public static ProdCodeDef METHANOLLEADEDPCODE = new ProdCodeDef("METHANOLLEADEDPCODE");
	public static ProdCodeDef ETHANOLLEADEDPCODE = new ProdCodeDef("ETHANOLLEADEDPCODE");
	public static ProdCodeDef LEADEDPCODE = new ProdCodeDef("LEADEDPCODE");
	public static ProdCodeDef DIESEL1PCODE = new ProdCodeDef("DIESEL1PCODE");
	public static ProdCodeDef DIESEL2PCODE = new ProdCodeDef("DIESEL2PCODE");
	public static ProdCodeDef DIESEL3PCODE = new ProdCodeDef("DIESEL3PCODE");
	public static ProdCodeDef CNGFUELPCODE = new ProdCodeDef("CNGFUELPCODE");
	public static ProdCodeDef LPGFUELPCODE = new ProdCodeDef("LPGFUELPCODE");
	public static ProdCodeDef LNGFUELPCODE = new ProdCodeDef("LNGFUELPCODE");
	public static ProdCodeDef M85FUELPCODE = new ProdCodeDef("M85FUELPCODE");
	public static ProdCodeDef E85FUELPCODE = new ProdCodeDef("E85FUELPCODE");
	public static ProdCodeDef REFORM1FUELPCODE = new ProdCodeDef("REFORM1FUELPCODE");
	public static ProdCodeDef REFORM2FUELPCODE = new ProdCodeDef("REFORM2FUELPCODE");
	public static ProdCodeDef REFORM3FUELPCODE = new ProdCodeDef("REFORM3FUELPCODE");
	public static ProdCodeDef REFORM4FUELPCODE = new ProdCodeDef("REFORM4FUELPCODE");
	public static ProdCodeDef REFORM5FUELPCODE = new ProdCodeDef("REFORM5FUELPCODE");
	public static ProdCodeDef DIESEL1NOTAXPCODE = new ProdCodeDef("DIESEL1NOTAXPCODE");
	public static ProdCodeDef DIESEL2NOTAXPCODE = new ProdCodeDef("DIESEL2NOTAXPCODE");
	public static ProdCodeDef DIESEL3NOTAXPCODE = new ProdCodeDef("DIESEL3NOTAXPCODE");
	public static ProdCodeDef OTHERFUELNOTAXPCODE = new ProdCodeDef("OTHERFUELNOTAXPCODE");
	public static ProdCodeDef RACINGFUELPCODE = new ProdCodeDef("RACINGFUELPCODE");
	public static ProdCodeDef SUPERMETH77PCODE = new ProdCodeDef("SUPERMETH77PCODE");
	public static ProdCodeDef METHANOL100PCODE = new ProdCodeDef("METHANOL100PCODE");
	public static ProdCodeDef PLUSMETH100PCODE = new ProdCodeDef("PLUSMETH100PCODE");
	public static ProdCodeDef SUPERMETH100PCODE = new ProdCodeDef("SUPERMETH100PCODE");
	public static ProdCodeDef SUPERETHANOL77PCODE = new ProdCodeDef("SUPERETHANOL77PCODE");
	public static ProdCodeDef ETHAN0L100PCODE = new ProdCodeDef("ETHAN0L100PCODE");
	public static ProdCodeDef PLUSETHANOL100PCODE = new ProdCodeDef("PLUSETHANOL100PCODE");
	public static ProdCodeDef SUPERETHANOL100PCODE = new ProdCodeDef("SUPERETHANOL100PCODE");
	public static ProdCodeDef MISCFUELPCODE = new ProdCodeDef("MISCFUELPCODE");
//	public static ProdCodeDef AUTOMDSEPCODE = new ProdCodeDef("AUTOMDSEPCODE");
	public static ProdCodeDef MOTOROILPCODE = new ProdCodeDef("MOTOROILPCODE");
	public static ProdCodeDef CARWASHPCODE = new ProdCodeDef("CARWASHPCODE");
//	public static ProdCodeDef OILCHANGESPCODE = new ProdCodeDef("OILCHANGESPCODE");
//	public static ProdCodeDef OILFILTERSPCODE = new ProdCodeDef("OILFILTERSPCODE");
//	public static ProdCodeDef WORKORDERPCODE = new ProdCodeDef("WORKORDERPCODE");
//	public static ProdCodeDef ANTIFREZPCODE = new ProdCodeDef("ANTIFREEZEPCODE");
	public static ProdCodeDef WASHERFLUIDPCODE = new ProdCodeDef("WASHERFLUIDPCODE");
	public static ProdCodeDef BRAKEFLUIDPCODE = new ProdCodeDef("BRAKEFLUIDPCODE");
//	public static ProdCodeDef TIRESPCODE = new ProdCodeDef("TIRESPCODE");
	public static ProdCodeDef TIREEXCISETAXPCODE = new ProdCodeDef("TIREEXCISETAXPCODE");
	public static ProdCodeDef TIREROTATIONPCODE = new ProdCodeDef("TIREROTATIONPCODE");
	public static ProdCodeDef BATTERIESPCODE = new ProdCodeDef("BATTERIESPCODE");
//	public static ProdCodeDef LUBEPCODE = new ProdCodeDef("LUBEPCODE");
//	public static ProdCodeDef AUTOINSPECTIONPCODE = new ProdCodeDef("AUTOINSPECTIONPCODE");
//	public static ProdCodeDef LABORPCODE = new ProdCodeDef("LABORPCODE");
//	public static ProdCodeDef TOWPCODE = new ProdCodeDef("TOWPCODE");
	public static ProdCodeDef ROADSERVICEPCODE = new ProdCodeDef("ROADSERVICEPCODE");
	public static ProdCodeDef AUTOACCESSORIESPCODE = new ProdCodeDef("AUTOACCESSORIESPCODE");
//	public static ProdCodeDef AUTOPARTSPCODE = new ProdCodeDef("AUTOPARTSPCODE");
	public static ProdCodeDef PREVENTMAINTPCODE = new ProdCodeDef("PREVENTMAINTPCODE");
	public static ProdCodeDef ACSERVICEPCODE = new ProdCodeDef("ACSERVICEPCODE");
	public static ProdCodeDef ENGINESERVICEPCODE = new ProdCodeDef("ENGINESERVICEPCODE");
	public static ProdCodeDef TRANSMSERVICEPCODE = new ProdCodeDef("TRANSMSERVICEPCODE");
	public static ProdCodeDef BRAKESERVICEPCODE = new ProdCodeDef("BRAKESERVICEPCODE");
	public static ProdCodeDef EXHAUSTSERVICEPCODE = new ProdCodeDef("EXHAUSTSERVICEPCODE");
	public static ProdCodeDef BODYWORKPCODE = new ProdCodeDef("BODYWORKPCODE");
	public static ProdCodeDef AUTOGLASSPCODE = new ProdCodeDef("AUTOGLASSPCODE");
	public static ProdCodeDef SYNTHETICOILPCODE = new ProdCodeDef("SYNTHETICOILPCODE");
	public static ProdCodeDef LAMPSPCODE = new ProdCodeDef("LAMPSPCODE");
	public static ProdCodeDef WIPERSPCODE = new ProdCodeDef("WIPERSPCODE");
	public static ProdCodeDef HOSESPCODE = new ProdCodeDef("HOSESPCODE");
	public static ProdCodeDef TIRERELATEDPCODE = new ProdCodeDef("TIRERELATEDPCODE");
//	public static ProdCodeDef REPAIRPCODE = new ProdCodeDef("REPAIRPCODE");
	public static ProdCodeDef SERVICEPKGPCODE = new ProdCodeDef("SERVICEPKGPCODE");
	public static ProdCodeDef AUTOPARKINGPCODE = new ProdCodeDef("AUTOPARKINGPCODE");
	public static ProdCodeDef TRUCKTANKCLEANPCODE = new ProdCodeDef("TRUCKTANKCLEANPCODE");
	public static ProdCodeDef OTHERLUBEPCODE = new ProdCodeDef("OTHERLUBEPCODE");
	public static ProdCodeDef MISCPARTSSERVICEPCODE = new ProdCodeDef("MISCPARTSSERVICEPCODE");
	public static ProdCodeDef JETFUELPCODE = new ProdCodeDef("JETFUELPCODE");
	public static ProdCodeDef AVIATIONFUEL1PCODE = new ProdCodeDef("AVIATIONFUEL1PCODE");
	public static ProdCodeDef AVIATIONFUEL2PCODE = new ProdCodeDef("AVIATIONFUEL2PCODE");
	public static ProdCodeDef AVIATIONFUEL3PCODE = new ProdCodeDef("AVIATIONFUEL3PCODE");
	public static ProdCodeDef AVIATIONFUEL4PCODE = new ProdCodeDef("AVIATIONFUEL4PCODE");
	public static ProdCodeDef AVIATIONFUEL5PCODE = new ProdCodeDef("AVIATIONFUEL5PCODE");
	public static ProdCodeDef MISCAVIATIONFUELPCODE = new ProdCodeDef("MISCAVIATIONFUELPCODE");
	public static ProdCodeDef AVSTORAGEPCODE = new ProdCodeDef("AVSTORAGEPCODE");
	public static ProdCodeDef AVGROUNDHANDLINGPCODE = new ProdCodeDef("AVGROUNDHANDLINGPCODE");
	public static ProdCodeDef AVGROUNDPOWERUNITPCODE = new ProdCodeDef("AVGROUNDPOWERUNITPCODE");
	public static ProdCodeDef AVLABORPCODE = new ProdCodeDef("AVLABORPCODE");
	public static ProdCodeDef AVWORKORDERPCODE = new ProdCodeDef("AVWORKORDERPCODE");
	public static ProdCodeDef AVMAINTENANCEPCODE = new ProdCodeDef("AVMAINTENANCEPCODE");
	public static ProdCodeDef AVSERVICEPCODE = new ProdCodeDef("AVSERVICEPCODE");
	public static ProdCodeDef AVTRANSPORTPCODE = new ProdCodeDef("AVTRANSPORTPCODE");
	public static ProdCodeDef AVDEICINGPCODE = new ProdCodeDef("AVDEICINGPCODE");
	public static ProdCodeDef AVRAMPFEESPCODE = new ProdCodeDef("AVRAMPFEESPCODE");
	public static ProdCodeDef AVCATERINGPCODE = new ProdCodeDef("AVCATERINGPCODE");
	public static ProdCodeDef AVHANGERFEEPCODE = new ProdCodeDef("AVHANGERFEEPCODE");
	public static ProdCodeDef AVLANDINGFEEPCODE = new ProdCodeDef("AVLANDINGFEEPCODE");
	public static ProdCodeDef AVCALLOUTFEEPCODE = new ProdCodeDef("AVCALLOUTFEEPCODE");
	public static ProdCodeDef AVRENTALPCODE = new ProdCodeDef("AVRENTALPCODE");
	public static ProdCodeDef AVINSTRUCTIONFEEPCODE = new ProdCodeDef("AVINSTRUCTIONFEEPCODE");
	public static ProdCodeDef AVFLIGHTPLANPCODE = new ProdCodeDef("AVFLIGHTPLANPCODE");
	public static ProdCodeDef AVCHARTERFEEPCODE = new ProdCodeDef("AVCHARTERFEEPCODE");
	public static ProdCodeDef AVCOMMUNICATIONPCODE = new ProdCodeDef("AVCOMMUNICATIONPCODE");
	public static ProdCodeDef AVCLEANINGPCODE = new ProdCodeDef("AVCLEANINGPCODE");
	public static ProdCodeDef AVCARGOHANDLINGPCODE = new ProdCodeDef("AVCARGOHANDLINGPCODE");
	public static ProdCodeDef AVACCESSORIESPCODE = new ProdCodeDef("AVACCESSORIESPCODE");
	public static ProdCodeDef AVPILOTSUPPLIESPCODE = new ProdCodeDef("AVPILOTSUPPLIESPCODE");
	public static ProdCodeDef AVPARKINGFEESPCODE = new ProdCodeDef("AVPARKINGFEESPCODE");
	public static ProdCodeDef AVTIEDOWNFEESPCODE = new ProdCodeDef("AVTIEDOWNFEESPCODE");
	public static ProdCodeDef AVSANITATIONFEESPCODE = new ProdCodeDef("AVSANITATIONFEESPCODE");
	public static ProdCodeDef AVFUELADDITIVEFEESPCODE = new ProdCodeDef("AVFUELADDITIVEFEESPCODE");
	public static ProdCodeDef MISCAVIATIONPCODE = new ProdCodeDef("MISCAVIATIONPCODE");
	public static ProdCodeDef MARINEFUEL1PCODE = new ProdCodeDef("MARINEFUEL1PCODE");
	public static ProdCodeDef MARINEFUEL2PCODE = new ProdCodeDef("MARINEFUEL2PCODE");
	public static ProdCodeDef MARINEFUEL3PCODE = new ProdCodeDef("MARINEFUEL3PCODE");
	public static ProdCodeDef MARINEFUEL4PCODE = new ProdCodeDef("MARINEFUEL4PCODE");
	public static ProdCodeDef MARINEFUEL5PCODE = new ProdCodeDef("MARINEFUEL5PCODE");
	public static ProdCodeDef MARINEOTHERPCODE = new ProdCodeDef("MARINEOTHERPCODE");
	public static ProdCodeDef MISCMARINEFUELPCODE = new ProdCodeDef("MISCMARINEFUELPCODE");
	public static ProdCodeDef MARINESERVICEPCODE = new ProdCodeDef("MARINESERVICEPCODE");
	public static ProdCodeDef MARINELABORPCODE = new ProdCodeDef("MARINELABORPCODE");
	public static ProdCodeDef MARINEWORKORDERPCODE = new ProdCodeDef("MARINEWORKORDERPCODE");
	public static ProdCodeDef LAUNCHFEEPCODE = new ProdCodeDef("LAUNCHFEEPCODE");
	public static ProdCodeDef SLIPRENTALPCODE = new ProdCodeDef("SLIPRENTALPCODE");
	public static ProdCodeDef MISCMARINESERVICEPCODE = new ProdCodeDef("MISCMARINESERVICEPCODE");
	public static ProdCodeDef KEROSENEPCODE = new ProdCodeDef("KEROSENEPCODE");
	public static ProdCodeDef WHITEGASPCODE = new ProdCodeDef("WHITEGASPCODE");
	public static ProdCodeDef HEATINGOILPCODE = new ProdCodeDef("HEATINGOILPCODE");
	public static ProdCodeDef BOTTLEDPROPPCODE = new ProdCodeDef("BOTTLEDPROPPCODE");
	public static ProdCodeDef OTHERFUELPCODE = new ProdCodeDef("OTHERFUELPCODE");
	public static ProdCodeDef MISCOTHERFUELPCODE = new ProdCodeDef("MISCOTHERFUELPCODE");
	public static ProdCodeDef MERCHANDISEPCODE = new ProdCodeDef("MERCHANDISEPCODE");
	public static ProdCodeDef ICEPCODE = new ProdCodeDef("ICEPCODE");
//	public static ProdCodeDef TOBACCOPCODE = new ProdCodeDef("TOBACCOPCODE");
//	public static ProdCodeDef CIGSPCODE = new ProdCodeDef("CIGSPCODE");
	public static ProdCodeDef TOBACCOOTHERPCODE = new ProdCodeDef("TOBACCOOTHERPCODE");
	public static ProdCodeDef GENPACKAGEDBEVPCODE = new ProdCodeDef("GENPACKAGEDBEVPCODE");
	public static ProdCodeDef PACKAGEDBEVPCODE = new ProdCodeDef("PACKAGEDBEVPCODE");
	public static ProdCodeDef JUICEPCODE = new ProdCodeDef("JUICEPCODE");
	public static ProdCodeDef OTHERPACKBEVPCODE = new ProdCodeDef("OTHERPACKBEVPCODE");
	public static ProdCodeDef DISPENSEDBEVPCODE = new ProdCodeDef("DISPENSEDBEVPCODE");
	public static ProdCodeDef HOTDISPBEVPCODE = new ProdCodeDef("HOTDISPBEVPCODE");
	public static ProdCodeDef COLDDISPBEVPCODE = new ProdCodeDef("COLDDISPBEVPCODE");
	public static ProdCodeDef FROZENDISPBEVPCODE = new ProdCodeDef("FROZENDISPBEVPCODE");
	public static ProdCodeDef OTHERDISPBEVPCODE = new ProdCodeDef("OTHERDISPBEVPCODE");
	public static ProdCodeDef SNACKSPCODE = new ProdCodeDef("SNACKSPCODE");
	public static ProdCodeDef SALTYSNACKSPCODE = new ProdCodeDef("SALTYSNACKSPCODE");
	public static ProdCodeDef ALTSNACKSPCODE = new ProdCodeDef("ALTSNACKSPCODE");
	public static ProdCodeDef SWEETSNACKSPCODE = new ProdCodeDef("SWEETSNACKSPCODE");
	public static ProdCodeDef CANDYPCODE = new ProdCodeDef("CANDYPCODE");
	public static ProdCodeDef DAIRYPCODE = new ProdCodeDef("DAIRYPCODE");
//	public static ProdCodeDef MILKPCODE = new ProdCodeDef("MILKPCODE");
	public static ProdCodeDef PACKAGEDICECREAMPCODE = new ProdCodeDef("PACKAGEDICECREAMPCODE");
	public static ProdCodeDef OTHERDAIRYPCODE = new ProdCodeDef("OTHERDAIRYPCODE");
//	public static ProdCodeDef GROCERYPCODE = new ProdCodeDef("GROCERYPCODE");
	public static ProdCodeDef GROCERYEDIBLEPCODE = new ProdCodeDef("GROCERYEDIBLEPCODE");
	public static ProdCodeDef GROCERYNONEDIBLEPCODE = new ProdCodeDef("GROCERYNONEDIBLEPCODE");
	public static ProdCodeDef GROCERYPERISHABLEPCODE = new ProdCodeDef("GROCERYPERISHABLEPCODE");
	public static ProdCodeDef BREADPACKAGEDPCODE = new ProdCodeDef("BREADPACKAGEDPCODE");
	public static ProdCodeDef FROZENFOODSPCODE = new ProdCodeDef("FROZENFOODSPCODE");
	public static ProdCodeDef ALCOHOLPCODE = new ProdCodeDef("ALCOHOLPCODE");
//	public static ProdCodeDef BEERPCODE = new ProdCodeDef("BEERPCODE");
	public static ProdCodeDef BEERNONALCOHOLPCODE = new ProdCodeDef("BEERNONALCOHOLPCODE");
//	public static ProdCodeDef WINEPCODE = new ProdCodeDef("WINEPCODE");
//	public static ProdCodeDef LIQUORPCODE = new ProdCodeDef("LIQUORPCODE");
	public static ProdCodeDef DELIPCODE = new ProdCodeDef("DELIPCODE");
	public static ProdCodeDef PACKAGEDSANDWICHPCODE = new ProdCodeDef("PACKAGEDSANDWICHPCODE");
	public static ProdCodeDef PREPAREDFOODSPCODE = new ProdCodeDef("PREPAREDFOODSPCODE");
	public static ProdCodeDef DELIITEMSPCODE = new ProdCodeDef("DELIITEMSPCODE");
	public static ProdCodeDef FOODSERVICEPCODE = new ProdCodeDef("FOODSERVICEPCODE");
//	public static ProdCodeDef LOTTERYPCODE = new ProdCodeDef("LOTTERYPCODE");
	public static ProdCodeDef LOTTERYINSTANTPCODE = new ProdCodeDef("LOTTERYINSTANTPCODE");
	public static ProdCodeDef LOTTYERYONLINEPCODE = new ProdCodeDef("LOTTYERYONLINEPCODE");
	public static ProdCodeDef LOTTERYOTHERPCODE = new ProdCodeDef("LOTTERYOTHERPCODE");
//	public static ProdCodeDef MONEYORDERPCODE = new ProdCodeDef("MONEYORDERPCODE");
	public static ProdCodeDef MO_VENDORPAYMENTPCODE = new ProdCodeDef("MO_VENDORPAYMENTPCODE");
	public static ProdCodeDef MO_PAYROLLCHECKPCODE = new ProdCodeDef("MO_PAYROLLCHECKPCODE");
	public static ProdCodeDef MO_GIFTCERTPCODE = new ProdCodeDef("MO_GIFTCERTPCODE");
	public static ProdCodeDef MO_REFUNDCHECKPCODE = new ProdCodeDef("MO_REFUNDCHECKPCODE");
	public static ProdCodeDef MO_OFFICIALCHECKPCODE = new ProdCodeDef("MO_OFFICIALCHECKPCODE");
	public static ProdCodeDef MO_REBATECHECKPCODE = new ProdCodeDef("MO_REBATECHECKPCODE");
	public static ProdCodeDef MO_DIVIDENDCHECKPCODE = new ProdCodeDef("MO_DIVIDENDCHECKPCODE");
	public static ProdCodeDef MO_UTILITYCHECKPCODE = new ProdCodeDef("MO_UTILITYCHECKPCODE");
	public static ProdCodeDef STORESERVICESPCODE = new ProdCodeDef("STORESERVICESPCODE");
	public static ProdCodeDef HOMEDELIVERYPCODE = new ProdCodeDef("HOMEDELIVERYPCODE");
	public static ProdCodeDef PREPAIDPURCHASEPCODE = new ProdCodeDef("PREPAIDPURCHASEPCODE");
	public static ProdCodeDef PREPAIDACTRECHGPCODE = new ProdCodeDef("PREPAIDACTRECHGPCODE");
	public static ProdCodeDef MEMBERSHIPLOYALTYPCODE = new ProdCodeDef("MEMBERSHIPLOYALTYPCODE");
	public static ProdCodeDef HEALTHPCODE = new ProdCodeDef("HEALTHPCODE");
	public static ProdCodeDef PUBLICATIONSPCODE = new ProdCodeDef("PUBLICATIONSPCODE");
	public static ProdCodeDef DISCOUNT1PCODE = new ProdCodeDef("DISCOUNT1PCODE");
	public static ProdCodeDef DISCOUNT2PCODE = new ProdCodeDef("DISCOUNT2PCODE");
	public static ProdCodeDef DISCOUNT3PCODE = new ProdCodeDef("DISCOUNT3PCODE");
	public static ProdCodeDef DISCOUNT4PCODE = new ProdCodeDef("DISCOUNT4PCODE");
	public static ProdCodeDef DISCOUNT5PCODE = new ProdCodeDef("DISCOUNT5PCODE");
	public static ProdCodeDef COUPON1PCODE = new ProdCodeDef("COUPON1PCODE");
	public static ProdCodeDef COUPON2PCODE = new ProdCodeDef("COUPON2PCODE");
	public static ProdCodeDef COUPON3PCODE = new ProdCodeDef("COUPON3PCODE");
	public static ProdCodeDef COUPON4PCODE = new ProdCodeDef("COUPON4PCODE");
	public static ProdCodeDef COUPON5PCODE = new ProdCodeDef("COUPON5PCODE");
	public static ProdCodeDef LOTTERYPAYOUTINSTANTPCODE = new ProdCodeDef("LOTTERYPAYOUTINSTANTPCODE");
	public static ProdCodeDef LOTTERYPAYOUTONLINEPCODE = new ProdCodeDef("LOTTERYPAYOUTONLINEPCODE");
	public static ProdCodeDef LOTTERYPAYOUTOTHERPCODE = new ProdCodeDef("LOTTERYPAYOUTOTHERPCODE");
	public static ProdCodeDef SPLITTENDERPCODE = new ProdCodeDef("SPLITTENDERPCODE");
	public static ProdCodeDef TAXDISCOUNTPCODE = new ProdCodeDef("TAXDISCOUNTPCODE");
	public static ProdCodeDef TAX1PCODE = new ProdCodeDef("TAX1PCODE");
	public static ProdCodeDef TAX2PCODE = new ProdCodeDef("TAX2PCODE");
	public static ProdCodeDef TAX3PCODE = new ProdCodeDef("TAX3PCODE");
	public static ProdCodeDef TAX4PCODE = new ProdCodeDef("TAX4PCODE");
	public static ProdCodeDef TAX5PCODE = new ProdCodeDef("TAX5PCODE");
	public static ProdCodeDef CASHBACKPCODE = new ProdCodeDef("CASHBACKPCODE");
	public static ProdCodeDef CASHBACKFEEPCODE = new ProdCodeDef("CASHBACKFEEPCODE");
	public static ProdCodeDef FEE1PCODE = new ProdCodeDef("FEE1PCODE");
	public static ProdCodeDef FEE2PCODE = new ProdCodeDef("FEE2PCODE");
	public static ProdCodeDef FEE3PCODE = new ProdCodeDef("FEE3PCODE");
	public static ProdCodeDef FEE4PCODE = new ProdCodeDef("FEE4PCODE");
	public static ProdCodeDef FEE5PCODE = new ProdCodeDef("FEE5PCODE");
	public static ProdCodeDef MISCAVIATIONTAXPCODE = new ProdCodeDef("MISCAVIATIONTAXPCODE");
	public static ProdCodeDef GST_HST_VAT1PCODE = new ProdCodeDef("GST_HST_VAT1PCODE");
	public static ProdCodeDef PST_QST_VAT2PCODE = new ProdCodeDef("PST_QST_VAT2PCODE");
	public static ProdCodeDef SWT_VAT3PCODE = new ProdCodeDef("SWT_VAT3PCODE");

	// The 4 declarations below are necessary for serialization
	private static int nextOrdinal = 0;

	private final int ordinal = nextOrdinal++; //ProdCodeDef's ;

	// auto-incremented

	private static final ProdCodeDef[] VALUES = { FUELPCODE, KEROPCODE,
			DSLPCODE, MDSEPCODE, BATTACCPCODE, LABORPCODE, TIRESPCODE,
			OILPCODE, LUBEPCODE, COUPONPCODE, CNGPCODE, TAXPCODE, WASHPCODE,
			TOWPCODE, REPAIRPCODE, AUTOPARTSPCODE, AUTOMDSEPCODE, DSLFSPCODE,
			CIGSPCODE, TOBACCOPCODE, BEERPCODE, WINEPCODE, LIQOURPCODE,
			PREPAIDPCODE, ANTIFREZPCODE, FUELADJPOS, FUELADJNEG,
			UNLEADEDFUELPCODE, POWERPLUSFUELPCODE, REGULARFUELPCODE,
			POWERPREMIUMFUEPCODE, AVGASFUELPCODE, AVGETFUELPCODE,
			MARINEFUELPCODE, MANUALFUELPCODE, BEERWINEPCODE, GROCERYPCODE,
			OILCHANGESPCODE, OILFILTERSPCODE, AUTOINSPECTIONPCODE,
			WORKORDERPCODE, QSRPCODE, PREMIUMDIESELPCODE, OFFROADDIESELPCODE,
			MISCNONTAXPCODE, MONEYORDERPCODE, MONEYORDERFEEPCODE, LOTTERYPCODE,
			UN_ETHANOL5_7PCODE, MID_ETHANOL5_7PCODE, PRE_ETHANOL5_7PCODE,
			UN_ETHANOL7_7PCODE, MID_ETHANOL7_7PCODE, PRE_ETHANOL7_7PCODE,
			UN_ETHANOL10PCODE, MID_ETHANOL10PCODE, PRE_ETHANOL10PCODE,
			HYDROGENPCODE, OTHERTENDERPCODE, NETDISCOUNTPCODE, PTAXPCODE,
			PCASHPCODE, PACCTPCODE, NTAXPCODE, NDISCPCODE, NCASHPCODE,
			NACCTPCODE, NCHECKPCODE, NFOODSTAMPPCODE, PCASHBACKPCODE,
			POTHERTENDERPCODE, NCASHBACKPCODE,
			PREM1PCODE, REGFSPCODE, UNLFSPCODE, PREM1FSPCODE, MID1PCODE,
			MID1FSPCODE, MID2PCODE, MID2FSPCODE, MID3PCODE, MID3FSPCODE,
			PREM2PCODE, PREM2FSPCODE, DSL2PCODE, DSL2FSPCODE, GASOHOLPCODE,
			DISCOUNTPCODE, ETHANOLPCODE, E85PCODE, MISCSERVPCODE, ETHANOLFSPCODE,
			ETHANOL2PCODE, ETHANOL2FSPCODE, ETHANOL3PCODE, ETHANOL3FSPCODE,
			GASOHOLFSPCODE, GASOHOL2PCODE, GASOHOL2FSPCODE, GASOHOL3PCODE,
			GASOHOL3FSPCODE, PREPFOODPCODE, RESTAURANTPCODE, MILKPCODE,
			BEVERAGEPCODE, TOBACCOOUTLETPCODE, PREPFOODCOSTPCODE,
			UN_ETHANOL5_7FSPCODE, MID_ETHANOL5_7FSPCODE, PRE_ETHANOL5_7FSPCODE,
			UN_ETHANOL7_7FSPCODE, MID_ETHANOL7_7FSPCODE, PRE_ETHANOL7_7FSPCODE,
			UN_ETHANOL10FSPCODE, MID_ETHANOL10FSPCODE, PRE_ETHANOL10FSPCODE,
			FARMDSLPCODE, PROPANEPCODE, NONFARMDSLPCODE, TRUCKSCALEPCODE,
			ADDITIONALPCODE, DYEDDSLPCODE, LOWSULFBIOPCODE,
// exxonmobil nacs product codes			
			UNLEADED1PCODE, UNLEADED2PCODE, UNLEADED3PCODE, UNLEADED4PCODE, 
			UNLEADED5PCODE, METHANOL57PCODE, PLUSMETH57PCODE, SUPERMETH57PCODE,
			METHANOL77PCODE, PLUSMETH77PCODE, ETHANOL57PCODE, PLUSETHANOL57PCODE,
			SUPERETHANOL57PCODE, ETHANOL77PCODE, PLUSETHANOL77PCODE, METHANOLLEADEDPCODE,
			ETHANOLLEADEDPCODE, LEADEDPCODE, DIESEL1PCODE, DIESEL2PCODE, DIESEL3PCODE,
			CNGFUELPCODE, LPGFUELPCODE, LNGFUELPCODE, M85FUELPCODE, E85FUELPCODE,
			REFORM1FUELPCODE, REFORM2FUELPCODE, REFORM3FUELPCODE, REFORM4FUELPCODE,
			REFORM5FUELPCODE, DIESEL1NOTAXPCODE, DIESEL2NOTAXPCODE, DIESEL3NOTAXPCODE,
			OTHERFUELNOTAXPCODE, RACINGFUELPCODE, SUPERMETH77PCODE, METHANOL100PCODE,
			PLUSMETH100PCODE, SUPERMETH100PCODE, SUPERETHANOL77PCODE, ETHAN0L100PCODE,
			PLUSETHANOL100PCODE, SUPERETHANOL100PCODE, MISCFUELPCODE, MOTOROILPCODE, 
			CARWASHPCODE, WASHERFLUIDPCODE, BRAKEFLUIDPCODE, TIREEXCISETAXPCODE,
			TIREROTATIONPCODE, BATTERIESPCODE, ROADSERVICEPCODE, AUTOACCESSORIESPCODE,
			PREVENTMAINTPCODE, ACSERVICEPCODE, ENGINESERVICEPCODE, TRANSMSERVICEPCODE,
			BRAKESERVICEPCODE, EXHAUSTSERVICEPCODE, BODYWORKPCODE, AUTOGLASSPCODE,
			SYNTHETICOILPCODE, LAMPSPCODE, WIPERSPCODE, HOSESPCODE, TIRERELATEDPCODE,
			SERVICEPKGPCODE, AUTOPARKINGPCODE, TRUCKTANKCLEANPCODE, OTHERLUBEPCODE,
			MISCPARTSSERVICEPCODE, JETFUELPCODE, AVIATIONFUEL1PCODE, AVIATIONFUEL2PCODE,
			AVIATIONFUEL3PCODE, AVIATIONFUEL4PCODE, AVIATIONFUEL5PCODE, MISCAVIATIONFUELPCODE,
			AVSTORAGEPCODE, AVGROUNDHANDLINGPCODE, AVGROUNDPOWERUNITPCODE, AVLABORPCODE,
			AVWORKORDERPCODE, AVMAINTENANCEPCODE, AVSERVICEPCODE, AVTRANSPORTPCODE,
			AVDEICINGPCODE, AVRAMPFEESPCODE, AVCATERINGPCODE, AVHANGERFEEPCODE,
			AVLANDINGFEEPCODE, AVCALLOUTFEEPCODE, AVRENTALPCODE, AVINSTRUCTIONFEEPCODE,
			AVFLIGHTPLANPCODE, AVCHARTERFEEPCODE, AVCOMMUNICATIONPCODE, AVCLEANINGPCODE,
			AVCARGOHANDLINGPCODE, AVACCESSORIESPCODE, AVPILOTSUPPLIESPCODE, AVPARKINGFEESPCODE,
			AVTIEDOWNFEESPCODE, AVSANITATIONFEESPCODE, AVFUELADDITIVEFEESPCODE,
			MISCAVIATIONPCODE, MARINEFUEL1PCODE, MARINEFUEL2PCODE, MARINEFUEL3PCODE,
			MARINEFUEL4PCODE, MARINEFUEL5PCODE, MARINEOTHERPCODE, MISCMARINEFUELPCODE,
			MARINESERVICEPCODE, MARINELABORPCODE, MARINEWORKORDERPCODE, LAUNCHFEEPCODE,
			SLIPRENTALPCODE, MISCMARINESERVICEPCODE, KEROSENEPCODE, WHITEGASPCODE,
			HEATINGOILPCODE, BOTTLEDPROPPCODE, OTHERFUELPCODE, MISCOTHERFUELPCODE,
			MERCHANDISEPCODE, ICEPCODE, TOBACCOOTHERPCODE, GENPACKAGEDBEVPCODE,
			PACKAGEDBEVPCODE, JUICEPCODE, OTHERPACKBEVPCODE, DISPENSEDBEVPCODE, 
			HOTDISPBEVPCODE, COLDDISPBEVPCODE, FROZENDISPBEVPCODE, OTHERDISPBEVPCODE,
			SNACKSPCODE, SALTYSNACKSPCODE, ALTSNACKSPCODE, SWEETSNACKSPCODE,
			CANDYPCODE, DAIRYPCODE, PACKAGEDICECREAMPCODE, OTHERDAIRYPCODE, GROCERYEDIBLEPCODE,
			GROCERYNONEDIBLEPCODE, GROCERYPERISHABLEPCODE, BREADPACKAGEDPCODE,
			FROZENFOODSPCODE, ALCOHOLPCODE, BEERNONALCOHOLPCODE, DELIPCODE, 
			PACKAGEDSANDWICHPCODE, PREPAREDFOODSPCODE, DELIITEMSPCODE, FOODSERVICEPCODE,
			LOTTERYINSTANTPCODE, LOTTYERYONLINEPCODE, LOTTERYOTHERPCODE, MO_VENDORPAYMENTPCODE,
			MO_PAYROLLCHECKPCODE, MO_GIFTCERTPCODE, MO_REFUNDCHECKPCODE, MO_OFFICIALCHECKPCODE,
			MO_REBATECHECKPCODE, MO_DIVIDENDCHECKPCODE, MO_UTILITYCHECKPCODE, 
			STORESERVICESPCODE, HOMEDELIVERYPCODE, PREPAIDPURCHASEPCODE, PREPAIDACTRECHGPCODE,
			MEMBERSHIPLOYALTYPCODE, HEALTHPCODE, PUBLICATIONSPCODE, DISCOUNT1PCODE,
			DISCOUNT2PCODE, DISCOUNT3PCODE, DISCOUNT4PCODE, DISCOUNT5PCODE, COUPON1PCODE,
			COUPON2PCODE, COUPON3PCODE, COUPON4PCODE, COUPON5PCODE, LOTTERYPAYOUTINSTANTPCODE,
			LOTTERYPAYOUTONLINEPCODE, LOTTERYPAYOUTOTHERPCODE, SPLITTENDERPCODE,
			TAXDISCOUNTPCODE, TAX1PCODE, TAX2PCODE, TAX3PCODE,TAX4PCODE, TAX5PCODE, 
			CASHBACKPCODE, CASHBACKFEEPCODE, FEE1PCODE, FEE2PCODE, FEE3PCODE, FEE4PCODE,
			FEE5PCODE, MISCAVIATIONTAXPCODE, GST_HST_VAT1PCODE, PST_QST_VAT2PCODE,
			SWT_VAT3PCODE
			};

	/**
	 * Method to prevent duplicate constants from coexisting as a result of
	 * deserialization (ensures that only a single object represents each enum
	 * constant. This method is automatically invoked by the serialization
	 * mechanism. Without this method, Object.equals() method would be more
	 * involved and not a straightforward super.equals() which does just a ==
	 * check.
	 * 
	 * @throws java.io.ObjectStreamException
	 *             on serialization system issues
	 * @return the enum array
	 */
	Object readResolve() throws java.io.ObjectStreamException {
		return VALUES[ordinal]; // Canonicalize
	}

	/**
	 * Getter for property ordinal. Used to get the gempro's #define value
	 * 
	 * @return Value of property ordinal.
	 */
	public int getOrdinal() {
		return this.ordinal;
	}

	public boolean isValid() {
		return this.valid;
	}

	/**
	 * Method to get the ProdCodeDef.object for a specified ordinal. Used to get
	 * the object given a gempro's #define value
	 * 
	 * @param ordinal
	 *            the #define value represented by the object
	 * @return ProdCodeDef object representing the ordinal
	 */
	protected static ProdCodeDef getObject(int ordinal) {
		if (ordinal < 0 || ordinal >= VALUES.length) {
			return null;
		}
		return VALUES[ordinal];
	}

	/**
	 * Method to get the ProdCodeDef.object with the specified name
	 * @param name
	 * @return ProdCodeDef object with the specified name
	 * @throws Exception
	 */
	public static ProdCodeDef getObjectByName(String name) throws Exception {
		ProdCodeDef[] defs = ProdCodeDef.getObjects();
		for (int i = 0; i < defs.length; i++) {
			if (defs[i].name.equals(name)) {
				return (defs[i]);
			}
		}
		String msg = "ProdCode:" + name + " not found in ProdCodeDef data.";
		LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.ProdCodeDef.class).error( msg);
		throw new Exception(msg);
	}

	/**
	 * Getter for all the ProdCodeDef.objects
	 * 
	 * @return array of ProdCode Definitions
	 */
	public static ProdCodeDef[] getObjects() {
		ProdCodeDef[] defs = new ProdCodeDef[VALUES.length];
		System.arraycopy(VALUES, 0, defs, 0, VALUES.length);
		return defs;
	}

	/**
	 * Test method
	 * 
	 * @param args
	 *            params to the test
	 */

	public static void main(String[] args) {
		ProdCodeDef[] defs = ProdCodeDef.getObjects();
		for (int i = 0; i < defs.length; i++) {
			System.out.println("ProdCode: " + defs[i].getOrdinal() + " name = "
					+ defs[i].toString());
		}

		System.out.println("ProdCodeDef.FUELPCODE:"
				+ ProdCodeDef.FUELPCODE.toString() + ", value:"
				+ ProdCodeDef.FUELPCODE.getValue());
		System.out.println("ProdCodeDef.KEROPCODE:"
				+ ProdCodeDef.KEROPCODE.toString() + ", value:"
				+ ProdCodeDef.KEROPCODE.getValue());
		System.out.println("ProdCodeDef.DSLPCODE:"
				+ ProdCodeDef.DSLPCODE.toString() + ", value:"
				+ ProdCodeDef.DSLPCODE.getValue());
		System.out.println("ProdCodeDef.MDSEPCODE:"
				+ ProdCodeDef.MDSEPCODE.toString() + ", value:"
				+ ProdCodeDef.MDSEPCODE.getValue());
		System.out.println("ProdCodeDef.BATTACCPCODE:"
				+ ProdCodeDef.BATTACCPCODE.toString() + ", value:"
				+ ProdCodeDef.BATTACCPCODE.getValue());
		System.out.println("ProdCodeDef.LABORPCODE:"
				+ ProdCodeDef.LABORPCODE.toString() + ", value:"
				+ ProdCodeDef.LABORPCODE.getValue());
		System.out.println("ProdCodeDef.TIRESPCODE:"
				+ ProdCodeDef.TIRESPCODE.toString() + ", value:"
				+ ProdCodeDef.TIRESPCODE.getValue());
		System.out.println("ProdCodeDef.OILPCODE:"
				+ ProdCodeDef.OILPCODE.toString() + ", value:"
				+ ProdCodeDef.OILPCODE.getValue());
		System.out.println("ProdCodeDef.LUBEPCODE:"
				+ ProdCodeDef.LUBEPCODE.toString() + ", value:"
				+ ProdCodeDef.LUBEPCODE.getValue());
		System.out.println("ProdCodeDef.COUPONPCODE:"
				+ ProdCodeDef.COUPONPCODE.toString() + ", value:"
				+ ProdCodeDef.COUPONPCODE.getValue());
		System.out.println("ProdCodeDef.CNGPCODE:"
				+ ProdCodeDef.CNGPCODE.toString() + ", value:"
				+ ProdCodeDef.CNGPCODE.getValue());
		System.out.println("ProdCodeDef.TAXPCODE:"
				+ ProdCodeDef.TAXPCODE.toString() + ", value:"
				+ ProdCodeDef.TAXPCODE.getValue());
		System.out.println("ProdCodeDef.WASHPCODE:"
				+ ProdCodeDef.WASHPCODE.toString() + ", value:"
				+ ProdCodeDef.WASHPCODE.getValue());
		System.out.println("ProdCodeDef.TOWPCODE:"
				+ ProdCodeDef.TOWPCODE.toString() + ", value:"
				+ ProdCodeDef.TOWPCODE.getValue());
		System.out.println("ProdCodeDef.REPAIRPCODE:"
				+ ProdCodeDef.REPAIRPCODE.toString() + ", value:"
				+ ProdCodeDef.REPAIRPCODE.getValue());
		System.out.println("ProdCodeDef.AUTOPARTSPCODE:"
				+ ProdCodeDef.AUTOPARTSPCODE.toString() + ", value:"
				+ ProdCodeDef.AUTOPARTSPCODE.getValue());
		System.out.println("ProdCodeDef.AUTOMDSEPCODE:"
				+ ProdCodeDef.AUTOMDSEPCODE.toString() + ", value:"
				+ ProdCodeDef.AUTOMDSEPCODE.getValue());
		System.out.println("ProdCodeDef.DSLFSPCODE:"
				+ ProdCodeDef.DSLFSPCODE.toString() + ", value:"
				+ ProdCodeDef.DSLFSPCODE.getValue());
		System.out.println("ProdCodeDef.CIGSPCODE:"
				+ ProdCodeDef.CIGSPCODE.toString() + ", value:"
				+ ProdCodeDef.CIGSPCODE.getValue());
		System.out.println("ProdCodeDef.TOBACCOPCODE:"
				+ ProdCodeDef.TOBACCOPCODE.toString() + ", value:"
				+ ProdCodeDef.TOBACCOPCODE.getValue());
		System.out.println("ProdCodeDef.BEERPCODE:"
				+ ProdCodeDef.BEERPCODE.toString() + ", value:"
				+ ProdCodeDef.BEERPCODE.getValue());
		System.out.println("ProdCodeDef.WINEPCODE:"
				+ ProdCodeDef.WINEPCODE.toString() + ", value:"
				+ ProdCodeDef.WINEPCODE.getValue());
		System.out.println("ProdCodeDef.LIQOURPCODE:"
				+ ProdCodeDef.LIQOURPCODE.toString() + ", value:"
				+ ProdCodeDef.LIQOURPCODE.getValue());
		System.out.println("ProdCodeDef.PREPAIDPCODE:"
				+ ProdCodeDef.PREPAIDPCODE.toString() + ", value:"
				+ ProdCodeDef.PREPAIDPCODE.getValue());
		System.out.println("ProdCodeDef.ANTIFREZPCODE:"
				+ ProdCodeDef.ANTIFREZPCODE.toString() + ", value:"
				+ ProdCodeDef.ANTIFREZPCODE.getValue());
		System.out.println("ProdCodeDef.FUELADJPOS:"
				+ ProdCodeDef.FUELADJPOS.toString() + ", value:"
				+ ProdCodeDef.FUELADJPOS.getValue());
		System.out.println("ProdCodeDef.FUELADJNEG:"
				+ ProdCodeDef.FUELADJNEG.toString() + ", value:"
				+ ProdCodeDef.FUELADJNEG.getValue());
		System.out.println("ProdCodeDef.UNLEADEDFUELPCODE:"
				+ ProdCodeDef.UNLEADEDFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.UNLEADEDFUELPCODE.getValue());
		System.out.println("ProdCodeDef.POWERPLUSFUELPCODE:"
				+ ProdCodeDef.POWERPLUSFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.POWERPLUSFUELPCODE.getValue());
		System.out.println("ProdCodeDef.REGULARFUELPCODE:"
				+ ProdCodeDef.REGULARFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.REGULARFUELPCODE.getValue());
		System.out.println("ProdCodeDef.POWERPREMIUMFUEPCODE:"
				+ ProdCodeDef.POWERPREMIUMFUEPCODE.toString() + ", value:"
				+ ProdCodeDef.POWERPREMIUMFUEPCODE.getValue());
		System.out.println("ProdCodeDef.AVGASFUELPCODE:"
				+ ProdCodeDef.AVGASFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.AVGASFUELPCODE.getValue());
		System.out.println("ProdCodeDef.AVGETFUELPCODE:"
				+ ProdCodeDef.AVGETFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.AVGETFUELPCODE.getValue());
		System.out.println("ProdCodeDef.MARINEFUELPCODE:"
				+ ProdCodeDef.MARINEFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.MARINEFUELPCODE.getValue());
		System.out.println("ProdCodeDef.MANUALFUELPCODE:"
				+ ProdCodeDef.MANUALFUELPCODE.toString() + ", value:"
				+ ProdCodeDef.MANUALFUELPCODE.getValue());
		System.out.println("ProdCodeDef.BEERWINEPCODE:"
				+ ProdCodeDef.BEERWINEPCODE.toString() + ", value:"
				+ ProdCodeDef.BEERWINEPCODE.getValue());
		System.out.println("ProdCodeDef.GROCERYPCODE:"
				+ ProdCodeDef.GROCERYPCODE.toString() + ", value:"
				+ ProdCodeDef.GROCERYPCODE.getValue());
		System.out.println("ProdCodeDef.OILCHANGESPCODE:"
				+ ProdCodeDef.OILCHANGESPCODE.toString() + ", value:"
				+ ProdCodeDef.OILCHANGESPCODE.getValue());
		System.out.println("ProdCodeDef.OILFILTERSPCODE:"
				+ ProdCodeDef.OILFILTERSPCODE.toString() + ", value:"
				+ ProdCodeDef.OILFILTERSPCODE.getValue());
		System.out.println("ProdCodeDef.AUTOINSPECTIONPCODE:"
				+ ProdCodeDef.AUTOINSPECTIONPCODE.toString() + ", value:"
				+ ProdCodeDef.AUTOINSPECTIONPCODE.getValue());
		System.out.println("ProdCodeDef.WORKORDERPCODE:"
				+ ProdCodeDef.WORKORDERPCODE.toString() + ", value:"
				+ ProdCodeDef.WORKORDERPCODE.getValue());
		System.out.println("ProdCodeDef.QSRPCODE:"
				+ ProdCodeDef.QSRPCODE.toString() + ", value:"
				+ ProdCodeDef.QSRPCODE.getValue());
		System.out.println("ProdCodeDef.PREMIUMDIESELPCODE:"
				+ ProdCodeDef.PREMIUMDIESELPCODE.toString() + ", value:"
				+ ProdCodeDef.PREMIUMDIESELPCODE.getValue());
		System.out.println("ProdCodeDef.OFFROADDIESELPCODE:"
				+ ProdCodeDef.OFFROADDIESELPCODE.toString() + ", value:"
				+ ProdCodeDef.OFFROADDIESELPCODE.getValue());
		System.out.println("ProdCodeDef.MISCNONTAXPCODE:"
				+ ProdCodeDef.MISCNONTAXPCODE.toString() + ", value:"
				+ ProdCodeDef.MISCNONTAXPCODE.getValue());
		System.out.println("ProdCodeDef.MONEYORDERPCODE:"
				+ ProdCodeDef.MONEYORDERPCODE.toString() + ", value:"
				+ ProdCodeDef.MONEYORDERPCODE.getValue());
		System.out.println("ProdCodeDef.MONEYORDERFEEPCODE:"
				+ ProdCodeDef.MONEYORDERFEEPCODE.toString() + ", value:"
				+ ProdCodeDef.MONEYORDERFEEPCODE.getValue());
		System.out.println("ProdCodeDef.LOTTERYPCODE:"
				+ ProdCodeDef.LOTTERYPCODE.toString() + ", value:"
				+ ProdCodeDef.LOTTERYPCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL5_7PCODE:"
				+ ProdCodeDef.UN_ETHANOL5_7PCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL5_7PCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL5_7PCODE:"
				+ ProdCodeDef.MID_ETHANOL5_7PCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL5_7PCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL5_7PCODE:"
				+ ProdCodeDef.PRE_ETHANOL5_7PCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL5_7PCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL7_7PCODE:"
				+ ProdCodeDef.UN_ETHANOL7_7PCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL7_7PCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL7_7PCODE:"
				+ ProdCodeDef.MID_ETHANOL7_7PCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL7_7PCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL7_7PCODE:"
				+ ProdCodeDef.PRE_ETHANOL7_7PCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL7_7PCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL10PCODE:"
				+ ProdCodeDef.UN_ETHANOL10PCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL10PCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL10PCODE:"
				+ ProdCodeDef.MID_ETHANOL10PCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL10PCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL10PCODE:"
				+ ProdCodeDef.PRE_ETHANOL10PCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL10PCODE.getValue());
		System.out.println("ProdCodeDef.HYDROGENPCODE:"
				+ ProdCodeDef.HYDROGENPCODE.toString() + ", value:"
				+ ProdCodeDef.HYDROGENPCODE.getValue());
		System.out.println("ProdCodeDef.OTHERTENDERPCODE:"
				+ ProdCodeDef.OTHERTENDERPCODE.toString() + ", value:"
				+ ProdCodeDef.OTHERTENDERPCODE.getValue());
		System.out.println("ProdCodeDef.NETDISCOUNTPCODE:"
				+ ProdCodeDef.NETDISCOUNTPCODE.toString() + ", value:"
				+ ProdCodeDef.NETDISCOUNTPCODE.getValue());
		System.out.println("ProdCodeDef.PTAXPCODE:"
				+ ProdCodeDef.PTAXPCODE.toString() + ", value:"
				+ ProdCodeDef.PTAXPCODE.getValue());
		System.out.println("ProdCodeDef.PCASHPCODE:"
				+ ProdCodeDef.PCASHPCODE.toString() + ", value:"
				+ ProdCodeDef.PCASHPCODE.getValue());
		System.out.println("ProdCodeDef.PACCTPCODE:"
				+ ProdCodeDef.PACCTPCODE.toString() + ", value:"
				+ ProdCodeDef.PACCTPCODE.getValue());
		System.out.println("ProdCodeDef.NTAXPCODE:"
				+ ProdCodeDef.NTAXPCODE.toString() + ", value:"
				+ ProdCodeDef.NTAXPCODE.getValue());
		System.out.println("ProdCodeDef.NDISCPCODE:"
				+ ProdCodeDef.NDISCPCODE.toString() + ", value:"
				+ ProdCodeDef.NDISCPCODE.getValue());
		System.out.println("ProdCodeDef.NCASHPCODE:"
				+ ProdCodeDef.NCASHPCODE.toString() + ", value:"
				+ ProdCodeDef.NCASHPCODE.getValue());
		System.out.println("ProdCodeDef.NACCTPCODE:"
				+ ProdCodeDef.NACCTPCODE.toString() + ", value:"
				+ ProdCodeDef.NACCTPCODE.getValue());
		System.out.println("ProdCodeDef.NCHECKPCODE:"
				+ ProdCodeDef.NCHECKPCODE.toString() + ", value:"
				+ ProdCodeDef.NCHECKPCODE.getValue());
		System.out.println("ProdCodeDef.NFOODSTAMPPCODE:"
				+ ProdCodeDef.NFOODSTAMPPCODE.toString() + ", value:"
				+ ProdCodeDef.NFOODSTAMPPCODE.getValue());
		System.out.println("ProdCodeDef.PCASHBACKPCODE:"
				+ ProdCodeDef.PCASHBACKPCODE.toString() + ", value:"
				+ ProdCodeDef.PCASHBACKPCODE.getValue());
		System.out.println("ProdCodeDef.POTHERTENDERPCODE:"
				+ ProdCodeDef.POTHERTENDERPCODE.toString() + ", value:"
				+ ProdCodeDef.POTHERTENDERPCODE.getValue());
		System.out.println("ProdCodeDef.NOTHERTENDERPCODE:"
				+ ProdCodeDef.NOTHERTENDERPCODE.toString() + ", value:"
				+ ProdCodeDef.NOTHERTENDERPCODE.getValue());
		System.out.println("ProdCodeDef.NCASHBACKPCODE:"
				+ ProdCodeDef.NCASHBACKPCODE.toString() + ", value:"
				+ ProdCodeDef.NCASHBACKPCODE.getValue());
        
		System.out.println("ProdCodeDef.PREM1PCODE:"
 				+ ProdCodeDef.PREM1PCODE.toString() + ", value:"
				+ ProdCodeDef.PREM1PCODE.getValue());
		System.out.println("ProdCodeDef.REGFSPCODE:"
				+ ProdCodeDef.REGFSPCODE.toString() + ", value:"
				+ ProdCodeDef.REGFSPCODE.getValue());
		System.out.println("ProdCodeDef.UNLFSPCODE:"
				+ ProdCodeDef.UNLFSPCODE.toString() + ", value:"
				+ ProdCodeDef.UNLFSPCODE.getValue());
		System.out.println("ProdCodeDef.PREM1FSPCODE:"
 				+ ProdCodeDef.PREM1FSPCODE.toString() + ", value:"
				+ ProdCodeDef.PREM1FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID1PCODE:"
  				+ ProdCodeDef.MID1PCODE.toString() + ", value:"
				+ ProdCodeDef.MID1PCODE.getValue());
		System.out.println("ProdCodeDef.MID1FSPCODE:"
				+ ProdCodeDef.MID1FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID1FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID2PCODE:"
				+ ProdCodeDef.MID2PCODE.toString() + ", value:"
				+ ProdCodeDef.MID2PCODE.getValue());
		System.out.println("ProdCodeDef.MID2FSPCODE:"
				+ ProdCodeDef.MID2FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID2FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID3PCODE:"
 				+ ProdCodeDef.MID3PCODE.toString() + ", value:"
				+ ProdCodeDef.MID3PCODE.getValue());
		System.out.println("ProdCodeDef.MID3FSPCODE:"
				+ ProdCodeDef.MID3FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID3FSPCODE.getValue());
		System.out.println("ProdCodeDef.PREM2PCODE:"
 				+ ProdCodeDef.PREM2PCODE.toString() + ", value:"
				+ ProdCodeDef.PREM2PCODE.getValue());
		System.out.println("ProdCodeDef.PREM2FSPCODE:"
 				+ ProdCodeDef.PREM2FSPCODE.toString() + ", value:"
				+ ProdCodeDef.PREM2FSPCODE.getValue());
		System.out.println("ProdCodeDef.DSL2PCODE:"
				+ ProdCodeDef.DSL2PCODE.toString() + ", value:"
				+ ProdCodeDef.DSL2PCODE.getValue());
		System.out.println("ProdCodeDef.DSL2FSPCODE:"
				+ ProdCodeDef.DSL2FSPCODE.toString() + ", value:"
				+ ProdCodeDef.DSL2FSPCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOLPCODE:"
				+ ProdCodeDef.GASOHOLPCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOLPCODE.getValue());
		System.out.println("ProdCodeDef.DISCOUNTPCODE:"
 				+ ProdCodeDef.DISCOUNTPCODE.toString() + ", value:"
				+ ProdCodeDef.DISCOUNTPCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOLPCODE:"
				+ ProdCodeDef.ETHANOLPCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOLPCODE.getValue());
		System.out.println("ProdCodeDef.E85PCODE:"
				+ ProdCodeDef.E85PCODE.toString() + ", value:"
				+ ProdCodeDef.E85PCODE.getValue());
		System.out.println("ProdCodeDef.MISCSERVPCODE:"
  				+ ProdCodeDef.MISCSERVPCODE.toString() + ", value:"
				+ ProdCodeDef.MISCSERVPCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOLFSPCODE:"
  				+ ProdCodeDef.ETHANOLFSPCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOLFSPCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOL2PCODE:"
				+ ProdCodeDef.ETHANOL2PCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOL2PCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOL2FSPCODE:"
 				+ ProdCodeDef.ETHANOL2FSPCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOL2FSPCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOL3PCODE:"
 				+ ProdCodeDef.ETHANOL3PCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOL3PCODE.getValue());
		System.out.println("ProdCodeDef.ETHANOL3FSPCODE:"
 				+ ProdCodeDef.ETHANOL3FSPCODE.toString() + ", value:"
				+ ProdCodeDef.ETHANOL3FSPCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOLFSPCODE:"
 				+ ProdCodeDef.GASOHOLFSPCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOLFSPCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOL2PCODE:"
 				+ ProdCodeDef.GASOHOL2PCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOL2PCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOL2FSPCODE:"
 				+ ProdCodeDef.GASOHOL2FSPCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOL2FSPCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOL3PCODE:"
 				+ ProdCodeDef.GASOHOL3PCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOL3PCODE.getValue());
		System.out.println("ProdCodeDef.GASOHOL3FSPCODE:"
  				+ ProdCodeDef.GASOHOL3FSPCODE.toString() + ", value:"
				+ ProdCodeDef.GASOHOL3FSPCODE.getValue());
		System.out.println("ProdCodeDef.PREPFOODPCODE:"
 				+ ProdCodeDef.PREPFOODPCODE.toString() + ", value:"
				+ ProdCodeDef.PREPFOODPCODE.getValue());
		System.out.println("ProdCodeDef.RESTAURANTPCODE:"
 				+ ProdCodeDef.RESTAURANTPCODE.toString() + ", value:"
				+ ProdCodeDef.RESTAURANTPCODE.getValue());
		System.out.println("ProdCodeDef.MILKPCODE:"
 				+ ProdCodeDef.MILKPCODE.toString() + ", value:"
				+ ProdCodeDef.MILKPCODE.getValue());
		System.out.println("ProdCodeDef.BEVERAGEPCODE:"
  				+ ProdCodeDef.BEVERAGEPCODE.toString() + ", value:"
				+ ProdCodeDef.BEVERAGEPCODE.getValue());
		System.out.println("ProdCodeDef.TOBACCOOUTLETPCODE:"
 				+ ProdCodeDef.TOBACCOOUTLETPCODE.toString() + ", value:"
				+ ProdCodeDef.TOBACCOOUTLETPCODE.getValue());
		System.out.println("ProdCodeDef.PREPFOODCOSTPCODE:"
  				+ ProdCodeDef.PREPFOODCOSTPCODE.toString() + ", value:"
				+ ProdCodeDef.PREPFOODCOSTPCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL5_7FSPCODE:"
				+ ProdCodeDef.UN_ETHANOL5_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL5_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL5_7FSPCODE:"
				+ ProdCodeDef.MID_ETHANOL5_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL5_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL5_7FSPCODE:"
				+ ProdCodeDef.PRE_ETHANOL5_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL5_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL7_7FSPCODE:"
				+ ProdCodeDef.UN_ETHANOL7_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL7_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL7_7FSPCODE:"
				+ ProdCodeDef.MID_ETHANOL7_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL7_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL7_7FSPCODE:"
				+ ProdCodeDef.PRE_ETHANOL7_7FSPCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL7_7FSPCODE.getValue());
		System.out.println("ProdCodeDef.UN_ETHANOL10FSPCODE:"
				+ ProdCodeDef.UN_ETHANOL10FSPCODE.toString() + ", value:"
				+ ProdCodeDef.UN_ETHANOL10FSPCODE.getValue());
		System.out.println("ProdCodeDef.MID_ETHANOL10FSPCODE:"
				+ ProdCodeDef.MID_ETHANOL10FSPCODE.toString() + ", value:"
				+ ProdCodeDef.MID_ETHANOL10FSPCODE.getValue());
		System.out.println("ProdCodeDef.PRE_ETHANOL10FSPCODE:"
				+ ProdCodeDef.PRE_ETHANOL10FSPCODE.toString() + ", value:"
				+ ProdCodeDef.PRE_ETHANOL10FSPCODE.getValue());
		System.out.println("ProdCodeDef.FARMDSLPCODE:"
				+ ProdCodeDef.FARMDSLPCODE.toString() + ", value:"
				+ ProdCodeDef.FARMDSLPCODE.getValue());
		System.out.println("ProdCodeDef.PROPANEPCODE:"
				+ ProdCodeDef.PROPANEPCODE.toString() + ", value:"
				+ ProdCodeDef.PROPANEPCODE.getValue());
		System.out.println("ProdCodeDef.NONFARMDSLPCODE:"
				+ ProdCodeDef.NONFARMDSLPCODE.toString() + ", value:"
				+ ProdCodeDef.NONFARMDSLPCODE.getValue());
		System.out.println("ProdCodeDef.TRUCKSCALEPCODE:"
				+ ProdCodeDef.TRUCKSCALEPCODE.toString() + ", value:"
				+ ProdCodeDef.TRUCKSCALEPCODE.getValue());
		System.out.println("ProdCodeDef.ADDITIONALPCODE:"
				+ ProdCodeDef.ADDITIONALPCODE.toString() + ", value:"
				+ ProdCodeDef.ADDITIONALPCODE.getValue());
		System.out.println("ProdCodeDef.DYEDDSLPCODE:"
				+ ProdCodeDef.DYEDDSLPCODE.toString() + ", value:"
				+ ProdCodeDef.DYEDDSLPCODE.getValue());
		System.out.println("ProdCodeDef.LOWSULFBIOPCODE:"
				+ ProdCodeDef.LOWSULFBIOPCODE.toString() + ", value:"
				+ ProdCodeDef.LOWSULFBIOPCODE.getValue());
	}

}
