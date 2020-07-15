package com.verifone.isd.vsms2.sales.ent.trans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

public enum WorkStationType{
	
	INDOOR_WS,
	OUTDOOR_WS,
	THIN_CLIENT,
	OUTDOOR_VIRTUAL_WS;
	
	private static Logger logger = LoggerFactory
			.getLogger(com.verifone.isd.vsms2.sales.ent.trans.WorkStationType.class);
	private static final int INDOOR_POS_MIN_RANGE = 101;
	private static final int INDOOR_POS_MAX_RANGE = 150;
	private static final int OUTDOOR_POS_MIN_RANGE = 901;
	private static final int OUTDOOR_POS_MAX_RANGE = 964;
	private static final int THINCLIENT_POS_MIN_RANGE = 151;
	private static final int THINCLIENT_POS_MAX_RANGE = 199;
	private static int OUTDOOR_VIRTUAL_POS_MIN_RANGE = 250;
	private static int NO_OF_VIRTUAL_POS_REGISTERS = 10;

	static {
		// load virtual POS range from property file
		String OUTDOOR_VIRTUAL_POS_MIN_RANGE_PROP = "virtual.pos.register.id.range.lower";
		String NO_OF_VIRTUAL_POS_REGISTERS_PROP = "virtual.pos.no.of.registers";
		try {
			OUTDOOR_VIRTUAL_POS_MIN_RANGE = Short.parseShort(SysPropertyFactory
					.getProperty(OUTDOOR_VIRTUAL_POS_MIN_RANGE_PROP, String.valueOf(OUTDOOR_VIRTUAL_POS_MIN_RANGE)));
		} catch (NumberFormatException nfe) {
			logger.error("error loading property '{}' - {}", OUTDOOR_VIRTUAL_POS_MIN_RANGE_PROP, nfe);
		}
		try {
			NO_OF_VIRTUAL_POS_REGISTERS = Short.parseShort(SysPropertyFactory
					.getProperty(NO_OF_VIRTUAL_POS_REGISTERS_PROP, String.valueOf(NO_OF_VIRTUAL_POS_REGISTERS)));
		} catch (NumberFormatException nfe) {
			logger.error("error loading property '{}' - {}", NO_OF_VIRTUAL_POS_REGISTERS_PROP, nfe);
		}
	}
	
	public static  WorkStationType getWorkstationType(long posID) {
		
		if(posID>= INDOOR_POS_MIN_RANGE && posID<=INDOOR_POS_MAX_RANGE) {
			return WorkStationType.INDOOR_WS;
		}else if(posID>= OUTDOOR_POS_MIN_RANGE && posID<=OUTDOOR_POS_MAX_RANGE) {
			return WorkStationType.OUTDOOR_WS;
		}
		else if(posID>= THINCLIENT_POS_MIN_RANGE && posID<=THINCLIENT_POS_MAX_RANGE) {
			return WorkStationType.THIN_CLIENT;
		} else if (posID >= OUTDOOR_VIRTUAL_POS_MIN_RANGE
				&& posID < (OUTDOOR_VIRTUAL_POS_MIN_RANGE + NO_OF_VIRTUAL_POS_REGISTERS)) {
			return WorkStationType.OUTDOOR_VIRTUAL_WS;
		}else {
			return WorkStationType.INDOOR_WS;
		}
	}
	
}