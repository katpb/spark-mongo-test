package com.verifone.isd.vsms2.sys.ent.managedevices;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.user.LoginFailedException;
import com.verifone.isd.vsms2.sys.util.encrypt.CredentialUtility;
import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * Entity class for Manage Devices Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class ManageDeviceConfig implements IEntityObject, ISystemEntityVisitable, Comparable<ManageDeviceConfig> {

	private static final long serialVersionUID = 7908514708377188478L;
	private static final Logger logger = LoggerFactory.getLogger(ManageDeviceConfig.class);
	public static final int MIN_TERMINAL_ID = 151;
	public static final int MAX_TERMINAL_ID = 199;
	public static final int MIN_PORT = 1024;
	public static final int MAX_PORT = 65535;
	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	public static final int MAX_LENGTH_SERIAL_NUM = 16;
	public static final int MAX_LENGTH_VENDOR = 50;
	public static final int MAX_LENGTH_MODEL = 50;
	public static final int MAX_LENGTH_HARDWARE_VERSION = 12;

	private ManageDeviceConfigPK pk;
	private ManageDeviceApplicationType applicationType;
	private String description;
	private String ipAddress;
	private int port;
	private String status;
	private String serialNumber;
	private boolean enabled;
	private String token;
	private String vendor;
	private String model;
	private String hardwareVersion;
	private String name;
	
	public ManageDeviceConfig() {
		
	}
	
	public ManageDeviceConfig(ManageDeviceConfigPK pk) {
		this.pk = pk;
	}

	@Override
	public void accept(ISystemEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (ManageDeviceConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		ManageDeviceConfig config = (ManageDeviceConfig) obj;
		config.setPK(this.pk);
		config.setApplicationType(this.applicationType);
		config.setDescription(this.description);
		config.setName(this.name);
		config.setIpAddress(this.ipAddress);
		config.setPort(this.port);
		config.setStatus(this.status);
		config.setSerialNumber(this.serialNumber);
		config.setEnabled(this.enabled);
		config.setToken(this.token);
		config.setVendor(this.vendor);
		config.setModel(this.model);
		config.setHardwareVersion(this.hardwareVersion);
	}

	@Override
	public void validate() throws Exception {
		if(isPKValid()) {	
			String missingElement = getApplicationType().toString();
			String ipAddress = this.getIpAddress();
			
			if(missingElement == null || ipAddress == null || String.valueOf(getPort()) == null) {
				missingElement = missingElement == null ? IXMLVocabulary.APPLICATION_TYPE : 
					(ipAddress == null ? IXMLVocabulary.IP_ADDRESS : IXMLVocabulary.PORT);				
				throw new SAXException("Missing Mandatory element" + missingElement + "in manageDeviceConfig");
			} else {
				
				if(ipAddress != null && validateIpAddress(ipAddress)) {
					if(!validatePort(getPort())) {
						throw new SAXException("Invalid Port : " + getPort());
					}
				}else {
					throw new SAXException("Invalid IP Address : " + ipAddress);
				}
			}
		} else {
			throw new Exception("Invalid Register ID : " + this.pk);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}
	
	private boolean validateIpAddress(String ipAddr) {
		return ipAddr.matches(IPADDRESS_PATTERN);
	}
	
	private boolean validatePort(int port) {
		return (port >= MIN_PORT && port <= MAX_PORT);
	}
	
	public void validateToken(String rawToken) throws Exception {
        String salt = "";
        String expHash = null;
        int delIdx;
        if ((this.token != null) && (this.token.length() != 0)) { 
        	
            delIdx = this.token.indexOf(CredentialUtility.SALT_DELIMITER_CHAR);
            salt = this.token.substring(0, delIdx);
			expHash = this.token.substring(delIdx + 1);

        
	        if (expHash == null) {
	            logger.error("Invalid hashed password entry!");
	            throw new LoginFailedException("Internal Error ");
	        }

	        String testHash;
            // Hash the new raw password using the salt of the user's salted hashed password
            try {
                testHash = CredentialUtility.hashRawPassword(salt, rawToken);
            } catch (UnsupportedEncodingException ex) {
                logger.error("Internal Error - {}", ex.getMessage());
                throw new LoginFailedException("Internal Error ");
            } catch (NoSuchAlgorithmException ex) {
                logger.error("Internal Error - {}", ex.getMessage());
                throw new LoginFailedException("Internal Error ");
            }
            if(!expHash.equals(testHash)) {
            	throw new LoginFailedException("Login failed, user name or password error.");
            }
            if(!this.isEnabled()) {
    			logger.info("This device is diabled");
            	throw new DeviceDisabledException("This device is diabled");
    		}
        } else {
        	logger.info("This device is not registerd");
        	throw new DeviceNotRegisteredException("This device is not registerd");
        }
	}
	
	public ManageDeviceApplicationType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(ManageDeviceApplicationType appType) {
		this.applicationType = appType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
    public void backupInternalInfo(ContentHandler ch) throws SAXException {
    	
    	String token = this.getToken();
    	if(token != null) {
    		AttributesImpl attrs = new AttributesImpl();
    		
    		ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.DEVICE_DETAILS, IXMLVocabulary.EMPTY_STRING, attrs);

			ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.VENDOR, IXMLVocabulary.EMPTY_STRING, attrs);
			String vendor = this.getVendor();
			ch.characters(vendor.toCharArray(), 0, vendor.length());
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.VENDOR, IXMLVocabulary.EMPTY_STRING);
			
			ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODEL, IXMLVocabulary.EMPTY_STRING, attrs);
			String model = this.getModel();
			ch.characters(model.toCharArray(), 0, model.length());
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.MODEL, IXMLVocabulary.EMPTY_STRING);
			
			ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.HARDWARE_VERSION, IXMLVocabulary.EMPTY_STRING, attrs);
			String hwVersion = this.getHardwareVersion();
			ch.characters(hwVersion.toCharArray(), 0, hwVersion.length());
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.HARDWARE_VERSION, IXMLVocabulary.EMPTY_STRING);
		
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.DEVICE_DETAILS, IXMLVocabulary.EMPTY_STRING);
	    }	
    }
    
    public void backupHashedToken(ContentHandler ch) throws SAXException {
    	
    	String token = this.getToken();
    	if(token != null) {
    		AttributesImpl attrs = new AttributesImpl();
    		
    		ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.SECURE_DEVICE_DETAILS, IXMLVocabulary.EMPTY_STRING, attrs);
			ch.startElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.HASHED_TOKEN, IXMLVocabulary.EMPTY_STRING, attrs);
			ch.characters(token.toCharArray(), 0, token.length());
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.HASHED_TOKEN, IXMLVocabulary.EMPTY_STRING);		
			ch.endElement(IXMLVocabulary.EMPTY_STRING, IXMLVocabulary.SECURE_DEVICE_DETAILS, IXMLVocabulary.EMPTY_STRING);
	    }	
    }
    
    public void restoreInternalInfo(final SAXContentHandler mainHandler, String uri,
    	    String localName, String qName, Attributes atts) throws SAXException {
	    if (!(localName.equals(IXMLVocabulary.DEVICE_DETAILS) || localName.equals(IXMLVocabulary.SECURE_DEVICE_DETAILS))) {
	        return;
	    }
	    mainHandler.navigate(new SAXContentHandler() {
	    	private StringBuffer curElemStr;
	        @Override
	        public void startElement(String uri, String localName,
	                String qName, Attributes atts) throws SAXException {
	        	curElemStr = new StringBuffer();
	        }
	    	
	        @Override
	        public void endElement(String uri, String localName, String qName)
	                throws SAXException {
	            if (localName.equals(IXMLVocabulary.HASHED_TOKEN)) {
	            	ManageDeviceConfig.this.setToken(curElemStr.toString());
	            } else if (localName.equals(IXMLVocabulary.VENDOR)) {
	            	ManageDeviceConfig.this.setVendor(curElemStr.toString());
	            } else if (localName.equals(IXMLVocabulary.MODEL)) {
	            	ManageDeviceConfig.this.setModel(curElemStr.toString());
	            } else if (localName.equals(IXMLVocabulary.HARDWARE_VERSION)) {
	            	ManageDeviceConfig.this.setHardwareVersion(curElemStr.toString());
	            }
	        }
	        
	        @Override
	        public void characters(char ch[], int start, int length)
	        	    throws SAXException {
	        	        if (curElemStr != null) {
	        	            for (int i = start; i < start + length; i++) {
	        	                switch (ch[i]) {
	        	                    case '\\':
	        	                    case '"':
	        	                    case '\n':
	        	                    case '\r':
	        	                    case '\t':
	        	                        break;
	        	                    default:
	        	                        curElemStr.append(ch[i]);
	        	                        break;
	        	                }
	        	            }
	        	        }
	        	    }

	    }, uri, localName, qName, atts);
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}
	
	@Override
	public boolean equals(Object manageDevice) {
		if(manageDevice instanceof ManageDeviceConfig) {
			ManageDeviceConfig manageDeviceCfg = (ManageDeviceConfig) manageDevice;
			if((this.pk.getId() == manageDeviceCfg.pk.getId())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 23;
		hash += hash * 23 + this.pk.getId();
		hash += hash * 4 + name.length(); 
		hash += hash * 7 + applicationType.getOrdinal();
		hash += hash * 9 + 	description.length();	
		hash += hash * 9 + 	ipAddress.length();
		hash += hash * 4 + 	port;
		hash += hash * 9 + 	status.length();
		hash += hash * 4 + 	vendor.length();
		hash += hash * 9 + 	description.length();
		hash += hash * 3 + 	model.length();
		hash += hash * 9 + 	hardwareVersion.length();
		
		return hash;
	}

	@Override
	public int compareTo(ManageDeviceConfig manageDeviceCfg) {
		return (this.pk.getId() - manageDeviceCfg.pk.getId()); 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
