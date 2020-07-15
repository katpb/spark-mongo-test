package com.verifone.isd.vsms2.sys.db.pres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.lang.reflect.Method;

/**
 * Factory method for IReferenceDataSystem implementation.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class ReferenceDataSystemFactory
{
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory.class);
    private static IReferenceDataSystem refDS;
    public static final String REF_DS_CLZ_NAME = "sys.db.refds.class";
    /**
     * Factory method that returns an implementation of IReferenceDataSystem.
     * @return IReferenceDataSystem instance.
     * @throws Exception On error in the factory method.
     */    
    public static synchronized IReferenceDataSystem getInstance() throws Exception { 
        if (null == refDS) {
            try {
                String clzName = SysPropertyFactory.getProperty(REF_DS_CLZ_NAME);
                if (null != clzName && clzName.trim().length() > 4) {
                    Class refDSClz = Class.forName(clzName);
                    Method singletonMethod = refDSClz.getMethod("getInstance", new Class[0]);
                    refDS = (IReferenceDataSystem)singletonMethod.invoke(null, new Object[0]);
                }
            }
            catch (Throwable t) {
                LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory.class).error("Use default class - error in custom IReferenceDataSystem creation: " +t);
                t.printStackTrace();
            }
            finally {
                if (null == refDS) {
                    refDS = (IReferenceDataSystem)ReferenceDataSystem.getInstance(); 
                }
            }
        }
        return refDS; 
    }
}
