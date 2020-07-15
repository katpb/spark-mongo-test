/*
 * SecurityCtrlPK.java
 *
 * Created on July 12, 2003, 10:55 PM
 */

package com.verifone.isd.vsms2.sys.ent.securityctrl;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 *
 * @author  BHANU NARAYANAN
 */
public class SecurityCtrlPK implements IEntityPK {
    static final long serialVersionUID = -4070256954345034854L;   
    private String menuId;
    private String subMenuId;
    
    /** Creates a new instance of UserPK */
    public SecurityCtrlPK() {
    }
    
    public SecurityCtrlPK(String menuId, String subMenuId) {
        this.menuId = menuId;
        this.subMenuId = subMenuId;
    }
    
    /** Compares another primary key for equality
     * @param obj primary key to be compared for equality
     * @return true if both objects are equal
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof SecurityCtrlPK) {
            SecurityCtrlPK aObj = (SecurityCtrlPK)obj;
            return (this.menuId.equals(aObj.menuId) && this.subMenuId.equals(aObj.subMenuId));
        }
        return false;            
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    }    
    
    /** Method to validate a primary key
     * @return true if the primary key is valid
     */
    public boolean isValid() {
        return (this.menuId  != null && !this.menuId.trim().equals("") &&
        this.subMenuId  != null && !this.subMenuId.trim().equals(""));
    }
    
    public String[] getValue() {
        String[] vals = new String[2];
        vals[0] = this.menuId;
        vals[1] = this.subMenuId;
        return vals;
    }
    
    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return this.menuId +" " +this.subMenuId;
    }      
    
    public String getMenuId() {
        return this.menuId;
    }
    
    public String getSubMenuId() {
        return this.subMenuId;
    }
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.menuId == null) ? 0 : this.menuId.hashCode()) 
        + ((this.subMenuId == null) ? 0 : this.subMenuId.hashCode());
    }          
}
