/*
 * MaskingLayout.java
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

/**
 * Interface that defines bean pattern for <code>maskMessage</code> property.
 * <p>
 * Implementations of this interface must process logging events according
 * to the bean <code>maskMessage</code> property and those implementations must
 * initialize the persistent instance to the {@link #DEFAULT_MASKMESSAGE default}.
 * <p>
 * If the bean property is <code>true</code>, then the application supplied
 * {@link org.apache.log4j.spi.LoggingEvent#getMessage() message} of the logging
 * event passed in the method
 * {@link org.apache.log4j.Layout#format(org.apache.log4j.spi.LoggingEvent) Layout.format(LoggingEvent)}
 * must be processed by
 * {@link com.verifone.isd.viper.eps.sys.util.VFIStringUtil#getMaskedMessage(java.lang.String)).
 * A new {@link org.apache.log4j.spi.LoggingEvent} then must be created with the
 * returned message string from the <code>getMaskedMessage</code> call.
 * <p>
 * {@link com.verifone.isd.viper.eps.sys.util.MaskAppender MaskAppender},
 * will do the masking of events instead and 
 * the MaskAppender will call the method{@link #setMaskMessage(boolean) setMaskMessage(false)}
 * for those layouts that implement this interface.
 *
 * @see com.verifone.isd.viper.eps.sys.util.MaskAppender
 * @see com.verifone.isd.viper.eps.sys.log.MaskingPatternLayout
 * @see com.verifone.isd.viper.eps.sys.log.EPSHtmlLayout
 * @see com.verifone.isd.viper.eps.sys.util.VFIStringUtil#getMaskedMessage(java.lang.String)
 * 
 * @author Joe_H5
 */
public interface MaskingLayout
{
    /**
     * DEFAULT value implementations must initialize their persistent JavaBean
     * class variable instance to.
     */
    public static boolean DEFAULT_MASKMESSAGE = true;

    /**
     * Layout property getter for maskMessage.
     * Default is true.
     * <p>
     * The Layout's Log4j configuration property can specify 'true' or 'false'.
     *
     * @return <code>true</code> if message masking is enabled.
     */
    public boolean isMaskMessage();

    /**
     * Layout property setter for maskMessage.
     * <p>
     * The Layout's Log4j configuration property can specify 'true' or 'false'.
     *
     * @param maskMessage the new value to set.  <code>true</code> if message
     *                    masking is to be enabled.
     */
    public void setMaskMessage(boolean maskMessage);
}
