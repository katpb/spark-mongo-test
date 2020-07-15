package com.verifone.isd.vsms2.sys.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.verifone.isd.vsms2.sys.util.log4j.NamedLoggers;
import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;

/**
 * Class to determine if the CGI response is for failure or not
 *
 */

public class CGIResponseAnalyser {
	
    private boolean isError = false;    
    private VFIResponseXMLHandler handler;

	/**
	 * method to analyze the CGI response
	 * @param buffReader Reader to used as InputSource
	 */ 
	private void analyzeResponse(BufferedReader buffReader) {
		try {
			SAXParserFactory spf = SecureSAXParserFactory.newSPFInstance();
			SAXParser parser = spf.newSAXParser();
			XMLReader sp = parser.getXMLReader();
            handler = new VFIResponseXMLHandler();
			SAXFilter sf = new SAXFilter(sp, handler);  
			InputSource is = new InputSource(buffReader);
			sf.parse(is);	
		}catch (Exception e) {
			NamedLoggers.AUTOUPGRADE.error("Exception in analyzeResponse : ", e);
			isError = true;
		}
	}

	/**
     * method to analyze the CGI response
     * @param reader Reader to used as InputSource
     */ 
    public void analyzeResponse(Reader reader) {
        BufferedReader buffReader = null;
        try {
            buffReader = new BufferedReader(reader);
            analyzeResponse(buffReader);
        } catch (Exception e) {
        	NamedLoggers.AUTOUPGRADE.error("Exception in analyzeResponse : ", e);
            isError = true;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }

            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * method to analyze the CGI response
     * @param inStream Stream to be used for reading the xml
     */ 
    public void analyzeResponse(InputStream inStream) {
        BufferedReader buffReader = null;
        try {
            buffReader = new BufferedReader(new InputStreamReader(inStream));
            analyzeResponse(buffReader);
        }  catch (Exception e) {
        	NamedLoggers.AUTOUPGRADE.error("Exception in analyzeResponse : ", e);
            isError = true;
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                }
            }

            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (Exception e) {
                }
            }
        }
    }
    
    /**
     * method to analyze the CGI response
     * @param responseFilePath File where response is saved
     */
    public void analyzeResponse(String responseFilePath) {
        Reader fileReader = null;
        BufferedReader buffReader = null;
        try {
            fileReader = new FileReader(new File(responseFilePath));
            buffReader = new BufferedReader(fileReader);
            analyzeResponse(buffReader);
        }  catch (Exception e) {
        	NamedLoggers.AUTOUPGRADE.error("Exception in analyzeResponse : ", e);
            isError = true;
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                }
            }

            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (Exception e) {
                }
            }
        }
    }
	
	/**
	 * method to tell if the CGI response is for failure or not
	 * @return true if the CGI response is for failure
	 */	
	public boolean isError() {
		return (isError || handler.isFaultDocument());
	}

	/**
	 * method to get the error message from CGI response
	 * @return The error message
	 */
	public String getErrorMsg() {
            if (handler != null) {
                return handler.getErrorData();
            }
            return null;
	}
	
    /**
     * Returns the value of the given element if present in CGIResponse
     * @param element whose value need to be fetched
     * @return Value if present or null;
     */
    public String getValue(String element) {
            if (handler != null) {
                return handler.getValue(element);
            }
            return null;
    }
}
