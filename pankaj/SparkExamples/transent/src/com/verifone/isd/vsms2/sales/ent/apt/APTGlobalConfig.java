package com.verifone.isd.vsms2.sales.ent.apt;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.MOPCodeConfig;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;

/**
 * Entity class for APT Global Config
 * 
 * @author MadhusudhanB1
 *
 */
public class APTGlobalConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 4224126802214079846L;
	private boolean loginForEveryTransaction;
	private int loginTimeout;
	private boolean cashierReceiptRequired;
	private int presetSecurityLevel;
	List<MOPCodeConfig> enabledMOPCodes;
	List<APTDepartmentConfig> enabledDepartments;

	public static final int MAX_LOGIN_TIOMOUT = 15;

	public APTGlobalConfig() {
		enabledMOPCodes = new ArrayList<MOPCodeConfig>();
		enabledDepartments = new ArrayList<APTDepartmentConfig>();
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return null;
	}

	@Override
	public void setPK(IEntityPK pk) {
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		APTGlobalConfig aptGlobalConfig = (APTGlobalConfig) obj;
		
		aptGlobalConfig.setLoginForEveryTransaction(this.loginForEveryTransaction);
		aptGlobalConfig.setLoginTimeout(this.loginTimeout);
		aptGlobalConfig.setCashierReceiptRequired(this.cashierReceiptRequired);
		aptGlobalConfig.setPresetSecurityLevel(this.presetSecurityLevel);
		aptGlobalConfig.setEnabledMOPCodes(this.enabledMOPCodes);
		aptGlobalConfig.setEnabledDepartments(this.enabledDepartments);
	}

	@Override
	public void validate() throws Exception {
		if(this.loginTimeout < 0 || this.loginTimeout > MAX_LOGIN_TIOMOUT) {
			throw new Exception("Invalid Login Timeout : " + this.loginTimeout);
		}
		if(SecurityLevel.getObject(this.presetSecurityLevel) == null) {
			throw new Exception("Invalid Security Level : " + this.presetSecurityLevel);
		}
	}

	@Override
	public boolean isPKValid() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof APTGlobalConfig)) {
			return false;
		}
		APTGlobalConfig aptConfig = (APTGlobalConfig) obj;

		if(this.loginForEveryTransaction != aptConfig.loginForEveryTransaction) {
			return false;
		}
		if(this.loginTimeout != aptConfig.loginTimeout) {
			return false;
		}
		if(this.cashierReceiptRequired != aptConfig.cashierReceiptRequired) {
			return false;
		}
		if(this.presetSecurityLevel != aptConfig.presetSecurityLevel) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 10;
		hash = 77 * hash + this.loginTimeout;
		hash = 77 * hash + this.presetSecurityLevel;
		return hash;
	}
	
	public boolean isLoginForEveryTransaction() {
		return loginForEveryTransaction;
	}

	public void setLoginForEveryTransaction(boolean loginForEveryTransaction) {
		this.loginForEveryTransaction = loginForEveryTransaction;
	}

	public int getLoginTimeout() {
		return loginTimeout;
	}

	public void setLoginTimeout(int loginTimeout) {
		this.loginTimeout = loginTimeout;
	}

	public boolean isCashierReceiptRequired() {
		return cashierReceiptRequired;
	}

	public void setCashierReceiptRequired(boolean cashierReceiptRequired) {
		this.cashierReceiptRequired = cashierReceiptRequired;
	}

	public int getPresetSecurityLevel() {
		return presetSecurityLevel;
	}

	public void setPresetSecurityLevel(int presetSecurityLevel) {
		this.presetSecurityLevel = presetSecurityLevel;
	}
	
	public List<MOPCodeConfig> getEnabledMOPCodes() {
		return this.enabledMOPCodes;
	}
	
	public void setEnabledMOPCodes(List<MOPCodeConfig> mopCodes) {
		this.enabledMOPCodes = mopCodes;
	}
	
	public List<APTDepartmentConfig> getEnabledDepartments() {
		return enabledDepartments;
	}

	public void setEnabledDepartments(List<APTDepartmentConfig> enabledDepartments) {
		this.enabledDepartments = enabledDepartments;
	}
}
