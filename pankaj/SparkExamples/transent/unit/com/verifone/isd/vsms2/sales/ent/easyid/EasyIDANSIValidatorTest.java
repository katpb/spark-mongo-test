/*
 * EasyIDANSIValidator.java
 * JUnit based test
 *
 * Created on April 07, 2010, 11:03 AM
 */

package com.verifone.isd.vsms2.sales.ent.easyid;

import com.verifone.isd.vsms2.sales.ent.easyid.*;
import junit.framework.*;
import junit.textui.TestRunner;
/**
 *
 * @author sayeed_m1
 */
public class EasyIDANSIValidatorTest extends TestCase {
    
    public EasyIDANSIValidatorTest(java.lang.String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(EasyIDANSIValidatorTest.class);
        return suite;
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    /**
     * Test of getDateFormat method, of class com.verifone.isd.vsms2.sales.ent.easyid.EasyIDANSIValidator
     */
    public void testGetDateFormat() {
        
        boolean parsedResult = false;
        // YYMM
        String inputData1 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB6309 DBA1212 DBC DAJPR DAK303411113";
        // YYMMDD
        String inputData2 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB721015 DBA240520 DBC DAJID DAK303411113";
        //YYYYMMDD
        String inputData3 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB19560913 DBA20161215 DBC DAJFL DAK303411113";
        //MMDDYYYY
        String inputData4 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB10061975 DBA07302015 DBC DAJGA DAK303411113";
        //MM-DD-YYYY
        String inputData5 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB10-09-1983 DBA11-21-2010 DBC DAJAL DAK303411113";
        //YYY - invalid
		String inputData6 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB983 DB010 DBC DAJCA DAK303411113";
		
		String inputData7 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB";
		
		String inputData8 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBA";

		String inputData9 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBADBB";

		String inputData10 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBA9957";

		String inputData11 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB997354";

		String inputData12 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB017783 DBA738104 DBC DAJCA DAK303411113";
		
		String inputData13 ="@   ANSI 6360550 30002DL00410242ZG02830112DLDCAC DBB999999 DBA776655 DBC DAJCA DAK303411113";
		
		String inputData14 ="@   ANSI 6360100 90002DL00410246ZF02870067DLDAQS265644351050\nDCSANKA\nDDER\nDACARNE\nDBD12192017 DBB01051965 DBA01052026";

        System.out.println("testDateFormat");
        
        EasyIDANSIValidator testEasyID = EasyIDANSIValidator.getInstance();
        EasyIDData easyIDData = new EasyIDData();
        
        byte[] input = inputData1.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);        
        this.clearEasyIDData(easyIDData);
        
        input = inputData2.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);        
        this.clearEasyIDData(easyIDData);
        
        input = inputData3.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);        
        this.clearEasyIDData(easyIDData);
        
        input = inputData4.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);        
        this.clearEasyIDData(easyIDData);
        
        input = inputData5.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);
        this.clearEasyIDData(easyIDData);

        input = inputData6.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

        input = inputData7.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

        input = inputData8.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

        input = inputData9.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

        input = inputData10.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, true);
        this.clearEasyIDData(easyIDData);

        input = inputData11.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

        input = inputData12.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);

		input = inputData13.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(parsedResult, false);
        this.clearEasyIDData(easyIDData);
		
		input = inputData14.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(easyIDData.firstName, "ARNE");
        this.clearEasyIDData(easyIDData);
		
		input = inputData14.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(easyIDData.driverId, "S265644351050");
        this.clearEasyIDData(easyIDData);
		
		input = inputData14.getBytes();
        parsedResult = testEasyID.validateInput(input, easyIDData);
        assertEquals(easyIDData.lastName, "ANKA");
        this.clearEasyIDData(easyIDData);

    }
    
    public void clearEasyIDData(EasyIDData easyIDData){
        
        easyIDData.expMonth = "";
        easyIDData.expYear = "";
        easyIDData.birthDay = "";
        easyIDData.birthMonth = "";
        easyIDData.birthYear = "";
        easyIDData.state = "";
		easyIDData.firstName = "";
		easyIDData.middleName = "";
		easyIDData.lastName = "";
		easyIDData.driverId = "";
    }
      
    
}
