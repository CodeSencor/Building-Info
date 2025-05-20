package pl.put.poznan.buildinginfo.logic;

public class CubeVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        return room.getCube();
    }

    @Override
    public double visitLevel(Level level) {
        double totalCube = 0;
        for (Room room : level.getRooms()) {
            totalCube += room.acceptVisitor(this);
        }
        return totalCube;
    }

    @Override
    public double visitBuilding(Building building) {
        double totalCube = 0;
        for (Level level : building.getLevels()) {
            totalCube += level.acceptVisitor(this);
        }
        return totalCube;
    }
}
