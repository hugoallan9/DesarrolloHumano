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
public class ReporteTest {
    
    public ReporteTest() {
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
     * Test of ordenNombres method, of class Reporte.
     */
    @Test
    public void testOrdenNombres() {
        System.out.println("ordenNombres");
        Pais[] paises = null;
        int posInicial = 0;
        int posFinal = 0;
        Reporte instance = new Reporte();
        instance.ordenNombres(paises, posInicial, posFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encontrarPais method, of class Reporte.
     */
    @Test
    public void testEncontrarPais() {
        System.out.println("encontrarPais");
        Pais[] paises = null;
        String name = "";
        int posInicial = 0;
        int posFinal = 0;
        Reporte instance = new Reporte();
        int expResult = 0;
        int result = instance.encontrarPais(paises, name, posInicial, posFinal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPais method, of class Reporte.
     */
    @Test
    public void testEliminarPais() {
        System.out.println("eliminarPais");
        Pais[] paises = null;
        int posicion = 0;
        int longitud = 0;
        Reporte instance = new Reporte();
        instance.eliminarPais(paises, posicion, longitud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenIDH method, of class Reporte.
     */
    @Test
    public void testOrdenIDH() {
        System.out.println("ordenIDH");
        Pais[] paises = null;
        int posInicial = 0;
        int posFinal = 0;
        Reporte instance = new Reporte();
        instance.ordenIDH(paises, posInicial, posFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenMayorIDH method, of class Reporte.
     */
    @Test
    public void testOrdenMayorIDH() {
        System.out.println("ordenMayorIDH");
        Pais[] paises = null;
        int posInicial = 0;
        int posFinal = 0;
        Reporte instance = new Reporte();
        instance.ordenMayorIDH(paises, posInicial, posFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of busquedaSecuencial method, of class Reporte.
     */
    @Test
    public void testBusquedaSecuencial() {
        System.out.println("busquedaSecuencial");
        Pais[] paises = null;
        String continente = "";
        int inicio = 0;
        int fin = 0;
        Reporte instance = new Reporte();
        int expResult = 0;
        int result = instance.busquedaSecuencial(paises, continente, inicio, fin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contadorPaises method, of class Reporte.
     */
    @Test
    public void testContadorPaises() {
        System.out.println("contadorPaises");
        Pais[] paises = null;
        int longitud = 0;
        Reporte instance = new Reporte();
        instance.contadorPaises(paises, longitud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conversionAngulos method, of class Reporte.
     */
    @Test
    public void testConversionAngulos() {
        System.out.println("conversionAngulos");
        Reporte instance = new Reporte();
        instance.conversionAngulos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}