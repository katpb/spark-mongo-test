package com.verifone.isd.vsms2.sales.ent;

import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sales.ent.agevalidn.AgeValidn;
import com.verifone.isd.vsms2.sales.ent.apt.APTAllowedFPConfig;
import com.verifone.isd.vsms2.sales.ent.apt.APTAllowedOperationsConfig;
import com.verifone.isd.vsms2.sales.ent.apt.APTDepartmentConfig;
import com.verifone.isd.vsms2.sales.ent.apt.APTGlobalConfig;
import com.verifone.isd.vsms2.sales.ent.apt.APTTerminalConfig;
import com.verifone.isd.vsms2.sales.ent.banner.Banner;
import com.verifone.isd.vsms2.sales.ent.bluelaw.BlueLaw;
import com.verifone.isd.vsms2.sales.ent.cashiertracking.CatTracking;
import com.verifone.isd.vsms2.sales.ent.cashiertracking.DeptTracking;
import com.verifone.isd.vsms2.sales.ent.cashiertracking.PluTracking;
import com.verifone.isd.vsms2.sales.ent.category.Category;
import com.verifone.isd.vsms2.sales.ent.charity.Charity;
import com.verifone.isd.vsms2.sales.ent.checkline.CheckLine;
import com.verifone.isd.vsms2.sales.ent.couponcfg.CouponConfig;
import com.verifone.isd.vsms2.sales.ent.couponfam.CouponFam;
import com.verifone.isd.vsms2.sales.ent.couponmsg.CouponMsg;
import com.verifone.isd.vsms2.sales.ent.currency.Currency;
import com.verifone.isd.vsms2.sales.ent.cwcfg.CarWashConfig;
import com.verifone.isd.vsms2.sales.ent.cwpaypoint.CarWashPaypointConfig;
import com.verifone.isd.vsms2.sales.ent.dept.Department;
import com.verifone.isd.vsms2.sales.ent.discountdenom.DiscountDenom;
import com.verifone.isd.vsms2.sales.ent.fee.Fee;
import com.verifone.isd.vsms2.sales.ent.fueltax.FuelTaxEx;
import com.verifone.isd.vsms2.sales.ent.fueltax.FuelTaxRcpt;
import com.verifone.isd.vsms2.sales.ent.imagecfg.ImageConfig;
import com.verifone.isd.vsms2.sales.ent.inhouseacct.InHouseAcct;
import com.verifone.isd.vsms2.sales.ent.loginout.LogInOut;
import com.verifone.isd.vsms2.sales.ent.logo.Logo;
import com.verifone.isd.vsms2.sales.ent.menu.Menu;
import com.verifone.isd.vsms2.sales.ent.mop.Mop;
import com.verifone.isd.vsms2.sales.ent.netcname.NetCardName;
import com.verifone.isd.vsms2.sales.ent.plupromo.PluPromo;
import com.verifone.isd.vsms2.sales.ent.popdefinition.PopDefinition;
import com.verifone.isd.vsms2.sales.ent.popdiscount.PopDiscount;
import com.verifone.isd.vsms2.sales.ent.popsiteinfo.PopSiteInfo;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCode;
import com.verifone.isd.vsms2.sales.ent.promocombo.PromoCombo;
import com.verifone.isd.vsms2.sales.ent.promoitemlistdept.PromoItemListDept;
import com.verifone.isd.vsms2.sales.ent.promoitemlistplu.PromoItemListPLU;
import com.verifone.isd.vsms2.sales.ent.promomixandmatch.PromoMixAndMatch;
import com.verifone.isd.vsms2.sales.ent.salescfg.SalesConfig;
import com.verifone.isd.vsms2.sales.ent.slogan.Slogan;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKey;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyTypeSecurityConfig;
import com.verifone.isd.vsms2.sales.ent.tax.Tax;
import com.verifone.isd.vsms2.sales.ent.tlssiteinfo.TlsSiteInfo;
import com.verifone.isd.vsms2.sales.ent.trans.PopAwardGenDetail;
import com.verifone.isd.vsms2.sales.ent.vendcfg.VendingConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaDepartmentConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaGroupConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaItemSubsetConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaItemSubsetItemConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaItemsetConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaItemsetSubsetConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaMenuConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaTerminal;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaTerminalPreviewConfig;
import com.verifone.isd.vsms2.sales.ent.vistadevice.VistaTerminalPreviewItemsetConfig;
import com.verifone.isd.vsms2.sys.ent.report.PeriodType;

