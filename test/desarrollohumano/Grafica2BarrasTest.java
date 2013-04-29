/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Graphics;
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
public class Grafica2BarrasTest {
    
    public Grafica2BarrasTest() {
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
     * Test of Grafica2Barras method, of class Grafica2Barras.
     */
    @Test
    public void testGrafica2Barras() {
        System.out.println("Grafica2Barras");
        float esperanza = 0.0F;
        float esperanza2 = 0.0F;
        float educacion = 0.0F;
        float educacion2 = 0.0F;
        float pib = 0.0F;
        float pib2 = 0.0F;
        float idh = 0.0F;
        float idh2 = 0.0F;
        Grafica2Barras instance = null;
        instance.Grafica2Barras(esperanza, esperanza2, educacion, educacion2, pib, pib2, idh, idh2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Grafica2Barras.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Grafica2Barras instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPixel method, of class Grafica2Barras.
     */
    @Test
    public void testCalcularPixel() {
        System.out.println("calcularPixel");
        float valor = 0.0F;
        float[] co = null;
        Grafica2Barras instance = null;
        int expResult = 0;
        int result = instance.calcularPixel(valor, co);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}