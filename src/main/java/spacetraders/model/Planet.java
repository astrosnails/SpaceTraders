package spacetraders.model;

public class Planet {
    
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
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public int getResourcePrice(ResourceType type) {
        //get the instance of this singleton class
        ResourcesInfo a = ResourcesInfo.getInstance();
        int value = a.getBasePrice(type) * (1 + a.getVariance(type)); 
        value += (a.getPriceIncreasePerTechLevel(type) * 
            (getTechnologyLevel().getRank() - getMinTechLevelToProduce(type).getRank()));
        return value; 
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
    public void setTechnologyLevel(TechnologyLevel technologyLevel) {
        this.technologyLevel = technologyLevel;
    }

    public TechnologyLevel getTechnologyLevel() {
        return this.technologyLevel;
    }

    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public ResourceLevel getResourceLevel() {
        return this.resourceLevel;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Resources getResources() {
        return this.resources;
    }


}
