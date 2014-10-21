package spacetraders.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* The universe class. It is responsible for creating the Universe as well
* as the planets that are in the universe.
* @author Team Astrosnails (6) - CS 2340 Fall 2014
*/
public class Universe implements Serializable {
    private static Universe universe;
    private List<Planet> planets;
    private int width;
    private int height;

    /**
    *  Creates the Universe as well as planets in the universe.
    */
    private Universe() {
        width = 15;
        height = 10;
        
    	Resources r1 = new Resources();
        r1.addResource(ResourceType.WATER, 1000)
            .addResource(ResourceType.FOOD, 200)
            .addResource(ResourceType.GOLD, 20)
            .addResource(ResourceType.OIL, 100)
            .addResource(ResourceType.COCAINE, 1);
        Planet p1 = new Planet("Planet 1", new Coordinates(1, 2),
            TechnologyLevel.AGRICULTURE,
            ResourceLevel.LOTSOFWATER, r1, PlanetEvent.DROUGHT);
        
        Resources r2 = new Resources();
        r2.addResource(ResourceType.WATER, 50)
            .addResource(ResourceType.FOOD, 300)
            .addResource(ResourceType.GOLD, 80)
            .addResource(ResourceType.OIL, 500)
            .addResource(ResourceType.COCAINE, 2);
        Planet p2 = new Planet("Planet 2", new Coordinates(4, 5),
            TechnologyLevel.INDUSTRIAL,
            ResourceLevel.DESERT, r2, PlanetEvent.NOTHING);
        
        Resources r3 = new Resources();
        r3.addResource(ResourceType.WATER, 500)
            .addResource(ResourceType.FOOD, 500)
            .addResource(ResourceType.GOLD, 400)
            .addResource(ResourceType.OIL, 50)
            .addResource(ResourceType.COCAINE, 5);
        Planet p3 = new Planet("Planet 3", new Coordinates(2, 3),
            TechnologyLevel.MEDIEVAL,
            ResourceLevel.MINERALRICH, r3, PlanetEvent.NOTHING);
        
        Resources r4 = new Resources();
        r4.addResource(ResourceType.WATER, 200)
            .addResource(ResourceType.FOOD, 1000)
            .addResource(ResourceType.GOLD, 100)
            .addResource(ResourceType.OIL, 100)
            .addResource(ResourceType.COCAINE, 0);
        Planet p4 = new Planet("Planet 4", new Coordinates(9, 8),
            TechnologyLevel.RENAISSANCE,
            ResourceLevel.RICHSOIL, r4, PlanetEvent.NOTHING);
        
        planets = new ArrayList<Planet>();
        planets.add(p1);
        planets.add(p2);
        planets.add(p3);
        planets.add(p4);
    }
    
    /**
    *  Returns an instance of the universe. Ensures that Universe follows
    *  the Singleton pattern.
    *  @return The universe
    */
    public static Universe getInstance() {
        if (universe == null) {
            universe = new Universe();
        }
        
        return universe;
    }
    
    /**
    * CAUTION: ONLY USE FOR LOADING GAME
    * Sets the global universe object to otherUniverse
    * @param otherUniverse The universe
    */
    public static void setInstance(Universe otherUniverse) {
        universe = otherUniverse;
    }
    
    /**
    * Returns the planet in the universe
    * @return The planets
    */
    public List<Planet> getPlanets() {
        return planets;
    }
    
    /**
    * Returns the width of the universe
    * @return The width
    */
    public int getWidth() {
        return width;
    }
    
    /**
    * Returns the height of the universe
    * @return The height
    */
    public int getHeight() {
        return height;
    }
}
