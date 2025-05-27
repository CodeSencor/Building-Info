package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AreaVisitorTest {
    private static AreaVisitor visitor = null;
    @BeforeAll
    static void setUp() {
        visitor = new AreaVisitor();
    }
    @Test
    void testVisitRoom() {
        Room mockedRoom = mock(Room.class);
        when(mockedRoom.getArea()).thenReturn(5.0);

        assertEquals(5.0, this.visitor.visitRoom(mockedRoom));
        verify(mockedRoom).getArea();
    }

    @Test
    void testVisitLevel() {
        Level mockedLevel = mock(Level.class);
        ArrayList<Room> mockedRooms = new ArrayList<>();
        for (double i = 1; i < 4; i++) {
            Room mockedRoom = mock(Room.class);
            when(mockedRoom.getArea()).thenReturn(i);
            when(mockedRoom.acceptVisitor(any())).thenAnswer(new Answer<Object>() {
                public Object answer(InvocationOnMock invocation) {
                    return mockedRoom.getArea();
                }
            });
            mockedRooms.add(mockedRoom);
        }
        when(mockedLevel.getRooms()).thenReturn(mockedRooms);

        assertEquals(6.0, this.visitor.visitLevel(mockedLevel));
        verify(mockedLevel).getRooms();

        for (Room mockedRoom : mockedRooms) {
            verify(mockedRoom).acceptVisitor(this.visitor);
            verify(mockedRoom).getArea();
        }
    }

    @Test
    void testVisitBuilding() {
        Building mockedBuilding = mock(Building.class);
        ArrayList<Level> mockedLevels = new ArrayList<>();
        for (double j = 1; j < 4; j++) {
            Level mockedLevel = mock(Level.class);
            ArrayList<Room> mockedRooms = new ArrayList<>();
            for (double i = 1; i < 4; i++) {
                Room mockedRoom = mock(Room.class);
                when(mockedRoom.getArea()).thenReturn(i*j);
                when(mockedRoom.acceptVisitor(any())).thenAnswer(new Answer<Object>() {
                    public Object answer(InvocationOnMock invocation) {
                        return mockedRoom.getArea();
                    }
                });
                mockedRooms.add(mockedRoom);
            }
            when(mockedLevel.getRooms()).thenReturn(mockedRooms);
            when(mockedLevel.acceptVisitor(any())).thenAnswer(new Answer<Object>() {
                public Object answer(InvocationOnMock invocation) {
                    return visitor.visitLevel(mockedLevel);
                }
            });
            mockedLevels.add(mockedLevel);
        }
        when(mockedBuilding.getLevels()).thenReturn(mockedLevels);

        assertEquals(36.0, this.visitor.visitBuilding(mockedBuilding));
        verify(mockedBuilding).getLevels();

        for (Level mockedLevel : mockedLevels) {
            verify(mockedLevel).acceptVisitor(this.visitor);
        }
    }
}