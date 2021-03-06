package spacetraders.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import javafx.beans.property.SimpleIntegerProperty;
/**
* Resources Class represents the resource in the planet
*@author Team AstroSnail
*@version 1.0
*/
public class Resources implements Serializable {

    private Map<ResourceType, Resource> resources;
    /**
    * Create a Resources Object
    */
    public Resources() {
        resources = new EnumMap<>(ResourceType.class);
        resources.put(ResourceType.WATER, new Resource(0));
        resources.put(ResourceType.OIL, new Resource(0));
        resources.put(ResourceType.FOOD, new Resource(0));
        resources.put(ResourceType.GOLD, new Resource(0));
        resources.put(ResourceType.COCAINE, new Resource(0));
        resources.put(ResourceType.FUEL, new Resource(10));
    }

    /**
    * Create a Resources Object
    * @param
    * initialAmounts - int represents the initial amount of the resource
    */
    public Resources(Map<ResourceType, Integer> initialAmounts) {
        this();

        for (ResourceType resourceType : resources.keySet()) {
            resources.get(resourceType).
                setAmount(initialAmounts.get(resourceType));
        }
    }

    /**
    * Add resource
    * @param
    * resourceType - type of the resource
    * amount - int represents the amount of the resource
    * @return
    * Resources: a resource object
    */
    public Resources addResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).addAmount(amount);

        return this;
    }
    /**
    * Remove resource
    * @param
    * resourceType - type of the resource
    * amount - int represents amount
    * @return
    * Resources: a resource object
    */
    public Resources removeResource(ResourceType resourceType, int amount) {
        resources.get(resourceType).removeAmount(amount);

        return this;
    }

    /**
    * Create a Resources Object
    * @param
    * resourceType - type of the resource
    * amount - int represents the amount of the resource
    * @return: int integer represents the amount of the resource
    */
    public int getResourceAmount(ResourceType resourceType) {
        return resources.get(resourceType).getAmount();
    }

    /**
    * Returns the resourceAmountProperty of the specified resource
    * @param ResourceType resourceType
    * @return SimpleIntegerProperty property
    */
    public SimpleIntegerProperty getResourceAmountProperty(
        ResourceType resourceType) {
        return resources.get(resourceType).getAmountProperty();
    }
    /**
    *  Private Inner Class for Resource
    */
    private class Resource implements Serializable {
        private transient SimpleIntegerProperty amount;
        /**
        *Create a resource object
        *@param int - int represents the amount of the resource
        */
        public Resource(int amount) {
            this.amount = new SimpleIntegerProperty(amount);
        }
        /**
        * Set amount of the resource
        *@param int - int represents the amount of the resource
        */
        public void setAmount(int amount) {
            this.amount.set(amount);
        }

       /**
        * Add a amount of the resource
        *@param int - int represents the amount of the resource
        */
        public void addAmount(int amount) {
            this.amount.set(this.amount.get() + amount);
        }
       /**
        * Remove an amount of the resource
        *@param int - int represents the amount of the resource
        */
        public void removeAmount(int amount) {
            this.amount.set(this.amount.get() - amount);
        }
        /**
        * Get an amount of the resource
        *@param int - int represents the amount of the resource
        *@return int - the amount of the resource
        */
        public int getAmount() {
            return amount.intValue();
        }

        /**
        * Returns the AmountProperty of the resource
        *@param: none
        *@return: SimpleIntegerProperty amount
        */
        public SimpleIntegerProperty getAmountProperty() {
            return amount;
        }

        /**
        * Serializes the resource for saving
        * @param out Output stream
        */
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeInt(amount.getValue());
        }

        /**
        * Serializes the resource for saving
        * @param out Output stream
        */
        private void readObject(ObjectInputStream in) throws IOException,
                ClassNotFoundException {
            in.defaultReadObject();
            amount = new SimpleIntegerProperty(in.readInt());
        }
    }
}
