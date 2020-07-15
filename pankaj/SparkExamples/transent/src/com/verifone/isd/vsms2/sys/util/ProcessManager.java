package com.verifone.isd.vsms2.sys.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ScheduledFuture;

/**
 * This class encaptulates a <code>Process</code> to assist in relenquishing resources 
 * when it is no longer needed.  The <code>Process</code> is returned from a
 * <code>Runtime.exec()</code> call. The constructor of this class takes the command parameters
 * to be passed to the <code>Runtime.exec()</code> method and retains a reference to the
 * returned <code>Process</code> object. The creator of this class can then call the
 * method <code>ProcessManager.waitForCompletion()</code>. This method returns the command lines return code
 * when completed. When the process is no longer needed, <code>ProcessManager.close()</code> must
 * be called to relenquish all resources associated to with this process.
 * <code>ProcessManager</code> can be constructed with a timer value greater than zero.
 * This will specify the amount of time the commmand has to execute before
 * the <code>close</code> is called.  Otherwise, if the time value is less than
 * or equal to zero or not specified, the command will run until either the command has
 * finished or it is closed.
 *
 * CAUTION: if a command is specified that will never return and the <code>waitForCompletion</code>
 * is called, the caller will be block indefinitely unless and until the <code>close</code>
 * is called by another thread.
 *
 * @see java.lang.Process
 * @see java.lang.Runtime#exec(java.lang.String)
 */
public class ProcessManager implements Closeable
{
    private Process process = null;
    private ScheduledFuture<?> future;

	/**
	 * Executes the specified string command in a separate process. 
	 * <p>
	 * The <code>command</code> is passed onto <code>Runtime.exec</code>.
	 * the <code>timeout</code> parameter, if greater than zero, specifies the
	 * maximum amount of time (in milliSeconds) before the command is destroyed
	 * If equal to or less than zero, then the command can execute until it is
	 * finished. 
	 * This method has exactly the same effect as 
	 * <code>ProcessManager(command, 0)</code>.
	 * @param command a specified system command.
	 * @throws java.io.IOException On any I/O errors.
	 * @see java.lang.Runtime#exec(java.lang.String, java.lang.String[])
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 */
    public ProcessManager(String command) throws IOException
	{
		this( command, 0);
	}
	/**
	 * Executes the specified string command in a separate process. 
	 * <p>
	 * The <code>command</code> is passed onto <code>Runtime.exec</code>.
	 * the <code>timeout</code> parameter, if greater than zero, specifies the
	 * maximum amount of time (in milliSeconds) before the command is destroyed
	 * If equal to or less than zero, then the command can execute until it is
	 * finished. 
	 * @param command a specified system command.
	 * @param timeout If > 0, maximum time for command to execute; <= 0, unlimited time.
	 * @throws java.io.IOException On any I/O errors.
	 * @see java.lang.Runtime#exec(java.lang.String, java.lang.String[])
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 */
    public ProcessManager(String command,int timeout) throws IOException
    {
        this(command, timeout, null);
    }
	
	/**
	 * Executes the specified string command in a separate process. 
	 * <p>
	 * The <code>command</code> is passed onto <code>Runtime.exec</code>.
	 * the <code>timeout</code> parameter, if greater than zero, specifies the
	 * maximum amount of time (in milliSeconds) before the command is destroyed
	 * If equal to or less than zero, then the command can execute until it is
	 * finished. 
	 * @param command a specified system command.
	 * @param timeout If > 0, maximum time for command to execute; <= 0, unlimited time.
     * @param workingDirecory the working directory of the subprocess, or
     * <tt>null</tt> if the subprocess should inherit the working directory of the
	 * current process.
	 * @throws java.io.IOException On any I/O errors.
	 * @see java.lang.Runtime#exec(java.lang.String, java.lang.String[])
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 */
    public ProcessManager(String command,int timeout, java.io.File workingDirecory) throws IOException
    {
        if (timeout > 0)
        {
           
            future = CommonThreadPoolUtil.getInstance().schedule(new Runnable(){

				@Override
				public void run() {
					ProcessManager.this.close();
					
				}}, timeout);
        }
        this.process = Runtime.getRuntime().exec(command, null, workingDirecory);
    }
	
