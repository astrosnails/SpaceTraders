/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.Tests;
package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetraders.model.*;
import static spacetraders.model.ShipType.Protoss;
import spacetraders.model.TechnologyLevel;
import spacetraders.model.Universe;

/**
 *
 * @author Hifza Sakhi
 */
public class ResourceInfoTest {
    
    private static ResourcesInfo info;
    private Map<ResourceType, ResourceInfo> resourceInfoMap;
    
    public ResourceInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
      ResourceInfo waterInfo = new ResourceInfo();
        waterInfo.setName("Water")
            .setBasePrice(100)
            .setMinTechLevelToProduce(TechnologyLevel.PRE_AGRICULTURE)
            .setMinTechLevelToUse(TechnologyLevel.PRE_AGRICULTURE)
            .setPriceIncreasePerTechLevel(3)
            .setVariance(10)
            .setConditionForCheap(ResourceLevel.LOTSOFWATER)
            .setConditionForExpensive(ResourceLevel.DESERT)
            .setMinPriceWithTrader(95)
            .setMaxPriceWithTrader(120);

        ResourceInfo foodInfo = new ResourceInfo();
        foodInfo.setName("Food")
            .setBasePrice(350)
            .setMinTechLevelToProduce(TechnologyLevel.AGRICULTURE)
            .setMinTechLevelToUse(TechnologyLevel.PRE_AGRICULTURE)
            .setPriceIncreasePerTechLevel(30)
            .setVariance(15)
            .setConditionForCheap(ResourceLevel.RICHSOIL)
            .setConditionForExpensive(ResourceLevel.POORSOIL)
            .setMinPriceWithTrader(345)
            .setMaxPriceWithTrader(400);

        ResourceInfo oilInfo = new ResourceInfo();
        oilInfo.setName("Oil")
            .setBasePrice(1000)
            .setMinTechLevelToProduce(TechnologyLevel.RENAISSANCE)
            .setMinTechLevelToUse(TechnologyLevel.MEDIEVAL)
            .setPriceIncreasePerTechLevel(50)
            .setVariance(10)
            .setConditionForCheap(ResourceLevel.RICHSOIL)
            .setConditionForExpensive(ResourceLevel.WARLIKE)
            .setMinPriceWithTrader(945)
            .setMaxPriceWithTrader(1200);

        ResourceInfo goldInfo = new ResourceInfo();
        goldInfo.setName("Gold")
            .setBasePrice(4000)
            .setMinTechLevelToProduce(TechnologyLevel.POST_INDUSTRIAL)
            .setMinTechLevelToUse(TechnologyLevel.RENAISSANCE)
            .setPriceIncreasePerTechLevel(60)
            .setVariance(20)
            .setConditionForCheap(ResourceLevel.MINERALRICH)
            .setConditionForExpensive(ResourceLevel.WARLIKE)
            .setMinPriceWithTrader(3955)
            .setMaxPriceWithTrader(4400);

        ResourceInfo cocaineInfo = new ResourceInfo();
        cocaineInfo.setName("Cocaine")
            .setBasePrice(10000)
            .setMinTechLevelToProduce(TechnologyLevel.MEDIEVAL)
            .setMinTechLevelToUse(TechnologyLevel.AGRICULTURE)
            .setPriceIncreasePerTechLevel(200)
            .setVariance(25)
            .setConditionForCheap(ResourceLevel.LOTSOFHERBS)
            .setConditionForExpensive(null)
            .setMinPriceWithTrader(9999)
            .setMaxPriceWithTrader(15000);

        ResourceInfo fuelInfo = new ResourceInfo();
        fuelInfo.setName("Fuel")
            .setBasePrice(500)
            .setMinTechLevelToProduce(TechnologyLevel.AGRICULTURE)
            .setMinTechLevelToUse(TechnologyLevel.EARLY_INDUSTRIAL)
            .setPriceIncreasePerTechLevel(35)
            .setVariance(15)
            .setConditionForCheap(ResourceLevel.RICHSOIL)
            .setConditionForExpensive(ResourceLevel.WARLIKE)
            .setMinPriceWithTrader(480)
            .setMaxPriceWithTrader(600);

        resourceInfoMap = new EnumMap<>(ResourceType.class);
        resourceInfoMap.put(ResourceType.WATER, waterInfo);
        resourceInfoMap.put(ResourceType.FOOD, foodInfo);
        resourceInfoMap.put(ResourceType.OIL, oilInfo);
        resourceInfoMap.put(ResourceType.GOLD, goldInfo);
        resourceInfoMap.put(ResourceType.COCAINE, cocaineInfo);
        resourceInfoMap.put(ResourceType.FUEL, fuelInfo);
    
    
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test 
    public void testSingletonInstance() {
        info = info.getInstance();
        private static ResourcesInfo testInfo = testInfo.getInstance();
        //objects should be references of each other
        assertEquals(info, testInfo);
    }
    
