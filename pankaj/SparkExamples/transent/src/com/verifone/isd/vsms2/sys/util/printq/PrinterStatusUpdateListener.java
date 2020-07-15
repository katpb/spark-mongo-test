package com.verifone.isd.vsms2.sys.util.printq;

import jpos.POSPrinterControl112;
import jpos.events.StatusUpdateEvent;

/**
 * Printer status update event listener implementation.
 */
class PrinterStatusUpdateListener implements jpos.events.StatusUpdateListener
{

    private boolean online = false;
    private POSPrinterControl112 thePrinter;

    /**
     * The queue thread this listener is listening for.
     */
    private IPrintQueueStatus ptrQthrd;

    /**
     * Default constructor.
     * @param thePrinter The JPOS printer to determine online status for.
     * @param ptrQthrd The PrinterQueueRunnable that &quot;owns&quot; this object.
     */
    PrinterStatusUpdateListener(POSPrinterControl112 thePrinter,
                                IPrintQueueStatus ptrQthrd)
    {
        this.ptrQthrd = ptrQthrd;
        this.thePrinter = thePrinter;
    }

    public void statusUpdateOccurred(StatusUpdateEvent e)
    {
        synchronized (this)
        {
            switch (e.getStatus())
            {
                case jpos.JposConst.JPOS_SUE_POWER_ONLINE:
                    online = true;
                    notifyAll();
                    break;
                case jpos.JposConst.JPOS_SUE_POWER_OFF:
                case jpos.JposConst.JPOS_SUE_POWER_OFFLINE:
                case jpos.JposConst.JPOS_SUE_POWER_OFF_OFFLINE:
                    online = false;
                    notifyAll();
                    break;
                case jpos.POSPrinterConst.PTR_SUE_IDLE:
                    notifyAll();
                    break;
            }
        }
    }

    /**
     * Wait for printer to be online if not ONLINE. If printer is already
     * ONLINE, return immediately.
     * @param timeout The timeout (in mSec) to wait for an ONLINE condition.
     *                If <i>timeout</i> &lt; 0, then wait for ever.
     *                If <i>timeout</i> == 0, then never wait regardless of ONLINE condition.
     *
     * @return <code>true</code> if printer is ONLINE,
     *         otherwise return <code>false</code>.
     */
    public synchronized boolean waitForOnline(long timeout)
    {
        if (!online)
        {
            if (timeout > 0)
            {
                long endTime = System.currentTimeMillis() + timeout;
                while (!isOnline() && ptrQthrd.isKeepRunning())
                {
                    if (endTime > System.currentTimeMillis())
                    {
                        try
                        {
                            wait(250);
                        } catch (InterruptedException iex)
                        {
                            break;
                        }
                    } else
                    {
                        break;
                    }
                }
            } else if (timeout < 0)
            {
                while (!isOnline() && ptrQthrd.isKeepRunning())
                {
                    try
                    {
                        wait(250);
                    } catch (InterruptedException iex)
                    {
                        break;
                    }
                }
            }
        }
        return online;
    }

    /**
     * Get current online status.
     * @return <code>true</code> if service detects that the printer device is ONLINE.
     */
    public boolean isOnline()
    {
        boolean retValue = false;
        synchronized (this)
        {
            if (this.thePrinter.getState() != jpos.JposConst.JPOS_S_CLOSED)
            {
                try
                {
                    int ps = this.thePrinter.getPowerState();
                    retValue =
                            ((ps == jpos.JposConst.JPOS_PS_ONLINE) || (ps == jpos.JposConst.JPOS_PS_UNKNOWN) && online);
                } catch (Exception e)
                {
                }
            }
        }
        return retValue;
    }

    /**
     * Synchronized call to notifyAll() method of this object.
     */
    public synchronized void signal()
    {
        notifyAll();
    }
}
