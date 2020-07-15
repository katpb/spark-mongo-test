package com.verifone.isd.vsms2.sys.util;

import java.util.ArrayList;
import java.util.List;

public class RebootDevicesUtil {
	public boolean rebootCommander() throws Exception {
		List<String> cmd = new ArrayList<>();
		cmd.add("sudo");
		cmd.add("reboot");
		ProcessBuilder pb = new ProcessBuilder(cmd);
		Process pr = pb.start();
		if (pr.waitFor() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
