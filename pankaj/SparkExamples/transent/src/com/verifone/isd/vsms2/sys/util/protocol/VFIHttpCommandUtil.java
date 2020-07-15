package com.verifone.isd.vsms2.sys.util.protocol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.CGIResponseAnalyser;
import com.verifone.isd.vsms2.sys.util.ControllerConstants;
import com.verifone.isd.vsms2.sys.util.sax.ISAXSerializable;
import com.verifone.isd.vsms2.sys.util.sax.SAXWriter;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * Utility class to send HTTP request to SiteController.
 * 
 * @author HimanshuY1
 */
public class VFIHttpCommandUtil {

    private static final String HTTP_POST = "POST";

    private static Logger logger = LoggerFactory.getLogger(VFIHttpCommandUtil.class);

    private static final int READ_BUFFER_SIZE = 10240;
    private Random random = new Random();
    private static final String TMP = ".tmp";
    private Date dateFromHeader;   
	/**
     * Fires the URL and retrieves the response. Analyze the response for any
     * errors. If no errors and a file name is provided, the response will be
     * saved to that file
     * 
     * @param url
     *            URL to be invoked
     * @param localFile
     *            file name to which the response should be saved.
     * @return true if the transfer was successful & response is not a VFIFault
     *         response
     */
    public boolean sendRequest(String url, String localFile) {
        String tmpFile = (localFile != null) ? (localFile + TMP) : (this.random.nextInt() + TMP);
        File tempFile = new File(tmpFile);
        boolean result = executeView(url, tempFile);
        if (result) {
            result = analyzeAndSave(localFile, tempFile);
        }
        return result;
    }
    
    /**
     * Fires the URL and analyse the response. 
     * 
     * @param url
     *            URL to be invoked
     * 
     * @return CGIResponseAnalyser
     */
    public CGIResponseAnalyser sendRequest(VFIURL url) {
        InputStream in = null;
        VFIHttpURLConnection conn = null;
        CGIResponseAnalyser analyser = null;
        try {
	        conn = url.openConnection();
	        in = (InputStream) conn.getContent();
	        analyser = new CGIResponseAnalyser();
            analyser.analyzeResponse(in);
        } catch (IOException e) {
        	 logger.error("Exception while sending request", e);
		}    
        return analyser;
    }
    
    /**
     * Fires the URL and retrieves the response. Analyze the response for any
     * errors. If no errors and a file name is provided, the response will be
     * saved to that file
     * 
     * @param url
     *            URL to be invoked
     * @param localFile
     *            file name to which the response should be saved.
     * @param timeout
     *            new timeout value for this request
     * @return true if the transfer was successful & response is not a VFIFault
     *         response
     */
    public boolean sendRequest(String url, String localFile,int timeout) {
        String tmpFile = (localFile != null) ? (localFile + TMP) : (this.random.nextInt() + TMP);
        File tempFile = new File(tmpFile);
        boolean result = executeView(url, tempFile,timeout);
        if (result) {
            result = analyzeAndSave(localFile, tempFile);
        }
        return result;
    }

	public boolean sendRequest(String cmd, String localFile, String payLoad, int timeout) {
		String tmpFile = (localFile != null) ? (localFile + TMP) : (this.random.nextInt() + TMP);
		File tempFile = new File(tmpFile);
		boolean result = executeUpdate(cmd, tempFile, payLoad, null, getConnection(timeout));
		if (result) {
			result = analyzeAndSave(localFile, tempFile);
		}
		return result;
	}



	/**
	 * Send http request.
	 * 
	 * @param url
	 *            the url
	 * @return the uRL connection
	 */
	public URLConnection sendRequest(String url) {
		URL urlobj = null;
		URLConnection urlcon = null;
		try {
			urlobj = new URL(url);
		} catch (MalformedURLException e) {
			logger.error("MalformedURLException while sending request '{}'",url,e);
		}

		try {
			if (null != urlobj) {
				urlcon = urlobj.openConnection();
			}
		} catch (IOException e) {
		}
		return urlcon;

	}
    
    /**
     * Fires the URL, sends the given command and Payload as post data.
     * retrieves the response, Analyze it for any errors. If no errors and a
     * file name is provided, the response will be saved to that file
     * 
     * @param cmd
     *            a typical 'u' command that needs to be invoked
     * @param localFile
     *            file name to which the response should be saved.
     * @param payLoad
     *            String containing xml payload that needs to be sent for the
     *            given command
     * @return true if the transfer was successful & response is not a VFIFault
     *         response
     */
    public boolean sendRequest(String cmd, String localFile, String payLoad) {
        String tmpFile = (localFile != null) ? (localFile + TMP) : (this.random.nextInt() + TMP);
        File tempFile = new File(tmpFile);
        boolean result = executeUpdate(cmd, tempFile, payLoad, null, getConnection(0));
        if (result) {
            result = analyzeAndSave(localFile, tempFile);
        }
        return result;
    }

