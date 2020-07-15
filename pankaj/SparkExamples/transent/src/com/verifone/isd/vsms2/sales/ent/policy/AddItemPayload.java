package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * 
 * This class contains prompt and menuId details related to AddItem action.
 *
 */
public class AddItemPayload implements Serializable {

	private static final long serialVersionUID = -3240951735411890929L;
	
	private Prompt prompt;
	private String menuId;
	
	/**
	 * Getter for prompt
	 * @return
	 */
	public Prompt getPrompt() {
		return prompt;
	}
	
	/**
	 * Setter for prompt
	 * @param prompt
	 */
	public void setPrompt(Prompt prompt) {
		this.prompt = prompt;
	}
	
	/**
	 * Getter for menu ID
	 * @return
	 */
	public String getMenuId() {
		return menuId;
	}
	
	/**
	 * Setter for menu ID
	 * @param string
	 */
	public void setMenuId(String string) {
		this.menuId = string;
	}
	
}
