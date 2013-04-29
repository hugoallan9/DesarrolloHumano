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
public class EducacionTest {
    
    public EducacionTest() {
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
     * Test of calcularIndice method, of class Educacion.
     */
    @Test
    public void testCalcularIndice() {
        System.out.println("calcularIndice");
        float maximo = 0.0F;
        float minimo = 0.0F;
        float indicador1 = 0.0F;
        float indicador2 = 0.0F;
        Educacion instance = new Educacion();
        instance.calcularIndice(maximo, minimo, indicador1, indicador2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}