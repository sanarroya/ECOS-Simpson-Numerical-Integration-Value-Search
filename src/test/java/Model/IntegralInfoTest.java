/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SantiagoAvila
 */
public class IntegralInfoTest {
    
    public IntegralInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumberOfSegments method, of class IntegralInfo.
     */
    @Test
    public void testGetNumberOfSegments() {
        System.out.println("getNumberOfSegments");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        double expResult = 10.0;
        double result = instance.getNumberOfSegments();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getSegmentWidth method, of class IntegralInfo.
     */
    @Test
    public void testGetSegmentWidth() {
        System.out.println("getSegmentWidth");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        double expResult = 0.11;
        double result = instance.getSegmentWidth();
        assertEquals(expResult, result, 0.2);
    }

    /**
     * Test of getDegreesOfFreedom method, of class IntegralInfo.
     */
    @Test
    public void testGetDegreesOfFreedom() {
        System.out.println("getDegreesOfFreedom");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        double expResult = 9.0;
        double result = instance.getDegreesOfFreedom();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getIntegralLowerLimit method, of class IntegralInfo.
     */
    @Test
    public void testGetIntegralLowerLimit() {
        System.out.println("getIntegralLowerLimit");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        double expResult = 0.0;
        double result = instance.getIntegralLowerLimit();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getIntegralUpperLimit method, of class IntegralInfo.
     */
    @Test
    public void testGetIntegralUpperLimit() {
        System.out.println("getIntegralUpperLimit");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        double expResult = 1.1;
        double result = instance.getIntegralUpperLimit();
        assertEquals(expResult, result, 0.0);       
    }

    /**
     * Test of getIntegralResult method, of class IntegralInfo.
     */
    @Test
    public void testGetIntegralResult() {
        System.out.println("getIntegralResult");
        IntegralInfo instance = new IntegralInfo(9, 10.0, 0.0, 1.1, 0.35006);
        instance = (CalculationManager.simpsonIntegral(instance));
        double expResult = instance.getExpectedResult();
        double result = instance.getIntegralResult();
        assertEquals(expResult, result, 0.2);
    }
}