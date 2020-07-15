package com.verifone.isd.vsms2.sales.ent.vistadevice;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Terminal Preview Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaTerminalPreviewConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 6353620212572038455L;
	private VistaTerminalPreviewConfigPK pk;
	private boolean loyaltyMember;
	private String loyaltyLogo;
	private String memberInstructions;
	private boolean showHotItems;
	private String storeLogo;
	private String buttonColor;
	private List<VistaTerminalPreviewItemsetConfig> itemsets;

	public VistaTerminalPreviewConfig() {
		setItemsets(new ArrayList<VistaTerminalPreviewItemsetConfig>());
	}
	
	public VistaTerminalPreviewConfig(VistaTerminalPreviewConfigPK pk) {
		this.pk = pk;
		setItemsets(new ArrayList<VistaTerminalPreviewItemsetConfig>());
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
		this.pk = (VistaTerminalPreviewConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaTerminalPreviewConfig terminalPreviewConfig = (VistaTerminalPreviewConfig) obj;
		terminalPreviewConfig.setPK(pk);
		terminalPreviewConfig.setLoyaltyMember(loyaltyMember);
		terminalPreviewConfig.setLoyaltyLogo(loyaltyLogo);
		terminalPreviewConfig.setMemberInstructions(memberInstructions);
		terminalPreviewConfig.setStoreLogo(storeLogo);
		terminalPreviewConfig.setButtonColor(buttonColor);
		terminalPreviewConfig.setShowHotItems(showHotItems);
		terminalPreviewConfig.setItemsets(itemsets);
	}

	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid Terminal ID : " + this.pk.getId());
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaTerminalPreviewConfig)) {
			return false;
		}
		VistaTerminalPreviewConfig itemsetsCfg = (VistaTerminalPreviewConfig) obj;
		if(itemsetsCfg.getPK() == null || ((VistaTerminalPreviewConfigPK)itemsetsCfg.getPK()).getId() != this.pk.getId())
		{
			return false;
		}
		if(itemsetsCfg.isLoyaltyMember() != this.loyaltyMember) {
			return false;
		}
		if(itemsetsCfg.getLoyaltyLogo() == null || !itemsetsCfg.getLoyaltyLogo().equals(this.loyaltyLogo)) {
			return false;
		}
		if(itemsetsCfg.getMemberInstructions() == null || !itemsetsCfg.getMemberInstructions().equals(this.memberInstructions)) {
			return false;
		}
		if(itemsetsCfg.getStoreLogo() == null || !itemsetsCfg.getStoreLogo().equals(this.storeLogo)) {
			return false;
		}
		if(itemsetsCfg.getButtonColor() == null || !itemsetsCfg.getButtonColor().equals(this.buttonColor)) {
			return false;
		}
		if(itemsetsCfg.isShowHotItems() != this.showHotItems) {
			return false;
		}
		
		for(VistaTerminalPreviewItemsetConfig itemset : itemsetsCfg.getItemsets()) {
			if(!this.itemsets.contains(itemset)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 232;
		hash += hash * 23 + this.pk.getId();
		hash += hash * 4 + loyaltyLogo.length(); 
		hash += hash * 7 + memberInstructions.length();
		hash += hash * 9 + 	storeLogo.length();	
		return hash;
	}
	
	public boolean isLoyaltyMember() {
		return loyaltyMember;
	}

	public void setLoyaltyMember(boolean loyaltyMember) {
		this.loyaltyMember = loyaltyMember;
	}

	public String getLoyaltyLogo() {
		return loyaltyLogo;
	}

	public void setLoyaltyLogo(String loyaltyLogo) {
		this.loyaltyLogo = loyaltyLogo;
	}

	public String getMemberInstructions() {
		return memberInstructions;
	}

	public void setMemberInstructions(String memberInstructions) {
		this.memberInstructions = memberInstructions;
	}

	public boolean isShowHotItems() {
		return showHotItems;
	}

	public void setShowHotItems(boolean showHotItems) {
		this.showHotItems = showHotItems;
	}

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public List<VistaTerminalPreviewItemsetConfig> getItemsets() {
		return itemsets;
	}

	public void setItemsets(List<VistaTerminalPreviewItemsetConfig> itemsets) {
		this.itemsets = itemsets;
	}

	public String getButtonColor() {
		return buttonColor;
	}

	public void setButtonColor(String buttonColor) {
		this.buttonColor = buttonColor;
	}
}
