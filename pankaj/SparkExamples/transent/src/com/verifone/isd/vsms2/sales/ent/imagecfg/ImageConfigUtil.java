package com.verifone.isd.vsms2.sales.ent.imagecfg;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * This is an utility class for Image Upload operation  
 * 
 * @author MadhusudhanB1
 *
 */
public class ImageConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageConfigUtil.class);
	public static final String VISTA_ROOT_DIR_PROP = "vista.root.dir";
	public static final String VISTA_ROOT_DIR_DEFAULT_PATH = "/media/v950sc-drive/coresvcs/vista";
	public static final String VISTA_IMAGES_URL_PREFIX = "images/vista/uploaded/images";
	public static final String VISTA_IMAGES_COMMON_DIR = "/images";
	public static final String VISTA_DEFAULT_IMAGES_DIR = "htdocs/images/vista/";
	
    public static String getMIMEType(String base64Image) {
    	String contentType = null;
    	try {
	    	byte[] imageByte = Base64.getDecoder().decode(base64Image);
		   	ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		   	contentType = URLConnection.guessContentTypeFromStream(bis);
    	} catch (Exception e) {
    		LOGGER.error("Invalid content type", e);
    	}
    	return contentType;
    }

    public static String getBase64ImageString(ImageConfig imageConfig) {
    	String encodedString = null;
    	ImageConfigPK pk = (ImageConfigPK) imageConfig.getPK();
    	String filePath =  getDirectoryPath(imageConfig) + pk.getName() + "." + imageConfig.getFileExtention();
    	File file = new File(filePath);
    	byte [] byteArray = new byte[(int) file.length()];
    	try (FileInputStream fis = new FileInputStream(file)) {
	    	fis.read(byteArray);
	    	encodedString = Base64.getEncoder().encodeToString(byteArray);
    	} catch (IOException e) {
    		LOGGER.error("Error loading image file", e);
    	}
    	return encodedString;
    }
    
    public static String getDirectoryPath(ImageConfig imageConfig) {
    	String prefix = SysPropertyFactory.getProperty(VISTA_ROOT_DIR_PROP, VISTA_ROOT_DIR_DEFAULT_PATH);
    	ImageConfigPK pk = (ImageConfigPK) imageConfig.getPK();
    	String dirPath = null;
    	if(pk.getApplicationType() != null) {
    		dirPath = prefix + VISTA_IMAGES_COMMON_DIR + File.separator + pk.getApplicationType().getAppTypeStringType() + File.separator;
    	} else {
    		dirPath = prefix + VISTA_IMAGES_COMMON_DIR + File.separator;
    	}
    	
    	File file = new File(dirPath);
    	if(!file.exists()) {
    		file.mkdirs();
    	}
    	return dirPath;
    }

    public static String getFileExtension(ImageConfig imageConfig) {
    	String mimeType = ImageConfigUtil.getMIMEType(imageConfig.getBase64Image());
    	String extention = null;
    	if(mimeType != null) {
    		extention = mimeType.split("/")[1];
    	}
    	return extention;
    }
}
