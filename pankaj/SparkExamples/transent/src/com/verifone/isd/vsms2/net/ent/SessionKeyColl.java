/**
 * 
 */
package com.verifone.isd.vsms2.net.ent;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 * @author Anindya_d1
 *
 */
public class SessionKeyColl {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.SessionKeyColl.class);
	private static final int DEF_TOPAZ_REGID = 101;
	/**
	 * If different registers use different session keys (for a specific debit
	 * host), the following flag will be true. When all registers use the same
	 * session key (for a specific debit host), the default register ID (101)
	 * will be used as the key to the <code>registerKeys</code> HashMap.
	 */
	private boolean multiMS;	
	private HashMap registerKeys;	// key is register number

	public SessionKeyColl() {
		registerKeys = new HashMap();
	}

	/**
	 * @return the multiMS
	 */
	public boolean isMultiMS() {
		return multiMS;
	}

	/**
	 * @param multiMS the multiMS to set
	 */
	public void setMultiMS(boolean multiMS) {
		this.multiMS = multiMS;
	}
	
	/**
	 * Clear all session keys stored for all registers
	 * 
	 */
	public void clearSessionKeys() {
		this.registerKeys.clear();
	}

	/**
	 * Store the session key for a given register and debit host. If all Topaz
	 * registers are using the same session key for a given debit host, then a
	 * unique register ID key (e.g. 101) should be used while storing session
	 * keys in the above HashMap. This will ensure that the size of the HashMap
	 * is 1. This is used by the retrieve method when multiple Topaz registers
	 * request for the session key.
	 * 
	 * @param registerID
	 * @param debitHost
	 * @param sessionKey
	 */
	public void storeSessionKey(int registerID, int debitHost, String sessionKey) {
		Integer regIDKey = null;
		/*
		 * When different registers use the same session key for a specific
		 * debit host, use the default register ID (101) to store the session
		 * key in this collection
		 */
		if (multiMS) {
			regIDKey = new Integer(registerID);
		} else {
			regIDKey = new Integer(DEF_TOPAZ_REGID);
		}
		// Determine if there is an existing entry for the register
		RegisterKeyColl coll = (RegisterKeyColl) registerKeys.get(regIDKey);
		if (coll == null) {
			coll = new RegisterKeyColl();
			registerKeys.put(regIDKey, coll);
		}
		coll.storeDebitHostKey(debitHost, sessionKey);
	}
	
	/**
	 * Return the session key for the given debit host to the requesting Topaz
	 * register. The session key information is attached to the card table entry
	 * returned from Newpro to Topaz during a debit transaction.
	 * 
	 * @param registerID
	 *            register requesting the session key
	 * @param debitHost
	 *            debit host from the debit ISO record
	 * @return the session key for the given register and debit host
	 */
	public String retrieveSessionKey(int registerID, int debitHost) {
		String sessionKey = null;
		RegisterKeyColl coll = null;
		Integer regIDKey = null;
		if (registerKeys.isEmpty()) {
			logger.error("No session keys available on Newpro");
		} else if (multiMS) {
			/*
			 * If different registers are using different session keys, simply
			 * retrieve the session key for the given debit host from the
			 * register specific collection.
			 */
			regIDKey = new Integer(registerID);
		} else {
			/*
			 * Do not rely on the register ID key if all registers are using the
			 * same session key for a specific debit host. The default register
			 * id (101) was used to store the session key in this collection.
			 */
			regIDKey = new Integer(DEF_TOPAZ_REGID);
		}
		coll = (RegisterKeyColl) registerKeys.get(regIDKey);
		if (coll != null) {
			sessionKey = coll.retrieveDebitHostKey(debitHost);
		}
		return sessionKey;
	}
	
	/**
	 * @author Anindya_D1
	 * 
	 * Inner class to represent the debit host specific keys for a given
	 * register
	 */
	private class RegisterKeyColl {
		private HashMap debitHosts;	// key is debit host

		public RegisterKeyColl() {
			debitHosts = new HashMap();
		}
		
		/**
		 * Store the session key for the given debit host.
		 * 
		 * @param debitHost
		 *            debit host defined in Debit ISO record
		 * @param sessionKey
		 *            session key for the given debit host
		 */
		public void storeDebitHostKey(int debitHost, String sessionKey) {
			Integer debHostKey = new Integer(debitHost);
			debitHosts.put(debHostKey, sessionKey);
		}
		
		/**
		 * 
		 * @param debitHost
		 *            debit host from the debit ISO record
		 * @return the session key for the given debit host
		 */
		public String retrieveDebitHostKey(int debitHost) {
			Integer debHostKey = new Integer(debitHost);
			String sessionKey = (String) debitHosts.get(debHostKey);
			return sessionKey;
		}
	}
}
