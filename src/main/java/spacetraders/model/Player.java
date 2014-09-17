package spacetraders.model;

public class Player {

    private String name;
    private int money;
    private Planet location;
    private int wantedLevel;
    private int fighterSkill;
    private int pilotSkill;
    private int traderSkill;
    private int engineerSkill;
    private Ship ship;
    
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
    
    public void setFighterSkill(int wantefighterSkilldLevel) {
        this.fighterSkill = fighterSkill;
    }
    
    public int getPilotSkill() {
        return pilotSkill;
    }
    
    public void setPilotSkill(int wantefighterSkilldLevel) {
        this.pilotSkill = pilotSkill;
    }
    
    public int getTraderSkill() {
        return traderSkill;
    }
    
    public void setTraderSkill(int wantefighterSkilldLevel) {
        this.traderSkill = traderSkill;
    }
    
    public int getEngineerSkill() {
        return engineerSkill;
    }
    
    public void setEngineerSkill(int wantefighterSkilldLevel) {
        this.engineerSkill = engineerSkill;
    }
    
    public Ship getShip() {
        return ship;
    }
    
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}