/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz production version
 * Created September 21, 2005                                 David C. Brown
 *
 * Define the JUnit class to test the deepCopy instantiation of base and
 * subclass fields from ItemLine.
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.util.Quantity;
import junit.framework.*;

/**
 * Test suite to ensure the right subclasses populate/override superclass
 * fields and methods when doing a deepCopy.  Otherwise we'll have slicing
 * in corner cases and probably encounter ClassCastExceptions at runtime.
 *
 * @author	David C. Brown
 * @version	4.0 (NewPro)
 * @since	Topaz production 2.0
 */

public class TestPluItemLine extends TestCase {
	ItemLine		il1, il2;
	PluItemLine		pil1, pil2;
	PluPK			ppk;

	Object[]		disclist1, disclist2;

	DepartmentInfo deptInfo;
	/**
	 * @see	http://junit.sourceforge.net/doc/cookstour/cookstour.htm
	 *
	 * @param	void
	 * @return	Test
	 */

	public static Test suite() {
		TestSuite suite = new TestSuite(TestPluItemLine.class);
		return suite;
	}

	/**
	 * Make DiscountInfo entries to start out testing.
	 *
	 * @param	void
	 * @return	void
	 */

	public void setUp() {
		il1 = new SimpleItemLine();
		il1.addDiscountInfo(new DiscountInfo());
		il1.addDiscountInfo(new DiscountInfo());

		ppk = new PluPK("000000000170000");

		pil1 = new PluItemLine();
		pil1.setPluNum(ppk);
		pil1.addDiscountInfo(new PluDiscountInfo());
		pil1.addDiscountInfo(new PluDiscountInfo());
        pil1.setSellingUnit(new Quantity(10, "EA"));
                        
        deptInfo = new DepartmentInfo();
        deptInfo.setDeptNum(9000);
        
        }

	/**
	 * Close any database connections, sockets that might tie up resources
	 * on another system, etc.
	 *
	 * NOT USED in this test suite.
	 *
	 * @param	void
	 * @return	void
	 */

	public void tearDown() {
	}

	/**
	 * Create a SimpleItemLine, populate it with DiscountInfo entities and
	 * ensure a deepCopy returns the same.
	 *
	 * @param	void
	 * @return	void
	 */

	public void testSimpleItemLine() {
		il2 = new SimpleItemLine();			// Observe behavior of base class
		il1.setDepartmentInfo(deptInfo);
                if (il1 != null) {
                    il1.deepCopy(il2);

                    disclist1 = il1.getAllDiscountInfo();
                }
		disclist2 = il2.getAllDiscountInfo();

		assertTrue(disclist1.length == disclist2.length);
		for (int i = 0; i < disclist2.length; i++) {
			assertTrue(disclist2[i] instanceof DiscountInfo);
		}
	}

	/**
	 * Create a PluItemLine, populate it with PluDiscountInfo entities and
	 * ensure a deepCopy returns the same.  Then create another PluItemLine
	 * but use the superclass SimpleItemLine reference.  Ensure deepCopy
	 * knows to instantiate the subclass PluDiscountInfo entries.
	 *
	 * @param	void
	 * @return	void
	 */

	public void testPluItemLine() {
		il1 = pil1;							// Discounts, etc. already added
		il1.setDepartmentInfo(deptInfo);
		il2 = new PluItemLine();
                if (il1 != null) {
                    il1.deepCopy(il2);

                    disclist1 = il1.getAllDiscountInfo();
                }
		disclist2 = il2.getAllDiscountInfo();

		assertTrue(disclist1.length == disclist2.length);
		for (int i = 0; i < disclist2.length; i++) {
			assertTrue(disclist2[i] instanceof PluDiscountInfo);
		}
	}

	/**
	 * To run this from the command line, rather than from ant & the VCCM, cd
	 * to the component root (or if you've collected everything into a
	 * "condensed" tree go to the directory that *contains* com/verifone/...)
	 * and invoke as "java <package path>.<class name>".  Make sure the
	 * junit.jar is in your path.
	 *
	 * @param	String[] NOT USED
	 * @return	void
	 * @see		componentNotes.html (FAQ)
	 */

	public static void main(String[] Args) {
		junit.textui.TestRunner.run(suite());
	}
}
