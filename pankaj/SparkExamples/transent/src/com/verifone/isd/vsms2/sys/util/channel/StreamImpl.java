package com.verifone.isd.vsms2.sys.util.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
StreamProcessor class
processes an incoming data stream
 */
public class StreamImpl implements IStream {

    private Logger logger = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.channel.StreamImpl.class);
    private StreamChannel streamChannel = null;
    private IStreamListener streamListener = null;
    private IStreamAppFactory streamAppFactory = null;

    public StreamImpl(int localPort, ThreadGroup threadGroup) throws java.io.IOException {
        streamListener = new StreamListener();
        streamChannel = new StreamChannel(localPort, streamListener, threadGroup);
    }

    @Override
    public void stop() {
        streamChannel.stop();
    }

    @Override
    public void setStreamAppFactory(IStreamAppFactory streamAppFactory) {
        this.streamAppFactory = streamAppFactory;
    }

    @Override
    public IStreamAppFactory getStreamAppFactory() {
        return this.streamAppFactory;
    }

    class StreamListener implements IStreamListener {

        @Override
        public void openStream(java.net.Socket socket) {
            try {
                if (streamAppFactory != null) {
                    streamAppFactory.create(socket).start();
                } else {
                    socket.close();
                }
            } catch (java.io.IOException e) {
                // do nothing, it's just a close
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        stop();
        if (SysPropertyFactory.reportFinalizers()) {
            logger.info("finalize " + this.getClass().getName());
        }
        super.finalize();
    }
}
