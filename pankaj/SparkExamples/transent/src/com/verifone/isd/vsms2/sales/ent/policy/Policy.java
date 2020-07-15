/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * A Policy entity contains a set of conditions that define the policy and also
 * the action that needs to be performed.
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class Policy implements Serializable {

    static final long serialVersionUID = -8474231892299751086L;

    private String sysid;
    private String name;
    private String description;
    private boolean active;
    private ScopeType scope;
    private TriggerType trigger;
    private Condition[] conditions;
    private Action[] actions;
    private int registerId;

	public String getSysid() {
		return sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	/**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the actions.
     */
    public Action[] getActions() {
        return actions;
    }

    /**
     * @param actions The actions to set.
     */
    public void setActions(Action[] actions) {
        this.actions = actions;
    }

    /**
     * @return Returns the active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active The active to set.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return Returns the conditions.
     */
    public Condition[] getConditions() {
        return conditions;
    }

    /**
     * @param conditions The conditions to set.
     */
    public void setConditions(Condition[] conditions) {
        this.conditions = conditions;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Returns the scope.
     */
    public ScopeType getScope() {
        return scope;
    }

    /**
     * @param scope The scope to set.
     */
    public void setScope(ScopeType scope) {
        this.scope = scope;
    }

    /**
     * @return Returns the trigger.
     */
    public TriggerType getTrigger() {
        return trigger;
    }

    /**
     * @param trigger The trigger to set.
     */
    public void setTrigger(TriggerType trigger) {
        this.trigger = trigger;
    }
    
    /**
     * @return Returns the registerId.
     */
    public int getRegisterId() {
        return registerId;
    }
    
    /**
     * @param registerId The registerId to set.
     */
    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("name-" + name);
        buffer.append("\n description-" + description);
        buffer.append("\n active-" + active);
        buffer.append(";scope-" + scope);
        buffer.append(";trigger-" + trigger);
        for(int i=0; i < conditions.length; i++) {
            buffer.append("\n condition " + (i+1) + ":");
            buffer.append(conditions[i].toString());
        }
        for(int i=0; i < actions.length; i++) {
            buffer.append("\n action " + (i+1) + ":");
            buffer.append(actions[i].toString());
        }
        buffer.append("\n\n");
        return buffer.toString();
    }
    
    /**
     * clears status code once actions processed completely
     */
    public void clearActionstatus(){
    	for(int i=0; i < actions.length; i++) {
    		actions[i].setProcessed(false);
        }
    }
}
