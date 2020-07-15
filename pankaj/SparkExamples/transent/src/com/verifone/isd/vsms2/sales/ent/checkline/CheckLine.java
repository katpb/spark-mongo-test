package com.verifone.isd.vsms2.sales.ent.checkline;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MessageJustification;
import com.verifone.isd.vsms2.sys.util.MessageMode;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
/** Entity class for CheckLine
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CheckLine implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -9079577740805955472L;
    /** Maximum CheckLines
     */    
    public static final int MAX_CHECK_LINES = 5;
    private CheckLinePK ID;
    private String message;
    private MessageMode mode;           // Default Normal mode
    private MessageJustification justification;  // Default left justified
    private boolean enabled = true;  // Default enabled
    
    /** Enumeration to define normal mode of printing */    
    public static final int NORMAL_MODE = 0;
    /** Enumeration to define double mode of printing */    
    public static final int DOUBLE_MODE = 1;
    
    /** Enumeration to define left justification */    
    public static final int LEFT_JUSTIFY = 0;
    /** Enumeration to define center justification */    
    public static final int CENTER_JUSTIFY = 1;
    /** Enumeration to define right justification */    
    public static final int RIGHT_JUSTIFY = 2;
    
    /** Constructor
     * @param ID PK for the entity
     */    
    public CheckLine(CheckLinePK ID) {
        this.ID = ID;
        this.message = "";
    }
    
    /** No-args constructor */    
    public CheckLine() {
        this(new CheckLinePK(0));
    }
    
    /** Setter for property message
     * @param message message of the entity
     */    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /** Getter for property message
     * @return message of the entity
     */    
    public String getMessage() {
        return this.message;
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to clone another entity with this enity's attributes
     * @param obj entity to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        CheckLine cObj = (CheckLine) obj;
        cObj.ID = this.ID;
        cObj.message = this.message;
        cObj.mode = this.mode;
        cObj.justification = this.justification;
        cObj.enabled = this.enabled;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();  
    }

    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (CheckLinePK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid CheckLine: " +this.ID);            
        }
    }
    
    /** Getter for property mode.
     * @return Value of property mode.
     */
    public MessageMode getMode() {
        return this.mode;
    }
    
    /** Setter for property mode.
     * @param mode New value of property mode.
     */
    public void setMode(MessageMode mode) {
        this.mode = mode;
    }
    
    /** Getter for property justification.
     * @return Value of property justification.
     */
    public MessageJustification getJustification() {
        return this.justification;
    }
    
    /** Setter for property justification.
     * @param justification New value of property justification.
     */
    public void setJustification(MessageJustification justification) {
        this.justification = justification;
    }
    
    /** Getter for property enabled.
     * @return Value of property enabled.
     */
    public boolean isEnabled() {
        return this.enabled;
    }
    
    /** Setter for property enabled.
     * @param enabled New value of property enabled.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    /** Implementation method for the visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}



