package com.verifone.isd.vsms2.sales.ent.loginout;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

import java.util.Hashtable;

/**
 *  entity class for LogInOut
 *
 *  @author "mailto:bhanu_narayanan@hp.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */
public class LogInOut implements IEntityObject, ISalesEntityVisitable {
    
    static final long serialVersionUID = -9079577740805955472L;

    private static final int MAX_LINES = 3;

    private LogInOutPK ID;
    
    private Hashtable logInMsgLines;
    private boolean isLogInMsgDisplayEnabled = false;  // Default disabled

    private Hashtable logOutMsgLines;
    private boolean isLogOutMsgDisplayEnabled = false;  // Default disabled

    /**
     * Entity object containing the login and logout message
     */    
    public LogInOut() {
        this.ID = new LogInOutPK();
        this.logInMsgLines = new Hashtable(MAX_LINES);
        this.logOutMsgLines = new Hashtable(MAX_LINES);
        for(int i=1; i<=MAX_LINES; ++i) {
            this.logInMsgLines.put(new Integer(i), "");
            this.logOutMsgLines.put(new Integer(i), "");
        }
    }

    /**
     * Getter for the primary key
     * @return primary key object
     */    
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /**
     * Setter for primary key
     * @param pk primary key object
     */    
    public void setPK(IEntityPK pk) {
        this.ID = (LogInOutPK)pk;
    }
    
    /**
     * Getter for logInEnable property
     * @return If true, the login message is displayed when logging in
     */    
    public boolean isLogInMsgDisplayEnabled() {
        return this.isLogInMsgDisplayEnabled;
    }
    
    /**
     * Setter for logInEnable property
     * @param isTrue If true, the login message is displayed when logging in
     */    
    public void setLogInMsgDisplayEnabled(boolean isTrue) {
        this.isLogInMsgDisplayEnabled = isTrue;
    }

    /**
     * Getter for logOutEnable property
     * @return If true, the logout message is displayed when logging out
     */    
    public boolean isLogOutMsgDisplayEnabled() {
        return this.isLogOutMsgDisplayEnabled;
    }
    
    /**
     * Setter for logOutEnable property
     * @param isTrue If true, the logout message is displayed when logging out
     */    
    public void setLogOutMsgDisplayEnabled(boolean isTrue) {
        this.isLogOutMsgDisplayEnabled = isTrue;
    }

    /**
     * Getter for a line of the login message
     * @param index message line number
     * @return The requested message line
     */    
    public String getLogInLineAt(int index) {
        return (String)logInMsgLines.get(new Integer(index));
    }

    /**
     * Getter for the number of login message lines
     * @return number of login message lines
     */    
    public int getLogInLinesCount() {
        return logInMsgLines.size();
    }    
    
    /**
     * Setter for a line of the login message
     * @param index message line number
     * @param message Contents of message line
     */    
    public void setLogInLineAt(int index, String message) {
        logInMsgLines.put(new Integer(index), ((null == message) ? "" : message));
    }
    
    /**
     * Getter for a line of the logout message
     * @param index message line number
     * @return The requested message line
     */    
    public String getLogOutLineAt(int index) {
        return (String)logOutMsgLines.get(new Integer(index));
    }
    
    /**
     * Getter for the number of logout message lines
     * @return number of login message lines
     */    
    public int getLogOutLinesCount() {
        return logOutMsgLines.size();
    }    
    
    /**
     * Setter for a line of the logout message
     * @param index message line number
     * @param message Contents of message line
     */    
    public void setLogOutLineAt(int index, String message) {
        logOutMsgLines.put(new Integer(index), ((null == message) ? "" : message));
    }
    
    /** Method to clone the current entity into another
     * @param obj object to be copied to
     */    
    public void setAttributes(IEntityObject obj) {
        LogInOut lObj = (LogInOut) obj;
        lObj.setLogInMsgDisplayEnabled(this.isLogInMsgDisplayEnabled());
        lObj.setLogOutMsgDisplayEnabled(this.isLogOutMsgDisplayEnabled());
        for ( int i = 1; i <= this.logInMsgLines.size(); i++ ) {
            lObj.setLogInLineAt(i, this.getLogInLineAt(i));
        }
        for ( int i = 1; i <= this.logOutMsgLines.size(); i++ ) {
            lObj.setLogOutLineAt(i, this.getLogOutLineAt(i));
        }
    }
    
    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!this.ID.isValid()) {
            throw new Exception ("Invalid ID for LogInOut: " +this.ID);
        }
    }

    /**
     * Method to validate the primary key of the entity object
     * @return True if the primary key is valid
     */
    public boolean isPKValid() {
        return this.ID.isValid();
    }
    
    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }       
}