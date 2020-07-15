/*
 * Verifone Copyright (c) All rights reserved.
 * Author: HimanshuY1
 * Created on Apr 23, 2012
 */
package com.verifone.isd.vsms2.net.ent.eps;

import com.verifone.isd.vsms2.net.ent.PosLoyaltyConfig;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity Object for Net Pos Config
 * @author HimanshuY1
 */
public class NetPosConfig implements IEntityObject{

	private static final long serialVersionUID = -6414803170382420159L;
	
	private NetDealerConfig dealerConfig;
	private NetBatchConfig batchConfig;
	private PosLoyaltyConfig posLoyaltyConfig;

	private NetPosConfigPK ID;
	
	public NetPosConfig() {
		this.dealerConfig = new NetDealerConfig();
		this.batchConfig = new NetBatchConfig();
		this.posLoyaltyConfig = new PosLoyaltyConfig();
	}

	public void setRecordNr(short recordNr) {
        ID = new NetPosConfigPK(recordNr);
    }
	
	@Override
	public IEntityPK getPK() {
		return ID;
	}

	@Override
	public boolean isPKValid() {
		 return (this.ID == null) ? false : this.ID.isValid();
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		if (obj instanceof NetPosConfig) {
			NetPosConfig posCfg = (NetPosConfig) obj;
			batchConfig.setAttributes(posCfg.getBatchConfig());
			dealerConfig.setAttributes(posCfg.getDealerConfig());
			posLoyaltyConfig.setAttributes(posCfg.getPosLoyaltyConfig());
		}
	}

	@Override
	public void setPK(IEntityPK pk) {
		 ID = (NetPosConfigPK)pk;
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid NetPosConfig Entry ID: " + this.ID);
		}
		/*
		 * Skipping validation of dealer config as many original EPSPAK fields
		 * are not used in commander and will need some clean up.
		 */
		if (this.batchConfig != null) {
			this.batchConfig.validate();
		}
		if (this.posLoyaltyConfig != null) {
			this.posLoyaltyConfig.validate();
		}
	}

	/**
	 * @return the dealerConfig
	 */
	public NetDealerConfig getDealerConfig() {
		return dealerConfig;
	}

	/**
	 * @param dealerConfig the dealerConfig to set
	 */
	public void setDealerConfig(NetDealerConfig dealerConfig) {
		this.dealerConfig = dealerConfig;
	}

	/**
	 * @return the batchConfig
	 */
	public NetBatchConfig getBatchConfig() {
		return batchConfig;
	}

	/**
	 * @param batchConfig the batchConfig to set
	 */
	public void setBatchConfig(NetBatchConfig batchConfig) {
		this.batchConfig = batchConfig;
	}

	/**
	 * @return the posLoyaltyConfig
	 */
	public PosLoyaltyConfig getPosLoyaltyConfig() {
		return posLoyaltyConfig;
	}

	/**
	 * @param posLoyaltyConfig the posLoyaltyConfig to set
	 */
	public void setPosLoyaltyConfig(PosLoyaltyConfig posLoyaltyConfig) {
		this.posLoyaltyConfig = posLoyaltyConfig;
	}
}
