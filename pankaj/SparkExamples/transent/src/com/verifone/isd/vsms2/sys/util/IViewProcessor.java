package com.verifone.isd.vsms2.sys.util;

import java.io.File;


public interface IViewProcessor {
	public void backupConfigData(File outFile, String visitor) throws Exception;

}
