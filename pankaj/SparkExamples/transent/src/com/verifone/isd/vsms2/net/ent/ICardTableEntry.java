package com.verifone.isd.vsms2.net.ent;

public interface ICardTableEntry extends java.io.Serializable
{ 
    public CardData parseInit(CardData rawData);
    
    public CardData getParsedCard();
    
    public INetCCardConfig getISORecord();
    
    public NetCCardConfigSet getMatchSet();
    
    public void addToMatchSet(INetCCardConfig matchingISO);
    
    public void setParsedCard(CardData parsedCard);
    
    public void storeISO(INetCCardConfig netCCard);
    
    public void validateCard() throws NetworkException;
    
    public void validateCard(boolean accountOnly) throws NetworkException;
    
    public void validateExpirationDate() throws NetworkException;
    
    public void checkAvs();
    
    public void checkCvv2();
    
    /**
	 * 
	 * @return the session key used for Master Session
	 */
	public String getSessionKey();

	/**
	 * Store the session key to be used for Debit Master Session
	 * 
	 * @param sessionKey the session key for Debit MS
	 */
	public void setSessionKey(String sessionKey);

}
