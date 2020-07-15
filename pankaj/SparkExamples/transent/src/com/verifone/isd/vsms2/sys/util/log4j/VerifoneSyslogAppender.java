/*
 * ExtendedSyslogAppender.java
 * 
 * COPYRIGHT (c) 2000-2011 by VeriFone Inc., All Rights Reserved.
 * 
 *                       N O T I C E
 * 
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sys.util.log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Category;
import org.apache.log4j.Layout;
import org.apache.log4j.MDC;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.SyslogQuietWriter;
import org.apache.log4j.helpers.SyslogWriter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

/**
 * Use this to send log messages to a remote syslog daemon.
 * <p>
 * This class is a re-implementation of Log4J's
 * org.apache.log4j.net.SysLogAppender.  All configuration properties
 * used in Log4J's SyslogAppender apply for this implementation.
 * <p>
 * The major changes done in this implementation are:<br>
 * <ul>
 *    <li> When printing the stack trace, stack source lines are submitted
 *         as one atomic operation to the the Syslog service.
 *    <li> If a message or stack trace is longer than 1024 characters,
 *         the message is split among multiple Syslog service submissions.
 *    <li> An &quot;appName&quot; property is introduced and this is output
 *         for ALL continuation lines.
 * </ul>
 * 
 * Modifications to Log4j's original implementation will have the JavaDoc tag
 * &quot;&#64;since cr0140.01&quot; javadoc tag.  That's the
 * &quot;
 * at since cr0140.01
 * &quot;
 *
 * @since cr0140.01
 * @author Joe_H5
 */
public class VerifoneSyslogAppender extends AppenderSkeleton
{
    // The following constants are extracted from a syslog.h file
    // copyrighted by the Regents of the University of California
    // I hope nobody at Berkley gets offended.

    /**
     * Kernel messages
     */
    final static public int LOG_KERN = 0;
    /**
     * Random user-level messages
     */
    final static public int LOG_USER = 1 << 3;
    /**
     * Mail system
     */
    final static public int LOG_MAIL = 2 << 3;
    /**
     * System daemons
     */
    final static public int LOG_DAEMON = 3 << 3;
    /**
     * security/authorization messages
     */
    final static public int LOG_AUTH = 4 << 3;
    /**
     * messages generated internally by syslogd
     */
    final static public int LOG_SYSLOG = 5 << 3;
    /**
     * line printer subsystem
     */
    final static public int LOG_LPR = 6 << 3;
    /**
     * network news subsystem
     */
    final static public int LOG_NEWS = 7 << 3;
    /**
     * UUCP subsystem
     */
    final static public int LOG_UUCP = 8 << 3;
    /**
     * clock daemon
     */
    final static public int LOG_CRON = 9 << 3;
    /**
     * security/authorization messages (private)
     */
    final static public int LOG_AUTHPRIV = 10 << 3;
    /**
     * ftp daemon
     */
    final static public int LOG_FTP = 11 << 3;
    // other codes through 15 reserved for system use
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL0 = 16 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL1 = 17 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL2 = 18 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL3 = 19 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL4 = 20 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL5 = 21 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL6 = 22 << 3;
    /**
     * reserved for local use
     */
    final static public int LOG_LOCAL7 = 23 << 3;
    protected static final int SYSLOG_HOST_OI = 0;
    protected static final int FACILITY_OI = 1;
    static final String TAB = "    ";
    // Have LOG_USER as default
    private int syslogFacility = LOG_USER;
    private String facilityStr;
    private boolean facilityPrinting = false;
    //SyslogTracerPrintWriter stp;
    private SyslogQuietWriter sqw;
    private String syslogHost;
    
    private String appName = "";

    /**
     * If true, the appender will generate the HEADER (timestamp and host name) part of the syslog packet.
     */
    private boolean header = false;
    /**
     * Date format used if header = true.
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss ", Locale.ENGLISH);
    /**
     * Host name used to identify messages from this appender.
     */
    private String localHostname;
    /**
     * Set to true after the header of the layout has been sent or if it has none.
     */
    private boolean layoutHeaderChecked = false;
    
    private boolean useRFC5424 = true;

    private String procID = "";
    private String msgID = "";
    private Map<String, Map<String,String>> structuredData = new HashMap<String, Map<String,String>>();

