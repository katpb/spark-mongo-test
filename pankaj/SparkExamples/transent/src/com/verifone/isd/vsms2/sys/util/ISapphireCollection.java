package com.verifone.isd.vsms2.sys.util;

import java.util.Enumeration;
import java.util.Vector;

/** Interface to be implemented by collection classes. This interface
 * provides generic access methods. This interface specifically allows
 * duplicate elements. However, reaching the duplicates may only be
 * possible using elements() and elementAt() methods.
 * @author "mailto:bhanu_narayanan@verifone.com"
 * @version 1.0
 */

public interface ISapphireCollection
{
    /** Value to represent an unbounded collection size */    
    public static final int UNKNOWN_MAX_SIZE = -1;
    /** returns the index of the first occurrence of the given object;
     * -1 if the object is not found in the collection
     * @param obj the object to get index
     * @return index of the object's first occurrence; -1 if object not in collection
     */
	public int indexOf (Object obj);
    /** Getter for an object given its key object
     * @param objID key for the class; use wrapper classes for primitive types
     * @return requested object; null if an object with the required key is not found
     */    
	public Object get (Object objID); 
    /** Getter for an element, give its index in the collection
     * @param index object's index in the collection
     * @return object at the specified index; null if index is invalid
     */    
    public Object elementAt (int index);
    /** Add element to the collection
     * @param newObj object to be added
     */    
    public void addElement (Object newObj);
    /** Remove element from the collection
     * @param remObj object to be removed
     * @return true if the object was removed
     */    
    public boolean removeElement (Object remObj);
    /** Getter for all the elements in the collection as an enumeration
     * @return enumeration of all elements
     */    
	public Enumeration elements();
    /** Getter for number of objects in the collection
     * @return number of objects in the collection
     */    
	public int getCount();
    /** Getter for maximum allowed size of the collection
     * @return maximum allowed size of the collection
     */    
	public int getMaximumSize();
    /** Setter for maximum allowed size of the collection
     * @param maxSize maximum allowed size of the collection
     */    
	public void setMaximumSize(int maxSize);
}
 
 
