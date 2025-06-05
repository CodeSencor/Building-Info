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
