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

    private String name;
    private int cost;
    private String description;
    private int attack;
    private int defense;
    private int speed;
    private int cargoSpace;
    private Cargo cargo;

    /**
     * This constructor sets up a Ship
     * @param String name, int cost, int cargoSpace
     * @return none
     */
    public Ship(String name, int cost, int cargoSpace) {
        this.name = name;
        this.cost = cost;
        cargo = new Cargo(cargoSpace);
    }

    /**
     * This method sets name of a Ship
     * @param String name
     * @return none
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets name of a Ship
     * @param none
     * @return String name
     */
    public String getName() {
        return this.name;
    } 

    /**
     * This method sets cost of a Ship
     * @param int cost
     * @return none
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * This method gets name of a Ship
     * @param none
     * @return int cost
     */
    public int getCost() {
        return this.cost;
    } 

    /**
     * This method sets description of a Ship
     * @param String description
     * @return none
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method gets description of a Ship
     * @param none
     * @return String description
     */
    public String getDescription() {
        return this.description;
    } 

    /**
     * This method sets attack of a Ship
     * @param int attack
     * @return none
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * This method gets attack of a Ship
     * @param none
     * @return int attack
     */
    public int getAttack() {
        return this.attack;
    } 

    /**
     * This method sets defense of a Ship
     * @param int defense
     * @return none
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * This method gets defense of a Ship
     * @param none
     * @return int defense
     */
    public int getDefense() {
        return this.defense;
    } 

    /**
     * This method sets speed of a Ship
     * @param int speed
     * @return none
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * This method gets speed of a Ship
     * @param none
     * @return int speed
     */
    public int getSpeed() {
        return this.speed;
    } 

    /**
     * This method sets speed of a Ship
     * @param none
     * @return int speed
     */
    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    /**
     * This method gets cargo space of a Ship
     * @param none
     * @return int cargoSpace
     */
    public int getCargoSpace() {
        return this.cargoSpace;
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
}
