/*
 * TicketNumberGenerator.java
 *
 * Created on May 22, 2003, 6:20 PM
 */

package com.verifone.isd.vsms2.sys.util;
/**
 * This class provides the ticket number generation service.
 * TBD: Persistence and restoring from the persist store
 * @author  Bhanu_N2
 */
public class TicketNumberGenerator implements ISequenceGenerator {
    private static TicketNumberGenerator theInstance;
    private int ticketNr;
    private short registerId;
    private int ticketMin;
    private int ticketMax;

    private static final int SEQUENCE_MAX = 9999;
    private static final int SEQUENCE_MIN = 1;
    /**
     * Base number to be applied to the sequence number to get the ticket number
     */
    protected static final int TICKET_BASE = 10000;
    
    /** Creates a new instance of TicketNumberGenerator */
    protected TicketNumberGenerator() {
        int regTicketBase = this.registerId * TICKET_BASE;            
        this.ticketMin = regTicketBase + SEQUENCE_MIN;
        this.ticketMax = regTicketBase + SEQUENCE_MAX;
        this.ticketNr = this.ticketMin;        
    }
    
    /** Singleton accessor method
     * @return the singleton instance
     */    
    public static synchronized ISequenceGenerator getInstance() {
        if (theInstance == null) {
            theInstance = new TicketNumberGenerator();
        }
        return theInstance;
    }
    
    /** Provides a way to explicitly set the register id; this fixes
     * the valid ticket number range. If an invalid register ID is
     * passed, java.lang.IllegalArgumentException will be thrown!
     * @param regId register number used in generating the ticket
     * number
     * @throws IllegalArgumentException on invalid register id 
     */    
    public void setRegisterId(short regId) throws IllegalArgumentException{
        this.registerId = regId;
        int regTicketBase = this.registerId * TICKET_BASE;
        this.ticketMin = regTicketBase + SEQUENCE_MIN;
        this.ticketMax = regTicketBase + SEQUENCE_MAX;
        int seqNum = this.ticketNr%TICKET_BASE;
        this.ticketNr = regTicketBase + seqNum;
    }
    
    /**
     * Setter for the sequence number; use this with caution since the sequence number will 
     * jump to the specified value from the current value.
     * @param seqNr required sequence number
     * @throws java.lang.IllegalArgumentException on invalid value
     */
    protected void setSequenceNum(int seqNr) throws IllegalArgumentException {
        int regTicketBase = this.registerId * TICKET_BASE;     
        int newNr = regTicketBase +seqNr;
        if (newNr >= this.ticketMin && newNr <= this.ticketMax) {
            this.ticketNr = newNr;
        }
        else {
            throw new IllegalArgumentException("Invalid sequence number: " +seqNr);            
        }
    }
    
    /** Getter for register ID
     * @return register number used in generating the ticket
     * number
     */    
    public short getRegisterId() {
        return this.registerId;
    }
    
    /** Getter for register ID
     * @return register number used in generating the ticket number
     */    
    protected int getSequenceNum() {
        return (int)(this.ticketNr%TicketNumberGenerator.TICKET_BASE);
    }    
    
    /** Get the next sequence number
     * @return next sequence number
     */       
    public synchronized long getNext() {
        ++this.ticketNr;
        if (this.ticketNr < this.ticketMin) {
            this.ticketNr = this.ticketMin;
        }
        else if (this.ticketNr > this.ticketMax) {
            this.ticketNr = this.ticketMin;
        }
        return this.ticketNr;
    }
    
    /**
     * Getter for the current sequence number; this method is idempotent
     * @return current sequence number
     */
    public synchronized long getCurrent() {
        return this.ticketNr;
    }
    
    /** Get the sequence maximum
     * @return sequence maximum
     */       
    public long getMaximum() {
        return SEQUENCE_MAX;
    }
    
    /** Get the sequence maximum
     * @return sequence maximum
     */        
    public long getMinimum() {
        return SEQUENCE_MIN;
    }
    
    /** Test method
     * @param args dummy args */    
    public static void main(String[] args) {
        TicketNumberGenerator genr = (TicketNumberGenerator)TicketNumberGenerator.getInstance();
        System.out.println(genr.getCurrent());         
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());       
        genr.setRegisterId((short)101);
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());     
        genr.setRegisterId((short)103);
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());   
        genr.setRegisterId((short)110);
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());         
        genr.setRegisterId((short)199);
        System.out.println(genr.getCurrent());         
        System.out.println(genr.getNext());
        System.out.println(genr.getCurrent());         
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());  
        System.out.println(genr.getCurrent());
        System.out.println(genr.getCurrent());          
    }
    
    /** Get the ticket base
     * @return ticket base
    */
    public int getTicketBase() {
		return TICKET_BASE;
	}
}
