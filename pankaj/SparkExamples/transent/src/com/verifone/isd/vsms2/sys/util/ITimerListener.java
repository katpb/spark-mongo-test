package com.verifone.isd.vsms2.sys.util;

/**
 * interface for a timer to call back
 * @author "mailto:david_ezell@verifone.com"
 * @version 1.0
 * @see com.verifone.isd.vsms2.sys.util.Timer
 */
public interface ITimerListener
{
    /**
     * method called when the timer expires
     */
    public void expired();
    
    /**
     * method called when the timer is cleared
     */
    public void cleared();
}