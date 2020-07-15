/*
 * RegisterIdFactory.java
 * Created by: Joe Hutzenbiler
 * 2016-12-16
 *
 * COPYRIGHT (c) 2016 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sys.util.register;

import com.verifone.isd.vsms2.sys.util.IRegisterIdFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.lang.reflect.Method;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The 'Global' register ID factory.
 * <p>
 * Because of the need to have a common 'entry' to determine the 'registerID' the VM instance is running on,
 * this implementation of <i>IRegisterIDFactory</i> is based off of the implementation found at
 * <I>com.verifone.isd.topaz.sys.ent.RegisterIdFactory</i>.
 *
 * @author Joe_H5
 */
public class RegisterIdFactory implements IRegisterIdFactory
{

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterIdFactory.class);

    public static final String REGISTER_ID_FACTORY_CLZ_NAME = "sys.ent.registerId.factory.class";
    private static IRegisterIdFactory theInstance;

    private static final int DEFAULT_REG_NUM = 101;
    private static final int DEFAULT_BASE = 100;
    private static final int DEFAULT_MAX = 200;

    private static final int REG_PREFIX_LEN = 5; //topaz is the prefix in host name

    private final int registerId;

    private RegisterIdFactory()
    {
        RegisterType regType = RegisterType.getRegisterType();
        if ((regType == RegisterType.CONTROLLER) || (regType == RegisterType.RUBYCI))
        {
            this.registerId = 0;
        } else
        {
            int regNum = DEFAULT_REG_NUM;
            try
            {
                InetAddress localAddr = InetAddress.getLocalHost();

                /* All topazes are supposed to follow the naming convention 
                 * topaz{xxx} where xxx maps to a register id between 101
                 * and 199. To enforce this naming convention, use the 
                 * getHostName() method instead of getHostAddress(). 
                 * PC simulators will work as long as the register.id property
                 * is set in the property file.
                 */
                String name = localAddr.getHostName();
                String regId = name.substring(REG_PREFIX_LEN);
                regNum = Integer.parseInt(regId);
            } catch (Throwable e)
            {
                try
                {
                    regNum = Integer.parseInt(SysPropertyFactory.getProperty("register.id", String.valueOf(DEFAULT_REG_NUM)));
                } catch (NumberFormatException se)
                {
                }
            } finally
            {
                if (regNum >= DEFAULT_MAX)
                {
                    regNum = (regNum - DEFAULT_MAX) % DEFAULT_BASE;
                }

                if (regNum < 0)
                {
                    regNum = DEFAULT_REG_NUM;
                }
                this.registerId = regNum;
            }
        }

        LOGGER.debug("Reg ID is: {}", this.registerId);
    }

    public static synchronized IRegisterIdFactory getInstance()
    {
        if (theInstance == null)
        {
            try
            {
                String clzName = SysPropertyFactory.getProperty(REGISTER_ID_FACTORY_CLZ_NAME, "");
                clzName = clzName.trim();
                if (!clzName.isEmpty() && !clzName.equals(RegisterIdFactory.class.getName()))
                {
                    Class<?> refDSClz = Class.forName(clzName);
                    Method singletonMethod = refDSClz.getMethod("getInstance", new Class[0]);
                    Class<?> singletonType = singletonMethod.getReturnType();
                    if (IRegisterIdFactory.class.isAssignableFrom(singletonType))
                    {
                        theInstance = IRegisterIdFactory.class.cast(singletonMethod.invoke(null, new Object[0]));
                    } else
                    {
                        LOGGER.warn("Custom implementation does not create an IRegisterIdFactory implementation; using default implementation.");
                    }
                }
            } catch (NoSuchMethodException nsme)
            {
                LOGGER.warn("Factory creation method does not exist; using default implementation.");
            } catch (ClassNotFoundException cnfe)
            {
                LOGGER.warn("Custom Factory class does not exist; using default implementation.");
            } catch (Throwable t)
            {
                LOGGER.warn("Error '{}' encountered in custom IRegisterIdFactory creator; using default implementation.", t.getMessage());
            } finally
            {
                if (null == theInstance)
                {
                    theInstance = new RegisterIdFactory();
                }
            }
        }
        return theInstance;
    }

    @Override
    public int getRegisterId()
    {
        return registerId;
    }

    /**
     * Used for JUnit testing purposes only!
     */
    static synchronized void clearInstance()
    {
        RegisterIdFactory.theInstance = null;
    }
}
