/*
 * TestBreakPoint.java
 *
 * Created on August 11, 2006, 2:24 PM
 */

package com.verifone.isd.vsms2.sales.ent.tax;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
/**
 *
 * @author  bhanu_n2
 */
public class TestTax extends TestCase {
    
    /** Creates a new instance of TestBreakPoint */
    public TestTax() {
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
        System.exit(0);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(TestTax.class);
        return suite;
    }
    
    public void testComputeTaxInvalidBPRepeatAIOOB() throws Exception {
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("MD");
        t.setIndicator("T");
        t.setRatePercent(new Quantity("5.000", Tax.MAX_RATE_DECIMALS, "%"));
        t.setStartAmount(new MoneyAmount("0.00", Tax.MAX_AMT_DECIMALS));
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.20", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(2);
        bProps.setRepeatEndNum(2);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 19, 1);
        bProps.addBreakPoint(bpt);
        try {
            t.validate();
            fail(" EXPECTED INVALID CONFIGURATION ERROR HERE!!!");
        }
        catch (Exception e) {
        }
    }
    
    public void testComputeTaxMD() throws Exception {
        System.out.println("testComputeTaxMD");           
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("MD");
        t.setIndicator("T");
        t.setRatePercent(new Quantity("5.000", Tax.MAX_RATE_DECIMALS, "%"));
        t.setStartAmount(new MoneyAmount("0.00", Tax.MAX_AMT_DECIMALS));
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.20", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(2);
        bProps.setRepeatEndNum(2);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 0, 1);
        bProps.addBreakPoint(bpt);
        
        bpt = new BreakPoint(2, 19, 1);
        bProps.addBreakPoint(bpt); 
        
        t.validate();
        this.dumpTaxTable(t);
        assertEquals(t.computeTax(new MoneyAmount(1)).getLongValue(), 0);
        assertEquals(t.computeTax(new MoneyAmount(19)).getLongValue(), 0);  
        assertEquals(t.computeTax(new MoneyAmount(20)).getLongValue(), 1);    
        assertEquals(t.computeTax(new MoneyAmount(21)).getLongValue(), 2);          
        assertEquals(t.computeTax(new MoneyAmount(39)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(40)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(41)).getLongValue(), 3);  
        assertEquals(t.computeTax(new MoneyAmount(589)).getLongValue(), 30);  
        assertEquals(t.computeTax(new MoneyAmount(600)).getLongValue(), 30);        
        assertEquals(t.computeTax(new MoneyAmount(921)).getLongValue(), 47);    
        assertEquals(t.computeTax(new MoneyAmount(940)).getLongValue(), 47); 
        assertEquals(t.computeTax(new MoneyAmount(941)).getLongValue(), 48);     
        assertEquals(t.computeTax(new MoneyAmount(321)).getLongValue(), 17);           
    }
    
    public void testComputeTaxOneBP() throws Exception {
        System.out.println("testComputeTaxOneBP");        
        Tax t1 = new Tax();
        t1.setPK(new TaxPK(1));
        t1.setName("ONE BP");
        t1.setIndicator("T");
        t1.setRatePercent(new Quantity("5.000", Tax.MAX_RATE_DECIMALS, "%"));
        t1.setStartAmount(new MoneyAmount("0.00", Tax.MAX_AMT_DECIMALS));
        
        t1.setRegistrationNum("");
        t1.setPriceIncludesTax(false);
        t1.setFuelIncludesTax(false);
        t1.setPromptForExemption(false);
        t1.setBreakPoint(true);
        BreakPointProps bProps1 = new BreakPointProps();
        bProps1.setMinimumTaxableAmount(new MoneyAmount("0.20", Tax.MAX_AMT_DECIMALS));
        bProps1.setRepeatStartNum(1);
        bProps1.setRepeatEndNum(1);
        bProps1.setApplyForAllAmounts(true);
        t1.setBreakPointProps(bProps1);
        
        BreakPoint bpt = new BreakPoint(1, 19, 1);
        bProps1.addBreakPoint(bpt);    
        t1.validate();
        
        this.dumpTaxTable(t1);
        assertEquals(t1.computeTax(new MoneyAmount(1)).getLongValue(), 0);
        assertEquals(t1.computeTax(new MoneyAmount(19)).getLongValue(), 0);  
        assertEquals(t1.computeTax(new MoneyAmount(20)).getLongValue(), 1);    
        assertEquals(t1.computeTax(new MoneyAmount(21)).getLongValue(), 1);          
        assertEquals(t1.computeTax(new MoneyAmount(39)).getLongValue(), 1);  
        assertEquals(t1.computeTax(new MoneyAmount(40)).getLongValue(), 2);  
        assertEquals(t1.computeTax(new MoneyAmount(59)).getLongValue(), 2);  
        assertEquals(t1.computeTax(new MoneyAmount(60)).getLongValue(), 3);          
        System.out.println(t1.computeTax(new MoneyAmount(590)));    
    }
    
    public void testComputeTaxVA() throws Exception {
        System.out.println("testComputeTaxVA");
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("VA");
        t.setIndicator("V");
        t.setRatePercent(new Quantity("4.500", Tax.MAX_RATE_DECIMALS, "%"));
        t.setStartAmount(new MoneyAmount("0.00", Tax.MAX_AMT_DECIMALS));
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.12", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(1);
        bProps.setRepeatEndNum(9);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 21, 1);
        bProps.addBreakPoint(bpt);
        bpt = new BreakPoint(2, 21, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(3, 21, 1);
        bProps.addBreakPoint(bpt);   
        bpt = new BreakPoint(4, 21, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(5, 22, 1);
        bProps.addBreakPoint(bpt);  
        bpt = new BreakPoint(6, 21, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(7, 21, 1);
        bProps.addBreakPoint(bpt);  
        bpt = new BreakPoint(8, 21, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(9, 22, 1);
        bProps.addBreakPoint(bpt);  
        t.validate();
        
        this.dumpTaxTable(t);
        assertEquals(t.computeTax(new MoneyAmount(1)).getLongValue(), 0);
        assertEquals(t.computeTax(new MoneyAmount(11)).getLongValue(), 0);  
        assertEquals(t.computeTax(new MoneyAmount(12)).getLongValue(), 1);    
        assertEquals(t.computeTax(new MoneyAmount(32)).getLongValue(), 1);         
        assertEquals(t.computeTax(new MoneyAmount(33)).getLongValue(), 1);          
        assertEquals(t.computeTax(new MoneyAmount(34)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(40)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(55)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(56)).getLongValue(), 3);  
        assertEquals(t.computeTax(new MoneyAmount(60)).getLongValue(), 3);        
        assertEquals(t.computeTax(new MoneyAmount(77)).getLongValue(), 3);    
        assertEquals(t.computeTax(new MoneyAmount(78)).getLongValue(), 4); 
        assertEquals(t.computeTax(new MoneyAmount(98)).getLongValue(), 4);     
        assertEquals(t.computeTax(new MoneyAmount(99)).getLongValue(), 4);  
        assertEquals(t.computeTax(new MoneyAmount(100)).getLongValue(), 5); 
        assertEquals(t.computeTax(new MoneyAmount(120)).getLongValue(), 5);     
        assertEquals(t.computeTax(new MoneyAmount(122)).getLongValue(), 5); 
        assertEquals(t.computeTax(new MoneyAmount(123)).getLongValue(), 6); 
        assertEquals(t.computeTax(new MoneyAmount(143)).getLongValue(), 6);     
        assertEquals(t.computeTax(new MoneyAmount(144)).getLongValue(), 6); 
        assertEquals(t.computeTax(new MoneyAmount(145)).getLongValue(), 7); 
        assertEquals(t.computeTax(new MoneyAmount(160)).getLongValue(), 7);     
        assertEquals(t.computeTax(new MoneyAmount(166)).getLongValue(), 7); 
        assertEquals(t.computeTax(new MoneyAmount(167)).getLongValue(), 8); 
        assertEquals(t.computeTax(new MoneyAmount(180)).getLongValue(), 8);     
        assertEquals(t.computeTax(new MoneyAmount(188)).getLongValue(), 8);  
        assertEquals(t.computeTax(new MoneyAmount(189)).getLongValue(), 9); 
        assertEquals(t.computeTax(new MoneyAmount(199)).getLongValue(), 9);     
        assertEquals(t.computeTax(new MoneyAmount(211)).getLongValue(), 9);  
        assertEquals(t.computeTax(new MoneyAmount(212)).getLongValue(), 10); 
        assertEquals(t.computeTax(new MoneyAmount(299)).getLongValue(), 13); 
        assertEquals(t.computeTax(new MoneyAmount(500)).getLongValue(), 23);
        assertEquals(t.computeTax(new MoneyAmount(540)).getLongValue(), 24);
        assertEquals(t.computeTax(new MoneyAmount(544)).getLongValue(), 24); 
        assertEquals(t.computeTax(new MoneyAmount(1433)).getLongValue(), 64);         
    }    

   public void testComputeTaxVT() throws Exception {
       System.out.println("testComputeTaxVT");
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("VT");
        t.setIndicator("V");
        t.setRatePercent(new Quantity("7.000", Tax.MAX_RATE_DECIMALS, "%"));
        t.setStartAmount(new MoneyAmount("0.00", Tax.MAX_AMT_DECIMALS));
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.01", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(1);
        bProps.setRepeatEndNum(7);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 13, 1);
        bProps.addBreakPoint(bpt);
        bpt = new BreakPoint(2, 13, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(3, 14, 1);
        bProps.addBreakPoint(bpt);   
        bpt = new BreakPoint(4, 13, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(5, 13, 1);
        bProps.addBreakPoint(bpt);  
        bpt = new BreakPoint(6, 13, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(7, 14, 1);
        bProps.addBreakPoint(bpt);  
        t.validate();
        dumpTaxTable(t);
        
        assertEquals(t.computeTax(new MoneyAmount(0)).getLongValue(), 0);
        assertEquals(t.computeTax(new MoneyAmount(1)).getLongValue(), 1);
        assertEquals(t.computeTax(new MoneyAmount(13)).getLongValue(), 1);  
        assertEquals(t.computeTax(new MoneyAmount(14)).getLongValue(), 1);    
        assertEquals(t.computeTax(new MoneyAmount(15)).getLongValue(), 2);          
        assertEquals(t.computeTax(new MoneyAmount(27)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(28)).getLongValue(), 2);  
        assertEquals(t.computeTax(new MoneyAmount(29)).getLongValue(), 3);  
        assertEquals(t.computeTax(new MoneyAmount(43)).getLongValue(), 3);  
        assertEquals(t.computeTax(new MoneyAmount(42)).getLongValue(), 3);          
        assertEquals(t.computeTax(new MoneyAmount(589)).getLongValue(), 42);  
        assertEquals(t.computeTax(new MoneyAmount(600)).getLongValue(), 42);        
        assertEquals(t.computeTax(new MoneyAmount(629)).getLongValue(), 45);    
        assertEquals(t.computeTax(new MoneyAmount(630)).getLongValue(), 45); 
        assertEquals(t.computeTax(new MoneyAmount(671)).getLongValue(), 47);     
        assertEquals(t.computeTax(new MoneyAmount(700)).getLongValue(), 49);        
   } 

   /*
   public void testComputeTaxQA1() throws Exception {
       System.out.println("testComputeTaxQA1");
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("QA");
        t.setIndicator("Q");
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.01", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(1);
        bProps.setRepeatEndNum(4);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 400, 100);
        bProps.addBreakPoint(bpt);
        bpt = new BreakPoint(2, 500, 110);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(3, 600, 120);
        bProps.addBreakPoint(bpt);   
        bpt = new BreakPoint(4, 700, 130);
        bProps.addBreakPoint(bpt); 
        t.validate();
        
        dumpTaxTable(t);
        System.out.println("Amt: " +new MoneyAmount(0) +" Tax: " + t.computeTax(new MoneyAmount(0)).getLongValue());
        System.out.println("Amt: " +new MoneyAmount(1) +" Tax: " + t.computeTax(new MoneyAmount(1)).getLongValue());
        System.out.println("Amt: " +new MoneyAmount(400) +" Tax: " + t.computeTax(new MoneyAmount(400)).getLongValue());  
        System.out.println("Amt: " +new MoneyAmount(401) +" Tax: " + t.computeTax(new MoneyAmount(401)).getLongValue());    
        System.out.println("Amt: " +new MoneyAmount(402) +" Tax: " + t.computeTax(new MoneyAmount(402)).getLongValue());          
        System.out.println("Amt: " +new MoneyAmount(888) +" Tax: " + t.computeTax(new MoneyAmount(888)).getLongValue());  
        System.out.println("Amt: " +new MoneyAmount(901) +" Tax: " + t.computeTax(new MoneyAmount(901)).getLongValue());  
        System.out.println("Amt: " +new MoneyAmount(902) +" Tax: " + t.computeTax(new MoneyAmount(902)).getLongValue());  
        System.out.println("Amt: " +new MoneyAmount(903) +" Tax: " + t.computeTax(new MoneyAmount(903)).getLongValue());  
        System.out.println("Amt: " +new MoneyAmount(1503) +" Tax: " + t.computeTax(new MoneyAmount(1503)).getLongValue());        
        System.out.println("Amt: " +new MoneyAmount(1504) +" Tax: " + t.computeTax(new MoneyAmount(1504)).getLongValue());    
        System.out.println("Amt: " +new MoneyAmount(1505) +" Tax: " + t.computeTax(new MoneyAmount(1505)).getLongValue()); 
        System.out.println("Amt: " +new MoneyAmount(2204) +" Tax: " + t.computeTax(new MoneyAmount(2204)).getLongValue());     
        System.out.println("Amt: " +new MoneyAmount(2206) +" Tax: " + t.computeTax(new MoneyAmount(2206)).getLongValue());    
 
   }  
   
    public void testComputeTaxQA2() throws Exception {
        System.out.println("testComputeTaxQA2");
        Tax t = new Tax();
        t.setPK(new TaxPK(1));
        t.setName("Q2");
        t.setIndicator("2");
        
        t.setRegistrationNum("");
        t.setPriceIncludesTax(false);
        t.setFuelIncludesTax(false);
        t.setPromptForExemption(false);
        t.setBreakPoint(true);
        BreakPointProps bProps = new BreakPointProps();
        bProps.setMinimumTaxableAmount(new MoneyAmount("0.11", Tax.MAX_AMT_DECIMALS));
        bProps.setRepeatStartNum(1);
        bProps.setRepeatEndNum(6);
        bProps.setApplyForAllAmounts(true);
        t.setBreakPointProps(bProps);
        
        BreakPoint bpt = new BreakPoint(1, 6, 1);
        bProps.addBreakPoint(bpt);
        bpt = new BreakPoint(2, 16, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(3, 15, 1);
        bProps.addBreakPoint(bpt);   
        bpt = new BreakPoint(4, 16, 1);
        bProps.addBreakPoint(bpt); 
        bpt = new BreakPoint(5, 16, 1);
        bProps.addBreakPoint(bpt);  
        bpt = new BreakPoint(6, 25, 1);
        bProps.addBreakPoint(bpt); 
         
        t.validate();
        
        this.dumpTaxTable(t);
        
        System.out.println("Amt: " +new MoneyAmount(500) +" Tax: " + t.computeTax(new MoneyAmount(500)).getLongValue());        

    }    */
   
   
   private void dumpTaxTable(Tax t) {
       long taxValue = 0;
       BreakPointProps breakPointProps = t.getBreakPointProps();
       if (breakPointProps != null ) {
           MoneyAmount minTaxable = breakPointProps.getMinimumTaxableAmount();
           long tableTaxableVal = (minTaxable == null) ? 0 : minTaxable.getLongValue();
           int taxNr = 1;
           TaxTableEntry curEntry = new TaxTableEntry();
           System.out.println("BP Tax Table for Tax: " +t.getPK() +" - " +t.getName());
           System.out.println("No.\tStart\tEnd\tTax");
           if (tableTaxableVal > 0) {
               curEntry.setEnd(new MoneyAmount(tableTaxableVal -1));
               System.out.println(taxNr++ +"\t" +curEntry.getStart() +"\t" +curEntry.getEnd() +"\t" +curEntry.getTax());
           }
           BreakPoint[] breakPts = breakPointProps.getBreakPoints();
           int nonRepIndexEnd = breakPointProps.getRepeatStartNum() -1;
           if (nonRepIndexEnd < 0) {
               nonRepIndexEnd = breakPts.length;
           }
           if (nonRepIndexEnd > breakPts.length) {
               nonRepIndexEnd = breakPts.length;
           }
            /*
             ** Compute tax for non repeat portion of the break point table
             */
           for (int i = 0; i < nonRepIndexEnd; i++) {
               //Update taxable and tax values for each non-repetitive break point value
               curEntry = new TaxTableEntry();
               curEntry.setStart(new MoneyAmount(tableTaxableVal));  
               tableTaxableVal += breakPts[i].getAmountDifference();
               taxValue += breakPts[i].getIncrement();
               curEntry.setEnd(new MoneyAmount(tableTaxableVal));
               curEntry.setTax(new MoneyAmount(taxValue));
               tableTaxableVal++;
               
               System.out.println(taxNr++ +"\t" +curEntry.getStart() +"\t" +curEntry.getEnd() +"\t" +curEntry.getTax());
           }
           int loopBeginIndex = breakPointProps.getRepeatStartNum() -1;
           int loopEndNum = breakPointProps.getRepeatEndNum();
           
           if (loopBeginIndex >= 0 && loopEndNum > 0 && loopBeginIndex < loopEndNum
           && loopBeginIndex < breakPts.length && loopEndNum <= breakPts.length) {
               while (taxNr < 100) {
                   for (int i = loopBeginIndex; i < loopEndNum; i++) {
                       /*
                       System.out.print(taxNr++ +"\t" +new MoneyAmount(tableTaxableVal) +"\t");
                       tableTaxableVal += breakPts[i].getAmountDifference();
                       taxValue += breakPts[i].getIncrement();
                       System.out.println(new MoneyAmount(tableTaxableVal) +"\t" +new MoneyAmount(taxValue));
                       tableTaxableVal++; // Increment to account for next iteration begin value (e.g., 20 - 39, 40 - 59, 60 - 79 etc) */
                       
                       curEntry = new TaxTableEntry();
                       curEntry.setStart(new MoneyAmount(tableTaxableVal));
                       tableTaxableVal += breakPts[i].getAmountDifference();
                       taxValue += breakPts[i].getIncrement();
                       curEntry.setEnd(new MoneyAmount(tableTaxableVal));
                       curEntry.setTax(new MoneyAmount(taxValue));
                       tableTaxableVal++;
                       
                       System.out.println(taxNr++ +"\t" +curEntry.getStart() +"\t" +curEntry.getEnd() +"\t" +curEntry.getTax());
                   }
               }
           }
           System.out.println("========  End tax table =======");
       }
   }
   

   private class TaxTableEntry {
    /**
     * Holds value of property start.
     */
    private MoneyAmount start;
    
    /**
     * Holds value of property end.
     */
    private MoneyAmount end;
    
    /**
     * Holds value of property tax.
     */
    private MoneyAmount tax;       
       /**
        * Getter for property start.
        * @return Value of property start.
        */
       public MoneyAmount getStart() {
           return (this.start == null) ? new MoneyAmount(0) : this.start;
       }
       
       /**
        * Setter for property start.
        * @param start New value of property start.
        */
       public void setStart(MoneyAmount start) {
           this.start = start;
       }
       
       /**
        * Getter for property end.
        * @return Value of property end.
        */
       public MoneyAmount getEnd() {
           return (this.end == null) ? new MoneyAmount(0) : this.end;
       }
       
       /**
        * Setter for property end.
        * @param end New value of property end.
        */
       public void setEnd(MoneyAmount end) {
           this.end = end;
       }
       
       /**
        * Getter for property tax.
        * @return Value of property tax.
        */
       public MoneyAmount getTax() {
          return (this.tax == null) ? new MoneyAmount(0) : this.tax;
       }
       
       /**
        * Setter for property tax.
        * @param tax New value of property tax.
        */
       public void setTax(MoneyAmount tax) {
           this.tax = tax;
       }
   }
}
