/////////////////////////////////////////////////////////////////////////////////////////
// Copyright:  This software is the copyright of Verifone, Inc.
// and the information therein may be the subject of a pending or granted
// patent. It may not be reproduced or used for any other purpose than that
// for which it is supplied without the written permission of Verifone, Inc.
// (c) VERIFONE, INC 2013, 2018
///////////////////////////////////////////////////////////////////////////////////////

package com.verifone.isd.vsms2.sys.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (c) 2012, 2013, 2018, VeriFone INC. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * 
 * <p>This contains a variety of utility functionalities that RSD agent and Cloud agent require.  
 * <p>File Management
 * 
 * @author  iGentechnologies,Inc.
 * @modified Tom Therrien
 * @modified David Godwin -- move to common utility package
 * @since   1.0
 * 
 */

public class AgentFileUtility {
	
	private static Logger logger = LoggerFactory.getLogger(AgentFileUtility.class);
	
	/*-------------------------FILE UTILITY---------------------------------*/
	/**
	 * Write to file.
	 *
	 * @param file the file
	 * @param content the content
	 * @return the file
	 */
	public static File writeToFile(File file, String content){
		FileOutputStream fstream = null;
		BufferedWriter out = null;
		try{
			fstream = new FileOutputStream(file);
			out = new BufferedWriter(new OutputStreamWriter(fstream, StringUtils.UTF8_CHARSET_STR));
			out.write(content);
			out.flush();
		}
		catch(Exception e){
			logger.error("RSD Exception, writing file: " + e.getLocalizedMessage(), e);
		}
		finally{
			FileUtil.closeResource(out);
			FileUtil.closeResource(fstream);
		}
		
		return file;
	}
	
	
	/**
	 * Gets the file size.
	 *
	 * @param filePath the file path
	 * @return the file size
	 */
	public static long getFileSize(String filePath){
		File file = new File(filePath);
		return file.length();
	}
	
	/**
	 * Gets the file size.
	 *
	 * @param file the file
	 * @return the file size
	 */
	public static long getFileSize(File file){
		return file.length();
	}
		
	/**
	 * Gets the extension name.
	 *
	 * @param fileName the file name
	 * @return the extension name
	 */
	public static String getExtensionName(String fileName){
		int ndx = fileName.lastIndexOf(".");
		if (ndx < 0)
			return "";
		return fileName.substring(ndx);
	}
	
	/**
	 * Gets the extension name.
	 *
	 * @param file the file
	 * @return the extension name
	 */
	public static String getExtensionName(File file){
		String fileName = file.getName();
		int ndx = fileName.lastIndexOf(".");
		if (ndx < 0)
			return "";
		return fileName.substring(ndx);
	}
	
	/**
	 * Gets the base name.
	 *
	 * @param filename the filename
	 * @return the base name
	 */
	public static String getBaseName(String filename){
		File f = new File(filename);
		int ndx = f.getName().lastIndexOf(".");
		if (ndx < 0)
			return "";
		String baseName = f.getName().substring(0, ndx);
		return baseName;
	}
	
	/**
	 * Rename file unless the file's current path and name matches the new name, in which case do nothing.
	 *
	 * @param srcFile the base file
	 * @param newFileName the new file name
	 * @return the string or null on error
	 */
	public static String renameFile(File srcFile, String newFileName){
		String filename = null;
		try{
			if(srcFile.exists()){
				File destFile = new File(srcFile.getAbsolutePath().replace(srcFile.getName(), newFileName));
				if (!(srcFile.getCanonicalPath().equals(destFile.getCanonicalPath()))) {
					/*
					 * Unlike file.renameTo(), this can copy file across Linux partitions.
					 * However, also unlike renameTo(), it fails if renaming the file to the *same* file name,
					 * so we must guard against that condition by adding the the test above.
					 */
					FileUtils.moveFile(srcFile, destFile);		// 
				}
				filename = destFile.getAbsolutePath();
				logger.info("RSD Renamed file, " + srcFile.getAbsolutePath() + " to " + destFile);
			}
			else{
				logger.error("RSD File, " + srcFile.getAbsolutePath() + " does not exist");
				filename = null;
			}
		}
		catch(IOException e){
			filename = null;
			logger.error("RSD Exception, renaming \"" + srcFile.getPath() + "\": " + e.getLocalizedMessage(), e);
		}
		return filename;
	}
	
