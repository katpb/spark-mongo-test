/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verifone.isd.vsms2.sys.util.version;

import com.verifone.isd.vsms2.sys.util.DateTransformer;
import java.text.ParseException;

/**
 * Value object to represent a component that needs to be exposed
 * to end users as an entity being versioned.
 * @author Bhanu_A1
 */
public class VersionedComponent {
    private String componentUID;
    private String displayName;
    private String displayVersion;
    private String sourceHash;
    private String buildTimeStamp;
    
    private static final int NUM_FIELDS = 5;
    private static final int TIMESTAMP_FIELD = 5;
    
    private VersionedComponent(String[] fields) { 
        this.componentUID = fields[0];
        this.sourceHash = fields[1];        
        this.displayName = fields[2];
        this.displayVersion = fields[3];
        this.buildTimeStamp = fields[4];
    }

    /**
     * Getter for component's internal UID, as it is under source code control
     * @return the componentUID UID, the component's unique ID
     */
    public String getComponentUID() {
        return componentUID;
    }

    /**
     * Getter for component's user friendly name
     * @return the displayName, the component's display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Getter for component's user facing version
     * @return the displayVersion, component's version
     */
    public String getDisplayVersion() {
        return displayVersion;
    }

    /**
     * Getter for component's hash - useful to detect if a component has changed
     * @return the sourceHash hash computed for the component and its antecedents
     */
    public String getSourceHash() {
        return sourceHash;
    }

    /**
     * Getter for component build timestamp
     * @return the buildTimeStamp, time stamp in ISO format
     */
    public String getBuildTimeStamp() {
        return buildTimeStamp;
    }
    
    static VersionedComponent validateAndCreate(String[] fields) {
        if (fields != null && fields.length >= NUM_FIELDS) {
            int i = 0;
            for (; i < NUM_FIELDS; i++) {
                String curField = fields[i];
                if (curField == null || curField.trim().length() == 0) {
                    break;
                }
                if (i+1 == TIMESTAMP_FIELD) {
                    try {
                        new DateTransformer().transformISODateStringToDate(curField);
                    } catch (ParseException ex) {
                        break;
                    }
                }
            }
            if (i >= NUM_FIELDS) {
                return new VersionedComponent(fields);
            }
        } 
        return null;
    }
}
