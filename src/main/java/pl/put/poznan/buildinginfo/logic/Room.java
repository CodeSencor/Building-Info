package pl.put.poznan.buildinginfo.logic;

/**
 * This class represents a single room.
 * It contains information regarding the room ID, name, area, cubature as well as heating and lighting requirements.
 */
public class Room implements ILocation {
    private String ID;

    private String NAME;

    private double area;

    private double cube;

    private double heating;

    private double light;

    /**
     * This function returns the Room object
     * @param id The room id
     * @param name The room name
     * @param area The area of the room
     * @param cube The cubature of the room
     * @param heating The heating requirement of the room
     * @param light The lighting requirement of the room
     */
    public Room(String id, String name, double area, double cube, double heating, double light){
        this.ID = id;
        this.NAME = name;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Returns the room ID
     * @return Room ID
     */
    @Override
    public String getId(){
        return ID;
    }

    /**
     * Returns the name ID
     * @return Room name
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Accepts the visitor.
     * @param visitor The visitor to be accepted.
     * @return The value retrieved by the visitor.
     */
    @Override
    public double acceptVisitor(IVisitor visitor) {
        return visitor.visitRoom(this);
    }

    /**
     * Returns the room area
     * @return Room area
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns the room cubature
     * @return Room cubature
     */
    public double getCube() {
        return cube;
    }

    /**
     * Returns the room heating requirement.
     * @return Room heating requirement.
     */
    public double getHeating() {
        return heating;
    }

    /**
     * Returns the room lighting requirement
     * @return Room lighting requirement
     */
    public double getLight() {
        return light;
    }
}
