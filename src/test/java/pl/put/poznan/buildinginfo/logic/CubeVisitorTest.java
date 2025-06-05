package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CubeVisitorTest {

    private static CubeVisitor cv;

    @BeforeEach
    void setUp() {
        cv = new CubeVisitor();
    }

    @Test
    void visitRoomTest() {
        assertEquals(10, cv.visitRoom(
                new Room("rid", "rname", 0, 10, 0, 0)
        ));
    }

    @Test
    void visitLevelTest() {
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            r.add(new Room("rid", "rname", 0, i, 0, 0));
        }
        assertEquals(150, new Level("lid", "lname", r));
    }

    @Test
    void visitBuildingTest() {
        ArrayList<Level> llist = new ArrayList<>();
        ArrayList<Room> rlist = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            rlist.add(new Room("rid", "rname", 0, i, 0, 0));
        }
        llist.add(new Level("lid", "lname", rlist));
        assertEquals(
                150,
                cv.visitBuilding(new Building("bid", "bname", llist))
        );
    }

    @Test
    void visitEmptyBuildingTest() {
        Building empty = new Building("empty", "b_name", new ArrayList<>());
        assertEquals(0, cv.visitBuilding(empty));
    }

    @Test
    void visitEmptyLevelsTest() {
        ArrayList<Level> levels = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            levels.add(new Level("lvl", "lvl_name", new ArrayList<>()));
        }
        Building building = new Building("bid", "bname", levels);
        assertEquals(0, cv.visitBuilding(building));
    }

    @Test
    void visitEmptyRoomTest() {
        Room room = new Room("rname", "rid", 0, 0, 0, 0);
        assertEquals(0, cv.visitRoom(room));
    }
}
