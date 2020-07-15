package com.verifone.isd.xml.directives;

/**
 * Features defined by JEP 185: Restrict Fetching of External XML Resources.
 * Per the reference implementation, these may be set to instruct the
 * processor not to load external DTDs or resolve external entities.
 */
public class ParserConstants {
    
    private ParserConstants() {}    // Prevent instantiation
    
    public static final String APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL = "http://apache.org/xml/features/disallow-doctype-decl";  // Must set to true
    public static final String APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";    // Must set to false
    public static final String XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";     // Must set to false
    public static final String XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities"; // Must set to false
    
    /*
     * Attribute values for JAXP XMLConstants ACCESS_EXTERNAL_DTD, ACCESS_EXTERNAL_SCHEMA, ACCESS_EXTERNAL_STYLESHEET
     * Note: Additional values may be possible, these are just the ones observed in the documentation.
     */
    public static final String EXTERNAL_ACCESS_PROTOCOL_NONE = "";      // Deny access
    public static final String EXTERNAL_ACCESS_PROTOCOL_FILE = "file";  // Allow file-system access
    public static final String EXTERNAL_ACCESS_PROTOCOL_JAR = "jar";    // Allow access of jar files
    public static final String EXTERNAL_ACCESS_PROTOCOL_HTTP = "http";  // Allow http access
    public static final String EXTERNAL_ACCESS_PROTOCOL_ALL = "all";    // Allow all access (but you will regret it)
}
