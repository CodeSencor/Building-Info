package pl.put.poznan.buildinginfo.logic;

public class LightVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        return room.getLight() / room.getArea();
    }

    @Override
    public double visitLevel(Level level) {
        double totalLight = 0;
        for (Room room : level.getRooms()) {
            totalLight += room.acceptVisitor(this);
        }
        return totalLight / level.getRooms().size();
    }

    @Override
    public double visitBuilding(Building building) {
        double totalLight = 0;
        for (Level level : building.getLevels()) {
            totalLight += level.acceptVisitor(this) * level.getRooms().size();
        }
        return totalLight / building.getLevels().size();
    }
}
