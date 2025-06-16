package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {

    private Level level;
    private Room room;

    @BeforeEach
    void setUp() {
        this.room = new Room("id", "name", 10, 20, 2, 1);
        this.level = new Level("level_id", "lname", new ArrayList<>());
    }

    @Test
    void addRoomTest() {
        assertEquals(0, this.level.getRooms().size());
        this.level.addRoom(this.room);
        assertEquals(1, this.level.getRooms().size());
    }

    @Test
    void removeRoomTest() {
        this.level.addRoom(this.room);
        assertEquals(1, this.level.getRooms().size());
        this.level.removeRoom(this.room);
        assertEquals(0, this.level.getRooms().size());
    }

    @Test
    void getIdTest() {
        assertEquals("level_id", this.level.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("lname", this.level.getName());
    }

    @Test
    void getRoomsTest() {
        this.level.addRoom(this.room);
        List<Room> l = this.level.getRooms();
        assertEquals(1, l.size());
        assertEquals("id", l.get(0).getId());
    }
}
