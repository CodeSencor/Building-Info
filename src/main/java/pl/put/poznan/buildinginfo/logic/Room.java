package pl.put.poznan.buildinginfo.logic;

public class Room implements ILocation {
    private String ID;

    private String NAME;

    private double area;

    private double cube;

    private double heating;

    private double light;

    public Room(String id, String name, double area, double cube, double heating, double light){
        this.ID = id;
        this.NAME = name;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    @Override
    public String getId(){
        return ID;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double calculateArea() {
        return area;
    }

    @Override
    public double calculateCube() {
        return cube;
    }

    @Override
    public double calculateHeat() {
        return heating;
    }

    @Override
    public double calculateLight() {
        return light;
    }
}
