/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * An Action entity contains the type of action to be performed along with the
 * associated payload.
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class Action implements Serializable {
    
    static final long serialVersionUID = -4225392330267369L;

    private ActionType type;
    private Object actionPayload;
    private boolean isProcessed;

    /**
	 * @return the isExecuted
	 */
	public boolean isProcessed() {
		return isProcessed;
	}

	/**
	 * @param isExecuted the isExecuted to set
	 */
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	/**
     * @return Returns the actionPayload.
     */
    public Object getActionPayload() {
        return actionPayload;
    }

    /**
     * @param actionPayload The actionPayload to set.
     */
    public void setActionPayload(Object actionPayload) {
        this.actionPayload = actionPayload;
    }

    /**
     * @return Returns the type.
     */
    public ActionType getType() {
        return type;
    }

    /**
     * @param type The type to set.
     */
    public void setType(ActionType type) {
        this.type = type;
    }
    
    public String toString() {
        return "type-" + type + ";payload-" + actionPayload;
    }

}
