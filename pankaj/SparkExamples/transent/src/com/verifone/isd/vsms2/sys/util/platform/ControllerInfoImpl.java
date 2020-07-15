package com.verifone.isd.vsms2.sys.util.platform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.FileUtil;
import com.verifone.isd.vsms2.sys.util.RegisterIDList;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.register.RegisterType;

/**
 * The Class ControllerInfoImpl provides necessary details about the
 * controller .
 * 
 * @author Sanjeev_S1
 */
public class ControllerInfoImpl implements IControllerInfo {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ControllerInfoImpl.class);

	/** The identified controller type. */
	private ControllerType identifiedControllerType = ControllerType.COMMANDER;

	/** The Constant ROUTE_CMD. */
	private static final String ROUTE_CMD = "route";

	/** The Constant PING_CMD. */
	private static final String PING_CMD = "/sbin/ping -c 5 ";

	/** The Constant TIMEZONE_CMD. */
	private static final String TIMEZONE_CMD = "/usr/bin/settz";

	/** The Constant DATE_CMD. */
	private static final String DATE_CMD = "date";

	/** The Constant VERSION. */
	private static final String VERSION_FILEEXTENSION = ".ver";
	
	/** The Constant MAX_DCRID. */
	private static final int MAX_DCRID = RegisterIDList.MAX_DCRNUM;
	
	/** The Constant MIN_DCRID. */
	private static final int MIN_DCRID = RegisterIDList.MIN_DCRNUM;	

	/** The singleton instance. */
	private static IControllerInfo instance = new ControllerInfoImpl();
        
        /** The Constants to support Topaz extended IP address range. */
	private static final int TPZ_EXT_IP_FIRST = 201;	
        private static final int TPZ_EXT_IP_LAST = 207;	
        private static final int TPZ_EXT_IP_GAP = 75;	        

	/**
	 * Instantiates a new DefaultBaseControllerInfoImpl.
	 */
	private ControllerInfoImpl() {
		this.identifyControllerType();
	}

	/**
	 * Gets the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static IControllerInfo getInstance() {
		return instance;
	}

	/**
	 * Identify controller type.
	 */
	private void identifyControllerType() {
		RegisterType registerType = RegisterType.getRegisterType();
		if (registerType.getProdName().equals(ControllerType.RUBYCI.getControllerName())) {
			LOGGER.debug("{} is identfied as Controller",ControllerType.RUBYCI.getControllerName());
			this.setIdentifiedPlatform(ControllerType.RUBYCI);
		} else {
			LOGGER.debug("Commander is identfied as Controller");
		}
	}

	/**
	 * Sets the identified platform.
	 * 
	 * @param identfiedPlatformType
	 *            the new identified platform
	 */
	private void setIdentifiedPlatform(ControllerType identfiedPlatformType) {
		this.identifiedControllerType = identfiedPlatformType;

	}

	/**
	 * Gets the identified platform type.
	 * 
	 * @return the identified platform type
	 */
	@Override
	public ControllerType getIdentifiedControllerType() {
		return this.identifiedControllerType;
	}

	@SuppressWarnings("boxing")
	@Override
	public boolean isValidRegister(String ipAddress,int allowedRegistersCount) {
		LOGGER.debug("Allowed register count for the current platform is {}",allowedRegistersCount);
		String[] placeSplits = ipAddress.split("\\.");
		String versionNo;
		if (placeSplits.length == 4) {
			LOGGER.debug("IPAddress received is '{}'", ipAddress);
			versionNo = placeSplits[3];
		} else {
			LOGGER.debug("RegisterID received is '{}'", ipAddress);
			versionNo = ipAddress;
			if(Integer.parseInt(versionNo)>= MIN_DCRID&& Integer.parseInt(versionNo)<=MAX_DCRID &&
				gatherAllowedDCRIDs(allowedRegistersCount).contains(ipAddress)) {				
				return true;
			}
		}
                
                int registerId = Integer.parseInt(versionNo);
                if ((registerId >= TPZ_EXT_IP_FIRST) &&
                    (registerId <= TPZ_EXT_IP_LAST)) {		
			registerId -= TPZ_EXT_IP_GAP;
                        versionNo = Integer.toString(registerId);
		}
                                
		LOGGER.debug("Register ID to be looked up is '{}'", versionNo);
		File[] matchedRegisterFiles = this.lookupRegisterAvailability(versionNo);
		if(!(matchedRegisterFiles.length>0)) {
			return this.isRegisterVersionAllowed(allowedRegistersCount,versionNo,VERSION_FILEEXTENSION);
		}

		return (matchedRegisterFiles != null) && (matchedRegisterFiles.length > 0);
	}

	/**
	 * Checks if is register version allowed.
	 * 
	 * @param allowedRegistersCount
	 *            the allowed registers count
	 * @param regId
	 *            the reg id
	 * @param fileNameExtension
	 *            the file name extension
	 * @return true, if is register version allowed
	 */
	@SuppressWarnings("boxing")
	private boolean isRegisterVersionAllowed(int allowedRegistersCount,String regId,final String fileNameExtension) {
		Set<String> allowedRegisterIDs = gatherAllowedRegisterIDs(allowedRegistersCount);
		String path = SysPropertyFactory.makeAbsoluteDataPath("");
		File directory = new File(path);
		File[] availableRegisterFiles = directory
				.listFiles(new AvailableRegisterCountFilter(fileNameExtension));

		boolean isRegisterAllowed = availableRegisterFiles.length <= allowedRegistersCount;
		LOGGER.debug("Controller's existing Register count -{}",availableRegisterFiles.length);
		if ((null != regId) && isRegisterAllowed
				&& allowedRegisterIDs.contains(regId)) {
			LOGGER.debug("Register version can be allowed.Returning true");
			return true;
		} else {
			LOGGER.debug("Register version CANNOT be allowed.Returning false");
			return false;
		}
	}

	/**
	 * Gather allowed register i ds.
	 * 
	 * @param allowedRegistersCount
	 *            the allowed registers count
	 * @return the sets the
	 */
	private static Set<String> gatherAllowedRegisterIDs(
			final int allowedRegistersCount) {
		Set<String> allowedRegisterIDs = new TreeSet<String>();
		for (int i = 1; i <= allowedRegistersCount; i++) {
			allowedRegisterIDs.add(String.valueOf(100 + i));
		}
		LOGGER.debug("Allowed register IDs are - {}", allowedRegisterIDs);
		return allowedRegisterIDs;
	}

	/**
	 * Gather allowed count of DCR ids.
	 * 
	 * @param allowedDCRCount
	 *            the allowed dcr count
	 * @return the sets the
	 */
	private static Set<String> gatherAllowedDCRIDs(
			final int allowedDCRCount) {
		Set<String> allowedDCRIDs = new TreeSet<String>();
		for (int i = 1; i <= allowedDCRCount; i++) {
			allowedDCRIDs.add(String.valueOf(900 + i));
		}
		return allowedDCRIDs;
	}

	/**
	 * The Class RegisterNameMatchFilter is used to filter the expected register
	 * name.
	 * 
	 * @author Sanjeev_S1
	 */
	private static final class RegisterNameMatchFilter implements
	FilenameFilter {

		/** The pos version no. */
		private final String posVersionNo;

		/**
		 * Instantiates a new register name match filter.
		 * 
		 * @param posVersionNo
		 *            the pos version no
		 */
		RegisterNameMatchFilter(String posVersionNo) {
			this.posVersionNo = posVersionNo;
		}

		@Override
		public boolean accept(File directory, String fileName) {
			return fileName.endsWith(this.posVersionNo + VERSION_FILEEXTENSION);
		}
	}

	/**
	 * The Class AvailableRegisterCountFilter filters the register file having an
	 * expected extension.
	 */
	private static class AvailableRegisterCountFilter implements FilenameFilter {

		/** The file extension. */
		private final String extension;

		/**
		 * Instantiates a new register allowed count filter.
		 * 
		 * @param ext
		 *            the fileExtension
		 */
		AvailableRegisterCountFilter(String ext) {
			this.extension = ext;
		}

		@Override
		public boolean accept(File directory, String fileName) {
			return fileName.endsWith(this.extension);
		}
	}

	/**
	 * Lookup register availability.
	 * 
	 * @param posVersionNo
	 *            the pos version no
	 * @return the file[]
	 */
	private File[] lookupRegisterAvailability(final String posVersionNo) {
		String path = SysPropertyFactory.makeAbsoluteDataPath("");
		File targetDirectory = new File(path);
		File[] registerVersionFiles = targetDirectory.listFiles(new RegisterNameMatchFilter(posVersionNo));
		if ((null != registerVersionFiles) & (registerVersionFiles.length > 0)) {
			LOGGER.debug("Register Lookup succcesful.");
		} else {
			LOGGER.debug("Register Lookup failed.Invalid client is trying to register as POS");
		}
		return registerVersionFiles;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getCPUBrand()
	 */
	@Override
	public String getCPUBrand() {
		return (this.extractFrom(FILE_CPUINFO, VENDOR_ID));
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getCPUClock()
	 */
	@Override
	public String getCPUClock() {
		return (this.extractFrom(FILE_CPUINFO, CPU_MHZ) + " MHz");
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getRAMSize()
	 */
	@Override
	public String getRAMSize() {
		return (this.extractFrom(FILE_MEMINFO, MEM_TOTAL));
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getFreeRAM()
	 */
	@Override
	public String getFreeRAM() {
		return (this.extractFrom(FILE_MEMINFO, MEM_FREE));
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getDiskInfo()
	 */
	@Override
	public String[] getDiskInfo() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getNetFields()
	 */
	@Override
	public String[] getNetFields() {

		int currField = 0;
		String[] netFields = new String[] { UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN };
		BufferedReader breader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("/sbin/ifconfig eth0");
			breader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = breader.readLine();
			while (line != null) {

				if (line.indexOf("HWaddr") >= 0) {
					netFields[currField++] = line.substring(line
							.indexOf("HWaddr") + 6);
				}

				if (line.indexOf("inet addr:") >= 0) {
					netFields[currField++] = this.splitAndGetField(line,
							"inet addr:");
					netFields[currField++] = this.splitAndGetField(line,
							"Bcast:");
					netFields[currField++] = this.splitAndGetField(line,
							"Mask:");
				}

				line = breader.readLine();
			}

			process.waitFor();
		} catch (IOException ioex) {
		} catch (InterruptedException e) {
		} finally {
			if (null != breader) {
				try {
					breader.close();
				} catch (IOException e) {
				}
			}
			if (null != process) {
				process.destroy();
			}
		}

		return (netFields);
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getPingCommand()
	 */
	@Override
	public String getPingCommand() {
		return PING_CMD;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getRouteCmd()
	 */
	@Override
	public String getRouteCmd() {
		return ROUTE_CMD;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getTimeZoneCmd()
	 */
	@Override
	public String getTimeZoneCmd() {
		return TIMEZONE_CMD;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getDateCmd()
	 */
	@Override
	public String getDateCmd() {
		return DATE_CMD;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getModelShortName()
	 */
	@Override
	public String getModelShortName() {
		return this.identifiedControllerType.getControllerName();
	}
	
	@Override
	public String getModelDisplayName() {
		return this.identifiedControllerType.getControllerDisplayName();

	}

	/**
	 * Extract from.
	 * 
	 * @param procFile
	 *            the proc file
	 * @param info
	 *            the info
	 * @return the string
	 */
	private String extractFrom(String procFile, String info) {
		BufferedReader breader = null;
		try {
			breader = new BufferedReader(new InputStreamReader(
					new FileInputStream(procFile)));
			String line = breader.readLine();
			while (line != null) {
				if (line.indexOf(info) >= 0) {
					break;
				}
				line = breader.readLine();
			}

			if (line != null) {
				String[] fields = line.split(PROC_FILE_FIELD_SEPERATOR);
				if (fields.length == 2) {
					return (fields[1].trim());
				}
			}
		} catch (Exception ioex) {
			LOGGER.error("Error", ioex);
		} finally {
			if (null != breader) {
				try {
					breader.close();
				} catch (IOException e) {
				}
			}
		}
		return (UNKNOWN);
	}

	/**
	 * Split and get field.
	 * 
	 * @param line
	 *            the line
	 * @param key
	 *            the key
	 * @return the string
	 */
	private String splitAndGetField(String line, String key) {
		String[] tmps = line.substring(line.indexOf(key) + key.length()).split(
				" ");
		return (tmps[0]);
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getGateway()
	 */
	@Override
	public String getGateway() {
		String gateway = "N/A";
		BufferedReader breader = null;
		try {
			Process process = Runtime.getRuntime().exec(this.getRouteCmd());
			breader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));

			String line = breader.readLine();
			LOGGER.error(line);
			while (line != null) {

				if ((line.indexOf("default") >= 0)
						&& (line.indexOf("eth0") > 0)) {
					gateway = (line.substring(line.indexOf("default") + 7)
							.trim().split(" ")[0]);
				}

				line = breader.readLine();
			}

			process.waitFor();
		} catch (IOException ioex) {
			LOGGER.error("IOException", ioex);
		} catch (InterruptedException ie) {
			LOGGER.error("InterruptedException", ie);
		} finally {
			if (null != breader) {
				try {
					breader.close();
				} catch (IOException e) {
				}
			}
		}
		return gateway;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getModelName()
	 */
	@Override
	public String getModelName() {
		BufferedReader breader = null;
		String modelName = UNKNOWN; // default value if we can't read/access
		// file

		try {
			breader = new BufferedReader(new InputStreamReader(
					new FileInputStream(OS_ISSUE_FILE)));

			// only one line in this file and it contains model number and O/S
			// version
			String line = breader.readLine();

		} catch (FileNotFoundException e) {
			LOGGER.error("Couldn't open /etc/issue  file to read model number",
					e);
		} catch (IOException e) {
			LOGGER.error("error reading model number from /etc/issue file", e);
		} finally {
			try {
				if (breader != null) {
					breader.close();
				}
			} catch (IOException e) {
				LOGGER.error(
						"error closing /etc/issue file when reading model number",
						e);
			}

		}
		return modelName;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.util.platform.IControllerInfo#getOSVersion()
	 */
	@Override
	public String getOSVersion() {
		String issuePath = OS_ISSUE_FILE;
		String patchPath = OS_PATCH_FILE;
		String resp = UNKNOWN;
		BufferedReader issueReader = null;
		BufferedReader patchReader = null;
		FileInputStream fis = null;
		InputStreamReader isReader = null;
		try {
			fis = new FileInputStream(issuePath);
			isReader = new InputStreamReader(fis);
			issueReader = new BufferedReader(isReader);
			String line = issueReader.readLine();

			LOGGER.debug("Issue Reader = {}",line);
			String osVersion = null;
			// the first characters are usually junk, so skip these until
			// we get to the 'V'
			for (int i = 0; i < line.length(); i++) {
				if ((line.charAt(i) == 'V') || (line.charAt(i) == 'v')) {
					osVersion = line.substring(i);
					break;
				}
			}
			FileUtil.closeResource(issueReader);
			FileUtil.closeResource(isReader);
			FileUtil.closeResource(fis);

			String patch = null;
			String tmpStr = null;
			if (null != osVersion) {
				File file = new File(patchPath);
				if (file.exists()) {
					fis = new FileInputStream(file);
					isReader = new InputStreamReader(fis);
					patchReader = new BufferedReader(isReader);

					while ((tmpStr = patchReader.readLine()) != null) {
						patch = tmpStr;
					}

					if (patch != null) {
						osVersion = osVersion + PATCH + patch;
					}
				}
				// Remove any invalid character.
				StringBuilder strBuffer = new StringBuilder();
				for (int i = 0; i < osVersion.length(); i++) {
					if (!Character.isISOControl(osVersion.charAt(i))) {
						strBuffer.append(osVersion.charAt(i));
					}
				}
				resp = strBuffer.toString();
			}
		} catch (IOException ioex) {
			LOGGER.info(ioex.getMessage(), ioex);
		} finally {
			FileUtil.closeResource(patchReader);
			FileUtil.closeResource(issueReader);
			FileUtil.closeResource(isReader);
			FileUtil.closeResource(fis);
		}
		return (resp);
	}

	@Override
	public String toString() {
		return String
				.format("ControllerPlatformInfo [getIdentfiedPlatformType()=%s, getCPUBrand()=%s, getCPUClock()=%s, getRAMSize()=%s, getFreeRAM()=%s, getDiskInfo()=%s, getNetFields()=%s, getPingCommand()=%s, getRouteCmd()=%s, getTimeZoneCmd()=%s, getDateCmd()=%s, getModelShortName()=%s,getModelDisplayName()=%s, getGateway()=%s, getModelName()=%s, getOSVersion()=%s]",
						this.getIdentifiedControllerType(), this.getCPUBrand(),
						this.getCPUClock(), this.getRAMSize(), this.getFreeRAM(),
						Arrays.toString(this.getDiskInfo()),
						Arrays.toString(this.getNetFields()), this.getPingCommand(),
						this.getRouteCmd(), this.getTimeZoneCmd(), this.getDateCmd(),
						this.getModelShortName(), this.getModelDisplayName(), this.getGateway(), this.getModelName(),
						this.getOSVersion());
	}

	
}