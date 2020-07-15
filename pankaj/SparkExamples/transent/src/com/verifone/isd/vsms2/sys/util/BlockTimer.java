package com.verifone.isd.vsms2.sys.util;

import java.util.Enumeration;
import java.util.Vector;

/**
 *  Class to allow setting of a timer to control or bound an operation.
 *  This class pauses on the calling thread, and allows events on other
 *  threads to interrupt.  The term "BlockTimer" refers to the fact that
 *  it blocks the thread which calls the "start()" method.
 *
 *  @author "mailto:david_ezell@verifone.com"
 *  @version 1.0
 */

public class BlockTimer
{
    protected static final int IDLE = 0;
    protected static final int READY = 1;
    protected static final int CLEARED = 2;
    
    protected int status = IDLE;
    
    protected long duration = 0;
    private Vector timerListeners = null;
    
    /**
     * Constructor that takes the block duration as a parameter
     * @param duration block duration in mSecs
     */
    public BlockTimer(long duration)
    {
        this.duration = duration;
        timerListeners = new Vector();
    }
    
    /**
     * No-args constructor
     */
    public BlockTimer()
    {
        this(0);
    }
    
    /**
     * Setter for block duration
     * @param duration block duration in mSecs
     * @throws com.verifone.isd.vsms2.sys.util.TimerAlreadyStartedException if 'start' method is called on a timer that has already been started
     * @throws com.verifone.isd.vsms2.sys.util.TimerDurationInvalidException if the block duration specified is invalid
     */
    public void setDuration(long duration) throws TimerAlreadyStartedException,TimerDurationInvalidException
    {
        int stat = READY; //set to any other value than primitive default
        synchronized(this)
        {
           stat = status;
        }
        if (stat != IDLE)
            throw new TimerAlreadyStartedException();
        if (duration <= 0)
            throw new TimerDurationInvalidException();
            
        this.duration = duration;
    }
    
    /**
     * Getter for block duration
     * @return block duration in mSecs
     */
    public long getDuration()
    {
        return duration;
    }
  
    /**
     *  use this call to assure that an asynchronous call to clear will be caught.
     * @exception TimerAlreadyStartedException if the timer is not idle.
     */
    public void reset() throws TimerAlreadyStartedException
    {
        synchronized(this)
        {
           status = READY;
        }
    }
    
    /**
     * use this method to start the timer
     * @throws com.verifone.isd.vsms2.sys.util.TimerExpiredException if the timer has already expired
     * @throws com.verifone.isd.vsms2.sys.util.TimerAlreadyStartedException if the timer is not idle.
     */
    public void start() throws TimerExpiredException,TimerAlreadyStartedException
    {
        int localStatus = 0;
        synchronized(this)
        {
            if (status == CLEARED)  // raced out
            {
                status = IDLE;
                return;
            }
                
            if (status != IDLE && status != READY)  // might have been primed with reset()
                throw new TimerAlreadyStartedException();
                
            status = READY;
            try {
                wait(duration);
                localStatus = status;   // avoid a race condition
            }
            catch (InterruptedException e)
            {
                localStatus = CLEARED;
            }
            status = IDLE;
        }
        
        Enumeration e = getTimerListenersEnum();
        while (e.hasMoreElements())
        {
            ITimerListener listener = (ITimerListener)e.nextElement();
            switch(localStatus)
            {
            case READY:
                listener.expired();
                break;
            case CLEARED:
                listener.cleared();
                break;
            }
        }
        
        if (localStatus == READY)
            throw new TimerExpiredException();
    }
            
    /**
     * use this to clear the timer before it expires; this allows calling 'start' on the timer again
     * @throws com.verifone.isd.vsms2.sys.util.TimerAlreadyExpiredException if the timer has already expired
     */
    public void clear() throws TimerAlreadyExpiredException
    {
        synchronized(this)
        {
            if (status == IDLE)
                throw new TimerAlreadyExpiredException();
            status = CLEARED;
            notify();
        }
    }
    
    /**
     * Currently not implemented
     * @deprecated Not implemented in current version; will be removed in a future release
     */
    public void destroy()
    {
    }
    
    /**
     *  method to add a listener to the timer
     * @param listener denotes an object with an ITimerListener interface implemented
     * @see ITimerListener
     */
    public void addTimerListener(ITimerListener listener)
    {
        timerListeners.addElement(listener);
    }
    
    /**
     *  method to remove a listener from the timer
     *  @param listener denotes an object with an ITimerListener interface implemented
     *  @see ITimerListener
     */
    public void removeTimerListener(ITimerListener listener)
    {
        timerListeners.removeElement(listener);
    }
    
    /**
     * Getter for timer listeners
     * @return timer listeners
     * @see ITimerListener
     */
    public Enumeration getTimerListenersEnum()
    {
        return timerListeners.elements();
    }
    
    /**
     * @exception Throwable thrown per Java spec
     */
    protected void finalize() throws Throwable
    {
        destroy();
        super.finalize();
    }
}
 
 