    @Test 
    public void testNullInstance() {
        ResourcesInfo in = null;
        assertTrue(in, null);
        in = in.getInstance();
        assertFalse(in, null);
    }
    
    @Test 
    public void testMappings() {
        for (ResourceType resource: resourceInfoMap) {
            if (resource == WATER) {
                assertEquals("Water", resource.getName());
                assertEquals(100, resource.getBasePrice());
                assertEquals(TechnologyLevel.PRE_AGRICULTURE, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.PRE_AGRICULTURE, resource.getMinTechLevelToUse);
                assertEquals(3, resource.getPriceIncreasePerTechLevel);
                assertEquals(10, resource.getVariance);
                assertEquals(ResourceLevel.LOTSOFWATER, resource.getConditionForCheap);
                assertEquals(ResourceLevel.DESERT, resource.getConditionForExpensive);
                assertEquals(95, resource.getMinPriceWithTrader;
                assertEquals(120,  resource.getMaxPriceWithTrader);
            }
            
            if (resource == FOOD) {
                assertEquals("Food", resource.getName());
                assertEquals(350, resource.getBasePrice());
                assertEquals(TechnologyLevel.AGRICULTURE, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.PRE_AGRICULTURE, resource.getMinTechLevelToUse);
                assertEquals(30, resource.getPriceIncreasePerTechLevel);
                assertEquals(15, resource.getVariance);
                assertEquals(ResourceLevel.RICHSOIL, resource.getConditionForCheap);
                assertEquals(ResourceLevel.POORSOIL, resource.getConditionForExpensive);
                assertEquals(345, resource.getMinPriceWithTrader;
                assertEquals(400,  resource.getMaxPriceWithTrader
            }
            
            if (resource == OIL) {
                assertEquals("Oil", resource.getName());
                assertEquals(1000, resource.getBasePrice());
                assertEquals(TechnologyLevel.RENAISSANCE, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.MIDIEVAL, resource.getMinTechLevelToUse);
                assertEquals(50, resource.getPriceIncreasePerTechLevel);
                assertEquals(10, resource.getVariance);
                assertEquals(ResourceLevel.RICHSOIL, resource.getConditionForCheap);
                assertEquals(ResourceLevel.WARLIKE, resource.getConditionForExpensive);
                assertEquals(95, resource.getMinPriceWithTrader;
                assertEquals(1200,  resource.getMaxPriceWithTrader
            }
            
            if (resource == GOLD) {
                assertEquals("Gold", resource.getName());
                assertEquals(4000, resource.getBasePrice());
                assertEquals(TechnologyLevel.POST_INDUSTRIAL, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.RENAISSANCE, resource.getMinTechLevelToUse);
                assertEquals(60, resource.getPriceIncreasePerTechLevel);
                assertEquals(20, resource.getVariance);
                assertEquals(ResourceLevel.RICHSOIL, resource.getConditionForCheap);
                assertEquals(ResourceLevel.WARLIKE, resource.getConditionForExpensive);
                assertEquals(3955, resource.getMinPriceWithTrader;
                assertEquals(4400,  resource.getMaxPriceWithTrader
            }
            
            if (resource == COCAINE) {
                assertEquals("Cocaine", resource.getName());
                assertEquals(10000, resource.getBasePrice());
                assertEquals(TechnologyLevel.POST_MIDIEVAL, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.AGRICULTURE, resource.getMinTechLevelToUse);
                assertEquals(200, resource.getPriceIncreasePerTechLevel);
                assertEquals(25, resource.getVariance);
                assertEquals(ResourceLevel.LOTSOFHERBS, resource.getConditionForCheap);
                assertEquals(null, resource.getConditionForExpensive);
                assertEquals(9999, resource.getMinPriceWithTrader;
                assertEquals(15000,  resource.getMaxPriceWithTrader
            }
            
             if (resource == FUEL) {
                assertEquals("Fuel", resource.getName());
                assertEquals(500, resource.getBasePrice());
                assertEquals(TechnologyLevel.AGRICULTURE, resource.getMinTechLevelToProduce);
                assertEquals(TechnologyLevel.EARLY_INDUSTRIAL, resource.getMinTechLevelToUse);
                assertEquals(35, resource.getPriceIncreasePerTechLevel);
                assertEquals(15, resource.getVariance);
                assertEquals(ResourceLevel.RICHSOIL, resource.getConditionForCheap);
                assertEquals(ResourceLevel.WARLIKE, resource.getConditionForExpensive);
                assertEquals(480, resource.getMinPriceWithTrader;
                assertEquals(600,  resource.getMaxPriceWithTrader
            }
            
        }
        
    }
    
    
    
    
    
