package com.verifone.isd.vsms2.sys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateValidation {

	private static Logger logger = LoggerFactory
			.getLogger(DateValidation.class);

	public static void validateStartDateAndEndDate(String startDate,
			String endDate) throws DateValidationException, ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date start=null;
		Date end =null;
		if(startDate!=null&&endDate!=null){
		 start = dateFormat.parse(startDate);
		 end = dateFormat.parse(endDate);
            
		
		if (start.after(end)) {

			logger.error("Start Date must be less than End Date");
			throw new DateValidationException(
					"Start Date must be less than End Date");
		}

		 }
	}
}
