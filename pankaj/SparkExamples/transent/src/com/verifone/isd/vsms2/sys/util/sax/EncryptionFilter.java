/*
 * Created on Sep 6, 2005
 * Copyright(c) 2005 VeriFone, Inc.  All Rights Reserved.
 */
package com.verifone.isd.vsms2.sys.util.sax;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.Locator;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.XMLFilterImpl;
import com.verifone.isd.vsms2.sys.util.encrypt.IEncryptionService;

/**
 * @author David_E3
 * XMLFilter to allow com.verifone.isd.vsms2.sys.util.encryption and decryption of XML documents.  The handler operates in
 * either "ENCRYPT" or "DECRYPT" mode for the duration of a parse session.  The com.verifone.isd.vsms2.sys.util.encryption
 * code is accessed through an IEncryptionService interface set before the parse session.
 *
 * after constructing the handler, call the following methods
 * <pre>
 * setIEncryptionService(IEncryptionService encInterface) -- initialize the com.verifone.isd.vsms2.sys.util.encryption interface
 * setSimpleXPath(SimpleXPath sxp)	-- give the handler xPaths to use to identfy things to encrypt
 * setEncryption(boolean doEncryption) -- true to encrypt, false to decrypt
 *
 * followed by one of the following to direct output:
 * setContentHandler(ContentHandler outContentHandler)	-- your own content handler
 * setWriter(Writer writer) -- constructs a Serializer and intializes it with a Writer
 * setOutputStream(OutputStream out) -- constructs a Serializer and initializes it with an OutputStream
 * </pre>
 *
 * @see com.verifone.isd.vsms2.sys.util.encrypt.IEncryptionService
 * @see com.verifone.isd.vsms2.sys.util.sax.SimpleXPath
 * @see org.apache.xml.serialize.Serializer
 * @see org.xml.sax.helpers.XMLFilterImpl
 */
public class EncryptionFilter extends XMLFilterImpl {
    public static final boolean ENCRYPT = true;
    public static final boolean DECRYPT = false;
    
    private boolean doEncryption = true;
    private SimpleXPath sxp = null;
    private IEncryptionService encInterface = null;
    private Stack processCharStack = null;
    private boolean processChars = false;
    private StringBuffer charContent;
    private int skippedElementCount;
    /**
     * default constructor
     */
    public EncryptionFilter(IEncryptionService ie, SimpleXPath sxp, boolean doEncryption) {
        super();
        this.encInterface = ie;
        this.sxp = sxp;
        this.doEncryption = doEncryption;
        this.processCharStack = new Stack();
        this.charContent = new StringBuffer();
    }
    
    /**
     * Start document.
     *
     * @see org.xml.sax.ContentHandler#startDocument()
     */
    public void startDocument() throws SAXException {
        this.processCharStack.clear();
        this.processChars = false;
        this.sxp.reset();
        
        super.getContentHandler().startDocument();
    } // startDocument()
    
    /**
     * Start element.
     *
     * @see org.xml.sax.ContentHandler#startElement(String,String,String,Attributes)
     */
    public void startElement(String uri, String local, String raw, Attributes attrs) throws SAXException {
        if (this.skippedElementCount > 0) {
            this.skippedElementCount++;
        } else {
            SimpleXPath.PushStepResult tmpResult = sxp.pushStep(uri,local);
            if (tmpResult.requiredElement) {
                this.processCharStack.push((this.processChars) ? Boolean.TRUE : Boolean.FALSE);
                this.processChars = tmpResult.matchingNames.length > 0;
            } else {
                this.processChars = false;
                this.skippedElementCount = 1;
            }
            if (this.processChars) {
                if (attrs.getLength() > 0) {
                    String[] astrs = sxp.checkAttributes(attrs);
                    if (astrs.length > 0) {
                        AttributesImpl attrsImpl = new AttributesImpl(attrs);
                        for (int i = 0; i < astrs.length; i++) {
                            String nodeName = astrs[i];
                            SimpleXPath.Node n = sxp.getNodeInfo(nodeName);
                            int index = attrsImpl.getIndex(n.ns,n.localName);
                            String value = attrsImpl.getValue(index);
                            try {
                                if (this.doEncryption) {
                                    value = new String(this.encInterface.encryptAndEncode(value.toCharArray()));
                                } else {
                                    try {
                                        char[] result = this.encInterface.decryptEncodedData(value.toCharArray());
                                        value = new String(result);
                                        //Clear the local buffer
                                        int len = result.length;
                                        for (int z = 0; z < len; z++) {
                                            result[z] = (char)0;
                                        }
                                    } catch (Exception e){}
                                }
                                attrsImpl.setValue(index, value);
                            } catch (Exception e) {
                                throw new SAXException(e);
                            }
                        }
                        attrs = attrsImpl;
                    }
                }
            }
        }
        super.getContentHandler().startElement(uri,local,raw,attrs);
    } // startElement(String,String,String,Attributes)
    
    /**
     * characters.
     *
     * @see org.xml.sax.ContentHandler#characters(char[],int,int)
     */
    public void characters(char ch[], int start, int length)
    throws SAXException {
        if (this.processChars) { //Accumulate all char content before calling encrypt or decrypt
            charContent.append(ch,start,length);
        } else {
            super.getContentHandler().characters(ch, start, length);
        }
    } // characters(char[],int,int);
    
    /**
     * end element.
     *
     * @see org.xml.sax.ContentHandler#endElement(String,String,String)
     */
    public void endElement(String uri, String local, String raw)
    throws SAXException {
        if (this.processChars) {
            int len = charContent.length();
            char[] value = new char[len];
            charContent.getChars(0, len, value, 0);
            try {
                if (this.doEncryption) {
                    value = this.encInterface.encryptAndEncode(value);
                } else {
                    try {
                        value = this.encInterface.decryptEncodedData(value);
                    } catch (Exception e){}
                }
                super.getContentHandler().characters(value, 0, value.length);
            } catch (Exception e) {
                throw new SAXException(e);
            } finally {
                this.charContent.delete(0, len);
            }
        }
        if (this.skippedElementCount > 0) {
            this.skippedElementCount--;
        } else {
            sxp.popStep();
            this.processChars = ((Boolean)(this.processCharStack.pop())).booleanValue();
        }
        super.getContentHandler().endElement(uri,local,raw);
    } // endElement(String)
}