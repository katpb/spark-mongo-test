/**
 * 
 */
package com.verifone.isd.vsms2.net.ent.eps;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.EntryMethodDef;
import com.verifone.isd.vsms2.sys.l10n.ForeCourtRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * Entity class for allowed entry method
 * @author Regan_D1
 *
 */
public class EntryMethod implements Serializable {
	
	/**
	 * Serial version id.
	 */
	private static final long serialVersionUID = -6408797857677876852L;
	
	private EntryMethodDef entryMethod;
	private String label="";

	/**
	 * Returns entry method
	 * @return entryMethod
	 */
	public EntryMethodDef getEntryMethod() {
		return entryMethod;
	}

	/**
	 * @param entryMethod
	 */
	public void setEntryMethod(EntryMethodDef entryMethod) {
		this.entryMethod = entryMethod;
	}

	/**
	 * Returns entry method label to be displayed in screen
	 * @return entry Label
	 */
	public String getLabel() {
		if((entryMethod.equals(EntryMethodDef.ENTRY_MANUAL)) && (null == label)) {
			label = LocalizedRB.getForeCourtRes(ForeCourtRes.DCR_DEFAULT_MANUAL_ID);
		}
		return label;
	}

	/**
	 * Returns label
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object entryMthd) {
		
		if(entryMthd instanceof EntryMethod)
		{
			EntryMethod entry = (EntryMethod) entryMthd;
			if(this.label.equals(entry.getLabel()) &&
					this.entryMethod.equals(entry.getEntryMethod()))
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
		
		hashCode += this.getLabel() != null ? this.getLabel().hashCode() : 0 ;
		hashCode += this.getEntryMethod() != null? this.getEntryMethod().hashCode() : 0;
		
		return hashCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer outPut = new StringBuffer();
		outPut.append("EntryMethod:" + entryMethod.getDescription());
		if(label!=null)
		{
			outPut.append("Label:" + this.label);
		}
		
		return outPut.toString();
	}

}
