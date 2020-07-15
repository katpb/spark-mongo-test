package com.verifone.isd.vsms2.sys.util.version;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Utility class to read the component list and to maintain the read list.
 * Based on the provided fully qualified file name for reading and based on the 
 * last modification timestamp of the file (if identical to what was read before),
 * the version objects will be refreshed.
 * @author Bhanu_A1
 */
public class ComponentListReader {
    public static final String DEFAULT_FILENAME = "componentList.txt";
    static final String FIELD_SEPARATOR = "@";
    private static String CUR_FILENAME;
    private static long LAST_MODIFIED;
    private static SortedMap<String, VersionedComponent> COMPONENTS = Collections.synchronizedSortedMap(new TreeMap<String, VersionedComponent> ()) ;
    
    /**
     * Retrieve all tracked components 
     * @return array of VersionedComponent[] instances, either of size 0 or more
     */
    public VersionedComponent[] getAll() {
        return COMPONENTS.values().toArray(new VersionedComponent[0]);
    }
    
    /**
     * Get a specific VersionedComponent, given its display name
     * @param displayName display name/ end user facing name of the component
     * @return required VersionedComponent or null
     */
    public VersionedComponent getByDisplayName(String displayName) {
        return COMPONENTS.get(displayName);
    }
    
    /**
     * Method to read version list details from a file with the specified
     * file name
     * @param fileName name of the file; if the file name is not fully qualified, 
     * it will just be assumed to be in the user's home directory
     * @throws IOException in case of file read errors
     */
    //Intentionally kept this logic out of constructor
    public void readVersionDetails(String fileName) throws IOException {
        refreshVersionDetails(fileName);
    }
    
    private static synchronized void refreshVersionDetails(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (file.exists()) {       
            boolean readFile = true;
            long lastModified = file.lastModified();
            if (CUR_FILENAME != null) {
                if (CUR_FILENAME.equals(fileName)) {
                    if (lastModified == LAST_MODIFIED) {
                        readFile = false;
                    }
                }
            }
            if (readFile) {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                    SortedMap <String, VersionedComponent> newComps =  new TreeMap<String, VersionedComponent> ();
                    boolean evaluateResult = false;
                    while (true) {
                        try {
                            String curLine = br.readLine();
                            if (curLine == null) {
                                evaluateResult = true;
                                break;
                            }
                            else {
                                String[] parts = curLine.split(FIELD_SEPARATOR);
                                VersionedComponent newComp = VersionedComponent.validateAndCreate(parts);
                                if (newComp != null) {
                                    String name = newComp.getDisplayName();
                                    newComps.put(name, newComp);
                                }
                            }

                        } catch (IOException ex) {
                            break;
                        }
                    }
                    if (evaluateResult && newComps.size() > 0) {
                        LAST_MODIFIED = lastModified;
                        CUR_FILENAME = fileName;
                        COMPONENTS.clear();
                        COMPONENTS.putAll(newComps);
                        newComps.clear();
                    }
                }
                finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException ex) {
                        }
                    }
                }
            }
        }
    }
}
