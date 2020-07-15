/*
 * NetECPRequest.java
 *
 * Created on May 05, 2003, 9:20 AM
 */
package com.verifone.isd.vsms2.net.ent;

/** NetECPRequest represents all the transaction data needed to create a network SEV
 * request message that will be sent to Gemix.  
 *
 * @see NetTransReq
 * @author kelvin_f1
 * @version 1.0
 *
 */
public class NetECPRequest implements  java.io.Serializable
{
    static final long serialVersionUID = 7957828279525817516L;
	
    private CardData cardData;          // Account #, expiration date, track data
    private NetworkRequest networkRequest;  // Network specific transaction information
    private INetCCardConfig isoRecord;   // Card type card table information
    private NetProductCol netProducts;	// Network product information
    private RefundData refundInfo;      // Refund specific information
    private EncryptPreauthInfo encryptCardData;	// holds encrypted values of sensitive card data

    /** No Arguments Constructor method. Creates a new NetECPRequest object that will hold all
     * the data needed to create a network transaction to be sent to Gemix.
     */    
    public NetECPRequest()
    {

    }

    /** Constructor method. Contains all the data required to create a network request
     * transaction to be sent to Gemix.
     * @param cardData Card data the account number, expiry date, track data, etc.
     * @param networkRequest Transaction amount, type, and other data needed to create a network transaction
     * request.
     * @param isoRecord Card table entry data for the specific card type.
     * @param netProducts The network product details.
     */    
    public NetECPRequest(CardData cardData, NetworkRequest networkRequest, 
                         INetCCardConfig isoRecord, NetProductCol netProducts, 
                         RefundData data)
    {

        this.cardData = cardData;
        this.networkRequest = networkRequest;
        this.isoRecord = isoRecord;
        this.netProducts = netProducts;
        this.refundInfo = data;
    }

    /** Setter method that sets a reference to the card data.
     * @param cardData Account number, expiry date, and track data.
     */    
    public void setCardData(CardData cardData)
    {
        this.cardData = cardData;
    }
    
    /** Getter method that retrieves a reference to the card data.
     * @return Card data, account number, exiry data, and track data.
     */    
    public CardData getCardData()
    {
        return this.cardData;
    }
    
    /** Setter method that sets a reference to the network request data.
     * @param networkRequest Network transaction information, amount, type, and other data needed to create a
     * network request message.
     */    
    public void setNetworkRequest(NetworkRequest networkRequest)
    {
        this.networkRequest = networkRequest;
    }
    
    /** Getter method to retrieve the a reference to the network request data.
     * @return Network transaction information, amount, type, and other data needed to create a
     * network request message.
     */    
    public NetworkRequest getNetworkRequest()
    {
        return this.networkRequest;
    }
    
    /** Setter method to set a reference to the card table data.
     * @param isoRecord card table information for a specific card type.
     */    
    public void setIsoRecord(INetCCardConfig isoRecord)
    {
        this.isoRecord = isoRecord;
    }
    
    /** Getter method to retrieve a reference to the card table data.
     * @return card table information for a specific card type.
     */    
    public INetCCardConfig getIsoRecord()
    {
        return this.isoRecord;
    }
    
    /** Setter method sets a reference to the collection of network products.
     * @param netProducts Collection of network product information.
     */    
    public void setNetProducts(NetProductCol netProducts)
    {
        this.netProducts = netProducts;
    }

    /** Getter method that returns a reference to the collection of network production
     * information.
     * @return Collection of network product information.
     */    
    public NetProductCol getNetProducts()
    {
        return this.netProducts;
    }

    public void setRefundInfo(RefundData data) {
        this.refundInfo = data;
    }
    
    public RefundData getRefundInfo() {
        return this.refundInfo;
    }
    
	/**
	 * @return Returns the encryptCardData.
	 */
	public EncryptPreauthInfo getEncryptCardData() {
		return encryptCardData;
	}
	/**
	 * @param encryptCardData The encryptCardData to set.
	 */
	public void setEncryptCardData(EncryptPreauthInfo encryptCardData) {
		this.encryptCardData = encryptCardData;
	}
	
	/**
	 * Determine if the network request object has a valid cash back amount.
	 * This will be used to determine whether to display change amount to
	 * cashier/customer during prepay completion. Customer receives the change
	 * (for cashback) during pre-auth, so there is no need to display this again
	 * at the time of completion.
	 * 
	 * @return true if this contains a cash back amount
	 */
	public boolean containsCashback() {
		boolean cashback = false;
		try {
			if (networkRequest.getCashBack().getLongValue() != 0) {
				cashback = true;
			}
		} catch (Exception e) {
		}
		return cashback;
	}
}
