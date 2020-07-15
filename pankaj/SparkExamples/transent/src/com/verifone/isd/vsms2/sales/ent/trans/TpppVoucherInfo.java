/*
 * TpppVoucherInfo.java
 *
 * Created on September 21, 2017, 11:30 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.AcctPrintInfo;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCode;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.NetworkRes;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;
import com.verifone.isd.vsms2.sys.util.FormattedLine;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Helper entity for Transaction that holds information related to
 * Third Party Product when it is part of a sale.
 * @author Peder_K1
 */
public class TpppVoucherInfo implements Serializable {
    
	static final long serialVersionUID = 5978062565389305985L;

	public static final int INITIAL_REQ_PENDING = 1;
	public static final int INITIAL_VOUCH_REQ_SUCCESSFUL = 2;
	public static final int INITIAL_VOUCH_REQ_FAILURE = 3;
	public static final int FINALIZE_VOUCH_REQ_SUCCESSFUL = 4;
	public static final int ACKNOWLEDGE_VOUCH_REQ_SUCCESSFUL = 5;
	
	private String description;
    
    private String entryMethod;
    
    private int tpppStatus;          // Pending, successful or failed
    private String refNum;
    private FormattedLine[] merchTextLines;		// receipt message for merchant copy
    private FormattedLine[] custTextLines;		// receipt message for customer copy
	private FormattedLine[] custSupplementTextLines; //receipt message for customer gift copy (chit)

	private String networkName; // Network in which the Third Party Product item is configured.
	private String extendedUpc; // Extended UPC information coming with Third Party Product extended UPC items.
	private String barCodeScannedInformation; //The entire full scanned bar code to be sent to Third Party Product Provier
	private String barCodeID;//The first four characters from barCodeScannedInformation
    

	
    /** Creates a new instance of TpppVoucherInfo */
    public TpppVoucherInfo() {
        this.merchTextLines = new FormattedLine[0];
        this.custTextLines = new FormattedLine[0];
		this.custSupplementTextLines = new FormattedLine[0];
    }
    
    public String getEntryMethod() {
        return this.entryMethod;
    }
    
    public void setEntryMethod(String entryMethod) {
        this.entryMethod = entryMethod;
    }
    
    public int getTpppStatus() {
        return this.tpppStatus;
    }
    
    public void setTpppStatus(int tpppStatus) {
        this.tpppStatus = tpppStatus;
    }
 
    public String getRefNum() {
        return this.refNum;
    }
    
    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

	/**
	 * @return Returns the custCopyText.
	 */
	public String[] getCustCopyText() {
		String[] lines = new String[custTextLines.length];
		for (int i = 0; i < custTextLines.length; i++) {
			if (custTextLines[i] != null) {
				lines[i] = custTextLines[i].getLine();
			}
		}
		return lines;
	}
	/**
	 * @param custCopyText The custCopyText to set.
	 */
	public void setCustCopyText(String[] custCopyText) {
		this.custTextLines = new FormattedLine[custCopyText.length];
		for (int i = 0; i < custCopyText.length; i++) {
			this.custTextLines[i] = new FormattedLine();
			this.custTextLines[i].setLine(custCopyText[i]);
		}
	}
	/**
	 * @return Returns the custSupplementText.
	 */
	public String[] getCustSupplementText() {
		String[] lines = null;
		if(custSupplementTextLines != null){
			lines = new String[custSupplementTextLines.length];
			for (int i = 0; i < custSupplementTextLines.length; i++) {
				if (custSupplementTextLines[i] != null) {
					lines[i] = custSupplementTextLines[i].getLine();
				}
			}
		}
		return lines;
	}
	/**
	 * @param custSupplementText The custSupplementText to set.
	 */
	public void setCustSupplementText(String[] custSupplementTex) {
		if(custSupplementTex != null){
			this.custSupplementTextLines = new FormattedLine[custSupplementTex.length];
			for (int i = 0; i < custSupplementTex.length; i++) {
				this.custSupplementTextLines[i] = new FormattedLine();
				this.custSupplementTextLines[i].setLine(custSupplementTex[i]);
			}
		}
	}
	
	/**
	 * @return Returns the merchCopyText.
	 */
	public String[] getMerchCopyText() {
		String[] lines = new String[merchTextLines.length];
		for (int i = 0; i < merchTextLines.length; i++) {
			if (merchTextLines[i] != null) {
				lines[i] = merchTextLines[i].getLine();
			}
		}
		return lines;
	}
	
	/**
	 * @param merchCopyText The merchCopyText to set.
	 */
	public void setMerchCopyText(String[] merchCopyText) {
		this.merchTextLines = new FormattedLine[merchCopyText.length];
		for (int i = 0; i < merchCopyText.length; i++) {
			this.merchTextLines[i] = new FormattedLine();
			this.merchTextLines[i].setLine(merchCopyText[i]);
		}
	}


    /**
	 * @return the custTextLines
	 */
	public FormattedLine[] getCustTextLines() {
		return custTextLines;
	}

	/**
	 * @param custTextLines the custTextLines to set
	 */
	public void setCustTextLines(FormattedLine[] custTextLines) {
		this.custTextLines = custTextLines;
	}

	/**
	 * @return the merchTextLines
	 */
	public FormattedLine[] getMerchTextLines() {
		return merchTextLines;
	}

	/**
	 * @param merchTextLines the merchTextLines to set
	 */
	public void setMerchTextLines(FormattedLine[] merchTextLines) {
		this.merchTextLines = merchTextLines;
	}

	/**
     * Make operations across all entities in a transaction polymorphic with
     * the abstract visitor class -- all we do is call it's visit() method
     * and pass a reference to our actual type.  The visitor will have a
     * method with a signature that matches our type and automatically use it.
     * Different visitor implementations can be created any time to generate
     * new results against all the known entities in a transaction.
     *
     * <B>NOTE</B> that adding a new data type as an argument to the visit()
     * method means the abstract class (TransactionVisitor) and all the
     * visitor implementations must be updated.  We don't expect to be doing
     * this much.
     *
     * @param		v
     * @exception	Exception
     */
    
    public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getExtendedUpc() {
		return extendedUpc;
	}

	public void setExtendedUpc(String extendedUpc) {
		this.extendedUpc = extendedUpc;
	}	

	public FormattedLine[] getCustSupplementTextLines() {
		return custSupplementTextLines;
	}

	public void setCustSupplementTextLines(FormattedLine[] custSupplementTextLines) {
		this.custSupplementTextLines = custSupplementTextLines;
	}

	/**
	 * This method will check the TpppVoucherInfo is an Third Party Product type by checking the networkName 
	 * present or not.
	 * @return : Is Third Party Product item or not.
	 */
	
	public boolean isTpppVoucherItem(){
		boolean isTpppVoucherItem = false;
		if(networkName!= null && networkName.trim().length() > 0) {
			isTpppVoucherItem = true;
		}
		return isTpppVoucherItem;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBarCodeScannedInformation() {
		return barCodeScannedInformation;
	}

	public void setBarCodeScannedInformation(String barCodeScannedInformation) {
		this.barCodeScannedInformation = barCodeScannedInformation;
	}
		
	public String getBarCodeID() {
			return barCodeID;
	}

	public void setBarCodeID(String barCodeID) {
		this.barCodeID = barCodeID;
	}
}
 