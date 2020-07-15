package com.verifone.isd.vsms2.sys.ent.securityctrl;

import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;


/**
 *  entity class for Security control
 *
 *  @author "mailto:bhanu_n2@verifone.com"
 */
public class SecurityCtrl implements IEntityObject, ISystemEntityVisitable {
    static final long serialVersionUID = -2454781461478109739L;
    
    private SecurityCtrlPK ID;
    private SecurityLevel secLevel;
    private SecurityCtrlPK parentID;
    
    public static final int MIN_SECURITY_LEVEL = 0;
    public static final int MAX_SECURITY_LEVEL = 9;

    private static final String CONFIG_FNS      = "CFG";
    private static final String CAR_WASH_FNS    = "CWA";
    private static final String DCR_CONFIG_FNS  = "DCR";
    private static final String FLASH_RPT_FNS   = "FSH";
    private static final String FUEL_MGR_FNS    = "FUE";
    private static final String MAINT_FNS       = "MNT";
    private static final String NETWORK_MGR_FNS = "NET";
    private static final String RPT_FNS         = "RPT";
    private static final String SECURITY_FNS    = "SEC";
    private static final String SYS_MGR_FNS     = "SYS";
    private static final String TAVE_CFG_FNS    = "TCF";
    private static final String UNATTENDED_CFG_FNS = "UCF";
    
    private static final String SEC_SYS_MGR     = "SMF";
    private static final String SEC_FUEL_MGR    = "FMF";
    private static final String SEC_CONFIG      = "CFN";
    private static final String SEC_RPT         = "RFN";
    private static final String SEC_FLASH_RPT   = "FRF";
    private static final String SEC_MAINT       = "MFN";
    private static final String SEC_SECURITY    = "SFN";
    private static final String SEC_CAR_WASH    = "CWF";
    private static final String SEC_NETWORK_MGR = "NMF";
    private static final String SEC_DCR         = "DCF";
    private static final String SEC_VERIPASS    = "VPF";
    private static final String SEC_TAVE_CFG    = "TSF";
    private static final String SEC_UNATTENDED_CFG = "USF";
    
    public SecurityCtrl(SecurityCtrlPK ID, SecurityLevel secLevel) {
        this.ID = ID;
        this.secLevel = secLevel;
    }
    
    public SecurityCtrl() {
    }
    
    public SecurityLevel getSecurityLevel() {
        if (this.secLevel == null) {
            this.secLevel = SecurityLevel.MAXIMUM;
        }
        return this.secLevel;
    }
    
    public void setSecurityLevel(SecurityLevel secLevel) {
        this.secLevel = secLevel;
    }
    
    /*
    public void accept(DataSetXMLVisitor v) throws SAXException {
        v.visit(this);
    }
     */
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        SecurityCtrl cObj = (SecurityCtrl) obj;
        cObj.setPK(this.getPK());
        cObj.setSecurityLevel(this.getSecurityLevel());
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (SecurityCtrlPK)pk;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid security ctrl: " +this.ID);
        }  
        if (this.secLevel == null) {
            throw new Exception("Invalid security level for security ctrl: " +this.ID);
        }        
    }
    
    public SecurityCtrlPK getParentPK() {
        if (this.parentID != null) {
            return this.parentID;
        }
        String menuID = this.ID.getMenuId();
        String subMenuID = this.ID.getSubMenuId();
        if ((menuID.equals(SYS_MGR_FNS)) && (subMenuID.equals(SECURITY_FNS))) {
            return null;
        }
        else {
            String[] pID = new String[2];
            if (menuID.equals(CONFIG_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_CONFIG;
            }
            else if (menuID.equals(CAR_WASH_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_CAR_WASH;
            }
            else if (menuID.equals(DCR_CONFIG_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_DCR;
            }
            else if (menuID.equals(FLASH_RPT_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_FLASH_RPT;
            }
            else if (menuID.equals(FUEL_MGR_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_FUEL_MGR;
            }
            else if (menuID.equals(MAINT_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_MAINT;
            }
            else if (menuID.equals(NETWORK_MGR_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_NETWORK_MGR;
            }
            else if (menuID.equals(RPT_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_RPT;
            }
            else if (menuID.equals(SECURITY_FNS)) {
                pID[0] = SYS_MGR_FNS;
                pID[1] = SECURITY_FNS;
            }
            else if (menuID.equals(SYS_MGR_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_SYS_MGR;
            }
            else if (menuID.equals(TAVE_CFG_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_TAVE_CFG;
            }
            else if(menuID.equals(UNATTENDED_CFG_FNS)) {
                pID[0] = SECURITY_FNS;
                pID[1] = SEC_UNATTENDED_CFG;
            }
            else // If no parent, at least validate for security ctrl menu access.
            {
                pID[0] = SYS_MGR_FNS;
                pID[1] = SECURITY_FNS;
            }
            this.parentID = new SecurityCtrlPK(pID[0], pID[1]);
            return this.parentID;
        }
    }    
    
    public void accept(ISystemEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    public boolean isReadOnly() {
        if (this.isPKValid()) {
            return Character.isLowerCase(this.ID.getMenuId().charAt(0));
        }
        return true; //Err on the safer side, if PK is null/ invalid
    }
 }