package com.verifone.isd.vsms2.sales.ent.popdiscount;


/**
 * Entity for card type member discount type
 */
public class CardTypeMemberDiscount implements IPopDiscountType
{
    static final long serialVersionUID = 614992282294142035L;
    /**
     * Maximum value for track offset
     */    
    public static final int MAX_TRACK_OFFSET = 99;
    /**
     * Maximum value for track offset
     */    
    public static final int MAX_TRACK_NUMBER = 2;

    private String mask;
    private boolean isAllowManualEntry;
    private int track1Offset;
    private int track2Offset;
    private int trackPreference;
    
    /**
     * No-args constructor
     */    
    public CardTypeMemberDiscount() {
    }

    /**
     * Setter for mask property
     * @param mask Digits that will start or end each Membership
     * Card (example: 4012************ for a Visa mag stripe).
     */    
    public void setMask(String mask) {
        this.mask = mask;
    }
    
    /**
     * Getter for mask property
     * @return Mask for the membership card account
     */    
    public String getMask() {
        return this.mask;
    }

    /**
     * Setter for allowManualEntry property
     * @param isAllowManualEntry If true, allow the cashier to manually enter the card number
     */    
    public void setAllowManualEntry(boolean isAllowManualEntry) {
        this.isAllowManualEntry = isAllowManualEntry;
    }
    
    /**
     * Getter for allowManualEntry property
     * @return If true, allow the cashier to manually enter the card number
     */    
    public boolean isAllowManualEntry() {
        return this.isAllowManualEntry;
    }

    /**
     * Setter for track 1 offset
     * @param track1Offset track 1 offset
     */    
    public void setTrack1Offset(int track1Offset) {
        this.track1Offset = track1Offset;
    }
    
    /**
     * Getter for track 1 offset
     * @return track 1 offset
     */    
    public int getTrack1Offset() {
        return this.track1Offset;
    }

    /**
     * Setter for track 2 offset
     * @param track2Offset track 2 offset
     */    
    public void setTrack2Offset(int track2Offset) {
        this.track2Offset = track2Offset;
    }
    
    /**
     * Getter for track 2 offset
     * @return track 2 offset
     */    
    public int getTrack2Offset() {
        return this.track2Offset;
    }

    /**
     * Setter for track preference
     * @param trackPreference track preference
     */    
    public void setTrackPreference(int trackPreference) {
        this.trackPreference = trackPreference;
    }
    
    /**
     * Getter for track preference
     * @return track preference
     */    
    public int getTrackPreference() {
        return this.trackPreference;
    }

    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if ((track1Offset < 0) || (track1Offset > CardTypeMemberDiscount.MAX_TRACK_OFFSET)) {
            throw new Exception("Invalid Track 1 Offset: " + track1Offset + " for POP Discount");
        }
        if ((track2Offset < 0) || (track2Offset > CardTypeMemberDiscount.MAX_TRACK_OFFSET)) {
            throw new Exception("Invalid Track 2 Offset: " + track2Offset + " for POP Discount");
        }
        if ((trackPreference < 0) || (trackPreference > CardTypeMemberDiscount.MAX_TRACK_NUMBER)) {
            throw new Exception("Invalid Track Preference: " + trackPreference + " for POP Discount");
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.MEMBERSHIP_BASED;
    }
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return false;
	}
}