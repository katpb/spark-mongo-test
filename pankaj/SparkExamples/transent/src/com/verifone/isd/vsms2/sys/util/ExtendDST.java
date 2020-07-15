package com.verifone.isd.vsms2.sys.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendDST
{
        private Logger logger = LoggerFactory.getLogger(ExtendDST.class);    
        private static int dstStartMonth, dstEndMonth;
        private static int dstStartDayOfWeek, dstEndDayOfWeek;
        private static int dstStartDayOfWeekInMonth, dstEndDayOfWeekInMonth;
        private static int dstStartHour, dstEndHour;
        private static int currentYear;
        private static final int ONE_HR = 1 * 60 * 60 * 1000;
        private static long dstStartEndTime[] = new long[2];
        
        static {
            try {
                // Get DST specific properties to set DST rules in a generic manner.                
                // Default rule is US extended DST 
                // DST start: second sunday in March at 2.00 AM
                // DST end: first sunday in November at 2.00 AM
                if (TimeZone.getDefault().useDaylightTime()) {
                    dstStartMonth = Integer.parseInt(SysPropertyFactory.getProperty("dst.start.month", String.valueOf(Calendar.MARCH)));
                    dstEndMonth = Integer.parseInt(SysPropertyFactory.getProperty("dst.end.month", String.valueOf(Calendar.NOVEMBER)));
                    dstStartDayOfWeek = Integer.parseInt(SysPropertyFactory.getProperty("dst.start.dayOfWeek", String.valueOf(Calendar.SUNDAY)));
                    dstEndDayOfWeek = Integer.parseInt(SysPropertyFactory.getProperty("dst.end.dayOfWeek", String.valueOf(Calendar.SUNDAY)));
                    dstStartDayOfWeekInMonth = Integer.parseInt(SysPropertyFactory.getProperty("dst.start.dayOfWeekInMonth", String.valueOf(2)));
                    dstEndDayOfWeekInMonth = Integer.parseInt(SysPropertyFactory.getProperty("dst.end.dayOfWeekInMonth", String.valueOf(1)));                
                    dstStartHour = Integer.parseInt(SysPropertyFactory.getProperty("dst.start.hour", String.valueOf(2)));
                    dstEndHour = Integer.parseInt(SysPropertyFactory.getProperty("dst.end.hour", String.valueOf(2)));                                                        
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
	/* Main entry point for running another application from the
	 * command line.  This allows running arbitrary applications that
	 * have not been taught about the new rules for DST.
	 *
	 * Whatever Exceptions that application throws, we will as well.
	 */
	public static void main(String args[]) throws Exception
	{
		// If our default it the old US Rules, change to the new ones
		setExtendedDSTRules();

		// Now, use the remainder of the line to run the Java application
		// that is would have been used otherwise.

		int argc = args.length;
		if (argc == 0)
		{
			System.err.println("Usage: javavm <vmargs> FixTz <user-main-class> <main-class-args>");
			throw new Exception("ExtendDST: Argument Exception, no Java program to run.");
		}
		Class origAppClass = Class.forName(args[0]);
		Class argsClass[] = new Class[1];
		argsClass[0] = args.getClass();
		Method appMain = origAppClass.getDeclaredMethod("main", argsClass);
		int appArgc = argc - 1;
		String appArgs[] = new String[appArgc];
		System.arraycopy(args, 1, appArgs, 0, appArgc);
		Object appArgsObj[] = new Object[1];
		appArgsObj[0] = appArgs;
		appMain.invoke(null, appArgsObj);
	}

	/** setExtendedDSTRules()
         *  Assign DST rules in a generic manner by reading properties instead of hardcoding to US Extended DST.
         *  Properties are defaulted to US Extended DST. 
         */
	public static void setExtendedDSTRules()
	{
            TimeZone defaultTz = TimeZone.getDefault();
            // Clone the default TZ so that it can be safely maniputlated
            // before making the new on the default

            SimpleTimeZone simpleExtendedTZ = new SimpleTimeZone(defaultTz.getRawOffset(), defaultTz.getID());
            try
            {
                simpleExtendedTZ.setStartRule(dstStartMonth, dstStartDayOfWeekInMonth, dstStartDayOfWeek, dstStartHour*60*60*1000);
                simpleExtendedTZ.setEndRule(dstEndMonth, dstEndDayOfWeekInMonth, dstEndDayOfWeek, dstEndHour*60*60*1000);
                TimeZone.setDefault(simpleExtendedTZ);
            } catch (IllegalArgumentException ex)
            {
                LoggerFactory.getLogger(ExtendDST.class).warn( "Ignoring DST Parameters Invalid");
            }
	}

        /*
         * Calculate DST Start/End time in milliseconds since January 1, 1970, 00:00:00 GMT         
         */
        public static void calculateDSTStartEndTime(int currentYear) {
            Calendar calendar = null;

            try {
                calendar = (Calendar) Calendar.getInstance().clone();
                calendar.set(Calendar.YEAR, currentYear);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 0);

                calendar.set(Calendar.MONTH, dstStartMonth);
                calendar.set(Calendar.DAY_OF_WEEK, dstStartDayOfWeek);
                calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, dstStartDayOfWeekInMonth);
                calendar.set(Calendar.HOUR_OF_DAY, dstStartHour - 1);
                dstStartEndTime[0] = calendar.getTime().getTime() + (60 * 1000);

                calendar.set(Calendar.MONTH, dstEndMonth);
                calendar.set(Calendar.DAY_OF_WEEK, dstEndDayOfWeek);
                calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, dstEndDayOfWeekInMonth);
                calendar.set(Calendar.HOUR_OF_DAY, dstEndHour - 1);
                dstStartEndTime[1] = calendar.getTime().getTime() + (60 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
        
       /**
        * Tests if requested date/time falls under magic hrs during DST.
        *
        * @param timezone a timezone where date/time change requested.
        * @param date a requested date/time.
        * @return  <code>true</code> if date/time doesn't fall under DST magic hrs.
        *          <code>false</code> otherwise.
        */        
        public static boolean isSystemDateTimeUpdateAllowed(TimeZone timezone, Date date) {
            // get year from date 
            SimpleDateFormat newProDateFormat = new SimpleDateFormat("MMddHHmmyyyy.ss");
            String newTime = newProDateFormat.format(date);
            int yrIndex = newTime.lastIndexOf(".");
            int year = Integer.parseInt(newTime.substring(yrIndex-4, yrIndex));           
            
            if (timezone.useDaylightTime()) {
                long newTimeInMillis = date.getTime();

                if (year != currentYear) {
                    currentYear = year;
                    ExtendDST.calculateDSTStartEndTime(currentYear);                
                }

                if (((newTimeInMillis >= (dstStartEndTime[0] - ONE_HR)) && (newTimeInMillis <= dstStartEndTime[0]))
                    || ((newTimeInMillis >= (dstStartEndTime[1] - ONE_HR)) && (newTimeInMillis <= (dstStartEndTime[1] + ONE_HR)))) {                    
                    return false;
                }
            }            
            
            return true;
        }
}
