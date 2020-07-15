package com.verifone.isd.vsms2.sys.util;
import com.ibm.icu.text.PluralRules;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ibm.icu.text.RuleBasedNumberFormat;
import com.ibm.icu.util.ULocale;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.Optional;

/** 
 * Represent Money amount.
 * <p>
 * This class is designed to have the currency type inside of the each instance.
 * <p>
 * The currency type is represented using the {@link java.util.Currency} class. The
 * default currency type is the primary currency type configured in the PSI installer
 * This value comes from the read-only property sys.money.primary.currency_code.
 * <p>
 * If there is any error trying to read the property then "USD" is used as the
 * primary currency.<p>
 * The Default # of implied decimals is 2, unless explicitly specified by the 
 * property 'sys.money.decimals'.
 * <p>
 * For calculations, use the methods {@link #add(Quantity)},
 * {@link #mpy(Quantity)}, {@link #div(Quantity)}, {@link #mod(Quantity)},
 * {@link #sub(Quantity)} instead. Do not use {@link #getLongValue()}.
 */
public class MoneyAmount extends Quantity implements Serializable, Cloneable {
	/**
     * serial version uid
     */
	private static final long serialVersionUID = 7062736156071531451L;

    private static final int DEFAULT_NUMDECIMALS = 2;
    private static final int NUMDECIMALS;

	private static final String DEFAULT_CURRENCY_SIGN = "$";
	private static final String DEFAULT_CURRENCY_CODE = "USD";
    private static final String PRIMARY_CURRENCY_CODE;

    /**
     * Localize and change \u00a4 by the un-escaped character.
     * 
     */
    private static final String ENFORCED_FORMAT = "\u00a4#,##0.00;\u00a4-#,##0.00";
    private static final String OLD_FORMAT = "\u00a4###0.00;\u00a4-###0.00";
    private static final String VERBOSE_FORMAT = "{0} {1}{2}";
    private static final String VERBOSE_DEC_FORMAT = "{0}/100 ";

    /**
     * This map will store the primary and secondary currency symbol configured
     * in ConfigClient. These will be updated after a RefreshConfig invocation.
     * The initial capacity is 2 and it should not have more than two elements
     * at a time.
     */
    private static final Map<String, String> CURRENCY_SYMBOLS = 
            new ConcurrentHashMap<String, String>(2);

    /**
     * This map will store the primary and secondary currency print name configured
     * in ConfigClient. These will be updated after a RefreshConfig invocation.
     * The initial capacity is 2 and it should not have more than two elements
     * at a time.
     */
    private static final Map<String, String> CURRENCY_VERBOSE_NAME = 
            new ConcurrentHashMap<String, String>(2);

    /**
     * Do not add mutators for the currency, this attribute is immutable a new
     * instance needs to be created to change it.
     */
    private Currency currency;

    static {
        int val = DEFAULT_NUMDECIMALS;
        String uom=DEFAULT_CURRENCY_CODE;
        try {
            String defVal = SysPropertyFactory.getProperty("sys.money.decimals", String.valueOf(DEFAULT_NUMDECIMALS));
            val = Integer.parseInt(defVal);
        } catch (Exception e) {
        } finally {
            NUMDECIMALS = val;
        }
        try {
            uom = SysPropertyFactory.getProperty(
                    "sys.money.primary.currency_code", uom);
        } catch (Exception e) {
        } finally {
            PRIMARY_CURRENCY_CODE = uom;
        }
    }

    /**
     * Creates a new MoneyAmount with the default number of decimals(2), the 
     * primary currency code and the long value.
     * 
     * @param value amount with implied decimals (as defined by the default
     * number of decimals
     */
    public MoneyAmount(long value) {
        this(value, NUMDECIMALS, PRIMARY_CURRENCY_CODE);
    }

	/**
     * Creates a new MoneyAmount with the default number of decimals(2), the 
     * primary currency code and the value parsed from the string.
     * 
     * @param value string that represents the amount with decimal notation "0.00"
     */
    public MoneyAmount(String value) {
        this(value, NUMDECIMALS, PRIMARY_CURRENCY_CODE);
    }

    /**
     * Creates an new MoneyAmount and assign the currency type of the {@code orig}
     * to the new instance.
     * 
     * This object cannot be clonable because the currency type is final and a
     * clone method would not be able to write it.
     * 
     * @param orig original object to be cloned
     */
    public MoneyAmount(MoneyAmount orig) {
        super(orig);
        currency = Currency.getInstance(orig.getCurrencyCode());
    }

    /** Constructor.
     * @param value Money amount in cents
     * @param numDecimals Number of implied decimals
     */
    public MoneyAmount(long value, int numDecimals) {
        this(value, numDecimals, PRIMARY_CURRENCY_CODE);
    }