    /**
     * Fires the URL, sends the given command and Payload as post data.
     * retrieves the response, Analyze it for any errors. If no errors and a
     * file name is provided, the response will be saved to that file
     * 
     * @param cmd
     *            a typical 'u' command that needs to be invoked
     * @param localFile
     *            file name to which the response should be saved.
     * @param visitor
     *            ISAXSerializable object that will be used for writing xml
     *            document to the request
     * @return true if the transfer was successful & response is not a VFIFault
     *         response
     */
    public boolean sendRequest(String cmd, String localFile, ISAXSerializable visitor) {
        String tmpFile = (localFile != null) ? (localFile + TMP) : (this.random.nextInt() + TMP);
        File tempFile = new File(tmpFile);
        boolean result = executeUpdate(cmd, tempFile, null, visitor, getConnection(0));
        if (result) {
            result = analyzeAndSave(localFile, tempFile);
        }
        return result;
    }

    /**
     * Analyzes the response in temporary file for any error. If its a valid
     * response , and a fileName is provided renames the temporary file to the
     * given fileName after removing it
     * 
     * @param localFile
     *            file to which response should be saved
     * @param tempFile
     *            temporary File to analyze the response
     * @return true if response is a valid response(not VFIFault) and is able to
     *         Successfully save it to given file. Finally temporary file is
     *         removed
     */
    private boolean analyzeAndSave(String localFile, File tempFile) {
        boolean sucess = false;
        try {
            CGIResponseAnalyser analyser = new CGIResponseAnalyser();
            analyser.analyzeResponse(tempFile.getAbsolutePath());
            sucess = !analyser.isError();
            if ((localFile != null) && sucess) {
                File dest = new File(localFile);
                if (!dest.exists() || dest.delete()) {
                    if (tempFile.renameTo(dest)) {
                        sucess = true;
                    } else {
                        logger.error("Not able to rename temporary file to " + dest.getName());
                        sucess = false;
                    }
                } else {
                    logger.error("Error Removing the file : " + localFile);
                    sucess = false;
                }
            }
        } finally {
            if (tempFile.exists()) {
            	
				if (!sucess) {
					logger.error("Received an invalid XML from the controller. XML data will be printed!");
					logFileContents(tempFile);
				}
            	
                if (!tempFile.delete()) {
                    logger.error("Unable to delete temp file - {}", tempFile.getName());
                }
            }
        }
        return sucess;
    }

    /**
     * Sends the CGI command. Writes the response into a temp file.
     * 
     * @param url
     *            to be invoked
     * @param tempFile
     *            file to which the response should be saved
     * @return true if command was successful and result was retrieved in a
     *         file, false otherwise
     */
    private boolean executeView(String url, File tempFile) {
    	return executeView(url, tempFile, -1);
    }
    
