/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verifone.isd.vsms2.sys.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to update /etc/hosts entry
 * @author bhanu_n2
 */
public class UpdateHostEntry {
    private static final String UPDATE_HOSTS_SCRIPT = "sudo /usr/local/bin/updateHost";
    private final Logger logger = LoggerFactory.getLogger(UpdateHostEntry.class);
    public UpdateHostEntry() {
    }

    public void updateEntry(String address, String[] hostAliases) throws InvalidParamException {
        if (null != address && null != hostAliases && hostAliases.length > 0) {
            String ipAddress = address.trim();
            this.validateIP(ipAddress);
            String  hostAddress = null;
            StringBuffer processString = new StringBuffer();
            processString.append(UPDATE_HOSTS_SCRIPT);
            processString.append(" ");            
            int i = 0;
            for (; i < hostAliases.length; i++) {
                String curAlias = hostAliases[i];
                if (null != curAlias && curAlias.trim().length() > 0) {
                    processString.append(curAlias.trim());
                    processString.append(" ");
                    try {
                        InetAddress currentEntry = InetAddress.getByName(curAlias);
                        String curAddress = currentEntry.getHostAddress();
                        if (null != hostAddress && !curAddress.equals(hostAddress)) {
                            hostAddress = null;
                            break;
                        }
                        hostAddress = curAddress;
                    } catch (UnknownHostException he) {
                        hostAddress = null;
                    }
                }
            }
            /*Do not waste resources if etc/hosts is already uptodate 
             *  - if no mismatch was detected
             *  - if the new Ip and the original IP are identical
             *  - if no new aliases are added
             */
            if (null != hostAddress && ipAddress.equals(hostAddress) && i >= hostAliases.length) {
                return;
            }
            for (; i < hostAliases.length; i++) {
                String curAlias = hostAliases[i];
                if (null != curAlias && curAlias.trim().length() > 0) {
                    processString.append(curAlias.trim());
                    processString.append(" ");
                }
            }
            processString.append(ipAddress);
            ProcessManager pm = null;
            try {
                pm = new ProcessManager(processString.toString());
                pm.waitForCompletion();
            } catch (Exception ex) {
                logger.error("Error in updating host entry: ", ex);
            } finally {
                if (null != pm) {
                    try {
                        pm.close();
                    } catch (Exception e) {
                        logger.error("Error in closing process manager after host entry update: ", e);
                    }
                }
            }
        }
        else {
            throw new InvalidParamException("Invalid IP and/or host names");
        }
    }
    
    private void validateIP(String ipAddress) throws InvalidParamException {
        StringTokenizer stk = new StringTokenizer(ipAddress, ".", false);
        int parts = 0;
        while (stk.hasMoreTokens()) {
            try {
                int i = Integer.parseInt(stk.nextToken());
                if (i < 0 || i > 255) {
                    throw new InvalidParamException("Invalid IP: " + ipAddress);
                }
                if (i == 0 && parts == 0) {
                    throw new InvalidParamException("Invalid IP: " + ipAddress);
                }
            } catch (NumberFormatException nfe) {
                throw new InvalidParamException("Invalid IP: " + ipAddress);
            }
            parts++;                
        }
        if (parts != 4) {
            throw new InvalidParamException("Invalid IP: " + ipAddress);
        }        
    }
}
