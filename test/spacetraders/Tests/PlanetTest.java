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
import static spacetraders.model.ResourceType.COCAINE;
import static spacetraders.model.ResourceType.FOOD;
import static spacetraders.model.ResourceType.FUEL;
import static spacetraders.model.ResourceType.GOLD;
import static spacetraders.model.ResourceType.OIL;
import static spacetraders.model.ResourceType.WATER;
import spacetraders.model.Resources;

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
    
    @Test
    public void test2ValidateCargoSpace() {
        int amount = 31;
        boolean expResult = false;
        boolean result = cargo.validateCargoSpace(amount);
        assertEquals(expResult, result);
    }
    @Test
    public void test3ValidateCargoSpace() {
        int amount = -1;
        boolean expResult = true;
        boolean result = cargo.validateCargoSpace(amount);
        assertEquals(expResult, result);
    }
    @Test
    public void test4ValidateCargoSpace() {
        int amount = 30;
        boolean expResult = true;
        boolean result = cargo.validateCargoSpace(amount);
        assertEquals(expResult, result);
    }
    
    @Test 
    public void test1calculateTotalResources() {
        assertEquals(0,cargo.calculateTotalResources());
    }
 

    @Test 
    public void test2calculateTotalResources() {
        Resources resources = new Resources();
        resources.addResource(WATER,30);
        cargo.setResources(resources);
        assertEquals(30,cargo.calculateTotalResources());
    }
     @Test 
     public void test3calculateTotalResources() {
        Resources resources = new Resources();
        resources.addResource(WATER,30);
         resources.addResource(OIL,30);
        cargo.setResources(resources);
        assertEquals(60,cargo.calculateTotalResources());
    }
    
}
