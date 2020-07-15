/*
 * ThreadPriority.java
 *
 * Created on April 24, 2003, 12:13 PM
 */
package com.verifone.isd.vsms2.sys.util;

/**
 * @author  David_E3
 */
public class ThreadPriority {

    public static final ThreadGroup HI_PRIORITY_GROUP;
    public static final ThreadGroup DEFAULT_GROUP;

    static {
        int curPrio = Thread.currentThread().getPriority();
        DEFAULT_GROUP = new ThreadGroup("NORMAL_PRIORITY");
        DEFAULT_GROUP.setMaxPriority(curPrio);

        HI_PRIORITY_GROUP = new ThreadGroup("HIGH_PRIORITY");
        int hiPrio = curPrio + 1;
        hiPrio = (hiPrio <= Thread.MAX_PRIORITY) ? hiPrio : Thread.MAX_PRIORITY;
        HI_PRIORITY_GROUP.setMaxPriority(hiPrio);
    }

    /* never create this class */
    private ThreadPriority() {
    }
}