/**
 * Base visitor class for XML serialization of dataset domain
 * objects. This class provides stub functions for the visit()
 * method of all the visited objects. Inheriting visitor classes
 * should implement the visit() methods for the visited objects
 * of interest.
 *
 * Method visit() is the implementation of Visitor pattern.
 * A new visit() method for the appropriate dataset domain object has
 * to be registered with this base class if a new domain object is
 * added and it has to be XML serialized/ parsed.
 *
 * Clients interested in obtaining XML serialized data should
 * instantiate the appropriate visitor subclass and call
 * SAXWriter#writeSAX() passing the visitor as a parameter.
 *
 *  e.g.,
 *	<pre>
 *      XMLViewMgr viewMgr = new XMLViewMgr();
 *      ISAXSerializable v = new RegisterConfigXMLVisitor();
 *      SAXWriter sw = new SAXWriter(sm.getOutputStream());
 *      viewMgr.setSAXWriter(sw);
 *      viewMgr.setISAXSerializable(v);
 *      viewMgr.perform();
 *	</pre>
 *
 *  @author "mailto:bhanu_narayanan@hp.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */

public abstract class SalesEntityVisitor {
    /**
     * Visitor method for object of type MOP.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param mop the MOP object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Mop mop) throws Exception {
    }
    
    /**
     * Visitor method for object of type Banner.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param banner the Banner object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any error is
     * encountered
     */
    public void visit(Banner banner) throws Exception {
    }
    
    /**
     * Visitor method for object of type Category.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param category the Category object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any error is
     * encountered
     */
    public void visit(Category category) throws Exception {
    }
    