    /** Constructor
     * @param value amount with implied decimals (as defined by the default
     * number of decimals
     * @param currencyCode ISO 4217 code of the currency type 
     */
    public MoneyAmount(long value, String currencyCode) {
        this(value, NUMDECIMALS, currencyCode);
    }

    /** Constructor
     * @param val string that represents the amount with decimal notation "0.00"
     * @param numDecs Number of implied decimals
     */
    public MoneyAmount(String val, int numDecs) {
        this(val, numDecs, PRIMARY_CURRENCY_CODE);
    }

    /** Constructor
     * @param value amount with implied decimals (as defined by the default
     * number of decimals
     * @param numDecimals Number of implied decimals
     * @param currencyCode ISO 4217 code of the currency type
     */
    public MoneyAmount(long value, int numDecimals, String currencyCode) {
        super(value, numDecimals, currencyCode);
        currency=Currency.getInstance(currencyCode);
    }

    /** Constructor
     * @param val string that represents the amount with decimal notation "0.00"
     * @param currencyCode ISO 4217 code of the currency type
     */
    public MoneyAmount(String val, String currencyCode) {
        super(val, currencyCode);
        currency=Currency.getInstance(currencyCode);
    }

    /** Constructor
     * @param val string that represents the amount with decimal notation "0.00"
     * @param numDecs Number of implied decimals
     * @param currencyCode ISO 4217 code of the currency type
     */
    public MoneyAmount(String val, int numDecs, String currencyCode) {
        super(val, numDecs, currencyCode);
        currency=Currency.getInstance(currencyCode);
    }

    /**
     * Getter for default number of implied decimals
     * @return default number of implied decimals
     */
    public static final int getDefaultNumDecimals() {
        return MoneyAmount.NUMDECIMALS;
    }

    /**
     * @deprecated since Base047 use {@link  #getCurrencyCode()} instead.
     * @return 
     */
    @Override
    @Deprecated
    public String getUOM() {
        return getCurrencyCode();
    }

    /**
     * @deprecated since Base047 use {@link  #getCurrencyCode()} instead.
     * @return 
     */
    @Deprecated
    public static String getDefaultUOM() {
        return PRIMARY_CURRENCY_CODE;
    }

	/**
	 * @deprecated
	 * For calculations, use the methods {@link #add(Quantity)},
	 * {@link #mpy(Quantity)}, {@link #div(Quantity)}, {@link #mod(Quantity)},
	 * {@link #sub(Quantity)} instead.
	 * <p>
	 * To get the numeric value use {@link #toBigDecimal()} instead.
	 * @return 
	 */
	@Deprecated
	@Override
	public long getLongValue() {
		return super.getLongValue();
	}

	/**
	 * Gets the ISO 4217 code of the primary currency
	 * @return the ISO 4217 code of the primary currency
	 * @since Base047
	 */
	public static String getPrimaryCurrencyCode() {
		return PRIMARY_CURRENCY_CODE;
	}

	/**
	 * Gets the ISO 4217 code of the currency of this MoneyAmount.
	 * 
	 * @return the ISO 4217 code of the currency of this MoneyAmount.
	 * @since Base047
	 */
	public String getCurrencyCode(){
		return currency.getCurrencyCode();
	}

	/**
	 * Gets the symbol of the currency of this MoneyAmount as configured in 
	 * ConfigClient. If no symbol can be determined the {@code "$"} dollar symbol
	 * is returned.
	 * 
	 * @return the symbol of the currency of this MoneyAmount as configured in
	 * configClient.
	 * @since Base047
	 */
	public String getCurrencySymbol(){
		if (CURRENCY_SYMBOLS.containsKey(currency.getCurrencyCode())){
			return CURRENCY_SYMBOLS.get(currency.getCurrencyCode());
		} else {
			return DEFAULT_CURRENCY_SIGN;
		}
	}
	
	/**
	 * Associates the currency symbol with the code specified.
	 * <p>
	 * If there were already a code defined, the old symbol is replaced. A 
	 * {@link ConcurrentHashMap} object stores the references.
	 * 
	 * @param code that is going to be associated with the symbol
	 * @param symbol to be associated to the code
	 * @return the previous symbol associated to the code, or null if the code
	 * was not previously associated.
	 * @since Base047
	 */
	public static String setCurrencySymbols(String code, String symbol){
		return CURRENCY_SYMBOLS.put(code, symbol);
	}

