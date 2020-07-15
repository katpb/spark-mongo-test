package com.verifone.isd.vsms2.sales.ent.imagecfg;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class holds image details
 * 
 * @author MadhusudhanB1
 *
 */
public class ImageDetails {
	private final Logger logger = LoggerFactory.getLogger(ImageDetails.class);
	private BufferedImage image;
	private int size;
	private String mimeType;
	
	public ImageDetails(String base64Image) throws Exception {
		ByteArrayInputStream bis = null;
    	try {
	    	byte[] imageByte = Base64.getDecoder().decode(base64Image);
		   	bis = new ByteArrayInputStream(imageByte);
		   	mimeType = URLConnection.guessContentTypeFromStream(bis);
    		image = ImageIO.read(bis);
		   	size = imageByte.length;
		   	
    	} catch (IllegalArgumentException | IOException e) {
    		logger.error("Image file is not valid", e);
    		throw new Exception("Image file is not valid");
    	} finally {
    		if(bis != null) {
    			bis.close();
    		}
    	}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public int getSize() {
		return size;
	}

	public String getMimeType() {
		return mimeType;
	}
}
