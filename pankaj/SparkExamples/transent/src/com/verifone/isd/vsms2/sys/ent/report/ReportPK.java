/*
 * ReportPK.java
 *
 * Created on March 11, 2005, 4:58 PM
 */

package com.verifone.isd.vsms2.sys.ent.report;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 * This is the primary key for the report manager configuration entity
 * @author  tom_s5
 */
public class ReportPK implements IEntityPK {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.report.ReportPK.class);
	/**
	 * Default no-argument constructor
	 */
	public ReportPK() {
	}
	
	/** Method to compare two ReportPK objects for equality
	 * @param obj object to compare with
	 * @return true if the current and compared objects represent the same
	 * report configuration
	 */
        public boolean equals(IEntityPK obj) {
            if (obj instanceof ReportPK) {
                return true;
            }
            return false;
	}
        
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof IEntityPK) {
                return this.equals((IEntityPK) obj);
            }
            return false; 
        }
	
	/** Method to valiate the report number
	 * @return true if the employee number is valid
	 */
	public boolean isValid() {
		return true;
	}

    public int hashCode() {
        return 59 * 17;
    }
}
