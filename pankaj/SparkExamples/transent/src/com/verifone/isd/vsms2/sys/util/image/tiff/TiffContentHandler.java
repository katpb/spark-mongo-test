package com.verifone.isd.vsms2.sys.util.image.tiff;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

public class TiffContentHandler extends ContentHandler {
	Tiff tiffImage;

	//returns an array of Image	
	public Object getContent (URLConnection uc) {
		
		tiffImage = new Tiff(); 

		try {		
			tiffImage.readInputStream( uc.getInputStream() );
		}
		catch (IOException e) {};

		return tiffImage.getImageProducer(0);
	}

/*	
	public Object getImageProducer( int page ) {
		return tiffImage.getImageProducer(page);
	}
*/

	public String toString() {
		return tiffImage.toString(); 
	}		
}