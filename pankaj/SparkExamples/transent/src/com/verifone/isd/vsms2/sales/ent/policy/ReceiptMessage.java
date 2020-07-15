package com.verifone.isd.vsms2.sales.ent.policy;

import com.verifone.isd.vsms2.sys.util.FormattedLine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity that receive the configuration of the Receipt Message action in the
 * Rules Manager.
 * 
 * @author
 */
public class ReceiptMessage implements Serializable {
 
    private static final long serialVersionUID = 7196930369154738487L;
    
	private boolean insideEnabled;
	private boolean outsideEnabled;
	private final List<FormattedLine> insideLines;
	private final List<FormattedLine> outsideLines;
	public static int INSIDE_MAXRECEIPTLINELENGTH 	= 40;  
	public static int OUTSIDE_MAXRECEIPTLINELENGTH 	= 20;

	public ReceiptMessage(){
		insideLines = new ArrayList<FormattedLine>();
		outsideLines = new ArrayList<FormattedLine>();
	}

	public boolean isEnabledInside() {
		return insideEnabled;
	}

	public void setEnabledInside(boolean enabled) {
		this.insideEnabled = enabled;
	}

	public boolean isEnabledOutside() {
		return outsideEnabled;
	}

	public void setEnabledOutside(boolean enabled) {
		this.outsideEnabled = enabled;
	}

	public List<FormattedLine> getInsideLines() {
		return insideLines;
	}

	public List<FormattedLine> getOutsideLines() {
		return outsideLines;
	}
}
