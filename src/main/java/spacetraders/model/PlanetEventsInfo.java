package spacetraders.model;

import java.util.EnumMap;
import java.util.Map;

/**
*  Singleton class that holds the information about the game resources.
*  @author Team Astrosnails (6) - CS 2340 Fall 2014
*/
public class PlanetEventsInfo {
    private static PlanetEventsInfo eventsInfo;
    private Map<PlanetEvent, EventInfo> eventInfoMap;

    /**
    *  Creates the PlanetEventsInfo.
    */
    private PlanetEventsInfo() {
        EventInfo droughtInfo = new EventInfo();
        droughtInfo.setName("Drought")
            .setAffectedResource(ResourceType.WATER);

        EventInfo cropFailInfo = new EventInfo();
        cropFailInfo.setName("Cropfail")
            .setAffectedResource(ResourceType.FOOD);

        EventInfo warInfo = new EventInfo();
        warInfo.setName("War")
            .setAffectedResource(ResourceType.OIL);

        EventInfo lackOfWorkersInfo = new EventInfo();
        lackOfWorkersInfo.setName("Lack of Workers")
            .setAffectedResource(ResourceType.GOLD);

        EventInfo boredomInfo = new EventInfo();
        boredomInfo.setName("Boredom")
            .setAffectedResource(ResourceType.COCAINE);

        EventInfo nothingInfo = new EventInfo();
        nothingInfo.setName("")
            .setAffectedResource(null);

        eventInfoMap = new EnumMap<>(PlanetEvent.class);
        eventInfoMap.put(PlanetEvent.DROUGHT, droughtInfo);
        eventInfoMap.put(PlanetEvent.CROPFAIL, cropFailInfo);
        eventInfoMap.put(PlanetEvent.WAR, warInfo);
        eventInfoMap.put(PlanetEvent.LACK_OF_WORKERS, lackOfWorkersInfo);
        eventInfoMap.put(PlanetEvent.BOREDOM, boredomInfo);
        eventInfoMap.put(PlanetEvent.NOTHING, nothingInfo);
    }

    /**
    *  Returns an instance of the ResouresInfo. Ensures that ResouresInfo
    *  follows the Singleton pattern.
    *  @return The universe
    */
    public static PlanetEventsInfo getInstance() {
        if (eventsInfo == null) {
            eventsInfo = new PlanetEventsInfo();
        }

        return eventsInfo;
    }

    /**
    *  Returns the name of the event of the given enum.
    *  @param type The resource type
    *  @return Name
    */
    public String getName(PlanetEvent event) {
        return eventInfoMap.get(event).name;
    }
    /**
     * Method to get affected resource
     * @param event
     * @return
     */
    public ResourceType getAffectedResource(PlanetEvent event) {
        return eventInfoMap.get(event).affectedResource;
    }

    /**
    *  PlanetEventInfo holds the information for one PlanetEvent.
    */
    private class EventInfo {
        private String name;
        private ResourceType affectedResource;

        /**
        *  Set event's name.
        *  @param name The event name
        *  @return PlanetEventInfo This class to allow method chaining
        *    (Builder pattern)
        */
        public EventInfo setName(String name) {
            this.name = name;

            return this;
        }
        /**
         * Method to set affected resource
         * @param resource
         * @return
         */
        public EventInfo setAffectedResource(ResourceType resource) {
            this.affectedResource = resource;

            return this;
        }
    }
}
