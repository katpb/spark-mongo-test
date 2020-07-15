package com.verifone.isd.vsms2.sales.ent.vendcfg;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *
 * @author T_JoshuaM2
 */
public class VendingConfig implements IEntityObject, ISalesEntityVisitable, IVendingConfig {

	private static final long serialVersionUID = -2513432403539904142L;

	private VendingConfigPK pk;

	private boolean enabled;
	private boolean promptBefore;
	private boolean promptAfter;
	private boolean forceBothPrompts;
	private boolean alwaysAuthorize;
	private boolean forcePrefuelVend;
        private int columns;
	private VendingPromoMessage promoMessage;
	private String controllerIP;
	private int clientPort, serverUDPPort;
	private String serviceNumber;
        private String driverType;
	private MoneyAmount authorizeLimit;
	private int userTimeout;
	private Map<Integer, VendingIsland> vendingIslandsMap;

	/**
	 * Initial state is every option false and the authorization limit $0.00.
	 */
	public VendingConfig() {
		authorizeLimit = new MoneyAmount("0.00");
		promoMessage = new VendingPromoMessage();
		vendingIslandsMap = new TreeMap<Integer, VendingIsland>();
		driverType = "NONE";
	}

	@Override
	public String getDriverType() {
                /**
                 * Until driver type is a field in the DB/ConfigClient then
                 * 'enabled' will act as the switch between VENDGOGH and NONE.
                 * If in the future there is another vendor then ConfigClient
                 * should offer to select which vendor/driver is required and
                 * setDriverType should be added to this class and this method
                 * altered to return driverType.
                 */
		return enabled ? "VENDGOGH" : "NONE";
	}

	@Override
	public boolean isForceBothPrompts() {
		return forceBothPrompts;
	}

	@Override
	public void setForceBothPrompts(boolean forceBothPrompts) {
		this.forceBothPrompts = forceBothPrompts;
	}

	@Override
	public VendingPromoMessage getPromoMessage() {
		return promoMessage;
	}

	public void setPromoMessage(VendingPromoMessage promoMessage) {
		this.promoMessage = promoMessage;
	}

	@Override
	public String getControllerIP() {
		return controllerIP;
	}

	@Override
	public void setControllerIP(String controllerIP) {
		this.controllerIP = controllerIP;
	}

	@Override
	public int getClientPort() {
		return clientPort;
	}

