package com.verifone.isd.vsms2.sys.ent.employee;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;

public class ReadOnlyEmployee extends Employee {

	private static final long serialVersionUID = -6868770627233475249L;

	private String passwdNoChecks;

	public ReadOnlyEmployee(EmployeePK ID) throws Exception {
        super(ID);
    }

    @Override
    public void setPassword(String passwd) {
        this.passwdNoChecks = passwd;
    }

    @Override
    public String getPassword() {
        return (this.passwdNoChecks == null ? super.getPassword() : this.passwdNoChecks);
    }

    @Override
    public void setAttributes(IEntityObject obj) {
        this.passwdNoChecks = null;
        super.setAttributes(obj);
    }

    public void accept(ISystemEntityVisitor v) throws Exception {
        v.visit(this);
    }
}
