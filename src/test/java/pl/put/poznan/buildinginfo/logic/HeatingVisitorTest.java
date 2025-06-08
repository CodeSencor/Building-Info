package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class HeatingVisitorTest {

    private static HeatingVisitor hv;

    @BeforeEach
    void setUp() {
        hv = new HeatingVisitor();
    }

    @Test
    void visitRoomTest() {
        assertEquals(10, hv.visitRoom(
                new Room("rid", "rname", 0, 2, 20, 0)
        ));
    }

    @Test
    void visitLevelTest() {
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            r.add(new Room("rid", "rname", 0, 1, i, 0));
        }
        assertEquals(30, hv.visitLevel(new Level("lid", "lname", r)));
    }

    @Test
    void visitBuildingTest() {
        ArrayList<Level> llist = new ArrayList<>();
        ArrayList<Room> rlist = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            rlist.add(new Room("rid", "rname", 0, 1, i, 0));
        }
        llist.add(new Level("lid", "lname", rlist));
        assertEquals(
                150,
                hv.visitBuilding(new Building("bid", "bname", llist))
        );
    }

    @Test
    void visitEmptyBuildingTest() {
        Building empty = new Building("empty", "b_name", new ArrayList<>());
        assertEquals(0, hv.visitBuilding(empty));
    }

    @Test
    void visitEmptyLevelsTest() {
        ArrayList<Level> levels = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            levels.add(new Level("lvl", "lvl_name", new ArrayList<>()));
        }
        Building building = new Building("bid", "bname", levels);
        assertEquals(0, hv.visitBuilding(building));
    }

    @Test
    void visitEmptyRoomTest() {
        Room room = new Room("rname", "rid", 0, 0, 0, 0);
        assertEquals(0, hv.visitRoom(room));
    }

    @Test
    void visitPartiallyEmptyLevelTest() {
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            if(i % 20 == 0)
                r.add(new Room("rid", "rname", 0, 1, i, 0));
            else
                r.add(new Room("rid", "rname", 0, 0, i, 0));
        }
        assertEquals(30, hv.visitLevel(new Level("lid", "lname", r)));
    }
}

