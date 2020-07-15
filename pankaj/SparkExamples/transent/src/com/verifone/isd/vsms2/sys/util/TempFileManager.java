/*
 * TempFileManager.java
 *
 * Copyright (C) 2000-2009 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * History:
 *   Date             Action                                   User
 *   May 1, 2009     Creation                                 Joe_H5
 */

package com.verifone.isd.vsms2.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import java.io.File;
import java.util.NoSuchElementException;

/**
 *
 * @todo JavaDoc class, method and field comments
 */
public class TempFileManager extends Thread
{
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.TempFileManager.class);
    // Temporary BMP files will live for the following time (mS)...
    private static long TEMPORARY_FILE_LIFETIME = (5 * 60 * 1000); // 5 minutes
    private java.util.LinkedList queue = new java.util.LinkedList();
    private boolean keepRunning = true;

    private static TempFileManager myInstance = null;

    private TempFileManager()
    {
        super("TempFileManagerThread");
    }

    public void run()
    {
        try {
            while(keepRunning)
            {
                String fileName = null;
                synchronized(this)
                {
                    while (keepRunning && queue.isEmpty())
                    {
                        try {
                            wait();
                        } catch (InterruptedException iex) { }
                    }

                    if (!keepRunning)
                    {
                        break;
                    }

                    TempFileManager.MyQueueElement anElement = null;

                    try {
                        anElement = (TempFileManager.MyQueueElement) queue.removeFirst();
                    } catch (NoSuchElementException nsex) { }

                    if (anElement == null)
                    {
                        continue;
                    }

                    long endTime = anElement.creationTime + TEMPORARY_FILE_LIFETIME;
                    if ( endTime > System.currentTimeMillis())
                    {
                        while(keepRunning)
                        {
                            long waitTime = endTime - System.currentTimeMillis();
                            if (waitTime <= 0)
                            {
                                break;
                            }
                            try {
                                wait(waitTime);
                            } catch (InterruptedException iex) { }
                        }
                    }

                    fileName = anElement.fileName;
                }

                if (fileName != null)
                {
                    File tmpFile = new File(fileName);
                    if (!tmpFile.delete())
                    {
                        logger.error( "POSPrinterEx: Unable to remove tempory file '" + fileName + "'");
                    }
                }
            }
        } finally
        {
            queue.clear();
            queue = null;
        }
    }

    public synchronized static TempFileManager getInstance()
    {
        if (myInstance == null)
        {
            myInstance = new TempFileManager();
            myInstance.start();
        }

        return myInstance;
    }

    public synchronized void addFileName(String fileName)
    {
        queue.addLast( new TempFileManager.MyQueueElement( fileName ) );
        notifyAll();
    }

    public static void stopRunning()
    {
        TempFileManager tfm = null;

        synchronized(TempFileManager.class)
        {
            tfm = myInstance;
            myInstance = null;
        }

        if (tfm != null)
        {
            synchronized(tfm)
            {
                tfm.keepRunning = false;
                tfm.notifyAll();
            }
        }
    }

    private class MyQueueElement
    {
        String fileName;
        long creationTime;

        private MyQueueElement(String fileName)
        {
            this.fileName = fileName;
            creationTime = System.currentTimeMillis();
        }
    }

}
