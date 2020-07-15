
package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Helper class that provides entity data for a given entity object. More
 * precisely, it gives a mapping between the entity IDs and the CGI commands(v/u commands).
 */
public class PersistenceDatasetMap {
    private int id;
    private String dataset;
    private String subcmd;   
    
    private String viewCommand;
    private String updateCommand;
    
    
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dataset
	 */
	public String getDataset() {
		return dataset;
	}
	/**
	 * @param dataset the dataset to set
	 */
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}
	
	/**
	 * @return the viewCommand
	 */
	public String getViewCommand() {
		return viewCommand;
	}
	/**
	 * @param viewCommand the viewCommand to set
	 */
	public void setViewCommand(String viewCommand) {
		this.viewCommand = viewCommand;
	}
	/**
	 * @return the updateCommand
	 */
	public String getUpdateCommand() {
		return updateCommand;
	}
	/**
	 * @param updateCommand the updateCommand to set
	 */
	public void setUpdateCommand(String updateCommand) {
		this.updateCommand = updateCommand;
	}
	/**
	 * @return the subcmd
	 */
	public String getSubcmd() {
		return subcmd;
	}
	/**
	 * @param subcmd the subcmd to set
	 */
	public void setSubcmd(String subcmd) {
		this.subcmd = subcmd;
	}
      
    
}
