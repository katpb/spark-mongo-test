/**
 * This Class provides specified limits required by CISP specifications.
 */
package com.verifone.isd.vsms2.sys.util;

/**
 * Helper class to capture all parameters that are restricted based on CISP requirements
 * @author Dennis_T1
 */
public class CispLimits
{
    private static final int minPasswordLength = 7;
    private static final int passwordHistoryCount = 4;
    private static final int maximumPasswordExpiryDays = 90;
    private static final int loginFailBeforeLockOut = 6;
    private static final int lockOutTimeMinutes = 30;
    private static final int maxIdleTimeMinutes = 15;
    
    /** The Constant maxPasswordLength. */
    private static final int maxPasswordLength=40;
    
    /** The Constant minPasswordExpiryWarningDays. */
    private static final int minPasswordExpiryWarningDays=7;
    
	private static final int noOfChallengeQuestionsPerUser = 4;
    private static final int noOfChallengeQuestionsToAnswer = 2;
	private static final int challengeAnswerMinLength = 5;
    private static final int challengeAnswerMaxLength = 40;
    
    /**
     * Gets the minimum password expiry warning days.
     * 
     * @return the minimum password expiry warning days
     */
    public static int getMinimumPasswordExpiryWarningDays() { return minPasswordExpiryWarningDays; }

    /**
     * Gets the min password length.
     * 
     * @return minimum allowable number of characters in a password.
     * When the minimum is configured, it can be larger than this, but
     * never smaller.
     */
    public static int getMinPasswordLength() { return minPasswordLength; }
    /**
     * Getter for the number of retained recent passwords.  The user may not  re-use any of the stored passwords
     * @return the number of retained recent passwords.
     */
    public static int getPasswordHistoryCount() { return passwordHistoryCount;}
    /**
     * Getter for the password expiry frequency, in days.
     * @return the maximum time in days for which a password may be configured to expire.
     */
    public static int getMaximumPasswordExpiryDays() { return maximumPasswordExpiryDays; }
    /**
     * Getter for maximim invalid password failures before the user is locked out.
     * @return count of login password failures before the user is locked out.
     */
    public static int getLoginFailBeforeLockout() { return loginFailBeforeLockOut; }
    /**
     * Getter for user lockout duration, in minutes
     * @return time in minutes the user will be locked out after too
     * many failures.
     */
    public static int getLockOutMinutes() { return lockOutTimeMinutes; }
	/**
     * Getter for maximum idle time in minutes, after which the user session is terminated.
     * @return Returns the maxIdleTimeMinutes.
     */
	public static int getMaxIdleTimeMinutes()
	{
		return maxIdleTimeMinutes;
	}
    /**
     * Gets the max password length.
     * 
     * @return the maxPasswordLength
     */
    public static int getMaxPasswordLength() {
	return maxPasswordLength;
    }
    
    public static int getNoOfChallengeQuestionsPerUser() {
		return noOfChallengeQuestionsPerUser;
	}

	public static int getNoOfChallengeQuestionsToAnswer() {
		return noOfChallengeQuestionsToAnswer;
	}
	
    public static int getChallengeAnswerMinLength() {
		return challengeAnswerMinLength;
	}

	public static int getChallengeAnswerMaxLength() {
		return challengeAnswerMaxLength;
	}
}
