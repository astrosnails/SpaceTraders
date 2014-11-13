/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spacetraders.model.*;
import static org.junit.Assert.*;

/**
 *
 * @author Hifza Sakhi
 */
public class PlanetTest {
    
    Cargo cargo = new Cargo(30);
    
    public CargoTest() {
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
    
    @Test
    public void testValidateCargoSpace() {
        int amount = 0;
        boolean expResult = true;
        boolean result = cargo.validateCargoSpace(amount);
        assertEquals(expResult, result);
    }
    
    
}
