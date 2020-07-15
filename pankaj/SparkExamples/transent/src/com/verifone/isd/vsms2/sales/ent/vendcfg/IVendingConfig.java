package com.verifone.isd.vsms2.sales.ent.vendcfg;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import java.util.Map;

/**
 * Configuration options for the vending feature.
 *
 * @author T_JoshuaM2
 */
public interface IVendingConfig {

	//TODO add getters and setters for other elements too
	/**
	 *
	 * @return true if vending is enabled, false otherwise
	 */
	public boolean isEnabled();

	public void setEnabled(boolean enabled);
        
        public int getColumns();
        
        public void setColumns(int count);

	public String getControllerIP();

	public void setControllerIP(String controllerIP);

	public int getClientPort();

	public void setClientPort(int clientPort);

	public int getServerUDPPort();

	public int getUserTimeout();

	public void setUserTimeout(int userTimeout);

	public boolean isPromptBefore();

	public void setPromptBefore(boolean promptBefore);

	public boolean isPromptAfter();

	public void setPromptAfter(boolean promptAfter);

	public boolean isAlwaysAuthorize();

	public void setAlwaysAuthorize(boolean alwaysAuthorize);

	/**
	 * The amount of money available for vending per transaction.
	 *
	 * @return the amount available for vending
	 */
	public MoneyAmount getAuthorizeLimit();

	public void setAuthorizeLimit(MoneyAmount limit);

	public VendingPromoMessage getPromoMessage();

	public boolean isForcePrefuelVend();

	public void setForcePrefuelVend(boolean forcePrefuelVend);
	
	public boolean isForceBothPrompts();
	
	public void setForceBothPrompts(boolean forceBothPrompts);

	public Map<Integer, VendingIsland> getVendingIslands();

	public String getDriverType();
}
