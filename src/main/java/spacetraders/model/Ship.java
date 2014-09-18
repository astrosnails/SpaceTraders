package spacetraders.model;

public class Ship {

	private String name;
	private int cost;
	private String description;
	private int attack;
	private int defense;
	private int speed;
	private int cargoSpace; 

	public String setName() {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } 
}
