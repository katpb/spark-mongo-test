package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sys.util.MemberCardType;

/**
 * Entity for card based discount
 */
public class CardBasedDiscount implements IPopDiscountType
{
    static final long serialVersionUID = -4082239033530127581L;
    /**
     * Maximum value for cardType property
     */    
    public static final int MAX_CARDNAME_LENGTH = 16;
    
    private String cardName;
    private MemberCardType memberCardRequired;
    private CardBinDiscount binDiscount;
    
    /**
     * Constructor
     * @param cardName Card name
     */    
    public CardBasedDiscount(String cardName) {
        this.cardName = cardName;
        this.binDiscount = new CardBinDiscount();
    }

    /**
     * No-args constructor
     */    
    public CardBasedDiscount() {
        this("");
    }
    
    public CardBinDiscount getBinDiscount() {
        return binDiscount;
    }

    /**
     * Setter for card name
     * @param cardName Card name
     */    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    /**
     * Getter for card name
     * @return card name
     */    
    public String getCardName() {
        return this.cardName;
    }

    /**
     * Getter for memberCardRequired property
     * @return If true, a membership card is required
     */    
    public MemberCardType getMemberCardRequired() {
        return this.memberCardRequired;
    }

    /**
     * Setter for memberCardRequired property
     * @param memberCardRequired If true, a membership card is required
     */    
    public void setMemberCardRequired(MemberCardType memberCardRequired) {
        this.memberCardRequired = memberCardRequired;
    }

    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (cardName == null || cardName.trim().length() == 0 || cardName.trim().length() > CardBasedDiscount.MAX_CARDNAME_LENGTH) {
            throw new Exception("Invalid cardName: " + cardName + " for POP Discount");
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.CARD_BASED;
    }

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return (memberCardRequired == MemberCardType.ANY_CARD);
	}
}