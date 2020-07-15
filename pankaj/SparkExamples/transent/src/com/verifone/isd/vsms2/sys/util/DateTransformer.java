package com.verifone.isd.vsms2.sys.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Utility class to convert Date to ISO date string and vice-versa.
 *  The iso date format used is:
 *  <pre>
 *      YYYY-MM-DDThh:mm:ssTZD (eg 1999-07-10T09:45:20+01:00 and 2001-07-18T17:32:00-04:00)
 *  </pre>
 *  Reference: http://www.w3.org/TR/NOTE-datetime-970915.html
 * @see java.util.Date
 * @see java.util.Calendar
 *  @version 1.0
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 */

public class DateTransformer {
    /**
     * ISO Date format string that Sapphire uses in xml communication
     * with external entities
     * YYYY-MM-DDTHH:mm:ss(+/-)HH:mm
     */
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_SEPARATOR = "T";
	private static final String RECENT_OFFLINE = "RECENT";
	private static final String MSG_SEPERATOR = "-";
	public static final SimpleDateFormat SDF=new SimpleDateFormat(ISO_DATE_FORMAT);
   
    // Allow concurrent access to this variable
    private static final String DAY = "E ";
    private SimpleDateFormat isoDateFormat;
    
    // Static variables to keep various Date patterns based on Locale
    private static String LOCALE_DATE_DISPLAY_SHORT_2_CHAR_FORMAT = "";
    private static String LOCALE_TIME_MEDIUM_2_CHAR_FORMAT = "";
    private static String LOCALE_TIME_SHORT_2_CHAR_FORMAT = "";
    private static String LOCALE_TIME_MEDIUM_24_HOUR_2_CHAR_FORMAT = "";
    private static String LOCALE_DATE_SHORT_FORMAT = "";
    private static String LOCALE_DATE_SHORT_FORMAT_WITH_DAY = "";
    private static String LOCALE_DATE_SHORT_2_CHAR_FORMAT = "";
    private static String LOCALE_DATE_TIME_DEFAULT_FORMAT = "";
    private static String LOCALE_DATE_TIME_SHORT_FORMAT = "";
    private static DateFormat[] dateFormats = { new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"), 
    										new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX"), 
    										new SimpleDateFormat(ISO_DATE_FORMAT)};				
	private static Logger logger
	= LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.DateTransformer.class);
    
    static{
    	populateDefaultDateTimePatterns();
    }

	/**
	 * static method to populate default patterns based on system Locale.
	 * This method can be later invoked if we change the Locale from config client/other means
	 */
    public static void populateDefaultDateTimePatterns() {    	
    	Locale locale = Locale.getDefault();
    	DateFormat formattedDate = DateFormat.getDateInstance(DateFormat.SHORT ,locale);
    	SimpleDateFormat sdf = (SimpleDateFormat) formattedDate;
    	
    	LOCALE_DATE_SHORT_FORMAT = sdf.toPattern();
    	LOCALE_DATE_SHORT_FORMAT_WITH_DAY = DAY+LOCALE_DATE_SHORT_FORMAT;
    	LOCALE_DATE_SHORT_2_CHAR_FORMAT = getDatePattern(LOCALE_DATE_SHORT_FORMAT);
    	LOCALE_DATE_DISPLAY_SHORT_2_CHAR_FORMAT = getDatePattern(sdf.toLocalizedPattern()).toUpperCase();
    	DateFormat formattedTime = DateFormat.getTimeInstance(DateFormat.MEDIUM ,locale);
    	sdf = (SimpleDateFormat) formattedTime;
    	LOCALE_TIME_MEDIUM_2_CHAR_FORMAT = getTimePattern(sdf.toPattern());
    	LOCALE_TIME_MEDIUM_24_HOUR_2_CHAR_FORMAT = get24HourFormat(LOCALE_TIME_MEDIUM_2_CHAR_FORMAT);
    	
    	formattedTime = DateFormat.getTimeInstance(DateFormat.SHORT ,locale);
    	sdf = (SimpleDateFormat) formattedTime;
    	LOCALE_TIME_SHORT_2_CHAR_FORMAT = get24HourFormatPattern(getTimePattern(sdf.toPattern()));
    	
    	DateFormat formattedDateTime = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.SHORT, locale);
    	sdf = (SimpleDateFormat) formattedDateTime;
    	LOCALE_DATE_TIME_DEFAULT_FORMAT = sdf.toPattern();
    	
    	formattedDateTime = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
    	sdf = (SimpleDateFormat) formattedDateTime;
    	LOCALE_DATE_TIME_SHORT_FORMAT = sdf.toPattern();
	}
  
    public enum HourFormat{
    	_12HOUR,
    	_24HOUR
    }
    
    
    /**
     * Getter method to get Date in SHORT Format 
     * (for e.g. 	MM/DD/YY for US 
     * 				DD/MM/YY for Mexico)
     * @return String
     */
    public static String getLOCALE_DATE_DISPLAY_SHORT_2_CHAR_FORMAT() {
		return LOCALE_DATE_DISPLAY_SHORT_2_CHAR_FORMAT;
	}

    /**
     * Getter method to get Time in MEDIUM Format 
     * (for e.g. 	HH:MM:SS for US)
     * @return String
     */
	public static String getLOCALE_TIME_MEDIUM_2_CHAR_FORMAT() {
		return LOCALE_TIME_MEDIUM_2_CHAR_FORMAT;
	}
	/**
     * Getter method to get Time in SHORT Format 
     * (for e.g. 	HH:MM for US)
     * @return String
     */
	public static String getLOCALE_TIME_SHORT_2_CHAR_FORMAT() {
		return LOCALE_TIME_SHORT_2_CHAR_FORMAT;
	}

	/**
     * Getter method to get Date in SHORT Format 
     * (for e.g. 	M/d/YY for US 
     * 				d/MM/YY for Mexico)
     * @return String
     */
	public static String getLOCALE_DATE_SHORT_FORMAT() {
		return LOCALE_DATE_SHORT_FORMAT;
	}
	
	/**
	 * Getter method to get Date in SHORT Format 
	 * for e.g. 	E M/d/YY for US 
	 * @return
	 */
	public static String getLOCALE_DATE_SHORT_FORMAT_WITH_DAY() {
		return LOCALE_DATE_SHORT_FORMAT_WITH_DAY;
	}

	/**
     * Getter method to get Date in SHORT Format 
     * (for e.g. 	MM/dd/YY for US 
     * 				dd/MM/YY for Mexico)
     * @return String
     */
	public static String getLOCALE_DATE_SHORT_2_CHAR_FORMAT() {
		return LOCALE_DATE_SHORT_2_CHAR_FORMAT;
	}
	/**
     * Getter method to get Date and Time in DEFAULT Format 
     * Date in MEDIUM, Time in SHORT  for US
     * @return String
     */
	public static String getLOCALE_DATE_TIME_DEFAULT_FORMAT() {
		return LOCALE_DATE_TIME_DEFAULT_FORMAT;
	}

	/**
     * Getter method to get Time in 24 HOUR hh:mm:ss Format 
     * @return String
     */
	public static String getLOCALE_TIME_MEDIUM_24_HOUR_2_CHAR_FORMAT() {
		return LOCALE_TIME_MEDIUM_24_HOUR_2_CHAR_FORMAT;
	}

	
	/**
     * Getter method to get Date and Time in SHORT Format 
     * @return String
     */
	public static String getLOCALE_DATE_TIME_SHORT_FORMAT() {
		return LOCALE_DATE_TIME_SHORT_FORMAT;
	}

	/**
     * No-args constructor
     */
    public DateTransformer() {
        this. isoDateFormat= new SimpleDateFormat(ISO_DATE_FORMAT);
    }
    
    /**
     *  convert Date to ISO format.
     * @param date the date object to be converted to ISO format
     * @return ISO formatted date
     */
    public String transformToISODate(Date date) {
        Calendar tmpCal = Calendar.getInstance();
        tmpCal.setTime(date);
        int zoneOffsetHr = (tmpCal.get(Calendar.ZONE_OFFSET) + tmpCal.get(Calendar.DST_OFFSET))/(60*60*1000);
        int absHr = Math.abs(zoneOffsetHr);
        String zoneOffSetSign = (zoneOffsetHr < 0)? "-" : "+";
        String zoneOffsetHrStr =  (absHr < 10) ? "0" +absHr : Integer.toString(absHr);
        
        int zoneOffsetMin = (Math.abs(tmpCal.get(Calendar.ZONE_OFFSET) + tmpCal.get(Calendar.DST_OFFSET)))%(60*1000);
        String zoneOffsetMinStr = ((zoneOffsetMin < 10) ? "0" +zoneOffsetMin : Integer.toString(zoneOffsetMin));
        
        String ISODate = isoDateFormat.format(date)
        +zoneOffSetSign +zoneOffsetHrStr +":" +zoneOffsetMinStr;
        return ISODate;
    }
    
    /**
     * @param date
     * @return
     * @throws ParseException
     */
    public int transformToISODayofWeek(Date date) {
    	if(date!=null) {
    		Calendar tmpCal = Calendar.getInstance();
    		tmpCal.setTime(date);
    		return tmpCal.get(Calendar.DAY_OF_WEEK);
    	}else 
    		return 0;
    }
    
    /**
     * convert Date to ISO format.  The time zone offset is passed
     * so that daylight savings can be specified in the ISO date
     * string.
     * @param dstMethod daylight savings method
     * @param tzOffMin time zone offset, given as minutes west of Greenwich (values for North America are positive)
     * @param date the date object to be converted to ISO format
     * @return ISO formatted date
     */
    public String transformToISODate(String dstMethod, int tzOffMin, Date date) {
        boolean dstApplies = !dstMethod.equals("0");
        int tzMillis = tzOffMin *60 *1000;
        String[] timeZones = TimeZone.getAvailableIDs(tzMillis);
        TimeZone corTZ = null;
        for (int i = 0; i < timeZones.length; i++) {
            TimeZone tmpTZ = TimeZone.getTimeZone(timeZones[i]);
            if (tmpTZ.getRawOffset() == tzMillis) {
                corTZ = tmpTZ;
                if (tmpTZ.useDaylightTime() == dstApplies)
                    break;
            }
        }
        return this.transformToISODate(corTZ, date);
    }
    
    public String transformToISODate(TimeZone corTZ, Date date) {    
        String zoneStr = "+00:00";
        if (corTZ != null) {
            int tzOffMinWithDS = corTZ.getRawOffset()/60000;
            if (corTZ.inDaylightTime(date)) {
                tzOffMinWithDS += 60;
            }
            int zoneOffsetHr = tzOffMinWithDS/60;
            int absHr = Math.abs(zoneOffsetHr);
            String zoneOffSetSign = (zoneOffsetHr < 0)? "-" : "+";
            String zoneOffsetHrStr =  (absHr < 10) ? "0" +absHr : Integer.toString(absHr);
            
            int zoneOffsetMin = Math.abs(tzOffMinWithDS)%60;
            String zoneOffsetMinStr = ((zoneOffsetMin < 10) ? "0" +zoneOffsetMin : Integer.toString(zoneOffsetMin));
            zoneStr = zoneOffSetSign +zoneOffsetHrStr +":" +zoneOffsetMinStr;
        }
        String ISODate = isoDateFormat.format(date) +zoneStr;
        return ISODate;
    }
    
    /*
     * Lenient also considers real dates that exist (i.e. Feb 35th is bogus)
     * @param isoDate the date object to be parsed
     * @exception ParseException on error in parsing the date string
     * @return date object created from the ISO format date string
     */
    public Date transformISODateStringToDateLenient(String isoDate) 
    throws ParseException {
    	SimpleDateFormat sdf = isoDateFormat;
		sdf.setLenient(false);
		return sdf.parse(isoDate);
    }
    
    /**
     *  convert ISO format date string to Date. Time zone setting (& offset) are ignored currently.
     * @param isoDate the date object to be parsed
     * @exception ParseException on error in parsing the date string
     * @return date object created from the ISO format date string
     */
    public Date transformISODateStringToDate(String isoDate)
    throws ParseException {
        return isoDateFormat.parse(isoDate);
    }
    
    
    /**
     *  convert ISO format date string to Date and Time. 
     * @param isoDate the date object to be parsed as date and time
     * @return ISODateTime object created from the ISO format date string
     */
    public ISODateTime transformISODateStringToDateTime(String isoDate)
			throws ParseException {
		ISODateTime dateTime = new ISODateTime();
		if (isoDate != null && !isoDate.equalsIgnoreCase("")
				&& !isoDate.equalsIgnoreCase("current")) {

			/* To confirm the pattern of the isoDate string */
			isoDateFormat.parse(isoDate);

			int id = isoDate.indexOf(DATE_SEPARATOR);
			if (id > 0) {
				dateTime.setDate(isoDate.substring(0, id));
				dateTime.setTime(isoDate.substring(id + 1, id + 1 + 8));
			}
		}
		return dateTime;
	}
    
    
    /**
     *  convert Date Object to Date and Time. 
     * @param date the date object to be parsed as date and time
     * @return ISODateTime object created from the ISO format date string
     * 
     * This method uses the internal methods of this class to convert the date object
     * to the isoDate formatted string and convert the isoFormatted string to the 
     * ISODateTiem Object.
     */
    public ISODateTime transformISODateStringToDateTime(Date date)
			throws ParseException {
    	String isoDate = this.transformToISODate(date);
    	return this.transformISODateStringToDateTime(isoDate);
	}
    
    /**
     *  convert ISODate String Object to Date. 
     * @param String isoDate the isoDate String to be parsed
     * @return Date (Including GMT)
     * 
     * This method converts the ISODate String to the GMT applied Date.
     * @throws ParseException 
     */
    public Date convertISODateStringToGMTime(String isoDate) throws ParseException
    {
    	SimpleDateFormat isoDateFormat= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	
    	/*To verify the pattern before start processing*/
    	isoDateFormat.parse(isoDate);
    	
    	StringBuffer formattedStr = new StringBuffer("GMT");
    	char id = isoDate.charAt(isoDate.length() - 6);
    	
    	/* The last representation of the isoDate string is GMT in the format of +/-HH:MM */
    	if (id == '+' || id == '-') {
    		formattedStr.append(isoDate.substring(isoDate.length()-6, isoDate.length()));
		} else {
			throw new ParseException("Exception while parsing the Date String", isoDate.length()-6);
		}
    	TimeZone tz = TimeZone.getTimeZone(formattedStr.toString());
    	isoDateFormat.setTimeZone(tz);
    	return isoDateFormat.parse(isoDate);
    }
    
    /***
     * Returns current date in XMLGregorianCalendar format
     * @return
     * @throws Exception
     * @author ManjunathaV1
     */
    public static XMLGregorianCalendar getCurrentDateAsXMLGregorianCalendar() throws Exception {
		return transformToXMLGregorianCalendar(Calendar.getInstance().getTime());
	}
    
    /***
     * Returns passed in java.util.Date in XMLGregorianCalendar format
     * @return
     * @throws Exception
     * @author ManjunathaV1
     */
    public static XMLGregorianCalendar transformToXMLGregorianCalendar(Date date) throws Exception {
		GregorianCalendar gregoCal = new GregorianCalendar();
		gregoCal.setTime(date);
		XMLGregorianCalendar xmlGregoCal = null;
		try {
			xmlGregoCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregoCal);
		} catch (DatatypeConfigurationException e) {
			throw new Exception("Error while creating XMLGregorianCalendar instance.");
		}
		return xmlGregoCal;
	}
    
    /***
     * Returns future date for passed in number of days
     * @param days
     * @return
     * @throws Exception In case of conversion failures
     * @author ManjunathaV1
     */
    public static XMLGregorianCalendar getFutureDateInXmlGregorianCalendar(int days) throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		XMLGregorianCalendar date = null;
		try{
			date = transformToXMLGregorianCalendar(calendar.getTime());
		}catch(Exception ex){
			throw new Exception("Error while creating XMLGregorianCalendar instance.");
		}
		return date;
	}
   
	/**
	 * API to format Date and Time based on default Locale and Date in SHORT Style, Time in MEDIUM style 
	 * @param date
	 * @return
	 */
    public static String formatDateTime(Date date) {
		Locale locale = Locale.getDefault();
		DateFormat formattedDate = DateFormat.getDateTimeInstance(
				DateFormat.SHORT, DateFormat.MEDIUM, locale);
		return formattedDate.format(date);
	}
    
    /**
	 * API to format Date and Time based on Locale provided
	 * @param date
     * @param dateStyle - DEFAULT/SHORT(3)/MEDIUM(2)/LONG(1)/FULL(0)
     * @param timeStyle	- DEFAULT/SHORT/MEDIUM/LONG/FULL
     * @param hourFormat - 	true  :24 hour format 
	 * 						- 	false :12 hour format
     * @return formatted Date and Time based on Locale
	 */
    public static String formatDateTimeByStyle(Date date, int dateStyle,
			int timeStyle, HourFormat hourFormat) {
		String dateString = "";
		Locale locale = Locale.getDefault();
		DateFormat formattedDate = DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
		if (hourFormat==HourFormat._24HOUR) {
			dateString = new SimpleDateFormat(get24HourTimePattern(formattedDate), locale).format(date);
		} else {
			dateString = formattedDate.format(date);
		}
		return dateString.trim();
	}
    
	/**
	 * API to format Date based on default Locale and in SHORT style
	 * @param date
	 * @return formatted Date String
	 */
    public static String formatDate(Date date){
    	Locale locale = Locale.getDefault();
    	DateFormat formattedDate = DateFormat.getDateInstance(DateFormat.SHORT ,locale);
    	return formattedDate.format(date);
    }
    /**
     * API to format Date based on Locale
     * @param date
     * @param dateStyle	- DEFAULT/SHORT(3)/MEDIUM(2)/LONG(1)/FULL(0)
     * @return formatted Date based on Locale
     */
    public static String formatDateByStyle(Date date,int dateStyle,boolean skipYear){
    	String dateString="";
    	Locale locale = Locale.getDefault();
    	DateFormat formattedDate = DateFormat.getDateInstance(dateStyle ,locale);
    	if(skipYear){
    		SimpleDateFormat sdf = (SimpleDateFormat)formattedDate;
    		// Pattern will remove year from the Date String
    		 sdf.applyPattern(sdf.toPattern().replaceAll(
    			       "([^\\p{Alpha}']|('[\\p{Alpha}]+'))*y+([^\\p{Alpha}']|('[\\p{Alpha}]+'))*",
    			       ""));
    		 dateString = sdf.format(date);
    	}
    	else{
    		dateString = formattedDate.format(date);
    	}
    	return dateString;
    }
    
	/**
	 * API to format Time based on default Locale and Medium Format
	 * @param date
	 * @return
	 */
    public static String formatTime(Date date){
    	Locale locale = Locale.getDefault();
    	DateFormat formattedDate = DateFormat.getTimeInstance(DateFormat.MEDIUM ,locale);
    	return formattedDate.format(date);
    }
    
    /**
     *  API to format Time based on Locale
     * @param date
     * @param timeStyle
     * @param hourFormat	- 	true  :24 hour format 
	 * 						- 	false :12 hour format
     * @return formatted Time based on Locale
     */
    public static String formatTimeByStyle(Date date,int timeStyle,HourFormat hourFormat){
    	String timeString="";
    	Locale locale = Locale.getDefault();
    	DateFormat formattedDate = DateFormat.getTimeInstance(timeStyle ,locale);
    	if(hourFormat==HourFormat._24HOUR){
    		timeString = new SimpleDateFormat(get24HourTimePattern(formattedDate), locale).format(date);
    	}
    	else{
    		timeString = formattedDate.format(date);
    	}
    	return timeString.trim();
    }
    
    /**
     * API to get Date String by applying patterns
     * @param date
     * @param pattern
     * @return Formatted Date String
     */
    public static String getDateStringByPattern(Date date,String pattern){
    	SimpleDateFormat sdf = new SimpleDateFormat();
    	sdf.applyPattern(pattern);
    	return sdf.format(date);
    }
    
    private static String get24HourTimePattern(DateFormat formattedDate){
    	SimpleDateFormat sdf = (SimpleDateFormat) formattedDate;
		String pattern = sdf.toPattern();
		return get24HourFormat(pattern);
    }

	private static String get24HourFormat(String pattern) {
		final String _12_HOUR_PATTERN ="h";
		final String _24_HOUR_PATTERN ="H";
		//replace pattern from 'h' to 'H' for 24 hour format
		pattern = pattern.replaceAll(_12_HOUR_PATTERN, _24_HOUR_PATTERN);
		pattern = get24HourFormatPattern(pattern);
		return pattern;
	}
    private static String get24HourFormatPattern(String pattern){
		final String AM_PM_STR = "a";
		final int ZERO_INDEX = 0;
		int index = pattern.indexOf(AM_PM_STR);
		if (index != -1) {
			if (index > ZERO_INDEX) {
				// replace character if am/pm character on right
				pattern = pattern.substring(ZERO_INDEX, index);
			} else {
				// replace character if am/pm character on left
				pattern = pattern.substring(ZERO_INDEX + 1, pattern.length());
			}
		}
		return pattern;
	}
    
    /**
     * Replace single character in the pattern to double character
     * @param pattern
     * @return
     */
    private static String getDatePattern(String pattern){ 
    	//possible characters in Date pattern(includes localised strings)
    	char ch[] = { 'd', 'M', 'y', 'u', 'n', 'j', 't' };
		pattern = get_2_Char_DateTimeString(pattern, ch);
		return pattern.trim();
    }
    private static String getTimePattern(String pattern){
    	//possible characters in Time pattern
    	char ch[] =  {'H','h','m','s'};
		pattern = get_2_Char_DateTimeString(pattern, ch);
		return pattern.trim();
    }
    
   /**
    * Convert the pattern to return 2 character MM or dd or yy
    * If pattern is d/MM/yyyy , then convert to dd/MM/yy
    * pattern is M/d/yy , then convert to MM/dd/yy
    * @param pattern (for e.g d/M/yy)
    * @param character 
    * @return
    */
	private static String get_2_Char_DateTimeString(String pattern, char[] chars) {
		char tempCh;
		for (char ch : chars) {
			int count = 0;
			int index = 0;
			pattern += ' ';
			StringBuilder newString = new StringBuilder();
			if (pattern.indexOf(ch) != -1) {
				// character present
				for (index = 0; index < pattern.length(); index++) {
					tempCh = pattern.charAt(index);
					if (Character.isLetter(tempCh)) {
						if (tempCh == ch) {
							count++;
						}
					} else if (count > 0) {
						newString.append(ch);
						break;
					}
					if (count < 2)
						newString.append(tempCh);
				}
				newString.append(pattern.substring(index, pattern.length()));
			} else {
				newString.append(pattern);
			}
			pattern = newString.toString();
		}
		return pattern;
	}
	/**
	 * Method to split date String with word boundary
	 * For e.g dateStr = 12 April 2017 10:25:65 and width = 12,
	 *  return string will be "12 April 2017 \n10:25:65"
	 * @param dateStr
	 * @param width
	 * @return formattedString
	 */
	public static String displayDateWithWordBoundary(String dateStr,int width){
		final String SPACE = " ";
		final String SEPARATOR = SPACE+System.getProperty("line.separator")+SPACE;
		String[] dateSplit = StringSplitter.splitAtWordBoundary(dateStr, width);
		StringBuilder builder = new StringBuilder();
        for (String str : dateSplit) {
               builder.append(str);
               builder.append(SEPARATOR);
        }
        return builder.toString();
	}
	
	/**
	 * Method to validate Date/Time String against date/time pattern
	 *  
	 * @param dateStr
	 * @param format
	 * @return TRUE -  Valid Date/Time String
	 */
	public static boolean isValidDateTimeString(String dateStr,String format){
		Date date = null;
    	try {
    	    SimpleDateFormat sdf = new SimpleDateFormat(format);
    	    date = sdf.parse(dateStr);
    	    if (!dateStr.equals(sdf.format(date))) {
    	        date = null;
    	    }
    	} catch (ParseException pe) {
    		logger.error("Exception while parsing DateTimeString ",pe);
    	}
    	return date != null;
	}
	
	/**
	 * API to parse various ISO date format
	 * Supported formats
	 * 2018-01-26T15:43:50+05:00
	 * 2018-01-26T15:43:50Z
	 * 2018-01-26T15:43:50
	 * for non supported format, API will return current date.
	 * @param time
	 * @return Date
	 */
	public static Date getDateTime(String time) {
		Date date = null;
		for (DateFormat format : dateFormats) {
			if ((date = format.parse(time, new ParsePosition(0))) != null) {
				break;
			}
		}
		if (date == null) {
			// if date is null, set current date instead of throwing error
			date = new Date();
		}
		return date;
	}

	public static Date parseDate(String date) throws ParseException {
		return null != date && !date.isEmpty() ? SDF.parse(date) : null;

	}

	/***
	 * This API calculates the time elapsed between the given time and current
	 * time in DAYS,HOURS,MINUTES and SECONDS
	 *
	 * @param lastDateSeenOffline
	 *            last time it went offline.
	 *
	 **/
	public static String calculateElapsedTime(Date from) {

		Date lastOffline = from;
		String msg = "";		
		long timeDifference = System.currentTimeMillis() - lastOffline.getTime();

		long days = TimeUnit.MILLISECONDS.toDays(timeDifference);
		long hours = TimeUnit.MILLISECONDS.toHours(timeDifference);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifference);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(timeDifference);									
		if (days > 0) {
			msg = days + MSG_SEPERATOR + TimeUnit.DAYS;
		} else if (hours > 0) {
			msg = hours + MSG_SEPERATOR + TimeUnit.HOURS;
		} else if (minutes > 0) {
			msg = minutes + MSG_SEPERATOR + TimeUnit.MINUTES;
		} else if (seconds > 0) {
			msg = seconds + MSG_SEPERATOR + TimeUnit.SECONDS;
		} else {
			msg = RECENT_OFFLINE;
		}
					
		return msg;
	}
    
    /**
	 * Test method
	 * 
	 * @param args
	 *            parameters for the test
	 * @throws java.lang.Exception
	 *             on error in date/iso format or iso/ date conversion
	 */
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: DateFormat 0 -300 200107301205.20");
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm.ss");
            Date d = sdf.parse(args[2]);
            DateTransformer df = new DateTransformer();
            String ISODate = df.transformToISODate(args[0], Integer.parseInt(args[1]), d);
            System.out.println(ISODate);
            
        }
        //Expected output should be in { 2014-02-27T13:00:36.065+05:30 } format
        System.out.println("Xml calendar instance. " + getCurrentDateAsXMLGregorianCalendar());
    }
    
}