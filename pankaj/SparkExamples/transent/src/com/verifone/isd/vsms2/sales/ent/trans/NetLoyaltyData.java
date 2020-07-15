/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.verifone.isd.vsms2.sys.util.FormattedLine;

/**
 * @author anindya_d1
 *
 */
public class NetLoyaltyData implements Serializable {
	static final long serialVersionUID = -82391761999857526L;
	
	private int stan; // STAN for linking loyalty messages to EPS
	private String terminalID;	// Terminal ID from previous card service response
	private String terminalBatch;	// Terminal batch from previous card service response
	private Calendar timeStamp;		// Time stamp from previous card service response
	private boolean completionProcessed;	// whether loyalty completion was already sent
	private boolean completionFailed;	// loyalty completion failed, no need to retry
	private FormattedLine[] merchCopyLines;		// merchant copy loyalty text
	private FormattedLine[] custCopyLines;		// customer copy loyalty text
	private Map<String, LoyaltyAuthDetails> loyAuthInfo;	// loyalty auth details (one per program)
	private String epsName; //Loyalty epsName
	 private String failureResult;	// indicates OverallResult for a failed loyalty or advice
	
	/**
	 * 
	 */
	public NetLoyaltyData() {
		loyAuthInfo = new TreeMap<String, LoyaltyAuthDetails>();
	}
	/**
	 * @return the stan
	 */
	public int getStan() {
		return stan;
	}
	/**
	 * @param stan the stan to set
	 */
	public void setStan(int stan) {
		this.stan = stan;
	}
	/**
	 * @return the completionProcessed
	 */
	public boolean isCompletionProcessed() {
		return completionProcessed;
	}
	/**
	 * @param completionProcessed the completionProcessed to set
	 */
	public void setCompletionProcessed(boolean completionProcessed) {
		this.completionProcessed = completionProcessed;
	}

	/**
	 * @return the merchCopyLines
	 */
	public FormattedLine[] getMerchCopyLines() {
		return merchCopyLines;
	}
	/**
	 * @param merchCopyLines the merchCopyLines to set
	 */
	public void setMerchCopyLines(FormattedLine[] merchCopyLines) {
		this.merchCopyLines = merchCopyLines;
	}
	/**
	 * @return the custCopyLines
	 */
	public FormattedLine[] getCustCopyLines() {
		return custCopyLines;
	}
	/**
	 * @param custCopyLines the custCopyLines to set
	 */
	public void setCustCopyLines(FormattedLine[] custCopyLines) {
		this.custCopyLines = custCopyLines;
	}
	
	/**
	 * @return all loyalty authorization information
	 */
	public LoyaltyAuthDetails[] getLoyaltyAuth() {
		return loyAuthInfo.values().toArray(new LoyaltyAuthDetails[0]);
	}

	public LoyaltyAuthDetails getLoyaltyAuth(String programId) {
		return ((programId != null) ? loyAuthInfo.get(programId) : null);
	}
	
	public Set<Entry<String, LoyaltyAuthDetails>> getLoyaltyAuthEntries(){
		return loyAuthInfo.entrySet();
	}
	
	/**
	 * Store loyalty authorization information for a given program (one entry
	 * per program)
	 * 
	 * @param auth
	 */
	public void addLoyaltyAuth(LoyaltyAuthDetails auth) {
		loyAuthInfo.put(auth.getProgramID(), auth);
	}
	/**
	 * @return the terminalID
	 */
	public String getTerminalID() {
		return terminalID;
	}
	/**
	 * @param terminalID the terminalID to set
	 */
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	/**
	 * @return the terminalBatch
	 */
	public String getTerminalBatch() {
		return terminalBatch;
	}
	/**
	 * @param terminalBatch the terminalBatch to set
	 */
	public void setTerminalBatch(String terminalBatch) {
		this.terminalBatch = terminalBatch;
	}
	/**
	 * @return the timeStamp
	 */
	public Calendar getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Calendar timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the epsName
	 */
	public String getEpsName() {
		return epsName;
	}
	/**
	 * @param epsName the epsName to set
	 */
	public void setEpsName(String epsName) {
		this.epsName = epsName;
	}
	
	/** 
	 * @return the completionFailed
	 */
	public boolean isCompletionFailed() {
		return completionFailed;
	}
	/**
	 * @param completionFailed the completionFailed to set
	 */
	public void setCompletionFailed(boolean completionFailed) {
		this.completionFailed = completionFailed;
	}
	
	/**
	 * @return the failureResult
	 */
	public String getFailureResult() {
		return failureResult;
	}

	/**
	 * @param failureResult the failureResult to set
	 */
	public void setFailureResult(String failureResult) {
		this.failureResult = failureResult;
	}
	/**
	 * Determine if EPS sent receipt details in a loyalty transaction. This will
	 * be used to offer receipt choices at the DCR when a payment card is declined
	 * after a successful loyalty transaction.
	 * 
	 * @return true if EPS provided loyalty receipt information 
	 */
	public boolean hasEpsReceipt() {
		boolean epsReceipt = false;
		if ((merchCopyLines != null && merchCopyLines.length > 0)
				|| (custCopyLines != null && custCopyLines.length > 0)) {
			epsReceipt = true;
		}
		return epsReceipt;
	}
}
