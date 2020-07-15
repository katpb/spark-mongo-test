package com.verifone.isd.vsms2.sys.util;

import java.security.SecureRandom;

/**
 * 
 * Class to generate a random PCI compliant password
 * 
 * @author Ashim_K1
 *
 */
public class RandomPCICompliantPasswordGenerator {
	
	/** The Constant PRNG.The PRNGs are part of Java cryptographic service providers (CSPs) */
	private static final String PRNG = "SHA1PRNG";
	
	/** The passwd length. */
	private int passwdLen ;
		
	/**
	 * No argument constructor.
	 */
	public RandomPCICompliantPasswordGenerator() { 
		passwdLen = CispLimits.getMinPasswordLength();
	}
	
	/**
	 * Generates a random PCI compliant password.
	 * 
	 * @param passwordLength
	 *            the password length
	 * @return the string
	 */
	public String generate(int passwordLength) {
		SecureRandom generator;
		this.passwdLen = passwordLength;
		
		try {
			generator = SecureRandom.getInstance(PRNG);
		} catch (Exception ex) {
			generator = new SecureRandom();
		}
		char buffer[] = new char[passwdLen];
    	int randomNum;
    	
    	/* Fill all positions with random integers from 0 to 9*/
    	for( int i = 0; i < passwdLen; i++) {
    		randomNum = generator.nextInt(9);
    		buffer[i] = (char)(randomNum + '0');
     	}
    
    	/* Determine a random position to put a alphabet */ 
    	int positionOfAlpha = generator.nextInt(passwdLen);
    	
    	/* Get a random alphabet */
    	randomNum = generator.nextInt(25);
    	randomNum = randomNum + 'A';
    	
    	/* Put the generated alphabet in to the determined position */
   		buffer[positionOfAlpha] = (char)randomNum;
   		
		String generatedPassword = new String(buffer);
		String modifiedPassword = this.fixForReadability(generatedPassword);		   	
    	
		return modifiedPassword;
	}

	/**
	 * Perform sieving.
	 * 
	 * @param generatedPassword
	 *            the generated password
	 */
	private String fixForReadability(String generatedPassword) { 

		/**
		 * We generate passwords that include o, O, and 0 which can be hard to
		 * get right. These characters are not a security issue, but they do
		 * hamper usability in the field. A simple sieve that replaces {oO0}
		 * with O and {l1LI} with 1.
		 * 
		 * If some group of letters can be mistaken for a number ,we are
		 * replacing them with that number.Alphabets 'o' and 'O' are treated as
		 * numeric zero(0).Alphabets L,l and I are converted to numeric 1(one).
		 */
		String modifiedPassword = generatedPassword.replaceAll("O", "0");
		modifiedPassword = modifiedPassword.replaceAll("o", "0");
		modifiedPassword = modifiedPassword.replaceAll("L", "1");
		modifiedPassword = modifiedPassword.replaceAll("l", "1");
		modifiedPassword = modifiedPassword.replaceAll("I", "1");
		return modifiedPassword;
	}

}