	@Override
	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}

	@Override
	public int getServerUDPPort() {
		return serverUDPPort;
	}

	public void setServerUDPPort(int serverUDPPort) {
		this.serverUDPPort = serverUDPPort;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	@Override
	public int getUserTimeout() {
		return userTimeout;
	}

	@Override
	public void setUserTimeout(int userTimeout) {
		this.userTimeout = userTimeout;
	}

	@Override
	public Map<Integer, VendingIsland> getVendingIslands() {
		return vendingIslandsMap;
	}

	public void setVendingIslands(Map<Integer, VendingIsland> vendingIslands) {
		this.vendingIslandsMap = vendingIslands;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isPromptBefore() {
		return promptBefore;
	}

	@Override
	public void setPromptBefore(boolean promptBefore) {
		this.promptBefore = promptBefore;
	}

	@Override
	public boolean isPromptAfter() {
		return promptAfter;
	}

	@Override
	public void setPromptAfter(boolean promptAfter) {
		this.promptAfter = promptAfter;
	}

	@Override
	public boolean isAlwaysAuthorize() {
		return alwaysAuthorize;
	}

	@Override
	public void setAlwaysAuthorize(boolean alwaysAuthorize) {
		this.alwaysAuthorize = alwaysAuthorize;
	}

	@Override
	public MoneyAmount getAuthorizeLimit() {
		return authorizeLimit;
	}

	@Override
	public void setAuthorizeLimit(MoneyAmount authorizeLimit) {
		this.authorizeLimit = authorizeLimit;
	}

	@Override
	public boolean isForcePrefuelVend() {
		return forcePrefuelVend;
	}

	@Override
	public void setForcePrefuelVend(boolean forcePrefuelVend) {
		this.forcePrefuelVend = forcePrefuelVend;
	}
        
        @Override
        public int getColumns() {
            return columns;
        }

        @Override
        public void setColumns(int count) {
            this.columns = count;
        }

	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (VendingConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {

		VendingConfig vendingObj = (VendingConfig) obj;

		vendingObj.setEnabled(this.isEnabled());
		vendingObj.setPromptBefore(this.isPromptBefore());
		vendingObj.setPromptAfter(this.isPromptAfter());
		vendingObj.setForceBothPrompts(this.isForceBothPrompts());
		vendingObj.setAlwaysAuthorize(this.isAlwaysAuthorize());
		vendingObj.setForcePrefuelVend(this.isForcePrefuelVend());
		vendingObj.setAuthorizeLimit(this.getAuthorizeLimit());
		vendingObj.setUserTimeout(this.getUserTimeout());
		vendingObj.setPromoMessage(this.getPromoMessage());
		vendingObj.setControllerIP(this.getControllerIP());
		vendingObj.setClientPort(this.getClientPort());
		vendingObj.setServerUDPPort(this.getServerUDPPort());
		vendingObj.setServiceNumber(this.getServiceNumber());
		vendingObj.setVendingIslands(this.getVendingIslands());
	}

	@Override
	public void validate() throws Exception {
		// TODO
	}

	@Override
	public boolean isPKValid() {
		return true;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" Enabled = ").append(isEnabled());
		sb.append(" | PromotBefore = ").append(isPromptBefore());
		sb.append(" | PromotAfter = ").append(isPromptAfter());
		sb.append(" | ForceBothPrompts = ").append(isForceBothPrompts());
		sb.append(" | AlwaysAuthorize = ").append(isAlwaysAuthorize());
		sb.append(" | isForcePrefuelVend = ").append(isForcePrefuelVend());
		sb.append(" | authorizeLimit = "+(getAuthorizeLimit() != null ? getAuthorizeLimit().getLongValue() : 0));
		sb.append(" | userTimeout = ").append(getUserTimeout());
		sb.append(" | serviceNumber = ").append(getServiceNumber());
		sb.append(" | controllerIP = ").append(getControllerIP());
		sb.append(" | clientPort = ").append(getClientPort());
		sb.append(" | UDPPort = ").append(getServerUDPPort());
		sb.append(" | PromoMessage = ").append(getPromoMessage());
		
		for(Entry<Integer, VendingIsland> island : getVendingIslands().entrySet()) {
			
			sb.append(" | Island ").append(island.getKey()).append(" ").append(island.getValue());
		}
		
		return sb.toString();
		
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + (this.pk != null ? this.pk.hashCode() : 0);
		hash = 37 * hash + (this.enabled ? 1 : 0);
		hash = 37 * hash + (this.promptBefore ? 1 : 0);
		hash = 37 * hash + (this.promptAfter ? 1 : 0);
		hash = 37 * hash + (this.forceBothPrompts ? 1 : 0);
		hash = 37 * hash + (this.alwaysAuthorize ? 1 : 0);
		hash = 37 * hash + (this.forcePrefuelVend ? 1 : 0);
		hash = 37 * hash + (this.promoMessage != null ? this.promoMessage.hashCode() : 0);
		hash = 37 * hash + (this.controllerIP != null ? this.controllerIP.hashCode() : 0);
		hash = 37 * hash + this.clientPort;
		hash = 37 * hash + this.serverUDPPort;
		hash = 37 * hash + (this.serviceNumber != null ? this.serviceNumber.hashCode() : 0);
		hash = 37 * hash + (this.driverType != null ? this.driverType.hashCode() : 0);
		hash = 37 * hash + (this.authorizeLimit != null ? this.authorizeLimit.hashCode() : 0);
		hash = 37 * hash + this.userTimeout;
		hash = 37 * hash + (this.vendingIslandsMap != null ? this.vendingIslandsMap.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VendingConfig other = (VendingConfig) obj;
		if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
			return false;
		}
		if (this.enabled != other.enabled) {
			return false;
		}
		if (this.promptBefore != other.promptBefore) {
			return false;
		}
		if (this.promptAfter != other.promptAfter) {
			return false;
		}
		if (this.forceBothPrompts != other.forceBothPrompts) {
			return false;
		}
		if (this.alwaysAuthorize != other.alwaysAuthorize) {
			return false;
		}
		if (this.forcePrefuelVend != other.forcePrefuelVend) {
			return false;
		}
		if (this.promoMessage != other.promoMessage && (this.promoMessage == null || !this.promoMessage.equals(other.promoMessage))) {
			return false;
		}
		if ((this.controllerIP == null) ? (other.controllerIP != null) : !this.controllerIP.equals(other.controllerIP)) {
			return false;
		}
		if (this.clientPort != other.clientPort) {
			return false;
		}
		if (this.serverUDPPort != other.serverUDPPort) {
			return false;
		}
		if ((this.serviceNumber == null) ? (other.serviceNumber != null) : !this.serviceNumber.equals(other.serviceNumber)) {
			return false;
		}
		if ((this.driverType == null) ? (other.driverType != null) : !this.driverType.equals(other.driverType)) {
			return false;
		}
		if (this.authorizeLimit != other.authorizeLimit && (this.authorizeLimit == null || !this.authorizeLimit.equals(other.authorizeLimit))) {
			return false;
		}
		if (this.userTimeout != other.userTimeout) {
			return false;
		}
		if (this.vendingIslandsMap != other.vendingIslandsMap && (this.vendingIslandsMap == null || !this.vendingIslandsMap.equals(other.vendingIslandsMap))) {
			return false;
		}
		return true;
	}

}
