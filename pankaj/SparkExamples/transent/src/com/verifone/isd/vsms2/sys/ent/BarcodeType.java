package com.verifone.isd.vsms2.sys.ent;

import java.io.Serializable;

public class BarcodeType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1336421186058484509L;

	public static enum BARCODE_FORMAT{
		UPC_A("upcA"), 
		UPC_E("upcE"), 
		EAN_8("ean8"), 
		EAN_13("ean13"), 
		QR_CODE("qrCode"), 
		CODE_128("code128"), 
		PDF_417("PDF417"), 
		GS_1_128("GS1-128");

		private final String value;

		private BARCODE_FORMAT(String format) {
			this.value = format;
		}

		public String value() {
			return this.value;
		}
		
		/**
		 * Returns the BARCODE_FORMAT enum corresponding
		 * to the string passed.
		 * @param arg : String value
		 * @return : BARCODE_FORMAT 
		 * @throws IllegalArgumentException if the passed string doesn't match with any
		 * value in teh enum.
		 */
		public static BARCODE_FORMAT fromValue(String arg) {
			
			for(BARCODE_FORMAT format : BARCODE_FORMAT.values()) {
				if(format.value().equals(arg)) {
					return format;
				}
				
			}
			throw new IllegalArgumentException(arg);
		}
	}
	protected BARCODE_FORMAT format;
	protected String data;

	public BARCODE_FORMAT getFormat() {
		return this.format;
	}

	public void setFormat(BARCODE_FORMAT format) {
		this.format = format;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
