package com.verifone.isd.vsms2.sys.util.sax;

import java.io.File;

import org.apache.xml.serialize.XMLSerializer;

/**
 * Interface to facilitate saving of the imported configuration in a file through Managed Update process
 * This Configuration can be applied by the POS user by Apply Update function
 * @author T_ShailendraP1
 *
 */
public interface IManagedUpdateSaxContentHandler  {

	/**
	 * Sets the XMLSerializer for Serializing the payload
	 * @param serializer
	 */
	public void setSerializer(XMLSerializer serializer);
	
	/**
	 * Get the Root Path of the file to save
	 * @return
	 */
	public File getRootPath();
	
	/**
	 * skips the DB Update if present
	 * @param skipDbUpdate
	 */
	public void setSkipDbUpdate(boolean skipDbUpdate);

	/**
	 * gets the root Element Name for the input XML
	 * @return
	 */
	public String getRootElementName();

	/**
	 * Process the File save 
	 * @param tempFile
	 */
	public void saveFile(File tempFile);
	
	
	/**
	 * Returns the Exception to ignore at the time of saving the update file, But thrown to notify users
	 * @return Exception
	 */
	public Exception getIgnoredException();

}
