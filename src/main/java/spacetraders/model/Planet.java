package spacetraders.model;

/**
*This class implements the Planet Class
*to set up and create the methods of creating coordinates
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class Planet {
    
    private String name;
    private Coordinates coordinates;
    private TechnologyLevel technologyLevel;
    private ResourceLevel resourceLevel;
    private Resources resources;

    /**
	 * This constructor sets up a planet
	 * @param String name, Coordinates coordinates, TechnologyLevel technologyLevel,
        ResourceLevel resourceLevel, Resources resources
	 * @no return
	 */
    public Planet(String name, Coordinates coordinates, TechnologyLevel technologyLevel,
        ResourceLevel resourceLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.technologyLevel = technologyLevel;
        this.resourceLevel = resourceLevel;
        this.resources = resources;
    }
    
    /**
    * sets planet name
    * @param String name
    * @no return
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * gets name of planet
    * @no param
    * @return String name
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * gets resource price
    * @param ResourceType type
    * @return price as int
    */
    public int getResourcePrice(ResourceType type) {
        //get the instance of this singleton class
        ResourcesInfo a = ResourcesInfo.getInstance();
        int value = a.getBasePrice(type) * (1 + a.getVariance(type)); 
        value += (a.getPriceIncreasePerTechLevel(type) * 
            (getTechnologyLevel().getRank() - getMinTechLevelToProduce(type).getRank()));
        return value; 
    }

    /**
    * sets cooridnates of planet
    * @param Coordinates coordinates
    * @no return
    */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    /**
    * gets planet coordinates
    * @no param
    * @return coordinates
    */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
    /**
    * sets technology level
    * @param TechnologyLevel technologyLevel
    * @no return
    */
    public void setTechnologyLevel(TechnologyLevel technologyLevel) {
        this.technologyLevel = technologyLevel;
    }
   
    /**
    * gets technology level
    * @no param
    * @return TechnologyLevel
    */
    public TechnologyLevel getTechnologyLevel() {
        return this.technologyLevel;
    }
   
    /**
    * sets Resource level
    * @param ResourceLevel resourceLevel
    * @no return
    */
    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
    * gets Resource level
    * @no param
    * @return ResourceLevel
    */
    public ResourceLevel getResourceLevel() {
        return this.resourceLevel;
    }
   
    /**
    * sets Resources
    * @param Resources resources
    * @no return
    */
    public void setResources(Resources resources) {
        this.resources = resources;
    }
   
    /**
    * gets Resources
    * @no param
    * @return Resources
    */
    public Resources getResources() {
        return this.resources;
    }


}
