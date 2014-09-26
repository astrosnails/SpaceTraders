package spacetraders.model;

/**
*This class implements the Ship Class
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public boolean moneyLimit() {
    	return money < 1000; //if it is true: you can still buy!
    }
    
    public void buy(Resources item) {
    	if(moneyLimit() && cargo.validateCargoSpace()) {//you have money and you have space
    		cargo.add(item);
    	}
    }
    public void sell(Resources item) {
    	if(cargo.getSpace() != 0) {
    		cargo.remove(item);
    	}
    }
    public Planet getLocation() {
        return location;
    }
    
    public void setLocation(Planet location) {
        this.location = location;
    }
    
    public int getWantedLevel() {
        return wantedLevel;
    }
    
    public void setWantedLevel(int wantedLevel) {
        this.wantedLevel = wantedLevel;
    }
    
    public int getFighterSkill() {
        return fighterSkill;
    }
    
    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }
    
    public int getPilotSkill() {
        return pilotSkill;
    }
    
    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }
    
    public int getTraderSkill() {
        return traderSkill;
    }
    
    public void setTraderSkill(int traderSkill) {
        this.traderSkill = traderSkill;
    }
    
    public int getEngineerSkill() {
        return engineerSkill;
    }
    
    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }
    
    public Ship getShip() {
        return ship;
    }
    
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
