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
public class PaisTest {
    
    public PaisTest() {
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
     * Test of Pais method, of class Pais.
     */
    @Test
    public void testPais_0args() {
        System.out.println("Pais");
        Pais instance = new Pais();
        instance.Pais();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pais method, of class Pais.
     */
    @Test
    public void testPais_String_String() {
        System.out.println("Pais");
        String name = "";
        String continent = "";
        Pais instance = new Pais();
        instance.Pais(name, continent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Pais.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Pais instance = new Pais();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContinent method, of class Pais.
     */
    @Test
    public void testGetContinent() {
        System.out.println("getContinent");
        Pais instance = new Pais();
        String expResult = "";
        String result = instance.getContinent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}