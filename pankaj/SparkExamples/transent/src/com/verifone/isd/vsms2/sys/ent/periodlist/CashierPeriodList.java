package com.verifone.isd.vsms2.sys.ent.periodlist;

public class CashierPeriodList {
    private String filename;
    private boolean isOpen;
    private int empId;
    private int registerNumber;
    private int periodNumber;
    private String closedDate;

    /**
     * Returns the file name used to request cashier period data.
     * @return Returns The file name.
     */
    public String getFilename() {
        return this.filename;
    }

	/**
     * Sets the file name used to request cashier period data.
     * @param filename The new file name.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Returns the is open flag setting.
     * @return Returns The is open flag setting.
     */
    public boolean getIsOpen() {
        return this.isOpen;
    }

    /**
     * Sets the is open flag.
     * @param isOpen The new is open flag.
     */
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * Returns the employee ID setting.
     * @return Returns The employee ID setting.
     */
    public int getEmpId() {
        return this.empId;
    }

    /**
     * Sets the employee ID.
     * @param empId The new employee ID.
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * Returns the register number setting.
     * @return Returns The register number setting.
     */
    public int getRegisterNumber() {
        return this.registerNumber;
    }

    /**
     * Sets the register number.
     * @param registerNumber The new register number.
     */
    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    /**
     * Returns the period number setting.
     * @return Returns The period number setting.
     */
    public int getPeriodNumber() {
        return this.periodNumber;
    }

    /**
     * Sets the period number.
     * @param periodNumber The new period number.
     */
    public void setPeriodNumber(int periodNumber) {
        this.periodNumber = periodNumber;
    }

    /**
     * Returns the closed date setting.
     * @return Returns The closed date setting.
     */
    public String getClosedDate() {
        return this.closedDate;
    }

    /**
     * Sets the closed date.
     * @param closedDate The new closed date.
     */
    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }
    
}
