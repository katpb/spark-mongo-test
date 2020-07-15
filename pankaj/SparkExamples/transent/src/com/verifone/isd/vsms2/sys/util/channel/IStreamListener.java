package com.verifone.isd.vsms2.sys.util.channel;

/**
 *  interface with a method through which to receive
 *  a created socket
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public interface IStreamListener
{
    /**
     *  callback method presents a working socket
     *  @param socket the socket to use
     */
    public void openStream(java.net.Socket socket);
}