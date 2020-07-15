package com.verifone.isd.vsms2.fuel.ent;



public class DeviceVersionInformation {
	public static final int RESPONSE_HEADER_SIZE = 3;
	public static final int FUEL_POSITION_SIZE = 3;
	public static final int FIELD_LENGTH_SIZE = 2;
	public static final int INTERFACE_ID_SIZE = 2;
		
	/** Fuel Position Number */
	private short positionNumber;
	
	/** Device Hardware Vendor */
	private String vendor;
	
	/** Device Model */
	private String model;
	
	/** Device Software */
	private String software;
	
	/** Device Firmware Version */
	private String firmware;
	
	private String hardware;
	
	private short interfaceId;
	
	
	public DeviceVersionInformation(){
		this.positionNumber = 0;
		this.interfaceId = 0;
	}
	
	public DeviceVersionInformation(short positionNumber){
		this.positionNumber = positionNumber;
		this.interfaceId = 0;
	}

	/**
	 * @return the positionNumber
	 */
	public short getPositionNumber() {
		return positionNumber;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the software
	 */
	public String getSoftware() {
		return software;
	}

	/**
	 * @return the firmware
	 */
	public String getFirmware() {
		return firmware;
	}
	
	/**
	 * @return the hardware
	 */
	public String getHardware() {
		return hardware;
	}

	/**
	 * @param positionNumber the positionNumber to set
	 */
	public void setPositionNumber(short positionNumber) {
		this.positionNumber = positionNumber;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @param software the software to set
	 */
	public void setSoftware(String software) {
		this.software = software;
	}

	/**
	 * @param firmware the firmware to set
	 */
	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	/**
	 * @param hardware the hardware to set
	 */
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public short getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(short interfaceId) {
		this.interfaceId = interfaceId;
	}	
}
