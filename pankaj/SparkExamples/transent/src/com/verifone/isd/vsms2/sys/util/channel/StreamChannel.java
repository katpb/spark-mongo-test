package com.verifone.isd.vsms2.sys.util.channel;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StreamChannel implements Runnable {

    private Logger logger = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.channel.StreamChannel.class);
    private ServerSocket serverSocket = null;
    private boolean keepRunning = true;
    private Thread thread = null;
    private IStreamListener streamListener = null;

    public StreamChannel(int localPort, IStreamListener streamListener,
            ThreadGroup threadGroup) throws SocketException, java.io.IOException {
        logger.info("opening stream listener on port " + localPort);

        this.serverSocket = new ServerSocket(localPort);
        this.streamListener = streamListener;

        this.thread = new Thread(threadGroup, this, localPort + "_StreamChannel");
        this.thread.setPriority(threadGroup.getMaxPriority());
        this.thread.start();
    }

    public void stop() {
        keepRunning = false;
        try {
            serverSocket.close();
        } catch (java.io.IOException e) {
        }
    }

    @Override
    public void run() {
        while (keepRunning) {
            try {
                Socket socket = serverSocket.accept();
                streamListener.openStream(socket);
            } catch (java.io.IOException e) {
            }
        }
        logger.debug("exit StreamChannel");
    }

    @Override
    public void finalize() throws java.lang.Throwable {
        stop();
        if (SysPropertyFactory.reportFinalizers()) {
            logger.info("finalize " + this.getClass().getName());
        }
        super.finalize();
    }
}
