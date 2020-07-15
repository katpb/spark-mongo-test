/**
 * 
 */
package com.verifone.isd.vsms2.net.ent.eps;

import java.util.LinkedList;
import java.util.List;

import com.verifone.isd.vsms2.sys.l10n.ForeCourtRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * @author Raghavendra_R1
 *
 */
public class NetLoyaltyConfig {
	
    private List<LoyaltyProgramConfig> loyaltyPrograms;
	private String rewardsButtonLabel;
	private String defaultRewardsLabel;
	
	/**
	 * 
	 */
	public NetLoyaltyConfig() {
		this.loyaltyPrograms = new LinkedList<LoyaltyProgramConfig>();
		this.defaultRewardsLabel = LocalizedRB.getForeCourtRes(ForeCourtRes.DCR_DEFAULT_REWARDS_BUTTON_LABEL);
	}

	/**
	 * @return the loyaltyPrograms
	 */
	public List<LoyaltyProgramConfig> getLoyaltyPrograms() {
		return loyaltyPrograms;
	}
	
	/**
	 * @param loyaltyPrograms the loyaltyPrograms to set
	 */
	public void setLoyaltyPrograms(List<LoyaltyProgramConfig> loyaltyPrograms) {
		this.loyaltyPrograms = loyaltyPrograms;
	}
	
	/**
	 * @return the rewardsButtonLabel
	 */
	public String getRewardsButtonLabel(boolean getDefaultIfNull) {
		String label = null;
		/*
         * If only one loyalty program is configured, indicate it in the idle
         * screen instead of generic rewards button label
         */
         if ((loyaltyPrograms != null) && (loyaltyPrograms.size() == 1)) {
                LoyaltyProgramConfig singleProgram = loyaltyPrograms.get(0);
                if ((singleProgram != null)
                             && (singleProgram.getProgramName() != null)
                             && !singleProgram.getProgramName().isEmpty()) {
                      label = singleProgram.getProgramName();
                      return label;
                }
         }

		if((null != rewardsButtonLabel) && !rewardsButtonLabel.isEmpty()) {
			label = rewardsButtonLabel;
		} else if(getDefaultIfNull) {
			label = defaultRewardsLabel;
		}
		return label;
	}
	
	/**
	 * @param rewardsButtonLabel the rewardsButtonLabel to set
	 */
	public void setRewardsButtonLabel(String rewardsButtonLabel) {
		this.rewardsButtonLabel = rewardsButtonLabel;
	}
	
	public LoyaltyProgramConfig getLoyaltyProgram(String programName) {
		
		LoyaltyProgramConfig program = null;
		for(LoyaltyProgramConfig element : this.loyaltyPrograms) {
			if(element.getProgramName().equals(programName)) {
				program = element;
				break;
			}
		}
		
		return program;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetLoyaltyConfig ["
				+ (loyaltyPrograms != null ? "loyaltyPrograms="
						+ loyaltyPrograms + ", " : "")
				+ (rewardsButtonLabel != null ? "rewardsButtonLabel="
						+ rewardsButtonLabel : "") + "]";
	}
}
