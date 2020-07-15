package com.verifone.isd.vsms2.net.ent;

public class NetAutoUpProceedReply implements java.io.Serializable {

    private static final long serialVersionUID = 2757522461500615607L;

    private boolean netAutoUpProceedStatus;

    private String statusMessage = " ";

    /**
     * Checks if is net auto up proceed status.
     * 
     * @return true, if is net auto up proceed status
     */
    public boolean isNetAutoUpProceedStatus() {
	return netAutoUpProceedStatus;
    }

    /**
     * Sets the net auto up proceed status.
     * 
     * @param netAutoUpProceedStatus the new net auto up proceed status
     */
    public void setNetAutoUpProceedStatus(boolean netAutoUpProceedStatus) {
	this.netAutoUpProceedStatus = netAutoUpProceedStatus;
    }

    /**
     * Sets the status message.
     * 
     * @param tempStr the new status message
     */
    public void setStatusMessage(String tempStr) {
	this.statusMessage = tempStr;

    }

    /**
     * Gets the status message.
     * 
     * @return the status message
     */
    public String getStatusMessage() {
	return statusMessage;
    }

}
