/*
 * Created on Jul 27, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;

/**
 * @author Anindya_D1
 *
 * This class holds the track2 and user data generated on Gempro when
 * speedpass RF data is received on Topaz. Topaz makes an RMI call to
 * get the track2 and user data from Gempro.
 */
public class ParsedRF implements Serializable {
	static final long serialVersionUID = 1416574450742497959L;
	private String track2;
	private String userData;
	/**
	 * 
	 */
	public ParsedRF() {
		track2 = new String("");
		userData = new String("");
	}

	/**
	 * @return Returns the track2.
	 */
	public String getTrack2() {
		return track2;
	}
	/**
	 * @param track2 The track2 to set.
	 */
	public void setTrack2(String track2) {
		this.track2 = track2;
	}
	/**
	 * @return Returns the userData.
	 */
	public String getUserData() {
		return userData;
	}
	/**
	 * @param userData The userData to set.
	 */
	public void setUserData(String userData) {
		this.userData = userData;
	}
}
