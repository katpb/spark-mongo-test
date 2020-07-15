package com.verifone.isd.vsms2.sys.util;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Class which keeps a vector of objects and calls them back periodically.
 *  Each of the objects to watch must have a WatchObjects.IWatchObjects
 *  interface.
 * @author David Ezell "mailto:david_ezell@verifone.com"
 * @version 1.0
 * @see java.util.Vector
 * @see java.util.Enumeration
 */
public class WatchObjects implements Runnable
{
	private Logger logger = LoggerFactory.getLogger(WatchObjects.class);
    private Vector objs = null;
    private Thread thread = null;
    private boolean keepRunning = true;
    private long intervalMillis = 0;

    /* waitCheckPoint - maintained in hashtable for easy access in getCkeckPoints() method. It
     * is maintained separately for easy access in the run() method.
     */
    private CheckPoint waitCheckPoint;
    private Hashtable checkPoints;
   
    /**
     * Interface to be implemented by objects that need to be watched and periodically notified.
     */
    public interface IWatchObject {
        /**
         * Callback method
         * @param caller associated WatchObjects instance
         */
        public void check(WatchObjects caller);
    }
    
    /**
     *  constructor
     *  @param intervalMillis causes the set of objects to be checked each time this interval elapses.
     */
    public WatchObjects(long intervalMillis)
    {
        String name = "WatchObjects_" +intervalMillis;
        objs = new Vector();
        this.checkPoints = new Hashtable();
        
        String checkPointName = name +"_WAIT";
        this.waitCheckPoint = new CheckPoint(checkPointName);
        checkPoints.put(checkPointName, waitCheckPoint);
        this.intervalMillis = intervalMillis;
        thread = new Thread(this, name);
        /* 
        thread = new Thread(SapphireVMController.DEFAULT_GROUP, this, 
            "WatchObjects_" +intervalMillis); 
        */
        thread.start();
    }
    
    /**
     *  stop the internal thread, allowing WatchObjects to be garbage collected.
     */
    public void stop()
    {
        synchronized (this)
        {
            keepRunning = false;
            notify();
        }
    }
    
    /**
     * Accessor for all check points associated with the instance
     * @return an enumeration of the instance's check points
     */
    public Enumeration getCheckPoints() {
        return this.checkPoints.elements();
    }
    
    /**
     * add an object to be watched (IWatchObjects implementation) to the monitored collection
     * @param wo the object to be watched (IWatchObjects implementation)
     * @see com.verifone.isd.vsms2.sys.util.WatchObjects.IWatchObject
     */
    public void addWatchObject(IWatchObject wo)
    {
        String checkPointName = wo.toString();
        checkPoints.put(checkPointName, new CheckPoint(checkPointName));        
        objs.addElement(wo);
    }
    
    /**
     * remove a watched object from the monitored collection
     * @param wo a watched object to be removed from the collection
     * @see com.verifone.isd.vsms2.sys.util.WatchObjects.IWatchObject
     */
    public void removeWatchObject(IWatchObject wo)
    {
        checkPoints.remove(wo.toString());      
        objs.removeElement(wo);
    }
    
    /**
     *  called internally by the thread.  Has to be "public" to satisfy the Runnable interface,
     *  but run() should not be called by the application.
     */
    public void run()
    {
        boolean keepRun = false;
        synchronized(this) {
            keepRun = this.keepRunning;
        }
        while (keepRun)
         {

            try {
                this.waitCheckPoint.incrEntryCount();
                try {
                    synchronized (this) {
                        wait(intervalMillis);
                    }
                    this.waitCheckPoint.incrExitCount();
                    Enumeration s = objs.elements();
                    while (s.hasMoreElements()) {
                        IWatchObject curWO = (IWatchObject)s.nextElement();
                        CheckPoint pt = (CheckPoint)this.checkPoints.get(curWO.toString());
                        pt.incrEntryCount();
                        curWO.check(this);
                        pt.incrExitCount();
                    }
                    synchronized(this) {
                        keepRun = this.keepRunning;
                    }
                }
                catch (InterruptedException e)
                {
                    keepRun = false;
                    this.waitCheckPoint.incrExitCount();
                }
            }
            catch (Throwable t) {
                logger.error(Thread.currentThread().getName() + " thread death averted: " +t.toString());

                this.waitCheckPoint.incrExitCount();
            }
        }
        this.objs.clear();
        this.checkPoints.clear();
    }
    
    /**
     * Implementation method
     * @exception Throwable per the spec
     */
    protected void finalize() throws Throwable
    {
        super.finalize();
    }
}
    
