package com.verifone.isd.vsms2.sales.ent.bluelaw;

import com.verifone.isd.vsms2.sys.util.DayTimeRange;
import java.io.Serializable;

/** Helper class for BlueLaw to give a day's effective time ranges
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class BlueLawProps implements Serializable {
    static final long serialVersionUID = -147455857638392067L;
    private boolean isEffective;
    private DayTimeRange[] effectiveHours;
    /** Maximum blue law period ranges within a day
     */    
    public static final int MAX_EFFECTIVE_PERIODS = 2;
    
    /** Constructor
     * @param isEffective enables/ disables the period range
     */    
    public BlueLawProps(boolean isEffective) {
        this.isEffective = isEffective;
        this.effectiveHours = new DayTimeRange[0];
    }
    
    /** No-args constructor
     */    
    public BlueLawProps() {
        this(false);
    }
    
    /** Getter for property effective
     * @return true if blue law is in effect for the day
     */    
    public boolean isEffective() {
        return this.isEffective;
    }
    
    /** Setter for property effective
     * @param isTrue enables if true
     */    
    public void setEffective(boolean isTrue) {
        this.isEffective = isTrue;
        if (!isTrue)
            this.effectiveHours = new DayTimeRange[0];
    }
    
    /** Getter for property effectiveHours
     * @return effective durations in the day
     */    
    public DayTimeRange[] getEffectiveHours() {
        return this.effectiveHours;
    }
    
    /** Setter for property effectiveHours
     * @param effectiveHours effective durations in the day
     * @throws Exception on invalid duration data
     */    
    public void setEffectiveHours(DayTimeRange[] effectiveHours) throws Exception {
        if (effectiveHours == null) {
            this.effectiveHours = new DayTimeRange[0];
        }
        else if (effectiveHours.length <= MAX_EFFECTIVE_PERIODS) {
            this.effectiveHours = effectiveHours;
        }
        else {
            throw new Exception("Only " +this.MAX_EFFECTIVE_PERIODS +" effective periods allowed");
        }
    }
    
    /** Validator for the object attributes
     * @throws Exception on any invalid data
     */    
    public void validate() throws Exception {
        if (this.isEffective()) {
            DayTimeRange[] ranges = this.getEffectiveHours();
            if ((ranges != null) && (ranges.length > MAX_EFFECTIVE_PERIODS)) {
                throw new Exception("Only " +MAX_EFFECTIVE_PERIODS
                +" effective periods are allowed");
            }
        }
    }
}