package spacetraders.model;

/**
*This class implements the Player Class
*to set up and create the methods of ship
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class Player {

    private String name;
    private Cargo cargo;
    private int money;
    private Planet location;
    private int wantedLevel;
    private int fighterSkill;
    private int pilotSkill;
    private int traderSkill;
    private int engineerSkill;
    private Ship ship;
    
    /**
     * This constructor sets up a player
     * @param String name, int fighterSkill, int pilotSkill, int traderSkill, int engineerSkill
     * @return none
     */
    public Player(String name, int fighterSkill, int pilotSkill, int traderSkill, int engineerSkill) {
        this.name = name;
        this.fighterSkill = fighterSkill;
        this.pilotSkill = pilotSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.cargo = new Cargo(30);
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
     * @return int money
     */
    public int getMoney() {
        return money;
    }
    
    /**
     * This method sets the money of the player
     * @param int money
     * @return none
     */
    public void setMoney(int money) {
        this.money = money;
    }
    
    /**
     * This method checks if player has enough money
     * @param none
     * @return boolean 
     */
    public boolean moneyLimit() {
    	return money < 1000; //if it is true: you can still buy!
    }
    
    /**
     * This method allows player to buy an item
     * @param Resources item
     * @return none 
     */
    public void buy(Resources item) {
    	if(moneyLimit() && cargo.validateCargoSpace()) {
        //you have money and you have space
    		cargo.add(item);
    	}
    }

    /**
     * This method allows player to sell an item
     * @param Resources item
     * @return none 
     */
    public void sell(Resources item) {
    	if(cargo.getSpace() != 0) {
    		cargo.remove(item);
    	}
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
}
