package pl.put.poznan.buildinginfo.logic;

public class HeatingVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        if(room.getCube() == 0) {
            return 0;
        }
        return room.getHeating() / room.getCube();
    }

    @Override
    public double visitLevel(Level level) {
        double totalHeating = 0;
        int faultRooms = 0;
        for (Room room : level.getRooms()) {
            if (room.acceptVisitor(this) == -1) {
                faultRooms++;
                continue;
            }
            totalHeating += room.acceptVisitor(this);
        }
        if(faultRooms == level.getRooms().size()) {
            return 0;
        }
        return totalHeating / (level.getRooms().size() - faultRooms);
    }

    @Override
    public double visitBuilding(Building building) {
        double totalHeating = 0;
        for (Level level : building.getLevels()) {
            totalHeating += level.acceptVisitor(this) * level.getRooms().size();
        }
        return totalHeating / building.getLevels().size();
    }
}
