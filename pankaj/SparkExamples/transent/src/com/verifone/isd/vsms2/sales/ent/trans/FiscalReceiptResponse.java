package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;

/**
 * Entity class to hold Fiscal receipt response
 * @author Sumith_S1
 *
 */
public class FiscalReceiptResponse implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 6474183509660039785L;

	public static final long MAX_FISCAL_SEQNUM = 99999999;

	public enum Status {
		SEQ_OKAY,
		SEQ_OUT_OF_RANGE,
		SEQ_EXPIRED,
		SEQ_RETRIEVE_FAIL
	}

	private Status status = Status.SEQ_OKAY;
	
	private String authorizationName;
	private String authorizationNumber;
	
	private String receiptTypePrefix;
	private String receiptTypeSequenceNumber;
	
	private String startAuthDate;
	private String endAuthDate;
	
	private String startAuthDateLabel;
	private String endAuthDateLabel;
	
	private String beginSequence;
	private String endSequence;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAuthorizationName() {
		return authorizationName;
	}
	public void setAuthorizationName(String authorizationName) {
		this.authorizationName = authorizationName;
	}

	public String getAuthorizationNumber() {
		return authorizationNumber;
	}
	public void setAuthorizationNumber(String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}

	public String getReceiptTypePrefix() {
		return receiptTypePrefix;
	}
	public void setReceiptTypePrefix(String receiptTypePrefix) {
		this.receiptTypePrefix = receiptTypePrefix;
	}

	public String getReceiptTypeSequenceNumber() {
		return receiptTypeSequenceNumber;
	}
	public void setReceiptTypeSequenceNumber(String receiptTypeSequenceNumber) {
		this.receiptTypeSequenceNumber = receiptTypeSequenceNumber;
	}

	public String getStartAuthDate() {
		return startAuthDate;
	}
	public void setStartAuthDate(String startAuthDate) {
		this.startAuthDate = startAuthDate;
	}

	public String getEndAuthDate() {
		return endAuthDate;
	}
	public void setEndAuthDate(String endAuthDate) {
		this.endAuthDate = endAuthDate;
	}

	public String getStartAuthDateLabel() {
		return startAuthDateLabel;
	}
	public void setStartAuthDateLabel(String startAuthDateLabel) {
		this.startAuthDateLabel = startAuthDateLabel;
	}
	public String getEndAuthDateLabel() {
		return endAuthDateLabel;
	}
	public void setEndAuthDateLabel(String endAuthDateLabel) {
		this.endAuthDateLabel = endAuthDateLabel;
	}
	public String getBeginSequence() {
		return beginSequence;
	}
	public void setBeginSequence(String beginSequence) {
		this.beginSequence = beginSequence;
	}
	public String getEndSequence() {
		return endSequence;
	}
	public void setEndSequence(String endSequence) {
		this.endSequence = endSequence;
	}
	@Override
	public String toString() {
		return "FiscalReceiptResponse [status=" + status
				+ ", authorizationNumber=" + authorizationNumber
				+ ", receiptTypePrefix=" + receiptTypePrefix
				+ ", receiptTypeSequenceNumber=" + receiptTypeSequenceNumber
				+ ", startAuthDate=" + startAuthDate
				+ ", endAuthDate=" + endAuthDate
				+ ", beginSequence=" + beginSequence
				+ ", endSequence=" + endSequence
				+ ", authorizationName=" + authorizationName + "]";
	}

}
