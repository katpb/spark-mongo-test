package com.verifone.isd.vsms2.sys.db.pres;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.xerces.parsers.SAXParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;

/**
 * Reads the entity data mappings from a file (persistDatasetMap.xml).
 * Currently, this class is using CM agent for data sync to Postgres DB, but in
 * future, this class may be helpful for providing CGI command(view/update) and
 * dataset name for a given dataset ID.
 * 
 */
public class ReferenceDatasetSystem {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferenceDatasetSystem.class);

	public static final String SUBCMD_SEPARATOR = "_";
	private static final String COMMON_CLASSMAP_FILE = "persistDatasetMap.xml";
	private static final String APP_CLASSMAP_FILE = "persistDatasetMap.xml";

	private static ReferenceDatasetSystem theInstance;
	// This map provides CGI command(view/update) and dataset name for a given
	// dataset ID.
	private Map<String, PersistenceDatasetMap> datasetMaps;
	// This map provides dataset ID,dataset name and view CGI command for a given
	// update CGI command.
	private Map<String, PersistenceDatasetMap> updateCMDMaps;

	private ReferenceDatasetSystem(String filename, String appFileName) {

		datasetMaps = new HashMap<String, PersistenceDatasetMap>();
		updateCMDMaps = new HashMap<String, PersistenceDatasetMap>();
		loadClassMappings(filename, appFileName);
	}

	public static synchronized ReferenceDatasetSystem getInstance() throws Exception {
		if (theInstance == null) {
			String commonFilename = null;
			commonFilename = SysPropertyFactory.makeAbsoluteCommonConfigPath(COMMON_CLASSMAP_FILE);

			String prop = SysPropertyFactory.getProperty("sys.db.persistDatasetMap", APP_CLASSMAP_FILE);
			String appFileName = SysPropertyFactory.makeAbsoluteConfigPath(prop);

			theInstance = new ReferenceDatasetSystem(commonFilename, appFileName);
		}
		return theInstance;

	}

	private void loadClassMappings(String file, String appFileName) {
		InputStreamReader fr = null;
		InputStreamReader afr = null;
		try {
			PersistenceDatasetMapHandler ch = new PersistenceDatasetMapHandler();
			fr = new InputStreamReader(new FileInputStream(file), "UTF-8");

			SAXFilter msf = new SAXFilter(new SAXParser(), ch);
			msf.parse(new InputSource(fr));

			File appFile = new File(appFileName);
			if (appFile.exists()) {
				afr = new InputStreamReader(new FileInputStream(appFile), "UTF-8");
				msf = new SAXFilter(new SAXParser(), ch);
				msf.parse(new InputSource(afr));
			}
			datasetMaps.putAll(ch.getDatasetMaps());
			updateCMDMaps.putAll(ch.getUpdateCmdMaps());

		} catch (Exception e) {
			LOGGER.error("Error loading class maps from file " + file + ": ",e);
		} finally {
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException ioe) {
				}
			}
			if (null != afr) {
				try {
					afr.close();
				} catch (IOException ioe) {
				}
			}
		}
	}

	/*
	 * This map provides CGI command(view/update) and dataset name for a given
	 * dataset ID.
	 */
	public Map<String, PersistenceDatasetMap> getDatasetMap() {
		return datasetMaps;
	}

	/*
	 * This map provides dataset ID,dataset name and view CGI command for a given
	 * update CGI command.
	 */
	public Map<String, PersistenceDatasetMap> getUpdateCmdMap() {
		return updateCMDMaps;
	}
}