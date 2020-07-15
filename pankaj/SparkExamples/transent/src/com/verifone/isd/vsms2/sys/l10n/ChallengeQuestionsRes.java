package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * @author VadirajaC1
 * 
 */
public class ChallengeQuestionsRes extends ListResourceBundle {

	public static final String BEST_FRIEND_FIRST_NAME = "BEST_FRIEND_FIRST_NAME";
	public static final String CHILDHOOD_NICKNAME = "CHILDHOOD_NICKNAME";
	public static final String ELEMENTARY_SCHOOL_NAME = "ELEMENTARY_SCHOOL_NAME";
	public static final String ELEMENTARY_SCHOOL_TEACHER_LAST_NAME = "ELEMENTARY_SCHOOL_TEACHER_LAST_NAME";
	public static final String FIRST_BOSS_LAST_NAME = "FIRST_BOSS_LAST_NAME";
	public static final String FIRST_CAR_MAKE_AND_MODEL = "FIRST_CAR_MAKE_AND_MODEL";
	public static final String FIRST_COMPANY = "FIRST_COMPANY";
	public static final String FIRST_JOB_CITY = "FIRST_JOB_CITY";
	public static final String FIRST_NAME_CHILDHOOD_FRIEND = "FIRST_NAME_CHILDHOOD_FRIEND";
	public static final String GRAND_FATHER_FIRST_NAME = "GRAND_FATHER_FIRST_NAME";
	public static final String GRANDFATHER_PROFESSION = "GRANDFATHER_PROFESSION";
	public static final String GRANDMOTHER_FIRST_NAME = "GRANDMOTHER_FIRST_NAME";
	public static final String LAST_NAME_HIGHSCHOOL_TEACHER = "LAST_NAME_HIGHSCHOOL_TEACHER";
	public static final String MIDDLE_NAME_OLDEST_CHILD = "MIDDLE_NAME_OLDEST_CHILD";
	public static final String OLDEST_NEICE_FIRST_NAME = "OLDEST_NEICE_FIRST_NAME";
	public static final String OLDEST_NEPHEW_FIRST_NAME = "OLDEST_NEPHEW_FIRST_NAME";
	public static final String OLDEST_SIBLING_MIDDLE_NAME = "OLDEST_SIBLING_MIDDLE_NAME";
	public static final String SPOUSE_CITY = "SPOUSE_CITY";
	public static final String STREET_NAME_BEST_FRIEND_IN_HIGH_SCHOOL = "STREET_NAME_BEST_FRIEND_IN_HIGH_SCHOOL";
	public static final String STREET_NAME_IN_THIRD_GRADE = "STREET_NAME_IN_THIRD_GRADE";

	private static final Object[][] contents = { 
			{ BEST_FRIEND_FIRST_NAME, 					"What is the first name of your best friend in high school?" },
			{ CHILDHOOD_NICKNAME, 						"What was your childhood nickname?" }, 
			{ ELEMENTARY_SCHOOL_NAME, 					"What was the name of your elementary school?" },
			{ ELEMENTARY_SCHOOL_TEACHER_LAST_NAME, 		"What was the last name of your favorite elementary school teacher?" },
			{ FIRST_BOSS_LAST_NAME, 					"What is the last name of your first boss?" },
			{ FIRST_CAR_MAKE_AND_MODEL, 				"What was the make and model of your first car?" },
			{ FIRST_COMPANY, 							"What was the name of the company where you had your first job?" },
			{ FIRST_JOB_CITY, 							"In what city or town was your first job?" },
			{ FIRST_NAME_CHILDHOOD_FRIEND, 				"What was the first name of your favorite childhood friend?" },
			{ GRAND_FATHER_FIRST_NAME, 					"What was your grandfather's (on your mother's side) first name?" },
			{ GRANDFATHER_PROFESSION, 					"What was your grandfather's (on your father's side) profession?" },
			{ GRANDMOTHER_FIRST_NAME, 					"What is your grandmother's first name?" },
			{ LAST_NAME_HIGHSCHOOL_TEACHER, 			"What was the last name of your favorite high school teacher?" },
			{ MIDDLE_NAME_OLDEST_CHILD, 				"What is the middle name of your oldest child?" },
			{ OLDEST_NEICE_FIRST_NAME, 					"What is the first name of your oldest niece?" },
			{ OLDEST_NEPHEW_FIRST_NAME, 				"What is the first name of your oldest nephew?" },
			{ OLDEST_SIBLING_MIDDLE_NAME, 				"What is your oldest sibling's middle name?" },
			{ SPOUSE_CITY, 								"In what city or town did you meet your first spouse/partner?" },
			{ STREET_NAME_BEST_FRIEND_IN_HIGH_SCHOOL, 	"What was the street name where your best friend in high school lived (street name only)?" },
			{ STREET_NAME_IN_THIRD_GRADE, 				"What was the name of the street where you were living when you were in third grade?" }, 
			};

	@Override
	public Object[][] getContents() {
		return contents;
	}
}
