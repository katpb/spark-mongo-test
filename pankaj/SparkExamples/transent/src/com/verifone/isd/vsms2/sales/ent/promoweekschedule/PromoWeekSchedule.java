package com.verifone.isd.vsms2.sales.ent.promoweekschedule;

import java.io.Serializable;

public class PromoWeekSchedule implements Serializable {

	private static final long serialVersionUID = -4861064745826073514L;
	private String promotionID;
	private int dayofWeek;
	private String startDate;
	private String stopDate;
	private boolean enable = true;

	public PromoWeekSchedule() {
        startDate = new String();
        stopDate = new String();
	}
	
	/**
     * Constructor to be used primarily to create a minimal object suitable for use
     * in delete and empty statements from NAXML maint functions that have a
     * foreign key relationship to the weekSched classes.
     *
     * @param id 
     */
	public PromoWeekSchedule(String id) {
		this();
        this.promotionID = id;
    }

	/**
	 * @param id
	 * @param dayofWeek
	 * @param startDate
	 * @param stopDate
	 * @param enable
	 */
	public PromoWeekSchedule(String id, int dayofWeek,
			String startDate, String stopDate, boolean enable) {
		this();
		this.promotionID = id;
		this.dayofWeek = dayofWeek;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.enable = enable;
	}

	public void validate() throws Exception {

		if (this.promotionID == null
				|| (this.promotionID != null && this.promotionID.equals(""))) {
			throw new Exception("Invalid PromoWeekSchedule promotionID: "
					+ this.promotionID);
		}
		if (this.dayofWeek <= 0 && this.dayofWeek > 7) {
			throw new Exception("Invalid PromoWeekSchedule dayofWeek: "
					+ this.dayofWeek);
		}
		if (this.startDate == null) {
			throw new Exception("Invalid PromoWeekSchedule startDate: "
					+ this.startDate);
		}
		if (this.stopDate == null) {
			throw new Exception("Invalid PromoWeekSchedule stopDate: "
					+ this.stopDate);
		}
	}

	



	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	/**
	 * @return the dayofWeek
	 */
	public int getDayofWeek() {
		return dayofWeek;
	}

	/**
	 * @param dayofWeek the dayofWeek to set
	 */
	public void setDayofWeek(int dayofWeek) {
		this.dayofWeek = dayofWeek;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the stopDate
	 */
	public String getStopDate() {
		return stopDate;
	}

	/**
	 * @param stopDate the stopDate to set
	 */
	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	/** This method returns the String representation of the entity.
	 * @return String representation of the entity.
	 */
	public String toString() {
		return "PromoWeekSchedule# id:" + this.promotionID + "; dayofWeek:"
                + this.dayofWeek + "; startDate:"
				+ this.startDate + "; stopDate:" + this.stopDate + "; enable:"
				+ this.enable;
	}
	
	public boolean isValid() {
		try {
			this.validate();
			return true;
		} catch(Exception e) {
			return false;	
		}
	}

}


