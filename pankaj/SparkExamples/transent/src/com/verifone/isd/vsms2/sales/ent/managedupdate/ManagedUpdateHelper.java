package com.verifone.isd.vsms2.sales.ent.managedupdate;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for Managed Update Process
 * @author T_ShailendraP1
 *
 */
public class ManagedUpdateHelper {
	private static Logger logger = LoggerFactory.getLogger(ManagedUpdateHelper.class);
	
	/**
	 * private constructor
	 */
	private ManagedUpdateHelper(){
		
	}
	
	private static class ManagedUpdateHelperInstance{
        private static final ManagedUpdateHelper INSTANCE = new ManagedUpdateHelper();
    }
	
	/**
	 * gets singleton instance
	 * @return
	 */
    public static ManagedUpdateHelper getInstance(){
        return ManagedUpdateHelperInstance.INSTANCE;
    }
	
	/**
	 * Comparator class to get files in order
	 * @author T_ShailendraP1
	 *
	 */
	private static class FileComparator implements Comparator<File>,Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(File first, File second) {
			int f1=Integer.parseInt(first.getName().substring(0, first.getName().indexOf(ManagedUpdateConstant.DELEMETER)));
			int f2=Integer.parseInt(second.getName().substring(0, second.getName().indexOf(ManagedUpdateConstant.DELEMETER)));
			if(f1>f2){
				return 1;
			}else if(f1<f2){
				return -1;
			}else{
				return 0;
			}
		}	
	}
	
	/**
	 * File Filter to get only xml file from the directory
	 * @author T_ShailendraP1
	 *
	 */
	private static class XMLFileFilter implements FilenameFilter{

		@Override
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".xml")) {
					return true;
				} else {
					return false;
				}
			}
	}
	
	/**
	 * Method to get all the files in order in a certain directory
	 * @param rootPath
	 * @return
	 */
	public File[] getPendingFilesInOrder(File rootPath){
		File[] files=rootPath.listFiles(new XMLFileFilter());
		Arrays.sort(files,new FileComparator());
		return files;
	}
		
	/**
	 * Method to stage Files in a specific directory providing a Running sequence number
	 * @param rootPath
	 * @param tempFile
	 * @param managedDataSet
	 */
	public synchronized void stageFile(File rootPath,File tempFile,ManagedDataSet managedDataSet){
		int seq=0;
		File[]  listOfFiles=getPendingFilesInOrder(rootPath);
		synchronized (this) {
			if(listOfFiles==null || listOfFiles.length==0){
				seq=1;
			}else{
				String lastFileName=listOfFiles[listOfFiles.length-1].getName();
				int indexOfDel=lastFileName.indexOf("-");
				String seqNum=lastFileName.substring(0, indexOfDel);
				seq = Integer.parseInt(seqNum)+1;
			}
		    File actFile =new File(ManagedUpdateConstant.ROOT_PATH.getAbsolutePath()+ File.separatorChar+seq+ManagedUpdateConstant.DELEMETER+managedDataSet+ ".xml");	    
			if(!tempFile.renameTo(actFile)){
			logger.error("Error Moving file "+ tempFile.getName() +"from Temp directory");	
			}else{
				logger.info("File "+actFile.getName()+" created to stage configuration of size :"+(actFile.length()/(double)(1024*1024))+" MB");
			}
		}
	}
	
}
