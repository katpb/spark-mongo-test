package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.sys.l10n.FuelViewRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.ISapphireCollectionCtrl;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;


/**
 *  <code>FuelSite</code> is the implementation class for the fuel site
 *  entity object. This is a singleton class. <p>
 *  Creation of the singleton object is done at startup.
 *  Based on the property setting, either a new instance is
 *  created or a previously serialized FuelSite object is
 *  deserialized. <p>
 *  @see IFuelSite
 *  @author "mailto:david_ezell@verifone.com"
 */
public class FuelSite implements IFuelSite, IFuelEntityVisitable, Serializable {

	private Logger logger = LoggerFactory.getLogger(FuelSite.class);
    // Change this serialVersionUID if any incompatible changes are made to this class
	private static final long serialVersionUID = 6816659315281187398L;
    private ISapphireCollection fuelingPositionColl = null;
    private ISapphireCollection serviceLevelColl = null;
    private ISapphireCollection MOPColl = null;
    private ISapphireCollection tankColl = null;
    private ISapphireCollection naxFuelProductColl = null;
    private ISapphireCollection tierColl = null;
    private ISapphireCollection productColl = null;
    private ISapphireCollection blendTypeColl = null;
    private String UOM;
    private boolean ignoreMOPConflict = true;
    private boolean sixDigitsProtocol;
    private String haltMode;
    private Quantity autoDisapprovalDelay;
    private int startPostpayHrs;
    private int numPostpayHrs;
    private int startManApproval;
    private int numManApproval;
    private int startTier2Hrs;
    private int numTier2Hrs;
    private boolean approveAllEnabled;
    private boolean forcePt9CentsPerGal;
    private boolean autoCollectInside;
    private long saleDataFreq;
    private boolean priceChanged ;
    private int currentTierIndex;
    private int timeTierIndex;
    private int ppuDecPosition;
    private int totalDecPosition;
    private int inEffectRCFConfig = 0;

    /** holds value of setting fpOfflineNotify
     */
    private int fpOfflineNotify = 0;
    /** Holds value of property autoSettleOverrunEnabled. */
    private boolean autoSettleOverrunEnabled;
    
    private boolean enforcePromptingInside;
    private boolean promptRestrictionOutside;
    private boolean requireAttendantCard;

    public FuelSite() {
        this.fuelingPositionColl = FuelingPositionCollFactory.create();
        this.serviceLevelColl = FuelServiceLevelCollFactory.create();
        this.MOPColl = FuelMOPCollFactory.create();
        this.tankColl = FuelTankCollFactory.create();
        this.naxFuelProductColl = NAXFuelProductCollFactory.create();
        this.tierColl = FuelTierCollFactory.create();
        this.productColl = FuelProductCollFactory.create();
        this.blendTypeColl = FuelBlendTypeCollFactory.create();
		this.createDefaultObjects();
    }

    public FuelSite(FuelSite orig) throws FuelException {
        this();
        this.deepCopyFrom(orig);
    }

