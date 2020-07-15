package com.verifone.isd.vsms2.sys.util;

import java.util.Calendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This class provides utility methods for conversion of calendar objects. 
 */
public class CalendarUtil {

	/**
	 * Method to convert Calendar object to XMLGregorianCalendar object.
	 *  
	 * @param now
	 * @return
	 */
	public static XMLGregorianCalendar toXMLCalendar(Calendar now) {
		XMLGregorianCalendar xmlCal = null;
		if (now == null) {
			return null;
		}
		try {
			xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e) {
		}
		xmlCal.setDay(now.get(Calendar.DAY_OF_MONTH));
		/* We do a +1 below because XMLGregorianCalendar goes from 1 to 12 */
		xmlCal.setMonth(now.get(Calendar.MONTH)+1);
		xmlCal.setYear(now.get(Calendar.YEAR));
		xmlCal.setTime(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), 
					now.get(Calendar.SECOND));
		xmlCal.setTimezone(now.getTimeZone().getRawOffset()  / (60 * 1000));
		return xmlCal;				
	}
	
	/**
	 * Method to convert XMLGregorianCalendar object to Calendar object.
	 * 
	 * @param now
	 * @return
	 */
	public static Calendar toCalendar(XMLGregorianCalendar now) {
		Calendar cal = null;
		if (now == null) {
			return null;
		}
		cal = Calendar.getInstance();
		/* We do a -1 below because XMLGregorianCalendar goes from 1 to 12 */		
		cal.set(now.getYear(), now.getMonth() - 1, now.getDay(), 
				now.getHour(), now.getMinute(), now.getSecond());
		cal.setTimeZone(now.getTimeZone(0));
		return cal;
	}
}
