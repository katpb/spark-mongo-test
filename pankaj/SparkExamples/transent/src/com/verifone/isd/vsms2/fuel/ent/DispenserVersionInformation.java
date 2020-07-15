package com.verifone.isd.vsms2.fuel.ent;


public class DispenserVersionInformation extends DeviceVersionInformation{

	
	private boolean isBlender = false;
	
	public DispenserVersionInformation(short positionNumber) {
		super(positionNumber);
	}

	public boolean isBlender() {
		return isBlender;
	}

	public void setBlender(boolean isBlender) {
		this.isBlender = isBlender;
	}
}