    /**
     * Visitor method for object of type Menu.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param menu the Menu object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Menu menu) throws Exception {
    }
    
    /**
     * Visitor method for object of type Logo.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param logo the Logo object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Logo logo) throws Exception {
    }
    
    /**
     * Visitor method for object of type Slogan.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param slogan the Slogan object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Slogan slogan) throws Exception {
    }
    
    /**
     * Visitor method for object of type currency.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param currency the Currency object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Currency currency) throws Exception {
    }
    
    /**
     * Visitor method for object of type AgeValidn.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param ageValidn the AgeValidn object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(AgeValidn ageValidn) throws Exception {
    }
    
    /**
     * Visitor method for object of type Fee.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param fee the Fee object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Fee fee) throws Exception {
    }
    
    /**
     * Visitor method for object of type Department.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param dep the Department object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Department dep) throws Exception {
    }
    
    /**
     * Visitor method for object of type BlueLaw.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param blueLaw the BlueLaw object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(BlueLaw blueLaw) throws Exception {
    }
    
    /**
     * Visitor method for object of type ProductCode.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param prodCode the ProductCode object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(ProdCode prodCode) throws Exception {
    }
    
    /**
     * Visitor method for object of type PromoCombo.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param promoCombo the PromoCombo object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PromoCombo promoCombo) throws Exception {
    }

	/**
     * Visitor method for object of type PromoItemListPLU.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param promoItemListPLU the promotion item list for PLUs object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PromoItemListPLU promoItemListPLU) throws Exception {
    }
    
    /**
     * Visitor method for object of type PromoItemListDept.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param promoItemListDept the promotion item list for departments object
	 * to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PromoItemListDept promoItemListDept) throws Exception {
    }
    
    /**
     * Visitor method for object of type PromoMixAndMatch.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param promoMixAndMatch the promotion item list for PLUs object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PromoMixAndMatch promoMixAndMatch) throws Exception {
    }
    
    /**
     * Visitor method for object of type Tax
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param tax the TaxRate object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(Tax tax) throws Exception {
    }
    
    /**
     * Visitor method for object of type SoftKey.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param skey the SoftKey object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(SoftKey skey) throws Exception {
    }

    /**
     * Visitor method for object of type SalesConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param sc the SalesConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(SalesConfig sc) throws Exception {
    }
    
    /**
     * Visitor method for object of type PLUPromo.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param promo the PLUPromo object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PluPromo promo) throws Exception {
    }
    
    /**
     * Visitor method for object of type Mix.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param mix the Mix object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
//    public void visit(Mix mix) throws Exception {
//    }
        
    /**
     * Visitor method for object of type Match.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param match the Match object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
//    public void visit(Match match) throws Exception {
//    }
    
    /**
     * Visitor method for object of type NetCardName.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param netCard the NetCardName object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(NetCardName netCard) throws Exception {
    }   

	/**
     * Visitor method for object of type CouponFam.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param couponFam the CouponFam object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(CouponFam couponFam) throws Exception {
    }
    /**
     * Visitor method for object of type CouponConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param couponConfig the CouponConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    /**
     * Visitor method for object of type DiscountDenom.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param discountdenom the DiscountDenom object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(DiscountDenom discountdenom) throws Exception {
    }

    
    /**
     * Visitor method for object of type PeriodType.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param periodType the PeriodType object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(PeriodType periodType) throws Exception {
    }
    
    /**
     * Visitor method for object of type CouponConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param couponConfig the CouponConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

	public void visit(CouponConfig couponConfig) throws Exception {
	}	
    /**
     * Visitor method for object of type CouponMsg.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param couponMsg the CouponMsg object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(CouponMsg couponMsg) throws Exception {
    }
    
    /**
     * Visitor method for object of type CarWashConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param carWashConfig the CarWashConfig object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(CarWashConfig carWashConfig) throws Exception {
    }

    /**
     * Visitor method for object of type CarWashPaypointConfig.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param match the NetCardName object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

    public void visit(CarWashPaypointConfig carWashPaypointConfig) throws Exception {
    }

    /**
     * Visitor method for object of type LogInOut.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param logInOut the LogInOut object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    
    public void visit(LogInOut logInOut) throws Exception {
    }
    
    /**
     * Visitor method for object of type PopDefinition.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param popDefinition the PopDefinition object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PopDefinition popDefinition) throws Exception {
    }
    
    /**
     * Visitor method for object of type PopDiscount.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param popDiscount the PopDiscount object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PopDiscount popDiscount) throws Exception {
    }
    
    /**
     * Visitor method for object of type PopSiteInfo.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param popSiteInfo the PopSiteInfo object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(PopSiteInfo popSiteInfo) throws Exception {
    }
    
    /**
     * Visitor method for object of type TlsSiteInfo.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param tlsSiteInfo the TlsSiteInfo object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(TlsSiteInfo tlsSiteInfo) throws Exception {
    }    
    
    /**
     * Visitor method for object of type CheckLine.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param checkLine the CheckLine object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(CheckLine checkLine) throws Exception {
    }    
    
    /**
     * Visitor method for object of type FuelTaxEx.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param taxEx the FuelTaxEx object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(FuelTaxEx taxEx) throws Exception {
    }    

    /**
     * Visitor method for object of type FuelTaxRcpt.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param taxRcpt the FuelTaxRcpt object to be visited
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */
    public void visit(FuelTaxRcpt taxRcpt) throws Exception {
    }
   
    /**
     * @param catTracking the catTracking object to be visited
     * @throws Exception
     */
    public void visit(CatTracking catTracking) throws Exception {
    }    
    /**
     * @param deptTracking
     * @throws Exception
     */
    public void visit(DeptTracking deptTracking) throws Exception {
    }    
    /**
     * @param pluTracking 
     * @throws Exception
     */
    public void visit(PluTracking pluTracking) throws Exception {
    }    
    
    /**
	 * Visitor method for an in-house account number record
	 * @param inhouseAcct
	 * @throws Exception
	 */
	public void visit(InHouseAcct inhouseAcct) throws Exception {
	}
	
	public void visit(VendingConfig vendingConfig) throws Exception {
	}
	
    /**
	 * Visitor method for APT Global Config
	 * @param aptGlobalConfig
	 * @throws Exception
	 */
	public void visit(APTGlobalConfig aptGlobalConfig) throws Exception {
	}

    /**
	 * Visitor method for APT/Vista Payment Code Config
	 * @param mOPCodeConfig
	 * @throws Exception
	 */
	public void visit(MOPCodeConfig mOPCodeConfig) throws Exception {
	}

    /**
	 * Visitor method for APT Global Department Config
	 * @param aptDepartmentConfig
	 * @throws Exception
	 */
	public void visit(APTDepartmentConfig aptDepartmentConfig) throws Exception {
	}

    /**
	 * Visitor method for APT Terminal Config
	 * @param aptTerminalConfig
	 * @throws Exception
	 */
	public void visit(APTTerminalConfig aptTerminalConfig) throws Exception {
	}