    public final void deepCopyFrom(IFuelSite orig) throws FuelException {
        
        this.approveAllEnabled = orig.isApproveAllEnabled();
        this.autoCollectInside = orig.isAutoCollectInside();
        this.saleDataFreq = orig.getSaleDataFreq();
        this.forcePt9CentsPerGal = orig.isForcePt9CentsPerGal();
        this.ignoreMOPConflict = orig.isIgnoreMOPConflict();
        this.sixDigitsProtocol = orig.isSixDigitsProtocol();
        this.currentTierIndex = orig.getCurrentTierIndex();
        this.numManApproval = orig.getNumManApprovalHrs();
        this.numPostpayHrs = orig.getNumPostpayHrs();
        this.ppuDecPosition = orig.getPPUDecPosition();
        this.startManApproval = orig.getStartManApprovalHrs();
        this.startPostpayHrs = orig.getStartPostpayHrs();
        this.startTier2Hrs = orig.getStartTier2Hrs();
        this.numTier2Hrs = orig.getNumTier2Hrs();
        this.totalDecPosition = orig.getTotalDecPosition();
        this.priceChanged = orig.isPriceChanged();
        this.enforcePromptingInside = orig.getEnforcePromptingInside();
        this.promptRestrictionOutside = orig.getPromptRestrictionOutside();
        this.inEffectRCFConfig = orig.getInEffectRapidChangeConfig();
        this.requireAttendantCard = orig.getRequireAttendantCard();
        
        Quantity delay = orig.getAutoDisapprovalDelay();
        if (delay != null) {
            this.autoDisapprovalDelay = (Quantity) delay.clone();
        }
        this.UOM = orig.getUOM();
        this.haltMode = orig.getHaltMode();
        this.fpOfflineNotify = orig.getFPOfflineNotify();

        Enumeration enumr = orig.getServiceLevelColl().elements();
        while (enumr.hasMoreElements()) {
            FuelServiceLevel sl = (FuelServiceLevel) enumr.nextElement();
            this.serviceLevelColl.addElement(new FuelServiceLevel(sl));
        }

        enumr = orig.getBlendTypeColl().elements();
        while (enumr.hasMoreElements()) {
            FuelBlendType bl = (FuelBlendType) enumr.nextElement();
            this.blendTypeColl.addElement(new FuelBlendType(bl));
        }

        enumr = orig.getMOPColl().elements();
        while (enumr.hasMoreElements()) {
            FuelMOP mop = (FuelMOP) enumr.nextElement();
            this.MOPColl.addElement(new FuelMOP(mop));
        }

        enumr = orig.getTankColl().elements();
        while (enumr.hasMoreElements()) {
            FuelTank tank = (FuelTank) enumr.nextElement();
            this.tankColl.addElement(new FuelTank(tank));
        }

        enumr = orig.getNAXFuelProductColl().elements();
        while (enumr.hasMoreElements()) {
            NAXFuelProduct naxProd = (NAXFuelProduct) enumr.nextElement();
            this.naxFuelProductColl.addElement(new NAXFuelProduct(naxProd));
        }

        enumr = orig.getTierColl().elements();
        while (enumr.hasMoreElements()) {
            FuelTier tier = (FuelTier) enumr.nextElement();
            this.tierColl.addElement(new FuelTier(tier));
        }

        enumr = orig.getProductColl().elements();
        while (enumr.hasMoreElements()) {
            FuelProduct prod = (FuelProduct) enumr.nextElement();
            this.productColl.addElement(new FuelProduct(prod));
        }

        enumr = orig.getFuelingPositionColl().elements();
        while (enumr.hasMoreElements()) {
            FuelingPosition fp = (FuelingPosition) enumr.nextElement();
            this.fuelingPositionColl.addElement(new FuelingPosition(fp));
        }
    }

    @Override
    public boolean getPromptRestrictionOutside() {
		return promptRestrictionOutside;
	}

    @Override
	public void setPromptRestrictionOutside(boolean promptRestrictionOutside) {
		this.promptRestrictionOutside = promptRestrictionOutside;
	}

    @Override
	public boolean getEnforcePromptingInside() {
		return enforcePromptingInside;
	}

    @Override
	public void setEnforcePromptingInside(boolean enforcePromptingInside) {
		this.enforcePromptingInside = enforcePromptingInside;
	}

