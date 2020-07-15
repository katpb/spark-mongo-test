package com.verifone.isd.vsms2.sys.util.platform;

/**
 * Interface which provides methods for fetching controller Specific Information.
 * 
 * @author Sanjeev_S1
 */
public interface IControllerInfo {

	/** The unknown. */
	String UNKNOWN = "UNKNOWN";

	/** The build. */
	String BUILD = " Build: ";

	/** The patch. */
	String PATCH = " patch: ";

	/** The mem free. */
	String MEM_FREE = "MemFree";

	/** The mem total. */
	String MEM_TOTAL = "MemTotal";

	/** The cpu mhz. */
	String CPU_MHZ = "cpu MHz";

	/** The vendor id. */
	String VENDOR_ID = "vendor_id";

	/** The proc file field seperator. */
	String PROC_FILE_FIELD_SEPERATOR = ":";

	/** The file meminfo. */
	String FILE_MEMINFO = "/proc/meminfo";

	/** The file cpuinfo. */
	String FILE_CPUINFO = "/proc/cpuinfo";

	/** The os patch file. */
	String OS_PATCH_FILE = "/etc/patchlevel";

	/** The os issue file. */
	String OS_ISSUE_FILE = "/etc/issue";

	/** The date format. */
	String DATE_FORMAT = "MMddyy HHmmss";

	/**
	 * Checks if is valid register.This method basically checks for the
	 * registration status availability of the register. Returns true if
	 * registration status of the register is available with controller.If
	 * not,this method would check whether the register ID is a valid register
	 * that can be registered with controller.
	 * 
	 * @param ipAddress
	 *            the ip address
	 * @param allowedRegistersCount
	 *            the allowed registers count
	 * @return true, if is valid register
	 */
	boolean isValidRegister(String ipAddress, int allowedRegistersCount);

	/**
	 * Gets the identified controller type.
	 * 
	 * @return the identified controller type
	 */
	ControllerType getIdentifiedControllerType();

	/**
	 * Gets the cPU brand.
	 * 
	 * @return Brand of CPU
	 */
	String getCPUBrand();

	/**
	 * Gets the cPU clock.
	 * 
	 * @return CPU SPeed in MHz
	 */
	String getCPUClock();

	/**
	 * Gets the rAM size.
	 * 
	 * @return Total memory of the controller
	 */
	String getRAMSize();

	/**
	 * Gets the free ram.
	 * 
	 * @return Free Memory on the controller
	 */
	String getFreeRAM();

	/**
	 * Gets the disk info.
	 * 
	 * @return Array containing 3 fields - Total Memory, Used Memory and
	 *         Available Memory
	 */
	String[] getDiskInfo();

	/**
	 * Gets the net fields.
	 * 
	 * @return Array containing info about 4 fields in following order -
	 *         Hardware/Mac Address, Inet Address, Broadcast Address, NetMask
	 */
	String[] getNetFields();

	/**
	 * Gets the gateway.
	 * 
	 * @return Gateway used on the controller
	 */
	String getGateway();

	/**
	 * Gets the model name.
	 * 
	 * @return Model Name of the Platform
	 */
	String getModelName();

	/**
	 * Gets the oS version.
	 * 
	 * @return OS Version of the Platform
	 */
	String getOSVersion();

	/**
	 * Gets the ping command.
	 * 
	 * @return the command line argument(based on full path) used by the
	 *         controller for Ping
	 */
	String getPingCommand();

	/**
	 * Gets the route cmd.
	 * 
	 * @return the command line argument(based on full path) used by the
	 *         controller for getting the route
	 */
	String getRouteCmd();

	/**
	 * Gets the time zone cmd.
	 * 
	 * @return the time zone cmd
	 */
	String getTimeZoneCmd();

	/**
	 * Gets the date cmd.
	 * 
	 * @return the date cmd
	 */
	String getDateCmd();

	/**
	 * Getter for a short name representing the model.
	 * 
	 * @return short name for the model
	 */
	String getModelShortName();
	
	/**
	 * Getter for a dis name representing the model.
	 * 
	 * @return short name for the model
	 */
	String getModelDisplayName();
	
}
