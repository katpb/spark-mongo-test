package com.verifone.isd.vsms2.sys.util;
import java.util.Vector;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Reader;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Class to handle input and output from a TCP socket at the beginning of a server
 *  session in a consistent manner.  These routines use line oriented I/O, with a single
 *  empty line representing end of data.
 *  By creating a new SocketServerManager on a fresh incoming TCP stream, the object will
 *  prompt the other end first, and then gather the subsequent command lines into a vector
 *  of lines, accessible by an Enumeration.
 *
 *  This class sets the socket timeout to 5 seconds.  Code using the socket thereafter must
 *  expect a java.io.InterruptedIOException.
 *
 *  Once this class has been created on a socket, its close() method must be used to
 *  make sure that all streams resources are released properly.  The supplied socket
 *  will also be closed.
 *
 *  If the constructor throws an exception, the socket will be closed.
 *
 *  The balance of the data can be read or written to/from the stream by using either
 *  the already constructed reader/writer or by getting a new stream from the socket.
 *
 *  @see java.io.BufferedWriter
 *  @see java.io.BufferedReader
 *  @see java.net.Socket
 *  @see java.net.Socket#setSoTimeout(int)
 *  @see java.io.InterruptedIOException
 *  @see java.util.Vector
 *  @see java.util.Enumeration
 *
 *  @version 1.0
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *
 */
public class SocketServerManager {
    private Logger logger = LoggerFactory.getLogger(SocketServerManager.class);    
    private Vector field1set = null;
    private Vector field2set = null;
    private PrivateBufferReader br = null;
    private BufferedWriter bw = null;
    private Timer timer = null;
    private long datalength = 0;
    
    private Socket s = null;
    
    
    /**
     *  constructor
     *  @param name a name for this service which will appear in the response to the client.
     *  @param s the Socket to the client
     *  @exception IOException thrown on socket I/O error
     */
    public SocketServerManager(String name,Socket s) throws IOException {
        try {
            try {
                this.s = s;
                
                this.s.setTcpNoDelay(true);
                /* DB comment out
                timer = new Timer(timeout);
                timer.addTimerListener(new TimerListener(Thread.currentThread()));
                 */
                
                this.br = new PrivateBufferReader(new InputStreamReader(s.getInputStream()));
                this.bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                this.field1set = new Vector();
                this.field2set = new Vector();
                
                String str = "220 "+name+" ready.\n\n";
                bw.write(str);
                bw.flush();
                
                /* DB comment out
                timer.go();
                 */
                for (;;) {
                    String cmdLine = br.readLine();
                    if (cmdLine == null || cmdLine.length() == 0) {
                        break;
                    }
                    int whiteSpaceLoc = cmdLine.indexOf(' ');
                    if (whiteSpaceLoc == -1) {
                        this.field1set.addElement(cmdLine.trim());
                        this.field2set.addElement("");
                    }
                    else {
                        this.field1set.addElement(cmdLine.substring(0,whiteSpaceLoc).trim());
                        this.field2set.addElement(cmdLine.substring(whiteSpaceLoc+1).trim());
                    }
                }
                /* DB comment out
                timer.clear();
                 */
                try {
                    String len = findLine("length");
                    this.datalength = new Long(len).longValue();
                }
                catch(NoSuchElementException e) { /* ignore */ }
            }
            catch (SocketException e) {
                throw new IOException("SocketServerManager socket exception "+e.getMessage());
            }
            catch (InterruptedIOException e) {
                throw new IOException("SocketServerManager socket timed out "+e.getMessage());
            }
            catch (Exception e) {
                throw new IOException("SocketServerManager exception "+e.getMessage());
            }
        }
        catch (IOException e) {
            this.close();
            throw e;
        }
    }
    
    /* DB comment out
    class TimerListener implements ITimerListener {
        private Thread cur = null;
        public TimerListener(Thread cur) {
            this.cur = cur;
        }
        public void expired() {
            cur.interrupt();
        }
        public void cleared()
        {
        }
    }
     */
    
    /**
     * Getter for a writer on the underlying socket
     * @return BufferedWriter already constructed
     */
    public BufferedWriter getWriter() {
        return bw;
    }
    
