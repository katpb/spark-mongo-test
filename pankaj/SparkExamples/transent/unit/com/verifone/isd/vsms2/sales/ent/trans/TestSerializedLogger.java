package com.verifone.isd.vsms2.sales.ent.trans;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSerializedLogger extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(TestSerializedLogger.class);
		return suite;
	}
	
	
	/**
	 * Initialize a new Transaction object and create a serialized copy of it. 
	 * If the Logger inside Transaction becomes Null after serialization 
	 * this test will fail.
	 *
	 * @param	void
	 * @return	void
	 */

	
    public void testTransactionLogger() {
    		Transaction transaction = new Transaction();		
            Transaction copied = new Transaction();
    		copied = transaction.getSerializedClone();
    		Transaction s = copied.getSerializedClone();
    		assertTrue(s!=null);
    	}
    
}
