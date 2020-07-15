/*
 * CardBinDiscountTest.java
 * JUnit based test
 *
 * Created on March 21, 2007, 1:27 PM
 */

package com.verifone.isd.vsms2.sales.ent.popdiscount;

import java.util.ArrayList;
import junit.framework.*;
import junit.textui.TestRunner;

/**
 *
 * @author brian_r1
 */
public class CardBinDiscountTest extends TestCase {
    
    public CardBinDiscountTest(java.lang.String testName) {
        super(testName);
    }

    public static void main(java.lang.String[] args) throws Exception {
        System.out.println("Starting CardBinDiscountTest Test");
        TestRunner.run(suite());
    }   
    
    public static Test suite() {
        TestSuite suite = new TestSuite(CardBinDiscountTest.class);
        return suite;
    }

	private String b2t(boolean b) // from Boolean to True/False string
	{
		if (b == true) return "[TRUE]";
		else return "[FALSE]";
	}

	private String b2p(boolean b) // from Boolean to Pass/Fail string
	{
		if (b == true) return "[PASS]";
		else return "[FAIL]";
	}

	private boolean testAcctQualifies(boolean expected, String a, String s1, String s2)
	{
		CardBinDiscount cbd;
		boolean result, status;
		String sStatus, sExpected, sResult;

		// do the test
		cbd = s2 == null ? new CardBinDiscount(s1) : new CardBinDiscount(s1, s2);
		result = cbd.acctQualifies(a);
		status = result == expected;

		if (status == false)
		{
			// display the test status (pass or fail)
			System.out.print(b2p(status) + ":");

			// display the actual and expected test results
			System.out.print(" expected" + b2t(expected));
			System.out.print(" result" + b2t(result));

			// display the test data
			System.out.print(" account[" + a + "]");
			if (s2 == null)
				System.out.print(" mask[" + s1 + "]");
			else
				System.out.print(" begin[" + s1 + "] end[" + s2 + "]");

			// display complete
			System.out.println();
		}
		return status;
	}

	public void testAcctsQualify()
	{
		System.out.println();

		assertTrue(testAcctQualifies(
			true, // RANGE: all fields contain the same data and are equal to the maximum length
			"123456", 
			"123456", 
			"123456"));
		assertTrue(testAcctQualifies(
			true, // RANGE: all fields contain the same data and are less than the maximum length
			"12345",
			"12345",
			"12345"));
		assertTrue(testAcctQualifies(
			true, // RANGE: simple range test
			"2",
			"1",
			"3"));
		assertTrue(testAcctQualifies(
			false, // RANGE: start BIN is greater than the end BIN
			"2",
			"3",
			"1"));
		assertTrue(testAcctQualifies(
			true, // RANGE: test passes before reaching end of test string
			"1234",
			"1209",
			"1290"));
		assertTrue(testAcctQualifies(
			true, // RANGE:  start passes before reaching end of test string and end passes at end of test string
			"1234",
			"123",
			"1235"));
		assertTrue(testAcctQualifies(
			false, // RANGE: account is greater than end
			"1239",
			"1234",
			"1235"));
		assertTrue(testAcctQualifies(
			false, // RANGE: account is less than start
			"1230",
			"1234",
			"1235"));
		assertTrue(testAcctQualifies(
			true,  // MASK: mask is shorter than account number
			"1234", 
			"123", 
			null));
		assertTrue(testAcctQualifies(
			true, // MASK: mask is shorter than account number AND has wildcard
			"1234",
			"12*",
			null));
		assertTrue(testAcctQualifies(
			true,  // MASK: mask is longer than account number
			"1234",
			"12345",
			null));
		assertTrue(testAcctQualifies(
			true, // MASK: mask is longer than account number AND has wildcard
			"1234",
			"12*45",
			null));
		assertTrue(testAcctQualifies(
			false, // MASK: mismatch at last position
			"123456",
			"123457",
			null));
		assertTrue(testAcctQualifies(
			false, // MASK: mismatch at first position
			"023456",
			"123456",
			null));
		assertTrue(testAcctQualifies(
			false, // MASK: mismatch in middle position
			"123456",
			"120456",
			null));
	}
}
