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
import spacetraders.Abstract.TravelListener;
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
    Player thang;
    Ship thangship;
    Universe universe;
        
    @Before
    public void setUp() {
        thang = new Player("Thang", 1, 1 , 1 ,1, 1);
        thangship = new Ship(Protoss);
        universe = Universe.getInstance();
        
        thang.setLocation(universe.getPlanets().get(0));
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
    public void test1TravelTo() {
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
    public void test2TravelTo() {
        thang.setShip(thangship);
        thang.setLocation(universe.getPlanets().get(0));
        thang.travelTo(universe.getPlanets().get(1));
        Assert.assertEquals(thang.getLocation(), universe.getPlanets().get(1));
        Assert.assertEquals(4, thangship.getFuel().get());
    }
    @Test 
    public void test3TravelTo() {
        thang.setShip(thangship);
        thangship.addFuel(10);
        thang.setLocation(universe.getPlanets().get(0));
        thang.travelTo(universe.getPlanets().get(1));
        thang.travelTo(universe.getPlanets().get(0));
        Assert.assertEquals(thang.getLocation(), universe.getPlanets().get(0));
        Assert.assertEquals(8, thangship.getFuel().get());
    }
    
    @Test
    public void test4TravelTo() {
        final TestCall calledCallback = new TestCall();
        TravelListener listener = new TravelListener() {

            @Override
            public void onTravel(Planet destination) {
                calledCallback.call();
            }
        
        };
        
        thang.addTravelListener(listener);
        thang.travelTo(universe.getPlanets().get(0));
        assertEquals(true, calledCallback.isCalled());
    }
    
    private class TestCall {
        boolean isCalled;
        
        public void TestCall() {
            isCalled = false;
        }
        
        public void call() {
            isCalled = true;
        }
        
        public boolean isCalled() {
            return isCalled;
        }
    }
}