    /**
     * Property to enable or disable stack trace logging.
     * 
     * @since cr0140.01
     */
    private boolean logStackTrace = true;

    public VerifoneSyslogAppender()
    {
        this.initSyslogFacilityStr();
        this.setUseRFC5424(useRFC5424);
    }

    public VerifoneSyslogAppender(boolean logStackTrace)
    {
        this.logStackTrace = logStackTrace;
        this.initSyslogFacilityStr();
        this.setUseRFC5424(useRFC5424);
    }

    public VerifoneSyslogAppender(Layout layout, int syslogFacility)
    {
        this.layout = layout;
        this.syslogFacility = syslogFacility;
        this.initSyslogFacilityStr();
        this.setUseRFC5424(useRFC5424);
    }

    public VerifoneSyslogAppender(Layout layout, String syslogHost, int syslogFacility)
    {
        this(layout, syslogFacility);
        setSyslogHost(syslogHost);
        this.setUseRFC5424(useRFC5424);
    }

    /**
     * Release any resources held by this SyslogAppender.
     */
    @Override
    synchronized public void close()
    {
        closed = true;
        if (sqw != null)
        {
            try
            {
                if (layoutHeaderChecked && layout != null && layout.getFooter() != null)
                {
                    sendLayoutMessage(layout.getFooter());
                }
                sqw.close();
                sqw = null;
            }
            catch (java.io.InterruptedIOException e)
            {
                Thread.currentThread().interrupt();
                sqw = null;
            }
            catch (IOException e)
            {
                sqw = null;
            }
        }
    }

    private void initSyslogFacilityStr()
    {
        facilityStr = getFacilityString(this.syslogFacility);

        if (facilityStr == null)
        {
            System.err.println("\"" + syslogFacility
                    + "\" is an unknown syslog facility. Defaulting to \"USER\".");
            this.syslogFacility = LOG_USER;
            facilityStr = "user:";
        }
        else
        {
            facilityStr += ":";
        }
    }

    /**
     * Returns the specified syslog facility as a lower-case String, e.g. "kern", "user", etc.
     * @param syslogFacility
     * @return Printable facility string.
     */
    public static String getFacilityString(int syslogFacility)
    {
        switch (syslogFacility)
        {
            case LOG_KERN:
                return "kern";
            case LOG_USER:
                return "user";
            case LOG_MAIL:
                return "mail";
            case LOG_DAEMON:
                return "daemon";
            case LOG_AUTH:
                return "auth";
            case LOG_SYSLOG:
                return "syslog";
            case LOG_LPR:
                return "lpr";
            case LOG_NEWS:
                return "news";
            case LOG_UUCP:
                return "uucp";
            case LOG_CRON:
                return "cron";
            case LOG_AUTHPRIV:
                return "authpriv";
            case LOG_FTP:
                return "ftp";
            case LOG_LOCAL0:
                return "local0";
            case LOG_LOCAL1:
                return "local1";
            case LOG_LOCAL2:
                return "local2";
            case LOG_LOCAL3:
                return "local3";
            case LOG_LOCAL4:
                return "local4";
            case LOG_LOCAL5:
                return "local5";
            case LOG_LOCAL6:
                return "local6";
            case LOG_LOCAL7:
                return "local7";
            default:
                return null;
        }
    }