	/**
	 * Returns true if the currency code of this MoneyAmount corresponds to the
	 * primary currency code.
	 * 
	 * @return true if the currency code of this MoneyAmount corresponds to the 
	 * primary currency code.
	 * @since Base047
	 */
	public boolean isPrimaryCurrency() {
		return PRIMARY_CURRENCY_CODE.equals(currency.getCurrencyCode());
	}

    /**
	 * Get method
	 * 
	 * @return the divisor to use to get dollars or cents
	 */
    public static final long getDefaultDivisor() {
        long divisor = 1;
        for (int i = 0; i < NUMDECIMALS; i++) {
            divisor *= 10;
        }
        return divisor;
    }

	/**
	 * Return the absolute value of this MoneyAmount object in a separate
	 * MoneyAmount object
	 * 
	 * @return a separate MoneyAmount object containing the absolute value of
	 *         this MoneyAmount object
	 */
	public MoneyAmount abs() {
		MoneyAmount absVal = (MoneyAmount) this.clone();
		if (absVal.getLongValue() < 0) {
			absVal.neg();
		}
		return absVal;
	}	

	/**
	 * Converts this MoneyAmount to a BigDecimal.
	 * <p>
	 * The new object will lose any reference of the currency type.
	 * 
	 * @return this MoneyAmount converted to a BigDecimal.
	 * @since Base047
	 */
	public BigDecimal toBigDecimal() {
		return BigDecimal.valueOf(getLongValue(), getNumDecimals());
	}

	/**
	 * Returns a string representation of this MoneyAmount, using {@link DecimalFormat}
	 * and {@link NumberFormat} without a currency symbol e.g.: 999,999.00
	 * 
	 * @return a string representation of this MoneyAmount without currency symbol.
	 * @since Base047
	 */
	public String toNumericString() {
		DecimalFormat formatter = (DecimalFormat)NumberFormat.getCurrencyInstance();
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setCurrencySymbol("");
		symbols.setMonetaryDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		formatter.applyPattern(ENFORCED_FORMAT);
		formatter.setDecimalFormatSymbols(symbols);
		formatter.setMinimumFractionDigits(NUMDECIMALS);
		return formatter.format(toBigDecimal());
	}

	/**
	 * Returns a string representation of this MoneyAmount, using {@link DecimalFormat}
	 * and {@link NumberFormat} with a currency symbol e.g.: $999,999.00
	 * 
	 * @return a string representation of this MoneyAmount with a currency symbol.
	 * @since Base047
	 */
	public String toCurencyString() {
		DecimalFormat formatter = (DecimalFormat)NumberFormat.getCurrencyInstance();
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setCurrencySymbol(getCurrencySymbol());
		symbols.setMonetaryDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		formatter.applyPattern(ENFORCED_FORMAT);
		formatter.setDecimalFormatSymbols(symbols);
		formatter.setMinimumFractionDigits(NUMDECIMALS);
		return formatter.format(toBigDecimal());
	}

	/**
	 * Returns a string representation of this MoneyAmount, using {@link DecimalFormat}
	 * and {@link NumberFormat} with an optional two characters currency symbol e.g.: $999999.00
	 * .
	 * <p/>
	 * The currency symbol will be added and padded with spaces max. 2 characters 
	 * if {@code addPaddedCurrencySymbol} is true.
	 * 
	 * @param addPaddedCurrencySymbol the currency symbol will be added and padded if true
	 * @return a string representation of this MoneyAmount with a two characters
	 *     currency symbol.
	 * @since Base047
	 */
	public String toString(boolean addPaddedCurrencySymbol) {
		DecimalFormat formatter = (DecimalFormat)NumberFormat.getCurrencyInstance();
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		if (addPaddedCurrencySymbol){
			symbols.setCurrencySymbol(String.format("%2s", getCurrencySymbol()));
		} else {
			symbols.setCurrencySymbol("");
		}
		symbols.setMonetaryDecimalSeparator('.');
		formatter.applyPattern(OLD_FORMAT);
		formatter.setDecimalFormatSymbols(symbols);
		formatter.setMinimumFractionDigits(NUMDECIMALS);
		return formatter.format(toBigDecimal());
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 13 * hash + (this.currency != null ? this.currency.hashCode() : 0);
		hash = 13 * hash + getNumDecimals();
		hash = 13 * hash + Float.floatToIntBits(getLongValue());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final MoneyAmount other = (MoneyAmount) obj;
		if (this.currency != other.currency || !this.currency.equals(other.currency)) {
			return false;
		}
		return super.equals(obj);
	}
	
