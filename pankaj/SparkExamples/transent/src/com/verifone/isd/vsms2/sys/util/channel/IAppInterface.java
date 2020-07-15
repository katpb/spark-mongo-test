package com.verifone.isd.vsms2.sys.util.channel;

/**
 *  interface for common functions for all modules in SapphireVM which talk to new user interfaces.
 *
 *  @author "mailto:david_ezell@verifone.com"
 */
public interface IAppInterface {
    /**
     *  stop this module, freeing all resources and preparing for reinitialization if desired.
     *  @see IRubyChannel#stop()
     */
    public void stop();
}