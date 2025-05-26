package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class Level implements ILocation {
    private String ID;

    private String NAME;

    private ArrayList<Room> rooms;

    public Level(String id, String name, ArrayList<Room> rooms) {
        this.ID = id;
        this.NAME = name;
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double acceptVisitor(IVisitor visitor) {
        return visitor.visitLevel(this);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }
}
