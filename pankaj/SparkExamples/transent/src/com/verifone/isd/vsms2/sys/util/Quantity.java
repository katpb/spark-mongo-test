package com.verifone.isd.vsms2.sys.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** Class to represent quantity. Use this as base class for representing entities like volume, temperature etc.
 */
public class Quantity implements Serializable, Cloneable {

	/** The Constant LOGGER. */
	private static final Logger LOGGER	= LoggerFactory.getLogger(Quantity.class);
	/**
	 * Serial Version UID for serialization
	 */
	static final long serialVersionUID = 7717882780240602904L;

	private long value;
	private int numDecimals;
	private String UOM;

	protected long	scaledVal;				// Internal representation, scaled

	/**
	 * Constant defining the round-off value
	 */
	static final long	ROUNDOFF = 500000;	// Constant with implicit decimal
	/**
	 * Constant defining the precision decimal value
	 */
	static final int 	PRECISION = 6;		// Re-normalize after mpy/divide

	/** Constructor. Number of implied decimals is zero
	 * @param value quantity value
	 * @param UOM unit of measure
	 */
	public Quantity(long value, String UOM) {
		this(value, 0, UOM);
	}

	/** Copy constructor; preferred to clone method
	 * @param orig original object to the cloned
	 */
	public Quantity(Quantity orig) {
		this.value = orig.value;
		this.numDecimals = orig.numDecimals;
		this.UOM = orig.UOM;
		this.scaledVal = orig.scaledVal;
	}

	/** Constructor
	 * @param value quantity value
	 * @param numDecimals number of implied decimals
	 * @param UOM unit of measure
	 */
	public Quantity(long value, int numDecimals, String UOM) {
		if (numDecimals > PRECISION || numDecimals < 0) {
			throw new NumberFormatException();
		}

		this.numDecimals = numDecimals;
		this.value = value;
		this.UOM = UOM;
		this.scaledVal = scalePwrTen(value, PRECISION - numDecimals);
	}

	/** Constructor
	 * @param val string that represents the quantity value
	 * @param UOM unit of measure
	 */
	public Quantity (String val, String UOM) {
		this.value = this.convertToLong(val);
		this.numDecimals = this.extractFractionLen(val);
		this.UOM = UOM;
		this.scaledVal = scalePwrTen(this.value, PRECISION - this.numDecimals);
	}

	/** Constructor
	 * @param val string that represents the quantity value
	 * @param numDecimals Number of implied decimals
	 * @param UOM unit of measure
	 */
	public Quantity (String val, int numDecimals, String UOM) {
		long tmpVal = this.convertToLong(val);
		int fractLen = this.extractFractionLen(val);

		//Honor # decimals request by the client
		if (numDecimals > PRECISION || numDecimals < 0) {
			throw new NumberFormatException();
		}

		if (numDecimals >= fractLen) {
			for (int i = 0; i < numDecimals-fractLen; i++) {
				tmpVal *= 10;
			}
		}
		else {
			int roundOff = tmpVal < 0 ? -5 : 5;
			for (int i = 0; i < fractLen-numDecimals; i++) {
				tmpVal += roundOff;
				tmpVal /= 10;
			}
		}
		this.value = tmpVal;
		this.numDecimals = numDecimals;
		this.UOM = UOM;
		this.scaledVal = scalePwrTen(this.value, PRECISION - numDecimals);
	}

	/**
	 * Compares two Quantity objects for equality.
	 * @param compared the object to be compared (do not pass null)
	 * @return 0 - if both objects are equal, -1 if the value of this object is less; +1 if the value of this object is greater
	 */
	public int compare(Quantity compared) {
		return compared.scaledVal == this.scaledVal ? 0 : compared.scaledVal < this.scaledVal ? 1 : -1;
	}

	/** convert quantity to a string (will take into account the implied decimals)
	 * @return quantity represented as a string
	 */
	@Override
	public String toString() {
		long divisor = this.getDivisor();
		this.value = scalePwrTen(this.scaledVal, this.numDecimals - PRECISION); // Lazy update
		if (divisor == 1) {
			return String.valueOf(this.value);
		} else {
			String sign = this.value < 0 ? "-" : "";
			long integ = Math.abs(this.value) / divisor;
			String fract = String.valueOf(Math.abs(this.value) % divisor);
			int flen = fract.length();
			StringBuffer fbuf = new StringBuffer();
			if (flen < this.numDecimals) {
				for (int i = 0; i < this.numDecimals-flen; i++) {
					fbuf.append("0");
				}
			}
			fbuf.append(fract);
			return sign + integ +"." +fbuf.toString();
		}
	}