    /**
	 * Visitor method for APT/Vista Terminal Header/Trailer Config
	 * @param headerTrailerMsgConfig
	 * @throws Exception
	 */
	public void visit(HeaderTrailerMsgConfig headerTrailerMsgConfig) throws Exception {
	}

    /**
	 * Visitor method for APT Terminal Fueling Position Config
	 * @param aptFuelingPositionConfig
	 * @throws Exception
	 */
	public void visit(APTAllowedFPConfig aptFuelingPositionConfig) throws Exception {
	}
	
	/**
	 * Visitor method for APT Terminal Allowed Transactions Config
	 * @param aptAllowedTransConfig
	 * @throws Exception
	 */
	public void visit(APTAllowedOperationsConfig aptAllowedTransConfig) throws Exception {
	}

    /**
     * Visitor method for POP Auto Code Generation
     * @param autoPopCode
     * @throws Exception
     */
    public void visit(PopAwardGenDetail autoPopCode) throws Exception {
    }

    /* Visitor method for Vista Terminal Header/Trailer Config
	 * @param vistaHeaderTrailerMsgConfig
	 * @throws Exception
	 */
	public void visit(VistaTerminal vistaTerminal) throws Exception {
	}

    /**
	 * Visitor method for Vista Group Department Config
	 * @param vistaDepartmentConfig
	 * @throws Exception
	 */
	public void visit(VistaDepartmentConfig vistaDepartmentConfig) throws Exception {
	}
    /**
	 * Visitor method for Vista Group Config Config
	 * @param vistaGroupConfig
     * @throws Exception 
	 * @throws Exception
	 */
	public void visit(VistaGroupConfig vistaGroupConfig) throws Exception {
	}
    /**
     * Visitor method for object of type Menu.
     * Default behavior is no-op. To be implemented by subclasses if
     * specific xml serialization is reqd.
     * @param menu the Menu object to be visited
     * @throws SAXException 
     * @exception org.xml.sax.Exception thrown by visitor if any
     * error is encountered
     */

	public void visit(VistaMenuConfig vistaMenuConfig) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
    /**
	 * Visitor method for Vista Item Subset Config
	 * @param VistaItemSubsetConfig
     * @throws Exception 
	 */
	public void visit(VistaItemSubsetConfig vistaItemSubsetConfig) throws Exception {
	}

    /**
	 * Visitor method for Vista Item Subset Item Config
	 * @param VistaItemSubsetItemConfig
     * @throws Exception 
	 */
	public void visit(VistaItemSubsetItemConfig vistaItemSubsetItemConfig) throws Exception {
	}

    /**
	 * Visitor method for Vista Itemset Config
	 * @param VistaItemSubsetConfig
     * @throws Exception 
	 */
	public void visit(VistaItemsetConfig vistaItemsetConfig) throws Exception {
	}

    /**
	 * Visitor method for Vista Itemset Subset Item Config
	 * @param VistaItemSubsetItemConfig
     * @throws Exception 
	 */
	public void visit(VistaItemsetSubsetConfig vistaItemsetSubsetConfig) throws Exception {
	}
	
	/**
	 * Visitor method for Vista Terminal Preview Config
	 * @param VistaTerminalPreviewConfig
     * @throws Exception 
	 */
	public void visit(VistaTerminalPreviewConfig vistaTerminalPreviewConfig) throws Exception {
	}
	
	/**
	 * Visitor method for Vista Terminal Preview Itemset Config
	 * @param VistaTerminalPreviewItemsetConfig
     * @throws Exception 
	 */
	public void visit(VistaTerminalPreviewItemsetConfig vistaTerminalPreviewItemsetConfig) throws Exception {
	}
	
	/**
	 * Visitor method for Image Config
	 * @param Image Config
         * @throws Exception 
	 */
	public void visit(ImageConfig imageConfig) throws Exception {
	}

	
	/**
	 * Visitor method for charity configuration
	 * @param charity
	 * @throws Exception
	 */
	public void visit(Charity charity) throws Exception{
		
	}
	
	/**
	 * Visitor method for SoftKeyType Security Config
	 * 
	 * @param softKeyTypeSecurityConfig
	 * @throws Exception
	 */
	public void visit(SoftKeyTypeSecurityConfig softKeyTypeSecConfig) throws SAXException {

	}
	
}

