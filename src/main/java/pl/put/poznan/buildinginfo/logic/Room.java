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
    public double acceptVisitor(IVisitor visitor) {
        return visitor.visitRoom(this);
    }

    public double getArea() {
        return area;
    }

    public double getCube() {
        return cube;
    }

    public double getHeating() {
        return heating;
    }

    public double getLight() {
        return light;
    }
}
