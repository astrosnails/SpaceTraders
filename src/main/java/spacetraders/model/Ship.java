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

    /**
     * This constructor sets up a Ship
     * @param String name, int cost, int cargoSpace
     * @return none
     */
    public Ship(ShipType type) {
        this.type = type;
        cargo = new Cargo(ShipsInfo.getInstance().getCargoSpace(type));
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
}
