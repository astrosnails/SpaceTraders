package spacetraders.model;

public class Ship {

	private String name;
	private int cost;
	private String description;
	private int attack;
	private int defense;
	private int speed;
	private int cargoSpace; 

	public String setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } 

    public String setCost(int cost) {
        this.cost = cost;
    }

    public String getCost() {
        return this.cost;
    } 

    public String setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    } 

    public String setAttack(int attack) {
        this.attack = attack;
    }

    public String getAttack() {
        return this.attack;
    } 

    public String setDefense(int defense) {
        this.defense = defense;
    }

    public String getDefense() {
        return this.defense;
    } 

    public String setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSpeed() {
        return this.speed;
    } 

     public String setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public String getCargoSpace() {
        return this.cargoSpace;
    }
}