    /**
     * Sends the CGI command. Writes the response into a temp file.
     * 
     * @param url
     *            to be invoked
     * @param tempFile
     *            file to which the response should be saved
     * @param timeout
     *            new timeout value for this request
     * @return true if command was successful and result was retrieved in a
     *         file, false otherwise
     */
    private boolean executeView(String url, File tempFile,int timeout) {
        boolean transfer = false;
        InputStream in = null;
        VFIHttpURLConnection conn = null;
        try {
            VFIURL theurl = new VFIURL(url);
            logger.info("Exercising cgi request '{}'",url);
            conn = theurl.openConnection();
            conn.setTimeoutValue(timeout);
            in = (InputStream) conn.getContent();
            logger.debug("'{}' is the response code after URL request {}",conn.getResponseCode(),url);
            transfer = retrieveAndStoreInTemp(in, tempFile);
        } catch (Exception e) {
            logger.error("CGICommandUtil:storeConfig failed: " , e);
		} finally {
			
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						logger.error("Couldn't close the input stream ", e);
					}
				}
		}
        return transfer;
    }
    
	/**
	 * This method reads the file contents and logs it
	 * 
	 * @param file
	 */
	private void logFileContents(File file) {

		FileInputStream fileInputStream = null;
		BufferedReader reader = null;
		InputStreamReader streamReader = null;
		
		StringBuilder sb = new StringBuilder();

		try {
			fileInputStream = new FileInputStream(file);
			streamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(streamReader);
			
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			logger.info(sb.toString());

		} catch (IOException ex) {
			logger.error("Couldn't read the file " + file.getName(), ex);
		} finally {
			
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
				}
			}
			
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
			
			if (streamReader != null) {
				try {
					streamReader.close();
				} catch (Exception e) {
				}
			}

		}
	}

    /**
     * Sends the CGI command. Writes the response into a temp file.
     * 
     * @param cmd
     *            cmd to be invoked
     * @param tempFile
     *            file to which the response should be saved
     * @param payLoad
     *            data to be sent to server
     * @param is
     *            ISAXSerializable to be used for sending xml payload
     * @return true if command was successful and result was retrieved in a
     *         file, false otherwise
     */
    private boolean executeUpdate(String cmd, File tempFile, String payLoad, ISAXSerializable is, VFIHttpURLConnection conn) {
        InputStream in = null;
        OutputStream out = null;
        boolean transfer = false;
        long date;
        try {
			if (conn == null) {
				return false;
			}
            // Write the command and Payload on the outputStream with a gap of
            // "\n" between parameter and data. end with a blank line to mark
            // the end of Payload
            out = conn.getOutputStream();
            out.write(("cmd=" + cmd + "\n\n").getBytes());
            if (payLoad != null) {
                out.write(payLoad.getBytes());
            } else {
                SAXWriter sw = new SAXWriter(out);
                sw.writeSAX(is);
            }
            out.write(("\n\n").getBytes());
            out.flush();

            // Get the inputStream, read and store the response
            in = (InputStream) conn.getContent();
            transfer = retrieveAndStoreInTemp(in, tempFile);        
            date=conn.getDate();                
            dateFromHeader = new Date(date); 
            setHeaderDate(dateFromHeader);            
        } catch (Exception e) {
            logger.error("Exception while executing command : " , e);
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException ioe) {
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException ioe) {
                }
            }
        }
        return transfer;
    }

	private VFIHttpURLConnection getConnection(int timeout) {
		VFIHttpURLConnection conn = null;
		try {
			VFIURL theurl = new VFIURL(ControllerConstants.BASE_URL_CGILINK);
			conn = theurl.openConnection();
			conn.setRequestMethod(HTTP_POST);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setAllowUserInteraction(true);
			if (timeout > 0) {
				conn.setTimeoutValue(timeout);
			}
		} catch (Exception e) {
		}
		return conn;
	}

    /**
     * Sends the CGI command. Writes the response into a temp file.
     * 
     * @param in
     *            InputStream to read the data from
     * @param tempFile
     *            file to which the response should be saved
     * @return true if
     */
    private boolean retrieveAndStoreInTemp(InputStream in, File tempFile) {
        boolean transfer = false;
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(tempFile);
            int fileSize = 0;
            byte[] array = new byte[READ_BUFFER_SIZE];
            for (;;) {
                int len = in.read(array);
                if (len == -1) {
					break;
				}
                file.write(array, 0, len);
                fileSize += len;
            }
            file.flush();
            logger.debug("CGICommandUtil:retrieveAndStoreInTemp " + tempFile.getName() + " fileSize in bytes-"
                    + fileSize);
            transfer = true;
        } catch (Exception e) {
            logger.error("CGICommandUtil:storeConfig failed: " , e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException ioe) {
                }
            }
            if (null != file) {
                try {
                    file.close();
                } catch (IOException ioe) {
                }
            }
        }
        return transfer;
    }
    
    public Date getHeaderDate() {
		return dateFromHeader;
	}

	public void setHeaderDate(Date dateFromHeader) {
		this.dateFromHeader = dateFromHeader;
	}
	
	
	/**
	 * This class builds up the pay load for the Http POST requests.
	 * 
	 * @author T_RahulS6
	 *
	 */
	 public class RequestParam {

		private HashMap<String, String> params = new HashMap<>();

		public void addParam(String name, String value){
			params.put(name, value);
		}
		public String buildPayload() {
			StringBuilder payLoad = new StringBuilder();
			 for(Entry<String,String> ent:params.entrySet()){
		            payLoad.append(ent.getKey());
		            payLoad.append(IXMLVocabulary.EQUALS_SYMBOL);
		            payLoad.append(ent.getValue());
		            payLoad.append(IXMLVocabulary.AMPERSAND_SYMBOL);
		        }
			 payLoad.deleteCharAt(payLoad.length()-1);
			return payLoad.toString();
		}
	}
}