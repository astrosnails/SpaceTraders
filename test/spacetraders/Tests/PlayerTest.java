/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.Tests;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetraders.model.Coordinates;
import spacetraders.model.Planet;
import spacetraders.model.PlanetEvent;
import spacetraders.model.Player;
import spacetraders.model.ResourceLevel;
import spacetraders.model.ResourceType;
import spacetraders.model.Resources;
import spacetraders.model.Ship;
import spacetraders.model.ShipType;
import static spacetraders.model.ShipType.Protoss;
import spacetraders.model.TechnologyLevel;
import spacetraders.model.Universe;

/**
 *
 * @author thangnguyen
 */
public class PlayerTest {
    Player thang = new Player("Thang", 1, 1 , 1 ,1, 1);
    Ship thangship = new Ship(Protoss);
    Universe universe = Universe.getInstance();
    
    public PlayerTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test 
    public void test1calculateTotalResources() {
        thang.setShip(thangship);
        thang.setLocation(universe.getPlanets().get(0));
        try {
            thang.travelTo(universe.getPlanets().get(1));
            thang.travelTo(universe.getPlanets().get(0));
            thang.travelTo(universe.getPlanets().get(4));
            Assert.fail();
        } catch(RuntimeException e) {
            Assert.assertEquals("Fuel not checked before travel.", e.getMessage());
        }
    }
    @Test 
    public void test2calculateTotalResources() {
        thang.setShip(thangship);
        thang.setLocation(universe.getPlanets().get(0));
        thang.travelTo(universe.getPlanets().get(1));
        Assert.assertEquals(thang.getLocation(), universe.getPlanets().get(1));
        Assert.assertEquals(4, thangship.getFuel().get());
    }
    @Test 
    public void test3calculateTotalResources() {
        thang.setShip(thangship);
        thangship.addFuel(10);
        thang.setLocation(universe.getPlanets().get(0));
        thang.travelTo(universe.getPlanets().get(1));
        thang.travelTo(universe.getPlanets().get(0));
        Assert.assertEquals(thang.getLocation(), universe.getPlanets().get(0));
        System.out.println( thangship.getFuel().get());
        Assert.assertEquals(8, thangship.getFuel().get());
    }
}
