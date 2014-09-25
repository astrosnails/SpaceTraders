package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

public class Resources {
    
    private Map<ResourceType, Resource> resources;
    
    public Resources() {
        resources = new EnumMap<>(ResourceType.class);
        resources.put(ResourceType.WATER, new Resource("Water", 0));
        resources.put(ResourceType.OIL, new Resource("Oil", 0));
        resources.put(ResourceType.FOOD, new Resource("Food", 0));
        resources.put(ResourceType.GOLD, new Resource("Gold", 0));
    }
    
    public Resources(Map<ResourceType, Integer> initialAmounts) {
        this();
        
        for (ResourceType resourceType : resources.keySet()) {
            resources.get(resourceType).setAmount(initialAmounts.get(resourceType));
        }
    }
    
    public void addResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).addAmount(amount);
    }
    
    public void removeResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).removeAmount(amount);
    }
    
    private class Resource {
        private final String name;
        private int amount;

        public Resource(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
        
        public String getName() {
            return name;
        }

        public int getUnits() {
            return amount;
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
    }
}