	/**
	 * Return the money amount in words using ASCII characters. The format is:
	 * SPELLED_OUT_NUMBER ##/100 CURRENCY_NAME
	 * 
	 * {@code SPELLED_OUT_NUMBER} will be translated to the default locale language.
	 * {@code ##/100} corresponds to the fractional portion
	 * {@CURRENCY_NAME} corresponds to the CLDR localized currency.
	 * 
	 * <p/><strong>The string is normalized to contain only ASCII characters.
	 * Any composed character is decomposed and non-ASCII bytes eliminated.</strong>
	 * 
	 * @return money amount in words.
	 */
	public String toWord() {
		long fraction = Math.abs(getLongValue()) % getDivisor();

		BigDecimal bdec=toBigDecimal().abs();
		BigInteger bint=bdec.toBigInteger();

		RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(RuleBasedNumberFormat.SPELLOUT);
		String verbosedTotal = formatter.format(bint);

		String decimals = (fraction != 0)? MessageFormat.format(VERBOSE_DEC_FORMAT, fraction):"";

		/**
		 * The plural rule considered is ONE for [1] and OTHER for [0,...]
		 * e.g.: 1 DOLLAR, 2 DOLLARS or 0 DOLLARS
		 */		
		String curName = getPrintName(this.getCurrencyCode(),
			bint.compareTo(BigInteger.ONE)==0?
				PluralRules.KEYWORD_ONE:
				PluralRules.KEYWORD_OTHER);

		/**
		 * Normalize string to change non-ASCII characters to ASCII letters.
		 */
		String unormalized=MessageFormat.format(VERBOSE_FORMAT, verbosedTotal,
				decimals, curName);
		String normalized=Normalizer.normalize(unormalized, Normalizer.Form.NFD)
				.replaceAll("[^\\x00-\\x7F]", "");
		return normalized.toUpperCase();
	}

	/**
	 * Returns the name of the currency as printed in the receipt verbose total
	 * using plural rules.
	 * 
	 * Plural rules supported {@code PluralRules.KEYWORD_ONE} and
	 * {@code luralRules.KEYWORD_OTHER}
	 * 
	 * @param rule string defining the plural rule used to get the name of the
	 *				currency see {@link com.ibm.icu.text.PluralRules}
	 * @param theISOCode currency ISO 4217 code
	 * @return the verbose name of the currency of this MoneyAmount as configured in
	 *			configClient. If no verbose name is configured it will return the
	 *			currency name by the CLDR with non-ASCII characters (<strong>normalize it
	 *			before using it in an ASCII-only environment, see {@code java.
	 *			text.Normalizer}.</strong>)
	 * @since Base052.07
	 */
	public static String getPrintName(String theISOCode, String rule) {
		String name=CURRENCY_VERBOSE_NAME.get(theISOCode+rule);
		if (null != name && !name.trim().isEmpty()){
			return name;
		} else {
			Locale myLocalte = Locale.getDefault();
			ULocale ulocale = new ULocale(myLocalte.toString());

			com.ibm.icu.util.Currency icuCurrency =
					com.ibm.icu.util.Currency.getInstance(theISOCode);

			String curName = icuCurrency.getName(ulocale,
					com.ibm.icu.util.Currency.PLURAL_LONG_NAME, rule, new boolean[]{false});
			return curName;
		}
	}

	/**
	 * Gets the verbose name of the currency of this MoneyAmount as con figured in 
	 * ConfigClient. If no symbol is configured the name will be retrieved from
	 * the ICU CLDR library using the locale information.
	 * 
	 * @param rule string defining the plural rule used to get the name of the
	 *				currency see {@link com.ibm.icu.text.PluralRules}
	 * @return the verbose name of the currency of this MoneyAmount as configured in
	 *			configClient. If no verbose name is configured it will return the
	 *			currency name by the CLDR with non-ASCII characters (<strong>normalize it
	 *			before using it in an ASCII-only environment, see {@code java.
	 *			text.Normalizer}.</strong>)
	 * @since Base052.07
	 */
	public String getPrintName(String rule){
		return getPrintName(currency.getCurrencyCode(), rule);
	}
	
	/**
	 * Associates the currency print name with the code and rule specified.
	 * <p>
	 * If there were already a code and rule defined, the old name is replaced. A 
	 * {@link ConcurrentHashMap} object stores the references.
	 * 
	 * @param theISOCode currency ISO 4217 code to be associated with the symbol
	 * @param rule string defining the plural rule, see {@link com.ibm.icu.text.PluralRules}
	 * @param name name of the currency following plural rules for the locale
	 *			(see {@code com.ibm.icu.text.PluralRules}.)
	 * @return the previous value associated with code and rule, or null if there
	 *			was no mapping for key.
	 * @since Base052.07
	 */
	public static String setPrintName(String theISOCode, String rule, String name){
		return CURRENCY_VERBOSE_NAME.put(theISOCode + rule, name);
	}
}
