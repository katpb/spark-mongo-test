package com.verifone.isd.vsms2.sys.db.pres;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;

/**Content handler to parse entity ID and its CGI Commands.*/

public class PersistenceDatasetMapHandler extends SAXContentHandler {
	
	/** The logger. */
    private Logger logger
            = LoggerFactory.getLogger(PersistenceDatasetMapHandler.class);
	
	private static final int FAULT = -1;
    private static final int DOCUMENT = FAULT + 1;
    private static final int ROOT_ELEM = DOCUMENT +1;
    private static final int ENTITY_DATA_ELEM = ROOT_ELEM +1;
    private static final int VIEW_COMMAND_ELEM= ENTITY_DATA_ELEM +1;
    private static final int UPDATE_COMMAND_ELEM = VIEW_COMMAND_ELEM +1;
    
    private static final String EMPTY_STRING    = "";
    private static final String ROOT_ELEMENT    = "persistDatasetMap";
    private static final String ENTITY_DATA     = "entityData";    
    private static final String SYS_ID          = "sysid";
    private static final String DATA_SET        = "dataset"; 
    private static final String SUB_CMD        = "subcmd"; 
    private static final String VIEW_COMMAND    = "viewcommand";
    private static final String UPDATE_COMMAND  = "updatecommand";
    
    
    private int currentElement = FAULT;
    //This map provides CGI command(view/update) and dataset name for a given dataset ID.
    public Map <String,PersistenceDatasetMap> datasetMap;
    //This map provides dataset ID,dataset name and view CGI command for a given update CGI command.
    public Map <String,PersistenceDatasetMap> updateCmdMap;
    
    public PersistenceDatasetMap perDataMap;
    public StringBuffer strBuf;
      
    
    public PersistenceDatasetMapHandler() {      
        this.datasetMap = new HashMap <String, PersistenceDatasetMap>();
        this.updateCmdMap=new HashMap <String, PersistenceDatasetMap>();
    }

    
    public void startElement(String uri, String localName, String qName,
    	    Attributes attrs) throws SAXException {

        boolean isInvalidState = false;
        switch (this.currentElement) {
            case FAULT:
            case DOCUMENT:
                if (localName.equals(ROOT_ELEMENT)) {
                    this.currentElement = ROOT_ELEM;
                }
                else {
                    isInvalidState = true;
                }
                break;
                
            case ROOT_ELEM: 
                if (localName.equals(ENTITY_DATA)) {                
                    this.currentElement = ENTITY_DATA_ELEM;
                    int id = Integer.parseInt(attrs.getValue(EMPTY_STRING, SYS_ID));
                    String dataset = attrs.getValue(EMPTY_STRING, DATA_SET);
                    String subcommand = attrs.getValue(EMPTY_STRING, SUB_CMD);                    
                    perDataMap = new PersistenceDatasetMap();
                    perDataMap.setId(id);
                    perDataMap.setDataset(dataset); 
                    perDataMap.setSubcmd(subcommand);
                    logger.debug("dataset values message - {}",perDataMap);                   
               
                    }
              else {
                    isInvalidState = true;
                }             
                break;
                
            case ENTITY_DATA_ELEM:
            	if (localName.equals(VIEW_COMMAND)) {
				this.currentElement = VIEW_COMMAND_ELEM;
			} else if (localName.equals(UPDATE_COMMAND)) {
				this.currentElement = UPDATE_COMMAND_ELEM;
			} 
                break;

           
        }
        if (!isInvalidState
				&& ((this.currentElement == VIEW_COMMAND_ELEM)
						|| (this.currentElement == UPDATE_COMMAND_ELEM))) {
			this.strBuf = new StringBuffer();
		}
    
    }
    
    @Override
    public void endElement(String uri,String localName,String qName) throws SAXException {	

        try {
            switch(this.currentElement) {
                case DOCUMENT:
                case ROOT_ELEM:
                    this.currentElement = FAULT;
                    break;
                    
                case ENTITY_DATA_ELEM:
                	if (localName.equals(ENTITY_DATA)) {
						this.currentElement = ROOT_ELEM;
					}
                	if(perDataMap.getDataset()!=null){
                		datasetMap.put(perDataMap.getDataset(), perDataMap);
                	}
                	if(perDataMap.getUpdateCommand()!=null){
                		updateCmdMap.put(perDataMap.getUpdateCommand(), perDataMap);
                	}         

					break;
                    
                case VIEW_COMMAND_ELEM:                 
                    	logger.info("END ELEMENT STARTED");
                        String viewCommand = this.strBuf.toString().trim();
                        perDataMap.setViewCommand(viewCommand);
                        logger.debug("view set  values message - {} ,{}",viewCommand,perDataMap);
                        
                        this.currentElement =ENTITY_DATA_ELEM;
               
                    break;
                    
                case UPDATE_COMMAND_ELEM:                                 
                        String updateCommand = this.strBuf.toString().trim();
                        perDataMap.setUpdateCommand(updateCommand);
                        logger.debug("update set  values message - {}, {}",updateCommand,perDataMap);
                        this.currentElement =ENTITY_DATA_ELEM;
                                    
                    break;     
            }
          
        }      
        catch (Exception e) {
            throw new SAXException(e);
        }
    
    }   
    
    public void characters(char[] ch, int start, int length) {
        if (currentElement == VIEW_COMMAND_ELEM || currentElement == UPDATE_COMMAND_ELEM) {
            this.strBuf.append(ch, start, length);
        }
    }
    
	/**
	 * This map provides CGI command(view/update) and dataset name for a given
	 * dataset ID.
	 */
    public Map <String, PersistenceDatasetMap> getDatasetMaps() {
        return this.datasetMap;
    }
    
	/**
	 * This map provides dataset ID,dataset name and view CGI command for a given
	 * update CGI command.
	 */
    public Map <String, PersistenceDatasetMap> getUpdateCmdMaps() {
        return this.updateCmdMap;
    }
}
