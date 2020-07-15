/**
 * 
 */
package com.verifone.isd.vsms2.net.ent.eps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class for Loyalty Program details
 * @author Regan_D1
 *
 */
public class LoyaltyProgramConfig implements Serializable {
	
	private static final long serialVersionUID = -8481006031770472447L;
	
	private String programName;
	private String programId;
	/*
	 * secondary loyalty program ID reported to primary EPS
	 */
	private String secondaryProgramId;
	private List<EntryMethod> entryMethodList;
	private String epsName;
	
	public LoyaltyProgramConfig(){
		entryMethodList = new ArrayList<EntryMethod>();
		this.epsName = null;
		this.programName="";
		this.programId="";
	}
	
	/**
	 * Returns Loyalty Program name
	 * @return programName
	 */
	public String getProgramName() {
		return programName;
	}
	
	/**
	 * Set Loyalty Program name
	 * @param programName
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	/**
	 * Returns Loyalty ProgramId
	 * @return programId
	 */
	public String getProgramId() {
		return programId;
	}
	
	/**
	 * set Loyalty ProgramId
	 * @param programId
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	/**
	 * Returns allowed entry method list
	 * @return entryMethodList
	 */
	public List<EntryMethod> getEntryMethodList() {
		return entryMethodList;
	}
	
	/**
	 * Set allowed entry method list
	 * @param entryMethodList
	 */
	public void setEntryMethodList(List<EntryMethod> entryMethodList) {
		this.entryMethodList = entryMethodList;
	}
	
	/**
	 * Add entry method to the list 
	 * @param entryMethod
	 */
	public void addEntryMethod(EntryMethod entryMethod){
		entryMethodList.add(entryMethod);
	}

	/**
	 * Returns name of the EPS.
	 * @return epsName
	 */
	public String getEpsName() {
		return epsName;
	}

	/**
	 * set name of the EPs
	 * @param epsName
	 */
	public void setEpsName(String epsName) {
		this.epsName = epsName;
	}

	public String getSecondaryProgramId() {
		/*
		 * If this is not a secondary loyalty program, report the actual program
		 * ID to primary EPS
		 */
		if (secondaryProgramId == null) {
			return programId;
		}
		return secondaryProgramId;
	}

	public void setSecondaryProgramId(String secondaryProgramId) {
		this.secondaryProgramId = secondaryProgramId;
	}

	/**
	 * This method returns true if epsName of this is same as lyltyConfig.
	 * @param lyltyConfig
	 * @return true or false
	 */
	private boolean isEpsNameEquals(LoyaltyProgramConfig lyltyConfig){
		if( (this.epsName == null &&  lyltyConfig.getEpsName() == null) ||
				(this.epsName!=null && lyltyConfig.getEpsName() != null &&
				lyltyConfig.getEpsName().equalsIgnoreCase(this.epsName)) ) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method returns true if entry method list of this is same as lyltyConfig.
	 * @param lyltyConfig
	 * @return true or false
	 */
	private boolean isEntryMethodEquals(LoyaltyProgramConfig lyltyConfig){
		
		if((this.getEntryMethodList().size() == lyltyConfig.getEntryMethodList().size()) && 
				(this.getEntryMethodList().containsAll(lyltyConfig.getEntryMethodList()))){
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object lyltyPgmCfg) {
		
		if(lyltyPgmCfg instanceof LoyaltyProgramConfig) {
			
			LoyaltyProgramConfig lyltyConfig = (LoyaltyProgramConfig) lyltyPgmCfg;
			
			if(this.programName.equals(lyltyConfig.getProgramName()) &&
				this.programId.equals(lyltyConfig.getProgramId()) &&
				isEpsNameEquals(lyltyConfig) &&
				isEntryMethodEquals(lyltyConfig))
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;
		
		hashCode += this.getProgramName() != null ? this.getProgramName().hashCode() : 0; 
		hashCode += this.getProgramId() != null ? this.getProgramId().hashCode() : 0;
		hashCode += this.getEpsName() != null ? this.getEpsName().hashCode() : 0;
		for(EntryMethod entryMthd : this.getEntryMethodList()){
			hashCode += entryMthd.hashCode();
		}
		
		return hashCode;
	}

	@Override
	public String toString() {
		return "LoyaltyProgramConfig ["
				+ (programName != null ? "programName=" + programName + ", "
						: "")
				+ (programId != null ? "programId=" + programId + ", " : "")
				+ (entryMethodList != null ? "entryMethodList="
						+ entryMethodList : "") + "]";
	}
	
	
}
