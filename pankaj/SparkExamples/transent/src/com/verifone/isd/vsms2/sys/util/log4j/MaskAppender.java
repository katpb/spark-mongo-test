package com.verifone.isd.vsms2.sys.util.log4j;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import com.verifone.isd.vsms2.sys.util.VFIStringUtil;


/**
 * This class is used to mask all the sensitive data present in an XML log
 * before sending the it to rsyslog daemon. It will mask all the characters
 * present in the sensitive data of specified XML tags and attributes leaving
 * the first 6 and last 4 characters as is.
 * 
 * @author T_VadirajaC1
 */

public class MaskAppender extends VerifoneSyslogAppender {
	
	/**
	 * When no IP is specified in the log4j.propertes file, this address will be
	 * considered as default rsyslog server's IP address, that is localhost.
	 */
	private static final String RSYSLOG_IP = "127.0.0.1";

    private boolean maskMessage = true;

	public MaskAppender() {
	}

	protected MaskAppender(boolean logStackTrace) {
		super(logStackTrace);
	}

    /**
	 * Initial setup happens in this method, This method will be called once
	 */
	public void activateOptions() {

		super.activateOptions();

		if (super.getSyslogHost() == null) {
			super.setSyslogHost(RSYSLOG_IP);
		}

        if ((super.layout != null) && (super.layout instanceof MaskingLayout))
        {
            // Since this appender is masking the logging events,
            // no need for the layout to do so - performance and resource waste.
            MaskingLayout epsLayout = MaskingLayout.class.cast(super.layout);
            epsLayout.setMaskMessage(false);
        }
	}

	/**
	 * Calls its super append() after determining if stack information is to be output.
     * Masking has now been deferred to the
     * {@link com.verifone.isd.viper.eps.sys.log.EPSHtmlLayout EPSHtmlLayout} class.
     *
     * @see com.verifone.isd.viper.eps.sys.log.EPSHtmlLayout
     * @see com.verifone.isd.viper.eps.sys.util.VFIStringUtil#getMaskedMessage(java.lang.String)
	 */
	public void append(LoggingEvent event) {

		if (event != null && event.getMessage() != null) {

            boolean newEvent = false;
            ThrowableInformation throwableInfo = event.getThrowableInformation();
            if (!super.isLogStackTrace() && (throwableInfo != null))
            {
                throwableInfo = null;
                newEvent = true;
            }

            String logMessage = event.getMessage().toString();
            if (maskMessage)
            {
                logMessage = VFIStringUtil.getMaskedMessage(logMessage);
                newEvent = true;
            }
			if (newEvent) {
                throwableInfo = super.makeVerifoneThrowableInformation(throwableInfo, event.getLogger());
                event = new LoggingEvent(event.fqnOfCategoryClass,
                                            org.apache.log4j.Logger.getLogger(event.getLoggerName()),
                                            event.timeStamp,
                                            event.getLevel(),
                                            logMessage,
                                            event.getThreadName(),
                                            throwableInfo,
                                            event.getNDC(),
                                            event.getLocationInformation(),
                                            event.getProperties());
			}

			super.append(event);
		}
	}


    /**
     * Appender JavaBean property getter for maskMessage.
     * Default is true.
     * <p>
     * The appender's Log4j configuration property can specify 'true' or 'false'.
     *
     * @return <code>true</code> if message masking is enabled.
     */
    public boolean isMaskMessage()
    {
        return maskMessage;
    }

    /**
     * Appender JavaBean property setter for maskMessage.
     * <p>
     * The appender's Log4j configuration property can specify 'true' or 'false'.
     *
     * @param maskMessage the maskMessage to set
     */
    public void setMaskMessage(boolean maskMessage)
    {

    }

}
