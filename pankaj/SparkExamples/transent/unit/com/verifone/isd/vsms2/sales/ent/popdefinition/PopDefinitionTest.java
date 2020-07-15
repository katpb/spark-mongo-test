/*
 * PopDefinitionTest.java
 * JUnit based test
 *
 * Created on March 22, 2006, 12:34 PM
 */

package com.verifone.isd.vsms2.sales.ent.popdefinition;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import junit.framework.*;
import junit.textui.TestRunner;
/**
 *
 * @author bhanu_n2
 */
public class PopDefinitionTest extends TestCase {
    
    public PopDefinitionTest(java.lang.String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(PopDefinitionTest.class);
        return suite;
    }
    
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
    
    /**
     * Test of getDiscAmount method, of class com.verifone.isd.vsms2.sales.ent.popdefinition.PopDefinition.
     */
    public void testGetDiscAmount() {
        System.out.println("testGetDiscAmount");
        PopDefinition def = new PopDefinition(new PopDefinitionPK(1));
        def.getDiscAmount(0);
        def.getDiscAmount(PopDefinition.MAX_PRODUCTS);
        def.getDiscAmount(PopDefinition.MAX_PRODUCTS -1);   
        def.getDiscAmount(PopDefinition.MAX_PRODUCTS +1);        
    }
    
    /**
     * Test of setDiscAmount method, of class com.verifone.isd.vsms2.sales.ent.popdefinition.PopDefinition.
     */
    public void testSetDiscAmount() {
        System.out.println("testSetDiscAmount");
        PopDefinition def = new PopDefinition(new PopDefinitionPK(1));
        MoneyAmount amt = new MoneyAmount(20);
        def.setDiscAmount(0, amt);
        def.setDiscAmount(PopDefinition.MAX_PRODUCTS, amt);
        def.setDiscAmount(PopDefinition.MAX_PRODUCTS -1, amt);   
        def.setDiscAmount(PopDefinition.MAX_PRODUCTS +1, amt);  
        
        this.assertEquals(def.getDiscAmount(0).getLongValue(), 0);
        this.assertEquals(def.getDiscAmount(PopDefinition.MAX_PRODUCTS).getLongValue(), amt.getLongValue());
        this.assertEquals(def.getDiscAmount(PopDefinition.MAX_PRODUCTS -1).getLongValue(), amt.getLongValue());   
        this.assertEquals(def.getDiscAmount(PopDefinition.MAX_PRODUCTS +1).getLongValue(), 0);            
    }
    
    
}
