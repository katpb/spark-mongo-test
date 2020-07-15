/*
 * SequenceGenerator.java
 *
 * Created on May 22, 2003, 6:01 PM
 */

package com.verifone.isd.vsms2.sys.util;

/** Factory method to get a sequence number generator based
 * on a unique generator id string. Currently, TICKET_NUM is
 * the only supported sequence number generator. New generators
 * should be added to the factory method with a unique id string.
 *
 * This class also provides a default systemwide sequence number
 * generator. For unknown generator id strings, this instance
 * will be returned.
 * @author Bhanu_N2
 */
public class SequenceFactory {
    private static ISequenceGenerator defaultGenerator;
    /** Creates a new instance of SequenceGenerator */
    private SequenceFactory() {
    }
    
    /** 
     * Parameterized factory method that returns an instance of
     * ISequenceGenerator based on passed sequenceName. If passed 
     * sequenceName is NULL or empty it returns the default generator. 
     *
     * @param sequenceName - unique identifier for the requested sequence generator
     * @return requested ISequenceGenerator instance or a default
     * instance if null or empty name is passed.
     */    
    public static synchronized ISequenceGenerator getGenerator(String sequenceName) {
    	if (sequenceName != null && !sequenceName.trim().isEmpty()) {
    		if(sequenceName.equals("TICKET_NUM")) {
    			return TicketNumberGenerator.getInstance();
    		} else {
    			return SequenceGenerator.getInstance(sequenceName);
    		}
    	}
    	else {
			/**
			 * For unknown types, clients can't expect uniqueness 
			 * by sequenceName. Returning default generator.
			 */
    		return getDefaultGenerator();
    	}
    }
    
	/**
	 * Returns a generic system-wide sequence number generator that 
	 * returns a running long variable's value. This is not persisted 
	 * between reboots also.
	 * 
	 * @return
	 */
    private static synchronized ISequenceGenerator getDefaultGenerator() {
    	 if (defaultGenerator == null) {
             defaultGenerator = new ISequenceGenerator(){
                 private long seqNum = 0;
                 public synchronized long getNext() {
                     return seqNum++;
                 }
                 public long getMinimum() {
                     return Long.MIN_VALUE;
                 }
                 public long getMaximum() {
                     return Long.MAX_VALUE;
                 }
                 public synchronized long getCurrent() {
                     return seqNum;
                 }
             };
         }
         return defaultGenerator;
    }
    
    
    /** Test method
     * @param args Args (no-op on the args)
     */    
    public static void main (String[] args) {
        ISequenceGenerator gen = SequenceFactory.getGenerator("TST");
        System.out.println(gen.getNext());
        System.out.println(gen.getNext());      
        System.out.println(gen.getNext());        
    }
}
