package com.verifone.isd.vsms2.sys.util.version;	// adapted from package com.verifone.isd.vsms2.autoupgrade.app.rt.kiosk

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * Content handler class to convert XML file/data sent as payload to CGI command into KioskVersionDetails object
 * @author T_ManasiS1
 *
 */
public class KiosksVersionXMLBaseHandler extends SAXContentHandler {
	
	protected KioskVersionDetails kioskVerDetails;
	private KioskModuleDetails moduleDetails;
	private StringBuffer buffer;
	private boolean isRootFound;
	
	public KiosksVersionXMLBaseHandler() {
		buffer = new StringBuffer();
	}
	
	/**
	 * @param uri the element's uri
	 * @param localName the element's local name
	 * @param qName The element's qualified name.
	 * @param attributes The specified or defaulted attributes.
	 * @see org.xml.sax.ContentHandler#startElement
	 */     
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		try {
			buffer.delete(0, buffer.length());
			if (!isRootFound) {
				if ((localName.equals(IXMLVocabulary.KIOSK))) {
					isRootFound = true;
					kioskVerDetails = new KioskVersionDetails();
					int sysId = Integer.parseInt(atts.getValue(IXMLVocabulary.REGISTER_SYS_ID));
					kioskVerDetails.setKioskSysID(sysId);
				}
				else {
					throw new SAXException("Invalid root element: " +localName);
				}
			} else if(localName.equals(IXMLVocabulary.MODULE)) {
				moduleDetails = new KioskModuleDetails();
				String modName = atts.getValue(IXMLVocabulary.MODULE_NAME);
				moduleDetails.setModuleName(modName);
			} else if(localName.equals(IXMLVocabulary.MODULE_VER) ||
					localName.equals(IXMLVocabulary.TIME_STAMP) || localName.equals(IXMLVocabulary.BUILD_HASH)) {
				
			}
		} catch(Exception e) {
			throw new SAXException(uri +" " +localName, e);
		}
	}
	
	
	public void characters(char[] ch, int start, int length)throws SAXException {
		buffer.append(ch, start, length);
	}
	
	
	/**
	 * @param uri the element's uri
	 * @param localName the element's local name
	 * @param qName The element's qualified name.
	 * @see org.xml.sax.ContentHandler#endElement
	 */    
	public void endElement(String uri, String localName, String qName)throws SAXException {
		try {
			if (isRootFound) {
				if (uri.equals(IXMLVocabulary.EMPTY_STRING)) {
					if(localName.equals(IXMLVocabulary.MODULE_VER)) {
						moduleDetails.setModuleVer(buffer.toString().trim());
					} else if(localName.equals(IXMLVocabulary.TIME_STAMP)) {
						moduleDetails.setTimeStamp(buffer.toString().trim());
					} else if(localName.equals(IXMLVocabulary.BUILD_HASH)) {
						moduleDetails.setBuildHash(buffer.toString().trim());
					} else if(localName.equals(IXMLVocabulary.MODULE)) {
						kioskVerDetails.addModule(moduleDetails);
						moduleDetails = null;
					}
				}
			}
		} catch (Exception ex) {
			throw new SAXException(uri +" " +localName, ex);
		}
	}
	
	/**
	 * Method to get the kiosk version details
	 * @return kioskVerDetails - version details
	 */
	public KioskVersionDetails getKioskVersionDetails() {
		return kioskVerDetails;
	}
}
