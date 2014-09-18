package spacetraders.model;
import java.util.ArrayList;
import java.util.Random;
import spacetraders.model.Planet.ResourceLevel;

public class Universe {
	ArrayList<Planet> planets;
	double scarcity;
	Random rand = new Random();

    public Universe(Planet planet, double scarcity) {
    	planets.add(planet);
    	this.scarcity = scarcity * rand.nextDouble();

    	//this.planet.setResourceLevel(planet.getResourceLevel() * scarcity);
    	//LETS DISCUSS AS A GROUP HOW TO set resourcelevel
    }


    private ResourceLevel scarcityLevel(Planet planet) {
        ResourceLevel level = planet.getResourceLevel();
        switch (level) {
            case NOSPECIALRESOURCES:
                break;
            case MINERALRICH:
                break;
            case MINERALPOOR:
                break;
            case DESERT:
                break;
            case LOTSOFWATER:
                break;
            case RICHSOIL:
                break;
            case POORSOIL:
                break;
            case RICHFAUNA:
                break;
            case LIFELESS:
                break;
            case WEIRDMUSHROOMS:
                break;
            case LOTSOFHERBS:
                break;
            case ARTISTIC:
                break;
            case WARLIKE:
                break;
            default: 
        }
        return level;
    }

    public void addPlanet(Planet planet) {
    	planets.add(planet);
    }

    public Planet getPlanet(int index) {
    	return planets.get(index);
    }

    public void setScarcity(double scarcity) {
    	this.scarcity = scarcity;
    }

    public double getScarcity() {
    	return this.scarcity;
    }

}
