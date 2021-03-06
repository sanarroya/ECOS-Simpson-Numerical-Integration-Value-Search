/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
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
public class LoadDataTest {
    
    public LoadDataTest() {
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
     * Test of loadDataFromFile method, of class LoadData.
     */
    @Test
    public void testLoadDataFromFile() {
        System.out.println("loadDataFromFile");
        String fileName = "dataset.txt";
        List<IntegralInfo> expResult = new ArrayList<>();
        expResult.add(new IntegralInfo(6.0, 10.0, 0.0, 0.0, 0.20));
        expResult.add(new IntegralInfo(15.0, 10.0 , 0.0, 1.0, 0.45));
        expResult.add(new IntegralInfo(4.0, 10.0, 0.0, 3.0, 0.495));
        int equalValues = 0;
        List<IntegralInfo> result = LoadData.loadDataFromFile(fileName);
        if(expResult.size() == result.size()) {
            for(int i = 0; i < expResult.size(); i++) {
                IntegralInfo expElement = expResult.get(i);
                IntegralInfo resultElement = result.get(i);
                if((expElement.getDegreesOfFreedom() == resultElement.getDegreesOfFreedom()) && (expElement.getExpectedResult() == resultElement.getExpectedResult()) && (expElement.getIntegralLowerLimit() == resultElement.getIntegralLowerLimit()) && (expElement.getIntegralUpperLimit() == resultElement.getIntegralUpperLimit())) {
                    equalValues++;
                }
            }
        }else {
            fail("Las listas tienen diferentes longitudes");
        }
        assertEquals(equalValues, expResult.size());
    }
    
}
