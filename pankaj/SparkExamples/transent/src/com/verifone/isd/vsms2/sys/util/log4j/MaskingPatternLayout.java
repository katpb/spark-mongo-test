/*
 * MaskingPatternLayout.java
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

import com.verifone.isd.vsms2.sys.util.VFIStringUtil;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Implementation for a masking {@link PatternLayout}.
 * 
 * @author Joe_H5
 */
public class MaskingPatternLayout extends EnhancedPatternLayout implements MaskingLayout
{
    private boolean maskMessage = true;
    private static final int LINE_LENGTH = 90;
    private static final String INFO_SPACE = " ";

    /**
     * Constructs a masking PatternLayout using the defaults
     * found in {@link PatternLayout}.  Masking is enabled by default.
     */
    public MaskingPatternLayout()
    {
        super();
    }

    /**
     * Constructs a masking PatternLayout using the defaults
     * found in {@link PatternLayout} with the given masking enablement.
     * @param maskMessage Enable or disable masking for this layout.
     */
    public MaskingPatternLayout(boolean maskMessage)
    {
        super();
        this.maskMessage = maskMessage;
    }

    /**
     * Constructs a masking PatternLayout using the given pattern.
     * Masking is enabled by default.
     * @param pattern The conversion pattern defined by {#link PatternLayout}.
     */
    public MaskingPatternLayout(String pattern)
    {
        super(pattern);
    }

    /**
     * Constructs a masking PatternLayout using the given pattern and masking enablement.
     * @param pattern The conversion pattern defined by {#link PatternLayout}.
     * @param maskMessage Enable or disable masking for this layout.
     */
    public MaskingPatternLayout(String pattern, boolean maskMessage)
    {
        super(pattern);
        this.maskMessage = maskMessage;
    }

    @Override
    public String format(LoggingEvent event)
    {
        String message = event.getMessage().toString();
        boolean genNewEvent = false;

        if (maskMessage)
        {
            message = VFIStringUtil.getMaskedMessage(message);
            genNewEvent = true;
        }
        
        if ((message.length() > LINE_LENGTH) && (message.indexOf("<?xml") > 0))
        {
            StringBuffer sBuf = new StringBuffer();
            lineBreaks(sBuf, message);
            message = sBuf.toString();
            genNewEvent = true;
        }
        
        if (genNewEvent)
        {
            event = new LoggingEvent(event.fqnOfCategoryClass,
                                    org.apache.log4j.Logger.getLogger(event.getLoggerName()),
                                    event.timeStamp,
                                    event.getLevel(),
                                    message,
                                    event.getThreadName(),
                                    event.getThrowableInformation(),
                                    event.getNDC(),
                                    event.getLocationInformation(),
                                    event.getProperties());
        }

        return super.format(event);
    }

    @Override
    public boolean isMaskMessage()
    {
        return maskMessage;
    }

    @Override
    public void setMaskMessage(boolean maskMessage)
    {
        this.maskMessage = maskMessage;
    }
    
    private void lineBreaks(StringBuffer sbuf, String message)
    {
    	StringBuilder tmpBuffer = new StringBuilder();
    	tmpBuffer.append(message);
    	if (tmpBuffer.indexOf("<?xml") >= 0)
    	{
    		sbuf.append(INFO_SPACE).append(tmpBuffer.substring(0, tmpBuffer.indexOf(
    				"<?xml")));
    		tmpBuffer.delete(0, tmpBuffer.indexOf("<?xml"));
    		DisplayXML dspXML = new DisplayXML(sbuf, tmpBuffer.toString());
    		dspXML.processXML();
    	} else
    	{
    		sbuf.append(INFO_SPACE).append(tmpBuffer.toString());
    	}
    }

}
