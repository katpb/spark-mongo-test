package com.verifone.isd.vsms2.sys.util.channel;

/**
 *  Interface for controlling full duplex TCP pipes.  The interface allows for 
 * registration of a Factory class which will create application objects which 
 * in turn know how to work with a stream coming in on the associated RubyChannel.
 *  The Factory registered must create a Thread object (may be extended from 
 * Thread) and use the Socket object supplied.
 *  
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 *  @see IStreamAppFactory
 *  @see IRubyChannel
 */
public interface IStream
{
    /**
     *  Stop communication and free resources.  Not callable except through the 
     * IRubyChannel interface.
     *  @see IRubyChannel
     */
    public void stop();
    
    /**
     *  Set the factory which creates Thread objects which can handle the I/O required.
     *  @param streamAppFactory the factory class to create the application object.
     *  @see IStreamAppFactory
     */
     public void setStreamAppFactory(IStreamAppFactory sStreamAppFactory);
     
    /**
     *  get the factory which creates Thread objects which can handle the I/O required.
     */
     public IStreamAppFactory getStreamAppFactory();
     
}