	/** Accessor method for unit of measure
	 * @return unit of measure
	 */
	public String getUOM() {
		return this.UOM;
	}

	/**
	 * Accessor method for value
	 * @return value
	 * @deprecated
	 * Do not use for calculations, use the methods {@link #add(Quantity)},
	 * {@link #mpy(Quantity)}, {@link #div(Quantity)}, {@link #mod(Quantity)},
	 * {@link #sub(Quantity)} instead.
	 */
	@Deprecated
	public long getLongValue() {
		this.value = scalePwrTen(this.scaledVal, this.numDecimals - PRECISION); // Lazy update
		return this.value;
	}

	/** Accessor method for value
	 * @param newvalue new value to be set
	 */
	public void setValue(long newvalue) {
		this.value = newvalue;
		this.scaledVal = scalePwrTen(this.value, PRECISION);
	}

	/** Accessor method
	 * @return number of implied decimals
	 */
	public int getNumDecimals() {
		return this.numDecimals;
	}

	/** Accessor method
	 * @return the divisor to use to get whole or fraction part
	 */
	public long getDivisor() {
		return (long)Math.pow(10, this.numDecimals);
	}

	/** Divide the quantity by specified divisor. The result will be rounded
	 * up to the scale
	 * @param divisor the divisor quantity object
	 * @param scale the result's number of decimals
	 * @return the result Quantity object
	 */
	public Quantity divideByAnything(Quantity divisor, int scale) {
		long adjustPower = divisor.getNumDecimals()-this.numDecimals+scale+1;
		this.value = scalePwrTen(this.scaledVal, this.numDecimals - PRECISION); // Lazy update
		long toBeDivided = this.value;
		long dividedByWhat = divisor.getLongValue();

		if (this.numDecimals > PRECISION || this.numDecimals < 0) {
			throw new NumberFormatException();
		}

		if (adjustPower > 0) {
			toBeDivided = scalePwrTen(toBeDivided, (int)adjustPower);
			//            for (int i=0; i < adjustPower; i++)
			//                toBeDivided *= 10;
		}
		else {
			dividedByWhat = scalePwrTen(dividedByWhat, -1 * (int)adjustPower);
			//            for (int i=0; i < Math.abs(adjustPower); i++)
			//                dividedByWhat *= 10;
		}

		long divisionResult = toBeDivided / dividedByWhat;

		if (divisionResult > 0) {
			divisionResult += 5;
		} else {
			divisionResult -= 5;
		}
		divisionResult /= 10;

		return new Quantity(divisionResult, scale, this.UOM);

	}

	/** Divide the quantity by specified divisor. The result will be rounded
	 * up to the scale with 2 implied decimals
	 * @param divisor the divisor quantity object
	 * @return the result Quantity object
	 */
	public Quantity divideByAnything(Quantity divisor) {
		return this.divideByAnything(divisor, 2);
	}

	/** Multiply the quantity by specified multiplier. The result will be rounded
	 * up to the scale
	 * @param multiplier the multiplier quantity object
	 * @param scale the result's number of decimals
	 * @return the result Quantity object
	 * @deprecated use new method mpy
	 */
	@Deprecated
	public Quantity oldmultiplyByAnything(Quantity multiplier, int scale) {
		long adjustPower = multiplier.getNumDecimals()+this.numDecimals-scale-1;
		long longResult = this.value * multiplier.getLongValue();

		if (this.numDecimals > PRECISION || this.numDecimals < 0) {
			throw new NumberFormatException();
		}

		if (adjustPower > 0) {
			for (int i=0; i < adjustPower; i++) {
				longResult /= 10;
			}
		} else {
			for (int i=0; i < Math.abs(adjustPower); i++) {
				longResult *= 10;
			}
		}

		if (longResult > 0) {
			longResult += 5;
		} else {
			longResult -= 5;
		}
		longResult /= 10;

		return new Quantity(longResult, scale, this.UOM);
	}

	/** Multiply the quantity by specified multiplier. The result will be rounded
	 * up to the scale
	 * @param multiplier the multiplier quantity object
	 * @param scale the result's number of decimals
	 * @return the result Quantity object
	 */

