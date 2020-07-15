package com.verifone.isd.vsms2.sales.ent.managedupdate;

import java.io.File;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * Constants Used by Managed Update Process
 * @author T_ShailendraP1
 *
 */
public class ManagedUpdateConstant {
	public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	public static final String MANAGED_UPDATE_DIR = "managedupdate";
	public static final String TEMP = "temp";
	public static final String DELEMETER = "-";
	
	public static final String TIMESTAMP = "timeStamp";
	public static final String DATASET = "dataset";
	public static final String MANAGED_UPDATE = "managedUpdate";
	public static final String MANAGED_UPDATE_INFO = "managedUpdateInfo";
	
	public static final File ROOT_PATH= new File(SysPropertyFactory.makeAbsoluteDataPath(MANAGED_UPDATE_DIR));
	public static final File TEMP_PATH= new File(ROOT_PATH.getAbsolutePath()+File.separatorChar+TEMP);
}
