package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

/**
 * This class represents a building. It contains an ID, its name and a list of levels that the building is comprised of.
 */
public class Building implements ILocation {
    private String ID;

    private String NAME;

    private ArrayList<Level> levels;

    /**
     * Creates the building object
     * @param id The building ID
     * @param name The building name
     * @param levels The list of levels of the building
     */
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
     * Returns building's levels
     */
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