	public Quantity multiplyByAnything(Quantity multiplier, int scale) {
		long adjustPower = multiplier.getNumDecimals()+this.numDecimals-scale-1;
		this.value = scalePwrTen(this.scaledVal, this.numDecimals - PRECISION); // Lazy update
		long longResult = this.value * multiplier.getLongValue();

		if (this.numDecimals > PRECISION || this.numDecimals < 0) {
			throw new NumberFormatException();
		}

		//longResult = scalePwrTen(longResult, (int)adjustPower);
		longResult = scalePwrTen(longResult, (int)-adjustPower);
		if (false) {
			if (adjustPower > 0) {
				for (int i=0; i < adjustPower; i++) {
					longResult /= 10;
				}
			}
			else {
				for (int i=0; i < Math.abs(adjustPower); i++) {
					longResult *= 10;
				}
			}
		}

		if (longResult > 0) {
			longResult += 5;
		} else {
			longResult -= 5;
		}
		longResult /= 10;

		return new Quantity(longResult, scale, this.UOM);
	}

	/** Multiply the quantity by specified multiplier. The result will be rounded
	 * up to the scale with 2 implied decimals
	 * @param multiplier the multiplier quantity object
	 * @return the result Quantity object
	 */
	public Quantity multiplyByAnything(Quantity multiplier) {
		return this.multiplyByAnything(multiplier, 2);
	}

	private long convertToLong(String val) {
		int fractLen = 0;
		long value = 0;
		boolean negative=false;
		String numStr = val.trim();
		if (numStr.charAt(0)=='-'){
			negative=true;
			numStr=numStr.substring(1);
		}
		int ptPosn = numStr.indexOf(".");
		if (ptPosn < 0) {
			value = Long.parseLong(numStr);
		}
		else {
			long integ = ptPosn == 0 ? 0 : Long.parseLong(numStr.substring(0,ptPosn));
			String fractStr = numStr.substring(ptPosn+1);
			if (Long.parseLong(fractStr) == 0L) {
				value = integ;
			}
			else {
				fractLen = fractStr.length();
				value = Long.parseLong(String.valueOf(integ) + fractStr);
			}
		}
		if (negative) {
			value=-value;
		}
		return value;
	}

	private int extractFractionLen(String val) {
		int fractLen = 0;
		String numStr = val.trim();
		int ptPosn = numStr.indexOf(".");
		if (ptPosn >= 0) {
			String fractStr = numStr.substring(ptPosn+1);
			if (Integer.parseInt(fractStr) != 0) {
				fractLen = fractStr.length();
			}
		}
		return fractLen;
	}

	/**
	 * Test method
	 * @param args the value, number of decimals, UOM for testing
	 */
	public static void main(String[] args) {
		Quantity q = null;

		switch (args.length) {
		case 3: q = new Quantity(args[0], Integer.parseInt(args[2]), args[1]);
		break;
		case 2: q = new Quantity(args[0], args[1]);
		break;
		}
		if (q == null) {
			System.out.println("Usage: java Quantity value uom [numDecimals]");
		} else {
			System.out.println("Values: " +q.toString() +" " +q.getLongValue() +" "
					+q.getNumDecimals() +" " +q.getUOM());
		}
	}

	/** Implement Cloneable interface
	 * @return the cloned object
	 */
	@Override
	public Object clone() {
		Quantity newQ = null;
		try {
			newQ = (Quantity)super.clone();
		} catch (CloneNotSupportedException badclone) {
			throw new InternalError(badclone.toString());
		}
		newQ.value = this.value;
		newQ.numDecimals = this.numDecimals;
		newQ.UOM = this.UOM;
		newQ.scaledVal = this.scaledVal;
		return newQ;
	}

	/** Multiply THIS object by an instance of another Quantity object.  Update
	 * the result and return a reference to THIS updated object.
	 * @return the same object with updated value (based on the operation)
	 * @param factor multiplier
	 */

	public Quantity mpy(Quantity factor) {
		this.scaledVal =  mpy(this, factor);
		return this;
	}

	/** Divide an instance of another Quantity object to THIS and save the
	 * fraction as the internal representation.  Return a reference to
	 * THIS updated object.
	 * @return the same object with updated value (based on the operation)
	 * @param divisor divisor for the operation
	 */

