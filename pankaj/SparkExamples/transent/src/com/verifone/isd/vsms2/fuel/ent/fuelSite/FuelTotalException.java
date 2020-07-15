package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.util.ArrayList;

public class FuelTotalException extends FuelException {

	public FuelTotalException(String errorKey, String bundleName,
			ArrayList errorParams, Throwable source) {
		super(errorKey, bundleName, errorParams, source);
	}

	public FuelTotalException(String errorKey, String bundleName,
			ArrayList errorParams) {
		super(errorKey, bundleName, errorParams);
	}

	public FuelTotalException(String errorKey, String bundleName,
			Throwable source) {
		super(errorKey, bundleName, source);
	}

	public FuelTotalException(String errorKey, Throwable source) {
		super(errorKey, source);
	}

	public FuelTotalException(String errorKey, String bundleName) {
		super(errorKey, bundleName);
	}

}
