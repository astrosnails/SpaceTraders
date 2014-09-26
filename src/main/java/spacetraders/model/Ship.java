package spacetraders.model;

public class Ship {

	private String name;
	private int cost;
	private String description;
	private int attack;
	private int defense;
	private int speed;
	private int cargoSpace; 
    private Cargo cargo;

    public Ship(String name, int cost, int cargoSpace) {
        this.name = name;
        this.cost = cost;
        cargo = new Cargo(cargoSpace);
    }

	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } 

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    } 

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    } 

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    } 

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    } 

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    } 

     public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getCargoSpace() {
        return this.cargoSpace;
    }
}