	/**
	 * Executes the specified string command in a separate process. 
	 * <p>
	 * The <code>commandArray</code> is passed onto <code>Runtime.exec</code>.
	 * the <code>timeout</code> parameter, if greater than zero, specifies the
	 * maximum amount of time (in milliSeconds) before the command is destroyed
	 * If equal to or less than zero, then the command can execute until it is
	 * finished. 
	 * @param commandArray array containing the command to call and its arguments.
	 * @param timeout If > 0, maximum time for command to execute; <= 0, unlimited time.
	 * @throws java.io.IOException On any I/O errors.
	 * @see java.lang.Runtime#exec(java.lang.String, java.lang.String[])
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 */
    public ProcessManager(String commandArray[],int timeout) throws IOException
    {
        if (timeout > 0)
        {
         
            CommonThreadPoolUtil.getInstance().schedule(new Runnable(){

				@Override
				public void run() {
					ProcessManager.this.close();
					
				}}, timeout);
        }
        this.process = Runtime.getRuntime().exec(commandArray);
    }
	
    /**
     * causes the current thread to wait, if necessary, until the 
     * process encapsulated by <code>ProcessManager</code> has 
     * terminated. This method returns 
     * immediately if the subprocess has already terminated. If the
     * subprocess has not yet terminated, the calling thread will be
     * blocked until the subprocess exits.
     *
     * @return     the exit value of the process. By convention, 
     *             <code>0</code> indicates normal termination.
     * @exception  InterruptedException  if the current thread is 
     *             {@link Thread#interrupt() interrupted} by another thread 
     *             while it is waiting, then the wait is ended and an 
     *             <code>InterruptedException</code> is thrown.
     */
	public int waitForCompletion() throws java.lang.InterruptedException {
		return process.waitFor();
	}
    
    /**
     * Gets the output stream of the subprocess.
     * Output to the stream is piped into the standard input stream of 
     * the process represented by this <code>Process</code> object. 
     * <p>
     * Implementation note: It is a good idea for the output stream to 
     * be buffered.
     *
     * @return  the output stream connected to the normal input of the
     *          subprocess.
     */
    public OutputStream getOutputStream()
    {
        return this.process.getOutputStream();
    }
    
    /**
     * Gets the input stream of the subprocess.
     * The stream obtains data piped from the standard output stream 
     * of the process represented by this <code>Process</code> object. 
     * <p>
     * Implementation note: It is a good idea for the input stream to 
     * be buffered.
     *
     * @return  the input stream connected to the normal output of the
     *          subprocess.
     */
    public InputStream getInputStream()
    {
        return this.process.getInputStream();
    }

    /**
     * Gets the error stream of the subprocess.
     * The stream obtains data piped from the error output stream of the 
     * process represented by this <code>Process</code> object. 
     * <p>
     * Implementation note: It is a good idea for the input stream to be 
     * buffered.
     *
     * @return  the input stream connected to the error stream of the
     *          subprocess.
     */
	public InputStream getErrorStream() {
		return this.process.getErrorStream();
	}

	/**
	 * Gets the exit value of the subprocess .
	 * @return  the exit value of the subprocess.
	 */
	public int getExitValue() {
		return this.process.exitValue();
	}

	/**
	 * Method will destroy encapsulated process and free up stream resources
	 * associated with the process.  Can be called while process is running or not.
	 * If process is still running, process will be forced to exit before freeing
	 * resources.  It is a good practice to call this method within a finally clause
	 * on the try block surrounding a <code>waitForCompletion</code> call.
	 */
	@Override
    public void close()
    {
        try {
            if (future != null)
            {
                this.future.cancel(false);
            }
        }
        catch (Exception e) {}
		
		try {
            process.destroy();
        }
        catch (Exception e) {}
		
		try {
                    this.readAllData(process.getInputStream());
        }
        catch (Exception e) {}

		try {
                    this.readAllData(process.getErrorStream());
        }
        catch (Exception e) {}

		try {
			process.getInputStream().close();
        }
        catch (Exception e) {}

		try {
			process.getOutputStream().close();
        }
        catch (Exception e) {}

		try {
			process.getErrorStream().close();
        }
        catch (Exception e) {}

    }
    
    private void readAllData(InputStream stream) throws IOException {
        int available = stream.available();
        while (available != 0) {
            byte[] bytes = new byte[available];
            int len = 0;
            do {
                int read = stream.read(bytes);
                if (read >= 0) {
                    len += read;
                }
                else {
                    throw new IOException();
                }
            } while (len < available);
            available = stream.available();
        }
    }
    /**
	 * Makes sure process is destryoed and resources freed before finalizing object
	 * @exception Throwable thrown per the spec
	 */
    protected void finalize() throws Throwable
    {
        this.close();
        super.finalize();
    }
}