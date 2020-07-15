 /*
 * NetDealerConfig.java
 *
 * Created on August 17, 2006, 9:27 AM
 */

package com.verifone.isd.vsms2.net.ent.eps;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.NetDealerConfigBase;
import com.verifone.isd.vsms2.net.ent.NetDealerConfigPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.util.SiteBrandType;

/**
 *
 * @author  Peder_K1
 */
public class NetDealerConfig extends NetDealerConfigBase implements Serializable
{
    static final long serialVersionUID = -7062245144290684223L;
    
    public static final int MAX_POP_ID = 5;
    
    protected boolean passwdForRefund;
    protected boolean checkAuthFlag;
    protected boolean popByCardTypeEnabled;
    protected int[] epsPopId;
    protected int epsRequestTo;
    protected int epsPosTo;
    protected int epsMaxRepetition;
    protected int epsMaxFrameLength;
    protected int epsMaxMessageLength;
    protected int epsCardTypeReport;
    protected SiteBrandType epsSiteBrand;    
   
  
   static {
        NetDealerConfigPK.setMaximumValue(MAX_DEALER_CONFIG_RECS);
        NetDealerConfigBase.setNameMaxLength(MAXNAMELEN);
        NetDealerConfigBase.setAddressMaxLength(MAXADDRLEN);
        NetDealerConfigBase.setCityMaxLength(MAXCITYLEN);
        NetDealerConfigBase.setStateMaxLength(MAXSTATELEN);
    }
   /** Creates a new instance of NetDealerConfig */
     public NetDealerConfig()
     {
         super();
         epsPopId = new int[MAX_POP_ID];
         epsSiteBrand = SiteBrandType.getObject(0);
     }
     
     public boolean getPasswdForRefund()
     {
         return this.passwdForRefund;
     }
     
     public void setPasswdForRefund(boolean passwdForRefund)
     {
         this.passwdForRefund = passwdForRefund;
     }
     
     public boolean getCheckAuthFlag()
     {
         return this.checkAuthFlag;
     }
     
     public void setCheckAuthFlag(boolean checkAuthFlag)
     {
         this.checkAuthFlag = checkAuthFlag;
     }
     
     public boolean getPopByCardTypeEnabled()
     {
         return this.popByCardTypeEnabled;
     }
     
     public void setPopByCardTypeEnabled(boolean popByCardTypeEnabled)
     {
         this.popByCardTypeEnabled = popByCardTypeEnabled;
     }
     
     public int getEpsPopId(int index) {
        return this.epsPopId[index];
    }
    public void setEpsPopId(int index, int id) {
        this.epsPopId[index] = id;
    }
    
     public int getEpsRequestTo() {
         return this.epsRequestTo;
     }
     
     public void setEpsRequestTo(int epsRequestTo) {
         this.epsRequestTo = epsRequestTo;
     }
     
     public int getEpsPosTo() {
         return this.epsPosTo;
     }
     
     public void setEpsPosTo(int epsPosTo) {
         this.epsPosTo = epsPosTo;
     }
     
     public int getEpsMaxRepetition() {
         return this.epsMaxRepetition;
     }
     
     public void setEpsMaxRepetition(int epsMaxRepetition) {
         this.epsMaxRepetition = epsMaxRepetition;
     }
     
     public int getEpsMaxFrameLength() {
         return this.epsMaxFrameLength;
     }
     
     public void setEpsMaxFrameLength(int epsMaxFrameLength) {
         this.epsMaxFrameLength = epsMaxFrameLength;
     }
     
     public int getEpsMaxMessageLength() {
         return this.epsMaxMessageLength;
     }
     
     public void setEpsMaxMessageLength(int epsMaxMessageLength) {
         this.epsMaxMessageLength = epsMaxMessageLength;
     }
     
     public int getEpsCardTypeReport() {
         return this.epsCardTypeReport;
     }
     
     public void setEpsCardTypeReport(int epsCardTypeReport) {
         this.epsCardTypeReport = epsCardTypeReport;
     }
     
     public SiteBrandType getEpsSiteBrand() {		
     	return epsSiteBrand;	
     }	
     
     public void setEpsSiteBrand(SiteBrandType epsSiteBrand) {		
     	this.epsSiteBrand = epsSiteBrand;	
     }     

     public void validate() throws Exception {
        super.validate();
        int i;
        
        for (i=0; i < MAX_POP_ID; i++) {
            if (this.epsPopId[i] != 0 && this.epsPopId[i] > 99) {
                throw new Exception("Invalid epsPopId"+(i+1)+": " +this.epsPopId[i]);
            }
        }
        if (this.epsRequestTo > 9999){
             throw new Exception("Invalid epsRequestTo: "+this.epsRequestTo);
        }
        if (this.epsPosTo > 999){
             throw new Exception("Invalid epsPosTo: "+this.epsPosTo);
        }
        if (this.epsMaxRepetition > 9){
             throw new Exception("Invalid epsMaxRepetition: "+this.epsMaxRepetition);
        }
        if (this.epsMaxFrameLength > 9999){
             throw new Exception("Invalid epsMaxFrameLength: "+this.epsMaxFrameLength);
        }
        if (this.epsMaxMessageLength > 9999){
             throw new Exception("Invalid epsMaxMessageLength: "+this.epsMaxMessageLength);
        }
        if (this.epsCardTypeReport > 999){
             throw new Exception("Invalid epsCardTypeReport: "+this.epsCardTypeReport);
        }
    }

    public void setAttributes(IEntityObject obj) {
        NetDealerConfig netDealerConfig = (NetDealerConfig)obj;
        super.setAttributes(netDealerConfig);
        
		netDealerConfig.setPasswdForRefund(this.passwdForRefund);
		netDealerConfig.setCheckAuthFlag(this.checkAuthFlag);
		netDealerConfig.setPopByCardTypeEnabled(this.popByCardTypeEnabled);
		netDealerConfig.setEpsPopId(0, this.epsPopId[0]);
		netDealerConfig.setEpsPopId(1, this.epsPopId[1]);
 		netDealerConfig.setEpsPopId(2, this.epsPopId[2]);
		netDealerConfig.setEpsPopId(3, this.epsPopId[3]);
		netDealerConfig.setEpsPopId(4, this.epsPopId[4]);
		netDealerConfig.setEpsRequestTo(this.epsRequestTo);
		netDealerConfig.setEpsPosTo(this.epsPosTo);
		netDealerConfig.setEpsMaxRepetition(this.epsMaxRepetition);
		netDealerConfig.setEpsMaxFrameLength(this.epsMaxFrameLength);
		netDealerConfig.setEpsMaxMessageLength(this.epsMaxMessageLength);
		netDealerConfig.setEpsCardTypeReport(this.epsCardTypeReport);
		// site brand configuration
		netDealerConfig.setEpsSiteBrand(this.epsSiteBrand);             
	}
    
    
}
