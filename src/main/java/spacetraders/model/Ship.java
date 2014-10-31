package spacetraders.model;

import java.io.Serializable;
import javafx.beans.property.SimpleIntegerProperty;

/**
*This class implements the Ship Class
*to set up and create the methods of ship
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/

public class Ship implements Serializable {
    private ShipType type;
    private Cargo cargo;
    private int health;
    private GadgetType[] gadgets;

    /**
     * This constructor sets up a Ship
     * @param String name, int cost, int cargoSpace
     * @return none
     */
    public Ship(ShipType type) {
        ShipsInfo shipsInformation = ShipsInfo.getInstance();
        this.type = type;
        this.cargo = new Cargo(shipsInformation.getCargoSpace(type));
        this.health = shipsInformation.getMaxHealth(type);
        this.gadgets = new GadgetType[shipsInformation.getSlotsAvailable(type)];
    }

    /** 
     * This method gets the cargo of a Ship
     * @return Cargo cargo
     */
    public Cargo getCargo() {
        return this.cargo;
    }
     /**
     * Adds the specified amount of fuel to Ship
     * @param int amount
     * @return none
     */
    public void addFuel(int amount) {
        cargo.getResources().addResource(ResourceType.FUEL, amount);
    }
     /**
     * Removes fuel from Ship
     * @param int amount
     * @return none
     */
    public void removeFuel(int amount) {
        cargo.getResources().removeResource(ResourceType.FUEL, amount);
    }
     /**
     * Returns the amount of fuel in the ship 
     * @param none
     * @return int fuel
     */
    public SimpleIntegerProperty getFuel() {
        return cargo.getResources().getResourceAmountProperty(ResourceType.FUEL);
    }
    
    /**
     * This method is to get the health of the ship
     * @return health
     */
    public int getHealth() {
        return health;
    }
       /**
     * This method is to set the health of the ship
     * @param new health
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * Return the ship's type
     * @return The ship type
     */
    public ShipType getType() {
        return type;
    }
    /**
     * Adds gadget to the next available gadget slot. Throws an exception f there
     * is no empty slot on the ship.
     * @throws RuntimeException
     * @param gadget 
     */
    public void addGadget(GadgetType gadget) {
        if (!hasAvailableSlot()) {
            throw new RuntimeException("No available slot for gadget to be added.");
        }
        
        GadgetsInfo gadgetsInformation = GadgetsInfo.getInstance();
        
        int emptySlot = 0;
        while (gadgets[emptySlot] != null) { emptySlot++; }
        gadgets[emptySlot] = gadget;
        
        // If the gadget increases the cargo space, add the extra space to cargo.
        if (gadgetsInformation.getCargoSpace(gadget) > 0) {
            cargo.addExtraSpace(gadgetsInformation.getCargoSpace(gadget));
        }
    }
    
    /**
     * Return gadgets
     * @return The gadget slots
     */
    public GadgetType[] getGadgets() {
        return gadgets;
    }
    
    /**
     * Checks if the ship has an available gadget slot.
     * @return True if the ship has an available gadget slot. False otherwise.
     */
    public boolean hasAvailableSlot() {
        if (gadgets.length == 0) {
            return false;
        }
        
        return gadgets[gadgets.length - 1] == null;
    }
}
