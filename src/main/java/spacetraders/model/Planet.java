package spacetraders.model;

public class Planet {
    public static enum TechnologyLevel {
        PRE_AGRICULTURE,
        AGRICULTURE,
        MEDIEVAL,
        RENAISSANCE,
        EARLY_INDUSTRIAL,
        INDUSTRIAL,
        POST_INDUSTRIAL,
        HI_TECH
    }
    
    public static enum ResourceLevel {
        NOSPECIALRESOURCES,
        MINERALRICH,
        MINERALPOOR,
        DESERT,
        LOTSOFWATER,
        RICHSOIL,
        POORSOIL,
        RICHFAUNA,
        LIFELESS,
        WEIRDMUSHROOMS,
        LOTSOFHERBS,
        ARTISTIC,
        WARLIKE
    }
    
    private String name;
    private Coordinates coordinates;
    private TechnologyLevel technologyLevel;
    private ResourceLevel resourceLevel;
    private Resources resources;

    public Planet(String name, Coordinates coordinates, TechnologyLevel technologyLevel,
        ResourceLevel resourceLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.technologyLevel = technologyLevel;
        this.resourceLevel = resourceLevel;
        this.resources = resources;
    }
    
    //DEBATEABLE PLEASE REVIEW SNAILS!
    public String setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    public int getCoordinates() {
        return this.coordinates;
    }
    
    public void setTechnologyLevel(TechnologyLevel technologyLevel) {
        this.technologyLevel = technologyLevel;
    }

    public void getTechnologyLevel() {
        return this.technologyLevel;
    }

    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public void getResourceLevel() {
        return this.resourceLevel;
    }

    public void setResources(Resource resources) {
        this.resources = resources;
    }

    public void getResources() {
        return this.resources;
    }


}
