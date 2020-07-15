package com.verifone.isd.vsms2.sys.db.pres;

import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Content handler to parse persist admin configuration.
 *
 * @see com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
class PersistenceClassMapHandler extends SAXContentHandler {
    private static final int FAULT = -1;
    private static final int DOCUMENT = FAULT + 1;
    private static final int ROOT_ELEM = DOCUMENT +1;
    private static final int ENTITY_DEFN_ELEM = ROOT_ELEM +1;
    private static final int ENTITY_ELEM = ENTITY_DEFN_ELEM +1;
    private static final int PK_ELEM = ENTITY_ELEM +1;
    private static final int PRI_PA_ELEM = PK_ELEM+1;
    private static final int SEC_PA_ELEM = PRI_PA_ELEM+1;
    
    private static final String EMPTY_STRING    = "";
    private static final String ROOT_ELEMENT    = "persistClassMap";
    private static final String ENTITY_DEFN     = "entityDefn";
    private static final String IS_GEMPRO_PA    = "isGemproPA";
    private static final String PRELOAD_REQD    = "isPreloadReqd";  
    private static final String TIMEOUT         = "timeOutMillis";    
    private static final String SYS_ID          = "sysid";
    private static final String NAME            = "name";
    private static final String ENTITY          = "entity";
    private static final String PRI_KEY         = "primaryKey";
    private static final String PRI_PA          = "primaryPersistAdmin";
    private static final String SEC_PA          = "secondaryPersistAdmin";
    
    private int currentElement = FAULT;
    private HashMap <String, PersistenceClassMap> idBasedClassMaps;
    private HashMap <String, PersistenceClassMap> classMaps;
    private PersistenceClassMap curClassMap;
    private StringBuffer strBuf;
    private int primaryTimeOut;
    private int secondaryTimeOut;
    
    PersistenceClassMapHandler() {
        this.idBasedClassMaps = new HashMap <String, PersistenceClassMap>();
        this.classMaps = new HashMap <String, PersistenceClassMap>();
    }
    
    /**
     * Callback to process element start tags.
     * @param uri The element's uri.
     * @param localName The element's local name.
     * @param qName The element's qualified name.
     * @param attrs The specified or defaulted attributes.
     * @exception org.xml.sax.SAXException Any SAX exception,
     * possibly wrapping another exception.
     * @see org.xml.sax.ContentHandler#startElement
     */
    @Override
    public void startElement(String uri, String localName, String qName,
    Attributes attrs) throws SAXException {
        boolean isInvalidState = false;
        switch (currentElement) {
            case FAULT:
            case DOCUMENT:
                if (localName.equals(ROOT_ELEMENT)) {
                    currentElement = ROOT_ELEM;
                }
                else {
                    isInvalidState = true;
                }
                break;
                
            case ROOT_ELEM: // ENTITY_DEFN
                if (localName.equals(ENTITY_DEFN)) {                
                    currentElement = ENTITY_DEFN_ELEM;
                    int ID = Integer.parseInt(attrs.getValue(EMPTY_STRING, SYS_ID));
                    String name = attrs.getValue(EMPTY_STRING, NAME);
                    curClassMap = new PersistenceClassMap(ID, (name == null) ? "" : name);
                }
                else {
                    isInvalidState = true;
                }                
                break;
                
            case ENTITY_DEFN_ELEM:
                if (localName.equals(ENTITY)) {                   
                    currentElement = ENTITY_ELEM;
                }
                else {
                    isInvalidState = true;
                }                
                break;
                
            case ENTITY_ELEM:
                if (localName.equals(PRI_KEY)) {                   
                    currentElement = PK_ELEM;
                }
                else {
                    isInvalidState = true;
                }                
                break;

            case PK_ELEM:
                if (localName.equals(PRI_PA)) {                   
                    currentElement = PRI_PA_ELEM;
                    String preloadReqd = attrs.getValue(EMPTY_STRING, PRELOAD_REQD);
                    if (preloadReqd != null && (preloadReqd.trim().equalsIgnoreCase("1") || 
                    preloadReqd.trim().equalsIgnoreCase("true"))) {
                        curClassMap.setPreloadPrimaryPA(true);   
                    }
                    else {
                        curClassMap.setPreloadPrimaryPA(false);
                    }
                    String timeOut = attrs.getValue(EMPTY_STRING, TIMEOUT);
                    if (timeOut != null && timeOut.trim().length() > 0) {
                        try {
                            this.primaryTimeOut = Integer.parseInt(timeOut.trim());
                        }
                        catch (NumberFormatException nfe) {
                            this.primaryTimeOut = 0;
                        }
                    }
                    else {
                        this.primaryTimeOut = 0;
                    }
                }
                else {
                    isInvalidState = true;
                }                
                break;
                    
            case PRI_PA_ELEM:
                if (localName.equals(SEC_PA)) {                   
                    currentElement = SEC_PA_ELEM;
                    String timeOut = attrs.getValue(EMPTY_STRING, TIMEOUT);
                    if (timeOut != null && timeOut.trim().length() > 0) {
                        try {
                            this.secondaryTimeOut = Integer.parseInt(timeOut.trim());
                        }
                        catch (NumberFormatException nfe) {
                            this.secondaryTimeOut = 0;
                        }
                    }
                    else {
                        this.secondaryTimeOut = 0;
                    }
                }
                else {
                    isInvalidState = true;
                }                
                break;   
        }
        if (isInvalidState) {
            throw new SAXException("Start at unexpected location for element: " +localName);
        }
        if (currentElement == ENTITY_ELEM || currentElement == PK_ELEM ||
        currentElement == PRI_PA_ELEM || currentElement == SEC_PA_ELEM) {
            this.strBuf = new StringBuffer();
        }
    }
    
