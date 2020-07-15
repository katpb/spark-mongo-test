package com.verifone.isd.vsms2.sys.util.version;	// copied from package com.verifone.isd.vsms2.autoupgrade.app.rt.kiosk

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

import com.verifone.isd.vsms2.sys.util.SecureSAXParserFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.log4j.NamedLoggers;
import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;

/**
 * Adapted from KioskUpgradeProcessor to obtain needed method getMasterKioskDetails()
 * @author David_G3
 *
 */
public class KioskDetailsProcessor {
	

	/**
	 * Method to read version XML to obtain master kiosk version details
	 * @return KioskVersionDetails - version details of master kiosk i.e. kiosk151.xml
	 */
	public KioskVersionDetails getMasterKioskDetails() {
		InputStreamReader reader = null;
		KioskVersionDetails verDetails = null;
		String kioskVerFilePath = SysPropertyFactory.makeAbsoluteDataPath(SysPropertyFactory.getProperty("default.master.kiosk.id", "kiosk151") + ".xml");
		File kioskVerFile = new File(kioskVerFilePath);
		try {
			if(kioskVerFile.exists()) {
				reader = new InputStreamReader(new FileInputStream(kioskVerFile), SuiteInfoConstants.UTF8_CHARSET_STR);
				KiosksVersionXMLBaseHandler handler = new KiosksVersionXMLBaseHandler();
				SAXParserFactory factory = SecureSAXParserFactory.newSPFInstance();
				SAXParser saxParser = factory.newSAXParser();
				SAXFilter saxFilter = new SAXFilter(saxParser.getXMLReader(), handler);
				saxFilter.parse(new InputSource(reader));
				verDetails = handler.getKioskVersionDetails();
			} else {
				NamedLoggers.AUTOUPGRADE.warn("Kiosk version file not found " + kioskVerFilePath);
				throw new FileNotFoundException(kioskVerFilePath);
			}
		} catch(FileNotFoundException e) {
			NamedLoggers.AUTOUPGRADE.warn("Master kiosk version file not found: " + kioskVerFilePath);
		} catch(Exception e) {
			NamedLoggers.AUTOUPGRADE.error("Exception while obtaining kiosk version details ", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) { }
			}
		}
		return verDetails;
	}

}
