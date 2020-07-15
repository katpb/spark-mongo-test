package com.verifone.isd.vsms2.sys.util;
import java.util.*;


/**
 *  Class which operates a lot like a Hashtable but
 *  keeps an "access ordered" cache of objects and keys.
 *
 *  The internal Hashtable associates a key with a value.  
 *  There are two fixed size vectors, one contains an ordered list of 
 *  keys, the other an ordered list of values.  Each time 
 *  the get() method is called on an item, both the key 
 *  and value are moved to the top of their vectors.  If a 
 *  put() method is called and there's no room, the oldest entry 
 *  for each vector and the associated Hashtable entry are removed 
 *  before adding.
 *
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *  @version 1.0
 *  @see java.util.Vector
 *  @see java.util.Hashtable
 */
public class Cache 
{
    /**
     *  keeps an ordered list of values
     */
    private Vector v = null;
    
    /**
     *  keeps an ordered list of keys
     */
    private Vector k = null;
    
    /**
     *  hashtable to associate keys to values for quick access.
     */
    private Hashtable h = null;
    
    /**
     *  the fixed size of the cache
     */
    private int size = 0;
    
    /**
     * creates a cache to contain the number of units designated.
     * @param size the maximum capacity in units of the cache.
     */
    public Cache(int size)
    {
        this.size = size;
        this.v = new Vector(size);
        this.k = new Vector(size);
        this.h = new Hashtable(size);
    }
    
    /**
     *  private "default" constructor to support cloning
     */
    private Cache()
    {
    }
    
    /**
     * Query method to return the current size of the cache
     * @return the size of the cache
     */
    public final synchronized int size() { return v.size(); }
    
    /**
     * Query method to return the cache capacity
     * @return the capacity of the cache
     */
    public final synchronized int capacity() { return v.capacity(); }
    
    /**
     * Query method to return if the cache is empty
     * @return true if the cache is empty
     */
    public final synchronized boolean isEmpty() { return v.isEmpty(); }
    
    /**
     * Getter for the elements in the cache
     * @return an enumeration of the values in the cache
     * @see java.util.Enumeration
     */
    public final synchronized Enumeration elements() { return v.elements(); }
    
    /**
     * Query method to check if an object is in the cache
     * @param elem the object to find in the cache
     * @return true if the object is in the cache
     */
    public final synchronized boolean contains(Object elem) { return v.contains(elem); }
    
    /**
     * Query method to query if a given key is in the cache
     * @param key of the object to find in the cache
     * @return true if the key is in the cache
     */
    public final synchronized boolean containsKey(Object key) { return h.containsKey(key); }
    
    /**
     *  create an entry in the cache associating the key with the value
     *  @param key the key value to associate
     *  @param obj the value to associate with the key
     *  @return any value object formerly associated with the key value, may return null.
     *  @see java.util.Hashtable
     */
    public synchronized Object put(Object key,Object obj)
    {
        Object rval = null;
        
        // enforce uniqueness
        // check to see if it exists...
        Object oldObj = h.get(key);
        if (oldObj != null)  // clear the old instance if it does
        {
            int ix = v.indexOf(oldObj);
            if (ix != -1)
            {
                rval = v.elementAt(ix);     // save for the return
                v.removeElementAt(ix);
                k.removeElementAt(ix);
                h.remove(key);
            }
        }
        
        /*
        ** note that if we reindexed, we've already removed
        ** one object, so the test below will not succeed,
        ** meaning that rval will not be reset.
        */
        if (v.size() == size)       // if the list is full
        {
            rval = v.elementAt(0);      // save for the return
            v.removeElementAt(0);       // take off head
            h.remove(k.elementAt(0));   // clear from hash
            k.removeElementAt(0);
        }
        
        v.addElement(obj);          // put at the end
        k.addElement(key);
        h.put(key,obj);
        return rval;
    }
    
    /**
     *  return a value from the cache for the key provided, moving both key and
     *  value to the "most recently accessed" position in the cache.
     *  @param key the key to use
     *  @return the associated value
     *  @exception NoSuchElementException thrown if the key doesn't match any value in the cache.
     */
    public synchronized Object get(Object key) throws NoSuchElementException
    {
        Object obj = h.get(key);
        if (obj == null)
            throw new NoSuchElementException();
                
        v.removeElement(obj);
        k.removeElement(key);
        v.addElement(obj);
        k.addElement(key);
        return obj;
    }
    
    /**
    *   remove a key/value pair from the cache designated by the key.
    *   @param key the key to use
    *   @return the value of the entry removed.
    *   @exception NoSuchElementException thrown if the key doesn't match any value in the cache.
    */
    public synchronized Object remove(Object key) throws NoSuchElementException
    {
        Object obj = h.get(key);
        if (obj == null)
            throw new NoSuchElementException();
                
        v.removeElement(obj);
        k.removeElement(key);
        h.remove(key);
        return obj;
    }
    
    /**
     *   remove a key/value pair from the cache designated by the value.
     *   This method requires looping through the cache to find the entry, so it is to be used
     *   very sparingly.
     * @return the value of the entry removed.
     * @param obj object to be removed
     * @exception NoSuchElementException thrown if the value doesn't match any value in the cache.
     */
    public synchronized Object removeObject(Object obj) throws NoSuchElementException
    {
        for (Enumeration e = h.keys();e.hasMoreElements();)
        {
            Object key = e.nextElement();
            if (h.get(key).equals(obj))
            {
                h.remove(key);
                k.removeElement(key);
                v.removeElement(obj);
                return obj;
            }
        }
        throw new NoSuchElementException();
    }
            
    /**
     *  clone the cache.  The copy is shallow with regard to keys and values but does replicate the collections.
     *  @return the new cache.
     *  @see java.lang.Object
     */
    public synchronized Object clone() throws java.lang.CloneNotSupportedException 
    {
        
        Cache c = (Cache)super.clone();
        c.v = (Vector)this.v.clone();
        c.k = (Vector)this.k.clone();
        c.h = (Hashtable)this.h.clone();
        c.size = this.size;
        return c;
    } 
    
    /**
     *  clear the cache of all entries
     */
    public synchronized void clear()
    {
        h.clear();
        k.removeAllElements();
        v.removeAllElements();
    }
    
    /**
     *  check that the cache is coherent in its internal values
     *  @exception Exception thrown if the cache is not coherent
     */
    public synchronized void assertValid() throws Exception
    {
        if (k.size() != this.size || v.size() != this.size)
            throw new Exception();
    }
}