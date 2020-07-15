package com.verifone.isd.vsms2.sys.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.register.RegisterType;

/**
 * Utility class to get the register ids.
 */
public class RegisterIDList {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegisterIDList.class);

	/** The Constant MAX_NUM_POS. */
	private static final int MAX_NUM_POS = 32;
	
    /** The Constant MAX_REGISTERID. */
    public static final int MAX_REGISTERID = 132;
	
	/** The Constant MIN_REGISTERID. */
    public static final int MIN_REGISTERID = 101;
    
	/** The Constant MIN_AUXPOSNUM. */
	public static final int MIN_AUXPOSNUM = 701;

	/** The Constant MAX_AUXPOSNUM. */
	public static final int MAX_AUXPOSNUM = 704;

	/** The Constant MIN_DCRNUM. */
	public static final int MIN_DCRNUM = 901;

	/** The Constant MAX_DCRNUM. */
	public static final int MAX_DCRNUM = 999;

	/** The Constant ALL_DCRNUM. */
	public static final int ALL_DCRNUM = 9;
	
	/** The Constant ALL_ATTENDANT_INDOORNUM, ASSIGNED TO DENOTE ATTENDANT INDOOR DETAILS. */
	public static final int ALL_ATTENDANT_INDOORNUM = 2;
	
	/** The Constant ALL_ATTENDANT_OUTDOORNUM, ASSIGNED TO DENOTE ATTENDANT OUTDOOR DETAILS. */
	public static final int ALL_ATTENDANT_OUTDOORNUM = 4;

	/** The Constant ALL_CWPAYPOINTNUM. */
	public static final int ALL_CWPAYPOINTNUM = 8;

	/** The Constant VERSION. */
	private static final String VERSION = ".ver";
	
	/** The Constant CONFIGURATION. */
	public static final String CFG = ".cfg";
	
	public static final int ATTENDANT_INDOOR_REG_NUM_BASE = 200;
	
	public static final int ATTENDANT_OUTDOOR_REG_NUM_BASE = 400;
	
	public static final int  ATTENDANT_INDOOR_VIRTUALID_MIN = 201;
	
	public static final int  ATTENDANT_INDOOR_VIRTUALID_MAX = 300;
	public static final int  ATTENDANT_OUTDOOR_VIRTUALID_MIN = 401;
	
	public static final int  ATTENDANT_OUTDOOR_VIRTUALID_MAX = 500;
	
	

	/**
	 * This method will return the valid topaz register ids.
	 * 
	 * @return list of topaz ids.
	 */
	public static Map<Integer, RegisterType> getRegisters() {
		final Map<Integer, RegisterType> regInfoMap = new TreeMap<Integer, RegisterType>();
		File dir = new File(SysPropertyFactory.makeAbsoluteDataPath(""));
		if (dir.exists() && dir.isDirectory()) {
			String[] tpzVersionFiles = dir
					.list(new RegisterVersionFilesPickerFilter(regInfoMap));
		}
		return regInfoMap;
	}

	/**
	 * This method will return the register file based on register number and
	 * file extension.
	 * 
	 * @param regNum
	 *            - register number
	 * @param fileExt
	 *            - file extension
	 * @return File
	 */
	public static File getRegisterFile(short regNum, String fileExt) {
		File topazRegFile = new File(
				SysPropertyFactory.makeAbsoluteDataPath(RegisterType.TOPAZ
						.getRegType()) + regNum + fileExt);
		File ruby2RegFile = new File(
				SysPropertyFactory.makeAbsoluteDataPath(RegisterType.RUBY2
						.getRegType()) + regNum + fileExt);
		File pythonC18RegFile = new File(
				SysPropertyFactory.makeAbsoluteDataPath(RegisterType.PYTHON_C18
						.getRegType()) + regNum + fileExt);
		File pythonC15RegFile = new File(
				SysPropertyFactory.makeAbsoluteDataPath(RegisterType.PYTHON_C15
						.getRegType()) + regNum + fileExt);


		File regFile = null;
        if (pythonC18RegFile.exists())
        {
            regFile = pythonC18RegFile;
        } else if (pythonC15RegFile.exists())
        {
            regFile = pythonC15RegFile;
        } else if (ruby2RegFile.exists())
        {
            regFile = ruby2RegFile;
        } else if (topazRegFile.exists())
        {
            regFile = topazRegFile;
        }

        return regFile;
	}
    
	/**
	 * Lookup register availability.
	 * 
	 * @param regType
	 *            the reg type
	 * @param regNum
	 *            the reg num
	 * @param fileExtension
	 *            the file ext
	 * @return the file[]
	 */
	public static File[] lookupRegisterAvailability(String regType,
			short regNum, String fileExtension) {
		String targetRegisterName = SysPropertyFactory
				.makeAbsoluteDataPath(regType) + regNum + fileExtension;
		File[] registerFiles = performLookUp(targetRegisterName);
		return registerFiles;
	}

	/**
	 * Perform look up.
	 * 
	 * @param targetRegisterName
	 *            the target register name
	 * @return the file[]
	 */
	private static File[] performLookUp(final String targetRegisterName) {
		String path = SysPropertyFactory.makeAbsoluteDataPath("");
		File targetDirectory = new File(path);
		File[] matchedRegisterFiles = targetDirectory
				.listFiles(new RegisterNameMatchFilter(targetRegisterName));
		if (matchedRegisterFiles.length > 0) {
			LOGGER.debug("Register already available");
		} else {
			LOGGER.debug(
					"Register unavailable.File '{}' is NOT YET created .",
					targetRegisterName);
		}
		return matchedRegisterFiles;
	}

	/**
	 * Checks if is register version allowed.
	 * 
	 * @param regId
	 *            the reg id
	 * @param allowedRegistersCount
	 *            the allowed registers count
	 * @param fileNameExtension
	 *            the ext
	 * @return true, if is register version allowed
	 */
	@SuppressWarnings("boxing")
	public static boolean isRegisterVersionAllowed(String regId,
			final int allowedRegistersCount, final String fileNameExtension) {
		LOGGER.info("Allowed register count for the current platform is {}",
				allowedRegistersCount);
		Set<String> allowedRegisterIDs = gatherAllowedRegisterIDs(allowedRegistersCount);
		String path = SysPropertyFactory.makeAbsoluteDataPath("");
		File targetDirectory = new File(path);
		File[] availableRegisterFiles = targetDirectory
				.listFiles(new AvailableRegisterCountFilter(fileNameExtension));

		boolean isAllowedRegistersLimitReached = availableRegisterFiles.length == allowedRegistersCount;
		LOGGER.info("Controller's existing Register count -{}",
				availableRegisterFiles.length);
		if ((null != regId) && !isAllowedRegistersLimitReached
				&& allowedRegisterIDs.contains(regId)) {
			LOGGER.info("Register version can be allowed.Returning true");
			return true;
		} else {
			LOGGER.info("Register version is not in the expected range (or) Max.register count already reached.Register cannot be allowed.Returning false");
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
		for (int i = 1; (i <= allowedRegistersCount)
				&& (allowedRegistersCount <= MAX_NUM_POS); i++) {
			allowedRegisterIDs.add(String.valueOf(100 + i));
			/**
			 * POS ID ranges from 101,102,...132.
			 */
		}
		LOGGER.debug("Allowed register IDs range - '{}'", allowedRegisterIDs);
		return allowedRegisterIDs;
	}

	/**
	 * The Class RegisterVersionFilesPickerFilter picks all register version
	 * files.
	 * 
	 * @author Sanjeev_S1
	 */
	private static final class RegisterVersionFilesPickerFilter implements
			FilenameFilter {

		/** The reg info map. */
		private final Map<Integer, RegisterType> regInfoMap;

		/**
		 * Instantiates a new RegisterVersionFilesPickerFilter.
		 * 
		 * @param regInfoMap
		 *            the reg info map
		 */
		RegisterVersionFilesPickerFilter(Map<Integer, RegisterType> regInfoMap) {
			this.regInfoMap = regInfoMap;
		}

		@Override
		public boolean accept(File dir, String name) {
			if (name != null) {
				name = name.trim();
                RegisterType regType = null;
                RegisterType[] regTypes = new RegisterType[] {
                    RegisterType.PYTHON_C15, RegisterType.PYTHON_C18, RegisterType.RUBY2, RegisterType.TOPAZ
                };
                for (RegisterType value : regTypes)
                {
                    if (name.startsWith(value.getRegType()))
                    {
                        regType = value;
                        break;
                    }
                }
				if (name.endsWith(VERSION) && (regType != null)) {
					int len = name.length();
					int registerId = Integer.parseInt(name.substring(len - 7,
							len - 4));
					this.regInfoMap.put(registerId, regType);
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * The Class RegisterNameMatchFilter is used to filter the expected register
	 * name.
	 * 
	 * @author Sanjeev_S1
	 */
	private static class RegisterNameMatchFilter implements FilenameFilter {

		/** The target register name. */
		private final String targetRegisterName;

		/**
		 * Instantiates a new register name match filter.
		 * 
		 * @param targetRegisterName
		 *            the target register name
		 */
		RegisterNameMatchFilter(String targetRegisterName) {
			this.targetRegisterName = targetRegisterName;
		}

		@Override
		public boolean accept(File directory, String fileName) {
			String absoluteFilePath = SysPropertyFactory
					.makeAbsoluteDataPath("");
			return (absoluteFilePath + fileName)
					.equals(this.targetRegisterName);
		}
	}

	/**
	 * The Class AvailableRegisterCountFilter filters the register file having
	 * an expected extension.
	 * 
	 * @author Sanjeev_S1
	 * */
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

}
