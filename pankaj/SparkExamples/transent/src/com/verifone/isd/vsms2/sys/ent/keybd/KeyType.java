package com.verifone.isd.vsms2.sys.ent.keybd;

/**
 * Serializable typesafe enum class to represent key types
 * @author  Bhanu_N2
 */
public class KeyType implements java.io.Serializable {
    static final long serialVersionUID = 758017298505663246L;
    private transient String name;
    private transient boolean unpender;
    private transient int keyConstValue;
    
    /** Private constructor - do not allow subclassing
     * @param name key type's name
     * @param unpender true if the key type represents an unpender
     * @param keyConstValue literal value of the keytype
     */
    private KeyType(String name,  boolean unpender, int keyConstValue) {
        this.name = name;
        this.unpender = unpender;
        this.keyConstValue = keyConstValue;
    }
    
    /** Override toString() method to provide the transaction type's name
     * @return transaction type's name
     */    
    public String toString() {
        return this.name;
    }
    
    /** 
     * Getter for property 'unpender'
     * @return true if the key type represents an unpender
     */      
    public boolean isUnpender() {
        return this.unpender;
    }
    
    /** 
     * Getter for property 'key constant'
     * @return the key constant value associated with the key type
     */    
    public int getKeyConstant() {
        return this.keyConstValue;
    }
    /** 
     * Not required since constructor is private. Just in case.. 
     * Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    /** 
     * Not required since constructor is private. Just in case.. 
     * Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * KeyType to represent a character; the character data is variable and is not specified in this object
     */    
    public static KeyType CHARACTER  = new KeyType("CHARACTER", false, SoftKeyConstants.KB_KEY_UNASSIGNED);
    /**
     * KeyType to represent 'Error Correct'
     */    
    public static KeyType CORR  = new KeyType("CORR", true, SoftKeyConstants.KB_FCT_ECORR);    
    /**
     * KeyType to represent 'Enter' key
     */    
    public static KeyType ENTER  = new KeyType("ENTER", true, SoftKeyConstants.KB_FCT_ENTER);    
    /**
     * KeyType to represent 'Exit' key
     */    
    public static KeyType EXIT  = new KeyType("EXIT", true, SoftKeyConstants.KB_FCT_EXIT);      
    /**
     * KeyType to represent 'Clear' key
     */    
    public static KeyType CLEAR  = new KeyType("CLEAR", true, SoftKeyConstants.KB_FCT_CLEAR);    
    /**
     * KeyType to represent 'Double Zero' key
     */    
    public static KeyType DBLZERO  = new KeyType("DBLZERO", true, SoftKeyConstants.KB_NUM_00);     
    /**
     * KeyType to represent a soft key; the soft key id and data are variable; they are not specified in this object
     */    
    public static KeyType SOFTKEY  = new KeyType("SOFTKEY", true, SoftKeyConstants.KB_KEY_UNASSIGNED); 
    /**
     *  KeyType to represent 'Left Arrow' key
     */    
    public static KeyType LEFT  = new KeyType("LEFT", true, SoftKeyConstants.KB_FCT_ARROW_LEFT);     
    /**
     *  KeyType to represent 'Right Arrow' key
     */    
    public static KeyType RIGHT  = new KeyType("RIGHT", true, SoftKeyConstants.KB_FCT_ARROW_RIGHT);    
    /**
     *  KeyType to represent 'Select' key
     */    
    public static KeyType SELECT  = new KeyType("SELECT", true, SoftKeyConstants.KB_FCT_SELECT);    
    /**
     *  KeyType to represent 'List' key
     */    
    public static KeyType LIST  = new KeyType("LIST", true, SoftKeyConstants.KB_FCT_LIST);  
    /**
     *  KeyType to represent 'Shift' key
     */    
    public static KeyType SHIFT  = new KeyType("SHIFT", false, SoftKeyConstants.KEY_SHIFT_MODE);    
    /**
     *  KeyType to represent 'Backspace' key
     */    
    public static KeyType BACKSPACE  = new KeyType("BACKSPACE", false, SoftKeyConstants.KEY_EDIT_BS);  
    /**
     *  KeyType to represent 'Yes' key
     */    
    public static KeyType YES  = new KeyType("YES", true, SoftKeyConstants.KB_FCT_YESKEY); 
    /**
     *  KeyType to represent 'No' key
     */    
    public static KeyType NO  = new KeyType("NO", true, SoftKeyConstants.KB_FCT_NOKEY);         
    /**
     *  KeyType to represent an undefined key
     */    
    public static KeyType UNDEFINED = new KeyType("UNDEFINED", true, SoftKeyConstants.KB_KEY_UNASSIGNED);
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //security level type; auto-incremented
    private static final KeyType[] VALUES = {
        CHARACTER, CORR, ENTER, EXIT, CLEAR, DBLZERO, SOFTKEY, LEFT, RIGHT, SELECT, LIST, SHIFT, BACKSPACE, YES, NO, UNDEFINED
    };
    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }     
    
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }    
    
    /** Method to get the KeyType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return KeyType object representing the ordinal
     */
    public static final KeyType getObject(int ordinal) {
        return VALUES[ordinal];
    }   
    
    /**
     * Static getter based on the key type name
     * @param name key type name
     * @return KeyType object
     */    
    public static final KeyType getObjectFromName(String name) {
        KeyType reqdVal = null;
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i].name.equals(name)) {
                reqdVal = VALUES[i];
                break;
            }
        }
        return reqdVal;
    }
}
