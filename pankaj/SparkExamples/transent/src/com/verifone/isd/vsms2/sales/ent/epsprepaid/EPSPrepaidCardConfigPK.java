package com.verifone.isd.vsms2.sales.ent.epsprepaid;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class EPSPrepaidCardConfigPK implements IEntityPK{
	
	private static final long serialVersionUID = -2166092247999588752L;

	private short recordNr;
	
	public EPSPrepaidCardConfigPK() {
	}
	
	public EPSPrepaidCardConfigPK(short recordNr) {
	    this.recordNr = recordNr;
	}
	
	public short getValue() {
	   return this.recordNr;
	}
	    
	public short getRecordNr() {
		return recordNr;
	}

	public void setRecordNr(short recordNr) {
		this.recordNr = recordNr;
	}

	 /** Method to compare two PrepaidCardConfigPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same record number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof EPSPrepaidCardConfigPK) {
        	EPSPrepaidCardConfigPK dObj = (EPSPrepaidCardConfigPK)obj;
            return (this.recordNr == dObj.recordNr);
        }
        return false;
    }
    
    /** Returns the objects string representation
     * @return string representation of the record number
     */    
    public String toString() {
        return String.valueOf(this.recordNr);
    }
    
	public boolean isValid() {
		boolean isValid = false;
		
		if(recordNr > 0){
			isValid = true;
		}
		return isValid;
	}
	
}