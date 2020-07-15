/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 12 March, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.util;
/**
 * The ICustomServiceManager interface provides a way to start or stop a service
 * that is specific to an application. For the custom service to be invoked, the
 * property 'customServiceManager.class' needs to be set and should point to the
 * implementation class of this interface.
 * 
 * This mechanism is being used in EPSPAK for starting a listener on Newpro for
 * unsolicited service requests from EPS.
 * 
 * @author Ganesh_k1
 */
public interface ICustomServiceManager {
    /**
     * This method will start the Service request manager. 
     */
    public void start();
    /**
     * This method will stop the service request manager. 
     */
    public void stop();
    
    /**
     * Refreshes network settings.
     */
    public void refresh() throws Exception;
}
