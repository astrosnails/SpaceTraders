/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetraders.model.GadgetType;
import spacetraders.model.Ship;
import spacetraders.model.ShipType;

/**
 *
 * @author saleh
 */
public class ShipTests {
    
    Ship ship;
    
    public ShipTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ship = new Ship(ShipType.ARWING);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGadgetTest() {
        ship.addGadget(GadgetType.BAZOOKA);
        
        Assert.assertEquals(null, GadgetType.BAZOOKA, ship.getGadgets()[0]);
    }
    
    @Test
    public void addMoreGadgetsThanSlots() {
        ship.addGadget(GadgetType.BAZOOKA);
        
        try {
            ship.addGadget(GadgetType.MISSILE);
            Assert.fail();
        } catch(RuntimeException e) {
            Assert.assertEquals("No available slot for gadget to be added.", e.getMessage());
        }
    }
    
    @Test
    public void addSpaceGadgetIncreasesMaxCargoSpace() {
        int space = ship.getCargo().getMaxSize();
        ship.addGadget(GadgetType.GIANT_MONSTER);
        Assert.assertTrue(ship.getCargo().getMaxSize() > space);
    }
}
