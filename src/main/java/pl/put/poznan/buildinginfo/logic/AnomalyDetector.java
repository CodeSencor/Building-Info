package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class AnomalyDetector {
    /**
     * Returns all rooms that exceed the heat to volume ratio
     * @param maxHeatCubeRatio Threshold above which a room is returned
     * @return List of rooms exceeding the heat to volume ratio
     */
    public ArrayList<Room> getAnomalies(Building building, double maxHeatCubeRatio) {
        ArrayList<Room> badRooms = new ArrayList<>();
        for (Level level : building.getLevels()) {
            for (Room room : level.getRooms()) {
                if (room.getHeating() > maxHeatCubeRatio) {
                    badRooms.add(room);
                }
            }
        }
        return badRooms;
    }
}