	public Quantity div(Quantity divisor) {
		this.scaledVal =  div(this, divisor);
		return this;
	}

	/** Divide an instance of another Quantity object to THIS and save the
	 * remainder as the internal representation.  Return a reference to
	 * THIS updated object.
	 * @return Quantitythe same object with updated value (based on the operation)
	 * @param divisor divisor for the operation
	 */

	public Quantity mod(Quantity divisor) {
		this.scaledVal =  mod(this, divisor);
		return this;
	}

	/** Add an instance of another Quantity object to THIS and update the
	 * internal representation.  Return a reference to THIS updated object.
	 * @return the same object with updated value (based on the operation)
	 * @param addor addend in the operation
	 */

	public Quantity add(Quantity addor) {
		this.scaledVal =  add(this, addor);
		return this;
	}

	/** Subtract an instance of another Quantity object from THIS and update
	 * the internal representation.  Return a reference to THIS updated object.
	 * @return the same object with updated value (based on the operation)
	 * @param subtractor subtrahend for the operation
	 */

	public Quantity sub(Quantity subtractor) {
		this.scaledVal =  sub(this, subtractor);
		return this;
	}

	/** Quick way to change the sign of the object.
	 * @return negated 'this' object
	 */

	public Quantity neg() {
		this.scaledVal *= -1;
		return this;
	}

	/** Compute the product of the scaled internal value and an arbitrary native
	 * data type of long.  Allows scaling by an arbitrary native data type
	 * without converting to/from native or creating a new object.
	 * @return the same object with updated value (based on the operation)
	 * @param factor multiplier in native data type
	 */

	public Quantity mpy(long factor) {
		factor = scalePwrTen(factor, PRECISION);
		//		scaledVal = mpy(this, factor);
		//		scaledVal = butterflyMpy(this, factor);
		this.scaledVal = dblMpy(this, factor);
		return this;
	}

	/** Compute the fraction from dividing the scaled internal value by
	 * an arbitrary native data type of long.
	 * @return the same object with updated value (based on the operation)
	 * @param divisor divisor for the operation
	 */

	public Quantity div(long divisor) {
		divisor  = scalePwrTen(divisor, PRECISION);
		this.scaledVal = div(this, divisor);
		return this;
	}

	/** Compute the remainder of after dividing the scaled internal value
	 * with an arbitrary data type of long.
	 * @return the same object with updated value (based on the operation)
	 * @param divisor divisor for the operation
	 */

	public Quantity mod(long divisor) {
		divisor = scalePwrTen(divisor, PRECISION);
		this.scaledVal = mod(this, divisor);
		return this;
	}

	/** Compute the sum of the scaled internal value and an arbitrary native
	 * data type of long.
	 * @return the same object with updated value (based on the operation)
	 * @param add1 addend for the operation
	 */

	public Quantity add(long add1) {
		this.scaledVal += scalePwrTen(add1, PRECISION);
		return this;
	}

	/** Compute the difference between the scaled internal representation and
	 * an arbitrary native data type of long.
	 * @return the same object with updated value (based on the operation)
	 * @param subtractor subtrahend for the operation
	 */

	public Quantity sub(long subtractor) {
		this.scaledVal -= scalePwrTen(subtractor, PRECISION);
		return this;
	}

	/** Return the scaled internal representation.
	 * @return scaled internal representation
	 */

	public long getScaledVal() {
		return this.scaledVal;
	}

	/**
	 * CLASS OPERATORS: Given two instances of class Quantity, compute the
	 * math operation using their internal scaled & normalized values, return
	 * the scaled, normalized native data type.
	 * 
	 * PURPOSE: cut down on class proliferation when doing a chain of ops on
	 * the object.  Switches to native data type and allows expression to
	 * derive results based on that data, at the end the object can be reset
	 * with resulting value.
	 * 
	 * ROUNDING: The value is computed, rounded and then normalized.  Rounding
	 * is always AWAY from ZERO.
	 * @param fact1 operand 1
	 * @param fact2 operand 2
	 * @return result of the operation
	 */

	public static long mpy(Quantity fact1, Quantity fact2) {
		//		return mpy(fact1, fact2.scaledVal);
		//		return butterflyMpy(fact1, fact2.scaledVal);
		return dblMpy(fact1, fact2.scaledVal);
	}

