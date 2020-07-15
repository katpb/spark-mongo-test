/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.fuel.ent.util;

/**
 * Blend Change count totals returned by the dispenser in a pump blend report for a single
 * grade of fuel on a hose.
 * @author kelvin_f1
 */
public class BlendChangeCount {

    private short pumpChangeCount;
    private short consoleChangeCount;
    private short lowBlendPercentage;

    /**
     * Constructs an object that represents the blend change count totals for a single grade
     * assigned to a hose on a dispenser.
     */
    public BlendChangeCount() {

    }

    /**
     * Get the pump change count for a grade assigned to a hose returned in the pump blend report.
     * @return pumpChangeCount - the pump change count for a grade assigned to a hose
     * returned in the pump blend report.
     */
    public short getPumpChangeCount() {
        return pumpChangeCount;
    }

    /**
     * Set the pump change count for a grade assigned to a hose returned in the pump blend report.
     * @param pumpChangeCount - the pump change count for a grade assigned to a hose
     */
    public void setPumpChangeCount(short pumpChangeCount) {
        this.pumpChangeCount = pumpChangeCount;
    }

    /**
     * Get the console change count for a grade assigned to a hose returned in the pump blend report.
     * @return the consoleChangeCount - the console change count for a grade assigned to a hose
     * returned in the pump blend report.
     */
    public short getConsoleChangeCount() {
        return consoleChangeCount;
    }

    /**
     * Set the console change count for a grade assigned to a hose returned in the pump blend report.
     * @param consoleChangeCount - the console change count for a grade assigned to a hose
     * returned in the pump blend report.
     */
    public void setConsoleChangeCount(short consoleChangeCount) {
        this.consoleChangeCount = consoleChangeCount;
    }

    /**
     * Get the low blend percentage for a grade assigned to a hose returned in the pump blend report.
     * @return lowBlendPercentage - the low blend percentage for a grade assigned to a hose returned
     * in the pump blend report.
     */
    public short getLowBlendPercentage() {
        return lowBlendPercentage;
    }

    /**
     * Set the low blend percentage for a grade assigned to a hose returned in the pump blend report.
     * @param lowBlendPercentage - the low blend percentage for a grade assigned to a hose returned
     * in the pump blend report.
     */
    public void setLowBlendPercentage(short lowBlendPercentage) {
        this.lowBlendPercentage = lowBlendPercentage;
    }


}
