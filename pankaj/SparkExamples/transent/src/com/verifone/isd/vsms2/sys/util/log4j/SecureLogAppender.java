/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.sys.util.log4j;

/**
 * Security log appender extends the supplied appender from Apache
 * in order to force the syslog facility to AUTH so that the
 * syslog daemon will forward the messages to the the customer's
 * centralized security log server using standard UNIX system
 * log formats and protocols configured by the system platform.
 *
 * Note that the facility must be set to a a facility that gets
 * sent to the security log server(s)
 * Tampering with property files can prevent security related
 * logs from being transmitted.
 *
 * @author dennis_t1 site controller version psca0061.01
 * @author bhanu_a1 Sapphire/Topaz version
 * 
 */
public class SecureLogAppender extends VerifoneSyslogAppender {

    public SecureLogAppender()
    {
        super(false);
    }

    protected boolean logStackTrace() {
        return false;
    }
}
