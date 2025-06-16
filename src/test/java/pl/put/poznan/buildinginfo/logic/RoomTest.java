package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() {
        this.room = new Room("id", "name", 10, 20, 2, 1);
    }

    @Test
    void getIdTest() {
        assertEquals("id", this.room.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("name", this.room.getName());
    }

    @Test
    void getAreaTest() {
        assertEquals(10, this.room.getArea());
    }

    @Test
    void getCubeTest() {
        assertEquals(20, this.room.getCube());
    }

    @Test
    void getHeatingTest() {
        assertEquals(2, this.room.getHeating());
    }

    @Test
    void getLightTest() {
        assertEquals(1, this.room.getLight());
    }
}
