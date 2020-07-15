package com.verifone.isd.vsms2.net.ent;


public class NetPDLReply implements  java.io.Serializable

{
    static final long serialVersionUID = 4188896890297378847L;    
    
    public static final int APPROVED = 0;   	 //network approval stored in status
    public static final int REJECTED = 1;		 //network reject stored in status

    private int status;
    private int handling;
    private String replyMessage;
    private String PDLErrorMessage;
 
    public NetPDLReply ()
    {

    }
    
    public int getStatus()
    {
        return this.status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getHandling()
    {
        return this.handling;
    }
    
    public void setHandling(int handling)
    {
        this.handling = handling;
    }
    
    public String getReplyMessage()
    {
        return this.replyMessage;
    }
    
    public void setReplyMessage(String replyMessage)
    {
        this.replyMessage = replyMessage;
    }

    public String getPDLErrorMessage()
    {
        return this.PDLErrorMessage;
    }
    
    public void setPDLErrorMessage(String PDLErrorMessage)
    {
        this.PDLErrorMessage = PDLErrorMessage;
    }
    
}
