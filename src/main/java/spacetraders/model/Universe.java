package spacetraders.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universe {
        private static Universe universe;
	private List<Planet> planets;

    private Universe() {
    	Resources r1 = new Resources();
        r1.addResource(ResourceType.WATER, 1000);
        r1.addResource(ResourceType.FOOD, 200);
        r1.addResource(ResourceType.GOLD, 20);
        r1.addResource(ResourceType.OIL, 100);
        Planet p1 = new Planet("Planet 1", new Coordinates(1, 2),
            TechnologyLevel.AGRICULTURE,
            ResourceLevel.LOTSOFWATER, r1);
        
        Resources r2 = new Resources();
        r2.addResource(ResourceType.WATER, 50);
        r2.addResource(ResourceType.FOOD, 300);
        r2.addResource(ResourceType.GOLD, 80);
        r2.addResource(ResourceType.OIL, 500);
        Planet p2 = new Planet("Planet 2", new Coordinates(4, 5),
            TechnologyLevel.INDUSTRIAL,
            ResourceLevel.DESERT, r2);
        
        Resources r3 = new Resources();
        r3.addResource(ResourceType.WATER, 500);
        r3.addResource(ResourceType.FOOD, 500);
        r3.addResource(ResourceType.GOLD, 400);
        r3.addResource(ResourceType.OIL, 50);
        Planet p3 = new Planet("Planet 3", new Coordinates(2, 3),
            TechnologyLevel.MEDIEVAL,
            ResourceLevel.MINERALRICH, r3);
        
        Resources r4 = new Resources();
        r4.addResource(ResourceType.WATER, 200);
        r4.addResource(ResourceType.FOOD, 1000);
        r4.addResource(ResourceType.GOLD, 100);
        r4.addResource(ResourceType.OIL, 100);
        Planet p4 = new Planet("Planet 4", new Coordinates(9, 8),
            TechnologyLevel.RENAISSANCE,
            ResourceLevel.RICHSOIL, r4);
        
        planets = new ArrayList<Planet>();
        planets.add(p1);
        planets.add(p2);
        planets.add(p3);
        planets.add(p4);
    }
    
    public static Universe getInstance() {
        if (universe == null) {
            universe = new Universe();
        }
        
        return universe;
    }
}
