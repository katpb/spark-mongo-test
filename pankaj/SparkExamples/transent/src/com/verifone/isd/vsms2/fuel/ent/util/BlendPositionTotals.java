package com.verifone.isd.vsms2.fuel.ent.util;


/**
 * Totals returned by from the blend data report from the fuel dispenser.
 * @author kelvin_f1
 */
public class BlendPositionTotals {

    private short fuelingPosition;
    private short numberOfGrades;
    private BlendChangeCount[] blendChangeCountArray;

    /**
     * Construct and object to represent the blend position totals returned by the dispenser.
     */
    public BlendPositionTotals() {

    }

    /**
     * Get the fueling position that returned the pump blend data report.
     * @return - fuelingPosition that returned the pump blend data report.
     */
    public short getFuelingPosition() {
        return fuelingPosition;
    }

    /**
     * Set the fueling position that was returned by the dispenser in the pump blend data
     * report.
     * @param fuelingPosition - fueling position that returned the pump blend data report.
     */
    public void setFuelingPosition(short fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    /**
     * Get the number of grades returned by the dispenser in the pump blend data report.
     * @return the numberOfGrades - number of grades that have blend totals.
     */
    public short getNumberOfGrades() {
        return numberOfGrades;
    }

    /**
     * Set the number of grades returned by the dispenser in the pump blend data report.
     * @param numberOfGrades - number of grade that have blend totals.
     */
    public void setNumberOfGrades(short numberOfGrades) {
        this.numberOfGrades = numberOfGrades;
    }

    /**
     * Get the blend change count totals for all grades returned in the pump blend data report.
     * @return the blendChangeCountArray - contains the pump change count blend totals for
     * all grades.
     */
    public BlendChangeCount[] getBlendChangeCountArray() {
        return blendChangeCountArray;
    }

    /**
     * Set the blend change count totals for all grades returned in pump blend data report.
     * @param blendChangeCountArray - contains the pump change count blend totals for
     * all grades.
     */
    public void setBlendChangeCountArray(BlendChangeCount[] blendChangeCountArray) {
        this.blendChangeCountArray = blendChangeCountArray;
    }
}