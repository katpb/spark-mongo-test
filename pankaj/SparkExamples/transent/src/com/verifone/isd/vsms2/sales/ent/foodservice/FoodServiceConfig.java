package com.verifone.isd.vsms2.sales.ent.foodservice;

import java.io.Serializable;
/***
 * Holds the Food Service Configuration Parameters
 * @author pravijak1
 *
 */
public class FoodServiceConfig implements Serializable {
	private static final long serialVersionUID = 8827678828455497210L;
	private boolean sendToKDS;
	private String kioskIP;
	private String kioskPort;
	private boolean printTicket;
	private String customMsg;
	private boolean isPmntNotfnEnabled;
	public static final String FOODSRV_FILENAME = "foodservcfg.xml";
	
	public FoodServiceConfig(){
		
	}
	
	/**
	 * Specifies whether the POS food service order details should be 
	 * sent to iOrder or not
	 * @return
	 */
	public boolean isSendToKDS() {
		return sendToKDS;
	}
	/**
	 * sets the Food Service "Send the POS Food Orders to KDS" flag
	 * @param sendToKDS
	 */
	public void setSendToKDS(boolean sendToKDS) {
		this.sendToKDS = sendToKDS;
	}
	
	/**
	 * Getter for iOrder Kiosk IPAddress
	 * @return
	 */
	
	public String getKioskIP() {
		return kioskIP;
	}
	/**
	 * setter for iOrder Kiosk IPAddress
	 * @param kioskIP
	 */
	public void setKioskIP(String kioskIP) {
		this.kioskIP = kioskIP;
	}
	
	/**
	 * getter for iOrder Kiosk port
	 * @return
	 */
	public String getKioskPort() {
		return kioskPort;
	}
	/**
	 * Setter for iOrder Kiosk port
	 * @param kioskPort
	 */
	public void setKioskPort(String kioskPort) {
		this.kioskPort = kioskPort;
	}
	
	/**
	 * Specifies whether food service Payment ticket
	 * should be printed at POS Printer or not
	 * 
	 * @return
	 */
	public boolean isPrintTicket() {
		return printTicket;
	}
	/**
	 * Specifies whether electronic notification is enabled or not
	 * for food service orders
	 * 
	 * @return
	 */
	public boolean isPmntNotfnEnabled() {
		return isPmntNotfnEnabled;
	}
	
	/**
	 * setter for electronic payment notification of food service orders
	 * @param isPmntNotfnEnabled
	 */
	public void setPmntNotfnEnabled(boolean isPmntNotfnEnabled) {
		this.isPmntNotfnEnabled = isPmntNotfnEnabled;
	}
	
	/**
	 * setter for printing the Food service payment receipt
	 * @param printTicket
	 */
	public void setPrintTicket(boolean printTicket) {
		this.printTicket = printTicket;
	}
	/**
	 * getter for custom message configured to print on 
	 * food service payment receipts
	 * @return
	 */
	public String getCustomMsg() {
		return customMsg;
	}
	/**
	 * setter for custom message configured to print on 
	 * food service payment receipts
	 * @param customMsg
	 */
	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}
	/**
	 * Returns string representation of Food Service Configuration
	 */
	public String toString(){
		return "FoodServiceConfig: [iOrderIP :"+ this.kioskIP + ",iOrderPort:" + this.kioskPort + ",sendToKDS : " + 
				this.sendToKDS + ",ElectronicNotificationEnbled  :" + this.isPmntNotfnEnabled +
				",PrintTicket : "+this.printTicket + ",ReceiptMessage : " + this.customMsg + "]"; 
	}
	
}
