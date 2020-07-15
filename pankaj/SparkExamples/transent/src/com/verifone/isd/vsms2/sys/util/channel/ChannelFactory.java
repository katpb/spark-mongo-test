package com.verifone.isd.vsms2.sys.util.channel;

import java.net.UnknownHostException;
import java.util.HashMap;

/**
 *  Constructs a logical communication channel for stream oriented (TCP) communication.
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public class ChannelFactory {

    static private HashMap configList = new HashMap();
    static private HashMap channels = new HashMap();

    /**
     *  Returns an IAppChannel interface with which to talk to the logical 
     * channel.  Logical channels are created to service a self-contained 
     * application area, such as fuel or payment networks. Note that it is 
     * possible to "prebind" addresses other than the defaults to a logical 
     * channel, usually for testing purposes.  If such a bound address is not 
     * found, the default is used. 
     *  <b>Once the channel is created, calling bind has no effect. </b>
     *  As an example, to configure the channel's address/ port to be on local 
     * host, the sequence of steps would be:
     *  <pre>
     *      ChannelFactory.bind(IAppChannel.FUEL_CHANNEL, 127.0.0.1, 5454, 7002);
     *      IAppChannel channel = ChannelFactory.create(IAppChannel.FUEL_CHANNEL);
     *  <pre>
     * @see #bind(int logicalChannel,String connectToIPStr,int connectToPort,int localPort)
     * @param logicalChannel the value of the channel to create.
     * @exception UnknownHostException thrown if the designated TCP/IP resources  
     * are not available for some reason.
     * @return IAppChannel interface with which to talk to the logical channel
     */
    static public synchronized IAppChannel create(int logicalChannel) throws 
            UnknownHostException {
        Integer intObj = new Integer(logicalChannel);
        IAppChannel reqdChannel = (IAppChannel) channels.get(intObj);
        if (null == reqdChannel) {
            ChannelConfig rc = (ChannelConfig) configList.get(intObj);
            if (rc == null) {
                rc = new ChannelConfig(logicalChannel);
                configList.put(new Integer(logicalChannel), rc);
            }
            reqdChannel = new ChannelImpl(rc);
            channels.put(intObj, reqdChannel);
        }
        return reqdChannel;
    }

    /**
     *  Returns an IAppChannel interface with which to talk to the logical 
     * channel.  Logical channels are created to service a self-contained 
     * application area, such as fuel or payment networks. Note that it is 
     * possible to "prebind" addresses other than the defaults to a logical 
     * channel, usually for testing purposes.  If such a bound address is not 
     * found, the default is used. 
     *  <b>Once the channel is created, calling bind has no effect. </b>
     *  As an example, to configure the channel's address/ port to be on local 
     * host, the sequence of steps would be:
     *  <pre>
     *      ChannelFactory.bind(IAppChannel.FUEL_CHANNEL, 127.0.0.1, 5454, 7002);
     *      IAppChannel channel = ChannelFactory.create(IAppChannel.FUEL_CHANNEL);
     *  <pre>
     * @see #bind(int logicalChannel,String connectToIPStr,int connectToPort,int localPort)
     * @param logicalChannel the value of the channel to create.
     * @param threadGroup thread group for the channel's threads. Should be 
     * ThreadPriority.HI_PRIORITY_GROUP or ThreadPriority.DEFAULT_GROUP.
     * 
     * @exception UnknownHostException thrown if the designated TCP/IP resources 
     * are not available for some reason.
     * @return IAppChannel interface with which to talk to the logical channel
     */
    static public synchronized IAppChannel create(int logicalChannel, 
            ThreadGroup threadGroup) throws UnknownHostException {
        ChannelImpl channel = (ChannelImpl) create(logicalChannel);
        channel.setThreadGroup(threadGroup);
        return channel;
    }

    /**
     *  Binds a ChannelConfig to a logical channel if something other than 
     * the default is desired. This method has effect on the IAppChannel 
     * created ONLY if it is called prior to calling the create method. 
     * <b> This method would have no effect after the channel has been created. </b>
     * @param logicalChannel logical channel id
     * @throws java.net.UnknownHostException on communication errors
     */
    static public synchronized void bind(int logicalChannel) throws UnknownHostException {
        Integer intObj = new Integer(logicalChannel);
        IAppChannel reqdChannel = (IAppChannel) channels.get(intObj);
        if (null == reqdChannel) { //Honor request ONLY if IAppChannel object is not yet established.
            ChannelConfig rc = new ChannelConfig(logicalChannel);
            configList.put(new Integer(logicalChannel), rc);
        }
    }
    
    /**
     * Getter for physical port number, given the logical port
     * @param logicalChannel logical port
     * @return physical port number
     * @throws UnknownHostException propagated to caller
     */
    static public int getPortForLogicalChannel(int logicalChannel) throws UnknownHostException {
        ChannelConfig rc = new ChannelConfig(logicalChannel);
        return rc.localPort;
    }
}