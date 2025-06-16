package pl.put.poznan.buildinginfo.logic;

public class LightVisitor implements IVisitor {

    @Override
    public double visitRoom(Room room) {
        double roomArea = room.getArea();
        if(roomArea == 0) {
            return 0;
        }
        return room.getLight() / roomArea;
    }

    @Override
    public double visitLevel(Level level) {
        double totalLight = 0;
        int faultRooms = 0;
        for (Room room : level.getRooms()) {
            if(room.acceptVisitor(this) == 0) {
                faultRooms++;
                continue;
            }
            totalLight += room.acceptVisitor(this);
        }
        if(faultRooms == level.getRooms().size()) {
            return 0;
        }
        return totalLight / (level.getRooms().size() - faultRooms);
    }

    @Override
    public double visitBuilding(Building building) {
        double totalLight = 0;
        for (Level level : building.getLevels()) {
            totalLight += level.acceptVisitor(this) * level.getRooms().size();

        }
        if(building.getLevels().isEmpty()) {
            return 0;
        }
        return totalLight / building.getLevels().size();
    }
}
