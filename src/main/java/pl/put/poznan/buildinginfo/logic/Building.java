package pl.put.poznan.buildinginfo.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Building implements ILocation {
    /**
     * This class represents a building.
     * @param id The building ID
     * @param name The building name
     * @param levels The list of levels of the building
     */
    private String ID;

    private String NAME;

    private ArrayList<Level> levels;

    public Building(String id, String name, ArrayList<Level> levels) {
        this.ID = id;
        this.NAME = name;
        this.levels = levels;
    }

    /**
     * Adds a level to the list
     * @param level The level to be added
     */
    public void addLevel(Level level) {
        levels.add(level);
    }

    /**
     * Removes a level
     * @param level Level to be removed
     */
    public void removeLevel(Level level) {
        levels.remove(level);
    }

    /**
     * Returns the ID of the building
     * @return ID of the building
     */
    @Override
    public String getId() {
        return ID;
    }

    /**
     * Returns the name of the building
     * @return Name of the building
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Calculates the total area of the building
     * @return Total area of the building
     */
    @Override
    public double calculateArea() {
        double totalArea = 0;
        for (Level level : levels) {
            totalArea += level.calculateArea();
        }
        return totalArea;
    }

    /**
     * Calculates the volume of all the rooms in the building
     * @return Volume of al the rooms in the building
     */
    @Override
    public double calculateCube() {
        double totalCube = 0;
        for (Level level : levels) {
            totalCube += level.calculateCube();
        }
        return totalCube;
    }

    /**
     * Calculates the total heat usage of all the rooms in the building.
     * @return Total heat usage of all the rooms in the building
     */
    @Override
    public double calculateHeat() {
        double totalHeat = 0;
        for (Level level : levels) {
            totalHeat += level.calculateHeat();
        }
        return totalHeat;
    }

    /**
     * Calculates the total light usage in the building
     * @return Total light usage in the building
     */
    @Override
    public double calculateLight() {
        double totalLight = 0;
        for (Level level : levels) {
            totalLight += level.calculateLight();
        }
        return totalLight;
    }

    /**
     * Returns all rooms that exceed the heat to volume ratio
     * @param maxHeatCubeRatio Threshold above which a room is returned
     * @return List of rooms exceeding the heat to volume ratio
     */
    public ArrayList<Room> getHeatExceedRooms(double maxHeatCubeRatio) {
        ArrayList<Room> badRooms = new ArrayList<>();
        for (Level level : levels) {
            for (Room room : level.getRooms()) {
                if (room.calculateHeat() / calculateCube() > maxHeatCubeRatio) {
                    badRooms.add(room);
                }
            }
        }
        return badRooms;
    }
}
