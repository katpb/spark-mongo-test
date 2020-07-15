package com.verifone.isd.vsms2.sales.ent.thirdpartyproduct;

public interface IThirdPartyProductProviderEntityVisitable {
	public void accept(ThirdPartyProductProviderEntityVisitor v) throws Exception;
}
