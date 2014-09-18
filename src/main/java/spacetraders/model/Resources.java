package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

public class Resources {

    public static enum Type {
        WATER,
        OIL,
        FOOD,
        GOLD
    }
    
    private Map<Type, Resource> resources;
    
    public Resources() {
        resources = new EnumMap<>(Type.class);
        resources.put(Type.WATER, new Resource("Water", 0));
        resources.put(Type.OIL, new Resource("Oil", 0));
        resources.put(Type.FOOD, new Resource("Food", 0));
        resources.put(Type.GOLD, new Resource("Gold", 0));
    }
    
    public Resources(Map<Type, Integer> initialAmounts) {
        this();
        
        for (Type resourceType : resources.keySet()) {
            resources.get(resourceType).setAmount(initialAmounts.get(resourceType));
        }
    }
    
    public void addResource(Type resourceType, int amount) {
        resources.get(resourceType).addAmount(amount);
    }
    
    public void removeResource(Type resourceType, int amount) {
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
