package com.verifone.isd.vsms2.sales.ent.attendant;

import com.verifone.isd.vsms2.sys.error.VFIException;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * Exception class for FSA Card already activated error
 * 
 * @author Medha_K1
 *
 */

public class CardAlreadyActivatedException extends VFIException {

	private static final long serialVersionUID = 8133805927721626366L;

	public CardAlreadyActivatedException(String error) {
		super(error, LocalizedRB.TOPAZ_RESOURCE);
	}
}
