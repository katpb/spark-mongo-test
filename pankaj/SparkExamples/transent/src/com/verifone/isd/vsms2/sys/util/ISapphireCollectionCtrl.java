package com.verifone.isd.vsms2.sys.util;

import java.util.Enumeration;
import java.util.Vector;

/**  
 * Interface to be implemented by collection classes that require
 * finer control not provided by ISapphireCollection.
 * @author "mailto:bhanu_narayanan@verifone.com"
 * @version 1.0
 */

public interface ISapphireCollectionCtrl
{
    /** Method to empty the collection and insert the elements passed.
     * @param newElements new elements to be inserted
     */    
    public void setElements (Enumeration newElements);
}
 
 
