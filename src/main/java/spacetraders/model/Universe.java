package spacetraders.model;
import java.util.random;

public class Universe {
	Planet planet;
	double scarcity;
	Random rand = new Random();

    public Universe(Planet planet, double scarcity) {
    	this.planet = planet;
    	this.scarcity = scarcity * rand.nextDouble();

    	//this.planet.setResourceLevel(planet.getResourceLevel() * scarcity);
    	//LETS DISCUSS AS A GROUP HOW TO set resourcelevel
    }

    public void setPlanet(Planet planet) {
    	this.planet = planet;
    }

    public Planet getPlanet() {
    	return this.planet;
    }

    public void setScarcity(double scarcity) {
    	this.scarcity = scarcity;
    }

    public double getScarcity() {
    	return this.scarcity;
    }

}
