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
    public double calculateArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.calculateArea();
        }
        return totalArea;
    }

    @Override
    public double calculateCube() {
        double totalCube = 0;
        for (Room room : rooms) {
            totalCube += room.calculateCube();
        }
        return totalCube;
    }

    @Override
    public double calculateHeat() {
        double totalHeat = 0;
        for (Room room : rooms) {
            totalHeat += room.calculateHeat();
        }
        return totalHeat;
    }

    @Override
    public double calculateLight() {
        double totalLight = 0;
        for (Room room : rooms) {
            totalLight += room.calculateLight();
        }
        return totalLight;
    }
}
