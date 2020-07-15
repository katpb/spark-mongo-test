package com.verifone.isd.vsms2.sales.ent.epsprepaid;

public interface IEPSPrepaidEntityVisitable {
	public void accept(EPSPrepaidEntityVisitor v) throws Exception;
}
