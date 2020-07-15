package com.verifone.isd.vsms2.sys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*** ClassName : ISODateTime
 * 
 * @author Ravi_G1
 *
 * Used as the wrapper class for Date and Time values from the ISO String.
 */

public class ISODateTime {
	
	public ISODateTime()
	{
		
	}

	private String date;
	private String time;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * @return boolean value isValid
	 */	
	public boolean isValid() {
		boolean valid = false;
		if (this.date != null && this.time != null
				&& !this.date.equalsIgnoreCase("")
				&& !this.time.equalsIgnoreCase("")) {
			/* To confirm the pattern of the isoDate string */
			String isoDate = this.date + DateTransformer.DATE_SEPARATOR + this.time;
			SimpleDateFormat isoDateFormat = new SimpleDateFormat(DateTransformer.ISO_DATE_FORMAT);
			isoDateFormat.setLenient(false);
			try {
				isoDateFormat.parse(isoDate);
				valid = true;
			} catch (ParseException e) {
				valid = false;
			}
		}
		return valid;
	}
}
