package pl.put.poznan.buildinginfo.logic;

public interface ILocation {
    String getId();

    String getName();

    double acceptVisitor(IVisitor visitor);
}
