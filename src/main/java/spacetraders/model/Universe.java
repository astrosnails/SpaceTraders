package spacetraders.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import spacetraders.model.Planet.ResourceLevel;

public class Universe {
        private static Universe universe;
	private List<Planet> planets;

    private Universe() {
    	Resources r1 = new Resources();
        r1.addResource(Resources.Type.WATER, 1000);
        r1.addResource(Resources.Type.FOOD, 200);
        r1.addResource(Resources.Type.GOLD, 20);
        r1.addResource(Resources.Type.OIL, 100);
        Planet p1 = new Planet("Planet 1", new Coordinates(1, 2),
            Planet.TechnologyLevel.AGRICULTURE,
            Planet.ResourceLevel.LOTSOFWATER, r1);
        
        Resources r2 = new Resources();
        r2.addResource(Resources.Type.WATER, 50);
        r2.addResource(Resources.Type.FOOD, 300);
        r2.addResource(Resources.Type.GOLD, 80);
        r2.addResource(Resources.Type.OIL, 500);
        Planet p2 = new Planet("Planet 2", new Coordinates(4, 5),
            Planet.TechnologyLevel.INDUSTRIAL,
            Planet.ResourceLevel.DESERT, r2);
        
        Resources r3 = new Resources();
        r3.addResource(Resources.Type.WATER, 500);
        r3.addResource(Resources.Type.FOOD, 500);
        r3.addResource(Resources.Type.GOLD, 400);
        r3.addResource(Resources.Type.OIL, 50);
        Planet p3 = new Planet("Planet 3", new Coordinates(2, 3),
            Planet.TechnologyLevel.MEDIEVAL,
            Planet.ResourceLevel.MINERALRICH, r3);
        
        Resources r4 = new Resources();
        r4.addResource(Resources.Type.WATER, 200);
        r4.addResource(Resources.Type.FOOD, 1000);
        r4.addResource(Resources.Type.GOLD, 100);
        r4.addResource(Resources.Type.OIL, 100);
        Planet p4 = new Planet("Planet 4", new Coordinates(9, 8),
            Planet.TechnologyLevel.RENAISSANCE,
            Planet.ResourceLevel.RICHSOIL, r4);
        
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
