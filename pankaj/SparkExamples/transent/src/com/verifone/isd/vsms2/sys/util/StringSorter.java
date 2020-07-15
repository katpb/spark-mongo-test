package com.verifone.isd.vsms2.sys.util;

import java.text.Collator;
import java.text.CollationKey;

/**
 *  Utility class to sort an array of strings.
 *  @see java.text.Collator
 *  @see java.text.CollationKey
 *  @version 1.0
 *  @author Bhanu Narayanan "mailto:bhanu_n2@verifone.com"
 *
 */
public class StringSorter
{
    /**
     * Constant defining the sort order as ascending
     */
    public static final boolean IS_ASCENDING = true;
    /**
     * Constant defining the sort order as descending
     */
    public static final boolean IS_DESCENDING = false;
    private static StringSorter theInstance;
    private Collator collator;
    
    private StringSorter()
    {
        this.collator = Collator.getInstance();
    }
    
    /**
     * Singleton getter
     * @return the singleton instance
     */
    public static synchronized StringSorter getInstance()
    {
        if (theInstance == null)
        {
            theInstance = new StringSorter();
        }
        return theInstance;
    }
    /**
     * sort the array of strings in descending order.
     * @param words strings to be sorted
     * @param sortType sort type based on the constants defined
     */
	public synchronized void sortList(String[] words, boolean sortType) 
	{
	    if ((words == null) || (words.length <= 1))
	        return;
	    CollationKey[] keys = new CollationKey[words.length];
        for (int i = 0; i < keys.length; i++) 
        {
            keys[i] = collator.getCollationKey(words[i]);
        }
        quickSort(keys, 0, keys.length-1); //Defaults to ascending
	    for (int i = 0; i < keys.length; i++)
	    {
	        int index = (sortType == IS_ASCENDING) ? i : (keys.length -(i+1));
	        words[i] = keys[index].getSourceString();
	    }
    }
    private void quickSort(CollationKey[] keys, int left, int right)
    {
        if (left >= right)
            return;
        swap(keys, left, (left+right)/2);
        int last = left;
        for (int current = left + 1; current <= right; current++)
        {
            if (keys[current].compareTo(keys[left]) < 0)
            {
                swap(keys, ++last, current);
            }
        }
        swap(keys, left, last);
        quickSort(keys, left, last-1);
        quickSort(keys, last+1, right);
     }
     
    private void swap(CollationKey[] keys, int i, int j)
    {
        CollationKey tempKey = keys[i];
        keys[i] = keys[j];
        keys[j] = tempKey;
    }
}