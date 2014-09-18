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
}
