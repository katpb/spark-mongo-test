package com.verifone.isd.vsms2.sys.ent.posfunction;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IReferenceDataSystem;
import com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory;
import com.verifone.isd.vsms2.sys.ent.BaseISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.BaseISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.function.FunctionCmdConstants;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityCtrl;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityCtrlPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.POSFunctionRes;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * 
 */
public class POSFunction implements java.io.Serializable, BaseISystemEntityVisitable {

	private static final long serialVersionUID = -3470524825796884927L;
	private static final Logger logger = LoggerFactory.getLogger(POSFunction.class);

	private String nameKey = null;
	private String command = null;
	private String longDescriptionKey = null;
	private SecurityCtrl securityCtrl;
	static protected Vector list = null;
	static private boolean isInitialized;
	private String resourceBundleName;
	static private ResourceBundle defaultBundle;
	
	// Security Controls identified for MWS
	private static final String MWS_MENUID 		= "MWS";	// Menu ID - Manager Workstation.
	private static final String VCP_SUBMENUID 	= "VCP";	// Sub Menu ID - View cashier period list.
	private static final String VMC_SUBMENUID 	= "VMC";	// Sub Menu ID - View MOP configuration.
	private static final String UCR_SUBMENUID 	= "UCR";	// Sub Menu ID - Update cashier reconciliation details.
	private static final String VCC_SUBMENUID 	= "VCC";	// Sub Menu ID - View cashier currency amounts.
	
	static{
		list = new Vector();
		 defaultBundle = LocalizedRB.getResourceBundle(LocalizedRB.POS_FUNCTION_RESOURCE, Locale.getDefault());     
	}
	
    private String getResourceString(String key, Locale reqdLocale) {
        String value = null;
        ResourceBundle rb = null;
        try {
            if (null == this.resourceBundleName && null == reqdLocale) {
                rb = POSFunction.defaultBundle;
            }
            else {
                String rbName = (this.resourceBundleName == null) ? LocalizedRB.POS_FUNCTION_RESOURCE : this.resourceBundleName;
                rb = LocalizedRB.getResourceBundle(rbName, reqdLocale);
            }
            value = rb.getString(key); 
        }
        catch (Exception e) {
            value = key;
        }
        return value;
    }

	POSFunction(String nameKey, String command, SecurityCtrl securityCtrl, String longDescriptionKey) {
		this.nameKey = nameKey;
		this.command = command;
		this.securityCtrl = securityCtrl;
		this.longDescriptionKey = longDescriptionKey;
		list.addElement(this);
	}

	public static synchronized void initialize() {
		if (!isInitialized) {
			logger.debug(">>>>>>>>>>> Initializing POS Function");
			LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.posfunction.POSFunction.class).info( "POSFunction#initialize() start");
			isInitialized = true;
			POSFunction.loadMWSPOSFunctions();
		}
	}

	private static void loadMWSPOSFunctions() {
			new POSFunction(POSFunctionRes.CMD_VCASHIERPDLIST,
					FunctionCmdConstants.CMD_VCASHIERPDLIST,
					getSecurityCtrl(MWS_MENUID, VCP_SUBMENUID),
					POSFunctionRes.CMD_VCASHIERPDLIST_DTL);

			new POSFunction(POSFunctionRes.CMD_VMOPCFG,
					FunctionCmdConstants.CMD_VMOPCFG,
					getSecurityCtrl(MWS_MENUID, VMC_SUBMENUID),
					POSFunctionRes.CMD_VMOPCFG_DTL);

			new POSFunction(POSFunctionRes.CMD_UCASHIERRECONDTLS,
					FunctionCmdConstants.CMD_UCASHIERRECONDTLS,
					getSecurityCtrl(MWS_MENUID, UCR_SUBMENUID),
					POSFunctionRes.CMD_UCASHIERRECONDTLS_DTL);

			new POSFunction(POSFunctionRes.CMD_VCASHIERDRAWERAMOUNTS,
					FunctionCmdConstants.CMD_VCASHIERDRAWERAMOUNTS,
					getSecurityCtrl(MWS_MENUID, VCC_SUBMENUID),
					POSFunctionRes.CMD_VCASHIERCURRAMTS_DTL);
	}

	@Override
	public void accept(BaseISystemEntityVisitor v) throws Exception {
	}

	/**
	 * @return the nameKey
	 */
	public String getNameKey() {
		  return this.getResourceString(this.nameKey, null);
	}

	/**
	 * @param nameKey the nameKey to set
	 */
	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the longDescriptionKey
	 */
	public String getLongDescriptionKey() {
		  return this.getResourceString(this.longDescriptionKey, null);
	}

	/**
	 * @param longDescriptionKey the longDescriptionKey to set
	 */
	public void setLongDescriptionKey(String longDescriptionKey) {
		this.longDescriptionKey = longDescriptionKey;
	}

	/**
	 * @return the securityCtrl
	 */
	public SecurityCtrl getSecurityCtrl() {
		return securityCtrl;
	}
	
	/**
	 * @return the securityCtrlDesc
	 */
	public String getSecurityCtrlDesc() {
		SecurityCtrlPK securityCtrlPK=(SecurityCtrlPK)securityCtrl.getPK();
		return getDescription(securityCtrlPK.getMenuId(), securityCtrlPK.getSubMenuId());
	}


	/**
	 * @param securityCtrl the securityCtrl to set
	 */
	public void setSecurityCtrl(SecurityCtrl securityCtrl) {
		this.securityCtrl = securityCtrl;
	}

	/**
	 * 
	 * @param menuID
	 * @param subMenuID
	 * @return
	 */
	public static SecurityCtrl getSecurityCtrl(String menuID, String subMenuID) {
		IEntityPersistAdmin securityPersistAdmin = null;
		IReferenceDataSystem refDataSystem = null;
		SecurityCtrl security = null;
		try {
			refDataSystem = ReferenceDataSystemFactory.getInstance();
			securityPersistAdmin=refDataSystem.getPersistAdmin(IReferenceDataSystem.SECURITY_CTRL);
			SecurityCtrlPK securityPK = new SecurityCtrlPK(menuID, subMenuID);
			security = new SecurityCtrl();
			security.setPK( securityPK);
			securityPersistAdmin.retrieve(security);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return security;
	}

	/**
	 * 
	 * @param command
	 * @return
	 */
	public static POSFunction get(String command) {
		Enumeration enumr = list.elements();
        while (enumr.hasMoreElements()) {
        	POSFunction curPosFn = (POSFunction) enumr.nextElement();
            if (curPosFn.command.equalsIgnoreCase(command)) {
                return curPosFn;
            }
        }
        return null;
	}
	
	/**
	 * 
	 * @return
	 */
    public static POSFunction[] getAllPOSFunctions() {
        return (POSFunction[])list.toArray(new POSFunction[0]);
    }
    
    /**
	 * returns localized description value for key.
	 * @param key - key 
	 * @return String
	 */
	private String getDescription(String menuId, String subMenuId) {
		String securityCtrlDesc = menuId + IXMLVocabulary.UNDERSCORE + subMenuId;
        try {
            securityCtrlDesc = LocalizedRB.getSecurityCtrlsRes(securityCtrlDesc, Locale.getDefault());
        }
        catch (Exception e) { 
            logger.error("Error in resource bundle lookup for: " + securityCtrlDesc + e);
        }
        return securityCtrlDesc;
    }
}
