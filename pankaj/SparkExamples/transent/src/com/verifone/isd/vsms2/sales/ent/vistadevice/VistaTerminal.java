package com.verifone.isd.vsms2.sales.ent.vistadevice;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sales.ent.HeaderTrailerMsgConfig;
import com.verifone.isd.vsms2.sales.ent.IReceiptMsgConfig;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.ITerminalConfig;
import com.verifone.isd.vsms2.sales.ent.PinpadTypeEnum;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Vista Terminal Configuration
 * 
 * @author MadhusudhanB1
 *
 */
public class VistaTerminal implements IEntityObject, ISalesEntityVisitable,ITerminalConfig {

	private static final long serialVersionUID = 2503823673343348790L;
	private VistaTerminalPK pk;
	private PinpadTypeEnum pinpadType;
	private int groupSysID;
	private List<IReceiptMsgConfig> headers;
	private List<IReceiptMsgConfig> trailers;

	public VistaTerminal() {
		headers = new ArrayList<IReceiptMsgConfig>();
		trailers = new ArrayList<IReceiptMsgConfig>();
	}
	
	public VistaTerminal(VistaTerminalPK pk) {
		this.pk = pk;
		headers = new ArrayList<IReceiptMsgConfig>();
		trailers = new ArrayList<IReceiptMsgConfig>();
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);	
	}

	@Override
	public IEntityPK getPK() {
		return pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (VistaTerminalPK) pk;
	}
	

	@Override
	public void setAttributes(IEntityObject obj) {
		VistaTerminal terminalCfg = (VistaTerminal) obj;
		terminalCfg.setPK(this.pk);
		terminalCfg.setGroupSysID(this.groupSysID);
		terminalCfg.setPinpadType(this.pinpadType);
		terminalCfg.setHeaderMsgs(this.headers);
		terminalCfg.setTrailerMsgs(this.trailers);
	}

	
	public List<IReceiptMsgConfig> getTrailerMsgs() {
		return trailers;
	}

	public void setTrailerMsgs(List<IReceiptMsgConfig> trailerMsgs) {
		this.trailers = trailerMsgs;
	}

	public List<IReceiptMsgConfig> getHeaderMsgs() {
		return headers;
	}

	public void setHeaderMsgs(List<IReceiptMsgConfig> headerMsgs) {
		this.headers = headerMsgs;
	}
	public PinpadTypeEnum getPinpadType() {
		return pinpadType;
	}

	public void setPinpadType(PinpadTypeEnum pinpadTypeEnum) {
		this.pinpadType = pinpadTypeEnum;
		
	}

	public int getGroupSysID() {
		return groupSysID;
	}

	public void setGroupSysID(int value) {
		this.groupSysID = value;
	}
		
	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid Vista Terminal ID: " + this.pk);
		}

		for(IReceiptMsgConfig ht : headers) {
			((HeaderTrailerMsgConfig)ht).validate();
		}
		for(IReceiptMsgConfig ht : trailers) {
			((HeaderTrailerMsgConfig)ht).validate();
		}
		if(headers.size() > IReceiptMsgConfig.MAX_LINES || trailers.size() > IReceiptMsgConfig.MAX_LINES) {
			throw new SAXException("Number of text lines should not be more than : " + IReceiptMsgConfig.MAX_LINES);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof VistaTerminal)) {
			return false;
		}
		VistaTerminal vistaTerminal = (VistaTerminal) obj;
		if(vistaTerminal.getPK() == null || ((VistaTerminalPK)vistaTerminal.getPK()).getId() != this.pk.getId())
		{
			return false;
		}
		if(vistaTerminal.groupSysID != this.groupSysID) {
			return false;
		}
		if(vistaTerminal.getPinpadType() == null || !(vistaTerminal.getPinpadType() == this.getPinpadType())) {
			return false;
		}
		if(vistaTerminal.getHeaderMsgs() == null || !(vistaTerminal.getHeaderMsgs().equals(this.getHeaderMsgs()))) {
			return false;
		}
		if(vistaTerminal.getTrailerMsgs() == null || !(vistaTerminal.getTrailerMsgs().equals(this.getTrailerMsgs()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 34;
		hash += hash * 6 + this.pk.getId();
		hash += hash * 6 + this.getGroupSysID();
		hash += hash * 6 + this.getPinpadType().hashCode();
		hash += hash * 6 + this.getHeaderMsgs().hashCode();
		hash += hash * 6 + this.getTrailerMsgs().hashCode();
		
		return hash;
	}
	@Override
	public boolean isGroupConfigSupported() {
		return true;
	}

}
