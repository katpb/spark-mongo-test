package com.verifone.isd.vsms2.sales.ent.policy;

/**
 * Enumeration for prompt type. 
 *
 */
public enum PromptType {

	YES_NO("YES_NO"), OK_CANCEL("OK_CANCEL"), OK("OK");

	private String promptValue;

	public String getPromptValue() {
		return promptValue;
	}

	PromptType(String promptValue) {
		this.promptValue = promptValue;
	}

	/**
	 * Return PromptType based on the value.
	 * 
	 * @param promptValue
	 * @return
	 */
		
	public static PromptType getPromptType(String promptValue) {
		if (promptValue != null) {
			try {
				return PromptType.valueOf(promptValue.trim().toUpperCase());
			} catch (IllegalArgumentException iae) {
			}
		}
		return null;
	}
	
}
