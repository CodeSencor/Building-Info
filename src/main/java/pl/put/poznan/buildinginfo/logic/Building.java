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

    public ArrayList<Level> getLevels() {
        return levels;
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

    @Override
    public double acceptVisitor(IVisitor visitor) {
        return visitor.visitBuilding(this);
    }
}
