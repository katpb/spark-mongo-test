/* Copyright (C) 2012 VeriFone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 03 August, 2012                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.util;

/**
 * This class holds the constants anything specific to the Controller (Site Controller).
 * 
 * @author Ganesh_K1 
 */
public abstract class ControllerConstants {
	public static final String BASE_LOCALHOST_CGILINK = "http://127.0.0.1/cgi-bin/CGILink?";
	public static final String BASE_URL_CGILINK = "http://sitecontroller/cgi-bin/CGILink?";
	public static final String BASE_HTTPS_URL_CGILINK = "https://sitecontroller/cgi-bin/CGILink?";
	public static final String BASE_URL_CGIUPLINK = "http://sitecontroller/cgi-bin/CGIUplink";
	public static final String HTTP_POST = "POST";
	public static final String SECONDARY_EPS = "VFI";
	public static final String PRIMARY_EPS = "primary";
	public static final String FSA_NAME = "FullServiceAttendant";
	public static final String DEFAULT_ENCODING_TYPE = "UTF-8";
	public static final String EVENT_CONTENT_TYPE = "text/event-stream;charset=UTF-8";
	
	//CDM Agent constants    
    public static final String COMMON_UCMD_FILE = "updatecommandlist.prop";
    public static final String CM_SUPPORTED_CMD="cdmsupporteddataset.prop";
    public static final String DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";    
}
