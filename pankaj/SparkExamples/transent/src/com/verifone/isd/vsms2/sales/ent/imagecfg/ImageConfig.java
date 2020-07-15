package com.verifone.isd.vsms2.sales.ent.imagecfg;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class ImageConfig implements IEntityObject, ISalesEntityVisitable {
	
	private static final long serialVersionUID = -2910756043435247755L;
	private ImageConfigPK pk;
	private String fileExtention;
	private String base64Image;
	public static int IMAGE_NAME_MAX_LENGTH = 40;
	public static int RESOLUTION_HEIGHT = 480;
	public static int RESOLUTION_WIDTH = 854;  
	public static int IMAGE_SIZE = 300 * 1024;
	private static List<String> mimeTypesAllowed = new ArrayList<>(Arrays.asList("image/png", "image/jpeg", "image/jpg"));
	
	public ImageConfig() {
	}
	
	public ImageConfig(ImageConfigPK pk) {
		this.pk = pk;
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (ImageConfigPK) pk;		
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		ImageConfig imageConfig = (ImageConfig) obj;
		imageConfig.setPK(this.pk);
		imageConfig.setBase64Image(this.base64Image);
		imageConfig.setFileExtention(this.fileExtention);
	}

	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid image name - " + this.pk.getName());
		}
		
		ImageDetails imageDetails = new ImageDetails(base64Image);
		BufferedImage image = imageDetails.getImage();
		if(image.getHeight() <= 0 || image.getHeight() > RESOLUTION_HEIGHT 
				|| image.getWidth() <= 0 || image.getWidth() > RESOLUTION_WIDTH) {
			throw new Exception("Image resolution cannot exceed, height : " + RESOLUTION_HEIGHT + " width : " + RESOLUTION_WIDTH);
		}
		if(imageDetails.getSize() <= 0 || imageDetails.getSize() > IMAGE_SIZE) {
			throw new Exception("Image size cannot exceed more than 300KB : " + pk.getName());
		}
		
		if(imageDetails.getMimeType() == null || !mimeTypesAllowed.contains(imageDetails.getMimeType())) {
			throw new Exception("Image type is not valid : " + pk.getName());
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getFileExtention() {
		return fileExtention;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}
}
