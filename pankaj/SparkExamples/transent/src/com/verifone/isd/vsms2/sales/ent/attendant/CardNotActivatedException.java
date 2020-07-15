package com.verifone.isd.vsms2.sales.ent.attendant;

import com.verifone.isd.vsms2.sys.error.VFIException;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * Exception class for FSA Card not activated error
 * 
 * @author Medha_K1
 *
 */

public class CardNotActivatedException extends VFIException {

	private static final long serialVersionUID = 8133805927721626366L;

	public CardNotActivatedException(String error) {
		super(error, LocalizedRB.TOPAZ_RESOURCE);
	}
}
