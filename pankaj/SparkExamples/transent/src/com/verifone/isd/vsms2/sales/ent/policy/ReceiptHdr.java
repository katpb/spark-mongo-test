package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sys.util.FormattedLine;

public class ReceiptHdr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322846497150131415L;
	private boolean isEnabled;

	private final List<FormattedLine> hdrLines;
	public static final int MAXRECEIPTLINELENGTH = 20;

	public ReceiptHdr() {
		hdrLines = new ArrayList<>();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<FormattedLine> getHdrLines() {
		return hdrLines;
	}

}
