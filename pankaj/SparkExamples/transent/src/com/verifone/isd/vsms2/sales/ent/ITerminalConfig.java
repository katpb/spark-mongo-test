package com.verifone.isd.vsms2.sales.ent;

import java.util.List;

/**
 * 
 * @author PravijaK1
 *
 */
public interface ITerminalConfig {
	/**
	 * Get the configured receipt header messages for Terminal
	 * @return
	 */
	public List<IReceiptMsgConfig> getHeaderMsgs();
	/**
	 * Get the configured receipt trailer messages for Terminal
	 * @return
	 */
	
	public List<IReceiptMsgConfig> getTrailerMsgs();
	/**
	 * Determines whether the terminal type supports the
	 * group configuration
	 * @return
	 */
	public boolean isGroupConfigSupported();
	/***
	 * Returns the associated terminal group sysId
	 * @return
	 */
	public int getGroupSysID();
}
