package com.verifone.isd.vsms2.sys.util.channel;

import java.net.InetAddress;

public class InetPort
{
    public InetAddress inetAddress = null;
    public int port = 0;
    public InetPort(InetAddress a,int port)
    {
        this.inetAddress = a;
        this.port = port;
    }
}