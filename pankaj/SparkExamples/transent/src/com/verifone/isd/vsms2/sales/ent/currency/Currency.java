package com.verifone.isd.vsms2.sales.ent.currency;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import java.text.MessageFormat;

/** Entity class for currency
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class Currency implements IEntityObject, ISalesEntityVisitable {
    private static final long serialVersionUID = -63836734820927467L;

    public static final int PRIMARY_CURRENCY_ID = 1;
    /** Maximum currencies
     */
    public static final int MAX_CURRENCIES = 2;
    /** Maximum exchange rate */    
    public static final int MAX_EXCHANGE_RATE = 999999999;
    /** Base exchange rate */    
    public static final int BASE_EXCHANGE_RATE = 1000000;
    /** Number of decimals */    
    public static final int NUM_DECIMALS = 6;
    /** Maximum number of chars in currency symbol */
    private static final int CURRENCY_SYMBOL_MAX_LENGTH = 2;

    private CurrencyPK ID;
    private String name;
    private String code;
    private String symbol;
    private Quantity exchangeRate;
    private String printNamePluralOne;
    private String printNamePluralOther;
    
    /** No-args constructor
     */
    public Currency() {
        this(null);
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */
    public Currency(CurrencyPK pk) {
        this.ID = pk;
        this.name = "";
        this.code = "";
        this.symbol = "";
        this.exchangeRate = new Quantity(BASE_EXCHANGE_RATE, NUM_DECIMALS, "");
		this.printNamePluralOne = "";
		this.printNamePluralOther = "";
    }
    
    /** Setter for property name
     * @param name name of the entity
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property name
     * @return name of the entity
     */
    public String getName() {
        return this.name;
    }

    /** 
     * Setter for entity code, the primary code will not be modified.
     * 
     * @param code code of the entity
     */
    public void setCode(String code) {
        this.code = code;
    }

    /** Getter for property code
     * @return code of the entity
     */
    public String getCode() {
        return this.code;
    }

    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Getter for currency symbol
     * @return currency symbol
     */    
    public String getSymbol() {
        return this.symbol;
    }
    
    /** Setter for currency symbol
     * @param symbol currency symbol
     */    
    public void setSymbol(String symbol) {
        if (symbol == null) {
            this.symbol="";
        }
        else {
            this.symbol = symbol;
        }
    }
    
    /** Getter for exchangeRate
     * @return exchangeRate
     */    
    public Quantity getExchangeRate() {
        return this.exchangeRate;
    }
    
    /** Setter for exchangeRate
     * @param newRate new exchange rate
     */    
    public void setExchangeRate(Quantity newRate) {
        if (newRate == null) {
            this.exchangeRate = new Quantity(BASE_EXCHANGE_RATE, NUM_DECIMALS, "");
        }
        else {
            this.exchangeRate = newRate;
        }
        if (this.ID != null && this.ID.getValue() == Currency.PRIMARY_CURRENCY_ID)  { 
            long exchVal = this.exchangeRate.getNumDecimals();   
            if (exchVal > 1 && exchVal % 10 == 0) { // Force the primary currency rate to always be 6 digits
                this.exchangeRate = new Quantity(BASE_EXCHANGE_RATE, NUM_DECIMALS, "");
            } //No need to handle else condition here since validate would throw exception if required.
        }
    }

	public String getPrintNamePluralOne() {
		return printNamePluralOne;
	}

	public void setPrintNamePluralOne(String printNamePluralOne) {
		this.printNamePluralOne = printNamePluralOne;
	}

	public String getPrintNamePluralOther() {
		return printNamePluralOther;
	}

	public void setPrintNamePluralOther(String printNamePluralOther) {
		this.printNamePluralOther = printNamePluralOther;
	}

    /** Method to clone another entity with this enity's attributes
     * @param obj entity to copy to
     */
    public void setAttributes(IEntityObject obj) {
        Currency cObj = (Currency) obj;
        cObj.ID = this.ID;
        cObj.name = this.name;
        cObj.setCode(this.code);
        cObj.setSymbol(this.getSymbol());
        cObj.setExchangeRate(this.getExchangeRate());
        cObj.printNamePluralOne = this.printNamePluralOne;
        cObj.printNamePluralOther = this.printNamePluralOther;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (CurrencyPK)pk;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid currency: " +this.ID);
        }
        if ((this.name == null) || (this.name.trim().equals("")) ||
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for currency: " +ID);
        }
        if ((this.code == null) || (this.code.trim().equals("")) ||
            (this.code.trim().equals("*"))) {
            throw new Exception("Invalid null code for currency: " +ID);
        } else {
            if ((this.ID.getValue() != PRIMARY_CURRENCY_ID)
                    && (MoneyAmount.getPrimaryCurrencyCode().equals(this.code))){
                String msg=MessageFormat.format("Invalid duplicated code {1} "
                        + "for currency: {2}", new Object[]{this.code, ID});
                throw new Exception(msg);
            }
            /**
             * Validates if this.code is a valid currency code.
             */
            try {
                java.util.Currency curr=java.util.Currency.getInstance(this.code);
            } catch (IllegalArgumentException e) {
                String msg=MessageFormat.format("Invalid code {1} for currency: {2}",
                        new Object[]{this.code, ID});
                throw new Exception(msg);
            }
        }
        long exchVal = this.exchangeRate.getLongValue();
        if ((exchVal < 0) || (exchVal > MAX_EXCHANGE_RATE)) {
            throw new Exception("Invalid exchange rate: "
            +exchangeRate.toString() +" for Currency: " +ID);
        }
        if ((this.ID.getValue() == Currency.PRIMARY_CURRENCY_ID) && (exchVal != BASE_EXCHANGE_RATE)) {
            throw new Exception("Base currency exchange rate can only be "
            +(new Quantity(BASE_EXCHANGE_RATE,NUM_DECIMALS,"")).toString() +" actual value = " +this.exchangeRate);
        }
        if (this.symbol.length() > CURRENCY_SYMBOL_MAX_LENGTH){
            throw new Exception("Invalid symbol for currency: " +ID);
        }
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}