	/**
	 * Implementing method for Quantity multiply.  Allows both 'scalar' and
	 * class methods to call same numeric operation.
	 * 
	 * <B>WARNING:</B> Subject to silent overflow erros.  Largest value
	 * manageable is $9,999.99 * 99 * 9.
	 * @param fact1 operand 1
	 * @param fact2 operand 2
	 * @return result value
	 * @see #mpy(Quantity, Quantity)
	 * @deprecated use the instance mpy method
	 */

	@Deprecated
	static long mpy(Quantity fact1, long fact2) {
		long	product;

		product = fact1.scaledVal * fact2;
		if (product > 0) {
			product += ROUNDOFF;
		} else {
			product -= ROUNDOFF;
		}
		return scalePwrTen(product, -PRECISION);
	}

	/**
	 * High-precision, high dynamic range replacement multiplication kernel.
	 * By computing product as a series of partial products we do not overflow
	 * the native type <code>long</code> for our MAX_TRAN * MAX_QTY * MAX_QTY
	 * design goal.  However, the number of scaling, multiply and accumulate
	 * steps make this method very compute intensive.
	 * 
	 * $9,999.99 * 9,999 * 9,999 works
	 * 
	 * <B>NOTES:</B> Most accurate and slowest method.
	 * @param fact1 multiplicand
	 * @param fact2 multiplier
	 * @return result
	 * @see #dblMpy(Quantity, long)
	 * @see #mBAMpy(Quantity, long)
	 */

	static long butterflyMpy(Quantity fact1, long fact2) {
		long	product;
		long	int1, int2, fract1, fract2;

		/*-
		 * Expensive now, but we can distribute these ops by making the whole
		 * and fractional parts fields in the object, and normalizing them with
		 * any other operation.
		 */
		int1 = scalePwrTen(fact1.scaledVal, -PRECISION);
		int2 = scalePwrTen(fact2, -PRECISION);
		fract1 = fact1.scaledVal % 1000000;
		fract2 = fact2 % 1000000;
		product = fract1 * fract2;

		/*- Compute butterfly: fractions first then round & normalize */

		if (product >= 0) {
			product += ROUNDOFF;
		} else {
			product -= ROUNDOFF;
		}

		/*- Mixed products of fraction and int can add in directly */

		product = scalePwrTen(product, -PRECISION);
		product += int1 * fract2 + int2 * fract1;

		/*- Integer/integer products need to be scaled up */

		product += scalePwrTen(int1 * int2, PRECISION);
		return product;
	}
	
	/**
	 * Return the absolute value of this Quantity object in a separate
	 * Quantity object
	 * 
	 * @return a separate Quantity object containing the absolute value of
	 *         this Quantity object
	 */
	public Quantity abs() {
		Quantity absVal = (Quantity) this.clone();
		if (absVal.compareWithZero() < 0) {
			absVal.neg();
		}
		return absVal;
	}	

	/**
	 * Used during development
	 * @param fact2 multiplier
	 * @return result
	 * @deprecated double operations are deprecated
	 */

	@Deprecated
	public Quantity dblMpy(Quantity fact2) {
		this.scaledVal = dblMpy(this, fact2);
		return this;
	}

	/**
	 * Used during development
	 * @param fact2 multiplier
	 * @return result
	 * @deprecated double operations are deprecated
	 */

	@Deprecated
	public Quantity dblMpy(long fact2) {
		fact2 = scalePwrTen(fact2, PRECISION);
		this.scaledVal = dblMpy(this, fact2);
		return this;
	}

	/**
	 * Used during development
	 * @param fact1 multiplicand
	 * @param fact2 multiplier
	 * @return result
	 * @deprecated double operations are deprecated
	 */

	@Deprecated
	public static long dblMpy(Quantity fact1, Quantity fact2) {
		return dblMpy(fact1, fact2.scaledVal);
	}

