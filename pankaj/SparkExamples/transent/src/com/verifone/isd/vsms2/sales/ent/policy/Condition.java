/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * A Condition class contains the operation defined for this condition of the
 * policy and the join type.
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class Condition implements Serializable {
    
    static final long serialVersionUID = -2244221405832394640L;

    private Operation operation;
    private JoinType joinType;

    /**
     * @return Returns the joinType.
     */
    public JoinType getJoinType() {
        return joinType;
    }

    /**
     * @param joinType The joinType to set.
     */
    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    /**
     * @return Returns the operation.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * @param operation The operation to set.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    public String toString() {
        return "\n operation: " + operation + "\n joinType: " + joinType;
    }
}