    /**
     * Callback to process element end tags.
     * @param uri The element's uri.
     * @param localName The element's local name.
     * @param qName The element's qualified name.
     * @exception org.xml.sax.SAXException Any SAX exception, possibly
     * wrapping another exception.
     * @see org.xml.sax.ContentHandler#endElement
     */
    @Override
    public void endElement(String uri,String localName,String qName) throws SAXException {
        boolean isInvalidState = false;
        try {
            switch(currentElement) {
                case DOCUMENT:
                case ROOT_ELEM:
                    currentElement = FAULT;
                    break;
                    
                case ENTITY_DEFN_ELEM:
                    //Will never be in this state
                    break;
                    
                case ENTITY_ELEM:
                    if (localName.equals(ENTITY)) {                       
                        String eclz = this.strBuf.toString().trim();
                        curClassMap.setEntityClassName(eclz);
                    }
                    else {
                        isInvalidState = true;
                    }   
                    break;
                    
                case PK_ELEM:
                    if (localName.equals(PRI_KEY)) {                       
                        String pkclz = this.strBuf.toString().trim();
                        curClassMap.setEntityPKClassName(pkclz);
                    }
                    else {
                        isInvalidState = true;
                    }                     
                    break;
                    
                case PRI_PA_ELEM: //SEC_PA is an optional element; check the actual elem name
                    if (localName.equals(ENTITY_DEFN)) {
                        String idBase = String.valueOf(curClassMap.getEntityId());
                        PersistenceClassMap idMapEntry = this.idBasedClassMaps.get(idBase);
                        if (idMapEntry != null) {
                            this.classMaps.remove(idMapEntry.getEntityClassName());
                        }
                        this.idBasedClassMaps.put(idBase, curClassMap);
                        this.classMaps.put(curClassMap.getEntityClassName(), curClassMap);
                        currentElement = ROOT_ELEM;  
                    }
                    else if (localName.equals(PRI_PA)) {
                        String ppaclz = this.strBuf.toString().trim();
                        curClassMap.setPrimaryPAClassName(ppaclz);
                        curClassMap.setPrimaryPATimeOut(this.primaryTimeOut);
                    }
                    else {
                        isInvalidState = true;
                    }                       
                    break;
                    
                case SEC_PA_ELEM: //2 end elements in a row; check the elem name
                    if (localName.equals(ENTITY_DEFN)) {
                        String idBase = String.valueOf(curClassMap.getEntityId());
                        PersistenceClassMap idMapEntry = this.idBasedClassMaps.get(idBase);
                        if (idMapEntry != null) {
                            this.classMaps.remove(idMapEntry.getEntityClassName());
                        }
                        this.idBasedClassMaps.put(idBase, curClassMap);    
                        this.classMaps.put(curClassMap.getEntityClassName(), curClassMap);
                        currentElement = ROOT_ELEM;  
                    }
                    else if (localName.equals(SEC_PA)) {
                        String spaclz = this.strBuf.toString().trim();
                        curClassMap.setSecondaryPAClassName(spaclz);
                        curClassMap.setSecondaryPATimeOut(this.secondaryTimeOut);
                    }
                    else {
                        isInvalidState = true;
                    }                       
                    break;
            }
            if (isInvalidState) {
                throw new SAXException("End at unexpected location for element: " +localName);
            }
        }
        catch (SAXException se) {
            throw se;
        }
        catch (Exception e) {
            throw new SAXException(e);
        }
    }
    
    /**
     * Callback to process element character content.
     * @param ch The character array.
     * @param start Start location of the element's content.
     * @param length Length of the element's content.
     * @see org.xml.sax.ContentHandler#characters
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement == ENTITY_ELEM || currentElement == PK_ELEM ||
        currentElement == PRI_PA_ELEM || currentElement == SEC_PA_ELEM) {
            this.strBuf.append(ch, start, length);
        }
    }
    
    /**
     * Returns the class maps has table for this object.
     * @return The class maps has table.
     */
    Map <String, PersistenceClassMap> getClassMaps() {
        return this.classMaps;
    }

    public int getPrimaryTimeOut() {
        return this.primaryTimeOut;
    }

    public int getSecondaryTimeOut() {
        return this.secondaryTimeOut;
    }
}
