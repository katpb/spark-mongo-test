package com.verifone.isd.vsms2.sys.util.channel;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.ThreadPriority;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ChannelImpl implements IAppChannel {

    private Logger logger = LoggerFactory.getLogger(ChannelImpl.class);
    // processor object for streams
    private IStream rubyStreams = null;
    // save the channel configuration
    private ChannelConfig config = null;
    private ThreadGroup threadGroup;

    /**
    ChannelImpl
    Constructor sets up a logical channel and uses a JNI interface to get allowable addresses
    and TCP/IP parameters from a C header file shared with the Ruby
     */
    public ChannelImpl(ChannelConfig rc) throws UnknownHostException {
        this.config = rc;
        this.threadGroup = ThreadPriority.DEFAULT_GROUP;
    }

    void setThreadGroup(ThreadGroup tg) {
        this.threadGroup = tg;
    }

    @Override
    public IStream getRubyStreamsInterface() {
        if (rubyStreams == null) {
            try {
                rubyStreams = new StreamImpl(config.localPort, this.threadGroup);
            } catch (java.net.UnknownHostException e) {
            } catch (java.net.SocketException e) {
            } catch (java.io.IOException e) {
            }
        }
        return rubyStreams;
    }

    @Override
    public void stop() {
        if (rubyStreams != null) {
            rubyStreams.stop();
        }
        rubyStreams = null;
    }

    @Override
    public int getPort() {
        return config.localPort;
    }


    @Override
    protected void finalize() throws java.lang.Throwable {
        stop();
        if (SysPropertyFactory.reportFinalizers()) {
            logger.info("finalize " + this.getClass().getName());
        }
        super.finalize();
    }
}
