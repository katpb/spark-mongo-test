package com.verifone.isd.vsms2.sales.ent.attendant;

import com.verifone.isd.vsms2.sys.error.VFIException;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * Exception for all errors related to Attendant Session
 * 
 * @author Medha_K1
 *
 */

public class AttendantSessionException extends VFIException {

	private static final long serialVersionUID = 8133805927721626366L;

	public AttendantSessionException(String error) {
		super(error, LocalizedRB.TOPAZ_RESOURCE);
	}
}
