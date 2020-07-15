/*
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 * 
 * Created Feb 2009                                     Jabbar
 *
 */
package com.verifone.isd.vsms2.sys.util;

import java.io.Serializable;

/**
 * This class holds a string and its formatting information.
 * This can be used to send formatted strings to Topaz for printing.
 * 
 * @author Jabbar
 */

public class FormattedLine implements Serializable {
	
	static final long serialVersionUID = 6207794868037862800L;

	public static final String CENTER = "Center";

	public static final String LEFT = "Left";

	public static final String RIGHT = "Right";

	public static final String NORMAL = "Normal";

	public static final String BOLD = "Bold";

	public static final String ITALIC = "Italic";

	public static final String UNDERLINED = "Underlined";
	
	public static final String DOUBLE = "Double";
	
	public static final String HALF = "Half";
	
	public static final String UPCA = "upcA";
	public static final String UPCE = "upcE";
	public static final String EAN13 = "ean13";
	public static final String EAN8 = "ean8";
	
	public static final String BOLDSTYLE = "boldStyle";
	
	public static final String ITALICSTYLE = "italicStyle"; 
	
	public static final String UNDERLINEDSTYLE = "underlinedStyle";
	
	private String line;

	private int column;

	private String Alignment;

	private String height;

	private String width;
	
	private String charStyle;
	
	private boolean boldStyle;
	
	private boolean italicStyle;
	
	private boolean underlinedStyle;

	private boolean paperCut;
	
	private String signatureData;	// to hold the signature
    
	private String signatureMimeType;    //to hold the signature mime type
	
	private boolean barcode;
	
	private String barcodeFormat;
	
	/**
	 * Returns the alignment to be performed on this line.
	 * 
	 * @return the alignment
	 */
	public String getAlignment() {
		return Alignment;
	}

	/**
	 * Sets the alignement.
	 * 
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		Alignment = alignment;
	}

	/**
	 * Returns the style of text to be rendered.
	 *  
	 * @return the charStyle
	 */
	public String getCharStyle() {
		return charStyle;
	}

	/**
	 * Sets the character style.
	 * 
	 * @param charStyle the charStyle to set
	 */
	public void setCharStyle(String charStyle) {
		this.charStyle = charStyle;
	}

	/**
	 * Returns the number of columns.
	 * 
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Sets the number of columns.
	 * 
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * Gets the height set for the characters in this line.
	 * 
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Sets the character height.
	 * 
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Returns the string line.
	 * 
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * Sets the line.
	 * 
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	/**
	 * Returns whether this is papercut.
	 *  
	 * @return the paperCut
	 */
	public boolean isPaperCut() {
		return paperCut;
	}

	/**
	 * Sets the paper cut.
	 * 
	 * @param paperCut the paperCut to set
	 */
	public void setPaperCut(boolean paperCut) {
		this.paperCut = paperCut;
	}

	/**
	 * Returns the width of each character.
	 * 
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Sets the width for the character.
	 * 
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the boldStyle
	 */
	public boolean isBoldStyle() {
		return boldStyle;
	}

	/**
	 * @param boldStyle the boldStyle to set
	 */
	public void setBoldStyle(boolean boldStyle) {
		this.boldStyle = boldStyle;
	}

	/**
	 * @return the italicStyle
	 */
	public boolean isItalicStyle() {
		return italicStyle;
	}

	/**
	 * @param italicStyle the italicStyle to set
	 */
	public void setItalicStyle(boolean italicStyle) {
		this.italicStyle = italicStyle;
	}

	/**
	 * @return the underlinedStyle
	 */
	public boolean isUnderlinedStyle() {
		return underlinedStyle;
	}

	/**
	 * @param underlinedStyle the underlinedStyle to set
	 */
	public void setUnderlinedStyle(boolean underlinedStyle) {
		this.underlinedStyle = underlinedStyle;
	}

	/**
	 * 
	 * @return true if this line is to be printed as a barcode
	 */
	public boolean isBarcode() {
		return barcode;
	}

	/**
	 * 
	 * @param barcode
	 *            if this line is to be printed as a barcode
	 */
	public void setBarcode(boolean barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the barcodeFormat
	 */
	public String getBarcodeFormat() {
		return barcodeFormat;
	}

	/**
	 * @param barcodeFormat the barcodeFormat to set
	 */
	public void setBarcodeFormat(String barcodeFormat) {
		this.barcodeFormat = barcodeFormat;
	}
	/**
     * @return Returns the signatureData.
     */
    public String getSignatureData() {
    	return signatureData;
    }
    /**
     * @param signatureData The signatureData to set.
     */
    public void setSignatureData(String signatureData) {
    	this.signatureData = signatureData;
    }
    /**
     * @return Returns the signatureMimeType.
     */
    public String getSignatureMimeType() {
    	return signatureMimeType;
    }
    /**
     * @param signatureMimeType The signatureMimeType to set.
     */
    public void setSignatureMimeType(String signatureMimeType) {
    	this.signatureMimeType = signatureMimeType;
    }
}
