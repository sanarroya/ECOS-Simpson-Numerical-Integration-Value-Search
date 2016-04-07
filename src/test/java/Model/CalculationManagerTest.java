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
public class CalculationManagerTest {
    
    public CalculationManagerTest() {
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
     * Test of simpsonIntegral method, of class CalculationManager.
     */
    @Test
    public void testSimpsonIntegral() {
        System.out.println("simpsonIntegral");
        IntegralInfo integralInfo = new IntegralInfo();
        integralInfo.setIntegralLowerLimit(0.0);
        integralInfo.setIntegralUpperLimit(1.1);
        integralInfo.setDegreesOfFreedom(9);
        integralInfo.setNumberOfSegments(10.0);
        double expResult = 0.35006;
        IntegralInfo resultIntegral = CalculationManager.simpsonIntegral(integralInfo);
        double result = resultIntegral.getIntegralResult();
        assertEquals(expResult, result, 0.2);
    }
    
}
