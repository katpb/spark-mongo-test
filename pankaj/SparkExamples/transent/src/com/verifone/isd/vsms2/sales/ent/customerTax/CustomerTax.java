/*
 * CustomerTax.java
 * Created by: JoswillP1
 *
 * COPYRIGHT (c) 2019 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sales.ent.customerTax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;
import java.text.MessageFormat;
import java.time.LocalDate;

/**
 *
 * @author JoswillP1
 */
public class CustomerTax implements IEntityObject {

	private CustomerTaxPK ID;
	private String name;
	private String address;
	private String phone;
	private String city;
	private String department;
	private int nrc;
	private String giro;
	private LocalDate last_access;
	public static final CustomerTax FISCAL_FINAL_CONSUMER;
	static {
		/**
		 * Final Consumer customer Tax Information
		 */
		FISCAL_FINAL_CONSUMER = new CustomerTax(CustomerTaxPK.FISCAL_FC_PK);
		FISCAL_FINAL_CONSUMER.setName(LocalizedRB.getTopazRes(TopazRes.FISCAL_FINAL_CONSUMER));
	}

	public CustomerTax() {
		this(null);
	}

	public CustomerTax(CustomerTaxPK ID) {
		this.ID = ID;
	}

	@Override
	public CustomerTaxPK getPK() {
		return ID;
	}

	@Override
	public void setPK(IEntityPK pk) {
		ID = CustomerTaxPK.class.cast(pk);
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		CustomerTax cObj = CustomerTax.class.cast(obj);
		cObj.ID = ID;
		cObj.name = name;
		cObj.address = address;
		cObj.phone = phone;
		cObj.city = city;
		cObj.department = department;
		cObj.nrc = nrc;
		cObj.giro = giro;
		cObj.last_access = last_access;
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception(MessageFormat.format("Invalid customer tax ID: {0} ",
					ID.getValue()));
		}
		if ((name == null) || (name.trim().isEmpty()) || (name.trim().equals("*"))) {
			throw new Exception(MessageFormat.format("Invalid name for customer: {0} ",
					ID.getValue()));
		}
	}

	@Override
	public boolean isPKValid() {
		return (ID != null && ID.isValid());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getNrc() {
		return nrc;
	}

	public void setNrc(int nrc) {
		this.nrc = nrc;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	@Override
	public String toString() {
		return "CustomerTax{" + ID + ", name=" + name + ","
				+ " address=" + address + '}';
	}
}
