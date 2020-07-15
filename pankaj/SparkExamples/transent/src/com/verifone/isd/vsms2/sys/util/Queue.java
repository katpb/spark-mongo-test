package com.verifone.isd.vsms2.sys.util;

import java.util.Vector;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 *  Makes a waitable queue out of a Vector.
 *  The class can be configured for an unlimited number
 *  of items, or given a definite maximum.
 *  If the getItem() method is called with wait set to <code>true</code>, 
 *  the object will block until another item is inserted.
 *  
 *  @author "mailto:david_ezell@verifone.com"
 *  @version 1.0
 *  @see java.util.Vector
 */
public class Queue
{
    private int maxItems = 0;
    private Vector list = null;
	private long hiWater = 0;
    
    /**
     *  constructor for a Queue with an unlimited number of items
     */
    public Queue()
    {
        list = new Vector();
    }
    
    /**
     *  constructor for a Queue with a limited size
     *  @param maxItems the maximum number of items on the queue.
     */
    public Queue(int maxItems)
    {
        this.maxItems = maxItems;
        list = new Vector(maxItems);
    }
    
    /**
     *  puts an object on the end of the queue.  It the queue is fixed size, an exception may
     *  be thrown.
     * @param obj the Object to put on the Queue.
     * @throws ArrayIndexOutOfBoundsException if the predetermined queue size would have been exceeded.
     * @see #maxItems
     */
    public void putItem(Object obj) throws ArrayIndexOutOfBoundsException {
        int size = 0;
        synchronized (this) {
            if (maxItems > 0 && list.size() >= maxItems) {
                throw new ArrayIndexOutOfBoundsException();
            }
            list.addElement(obj);
            size = list.size();
            notify();
        }
        if (hiWater < size) {
            hiWater = size;
        }
        
    }
    
    /**
     * Getter for peak usage of the queue
     * @return peak number of entries in the queue
     */
    public long getHighWater()
    {
        return hiWater;
    }
    
    /**
     *  gets an item off the queue.  If no items are available, behavior depends on the value
     *  of the parameter.
     * @param wait if true and no items, then block on the Queue object until one comes available. 
     * If wait is not true and no items, throw the exception
     * @throws NoSuchElementException if no elements are available.
     * @return the object requested.
     */
    public synchronized Object getItem(boolean wait) throws NoSuchElementException
    {
        if (wait && list.isEmpty())
        try {
            /* this should be a simple wait
            ** the while (list.size() == 0) is added because of a vm bug
            ** as a work around.  It's not going to work in production.
            */
            while (list.size() == 0)
                wait(1000);
        }
        catch (InterruptedException e)
        {
            throw new NoSuchElementException();
        }
        Object o = list.firstElement();
        list.removeElementAt(0);
        return o;
    }
}