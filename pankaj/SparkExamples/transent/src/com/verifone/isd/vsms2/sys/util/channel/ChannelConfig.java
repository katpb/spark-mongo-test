package com.verifone.isd.vsms2.sys.util.channel;
import com.verifone.isd.vsms2.sys.util.SapphireEnv;
import java.net.InetAddress;
import java.net.UnknownHostException;

class ChannelConfig
{
    int localPort = 0;
    
    ChannelConfig(int logicalChannel) throws UnknownHostException
    {
        this.localPort = SapphireEnv.getInstance().getSapphireBaseIPPort().intValue() + logicalChannel;
    }
}