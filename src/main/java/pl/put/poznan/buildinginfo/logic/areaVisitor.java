package pl.put.poznan.buildinginfo.logic;

public class areaVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        return room.getArea();
    }

    @Override
    public double visitLevel(Level level) {
        double totalArea = 0;
        for (Room room : level.getRooms()) {
            totalArea += room.acceptVisitor(this);
        }
        return totalArea;
    }

    @Override
    public double visitBuilding(Building building) {
        double totalArea = 0;
        for (Level level : building.getLevels()) {
            totalArea += level.acceptVisitor(this);
        }
        return totalArea;
    }
}
