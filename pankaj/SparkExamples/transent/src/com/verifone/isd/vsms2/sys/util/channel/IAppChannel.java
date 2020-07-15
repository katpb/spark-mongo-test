package com.verifone.isd.vsms2.sys.util.channel;

import java.net.InetAddress;

/**
 *  Interface to return interfaces for stream-based interaction on the attached 
 * channel.  Streams interface opens a pipe for the exchange and is document oriented.
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public interface IAppChannel
{
     public static final int SALES_CHANNEL = 6;     // reserved for rubySDPd, not for SapphireVM use 
     public static final int CGIPORTAL_CHANNEL = 11;
     public static final int DIAGPORTAL_CHANNEL = 12;
     public static final int CLOUDCM_PORTAL  = 411; //CDM socket port
 
    
    /**
     *  @return the IStream interface for the channel
     *  @see IStream
     */
    public IStream getRubyStreamsInterface();
    
    /**
     *  Stop this channel, freeing the required resources.
     */
    public void stop();
    
    /**
     *  get the port this channel is pointed at
     *  @return the port number
     */
    public int getPort();
}