package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

public class ResourcesInfo {
    private static ResourcesInfo resourcesInfo;
    private Map<ResourceType, ResourceInfo> resourceInfoMap;
    
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
    
    public static ResourcesInfo getInstance() {
        if (resourcesInfo == null) {
            resourcesInfo = new ResourcesInfo();
        }
        
        return resourcesInfo;
    }
    
    public String getName(ResourceType type) {
        return resourceInfoMap.get(type).name;
    }
    
    public int getBasePrice(ResourceType type) {
        return resourceInfoMap.get(type).basePrice;
    }
    
    public TechnologyLevel getMinTechLevelToProduce(ResourceType type) {
        return resourceInfoMap.get(type).minToProduce;
    }
    
    public TechnologyLevel getMinTechLevelToUse(ResourceType type) {
        return resourceInfoMap.get(type).minToUse;
    }
    
    public int getPriceIncreasePerTechLevel(ResourceType type) {
        return resourceInfoMap.get(type).priceIncreasePerTechLevel;
    }
    
    public int getVariance(ResourceType type) {
        return resourceInfoMap.get(type).variance;
    }
    
    public ResourceLevel getConditionForCheap(ResourceType type) {
        return resourceInfoMap.get(type).conditionForCheap;
    }
    
    public ResourceLevel getConditionForExpensive(ResourceType type) {
        return resourceInfoMap.get(type).conditionForExpensive;
    }
    
    public int getMinPriceWithTrader(ResourceType type) {
        return resourceInfoMap.get(type).minPriceWithTrader;
    }
    
    public int getMaxPriceWithTrader(ResourceType type) {
        return resourceInfoMap.get(type).maxPriceWithTrader;
    }
    
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
        
        public ResourceInfo setName(String name) {
            this.name = name;
            
            return this;
        }
        public ResourceInfo setBasePrice(int price) {
            this.basePrice = price;
            
            return this;
        }
        
        public ResourceInfo setMinTechLevelToProduce(TechnologyLevel minToProduce) {
            this.minToProduce = minToProduce;
            
            return this;
        }
        
        public ResourceInfo setMinTechLevelToUse(TechnologyLevel minToUse) {
            this.minToUse = minToUse;
            
            return this;
        }
        
        public ResourceInfo setPriceIncreasePerTechLevel(int priceIncrease) {
            this.priceIncreasePerTechLevel = priceIncrease;
            
            return this;
        }
        
        public ResourceInfo setVariance(int variance) {
            this.variance = variance;
            
            return this;
        }
        
        public ResourceInfo setConditionForCheap(ResourceLevel resourceLevel) {
            this.conditionForCheap = resourceLevel;
            
            return this;
        }
        
        public ResourceInfo setConditionForExpensive(ResourceLevel resourceLevel) {
            this.conditionForExpensive = resourceLevel;
            
            return this;
        }
        
        public ResourceInfo setMinPriceWithTrader(int minPrice) {
            this.minPriceWithTrader = minPrice;
            
            return this;
        }
        
        public ResourceInfo setMaxPriceWithTrader(int maxPrice) {
            this.maxPriceWithTrader = maxPrice;
            
            return this;
        }
    }
}