	/**
	 * Multiply scaled value of given instance times implicit scaled value
	 * of 2nd argument.  Return implicit scaled result.
	 * 
	 * <B>NOTE</B> Even though a floating-point math is used for the operation
	 * the number remains scaled so that we don't use any of the fraction bits
	 * from the floating point number.  Before we return we convert back to a
	 * long value so that we don't accumulate floating point imprecisions in
	 * a series of math operations.  The whole point is to use the hardware
	 * coprocessor to execute the scaling, handle the temporary-real precision
	 * of the product and convert back the integer part efficiently.  (This
	 * also means we use microcode operations instead of machine or byte code.)
	 * HOWEVER, deducting 1 bit each for signs of exponent and significand,
	 * -- yes, even 2's comp. math treats the MSB as a sign bit -- and 11 bits
	 * for the exponent leaves 64 - 13 = 51 bits for the significand as opppsed
	 * to 64 bits for the pure long result.  We can never have the precision
	 * of a pure long operation done with partial products: mply integer
	 * parts & scale, mply cross-terms of fraction & integer parts and add to
	 * partial product, mply fraction parts, scale and add to partial product.
	 * Compute $9,999.99 * 9,999 * 9,999 with the two methods:
	 * <pre>
	 * Kernel                toString()         implicit 6-decimal scaledVal() <br>
	 * -------------------+----------------+------------------------------  <br>
	 * Partial Products:    999799010199.99     (999799010199990000)        <br>
	 * Floating Point temp:	999799010199.99 (999799010199990016)        <br>
	 * <B>WHY DO THIS THING?</B>
	 * Here are sample execution times (ms) for the different multiply kernels,
	 * run on Topaz & Sapphire H/W, Dec 15, 2003:
	 * 
	 * SAPPHIRE:
	 * 		Partial product multiply time: 2954
	 * 		Double product multiply time: 791
	 * 		mpyByAnything product multiply time: 1811
	 * 		old mpyByAnything product multiply time: 6960
	 * 
	 * TOPAZ:
	 * 		Partial product multiply time: 4686
	 * 		Double product multiply time: 1683
	 * 		mpyByAnything product multiply time: 2762
	 * 		old mpyByAnything product multiply time: 9948
	 * </pre>
	 * @param fact1 multiplicand
	 * @param fact2 multiplier
	 * @return result
	 * @see #mBAMpy(Quantity, long)
	 * @see #butterflyMpy(Quantity, long)
	 */

	static long dblMpy(Quantity fact1, long fact2) {
		double	d1 = fact1.scaledVal;

		d1 *= fact2;

		/* Use 1/2 to round towards infinity, based on sign of result */

		if (d1 < 0.0) {
			d1 = Math.ceil((d1 - 5.0e5) / 1.0e6);	// truncate towards -inf
		} else {
			d1 = Math.floor((d1 + 5.0e5) / 1.0e6);	// truncate towards +inf
		}
		return (long)d1;
	}

	/**
	 * Exists for evaluation against other proposed multiply kernels -- small
	 * footprint and documents code.
	 * 
	 * <B>BENEFITS:</B> Can be more accurate than the floating point kernel,
	 * is much faster than the partial-product kernel.
	 * 
	 * <B>RISK:</B> Silent overflow of numbers, implicit decimal in 2nd
	 * argument vs. explicit in 1st.
	 * @param fact1 multiplicand
	 * @param fact2 multiplier
	 * @return result
	 * @see #dblMpy(Quantity, long)
	 * @see #butterflyMpy(Quantity, long)
	 */

	static long mBAMpy(Quantity fact1, long fact2) {
		int		adjustPower = 6 + fact1.numDecimals - 6 - 1;
		long	value = scalePwrTen(fact1.scaledVal,
				fact1.numDecimals - PRECISION);
		long	longResult = value * fact2;

		longResult = scalePwrTen(longResult, -adjustPower);

		if (longResult > 0) {
			longResult += 5;
		} else {
			longResult -= 5;
		}
		return longResult /= 10;
	}

	/**
	 * Compute the fraction, round and normalize.
	 * @param dividend dividend for the operation
	 * @param divisor divisor for the operation
	 * @return result value
	 * @see #mpy(Quantity, Quantity)
	 */

	public static long div(Quantity dividend, Quantity divisor) {
		return div(dividend, divisor.scaledVal);
	}

	/**
	 * Implementing method for Quantity divide.  Allows both 'scalar' and
	 * class methods to call same numeric operation.  (Divide 2nd argument
	 * into first.)
	 * @param dividend dividend
	 * @param divisor divisor
	 * @return result
	 * @see #div(Quantity, Quantity)
	 */

	static long div(Quantity dividend, long divisor) {
		long	quotient;

		/*-
		 * Scale first so division won't underflow result at the end.  The
		 * divisor has already been scaled.  Round and remove guard digit.
		 */

		quotient = scalePwrTen(dividend.scaledVal, PRECISION) * 10 / divisor;

		if (quotient > 0) {
			quotient += 5;
		} else {
			quotient -= 5;
		}
		return quotient / 10;
	}

