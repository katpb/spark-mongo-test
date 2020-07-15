package com.verifone.isd.vsms2.sys.util.channel;
import java.net.Socket;
import java.io.IOException;

/**
 *  Interface to be implemented by an application to create objects which know 
 * how to use a stream for a designated RubyChannel.
 *
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 *  @see IRubyStreams
 */
public interface IStreamAppFactory
{
    /**
     * create a threaded object constructed to use the Socket supplied.
     * @param socket the socket object that the application must handle.
     * @return an object of type Thread which will be started later.
     */
    public Thread create(Socket socket) throws IOException;
}