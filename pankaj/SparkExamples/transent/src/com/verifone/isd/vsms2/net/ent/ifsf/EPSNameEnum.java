package com.verifone.isd.vsms2.net.ent.ifsf;


public enum EPSNameEnum {

	VFI("VFI", true)
	
	{
		@Override
		public String getEpsName() {

			return "VFI";
		}

		@Override
		public boolean isEnabled() {
			
			return true;
		}
	},
	THIRDPARTY("Third-Party", false) {
		
		@Override
		public String getEpsName() {

			return "Third-Party";
		}

		@Override
		public boolean isEnabled() {
			return false;
		}
	};
	
	
	private boolean enabled;
	private String epsName;
	
	EPSNameEnum(String name, boolean enabled) {
		this.epsName = name;
		this.enabled = enabled;
	}
	
	/**
	 * Returns the DCRDriverType corresponding to a particular value.
	 */
	public static EPSNameEnum fromValue(String val) {
		
		EPSNameEnum epsName = null;
		
		if(val == null) {
			throw new IllegalArgumentException();			
		}

		for(EPSNameEnum type : EPSNameEnum.values()){
			if(val.equals(type.getEpsName())) {
				epsName = type;
			}
		}				
		return epsName;
	}
	
	public abstract String getEpsName(); 
	
	public abstract boolean isEnabled(); 
}

