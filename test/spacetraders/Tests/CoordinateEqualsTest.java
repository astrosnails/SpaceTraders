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
public class CoordinateEqualsTest {
    
    public CoordinateEqualsTest() {
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
    public void referenceEqualsTest() {
        Coordinates distance = new Coordinates(19, 30);
        Coordinates distance2 = distance;
        assertEquals(distance, distance2);
    }
    
    @Test
    public void sameEqualsTest() {
        Coordinates distance = new Coordinates(19, 30);
        assertEquals(distance, distance);
    }
   
    @Test
    public void differentClassInstancesEqualityTest() {
        Coordinates distance = new Coordinates(19, 30);
        Player hifza = new Player("Hifza", 3, 3, 3, 3, 3);
        assertEquals(distance, hifza);
    }
    
    @Test
    public void diffInstanceSameXandYTest() {
        Coordinates distance = new Coordinates(35, 20);
        Coordinates distance2 = new Coordinates(35, 20);
        assertEquals(distance, distance2);
    }
    
}
