package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

public class LightVisitorTest {

    private static LightVisitor lv;

    @BeforeEach
    void setUp() {
        lv = new LightVisitor();
    }

    @Test
    void testVisitRoom() {
        Room mockedRoom = mock(Room.class);
        when(mockedRoom.getLight()).thenReturn(5.0);
        when(mockedRoom.getArea()).thenReturn(2.0);

        assertEquals(2.5, lv.visitRoom(mockedRoom));
        verify(mockedRoom).getLight();
        verify(mockedRoom).getArea();
    }
    @Test
    void visitRoomTest() {
        assertEquals(10, lv.visitRoom(
                new Room("rid", "rname", 2, 0, 0, 20)
        ));
    }

    @Test
    void visitLevelTest() {
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            r.add(new Room("rid", "rname", 1, 0, 0, i));
        }
        assertEquals(30, lv.visitLevel(new Level("lid", "lname", r)));
    }

    @Test
    void visitBuildingTest() {
        ArrayList<Level> llist = new ArrayList<>();
        ArrayList<Room> rlist = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            rlist.add(new Room("rid", "rname", 1, 0, 0, i));
        }
        llist.add(new Level("lid", "lname", rlist));
        assertEquals(
                150,
                lv.visitBuilding(new Building("bid", "bname", llist))
        );
    }

    @Test
    void visitEmptyBuildingTest() {
        Building empty = new Building("empty", "b_name", new ArrayList<>());
        assertEquals(0, lv.visitBuilding(empty));
    }

    @Test
    void visitEmptyLevelsTest() {
        ArrayList<Level> levels = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            levels.add(new Level("lvl", "lvl_name", new ArrayList<>()));
        }
        Building building = new Building("bid", "bname", levels);
        assertEquals(0, lv.visitBuilding(building));
    }

    @Test
    void visitEmptyRoomTest() {
        Room room = new Room("rname", "rid", 0, 0, 0, 0);
        assertEquals(0, lv.visitRoom(room));
    }

    @Test
    void visitPartiallyEmptyLevelTest() {
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 10; i <= 50; i += 10) {
            if(i % 20 == 0)
                r.add(new Room("rid", "rname", 1, 0, 0, i));
            else
                r.add(new Room("rid", "rname", 0, 0, 0, i));
        }
        assertEquals(30, lv.visitLevel(new Level("lid", "lname", r)));
    }
}
