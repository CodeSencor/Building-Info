package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

/**
 * This class represents a single level in a building.
 * It contains information regarding the room ID and name as well as the
 */
public class Level implements ILocation {
    private String ID;

    private String NAME;

    private ArrayList<Room> rooms;

    /**
     * Returns an instance of the Level object.
     * @param id The ID of the level
     * @param name The name of the level
     * @param rooms The list of rooms in the level
     */
    public Level(String id, String name, ArrayList<Room> rooms) {
        this.ID = id;
        this.NAME = name;
        this.rooms = rooms;
    }

    /**
     * Adds a room to the level.
     * @param room The room to be added
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Removes a room from the level.
     * @param room The room to be removed
     */
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    /**
     * Returns the room ID.
     * @return ID of the room.
     */
    @Override
    public String getId() {
        return ID;
    }

    /**
     * Returns the name of the room.
     * @return Name of the room.
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Accepts the visitor.
     * @param visitor The visitor to be accepted
     * @return The value retrieved by the visitor
     */
    @Override
    public double acceptVisitor(IVisitor visitor) {
        return visitor.visitLevel(this);
    }

    /**
     * Returns the list of all rooms in the level.
     * @return The list of all rooms in the level
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
}