    /**
     * Returns the integer value corresponding to the named syslog facility, or -1 if it couldn't be recognized.
     *
     * @param facilityName one of the strings KERN, USER, MAIL, DAEMON, AUTH, SYSLOG, LPR, NEWS, UUCP, CRON, AUTHPRIV, FTP, LOCAL0,
     *                     LOCAL1, LOCAL2, LOCAL3, LOCAL4, LOCAL5, LOCAL6, LOCAL7. The matching is case-insensitive.
     *
     * @return Facility octet value.
     */
    public static int getFacility(String facilityName)
    {
        if (facilityName != null)
        {
            facilityName = facilityName.trim();
        }
        if ("KERN".equalsIgnoreCase(facilityName))
        {
            return LOG_KERN;
        }
        else if ("USER".equalsIgnoreCase(facilityName))
        {
            return LOG_USER;
        }
        else if ("MAIL".equalsIgnoreCase(facilityName))
        {
            return LOG_MAIL;
        }
        else if ("DAEMON".equalsIgnoreCase(facilityName))
        {
            return LOG_DAEMON;
        }
        else if ("AUTH".equalsIgnoreCase(facilityName))
        {
            return LOG_AUTH;
        }
        else if ("SYSLOG".equalsIgnoreCase(facilityName))
        {
            return LOG_SYSLOG;
        }
        else if ("LPR".equalsIgnoreCase(facilityName))
        {
            return LOG_LPR;
        }
        else if ("NEWS".equalsIgnoreCase(facilityName))
        {
            return LOG_NEWS;
        }
        else if ("UUCP".equalsIgnoreCase(facilityName))
        {
            return LOG_UUCP;
        }
        else if ("CRON".equalsIgnoreCase(facilityName))
        {
            return LOG_CRON;
        }
        else if ("AUTHPRIV".equalsIgnoreCase(facilityName))
        {
            return LOG_AUTHPRIV;
        }
        else if ("FTP".equalsIgnoreCase(facilityName))
        {
            return LOG_FTP;
        }
        else if ("LOCAL0".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL0;
        }
        else if ("LOCAL1".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL1;
        }
        else if ("LOCAL2".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL2;
        }
        else if ("LOCAL3".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL3;
        }
        else if ("LOCAL4".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL4;
        }
        else if ("LOCAL5".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL5;
        }
        else if ("LOCAL6".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL6;
        }
        else if ("LOCAL7".equalsIgnoreCase(facilityName))
        {
            return LOG_LOCAL7;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Write multiple message string as one line per Syslog event.
     * @param header  The header preamble for a syslog protocol.
     *                Usually is the header developed by {@link #getPacketHeader(long)}
     * @param message The message from a log event to submit to syslog.
     * 
     * @since cr0140.01
     */
    private void writeMessage(final String header, final String message)
    {
        Reader rdr = new StringReader(message);
        BufferedReader brdr = new BufferedReader(rdr);
        
        try
        {
            while(true)
            {
                String aLine = brdr.readLine();
                if (aLine == null)
                {
                     break;
                }

                splitPacket(header, aLine);
            }
        } catch (IOException ioe)
        {
            LogLog.error("Error writing to Syslog service!", ioe);
        }
    }

    /**
     * Write message string array as one line per Syslog event.
     * 
     * @param header  The header preamble for a syslog protocol.
     *                Usually is the header developed by {@link #getPacketHeader(long)}
     * @param message The message from a log event to submit to syslog.  This one is
     *                usually returned from the call to {@link ThrowableInformation#getThrowableStrRep()}.
     * 
     * @since cr0140.01
     */
    private void writeMessage(final String header, final String[] message)
    {
        for (int i = 0; i < message.length; i++)
        {
            String aStr = message[i];
            writeMessage(header, aStr);
        }
    }

    private void splitPacket(final String header, final String packet)
    {
        int byteCount = packet.getBytes().length + header.getBytes().length;
        //
        //   if packet is less than RFC 3164 limit
        //      of 1024 bytes, then write it
        //      (must allow for up 5to 5 characters in the PRI section
        //          added by SyslogQuietWriter)
        if (byteCount <= 1019)
        {
            sqw.write(header + packet);
        }
        else
        {
            int split = header.length() + (packet.length() - header.length()) / 2;
            splitPacket(header, packet.substring(0, split) + "...");
            splitPacket(header, "..." + packet.substring(split));
        }
    }

    @Override
    public void append(LoggingEvent event)
    {

        if (!isAsSevereAsThreshold(event.getLevel()))
        {
            return;
        }

        // We must not attempt to append if sqw is null.
        if (sqw == null)
        {
            errorHandler.error("No syslog host is set for SyslogAppedender named \""
                    + this.name + "\".");
            return;
        }

        // If application has configured 'appName' through MDC instead of
        // Log4J configuration, use MDC's definition.
        if (appName.length() == 0)
        {
            Object aValue = MDC.get("appName");
            if ((aValue != null) && (aValue.toString().length() > 0))
            {
                appName = aValue.toString();
            } else
            {
                // Incase neither configuration or MDC as defined 'appName'
                // Use current user's name.
                appName = System.getProperty("user.name", "UNKNOWN");
            }
        }

        if (!layoutHeaderChecked)
        {
            if (layout != null && layout.getHeader() != null)
            {
                sendLayoutMessage(layout.getHeader());
            }
            layoutHeaderChecked = true;
        }

        ThrowableInformation ti = event.getThrowableInformation();
        if ((ti != null) && !(ti instanceof VerifoneThrowableInformation))
        {
            ti = makeVerifoneThrowableInformation(ti, event.getLogger());
            event = new LoggingEvent(
                    event.getFQNOfLoggerClass(),
                    event.getLogger(),
                    event.getTimeStamp(),
                    event.getLevel(),
                    event.getMessage(),
                    event.getThreadName(),
                    ti,
                    event.getNDC(),
                    event.getLocationInformation(),
                    event.getProperties()
                );
        }

        String hdr = getPacketHeader(event.timeStamp);
        String packet;
        if (layout == null)
        {
            packet = String.valueOf(event.getMessage());
        }
        else
        {
            packet = layout.format(event);
        }
        if (facilityPrinting || hdr.length() > 0)
        {
            StringBuilder buf = new StringBuilder(hdr);
            if (facilityPrinting)
            {
                buf.append(facilityStr);
            }
            hdr = buf.toString();
        }

        sqw.setLevel(event.getLevel().getSyslogEquivalent());
        writeMessage(hdr, packet);

        // @since cr0140.01
        if (layout == null || layout.ignoresThrowable())
        {
            String[] s = event.getThrowableStrRep();
            if (s != null)
            {
                writeMessage(hdr, s);
            }
        }
    }

    @Override
    public void activateOptions()
    {
        if (header)
        {
            getLocalHostname();
        }
        if (layout != null && layout.getHeader() != null)
        {
            sendLayoutMessage(layout.getHeader());
        }
        layoutHeaderChecked = true;

    }

    /**
     * The SyslogAppender requires a layout. Hence, this method returns
     * <code>true</code>.
     *
     * @return Always returns <code>true</code>.
     */
    @Override
    public boolean requiresLayout()
    {
        return true;
    }

    /**
     * The <b>SyslogHost</b> option is the name of the the syslog host where log output should go. A non-default port can be
     * specified by appending a colon and port number to a host name, an IPv4 address or an IPv6 address enclosed in square
     * brackets.
     *
     * <b>WARNING</b> If the SyslogHost is not set, then this appender will fail.
     */
    public final void setSyslogHost(final String syslogHost)
    {
        this.sqw = new SyslogQuietWriter(new SyslogWriter(syslogHost),
                                         syslogFacility, errorHandler);
        //this.stp = new SyslogTracerPrintWriter(sqw);
        this.syslogHost = syslogHost;
    }

    /**
     * Returns the value of the <b>SyslogHost</b> option.
     * 
     * @return The SYSLOG host URN
     */
    public String getSyslogHost()
    {
        return syslogHost;
    }

    /**
     * Set the syslog facility. This is the <b>Facility</b> option.
     *
     * <p>The
     * <code>facilityName</code> parameter must be one of the strings KERN, USER, MAIL, DAEMON, AUTH, SYSLOG, LPR, NEWS, UUCP, CRON,
     * AUTHPRIV, FTP, LOCAL0, LOCAL1, LOCAL2, LOCAL3, LOCAL4, LOCAL5, LOCAL6, LOCAL7. Case is unimportant.
     *
     * @since 0.8.1
     */
    public void setFacility(String facilityName)
    {
        if (facilityName == null)
        {
            return;
        }

        syslogFacility = getFacility(facilityName);
        if (syslogFacility == -1)
        {
            System.err.println("[" + facilityName
                    + "] is an unknown syslog facility. Defaulting to [USER].");
            syslogFacility = LOG_USER;
        }

        this.initSyslogFacilityStr();

        // If there is already a sqw, make it use the new facility.
        if (sqw != null)
        {
            sqw.setSyslogFacility(this.syslogFacility);
        }
    }

    /**
     * Returns the value of the <b>Facility</b> option.
     * 
     * @return The configured facility string.
     */
    public String getFacility()
    {
        return getFacilityString(syslogFacility);
    }

    /**
     * If the <b>FacilityPrinting</b> option is set to true, the printed message will include the facility name of the application.
     * It is <em>false</em> by default.
     */
    public void setFacilityPrinting(boolean on)
    {
        facilityPrinting = on;
    }

    /**
     * Returns the value of the <b>FacilityPrinting</b> option.
     */
    public boolean getFacilityPrinting()
    {
        return facilityPrinting;
    }

    /**
     * If true, the appender will generate the HEADER part (that is, timestamp and host name) of the syslog packet. Default value is
     * false for compatibility with existing behavior, however should be true unless there is a specific justification.
     *
     * @since 1.2.15
     */
    public final boolean getHeader()
    {
        return header;
    }

    /**
     * Returns whether the appender produces the HEADER part (that is, timestamp and host name) of the syslog packet.
     *
     * @since 1.2.15
     */
    public final void setHeader(final boolean val)
    {
        header = val;
    }

    /**
     * Appender JavaBean property getter for logStackTrace.
     * Default is true.
     * <p>
     * The appender's Log4j configuration property can specify 'true' or 'false'.
     *
     * @return <code>true</code> if stack trace logging is enabled.
     */
    public boolean isLogStackTrace()
    {
        return logStackTrace;
    }

    /**
     * Appender JavaBean property getter for logStackTrace.
     * <p>
     * The appender's Log4j configuration property can specify 'true' or 'false'.
     *
     * @param logStackTrace <code>true</code> if stack trace logging is enabled.
     */
    public void setLogStackTrace(boolean logStackTrace)
    {
        this.logStackTrace = logStackTrace;
    }

    /**
     * Create {@link ThrowableInformation ThrowableInformation} honoring stack trace logging enable setting.
     * @param ti The throwable information to use to create the new one.
     * @param logger The Log4J logger associated with the event the original throwable information came from.
     * @return The new throwable information honoring stack trace logging enable.
     * 
     * @since cr0140.01
     */
    protected final ThrowableInformation makeVerifoneThrowableInformation(ThrowableInformation ti, Category logger)
    {
        ThrowableInformation retVal = ti;

        if (ti != null)
        {
            if (ti.getThrowable() != null)
            {
                retVal = new VerifoneSyslogAppender.VerifoneThrowableInformation(ti.getThrowable(), logger);
            } else if (ti.getThrowableStrRep().length > 0)
            {
                retVal = new VerifoneSyslogAppender.VerifoneThrowableInformation(ti.getThrowableStrRep());
            }
        }

        return retVal;
    }

    /**
     * Get the host name used to identify this appender.
     *
     * @return local host name
     *
     * @since 1.2.15
     */
    private String getLocalHostname()
    {
        if (localHostname == null)
        {
            try
            {
                InetAddress addr = InetAddress.getLocalHost();
                localHostname = addr.getHostName();
            }
            catch (UnknownHostException uhe)
            {
                localHostname = "UNKNOWN_HOST";
            }
        }
        return localHostname;
    }

    /**
     * Gets HEADER portion of packet.
     *
     * @param timeStamp number of milliseconds after the standard base time.
     *
     * @return HEADER portion of packet, will be zero-length string if header is false.
     *
     * @since 1.2.15
     */
    private String getPacketHeader(final long timeStamp)
    {
        String retVal = "";
        if (header)
        {
            retVal = (useRFC5424) ? getRFC54254Header(timeStamp) : getRFC3164Header(timeStamp) ;
        }
        return retVal;
    }
    
    private String getRFC3164Header(final long timeStamp)
    {
        StringBuilder buf = new StringBuilder(dateFormat.format(new Date(timeStamp)));
        //  RFC 3164 says leading space, not leading zero on days 1-9
        if (buf.charAt(4) == '0')
        {
            buf.setCharAt(4, ' ');
        }
        buf.append(' ');
        buf.append(getLocalHostname());
        buf.append(' ');
        buf.append(appName);
        buf.append(' ');
        return buf.toString();
    }

    private String getRFC54254Header(final long timeStamp)
    {
        StringBuilder buf = new StringBuilder("1 ");
        buf.append(dateFormat.format(new Date(timeStamp)));
        buf.append(' ');
        buf.append(getLocalHostname());
        buf.append(' ');
        buf.append(appName);
        buf.append(' ');
        buf.append((procID.length() == 0) ? "-" : procID); // PROCID field
        buf.append(' ');
        buf.append((msgID.length() == 0) ? "-" : msgID); // MSGID field
        buf.append(' ');
        if (structuredData.size() > 0)
        {
            for (Map.Entry<String, Map<String, String>> sdElement : structuredData.entrySet())
            {
                buf.append('[');
                String sdID = sdElement.getKey();
                buf.append(sdID);
                Map<String, String> map = sdElement.getValue();
                for (Map.Entry<String, String> entry : map.entrySet())
                {
                    buf.append(' ');
                    String sdName = entry.getKey();
                    String sdValue = entry.getValue();
                    buf.append(sdName);
                    buf.append('=');
                    buf.append('\"');
                    buf.append(sdValue);
                    buf.append('\"');
                }
                buf.append(']');
            }
        } else
        {
            buf.append('-'); // No Structured Data
        }
        buf.append(' ');

        return buf.toString();
    }

    /**
     * Set header or footer of layout.
     *
     * @param msg message body, may not be null.
     */
    private void sendLayoutMessage(final String msg)
    {
        if (sqw != null)
        {
            String packet = msg;
            String hdr = getPacketHeader(new Date().getTime());
            if (facilityPrinting || hdr.length() > 0)
            {
                StringBuilder buf = new StringBuilder(hdr);
                if (facilityPrinting)
                {
                    buf.append(facilityStr);
                }
                buf.append(msg);
                packet = buf.toString();
            }
            sqw.setLevel(6);
            sqw.write(packet);
        }
    }

    /**
     * Java bean getter for appName property.
     * @return the application set for this instance.
     * 
     * @since cr0140.01
     */
    public String getAppName()
    {
        return appName;
    }

    /**
     * Java bean setter for appName property.
     * @param appName the new application name to set appName to.
     * 
     * @since cr0140.01
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public boolean isUseRFC5424()
    {
        return useRFC5424;
    }

    public final void setUseRFC5424(boolean useRFC5424)
    {
        this.useRFC5424 = useRFC5424;
        if (useRFC5424)
        {
            String tzStr = getRFC5424TomezoneStr();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"+tzStr, Locale.ENGLISH);
        } else
        {
            dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss", Locale.ENGLISH);
        }
    }
    /* The 'SimpleDateFormat' class's 'Z' identifier in its format strang expands to '+HHmm' or '-HHmm'.
     * But RFZ5424 wants it to be +HH:mm' or '-HH:mm'.  This method puts that ':' colon in.
     */
    private String getRFC5424TomezoneStr()
    {
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        
        TimeZone tz = cal.getTimeZone();
        
        int tzOfs = tz.getOffset(System.currentTimeMillis());
        tzOfs = tzOfs / 1000;  // Drop milliseconds
        tzOfs = tzOfs/60;      // Drop Seconds

        int tzMM = tzOfs % 60;
        tzOfs = tzOfs/60;
        int tzHH = tzOfs % 60;
        if (tzOfs < 0)
        {
            tzHH = -tzHH;
            tzMM = -tzMM;
            sb.append('-');
        } else
        {
            sb.append('+');
        }
        if (tzHH < 9)
        {
            sb.append('0');
        }
        sb.append(tzHH);
        sb.append(':');
        if (tzMM < 9)
        {
            sb.append('0');
        }
        sb.append(tzMM);
        
        return sb.toString();
    }

    /**
     * Internal Log4J ThrowableInformation implementation honoring
     * {@link VerifoneSyslogAppender#logStackTrace} value regarding
     * logging of an exception's stack trace.
     * 
     * @since cr0140.01
     */
    protected class VerifoneThrowableInformation extends ThrowableInformation
    {
        private static final long serialVersionUID = -4911986577830393784L;

        private String[] rep = new String[0];

        public VerifoneThrowableInformation(Throwable throwable)
        {
            super(throwable);
            initRepString();
        }

        public VerifoneThrowableInformation(Throwable throwable, Category category)
        {
            super(throwable, category);
            initRepString();
        }

        public VerifoneThrowableInformation(final String[] r)
        {
            super(r);
            initRepString();
        }

        @Override
        public String[] getThrowableStrRep()
        {
            return (String[]) rep.clone();
        }

        /**
         * Create a new throwable information object honoring whether the stack trace information
         * is to be retained or not.
         * 
         * @since cr0140.01
         */
        private void initRepString()
        {
            String[] repStrs = super.getThrowableStrRep();
            if (repStrs.length > 0 && !VerifoneSyslogAppender.this.logStackTrace)
            {
                rep = new String[] {repStrs[0]};
            } else
            {
                rep = repStrs;
            }
        }
    }
}
