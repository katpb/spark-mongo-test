/*
 * EncryptionFilterListener.java
 *
 * Created on February 6, 2006, 5:23 PM
 */

package com.verifone.isd.vsms2.sys.util.sax;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLFilter;

/**
 * Interface to be implemented by classes that need to be notified of encryption filter's processed results.
 * The implementation classes can apply further business rules to modify the encrypted/ decrypted data before
 * the data is xml serialized.
 * @author bhanu_n2
 */
public interface EncryptFilterResultProcessor extends ContentHandler, XMLFilter{
}
