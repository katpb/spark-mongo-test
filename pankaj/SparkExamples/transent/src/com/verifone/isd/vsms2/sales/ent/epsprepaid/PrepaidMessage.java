/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.epsprepaid;

import java.io.Serializable;

/**
 * @author T_ShivrajS1
 *
 */
public class PrepaidMessage implements Serializable{

	private String message;
	private boolean enabled;
	private PrepaidMessageTypeEnum messageType;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the messageType
	 */
	public PrepaidMessageTypeEnum getMessageType() {
		return messageType;
	}
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(PrepaidMessageTypeEnum messageType) {
		this.messageType = messageType;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
