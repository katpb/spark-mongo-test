package com.verifone.isd.vsms2.sales.ent;

/**
 * Entity class for APT Header and Trailer
 * 
 * @author MadhusudhanB1
 *
 */
public class HeaderTrailerMsgConfig implements ISalesEntityVisitable,IReceiptMsgConfig{

	private int lineNumber;
	private String text;
	private AlignmentEnum alignment;
	
	public HeaderTrailerMsgConfig() {
		
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String Text) {
		this.text = Text;
	}
	
	public AlignmentEnum getAlign() {
		return alignment;
	}
	
	public void setAlign(AlignmentEnum align) {
		this.alignment = align;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof HeaderTrailerMsgConfig)) {
			return false;
		}
		
		HeaderTrailerMsgConfig htText = (HeaderTrailerMsgConfig) obj;
		
		if(this.lineNumber != htText.getLineNumber()) {
			return false;
		}
		
		if(!this.text.equals(htText.getText())) {
			return false;
		}
		
		if(!this.alignment.equals(htText.getAlign())) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 27;
		hash += hash * 10 + this.lineNumber;
		hash += hash * 10 + this.text.hashCode();
		hash += hash * 10 + this.alignment.hashCode();
		
		return hash;
	}
}

