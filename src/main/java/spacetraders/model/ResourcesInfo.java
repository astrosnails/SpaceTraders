package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

/**
*  Singleton class that holds the information about the game resources.
*  @author Team Astrosnails (6) - CS 2340 Fall 2014
*/
public class ResourcesInfo {
    private static ResourcesInfo resourcesInfo;
    private Map<ResourceType, ResourceInfo> resourceInfoMap;
    
    /**
    *  Creates the ResourcesInfo.
    */
    private ResourcesInfo() {
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
        
        resourceInfoMap = new EnumMap<>(ResourceType.class);
        resourceInfoMap.put(ResourceType.WATER, waterInfo);
        resourceInfoMap.put(ResourceType.FOOD, foodInfo);
        resourceInfoMap.put(ResourceType.OIL, oilInfo);
        resourceInfoMap.put(ResourceType.GOLD, goldInfo);
        resourceInfoMap.put(ResourceType.COCAINE, cocaineInfo);
    }
    
    /**
    *  Returns an instance of the ResouresInfo. Ensures that ResouresInfo follows
    *  the Singleton pattern.
    *  @return The universe
    */
    public static ResourcesInfo getInstance() {
        if (resourcesInfo == null) {
            resourcesInfo = new ResourcesInfo();
        }
        
        return resourcesInfo;
    }
    
    /**
    *  Returns the name of the resource of the given type.
    *  @param type The resource type
    *  @return Name
    */
    public String getName(ResourceType type) {
        return resourceInfoMap.get(type).name;
    }
    
    /**
    *  Returns the base price of the resource of the given type.
    *  @param type The resource type
    *  @return Base price
    */
    public int getBasePrice(ResourceType type) {
        return resourceInfoMap.get(type).basePrice;
    }
    
    /**
    *  Returns the minimum tech level to produce the resource
    *  of the given type.
    *  @param type The resource type
    *  @return Technology Level
    */
    public TechnologyLevel getMinTechLevelToProduce(ResourceType type) {
        return resourceInfoMap.get(type).minToProduce;
    }
    
    /**
    *  Returns the minimum tech level to use the resource
    *  of the given type.
    *  @param type The resource type
    *  @return Technology Level
    */
    public TechnologyLevel getMinTechLevelToUse(ResourceType type) {
        return resourceInfoMap.get(type).minToUse;
    }
    
    /**
    *  Returns the price increase per tech level for the resource
    *  of the given type.
    *  @param type The resource type
    *  @return Price increase per technology level
    */
    public int getPriceIncreasePerTechLevel(ResourceType type) {
        return resourceInfoMap.get(type).priceIncreasePerTechLevel;
    }
    
    /**
    *  Returns the minimum tech level to produce the resource
    *  of the given type.
    *  @param type The resource type
    *  @return Variance
    */
    public int getVariance(ResourceType type) {
        return resourceInfoMap.get(type).variance;
    }
    
    /**
    *  Returns the resource level at which the given resource type is
    *  cheap.
    *  @param type The resource type
    *  @return Resource level
    */
    public ResourceLevel getConditionForCheap(ResourceType type) {
        return resourceInfoMap.get(type).conditionForCheap;
    }
    
    /**
    *  Returns the resource level at which the given resource type is
    *  expensive.
    *  @param type The resource type
    *  @return Resource level
    */
    public ResourceLevel getConditionForExpensive(ResourceType type) {
        return resourceInfoMap.get(type).conditionForExpensive;
    }
    
    /**
    *  Returns the minimum price for this resource with a trader.
    *  @param type The resource type
    *  @return The minimum price
    */
    public int getMinPriceWithTrader(ResourceType type) {
        return resourceInfoMap.get(type).minPriceWithTrader;
    }
    
    /**
    *  Returns the maximum price for this resource with a trader.
    *  @param type The resource type
    *  @return The maximum price
    */
    public int getMaxPriceWithTrader(ResourceType type) {
        return resourceInfoMap.get(type).maxPriceWithTrader;
    }
    
    /**
    *  ResourceInfo holds the information for one resource.
    */
    private class ResourceInfo {
        private String name;
        private int basePrice;
        private TechnologyLevel minToProduce;
        private TechnologyLevel minToUse;
        private int priceIncreasePerTechLevel;
        private int variance;   //In percent. Ex: 50 for 50%
        private ResourceLevel conditionForCheap;
        private ResourceLevel conditionForExpensive;
        private int minPriceWithTrader;
        private int maxPriceWithTrader;
        
        /**
        *  Set resource's name.
        *  @param name The resource name
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setName(String name) {
            this.name = name;
            
            return this;
        }

        /**
        *  Set resource's base price.
        *  @param price The resource price
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setBasePrice(int price) {
            this.basePrice = price;
            
            return this;
        }
        

        /**
        *  Set resource's minimum technology level to produce.
        *  @param minToProduce The technology level
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setMinTechLevelToProduce(TechnologyLevel minToProduce) {
            this.minToProduce = minToProduce;
            
            return this;
        }
        
        /**
        *  Set resource's minimum technology level to use.
        *  @param minToUse The technology level
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setMinTechLevelToUse(TechnologyLevel minToUse) {
            this.minToUse = minToUse;
            
            return this;
        }
        
        /**
        *  Set resource's price increase per technology level
        *  @param priceIncrease The price increase
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setPriceIncreasePerTechLevel(int priceIncrease) {
            this.priceIncreasePerTechLevel = priceIncrease;
            
            return this;
        }
        
        /**
        *  Set resource's variance
        *  @param variance The variance
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setVariance(int variance) {
            this.variance = variance;
            
            return this;
        }
        
        /**
        *  Set resource's condition at which the resource is cheap.
        *  @param resourceLevel The resource level
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setConditionForCheap(ResourceLevel resourceLevel) {
            this.conditionForCheap = resourceLevel;
            
            return this;
        }
        
        /**
        *  Set resource's condition at which the resource is expensive.
        *  @param resourceLevel The resource level
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setConditionForExpensive(ResourceLevel resourceLevel) {
            this.conditionForExpensive = resourceLevel;
            
            return this;
        }
        
        /**
        *  Set resource's minimum price with a trader
        *  @param minPrice The minimum price
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setMinPriceWithTrader(int minPrice) {
            this.minPriceWithTrader = minPrice;
            
            return this;
        }
        
        /**
        *  Set resource's maximum price with a trader
        *  @param maxPrice The maximum price
        *  @return ResourceInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public ResourceInfo setMaxPriceWithTrader(int maxPrice) {
            this.maxPriceWithTrader = maxPrice;
            
            return this;
        }
    }
}
