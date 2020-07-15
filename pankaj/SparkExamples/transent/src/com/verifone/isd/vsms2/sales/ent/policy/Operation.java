/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCodePK;

/**
 * An Operation entity contains the type of operation to be performed along with
 * the associated payload.
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class Operation implements Serializable {
    
    static final long serialVersionUID = 2030206829930464318L;

    private OperationType type;
    private OperatorType operator;
    private Object oprnPayload;

    /**
     * @return Returns the operator.
     */
    public OperatorType getOperator() {
        return operator;
    }

    /**
     * @param operator The operator to set.
     */
    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    /**
     * @return Returns the oprnPayload.
     */
    public Object getOprnPayload() {
        return oprnPayload;
    }

    /**
     * @param oprnPayload The oprnPayload to set.
     */
    public void setOprnPayload(Object oprnPayload) {
        this.oprnPayload = oprnPayload;
    }

    /**
     * @return Returns the type.
     */
    public OperationType getType() {
        return type;
    }

    /**
     * @param type The type to set.
     */
    public void setType(OperationType type) {
        this.type = type;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("type-" + type);
        buffer.append(";operator-" + operator);
        if(type == OperationType.DEPT && operator == OperatorType.LIKE) {
            buffer.append(";payload-");
            DepartmentPK[] deptPKs = (DepartmentPK[]) oprnPayload;
            for(int i=0; i < deptPKs.length; i++)
                buffer.append(deptPKs[i].toString() + ",");
        } else if(type == OperationType.PRODCODE && operator == OperatorType.LIKE) {
            buffer.append(";payload-");
            ProdCodePK[] prdPKs = (ProdCodePK[]) oprnPayload;
            for(int i=0; i < prdPKs.length; i++)
                buffer.append(prdPKs[i].toString() + ",");
        } else if(type == OperationType.PLU && operator == OperatorType.LIKE) {
            buffer.append(";payload-");
            PluPK[] pluPKs = (PluPK[]) oprnPayload;
            for(int i=0; i < pluPKs.length; i++)
                buffer.append(pluPKs[i].toString() + ",");
        } else {
            buffer.append(";payload-" + oprnPayload);
        }
        return buffer.toString();
    }

}
