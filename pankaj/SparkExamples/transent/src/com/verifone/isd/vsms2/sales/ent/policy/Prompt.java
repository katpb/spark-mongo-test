package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * This class contains the prompt values related AddItem action.
 * 
 * 
 */
public class Prompt implements Serializable {

	private static final long serialVersionUID = -8141303066602694142L;
	private String promptMsg;
	private PromptType promptType;

	/**
	 * Getter for prompt message
	 * 
	 * @return
	 */
	public String getPromptMsg() {
		return promptMsg;
	}

	/**
	 * Setter for prompt message
	 * 
	 * @param promptMsg
	 */
	public void setPromptMsg(String promptMsg) {
		this.promptMsg = promptMsg;
	}

	/**
	 * Getter for prompt type
	 * 
	 * @return
	 */
	public PromptType getPromptType() {
		return promptType;
	}

	/**
	 * Setter for prompt type
	 * 
	 * @param prompType
	 */
	public void setPromptType(PromptType promptType) {
		this.promptType = promptType;
	}

}
