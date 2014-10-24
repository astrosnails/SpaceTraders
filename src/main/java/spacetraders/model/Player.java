package spacetraders.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import spacetraders.Abstract.TravelListener;

/**
*This class implements the Player Class
*to set up and create the methods of ship
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class Player implements Serializable {

    private String name;
    private Cargo cargo;
    transient private SimpleIntegerProperty money;
    private Planet location;
    private int wantedLevel;
    private int fighterSkill;
    private int pilotSkill;
    private int traderSkill;
    private int engineerSkill;
    private Ship ship;
    transient private List<TravelListener> travelListeners;
    
    /**
     * This constructor sets up a player
     * @param String name, int fighterSkill, int pilotSkill, int traderSkill, int engineerSkill
     * @return none
     */
    public Player(String name, int fighterSkill, int pilotSkill, int traderSkill, int engineerSkill, int startMoney) {
        this.name = name;
        this.money = new SimpleIntegerProperty(startMoney);
        this.fighterSkill = fighterSkill;
        this.pilotSkill = pilotSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.cargo = new Cargo(30);
        //TODO: MOVE CONFIG TO TOP OF CLASS HIERARCHY
        this.ship = new Ship(ShipType.Normandy);
        travelListeners = new ArrayList<>();
    }
    
    /**
     * This method sets up the name of the player
     * @param none
     * @return String name
     */
    public String getName() {
        return name;
    }
    
    /**
     * This method gets the name of the player
     * @param String name
     * @return none
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This method gets the money of the player
     * @param none
     * @return SimpleIntegerProperty money
     */
    public SimpleIntegerProperty getMoney() {
        return money;
    }
    
    /**
     * This method sets the money of the player
     * @param int money
     * @return none
     */
    public void setMoney(int money) {
        this.money.set(money);
    }
    
    public void decreaseMoney(int amount) {
        money.set(money.getValue() - amount);
    }
    
    /**
     * This method checks if player has enough money
     * @param none
     * @return boolean 
     */
    public boolean moneyLimit() {
    	return money.intValue() < 1000; //if it is true: you can still buy!
    }
    
    /**
     * This method returns the players location
     * @param none
     * @return Planet location 
     */
    public Planet getLocation() {
        return location;
    }
    
    /**
     * This method sets the players location
     * @param Planet location
     * @return none
     */
    public void setLocation(Planet location) {
        this.location = location;
    }
    
    /**
     * This method gets the players wantedlevel
     * @param none
     * @return int wantedLevel
     */
    public int getWantedLevel() {
        return wantedLevel;
    }
    
    /**
     * This method sets the players wantedlevel
     * @param int wantedLevel
     * @return none
     */
    public void setWantedLevel(int wantedLevel) {
        this.wantedLevel = wantedLevel;
    }
    
     /**
     * This method gets the players fighterSkill
     * @param none
     * @return int fighterSkill
     */
    public int getFighterSkill() {
        return fighterSkill;
    }
    
    /**
     * This method sets the players fighterSkill
     * @param int fighterSkill
     * @return none
     */
    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }
    
    /**
     * This method gets the players pilotSkill
     * @param none
     * @return int pilotSkill
     */
    public int getPilotSkill() {
        return pilotSkill;
    }
    
    /**
     * This method sets the players pilptSkill
     * @param int fighterSkill
     * @return none
     */
    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }
    
    /**
     * This method gets the players traderSkill
     * @param none
     * @return int traderSkill
     */
    public int getTraderSkill() {
        return traderSkill;
    }
    
    /**
     * This method sets the players traderSkill
     * @param int traderSkill
     * @return none
     */
    public void setTraderSkill(int traderSkill) {
        this.traderSkill = traderSkill;
    }
    
    /**
     * This method gets the players engineerSkill
     * @param none
     * @return int engineerSkill
     */
    public int getEngineerSkill() {
        return engineerSkill;
    }
    
    /**
     * This method sets the players engineerSkill
     * @param int traderSkill
     * @return none
     */
    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }
    
    /**
     * This method gets the players ship
     * @param none
     * @return Ship ship
     */
    public Ship getShip() {
        return ship;
    }
    

    /**
     * This method gets the players ship
     * @param Ship ship
     * @return none
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    /**
    * adds the travel listener. 
    * @param: TravelListener listener
    * @return none
    */
    public void addTravelListener(TravelListener listener) {
        travelListeners.add(listener);
    }
    /**
    * lets you travel to the specified planet
    * @param: Planet destination
    * @return: none
    */
    public void travelTo(Planet destination) {
        if (!hasEnoughFuelToTravelTo(destination)) {
            throw new RuntimeException("Fuel not checked before travel.");
        }
        
        // TODO: Handle bad accuracy because of conversion from double to in.
        // (Low priority)
        this.ship.removeFuel((int) getFuelNeeded(location.getCoordinates(),
                destination.getCoordinates()));
        
        this.location = destination;
        
        for (TravelListener listener : travelListeners) {
            listener.onTravel(destination);
        }
    }
    /**
    * determines if we have enough fuel to travel to a Planet
    * @param: Planet planet
    * @retur: boolean if there is enough fuel
    */
    public boolean hasEnoughFuelToTravelTo(Planet planet) {
        double fuelNeeded =
                getFuelNeeded(location.getCoordinates(), planet.getCoordinates());
        
        return getShip().getFuel().getValue() > fuelNeeded;
    }
    /**
    * gets the fuel needed to go from first to second coordinate
    * @param: Coordinates c1, Coordinates c2
    * @return: double fuelNeeded
    */
    //TODO: Move this outside player class
    public static double getFuelNeeded(Coordinates c1, Coordinates c2) {
        double fuelPerGridUnit = 1.5;
        return fuelPerGridUnit * c1.distanceTo(c2);
    }
    
    /**
    * Serializes player for saving
    * @param out Output stream
    */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(money.getValue());
    }
    
    /**
    * Deserializes player for loading
    * @param in Input stream
    */
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        money = new SimpleIntegerProperty(in.readInt());
        
        travelListeners = new ArrayList<>();
    }
}