	/**
	 * Read file.
	 *
	 * @param fileName the file name
	 * @return the string
	 */
	public static String readFile(String fileName){
		StringBuffer contents = new StringBuffer();
		if (AgentFileUtility.isFileExist(fileName, true)){
			logger.debug("RSD file exists, " + fileName);
			try{
				File file = new File(fileName);
				//StringBuffer contents = new StringBuffer();
				BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file), StringUtils.UTF8_CHARSET_STR));
				try{
					String line = null;
					while((line=input.readLine())!=null){
						contents.append(line+" ");
						//contents.append(System.getProperty("line.separator"));
					}
				}
				finally{
					input.close();
				}
			}
			catch(Exception e){
				logger.error("RSD Exception, reading file: " + e.getLocalizedMessage(), e);
			}
		}
		//logger.info("RSD FILECONTENTS: " + contents.toString());
		return contents.toString();
	}
	
	/**
	 * Copy directory.
	 *
	 * @param sourceDir the source dir
	 * @param destDir the dest dir
	 * @param deleteFlag the delete flag
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copyDirectory(File sourceDir, File destDir, boolean deleteFlag) throws IOException{
		logger.debug("RSD IN COPY DIRECTORY");
		if(!destDir.exists()){
			if (destDir.mkdir() == false) {
				logger.error("RSD could not create directory: " + destDir.getPath());
				return;
			}
		}
		File [] file_children = sourceDir.listFiles();
		if (file_children != null) {
			for (int i=0; i<file_children.length; i++){
				File sourceChild = file_children[i];
				String fileName = sourceChild.getName();
				File destChild = new File(destDir, fileName);
				if(sourceChild.isDirectory()){
					copyDirectory(sourceChild, destChild, false);
				}
				else{
					copyFile(sourceChild, destChild);
				}
				
				if(deleteFlag){
					boolean del_result = deleteFile(sourceChild);
					if (!del_result)
						logger.warn("RSD Unable to delete " + sourceChild.getPath());
				}
			}
		}
	}
	
	/**
	 * Copy file.
	 *
	 * @param source the source
	 * @param destination the destination
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copyFile(File source, File destination) throws IOException{	
		InputStream input = null;
		OutputStream output = null;
		try{
			if(!destination.exists()){
				if (destination.createNewFile() == false) {
					logger.error("RSD could not create file: " + destination.getPath());
				}
			}
			input = new FileInputStream(source);
			output = new FileOutputStream(destination);
			
			byte[] BUFFER = new byte[input.available()]; //former=1024
			
			
			int len;
			
			while((len=input.read(BUFFER))>0){
				output.write(BUFFER, 0, len);
			}
		}
		catch(Exception e){
			logger.error("RSD Exception, copying file: " + e.getLocalizedMessage(), e);
		}
		finally{
			FileUtil.closeResource(input);
			FileUtil.closeResource(output);
		}
	}
	
	/**
	 * Delete dir contents.
	 *
	 * @param source the source
	 * @param quiet do not log normal operation unless debug level is active
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void deleteDirContents(File source, boolean quiet) throws IOException{
		boolean isSuccess = false;

		String[] children = source.list();
		if (children != null) {
			for (int i=0; i<children.length; i++) {
				File subFile = new File(source, children[i]);
				if (subFile.isFile()){
					isSuccess = AgentFileUtility.deleteFile(subFile, quiet);
				}
				else if (subFile.isDirectory()){
					isSuccess = AgentFileUtility.deleteDirectory(subFile);
				}

				if (!isSuccess){
					logger.error("RSD Error trying to remove \"" + subFile.getAbsolutePath() + "\"");
				}
			}
		}
	}
	
	/**
	 * Delete dir contents.
	 *
	 * @param source the source
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void deleteDirContents(File source) throws IOException{
		deleteDirContents(source, false);
	}
	
	/**
	 * Delete file.
	 *
	 * @param file the file
	 * @param quiet do not log normal operation unless debug level is active
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean deleteFile(File file, boolean quiet) throws IOException{
		boolean isSuccess = false;
		
		logger.debug("RSD Deleting file: " + file.getAbsolutePath() + " (exists: " + file.exists() + ", isFile: " + file.isFile() + ")");
		if(file.isFile()){
			if ((!quiet) || (logger.isDebugEnabled()))
				logger.info("RSD Deleting existing file: " + file.getAbsolutePath());
			isSuccess = file.delete();
			if (!isSuccess)
				logger.warn("RSD  unable to delete file: " + file.getAbsolutePath());
		}
		return isSuccess;
	}
	
	/**
	 * Delete file.
	 *
	 * @param file the file
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean deleteFile(File file) throws IOException{
		return deleteFile(file, false);
	}
	
	/**
	 * Delete directory.
	 *
	 * @param dir the dir
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean deleteDirectory(File dir) throws IOException{
		boolean isSuccess = false; 
		
		if (dir.isDirectory()) {
			String[] children = dir.list();
			if (children != null) {
				for (int i=0; i<children.length; i++) {
					File subFile = new File(dir, children[i]);
					if (subFile.isFile()){
						isSuccess = AgentFileUtility.deleteFile(subFile);
					}
					else if (subFile.isDirectory()){
						isSuccess = AgentFileUtility.deleteDirectory(subFile);
					}

					if (! isSuccess){
						return isSuccess;
					}
				}
			}
			isSuccess = dir.delete();
		}
		
		return isSuccess;
	}
	
	/**
	 * Copy files.
	 *
	 * @param sourceDir the source dir
	 * @param destinationDir the destination dir
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean copyFiles(File sourceDir, File destinationDir)throws IOException{
		logger.debug("RSD IN COPY DIRECTORY CONTENTS");
		int copyCount = 0;
		boolean isCopied = false;
		if(!destinationDir.exists()){
			if (destinationDir.mkdir() == false) {
				logger.error("RSD could not create directory: " + destinationDir.getPath());
				return false;
			}
		}
		File [] file_children = sourceDir.listFiles();
		if (file_children != null) {
			for (int i=0; i<file_children.length; i++){
				String destDir = destinationDir.getAbsolutePath();
				File file = file_children[i];
				String newFile = AgentFileUtility.copyFile(file, destDir);
				if(AgentFileUtility.isFileExist(newFile, true)){
					copyCount += 1;
				}
			}
		
			if(copyCount == file_children.length){
				isCopied = true;
			}
		}
		
		return isCopied;
	}
	
	/**
	 * Move files.
	 *
	 * @param sourceDir the source dir
	 * @param destinationDir the destination dir
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean moveFiles(File sourceDir, File destinationDir)throws IOException{
		logger.debug("RSD IN MOVE DIRECTORY CONTENTS");
		int moveCount = 0;
		boolean isMoved = false;
		if(!destinationDir.exists()){
			if (destinationDir.mkdir() == false) {
				logger.error("RSD could not create directory: " + destinationDir.getPath());
				return false;
			}
		}
		File [] file_children = sourceDir.listFiles();
		if (file_children != null) {
			for (int i=0; i<file_children.length; i++){
				String destDir = destinationDir.getAbsolutePath();
				File file = file_children[i];
				String newFile = AgentFileUtility.moveFile(file, destDir);
				if(AgentFileUtility.isFileExist(newFile, true)){
					moveCount += 1;
				}
			}
		
			if(moveCount == file_children.length){
				isMoved = true;
			}
		}
		
		return isMoved;
	}
	
	/**
	 * Copy file.  Removes destination file if it exists.
	 *
	 * @param srcFile the file
	 * @param dirDestination the dir destination
	 * @return the string or null on error
	 */
	public static String copyFile(File srcFile, String dirDestination){
		String newFileName = null;
		
		try{
			File destDir = new File(dirDestination);
			
			File destFile = new File(destDir, srcFile.getName());
			
			logger.info("RSD Copying file \"" + srcFile.getName()+"\" from \""+srcFile.getAbsolutePath() + "\" to location \""+
											destDir.getAbsolutePath() + "\" as \"" + destFile.getAbsolutePath() + "\"");
			
			if(AgentFileUtility.isFileExist(destFile.getAbsolutePath(), true)){
				AgentFileUtility.deleteFile(destFile);
			}
			
			FileUtils.copyFile(srcFile, destFile);		// Unlike file.renameTo(), this can copy file across Linux partitions
			
			newFileName = destFile.getAbsolutePath();
		}
		catch(IOException e){
			logger.error("RSD Exception while moving file: " + e.getLocalizedMessage(), e);
		}
		return newFileName;
	}
	
	/**
	 * Move file.  Removes destination file if it exists.
	 *
	 * @param srcFile the file
	 * @param dirDestination the dir destination
	 * @param quiet do not log normal operation unless debug level is active
	 * @return the string or null on error
	 */
	public static String moveFile(File srcFile, String dirDestination, boolean quiet){
		String newFileName = null;
		
		try{
			File destDir = new File(dirDestination);
			
			File destFile = new File(destDir, srcFile.getName());
			
			if ((!quiet) || (logger.isDebugEnabled()))
				logger.info("RSD Moving file \""+srcFile.getAbsolutePath() + "\" to location \""+
						destDir.getAbsolutePath() + "\" as \"" + destFile.getAbsolutePath() + "\"");
			
			if(AgentFileUtility.isFileExist(destFile.getAbsolutePath(), quiet)){
				AgentFileUtility.deleteFile(destFile, quiet);
			}
			
			FileUtils.moveFile(srcFile, destFile);		// Unlike file.renameTo(), this can copy file across Linux partitions
			
			newFileName = destFile.getAbsolutePath();
		}
		catch(IOException e){
			logger.error("RSD Exception while moving file: " + e.getLocalizedMessage(), e);
		}
		return newFileName;
	}
	
	/**
	 * Move file.  Removes destination file if it exists.
	 *
	 * @param srcFile the file
	 * @param dirDestination the dir destination
	 * @return the string or null on error
	 */
	public static String moveFile(File srcFile, String dirDestination){
		return moveFile(srcFile, dirDestination, false);
	}

	/**
	 * Move file.
	 *
	 * @param filePath the file path
	 * @param dirDestination the dir destination
	 * @return the string
	 */
	public static String moveFile(String filePath, String dirDestination){
		String newFileName = null;
		
		try{
			File file = new File(filePath);
			newFileName = moveFile(file, dirDestination);
		}
		catch(Exception e){
			logger.error("RSD Exception while moving file: " + e.getLocalizedMessage(), e);
		}
		return newFileName;
	}

	/**
	 * Checks if is file exist.
	 *
	 * @param directory the directory
	 * @param fileName the file name
	 * @param quiet do not log normal operation unless debug level is active
	 * @return true, if is file exist
	 */
	public static boolean isFileExist(String directory, String fileName, boolean quiet){
		File fileDir = new File(directory);
		File[] files = fileDir.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		if (files != null) {
			for(File temp: files){
				fileNames.add(temp.getName());
			}
		}
		
		if (fileNames.contains(fileName)){
			return true;
		}
		return false;
	}

	/**
	 * Checks if is file exist.
	 *
	 * @param filePath the file path
	 * @param quiet do not log normal operation unless debug level is active
	 * @return true, if is file exist
	 */
	public static boolean isFileExist(String filePath, boolean quiet){
		if (filePath == null){
			return false;
		}
		File file = new File(filePath);
		if (!file.exists())
			if ((!quiet) || (logger.isDebugEnabled()))
				logger.info("RSD [isFileExist] File doesn't exist: \"" + file.getAbsolutePath() + "\"");
		return file.exists();
	}
	
	/**
	 * Checks if is file exist.
	 *
	 * @param filePath the file path
	 * @return true, if is file exist
	 */
	public static boolean isFileExist(String filePath){
		return isFileExist(filePath, false);
	}
	
	/**
	 * Creates the folder if path is does not exist.
	 *
	 * @param filePath the file path
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String createFolderIfMissing(String filePath) throws IOException{
		String destination_path = filePath;
		
		if (! AgentFileUtility.isFileExist(filePath, true)){
			File tempPath = new File(destination_path);
			boolean isFolderCreated = tempPath.mkdirs();
			
			destination_path = tempPath.getAbsolutePath();
				
			if (! isFolderCreated){
				logger.error("RSD Unable to create directory: " + destination_path);
				destination_path = null;
			} else {
				logger.info("RSD created directory: " + destination_path);
			}
		}
		
		return destination_path + File.separator;
	}
	
	/**
	 * Creates the file if missing.
	 *
	 * @param filePath the file path
	 * @param quiet do not log normal operation unless debug level is active
	 * @return the string
	 */
	public static String createFileIfMissing(String filePath, boolean quiet) {
		String filename = null;
		boolean isCreated = false;
		try{
			if(!AgentFileUtility.isFileExist(filePath, true)){
				File file = new File(filePath);
				if (file.createNewFile() == false) {
					logger.error("RSD could not create file: {}", file);
				} else {
					filename = file.getAbsolutePath();
					isCreated = true;
				}
			}
			else{
				filename = filePath;
			}
		}
		catch(Exception e){
			logger.error("RSD Exception, creating file: {}", filePath, e);
		}
	
		if ((!quiet) || (logger.isDebugEnabled()))
			logger.info("RSD file " + ((isCreated)? "created" : "exists") + ": " + filename);
		return filename;
	}
	
	/**
	 * Creates the file if missing.
	 *
	 * @param filePath the file path
	 * @return the string
	 */
	public static String createFileIfMissing(String filePath) {
		return createFileIfMissing(filePath, false);
	}
	
	/**
	 * Find xml file.
	 *
	 * @param baseDir the base dir
	 * @return the string
	 */
	public static String findXmlFile(File baseDir){
		String fileName = null;
		
		if(baseDir.isDirectory() && baseDir.exists()){
			ArrayList<File> files = new ArrayList<File>(Arrays.asList(baseDir.listFiles()));
			
			for(int i=0; i<files.size(); i++){
				File tempFile = files.get(i);
				fileName = tempFile.getAbsolutePath();
				if ((!tempFile.isDirectory()) && AgentFileUtility.getExtensionName(fileName).equalsIgnoreCase(".xml")){
					logger.debug("RSD Found XML file:" + fileName);
					
					return fileName;
				}
				else{
					fileName = null;
				}
			}
			
			if(fileName == null){
				logger.warn("RSD No XML file found in " + baseDir.getAbsolutePath());
			}
		}
		else{
			logger.warn("RSD Given parameter is not a valid directory, "+ baseDir);
		}
		return fileName;
	}
	
	/**
	 * Un zip file.
	 *
	 * @param zipFilePath the zip file path
	 * @param destinationPath the destination path
	 * @return the array list
	 */
	public static ArrayList<String> unZipFile(String zipFilePath, String destinationPath) {
		ArrayList<String> entries = new ArrayList<String>();

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ZipInputStream zipInputStream = null;

		BufferedOutputStream destination = null;
		FileOutputStream fos = null;

		try {		
			String destination_path = AgentFileUtility.createFolderIfMissing(destinationPath);

			fis = new FileInputStream(zipFilePath);
			bis = new BufferedInputStream(fis);
			zipInputStream = new ZipInputStream(bis);

			ZipEntry entry; 
			while((entry = zipInputStream.getNextEntry()) != null) {

				String destination_filename;
				logger.debug("RSD extracting: " + entry);

				int buffer = 1024;//source.available();
				int count;
				byte data[] = new byte[buffer];

				destination_filename = new File(destination_path,entry.getName()).getAbsolutePath();
				fos = new FileOutputStream(destination_filename);
				logger.info("RSD extracting to " + destination_filename);
				//File detinationFile = new File(destinationPath+entry.getName());

				destination = new BufferedOutputStream(fos, buffer);
				while((count=zipInputStream.read(data, 0, buffer)) != -1){
					destination.write(data, 0, count);
				}

				entries.add(destination_filename);

				destination.flush();
				destination.close();
				destination = null;
				fos.close();
				fos = null;
			}
		}
		catch (Exception e){
			logger.error("RSD Exception, unzip: {}", zipFilePath, e);
		}
		finally {
			FileUtil.closeResource(destination);
			FileUtil.closeResource(fos);
			FileUtil.closeResource(zipInputStream);
			FileUtil.closeResource(bis);
			FileUtil.closeResource(fis);
		}

		return entries; //return list of filenames
	}
}