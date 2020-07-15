package com.verifone.isd.vsms2.sys.util;

/** Interface for sequence number generator
 * @author Bhanu_N2
 */
public interface ISequenceGenerator {
    /** Get the next sequence number
     * @return next sequence number
     */    
    public long getNext();
    /** Get the sequence minimum
     * @return sequence minimum
     */    
    public long getMinimum();
    /** Get the sequence maximum
     * @return sequence maximum
     */    
    public long getMaximum();
    /** Get the current sequence number
     * @return current sequence number
     */      
    public long getCurrent();
}
