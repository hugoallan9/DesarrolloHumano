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
public class IndiceTest {
    
    public IndiceTest() {
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
     * Test of calcularIndice method, of class Indice.
     */
    @Test
    public void testCalcularIndice() {
        System.out.println("calcularIndice");
        float maximo = 0.0F;
        float minimo = 0.0F;
        float indicador = 0.0F;
        Indice instance = new Indice();
        instance.calcularIndice(maximo, minimo, indicador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndex method, of class Indice.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        Indice instance = new Indice();
        float expResult = 0.0F;
        float result = instance.getIndex();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}