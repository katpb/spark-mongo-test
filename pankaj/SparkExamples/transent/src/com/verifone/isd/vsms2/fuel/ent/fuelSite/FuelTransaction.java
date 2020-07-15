package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.util.PpgDiscDetails;
import com.verifone.isd.vsms2.sys.util.Volume;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;
import org.xml.sax.SAXException;




/**
 *  Implementation class for the fuel transaction entity object.
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelTransaction implements Serializable {
    private Logger logger  = LoggerFactory.getLogger(FuelTransaction.class);
    
    public static final int PRESET_PREPAY   = 0x01;
    public static final int PRESET_POSTPAY  = 0x02;
    public static final int CURRENCY        = 0x04;
    public static final int VOLUME          = 0x08;
    public static final int DCR_TRANSACTION = 0x20;
    public static final int CASH_ACCEPTOR_TXN  = 0x100;
    public static final int AUTO_COLLECT    = 0x200;
    public static final int PAMPOS_TRANSACTION = 0x400;
    
	// values for transaction Due Status
	public static final int SETTLED = 0;
	public static final int DUE = 2;
	public static final int CLAIMED = 3;
	public static final int NEW = 1;
	
	//This constant is used to make sure, that a autocollected
 	//Fuel transaction cannot be recalled/unautocollected multiple times
	public static final int UN_AUTOCOLLECTABLE_COUNT = 2;
	
//	public static final int RESERVED = 3;
//	public static final int FUELING = 4;

	// values for transaction settled for
	// current and stacked sales
	// Current 0x80H Stacked 0x8H
	public static final int CURRENTSETTLED = 128;
	public static final int STACKSETTLED = 8;


	// values for prepaidStatus
	public static final int EVEN = 0;
	public static final int UNDERRUN = 1;
	public static final int OVERRUN = 2;

	private int  fuelSequenceNumber = 0;
	private int  fuelingPositionId = 0;
	private long timeStamp = 0;
	private int dueStatus = SETTLED;
	private int prepaidStatus = EVEN;
	private long receiptNr;
	private int presetType;
	private Quantity limit;
    private MoneyAmount faceMoneyAmt;
    private MoneyAmount facePPV;
    private Volume faceVolume;
    private int  gradeSelected = 0;
    private int slID = 0;
    private int mopID = 0;
    private int tierID = 0;
    private int hoseID = 0;
    private int txnFlags;
    private MoneyAmount origPrice;
    private int unAutoCollect = 0;
    private PpgDiscDetails ppgDiscDetails;
    private MoneyAmount dueAmount;
    private boolean isPumpTest = false;
    /**
     * CR0042.01, flag to indicate whether the transaction is
     * a drive-off candidate
     */
    private boolean driveOff;
    private MoneyAmount mopConvAdjustment;	// adjustment from fueled amount due to MOP convert
    
  
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -3033163363665762427L;
    
    public FuelTransaction() {
    }
    
    /**
     *  @param amount  face amount of the transaction
     *  @param price   face price of the transaction
     *  @param volume  face volume of the transaction
     *  @param grade   grade of the fuel sold in the transaction
     *  @param time    transaction time in milliseconds
     */
    public FuelTransaction(	int txnFlags,
							Quantity limit,
    						MoneyAmount amount,
    						MoneyAmount price,
							Volume volume,
							int grade,
							long time,
							int fuelingPositionId,
							long receiptNr
						) {

        this.txnFlags = txnFlags;
        this.limit = limit;
        this.faceMoneyAmt = amount;
        this.facePPV = price;
        this.faceVolume = volume;
        this.gradeSelected = grade;
        this.timeStamp = time;
        this.fuelingPositionId = fuelingPositionId;
        this.receiptNr = receiptNr;
		
    }
    
    /**
     *  @param amount  face amount of the transaction
     *  @param price   face price of the transaction
     *  @param volume  face volume of the transaction
     *  @param grade   grade of the fuel sold in the transaction
     *  @param time    transaction time in milliseconds
     */
    public FuelTransaction( int txnFlags,
                            Quantity limit,
                            MoneyAmount amount,
                            MoneyAmount price,
                            Volume volume,
                            int grade,
                            long time,
                            int fuelingPositionId,
                            long receiptNr,
                            int slID,
                            int mopID,
                            int tierID,
                            int hoseID,
                            int fuelSequenceNumber,
                            MoneyAmount origPrice
                       ) {

        this.txnFlags = txnFlags;
        this.limit = limit;
        this.faceMoneyAmt = amount;
        this.facePPV = price;
        this.faceVolume = volume;
        this.gradeSelected = grade;
        this.timeStamp = time;
        this.fuelingPositionId = fuelingPositionId;
        this.receiptNr = receiptNr;
        this.slID = slID;
        this.mopID = mopID;
        this.tierID = tierID;
        this.hoseID = hoseID;
        if(fuelSequenceNumber != 0) {
            this.fuelSequenceNumber = fuelSequenceNumber;
        }
		
    }

    /**
     * Copy Constructor
     *  @param aTxn    a FuelTransaction object to clone
     */
    public FuelTransaction(FuelTransaction aTxn ) {

        this.txnFlags = aTxn.txnFlags;
        this.limit = (aTxn.limit == null) ? null : (Quantity) aTxn.limit.clone();
       	this.faceMoneyAmt = (aTxn.faceMoneyAmt == null)? null : (MoneyAmount)aTxn.faceMoneyAmt.clone();
        this.facePPV = (aTxn.facePPV == null)? null: (MoneyAmount)aTxn.facePPV.clone();
        this.faceVolume = (aTxn.faceVolume == null)? null: (Volume)aTxn.faceVolume.clone();
        this.gradeSelected = aTxn.gradeSelected;
        this.timeStamp = aTxn.timeStamp;
        this.fuelingPositionId = aTxn.fuelingPositionId;
        this.receiptNr = aTxn.receiptNr;
        this.slID = aTxn.slID;
        this.mopID = aTxn.mopID;
        this.tierID = aTxn.tierID;
        this.hoseID = aTxn.hoseID;
        this.presetType = aTxn.presetType;
        if(aTxn.fuelSequenceNumber != 0) {
            this.fuelSequenceNumber = aTxn.fuelSequenceNumber;
        }
        this.origPrice = (aTxn.origPrice == null)? null : (MoneyAmount) aTxn.origPrice.clone();
        this.mopConvAdjustment = (aTxn.mopConvAdjustment == null)? null : (MoneyAmount) aTxn.mopConvAdjustment.clone();
        this.dueStatus = aTxn.dueStatus;
        this.prepaidStatus = aTxn.prepaidStatus;
        this.dueAmount = (aTxn.dueAmount == null)? null : (MoneyAmount)aTxn.dueAmount.clone();
        this.unAutoCollect = aTxn.unAutoCollect;
        this.ppgDiscDetails = (aTxn.ppgDiscDetails == null)? null : (PpgDiscDetails) aTxn.ppgDiscDetails.clone();
        this.driveOff = aTxn.driveOff;
        this.isPumpTest = aTxn.isPumpTest;
    }

    /**
     * Set Fuel transaction parameters
     * @param slID (Service level 0=Cash 1=Credit)
     * @param mopID (mopId Id for Cash,Credit,Debit)
     * @param tierID 
     * @param hoseID
     */
    public void setTxnIDValues(int slID, int mopID, int tierID, int hoseID) {
        this.slID = slID;
        this.mopID = mopID;
        this.tierID = tierID;
        this.hoseID = hoseID;
    }
    
    /**
	 * @return true if this is an auto refund fuel transaction
	 */
	public boolean isAutoRefund() {
		return (((txnFlags & 0x20) == 0x20) ? true : false);
	}

	/**
	 * @return true if this is a Cash Acceptor transaction
	 */
	public boolean isCashAcceptorTrans() {
		return (((txnFlags & CASH_ACCEPTOR_TXN) == CASH_ACCEPTOR_TXN) ? true : false);
	}

	/**
	 * @return true if this is a DCR transaction
	 */
	public boolean isDCRTrans() {
		return (((txnFlags & DCR_TRANSACTION) == DCR_TRANSACTION) ? true
				: false);
	}
	
	/**
	 * @return true if this is a PAMPOS transaction
	 */
	public boolean isPamPosTrans() {
		return (((txnFlags & PAMPOS_TRANSACTION) == PAMPOS_TRANSACTION) ? true
				: false);
	}

	/**
	 * 
	 * @return true if this was a fuel prepay transaction
	 */
	public boolean isFuelPrepay() {
		return (((txnFlags & PRESET_PREPAY) == PRESET_PREPAY) ? true : false);
	}

	/**
	 * 
	 * @return true if this is an auto collect fuel transaction
	 */
	public boolean isAutoCollect() {
		return (((txnFlags & AUTO_COLLECT) == AUTO_COLLECT) ? true : false);
	}
    
    /**
	 * the face money amount for the fuel transaction
	 */
    public MoneyAmount getFaceMoneyAmt() {
    	if(null == faceMoneyAmt) {
    		faceMoneyAmt = new MoneyAmount(0);
    	}
        return faceMoneyAmt;
    }
    
    /**
	 * the face money amount to set for the fuel transaction
	 */
    public void setFaceMoneyAmt(MoneyAmount aMoneyAmt) {
    	
        this.faceMoneyAmt =  aMoneyAmt ;
    }
    /**
     *  the face price per volume for the fuel transaction
     */
    public MoneyAmount getFacePPV() {
    	if(null == facePPV) {
    		facePPV = new MoneyAmount(0);
    	}
        return facePPV;
    }
    
    /**
	 * the face price per volume to set for the fuel transaction
	 */
    public void setFacePPV(MoneyAmount aPPV) {
        this.facePPV =  aPPV;
    }
    /**
     *  the face volume for the fuel transaction
     */
    public Volume getFaceVolume() {
    	if(null == faceVolume) {
    		faceVolume = new Volume(0);
    	}
        return faceVolume;
    }
    
    /**
	 * the face volume to set for the fuel transaction
	 */
    public void setFaceVolume(Volume aVolume) {
        this.faceVolume =  aVolume;
    }
    /**
     *  grade of the fuel sold in the fuel transaction
     */
    public int getGradeSelected() {
        return gradeSelected;
    }
    
    
     /**
     * Getter for service level id
     * @return int
     */
    public int getServiceLevelID() {
        return slID;
    }
    
    /**
     * Setter for service level id
     * 
     */
    public void setServiceLevelID(int aSlID) {
        this.slID = aSlID;
    }
    /**
     * Getter for mop id
     * @return int
     */
    public int getMOPID() {
        return mopID;
    }
    
    /**
     * Setter for MOP id
     * 
     */
    public void setMOPID(int aMOPID) {
        this.mopID = aMOPID;
    }
    /**
     * Getter for tier id
     * @return int
     */
    public int getTierID() {
        return tierID;
    }
    
    /**
     * Setter for MOP id
     * 
     */
    public void setTierID(int aTierID) {
        this.tierID = aTierID;
    }
    /**
     * Getter for hose id
     * @return int
     */
    public int getHoseID() {
        return hoseID;
    }
    
    /**
     * Setter for hose id
     * 
     */
    public void setHoseID(int aHoseID) {
        this.hoseID = aHoseID;
    }
    /**
     * Getter for transaction flags
     * @return int
     */
    public int getTransactionFlags() {
        return this.txnFlags;
    }

    
    /**
     * Setter for transaction flags
 
     */
    public void setTransactionFlags(int aTxnFlags) {
      this.txnFlags = aTxnFlags;
    }

    /**
     * Verify if current transaction is settled.
     * @return boolean
     */
    public boolean getCurrentSettled() {
	
	return (( this.txnFlags & CURRENTSETTLED) == CURRENTSETTLED);
    }
    
    /**
     * Verify if the stacked transaction is settled
     * @return boolean
     */
    public boolean getStackSettled() {
	
	return (( this.txnFlags & STACKSETTLED) == STACKSETTLED);
    }
    
    /**
     * Getter for Limit
     * @return Quantity
     */
    public Quantity getLimit() {
        return this.limit;
    }
    
    /**
     * Setter for Limit
     * @return Quantity
     */
    public void setLimit(Quantity aLimit) {
         this.limit = aLimit;
    }
    /**
     * Getter for Limit as a MoneyAmount
     * @return MoneyAmount
     */
    public MoneyAmount getLimitAsMoneyAmount() {
        Quantity limt = getLimit();
        long lim = 0;
        if (limt != null) {
            if (limt instanceof MoneyAmount) {
                lim = limt.getLongValue();
            }
            else {
            	limit = new Quantity(limit.getLongValue(),3,limit.getUOM());
                Quantity origQ = getFacePPV().multiplyByAnything(limt);
                lim = origQ.getLongValue(); 
            }
        }
    	return new MoneyAmount(lim);
    }
    
    /**
     * Getter for receipt number
     * @return long
     */
    public long getReceiptNr() {
        return this.receiptNr;
    }
    
    /**
     * Getter for "fuel sequence number"
     * @return int
     */
    public int getFuelSequenceNumber() {
        return this.fuelSequenceNumber;
    }
    
    /**
     * Setter for "fuel sequence number"
     * @return int
     */
    public void setFuelSequenceNumber(int aFuelSequenceNumber) {
        this.fuelSequenceNumber =  aFuelSequenceNumber;
    }
    
    
    /**
     * Getter for "due status"
     * @return int
     */
    public int getDueStatus() {
        return(dueStatus);
    }
    
    /**
     * Setter for "due status"
     * @param dueStatus
     */
    public void setDueStatus(int dueStatus) {
        this.dueStatus = dueStatus;
    }    
    
    /**
     * Getter for "prepaid status"
     * @return int
     */
    public int getPrepaidStatus() {
        return(prepaidStatus);
    }
    
    /**
     * Setter for "prepaid status"
     * @param prepaidStatus
     */
    public void setPrepaidStatus(int prepaidStatus) {
        this.prepaidStatus = prepaidStatus;
    }    
    
    public void setReceiptNr(long receiptNr) {
		this.receiptNr = receiptNr;
	}
   
    public MoneyAmount getOrigPrice() {
    	if(null == origPrice) {
    		origPrice = new MoneyAmount(0);
    	}
        return this.origPrice;
    }
    
    public void setOrigPrice(MoneyAmount aOrigPrice) {
		this.origPrice = aOrigPrice;
	}
        
    public void setTimeStamp(long aTimeStamp) {
		this.timeStamp = aTimeStamp;
	}

	public long getTimeStamp() {
		return this.timeStamp;
	}
	public void setFuelingPosition(int fp) {
		this.fuelingPositionId = fp;
	}

	public int getFuelingPosition() {
		return this.fuelingPositionId;
	}

	
	public void setGradeSelected(int aGrade) {
		this.gradeSelected = aGrade;
	}

	/**
	 * @param presetType the presetType to set
	 */
	public void setPresetType(int presetType) {
		this.presetType = presetType;
	}

	/**
	 * @return the presetType
	 */
	public int getPresetType() {
		return presetType;
	}

    /**
	 * @param unAutoCollect the unAutoCollect to set
	 */
	public void setUnAutoCollect(int unAutoCollect) {
		this.unAutoCollect = unAutoCollect;
	}

	/**
	 * @return the unAutoCollect
	 */
	public int getUnAutoCollect() {
		return unAutoCollect;
	}

	/**
	 * @param ppgDiscDetails the ppgDiscDetails to set
	 */
	public void setPpgDiscDetails(PpgDiscDetails ppgDiscDetails) {
		this.ppgDiscDetails = ppgDiscDetails;
	}

	/**
	 * @return the ppgDiscDetails
	 */
	public PpgDiscDetails getPpgDiscDetails() {
		if(null == ppgDiscDetails) {
			ppgDiscDetails = new PpgDiscDetails();
		}
		return ppgDiscDetails;
	}

	/**
	 * @param dueAmount the dueAmount to set
	 */
	public void setDueAmount(MoneyAmount dueAmount) {
		this.dueAmount = dueAmount;
	}

	/**
	 * @return the dueAmount
	 */
	public MoneyAmount getDueAmount() {
		if(null == dueAmount) {
			dueAmount = new MoneyAmount(0);
		}
		return dueAmount;
	}

	/**
	 * @param isPumpTest the isPumpTest to set
	 */
	public void setPumpTest(boolean isPumpTest) {
		this.isPumpTest = isPumpTest;
	}

	/**
	 * @return the isPumpTest
	 */
	public boolean getPumpTest() {
		return isPumpTest;
	}

	/**
	 * @return the driveOff
	 */
	public boolean isDriveOff() {
		return driveOff;
	}

	/**
	 * @param driveOff the driveOff to set
	 */
	public void setDriveOff(boolean driveOff) {
		this.driveOff = driveOff;
	}

	public MoneyAmount getMopConvAdjustment() {
		if(null == mopConvAdjustment) {
			mopConvAdjustment = new MoneyAmount(0);
		}
		return mopConvAdjustment;
	}

	public void setMopConvAdjustment(MoneyAmount mopConvAdjustment) {
		this.mopConvAdjustment = mopConvAdjustment;
	}

	/**
     *	This method calls back into the FuelVisitor#visit() method of the visitor object
     *   @param v an instance of one of the FuelVisitor's subclasses
     *   @exception SAXException if the visitor encounters any error during XML serialization
     */
    public void accept(FuelVisitor v) throws SAXException {
        v.visit(this);
    }
	
}
