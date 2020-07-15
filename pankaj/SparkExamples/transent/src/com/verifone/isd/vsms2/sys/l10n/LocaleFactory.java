/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 25 Feb, 2005                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sys.l10n;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sudesh_s1
 *
 */
public class LocaleFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.l10n.LocaleFactory.class);
    private static LocaleFactory myInstance;
    private Thread localeFactoryThread;
    private Locale[] supportedLocales;

    private LocaleFactory() throws Exception {
        this.localeFactoryThread = new Thread(new LocaleFactoryRunnable(), getClass().getName() + ".LocaleFactoryRunnable");
        localeFactoryThread.start();
    }
    
    public static LocaleFactory getInstance() throws Exception {
        if (myInstance == null) {
            myInstance = new LocaleFactory();
        }
        return myInstance;
        
    }
    
    public Locale[] getSupportedLocales() {
        try {
        logger.debug( "LocaleFactory:getSupportedLocales begin");
        this.localeFactoryThread.join();
        logger.debug( "LocaleFactory:getSupportedLocales end");
        } catch(InterruptedException ie) {
            logger.error( ie.getMessage());
        }
        return supportedLocales;
    }

    private class LocaleFactoryRunnable implements Runnable {
        
        public void run() {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            logger.debug( "LocaleFactory:LocaleFactoryRunnable;run begin " + Thread.currentThread().getPriority());
            
            Locale[] availLocales = Locale.getAvailableLocales();
            int numAvailLocales = availLocales.length;
            logger.debug( "LocaleFactory:LocaleFactoryRunnable;run numAvailLocales-" + numAvailLocales);

            Locale defaultLocale = Locale.getDefault();
            logger.debug( "LocaleFactory:LocaleFactoryRunnable;run default Locale-" + defaultLocale);
            ArrayList locales = new ArrayList();
            locales.add(Locale.getDefault());

            for (int i = 0; i < numAvailLocales; i++) {
                Locale locale = availLocales[i];
                if(!defaultLocale.getLanguage().equalsIgnoreCase(locale.getLanguage()))
                    locales.add(availLocales[i]);
            }
            supportedLocales = (Locale[])locales.toArray(new Locale[0]);
            logger.debug( "LocaleFactory:LocaleFactoryRunnable;run end");
        }
        
    }
}


