/*
 * Created on Feb 16, 2005
 *
 */
package com.verifone.isd.vsms2.sys.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * The Class FileUtil.
 * 
 * @author Amit_k4
 */
public class FileUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUtil.class);

	/**
	 * This is a utility method for closing all IOStreams which implements
	 * Closeable interface like InputStream, OutputStream, Reader, Writer,
	 * RandomAccessFile etc.
	 * 
	 * @param Closeable
	 *            resource
	 */
	public static void closeResource(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Convert string to xml.
	 * 
	 * @param xmlString
	 *            the xml string
	 * @param directoryName
	 *            the directory name
	 * @param expectedFileName
	 *            the expected file name
	 */
	public static void convertStringtoXML(String xmlString,
			String directoryName, String expectedFileName) {
		DocumentBuilderFactory factory = SecureDocumentBuilderFactory.newDBFInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			StringReader stringReader = new StringReader(xmlString);
			InputSource inputSource = new InputSource(stringReader);
			Document document = builder.parse(inputSource);
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			Source src = new DOMSource(document);
			File file = new File(directoryName + File.separator
					+ expectedFileName);
			Result dest = new StreamResult(file);
			aTransformer.transform(src, dest);
		} catch (TransformerConfigurationException e) {
			LOGGER.error("TransformerConfigurationException", e);
		} catch (ParserConfigurationException e) {
			LOGGER.error("ParserConfigurationException", e);
		} catch (SAXException e) {
			LOGGER.error("ParserConfigurationException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		} catch (TransformerFactoryConfigurationError e) {
			LOGGER.error("TransformerFactoryConfigurationError", e);
		} catch (TransformerException e) {
			LOGGER.error("TransformerException", e);
		}
	}

	/**
	 * Gets the file size/Directory size in bytes.
	 * 
	 * @param fileName
	 *            the file name(file or directory)
	 * @return the file size in bytes
	 */
	public static double getFileSizeInBytes(String fileName) {
		long fileSize = 0;
		if (null != fileName) {
			File f = new File(fileName);
			if (f.isFile()) {
				LOGGER.info("'{}' is a valid file", fileName);
				fileSize = f.length();
			} else if (f.isDirectory()) {
				LOGGER.info("'{}' is a valid directory", fileName);
				File[] contents = f.listFiles();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i].isFile()) {
						fileSize += contents[i].length();
					} else if (contents[i].isDirectory())
						fileSize += getFileSizeInBytes(contents[i].getPath());
				}
			}
		} else {
			LOGGER.error("filename is a null");
			fileSize = 0;
		}
		return fileSize;
	}
	
	/**
	 * Gets the file path of forced upgrade related dormant state file and returns the File
	 * @return
	 */
	public static File getDormantStateFile() {
		String dormantStateFileName = SysPropertyFactory.getProperty("dormant.system.state", "/home/common/autoup/data/dormantState.txt");
		return new File(dormantStateFileName);
	}
}
