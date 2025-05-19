package pl.put.poznan.buildinginfo.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Building implements ILocation {
    private String ID;

    private String NAME;

    private ArrayList<Level> levels;

    public Building(String id, String name, ArrayList<Level> levels) {
        this.ID = id;
        this.NAME = name;
        this.levels = levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void removeLevel(Level level) {
        levels.remove(level);
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
        for (Level level : levels) {
            totalArea += level.calculateArea();
        }
        return totalArea;
    }

    @Override
    public double calculateCube() {
        double totalCube = 0;
        for (Level level : levels) {
            totalCube += level.calculateCube();
        }
        return totalCube;
    }

    @Override
    public double calculateHeat() {
        double totalHeat = 0;
        for (Level level : levels) {
            totalHeat += level.calculateHeat();
        }
        return totalHeat;
    }

    @Override
    public double calculateLight() {
        double totalLight = 0;
        for (Level level : levels) {
            totalLight += level.calculateLight();
        }
        return totalLight;
    }

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
