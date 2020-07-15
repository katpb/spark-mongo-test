/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import java.util.List;

/**
 * @author anindya_d1
 *
 */
public class FuelingMessageDetails implements Serializable {
	private static final long serialVersionUID = -3520710625873689258L;
	
	private List<String> messages;
	private int displayTime;	// in seconds
	private boolean beep;		// whether to play audio
	private int beepDuration;
	private int beepCounter;
	private int pauseDuration;
	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	/**
	 * @return the beepDuration
	 */
	public int getBeepDuration() {
		return beepDuration;
	}
	/**
	 * @param beepDuration the beepDuration to set
	 */
	public void setBeepDuration(int beepDuration) {
		this.beepDuration = beepDuration;
	}
	/**
	 * @return the beepCounter
	 */
	public int getBeepCounter() {
		return beepCounter;
	}
	/**
	 * @param beepCounter the beepCounter to set
	 */
	public void setBeepCounter(int beepCounter) {
		this.beepCounter = beepCounter;
	}
	/**
	 * @return the pauseDuration
	 */
	public int getPauseDuration() {
		return pauseDuration;
	}
	/**
	 * @param pauseDuration the pauseDuration to set
	 */
	public void setPauseDuration(int pauseDuration) {
		this.pauseDuration = pauseDuration;
	}
	/**
	 * @return the displayTime
	 */
	public int getDisplayTime() {
		return displayTime;
	}
	/**
	 * @param displayTime the displayTime to set
	 */
	public void setDisplayTime(int displayTime) {
		this.displayTime = displayTime;
	}
	/**
	 * @return the beep
	 */
	public boolean isBeep() {
		return beep;
	}
	/**
	 * @param beep the beep to set
	 */
	public void setBeep(boolean beep) {
		this.beep = beep;
	}
}
