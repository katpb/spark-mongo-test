/*
 * ModuleRes.java
 *
 * COPYRIGHT (c) 2000-2011 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */

package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * Resource bundle for all Managed Module related strings.  This is the
 * abbreviated class name bundle.
 * 
 * @see ModuleRes
 * 
 * @author Joe_H5
 */
public class ModuleRes extends ListResourceBundle {
    public static final String MODULE_NAME;
    public static final String ERRORS_READING_FILE;
    public static final String ERRORS_PARSING_FILE;
    public static final String MODULE_NOT_EXIST;
    public static final String CONFIGURATIONS_NOT_INITIALIZED;
    public static final String DEFINITION_NOT_EXIST;
    public static final String CONFIG_NOT_EXIST;
    public static final String PROP_NOT_EXIST;
    public static final String PROP_MISMATCH;
    public static final String XMLPARSER_CREATERR;
    public static final String VALID_PROPERR;
    public static final String CONFIG_PROPERR;
    public static final String ASSIGNED_ERR;
    public static final String UNREGISTERED_ERR;
    public static final String INVALID_PORTALCMD;
    public static final String CONFIGPROP_NOEXIST;
    public static final String CONFIGPROP_INVALID;
    public static final String FUEL_INVALID_PORT_ASSIGN;
    public static final String DCR_INVALID_PORT_ASSIGN; 
    public static final String DCR_INVALID_POSITION_ASSIGN;
    public static final String TANK_INVALID_PORT_ASSIGN; 
    public static final String DCR_UNASSIGN_POSITIONS_FIRST;
    public static final String DCR_POSITIONS_THRESHOLD;
    public static final String ESIGN_UNASSIGN_PORT;
    public static final String ESIGN_ASSIGN_PORT;
    public static final String MO_FEATURE_DISABLED;
    public static final String ASSIGN_WHILE_DISABLED;
    public static final String NOASSIGN_WHEN_ENABLED;
    public static final String NO_JPOS_ENTRY;
    public static final String INVALID_XML_DOCUMENT;
    public static final String DCR_INVALID_IP_ASSIGN;
    public static final String DCR_IP_AND_SERIAL_ASSIGNED;
    public static final String ENABLED_WHEN_CHANGING;
    public static final String INVALID_URI;


    static
    {
        
        MODULE_NAME = "MODULE_NAME";
        ERRORS_READING_FILE = "ERRORS_READING_FILE";
        ERRORS_PARSING_FILE = "ERRORS_PARSING_FILE";
        MODULE_NOT_EXIST = "MODULE_NOT_EXIST";
        CONFIGURATIONS_NOT_INITIALIZED = "CONFIGURATIONS_NOT_INITIALIZED";
        DEFINITION_NOT_EXIST = "DEFINITION_NOT_EXIST";
        CONFIG_NOT_EXIST = "CONFIG_NOT_EXIST";
        PROP_NOT_EXIST = "PROP_NOT_EXIST";
        PROP_MISMATCH = "PROP_MISMATCH";
        XMLPARSER_CREATERR = "XMLPARSER_CREATERR";
        VALID_PROPERR = "VALID_PROPERR";
        CONFIG_PROPERR = "CONFIG_PROPERR";
        ASSIGNED_ERR = "ASSIGNED_ERR";
        UNREGISTERED_ERR = "UNREGISTERED_ERR";
        INVALID_PORTALCMD = "INVALID_PORTALCMD";
        CONFIGPROP_NOEXIST = "CONFIGPROP_NOEXIST";
        CONFIGPROP_INVALID = "CONFIGPROP_INVALID";
        FUEL_INVALID_PORT_ASSIGN = "FUEL_INVALID_PORT_ASSIGN";
        DCR_INVALID_PORT_ASSIGN = "DCR_INVALID_PORT_ASSIGN";
        DCR_INVALID_POSITION_ASSIGN = "DCR_INVALID_POSITION_ASSIGN";
        TANK_INVALID_PORT_ASSIGN = "TANK_INVALID_PORT_ASSIGN";
        DCR_UNASSIGN_POSITIONS_FIRST = "DCR_UNASSIGN_POSITIONS_FIRST";
        DCR_POSITIONS_THRESHOLD = "DCR_POSITIONS_THRESHOLD";
        ESIGN_UNASSIGN_PORT = "ESIGN_UNASSIGN_PORT";
        ESIGN_ASSIGN_PORT = "ESIGN_ASSIGN_PORT";
        MO_FEATURE_DISABLED= "MO_FEATURE_DISABLED";
        ASSIGN_WHILE_DISABLED= "ASSIGN_WHILE_DISABLED";
        NOASSIGN_WHEN_ENABLED= "NOASSIGN_WHEN_ENABLED";
        NO_JPOS_ENTRY = "NO_JPOS_ENTRY";
        INVALID_XML_DOCUMENT = "INVALID_XML_DOCUMENT";
        ENABLED_WHEN_CHANGING =  "ENABLED_WHEN_CHANGING";
        DCR_INVALID_IP_ASSIGN= "DCR_INVALID_IP_ASSIGN";
        DCR_IP_AND_SERIAL_ASSIGNED= "DCR_IP_AND_SERIAL_ASSIGNED";
        INVALID_URI="INVALID_URI";
    };

