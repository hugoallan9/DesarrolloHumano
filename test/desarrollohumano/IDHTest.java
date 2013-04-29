/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugo
 */
public class IDHTest {
    
    public IDHTest() {
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
     * Test of calcularIDH method, of class IDH.
     */
    @Test
    public void testCalcularIDH() {
        System.out.println("calcularIDH");
        float esperanza = 0.0F;
        float educacion = 0.0F;
        float PIB = 0.0F;
        IDH instance = new IDH();
        instance.calcularIDH(esperanza, educacion, PIB);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}