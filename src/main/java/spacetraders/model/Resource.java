package spacetraders.model;

public class Resource {
    private String name;
    private String description;
    private int baseValue;
    private int units;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String name) {
        this.description = description;
    }
    
    public int getBaseValue() {
        return baseValue;
    }
    
    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }
    
    public int getUnits() {
        return units;
    }
    
    public void setUnits(int units) {
        this.units = units;
    }
    
    public void addUnits(int units) {
        this.units += units;
    }
    
    public void removeUnits(int units) {
        this.units -= units;
    }
}
