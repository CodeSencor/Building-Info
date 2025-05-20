package pl.put.poznan.buildinginfo.logic;

public interface IVisitor {

    double visitRoom(Room room);

    double visitLevel(Level level);

    double visitBuilding(Building building);
}
