package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

public class Resources {
    
    private Map<ResourceType, Resource> resources;
    
    public Resources() {
        resources = new EnumMap<>(ResourceType.class);
        resources.put(ResourceType.WATER, new Resource(0));
        resources.put(ResourceType.OIL, new Resource(0));
        resources.put(ResourceType.FOOD, new Resource(0));
        resources.put(ResourceType.GOLD, new Resource(0));
        resources.put(ResourceType.COCAINE, new Resource(0));
    }
    
    public Resources(Map<ResourceType, Integer> initialAmounts) {
        this();
        
        for (ResourceType resourceType : resources.keySet()) {
            resources.get(resourceType).setAmount(initialAmounts.get(resourceType));
        }
    }
    
    public Resources addResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).addAmount(amount);
        
        return this;
    }
    
    public Resources removeResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).removeAmount(amount);
        
        return this;
    }
    
    public int getResourceAmount(ResourceType resourceType) {
        return resources.get(resourceType).getAmount();
    }
    
    private class Resource {
        private int amount;

        public Resource(int amount) {
            this.amount = amount;
        }
        
        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void addAmount(int amount) {
            this.amount += amount;
        }

        public void removeAmount(int amount) {
            this.amount -= amount;
        }
        
        public int getAmount() {
            return amount;
        }
    }
}
