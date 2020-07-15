package com.verifone.isd.vsms2.sys.util;

import java.io.InputStream;

public interface IUpdateProcessor {

	public void restoreConfigData(InputStream inputStream, String handler)  throws Exception;


}
