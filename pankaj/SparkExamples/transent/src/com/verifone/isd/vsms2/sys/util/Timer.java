package com.verifone.isd.vsms2.sys.util;

import java.util.Vector;
import java.util.Enumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  class to allow setting of a timer to control or bound an operation.
 *  The class may be replaced by a factory method to create a real os timer
 *  for efficiency.
 *
 *  @author "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public class Timer implements Runnable
{
    private Logger logger = LoggerFactory.getLogger(Timer.class);
    private static final int INVALID = 0;
    private static final int IDLE = 1;
    private static final int READY = 2;
    private static final int TIMED_OUT = 3;
    private static final int CLEARED = 4;
    
    private int status = INVALID;
    
    private long duration = 0;
    /**
     * collection of timer listeners
     */
    protected Vector timerListeners = null;
    private Thread thread = null;
    private boolean keepRunning = true;
    
    /**
     *  create a timer to expire at a certain time (doesn't start the timer).
     *  @param duration the number of milliseconds before the timer expires
     *  @see #go()
     */
    public Timer (long duration)
    {
        this.duration = duration;
        timerListeners = new Vector();
        thread = new Thread(this, "Timer_" +duration);
        thread.start();
    }
 
    /**
     * Destroy the timer without triggering any callbacks to the listeners.
     */
    public void destroy()
    {
        timerListeners.clear();        
        timerListeners = null;
        synchronized(this) {
        keepRunning = false;
            notify();
        }
        thread = null;
    }
    
    /**
     *  start the timer
     *  @exception Exception thrown if the timer is in an invalid state
     */
    public void go() throws Exception
    {
        synchronized(this) {        
        status = INVALID;   // force reset
        }
        int curStatus;
        do
        {
            synchronized(this) {
                if (READY != status) {
                notify();
                }
            }
            /*04/01/2004: Changes Thread.yield() to Thread.sleep()
             * Even though the API spec says yield will give other threads
             * a chance to run, if the thread on which this method is executed is at 
             * a higher priority than the timer thread, the timer thread never gets 
             * a chance to run (since LynxOS uses preemptive scheduling). 
             * To give ANY other thread a chance to run, call sleep instead of yield.
             */
            Thread.sleep(20);
            synchronized(this) {
                curStatus = status;
            }
        }
        while (curStatus != READY);
    }
    
    /**
     *  this method executes the timer. It is public only because the Runnable interface 
     *  requires that it be so.
     *  @see java.lang.Runnable
     *  @see java.lang.Thread
     */
    public synchronized void run()
    {
        while (keepRunning) {
            try {
                try {
                    status = IDLE;
                    wait();
                    if (!keepRunning) {
                        break;
                    }

                    if (status == INVALID) {
                        continue;
                    }

                    status = READY;
                    wait(duration);

                } catch (InterruptedException ex) {
                }
                if (timerListeners == null) {
                    keepRunning = false;
                }
                if (!keepRunning) {
                    break;
                }
                if (status == INVALID) {
                    continue;
                }

                if (status == READY) {
                    status = TIMED_OUT;
                }
                Enumeration e = timerListeners.elements();
                while (e.hasMoreElements()) {
                    ITimerListener listener = (ITimerListener) e.nextElement();
                    switch (status) {
                        case TIMED_OUT:
                            listener.expired();
                            break;
                        case CLEARED:
                            listener.cleared();
                            break;
                    }
                }
            } catch (Throwable t) {
                logger.error(Thread.currentThread().getName() + " thread death averted: " + t.toString());
            }
        }
    }

    /**
     * interrupts the timer, the timer remains available
     * for restart
     * @exception TimerAlreadyExpiredException if the call is too late to catch the timer
     * @see #go()
     */
    public void clear() throws TimerAlreadyExpiredException
    {
        boolean yieldThread = false;
        synchronized (this) 
        {
            if (status == READY)
            {
                status = CLEARED;
                notify();
                yieldThread = true; // prevent deadlock... can't call Thread.yield() here
            }
            else
                throw new TimerAlreadyExpiredException();
        }
        if (yieldThread)
            Thread.yield();
    }
    
    /**
     *  method to add a listener to the timer
     *  @param listener denotes an object with an ITimerListener interface implemented
     *  @see ITimerListener
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
     * Implementation method
     * @exception Throwable thrown per Java spec
     */
    protected void finalize() throws Throwable
    {
        if (SysPropertyFactory.reportFinalizers()) {
            if (logger.isInfoEnabled()) {
                logger.info("finalizing "+this.getClass().getName());
            }
        }
        destroy();
        super.finalize();
    }
}
 
 
