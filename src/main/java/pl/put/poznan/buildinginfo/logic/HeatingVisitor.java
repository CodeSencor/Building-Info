package pl.put.poznan.buildinginfo.logic;

public class HeatingVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        return room.getHeating();
    }

    @Override
    public double visitLevel(Level level) {
        double totalHeating = 0;
        for (Room room : level.getRooms()) {
            totalHeating += room.acceptVisitor(this);
        }
        return totalHeating;
    }

    @Override
    public double visitBuilding(Building building) {
        double totalHeating = 0;
        for (Level level : building.getLevels()) {
            totalHeating += level.acceptVisitor(this);
        }
        return totalHeating;
    }
}
