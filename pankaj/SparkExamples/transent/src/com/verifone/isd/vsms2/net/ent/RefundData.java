/*
 * RefundData.java
 *
 * Created on Jan 11, 2005
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * class that contains data for a network refund
 *
 * @author linda_t1
 * @version 1.0 Copyright(c) 2005 VeriFone Inc. , All Rights Reserved
 */

public class RefundData implements java.io.Serializable
{
    private String referenceNumber;
    private String invoiceNumber;
    private String saleDate;
    private MoneyAmount originalAmount;
    
    
    static final long serialVersionUID =  994567088068496710L;

	public RefundData() {
            referenceNumber="";
            invoiceNumber="";
            saleDate="";
            originalAmount = new MoneyAmount(0);
        }
    
    public String getReferenceNumber()
    {
            return this.referenceNumber;		
    }

    public void setReferenceNumber(String referenceNumber)
    {
            this.referenceNumber = referenceNumber;		
    }
    
    public String getInvoiceNumber()
    {
            return this.invoiceNumber;		
    }

    public void setInvoiceNumber(String invoiceNumber)
    {
            this.invoiceNumber = invoiceNumber;		
    }
    public String getSaleDate()
    {
            return this.saleDate;		
    }

    public void setSaleDate(String saleDate)
    {
            this.saleDate = saleDate;		
    }

    public void setOriginalAmount(MoneyAmount originalAmount)
    {
        this.originalAmount = originalAmount;
    }

    public MoneyAmount getOriginalAmount()
    {
        return this.originalAmount;
    }
    
}