    /**
     * Getter for a reader on the underlying socket
     * @return BufferedReader already constructed
     */
    public BufferedReader getReader() {
        return br;
    }
    
    /**
     * Getter for an output stream on the underlying socket
     * @return OutputStream already constructed on the socket
     * @exception IOException thrown on socket I/O error
     */
    public OutputStream getOutputStream() throws IOException {
        return s.getOutputStream();
    }
    
    /**
     * Getter for the number of bytes as specified by the client using the command 'length'
     * @return the number of bytes to follow
     */
    public long getDatalength() { return datalength; }
    
    /**
     * Getter for an input stream on the underlying socket
     * @return InputStream already constructed on the socket
     * @exception IOException thrown on socket I/O error
     */
    public InputStream getInputStream() throws IOException {
        return s.getInputStream();
    }
    
    /**
     *  returns the command string from the command set received from the client which starts with
     *  the specified match
     *  @param startMatch the String to match
     *  @return InputStream already constructed on the socket
     *  @exception NoSuchElementException thrown if no match is found
     */
    public final String findLine(String startMatch) throws NoSuchElementException {
        Enumeration els = field1set.elements();
        int position = 0;
        while (els.hasMoreElements()) {
            String st = (String)els.nextElement();
            st = st.trim();
            if (st.compareTo(startMatch) == 0) {
                return (String) field2set.elementAt(position);
            }
            
            position++;
        }
        throw new NoSuchElementException("no value called "+startMatch+" found");
    }
    
    /**
     * Getter for all command names as received from the client
     * @return an enumeration of all command names as received from the client
     */
    public Enumeration getCommandNames() {
        return this.field1set.elements();
    }
    /**
      *  close the manager resources
     */
    public final void close() {
        try {
            if (br != null) {                
                try {
                    while (true) { //Read all data on i/p stream before closing it
                        String st = br.readLine();
                        if (st == null) {
                            break;
                        }
                    }
                }
                catch (Exception e){}
                br.closeResource();
            }
        }
        catch (IOException e){}
        try {
            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
        catch (IOException e){}
        try {
            if (timer != null) {
                timer.destroy();
            }
            s.close();
        }
        catch (IOException e){}
    }
    
    /**
     * Implementation to log object finalization
     * @exception Throwable thrown per the spec
     */
    protected void finalize() throws Throwable {
        if (SysPropertyFactory.reportFinalizers()) {
            if (logger.isInfoEnabled()) {
                logger.info("finalizing "+this.getClass().getName());
            }
        }
        close();
        super.finalize();
    }
    
    /**
     * This is a wrapper class used by SocketServerManager. When a reader is handed over 
     * to SAX parser, the reader gets closed by the parser. This causes 'Broken pipe' if the 
     * reader is from a socket and no response can be sent back to the client. This class 
     * overrides close() method to prevent the actual reader from getting closed by the 
     * SAX parser. Actual close of the reader is done by SocketServerManager when its 
     * close method is called.
     * @author  bhanu_n2
     */
    private class PrivateBufferReader extends BufferedReader {

        private PrivateBufferReader(Reader reader) {
            super(reader);
        }

        /**
         * No-op override. Actual close happens when the containing SocketServerManager instance is closed.
         */
        public void close() {
        //Intentionally no-op
        }

        private void closeResource() throws IOException {
            super.close();
        }

        public int read() throws IOException {
            try {
                return super.read();
            } catch (InterruptedIOException ioe) {
                throw new EOFException();
            }
        }

        public int read(char[] b, int off, int len) throws IOException {
            try {
                return super.read(b, off, len);
            } catch (InterruptedIOException ioe) {
                throw new EOFException();
            }
        }

        public String readLine() throws IOException {
            try {
                return super.readLine();
            } catch (InterruptedIOException ioe) {
                throw new EOFException();
            }
        }
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SocketServerManager [field1set=" + field1set + ", field2set="
				+ field2set + ", br=" + br + ", bw=" + bw + ", timer=" + timer
				+ ", datalength=" + datalength + ", socket=" + s + "]";
	}
    
}