    /*
     *   Implementation method
     *   @see IFuelSite#getFuelingPositionColl()
     */
    @Override
    public ISapphireCollection getFuelingPositionColl() throws FuelException {
        if (fuelingPositionColl == null) {
            throw new FuelException(FuelViewRes.ERROR_SITE_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        return fuelingPositionColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setFuelingPositionColl()
     */
    @Override
    public void setFuelingPositionColl(ISapphireCollection fpColl) throws FuelException {
        if (fuelingPositionColl == null) {
            throw new FuelException(FuelViewRes.ERROR_SITE_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        this.fuelingPositionColl = fpColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getServiceLevelColl()
     */
    @Override
    public ISapphireCollection getServiceLevelColl() {
        return serviceLevelColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getMOPColl()
     */
    @Override
    public ISapphireCollection getMOPColl() {
        return MOPColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getTankColl()
     */
    @Override
    public ISapphireCollection getTankColl() {
        return tankColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getNAXFuelProductColl()
     */
    @Override
    public ISapphireCollection getNAXFuelProductColl() {
        return naxFuelProductColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getTierColl()
     */
    @Override
    public ISapphireCollection getTierColl() {
        return tierColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getCurrentTierIndex()
     */
    @Override
    public int getCurrentTierIndex() {
        return (currentTierIndex);
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setCurrentTierIndex()
     */
    @Override
    public void setCurrentTierIndex(int newIndex) {
        currentTierIndex = newIndex;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getTimeTierIndex()
     */
    public int getTimeTierIndex() {
        return (timeTierIndex);
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setTimeTierIndex()
     */
    public void setTimeTierIndex(int newIndex) {
        timeTierIndex = newIndex;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getProductColl()
     */
    @Override
    public ISapphireCollection getProductColl() {
        return productColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getBlendTypeColl()
     */
    @Override
    public ISapphireCollection getBlendTypeColl() {
        return blendTypeColl;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getCurrentTier()
     */
    @Override
    public FuelTier getCurrentTier() {
        if (tierColl.getCount() > 0) {
            return (FuelTier) tierColl.get(currentTierIndex);
        } else {
            return null;
        }
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setCurrentTier()
     */
    @Override
    public void setCurrentTier(int number) throws FuelException {
        if ((number <= 0) || (number > IFuelSite.MAX_TIERS)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer tierNumber = Integer.valueOf(number);
            exceptionParams.add(tierNumber);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TEIR, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        currentTierIndex = number;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setPPUDecPosition()
     */
    @Override
    public void setPPUDecPosition(int ppuDecPosition) throws FuelException {
        if ((ppuDecPosition < 0) || (ppuDecPosition > IFuelSite.MAX_PPUDECPOSITION)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(ppuDecPosition);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_PPU_DEC, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.ppuDecPosition = ppuDecPosition;
        ISapphireCollection coll = this.getProductColl();
        Enumeration product = coll.elements();
        while (product.hasMoreElements()) {
            ((FuelProduct) product.nextElement()).setPPUDecPosition(this.ppuDecPosition);
        }


    }

    /*
     *   Implementation method
     *   @see IFuelSite#setPPUDecPosition()
     */
    @Override
    public int getPPUDecPosition() {
        return this.ppuDecPosition;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setTotalDecPosition()
     */
    @Override
    public void setTotalDecPosition(int totalDecPosition) throws FuelException {
        if ((totalDecPosition < 0) || (totalDecPosition > IFuelSite.MAX_TOTALDECPOSITION)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(totalDecPosition);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TOT_DEC, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.totalDecPosition = totalDecPosition;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setTotalDecPosition()
     */
    @Override
    public int getTotalDecPosition() {
        return this.totalDecPosition;
    }

    /**
     *  @exception java.lang.Throwable thrown per the spec
     */
    @Override
    protected void finalize() throws java.lang.Throwable {
        if (SysPropertyFactory.reportFinalizers()) {
            logger.info("finalize " + this.getClass().getName());
        }
        super.finalize();
    }

    /*
     *   Implementation method
     *   @see IFuelSite#accept(FuelEntityVisitor)
     */
    @Override
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setUOM(String)
     */
    @Override
    public void setUOM(String newUOM) {
        if (newUOM != null) {
            if ((newUOM.equals("USG")) || (newUOM.charAt(0) == 'G')) {
                UOM = newUOM;
            } else {
                UOM = "L";
            }
        }
    }

    /*
     *   Implementation method
     *   @see IFuelSite#getUOM()
     */
    @Override
    public String getUOM() throws FuelException {
        return UOM;
    }
    /*
     *   Implementation method
     *   @see IFuelSite#setIgnoreMOPConflict(boolean)
     */

    @Override
    public void setIgnoreMOPConflict(boolean newVal) {
        this.ignoreMOPConflict = newVal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setIgnoreMOPConflict()
     */
    @Override
    public boolean isIgnoreMOPConflict() {
        return this.ignoreMOPConflict;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setSixDigitsProtocol(boolean)
     */
    @Override
    public void setSixDigitsProtocol(boolean newVal) {
        this.sixDigitsProtocol = newVal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#isSixDigitsProtocol()
     */
    @Override
    public boolean isSixDigitsProtocol() {
        return this.sixDigitsProtocol;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setHaltMode(String)
     */
    @Override
    public void setHaltMode(String haltMode) {
        char hm = 0;
        if (haltMode != null && haltMode.length() > 0) {
            hm = haltMode.charAt(0);
        }
        if ((hm == 'H') || (hm == 'h')) {
            this.haltMode = "Hard";
        } else {
            this.haltMode = "Soft";
        }
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setHaltMode()
     */
    @Override
    public String getHaltMode() {
        return this.haltMode;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setAutoDisapprovalDelay(Quantity)
     */
    @Override
    public void setAutoDisapprovalDelay(Quantity delay) throws FuelException {
        if (delay == null) {
            autoDisapprovalDelay = new Quantity(0, 1, "Minutes");
        } else {
            long delayVal = delay.getLongValue();
            if ((delayVal < 0)
                    || (delayVal > ((IFuelSite.MAX_AUTODISAPPROVALDELAY * 10) / 60))
                    || ((delayVal % 5) != 0)) {

                ArrayList exceptionParams = new ArrayList(1);
                exceptionParams.add(delay);
                throw new FuelException(FuelViewRes.ERROR_INVALID_AUTODS_DELAY, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
            }
            autoDisapprovalDelay = delay;
        }
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setAutoDisapprovalDelay()
     */
    @Override
    public Quantity getAutoDisapprovalDelay() {
        return autoDisapprovalDelay;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setStartPostpayHrs()
     */
    @Override
    public void setStartPostpayHrs(int startHr) throws FuelException {
        if ((startHr < 0) || (startHr > 23)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(startHr);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_POSTPAY_START_HR, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.startPostpayHrs = startHr;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setStartPostpayHrs()
     */
    @Override
    public int getStartPostpayHrs() {
        return this.startPostpayHrs;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setNumPostpayHrs()
     */
    @Override
    public void setNumPostpayHrs(int numHrs) throws FuelException {
        if ((numHrs < 0) || (numHrs > 24)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(numHrs);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_POSTPAY_NUM_HR, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.numPostpayHrs = numHrs;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setNumPostpayHrs()
     */
    @Override
    public int getNumPostpayHrs() {
        return this.numPostpayHrs;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setStartManApprovalHrs()
     */
    @Override
    public void setStartManApprovalHrs(int startHr) throws FuelException {
        if ((startHr < 0) || (startHr > 23)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(startHr);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_MANAPPR_START_HR, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.startManApproval = startHr;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setStartManApprovalHrs()
     */
    @Override
    public int getStartManApprovalHrs() {
        return this.startManApproval;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setnumManApprovalHrs()
     */
    @Override
    public void setNumManApprovalHrs(int numHrs) throws FuelException {
        if ((numHrs < 0) || (numHrs > 24)) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(numHrs);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_MANAPPR_NUM_HR, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.numManApproval = numHrs;
    }

    /**
	 * @return the startTier2Hrs
	 */
	@Override
	public int getStartTier2Hrs() {
		return startTier2Hrs;
	}

	/**
	 * @param startTier2Hrs the startTier2Hrs to set
	 */
	@Override
	public void setStartTier2Hrs(int startTier2Hrs) {
		this.startTier2Hrs = startTier2Hrs;
	}

	/**
	 * @return the numTier2Hrs
	 */
	@Override
	public int getNumTier2Hrs() {
		return numTier2Hrs;
	}

	/**
	 * @param numTier2Hrs the numTier2Hrs to set
	 */
	@Override
	public void setNumTier2Hrs(int numTier2Hrs) {
		this.numTier2Hrs = numTier2Hrs;
	}

	/*
     *   Implementation method
     *   @see IFuelSite#setnumManApprovalHrs()
     */
    @Override
    public int getNumManApprovalHrs() {
        return this.numManApproval;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setStartTier2Hrs()
     */
    @Override
    public void setTier2(int startHr, int numHrs) throws FuelException {
        if ((startHr < 0) || (startHr > 23) || (numHrs < 0) || (numHrs > 24)) {

            ArrayList exceptionParams = new ArrayList(2);
            Integer intExceptionParam1 = Integer.valueOf(startHr);
            Integer intExceptionParam2 = Integer.valueOf(numHrs);
            exceptionParams.add(intExceptionParam1);
            exceptionParams.add(intExceptionParam2);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TIER_DETAILS, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        FuelTier[] tiers = null;
        if (numHrs == 0) {
            tiers = new FuelTier[1];
            tiers[0] = new FuelTier(1, 0, 24);
        } else {
            tiers = new FuelTier[2];
            tiers[0] = new FuelTier(1, (startHr + numHrs) % 24, 24 - numHrs);
            tiers[1] = new FuelTier(2, startHr, numHrs);
        }
        Vector list = new Vector();
        for (int i = 0; i < tiers.length; i++) {
            list.addElement(tiers[i]);
        }
        if (tierColl instanceof ISapphireCollectionCtrl) {
            ((ISapphireCollectionCtrl) tierColl).setElements(list.elements());
        }
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setApproveAllEnabled()
     */
    @Override
    public void setApproveAllEnabled(boolean newVal) {
        this.approveAllEnabled = newVal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setApproveAllEnabled()
     */
    @Override
    public boolean isApproveAllEnabled() {
        return this.approveAllEnabled;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setForcePt9CentsPerGal()
     */
    @Override
    public void setForcePt9CentsPerGal(boolean newVal) {
        this.forcePt9CentsPerGal = newVal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setForcePt9CentsPerGal()
     */
    @Override
    public boolean isForcePt9CentsPerGal() {
        return this.forcePt9CentsPerGal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setAutoCollectInside()
     */
    @Override
    public void setAutoCollectInside(boolean newVal) {
        this.autoCollectInside = newVal;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setAutoCollectInside()
     */
    @Override
    public boolean isAutoCollectInside() {
        return this.autoCollectInside;
    }

    /*
     *   Implementation method
     *   @see IFuelSite#setSaleDataFreq()
     */
    @Override
    public void setSaleDataFreq(long newVal) {
        this.saleDataFreq = newVal;
    }
    
    /*
     *   Implementation method
     *   @see IFuelSite#getSaleDataFreq()
     */
    @Override
    public long getSaleDataFreq(){
    	return this.saleDataFreq;
    }
    
    public final void createDefaultObjects() {
        Vector list = new Vector();

        for (int i = 1; i <= IFuelSite.MAX_SERVICELEVELS; i++) {
            FuelServiceLevel sl = new FuelServiceLevel(i, FuelServiceLevel.getDefaultName(i));
            list.addElement(sl);
        }
        if (serviceLevelColl instanceof ISapphireCollectionCtrl) {
            ((ISapphireCollectionCtrl) serviceLevelColl).setElements(list.elements());
        }
        list.clear();

        for (int i = 1; i <= IFuelSite.MAX_MOPS; i++) {
            FuelMOP mop = new FuelMOP(i , FuelMOP.getDefaultName(i));
            list.addElement(mop);
        }
        if (MOPColl instanceof ISapphireCollectionCtrl) {
            ((ISapphireCollectionCtrl) MOPColl).setElements(list.elements());
        }
        list.clear();

        for (int i = 1; i <= IFuelSite.MAX_BLENDTYPES; i++) {
            FuelBlendType bl = new FuelBlendType(i, FuelBlendType.getDefaultName(i));
            list.addElement(bl);
        }
        if (blendTypeColl instanceof ISapphireCollectionCtrl) {
            ((ISapphireCollectionCtrl) blendTypeColl).setElements(list.elements());
        }
    }

    /** Getter for property autoSettleOverrunEnabled.
     * @return Value of property autoSettleOverrunEnabled.
     *
     */
    @Override
    public boolean isAutoSettleOverrunEnabled() {
        return this.autoSettleOverrunEnabled;
    }

    /** Setter for property autoSettleOverrunEnabled.
     * @param autoSettleOverrunEnabled New value of property autoSettleOverrunEnabled.
     *
     */
    @Override
    public void setAutoSettleOverrunEnabled(boolean autoSettleOverrunEnabled) {
        this.autoSettleOverrunEnabled = autoSettleOverrunEnabled;
    }

    /** Setter for FuelProductColl
     * @param fuelProductColl
     *
     */
    @Override
    public void setFuelProductColl(ISapphireCollection fuelProductColl) {
        this.productColl = (FuelProductColl) fuelProductColl;
    }

    /**
     *   Implementation method
     * @see IFuelSite#getFPOfflineNotify()
     * @return int value for fpOfflineNotify
     */
    @Override
    public int getFPOfflineNotify() {
        return (this.fpOfflineNotify);
    }

    /**
     *   Implementation method
     * @see IFuelSite#setFPOfflineNotify(int)
     * @param newFPOfflineNotify new int value for fpOfflineNotify
     * @throws FuelException thrown if new value is out of range
     */ 
    @Override
    public void setFPOfflineNotify(int newFPOfflineNotify) throws FuelException {
        if (newFPOfflineNotify < 0) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(newFPOfflineNotify);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_FP_OFFLINE_NOTIFY, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.fpOfflineNotify = newFPOfflineNotify;
    }

    /**
     * @return the priceChanged
     */
    @Override
    public boolean isPriceChanged() {
        return this.priceChanged;
    }

    /**
     * @param priceChanged the priceChanged to set
     */
    @Override
    public void setPriceChanged(boolean priceChanged) {
        this.priceChanged = priceChanged;
    }
	
	
	/**
     * Derives all fuel products available on specified fuel point.
     * 
     * @param fp				FuelPoint
     * @return FuelProduct[] 	Products available for selection
     * @author Satish_P1
     */
	@Override
	public FuelProduct[] findGradesOnPump(int fp){
		ArrayList fuelGrades = new ArrayList();
		try{
			ISapphireCollection coll = this.getFuelingPositionColl();
			FuelingPosition posn = (FuelingPosition) coll.get(new Integer(fp));
			coll = this.getProductColl();
			FuelHose[] hoses = posn.getHosesWithDistinctProducts();

			for (int i = 0; i < hoses.length; i++) {
				int grade = hoses[i].getProductID();
				FuelProduct fuelProd = (FuelProduct) coll.get(new Integer(grade));
				fuelGrades.add(fuelProd);
				
			}
		}catch(Exception e){
			logger.error("Error occurred in finding grades on pump for FP[{}] : ",fp, e);
		}
		return (FuelProduct[]) fuelGrades.toArray(new FuelProduct[0]); 
	}
	
	/** Method to compare to FuelSite objects for equality
	 * @param obj FuelSite object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelSite)) {
				return false;
			}
			FuelSite aFuelSite = (FuelSite) obj;
			
			return new EqualsBuilder().append(this.approveAllEnabled, aFuelSite.approveAllEnabled)
									  .append(this.autoCollectInside, aFuelSite.autoCollectInside)
									  .append(this.autoSettleOverrunEnabled, aFuelSite.autoSettleOverrunEnabled)
									  .append(this.enforcePromptingInside, aFuelSite.enforcePromptingInside)
									  .append(this.forcePt9CentsPerGal, aFuelSite.forcePt9CentsPerGal )
									  .append(this.fpOfflineNotify, aFuelSite.fpOfflineNotify)
									  .append(this.ignoreMOPConflict, aFuelSite.ignoreMOPConflict)
									  .append(this.sixDigitsProtocol, aFuelSite.sixDigitsProtocol)
									  .append(this.numManApproval, aFuelSite.numManApproval)
									  .append(this.numPostpayHrs, aFuelSite.numPostpayHrs)
									  .append(this.numTier2Hrs,aFuelSite.numTier2Hrs)
									  .append(this.ppuDecPosition,aFuelSite.ppuDecPosition)
									  .append(this.startManApproval,aFuelSite.startManApproval)
									  .append(this.startPostpayHrs,aFuelSite.startPostpayHrs)
									  .append(this.startTier2Hrs,aFuelSite.startTier2Hrs)
									  .append(this.promptRestrictionOutside,aFuelSite.promptRestrictionOutside)
									  .append(this.totalDecPosition, aFuelSite.totalDecPosition)
									  .append(this.UOM, aFuelSite.UOM)
									  .append(this.haltMode,aFuelSite.haltMode)
									  .append(this.autoDisapprovalDelay,aFuelSite.autoDisapprovalDelay)
									  .append(this.serviceLevelColl, aFuelSite.serviceLevelColl)
									  .append(this.MOPColl, aFuelSite.MOPColl)
									  .append(this.tankColl,aFuelSite.tankColl)
									  .append(this.tierColl,aFuelSite.tierColl)
									  .append(this.blendTypeColl,aFuelSite.blendTypeColl)
									  .append(this.productColl, aFuelSite.productColl)
									  .append(this.fuelingPositionColl,aFuelSite.fuelingPositionColl)
									  .append(this.naxFuelProductColl,aFuelSite.naxFuelProductColl)
									  .append(this.saleDataFreq, aFuelSite.saleDataFreq)
									  .append(this.inEffectRCFConfig, aFuelSite.inEffectRCFConfig)
									  .append(this.requireAttendantCard, aFuelSite.requireAttendantCard)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.approveAllEnabled)
		   .append(this.autoCollectInside)
		   .append(this.autoSettleOverrunEnabled)
		   .append(this.enforcePromptingInside)
		   .append(this.forcePt9CentsPerGal)
		   .append(this.fpOfflineNotify)
		   .append(this.ignoreMOPConflict)
		   .append(this.sixDigitsProtocol)
		   .append(this.numManApproval)
		   .append(this.numPostpayHrs)
		   .append(this.numTier2Hrs)
		   .append(this.ppuDecPosition)
		   .append(this.startManApproval)
		   .append(this.startPostpayHrs)
		   .append(this.startTier2Hrs)
		   .append(this.promptRestrictionOutside)
		   .append(this.totalDecPosition)
		   .append(this.UOM)
		   .append(this.haltMode)
		   .append(this.autoDisapprovalDelay)
		   .append(this.serviceLevelColl)
		   .append(this.MOPColl)
		   .append(this.tankColl)
		   .append(this.tierColl)
		   .append(this.blendTypeColl)
		   .append(this.productColl)
		   .append(this.fuelingPositionColl)
		   .append(this.naxFuelProductColl)
		   .append(this.inEffectRCFConfig)
		   .append(this.requireAttendantCard)
		   .toHashCode();
	}

	@Override
	public int getInEffectRapidChangeConfig() {
		return inEffectRCFConfig;
	}

	@Override
	public void setInEffectRapidChangeConfig(int inEffectRCF) {
		this.inEffectRCFConfig = inEffectRCF;
	}

	@Override
	public void setRequireAttendantCard(boolean requireAttendantCard) {
		this.requireAttendantCard = requireAttendantCard;
		
	}

	@Override
	public boolean getRequireAttendantCard() {
		return this.requireAttendantCard;
	}

}