	/**
	 * Compute the remainder, round and normalize.  (Divide 2nd argument into
	 * first.)
	 * @param dividend dividend for the operation
	 * @param divisor divisor for the operation
	 * @return rounded and normalized remainder value
	 */

	public static long mod(Quantity dividend, Quantity divisor) {
		return mod(dividend, divisor.scaledVal);
	}

	/**
	 * Compute the remainder, round and normalize.  (Divide 2nd argument into
	 * first.)
	 * @param dividend dividend for the operation
	 * @param divisor divisor for the operation
	 * @return rounded and normalized remainder value
	 */

	public static long mod(Quantity dividend, long divisor) {
		return dividend.scaledVal % divisor;
	}

	/**
	 * Compute the sum, round and normalize.
	 * @param add1 operand 1
	 * @param add2 operand 2
	 * @return result value
	 */

	public static long add(Quantity add1, Quantity add2) {
		return add1.scaledVal + add2.scaledVal;
	}

	/**
	 * Compute the difference, round and normalize.
	 * @param subtrahend subtrahend for the operation
	 * @param subtractor subtractor for the operation
	 * @return result value
	 */

	public static long sub(Quantity subtrahend, Quantity subtractor) {
		return subtrahend.scaledVal - subtractor.scaledVal;
	}

	/**
	 * Negate the value
	 * @param q object to be negated
	 * @return result value
	 */

	public static long neg(Quantity q) {
		return q.scaledVal * -1;
	}

	/**
	 * Convenience method to discover how many digits are used to
	 * convert internal notation to native type of long.
	 * 
	 * 
	 * @return long
	 */

	public static long getScaleFact() {
		return scalePwrTen(1, PRECISION);
	}

	/**
	 * Static table of constants to do a lookup digit shift, base 10.
	 */

	static final long[]	TENPWRS = {
		1L,           10L,          100L,
		1000L,        10000L,       100000L,
		1000000L,     10000000L,    100000000L,
		1000000000L,  10000000000L, 1000000000000L
	};

	/**
	 * Class method to combine speedy base-ten digit shifting with reasonable
	 * lookup table size.  Cost of a 12-longword lookup table shared for the
	 * entire class is minimal.  Most shifts will be in the range of 6 digits
	 * and the shifting code can be inlined if required.  (Any chance of making
	 * it a JNM?)
	 * 
	 * Given the longword to shift, shift decimal right if pwr > 0 or left if
	 * pwr < 0.   Overflow/underflow is ignored.  Return resulting value.
	 * @param arg value to perfrom base-ten shift
	 * @param pwr number of shifts
	 * @return result
	 */

	static long scalePwrTen(long arg, int pwr) {
		if (pwr < 0) {
			pwr *= -1;						// Convert to absolute
			while (pwr >= TENPWRS.length) {
				arg /= TENPWRS[TENPWRS.length - 1];
				pwr -= TENPWRS.length - 1;
			}
			arg /= TENPWRS[pwr];			// Finish off last scale operation
		} else {
			while (pwr >= TENPWRS.length) {
				arg *= TENPWRS[TENPWRS.length - 1];
				pwr -= TENPWRS.length - 1;
			}
			arg *= TENPWRS[pwr];			// Finish off last scale operation
		}
		return arg;
	}

	/**
	 * Compare with zero quantity.
	 * @return 0 - if both objects are zero, 
	 * -1 if the value of this object is negative;
	 * +1 if the value of this object is greater than zero.
	 */
	public int compareWithZero(){
	    return compare(new Quantity(0,""));
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.UOM == null ? 0 : this.UOM.hashCode());
		result = prime * result + this.numDecimals;
		result = prime * result + (int) (this.scaledVal ^ this.scaledVal >>> 32);
		result = prime * result + (int) (this.value ^ this.value >>> 32);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Quantity other = (Quantity) obj;
		if (this.UOM == null) {
			if (other.UOM != null) {
				return false;
			}
		} else if (!this.UOM.equals(other.UOM)) {
			return false;
		}
		if (this.numDecimals != other.numDecimals) {
			return false;
		}
		if (this.scaledVal != other.scaledVal) {
			return false;
		}
		if (this.value != other.value) {
			return false;
		}
		return true;
	}
}
