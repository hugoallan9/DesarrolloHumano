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
public class GraficaBarrasTest {
    
    public GraficaBarrasTest() {
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
     * Test of GraficaBarras method, of class GraficaBarras.
     */
    @Test
    public void testGraficaBarras() {
        System.out.println("GraficaBarras");
        float esperanza = 0.0F;
        float educacion = 0.0F;
        float pib = 0.0F;
        float idh = 0.0F;
        GraficaBarras instance = null;
        instance.GraficaBarras(esperanza, educacion, pib, idh);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class GraficaBarras.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        GraficaBarras instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPixel method, of class GraficaBarras.
     */
    @Test
    public void testCalcularPixel() {
        System.out.println("calcularPixel");
        float valor = 0.0F;
        float[] co = null;
        GraficaBarras instance = null;
        int expResult = 0;
        int result = instance.calcularPixel(valor, co);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}