	static private final Object[][] contents = {
        { MODULE_NAME  ,  "Module Name"},
        { ERRORS_READING_FILE, "Errors reading XML Document!"},
        { ERRORS_PARSING_FILE, "Errors parsing XML document!"},
        { MODULE_NOT_EXIST, "Module named ''" + "{0}" + "'' does not exist!"},
        { CONFIGURATIONS_NOT_INITIALIZED, "Module configurations have not been initialized!"},
        { DEFINITION_NOT_EXIST, "Module definition for ''" + "{0}" + "'' does not exist!"},
        { CONFIG_NOT_EXIST, "Module configuration ''" + "{0}" + "'' does not exist!"},
        { PROP_NOT_EXIST, "Property ''" + "{0}" + "'' for module ''" + "{1}" + "'' does not exist!"},
        { PROP_MISMATCH, "Property ''" + "{0}" + "'' type mistmatch for module ''" + "{1}" + "''!"},
        { XMLPARSER_CREATERR, "Error encountered creating XML parser!"},
        { VALID_PROPERR, "Module validation failed for property ''" + "{0}" + "''!"},
        { CONFIG_PROPERR, "Error encountered configuring module property '" + "{0}" + "''!"},
        { ASSIGNED_ERR, "System resource ''" + "{0}" + "'' already assigned!"},
        { UNREGISTERED_ERR, "Module ''" + "{0}" + "'' has not been registered and is not configurable!"},
        { INVALID_PORTALCMD, "Invalid command request - ''" + "{0}" + "''!"},
        { CONFIGPROP_NOEXIST, "Config property ''" + "{0}" + "'' is not specified!"},
        { CONFIGPROP_INVALID, "Config property ''" + "{0}" + "'' specifies invalid value ''" + "{1}" + "''!"},
        { FUEL_INVALID_PORT_ASSIGN, "Serial Port cannot be assigned to a Fuel Channel which is NOT Enabled!"},
        { DCR_INVALID_PORT_ASSIGN, "Serial Port cannot be assigned to a DCR Channel which is NOT Enabled!"},
        { DCR_INVALID_POSITION_ASSIGN, "Position cannot be assigned to a DCR Channel which is NOT Enabled!"},
        { TANK_INVALID_PORT_ASSIGN, "Please assign Serial Port to TANK!"},
        { DCR_UNASSIGN_POSITIONS_FIRST, "DCR Positions are still assigned to this Channel! Unassign them first."},
        { DCR_POSITIONS_THRESHOLD, "Cannot assign MORE than ''{0}'' DCR Positions to Channel-''{1}''!"},
        { ESIGN_UNASSIGN_PORT, "Please Un-Assign Port!. Device Type is configured as 'NONE'."},
        { ESIGN_ASSIGN_PORT, "Please Assign Port to Fuel Price Display!"},
        { MO_FEATURE_DISABLED,"Money Order feature not enabled."},
        { ASSIGN_WHILE_DISABLED,"Cannot assign port when module is disabled."},
        { NOASSIGN_WHEN_ENABLED,"Please assign a port when enabling module."},
        { NO_JPOS_ENTRY, "No JPOS Entry named {0} to configure!"},
        { INVALID_XML_DOCUMENT, "XML Document parsing or processing has failed!"},
        { DCR_INVALID_IP_ASSIGN,"IP cannot be enabled on a DCR channel which is NOT Enabled!"},
        { DCR_IP_AND_SERIAL_ASSIGNED,"Serial Port cannot be assigned to a DCR Channel which has IP Enabled!"},
        { ENABLED_WHEN_CHANGING, "Please disable ''{0}'' feature when changing properties!"},
        { INVALID_URI, "URI resource string ''{0}'' is invalid" }
    };

    @Override
    protected Object[][] getContents()
    {
        return contents;
    }
}
