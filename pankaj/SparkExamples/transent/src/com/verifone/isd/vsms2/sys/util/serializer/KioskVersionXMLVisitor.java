package com.verifone.isd.vsms2.sys.util.serializer;	// moved from package com.verifone.isd.vsms2.autoupgrade.serializer

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.verifone.isd.vsms2.sys.util.log4j.NamedLoggers;
import com.verifone.isd.vsms2.sys.util.sax.ISAXSerializable;
import com.verifone.isd.vsms2.sys.util.version.KioskModuleDetails;
import com.verifone.isd.vsms2.sys.util.version.KioskVersionDetails;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * Class used to persist kiosk version details in a XML file
 * @author T_ManasiS1
 *
 */
public class KioskVersionXMLVisitor implements ISAXSerializable {
	
	private ContentHandler ch;
	private KioskVersionDetails verDetails;
	
	public KioskVersionXMLVisitor(KioskVersionDetails verDetails) {
		super();
		this.verDetails = verDetails;
	}
	
	public void setContentHandler(ContentHandler contentHandler) {
		this.ch = contentHandler;		
	}

	@Override
	public void writeSAX(ContentHandler contentHandler) throws SAXException {
		this.ch = contentHandler;
		if(this.verDetails == null) {
			throw new SAXException(" No version details to write ");
		}
		try {
			this.writeXML(verDetails);
		} catch(Exception e) {
			throw new SAXException(e.getMessage());
		}
		
	}
	
	/**
	 * method used to write details in XML
	 * @param verDetails
	 * @throws SAXException
	 */
	private void writeXML(KioskVersionDetails verDetails) throws SAXException {
		char[] chars = null;
		String data = null;

		try {
			ch.startPrefixMapping(IXMLVocabulary.KIOSK_DOMAIN_NS, IXMLVocabulary.KIOSK_NS);
			//register sysID
			AttributesImpl attrs = new AttributesImpl();
			String sysID = String.valueOf(verDetails.getKioskSysID());
			attrs.addAttribute(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.REGISTER_SYS_ID, IXMLVocabulary.EMPTY_STRING,
					IXMLVocabulary.CDATA_TYPE, sysID);
			ch.startElement(IXMLVocabulary.KIOSK_NS, IXMLVocabulary.KIOSK, IXMLVocabulary.EMPTY_STRING, attrs);
			if(verDetails.getModulesList() != null && verDetails.getModulesList().size() > 0) {
				for(KioskModuleDetails tmpDetails : verDetails.getModulesList()) {
					attrs = new AttributesImpl();
					//module name
					data = tmpDetails.getModuleName();					
					attrs.addAttribute(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODULE_NAME, IXMLVocabulary.EMPTY_STRING,
								IXMLVocabulary.CDATA_TYPE, data);
					ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODULE, IXMLVocabulary.EMPTY_STRING, attrs);
					attrs = new AttributesImpl();
					//module version
					data = tmpDetails.getModuleVer();
					ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODULE_VER, IXMLVocabulary.EMPTY_STRING, attrs);
					chars = data.toCharArray();
					ch.characters(chars, 0, chars.length);
					ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODULE_VER, IXMLVocabulary.EMPTY_STRING);
					//time stamp
					data = tmpDetails.getTimeStamp();
					ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.TIME_STAMP, IXMLVocabulary.EMPTY_STRING, attrs);
					chars = data.toCharArray();
					ch.characters(chars, 0, chars.length);
					ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.TIME_STAMP, IXMLVocabulary.EMPTY_STRING);
					//build hash
					data = tmpDetails.getBuildHash();
					ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.BUILD_HASH, IXMLVocabulary.EMPTY_STRING, attrs);
					chars = data.toCharArray();
					ch.characters(chars, 0, chars.length);
					ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.BUILD_HASH, IXMLVocabulary.EMPTY_STRING);
					ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODULE, IXMLVocabulary.EMPTY_STRING);
				}
			}
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.KIOSK, IXMLVocabulary.EMPTY_STRING);
		} catch(Exception e) {
			NamedLoggers.AUTOUPGRADE.error("Exception while serializing kiosk version details " , e);
			throw new SAXException(e.getClass().getName() +e.getMessage());
		}
	}

}
