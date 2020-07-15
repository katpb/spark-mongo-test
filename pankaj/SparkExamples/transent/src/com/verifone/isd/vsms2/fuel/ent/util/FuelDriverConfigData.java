/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.fuel.ent.util;


/**
 * Contains the fuel driver software version and configuration data.
 * @author kelvin_f1
 */
public class FuelDriverConfigData {

    private String softwareVersion;
    private boolean bufferedPriceMode;
    private boolean priceChangeIdleOnlyMode;

    /**
     * Constructs an object that represents the configuration data returned from the fuel
     * driver layer.
     */
    public FuelDriverConfigData() {

    }

    /**
     * Get the software version of the fuel driver.
     * @return the softwareVersion of the fuel driver.
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Set the software version returned by the fuel driver.
     * @param softwareVersion - the softwareVersion returned by the fuel driver.
     */
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    /**
     * Determines if the driver is configured for buffered price mode.
     * @return the bufferedPriceMode
     *  true - configured for buffered price mode.
     *  false - not configured for buffered price mode.
     */
    public boolean isBufferedPriceMode() {
        return bufferedPriceMode;
    }

    /**
     * Set the value of the fuel driver for buffered price mode.
     * @param bufferedPriceMode
     * true - if buffered price mode is enabled.
     * false - if buffered price mode is not enabled.
     */
    public void setBufferedPriceMode(boolean bufferedPriceMode) {
        this.bufferedPriceMode = bufferedPriceMode;
    }

    /**
     * Determines if the driver is configured to only allow price changes when a
     * dispenser is idle.
     * @return priceChangeIdleOnlyMode
     * true - if prices changes are only allowed while a dispenser is idle.
     * false - if prices changes are allowed in idle and the calling states.
     */
    public boolean isPriceChangeIdleOnlyMode() {
        return priceChangeIdleOnlyMode;
    }

    /**
     * Configure the value returned by the fuel driver to represent the mode to allow
     * price changes only when the driver is in the idle mode.
     * @param priceChangeIdleOnlyMode
     * true - if prices changes are only allowed while a dispenser is idle.
     * false - if prices changes are allowed in idle and the calling states.
     */
    public void setPriceChangeIdleOnlyMode(boolean priceChangeIdleOnlyMode) {
        this.priceChangeIdleOnlyMode = priceChangeIdleOnlyMode;
    }
}
