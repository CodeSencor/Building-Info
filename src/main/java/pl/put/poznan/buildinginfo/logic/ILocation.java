package pl.put.poznan.buildinginfo.logic;

public interface ILocation {
    String getId();

    String getName();

    double calculateArea();

    double calculateCube();

    double calculateHeat();

    double calculateLight();
}
