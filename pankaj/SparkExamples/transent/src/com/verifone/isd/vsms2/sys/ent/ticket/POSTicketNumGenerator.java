package com.verifone.isd.vsms2.sys.ent.ticket;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.ISequenceGenerator;
import com.verifone.isd.vsms2.sys.util.TicketNumberGenerator;
import com.verifone.isd.vsms2.sys.util.register.RegisterIdFactory;
import com.verifone.isd.vsms2.sys.db.rdbms.pres.SequenceDBAccessor;

/**
 * 
 * @author  Ehtesham_M1
 */
public class POSTicketNumGenerator extends TicketNumberGenerator {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.ticket.POSTicketNumGenerator.class);
    private static final int MIN_REG_ID = 001;
    private static final int MAX_REG_ID = 999;
    private String SEQ_NAME = "TICKET_NUM";
    
    private static Map<Short, ISequenceGenerator> registerMap = new HashMap<Short, ISequenceGenerator>();
    
    /** Creates a new instance of POSTicketNumGenerator */
    private POSTicketNumGenerator(short registerId) {
        super();
        SEQ_NAME = SEQ_NAME + "_" + registerId;
    }
    
    public static ISequenceGenerator getInstance(short registerId) {
    	POSTicketNumGenerator ticketGenerator = (POSTicketNumGenerator)registerMap.get(registerId);
        if(ticketGenerator == null) {
        	ticketGenerator = new POSTicketNumGenerator(registerId);
        	synchronized(ticketGenerator) {
        		POSTicketNumGenerator tempTicketGenerator = (POSTicketNumGenerator)registerMap.get(registerId);
        		if(tempTicketGenerator == null){
        			ticketGenerator.setRegisterId(registerId);
        			long defaultSeqNr = ticketGenerator.getCurrent();
        			long dbSeqNr = SequenceDBAccessor.getInstance().initializeSequenceNr(ticketGenerator.SEQ_NAME, defaultSeqNr);
        			if (dbSeqNr != defaultSeqNr) { ///If DB has a different ticket number stored, use it
        				int justSeqNr = (int)(dbSeqNr%TicketNumberGenerator.TICKET_BASE);
        				ticketGenerator.setSequenceNum(justSeqNr);  
        				defaultSeqNr = ticketGenerator.getCurrent();
        				if (dbSeqNr != defaultSeqNr) { //would be different if the register numbers are different
        					SequenceDBAccessor.getInstance().updateSequence(ticketGenerator.SEQ_NAME, defaultSeqNr); 
        				}
        			}
        			registerMap.put(registerId, ticketGenerator);
        		} else {
        			ticketGenerator = tempTicketGenerator;
        		}
        	}
        }
        return ticketGenerator;
    }
    
    /** 
     * This method is for Topaz
     * @return the singleton instance
     */
    public static synchronized ISequenceGenerator getInstance() {
    	short regId = (short)RegisterIdFactory.getInstance().getRegisterId();
    	POSTicketNumGenerator ticketGenerator = (POSTicketNumGenerator)registerMap.get(regId);
    	if(ticketGenerator == null){
    		ticketGenerator = (POSTicketNumGenerator)getInstance(regId);
    	}
        return ticketGenerator;
    }    
    
    /** Provides a way to explicitly set the register id; this fixes
     * the valid ticket number range. If an invalid register ID is
     * passed, java.lang.IllegalArgumentException will be thrown.
     * @param regId register number used in generating the ticket
     * number
     * @throws IllegalArgumentException on invalid topaz register id ( < 101 or > 199)
     */        
    public void setRegisterId(short regId) throws IllegalArgumentException{
        if (regId < MIN_REG_ID || regId > MAX_REG_ID) {
            throw new IllegalArgumentException("Invalid register ID: " 
            +regId);
        }
        super.setRegisterId(regId);
    }
    
    public synchronized long getNext() {
        long next = super.getNext();
        try {
            SequenceDBAccessor.getInstance().updateSequence(SEQ_NAME, this.getCurrent());
        }
        catch (Exception e) {
            logger.error("Error persisting ticket number to DB: " +e);
        }
        finally {
            return next;
        }
    }
    
    /** Test method
     * @param args dummy args */    
    public static void main(String[] args) {
        POSTicketNumGenerator genr = (POSTicketNumGenerator)POSTicketNumGenerator.getInstance((short)102);
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
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());
        System.out.println(genr.getNext());          
    }    
}
