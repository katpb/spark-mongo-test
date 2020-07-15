/* Copyright (C) 2011 VeriFone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 22 Nov, 2011                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.error;
/**
 * Enumeration for fault codes
 * 
 * @author Ganesh_K1
 */
public enum VFIFault {
    PARSE_ERROR("CGIPortal.ParseError","CGIPortal Error","CGI_PARSE_ERROR"),
    INTERNAL_ERROR("CGIPortal.InternalError","CGIPortal Error","CGI_INTERNAL_ERROR"),
    LOGIN_REQUIRED("CGIPortal.LoginRequired","CGIPortal Error","LOGIN_REQUIRED"),
    ALL_DCRS_NOT_IDLE("CGIPortal.allDcrsNotIdle","CGIPortal Error","ALL_DCRS_NOT_IDLE"),
    PRICE_SIGN_OFFLINE("CGIPortal.priceSignOffline", "CGIPortal Error", "PRICE_SIGN_OFFLINE"),
    OTP_REQUIRED("CGIPortal.OTPRequired", "CGIPortal Error", "OTP_REQUIRED"),
    DEVICE_DISABLED("CGIPortal.DeviceDisabled", "CGIPortal Error", "DEVICE_DISABLED"),
    DEVICE_NOT_REGISTERED("CGIPortal.DeviceNotRegisterd", "CGIPortal Error", "DEVICE_NOT_REGISTERED");
   
    private String faultCode;
    private String faultString;
    private String errorKey;
    /**
     * Constructor.
     * 
     * @param faultCode the faultCode
     * @param errorKey the errorKey to get the message from resource bundler.
     */
    private VFIFault(String faultCode, String faultString, String errorKey) {
        this.faultCode = faultCode; 
        this.faultString = faultString;
        this.errorKey = errorKey;
    }
	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}
	/**
	 * @return the faultString
	 */
	public String getFaultString() {
		return faultString;
	}
	/**
	 * @return the errorKey
	 */
	public String getErrorKey() {
		return errorKey;
	} 
}