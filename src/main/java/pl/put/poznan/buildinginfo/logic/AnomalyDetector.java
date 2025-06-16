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
        HeatingVisitor heatingVisitor = new HeatingVisitor();
        for (Level level : building.getLevels()) {
            for (Room room : level.getRooms()) {
                double heatCubeRatio = room.acceptVisitor(heatingVisitor);
                if (heatCubeRatio == -1 || heatCubeRatio > maxHeatCubeRatio) {
                    badRooms.add(room);
                }
            }
        }
        return badRooms;
    }
}
