package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnomalyDetectorTest {
    private Building building = null;
    private AnomalyDetector detector = null;
    private ArrayList<Room> allRooms = new ArrayList<>();
    @BeforeEach
    void setUp() {
        this.building = mock(Building.class);
        ArrayList<Level> mockedLevels = new ArrayList<>();
        for (double i = 1; i < 8; i = i + 2) {
            Level mockedLevel = mock(Level.class);
            ArrayList<Room> mockedRooms = new ArrayList<>();
            for (double j = 1; j < 10; j = j + 3) {
                Room mockedRoom = mock(Room.class);
                when(mockedRoom.getHeating()).thenReturn(i*j);
                mockedRooms.add(mockedRoom);
                this.allRooms.add(mockedRoom);
            }
            when(mockedLevel.getRooms()).thenReturn(mockedRooms);
            mockedLevels.add(mockedLevel);
        }
        when(building.getLevels()).thenReturn(mockedLevels);
        this.detector = new AnomalyDetector();
    }

    @Test
    void testGetAnomaliesHighRatio() {
        ArrayList<Room> anomalies = detector.getAnomalies(this.building,100.0);
        assertEquals(0, anomalies.size());

        assertEquals(Collections.emptyList(), anomalies);

        verify(building).getLevels();
        for (int i = 0; i < 4; i++) {
            verify(building.getLevels().get(i)).getRooms();
            for (int j = 0; j < 3; j++) {
                verify(building.getLevels().get(i).getRooms().get(j)).getHeating();
            }
        }
    }

    @Test
    void testGetAnomaliesOneExample() {
        ArrayList<Room> anomalies = detector.getAnomalies(this.building,48.0);
        assertEquals(1, anomalies.size());

        assertEquals(this.allRooms.get(11), anomalies.get(0));

        verify(building).getLevels();
        for (int i = 0; i < 4; i++) {
            verify(building.getLevels().get(i)).getRooms();
            for (int j = 0; j < 3; j++) {
                verify(building.getLevels().get(i).getRooms().get(j)).getHeating();
            }
        }
    }

    @Test
    void testGetAnomaliesZero() {
        ArrayList<Room> anomalies = detector.getAnomalies(this.building,0.0);
        assertEquals(12, anomalies.size());
        assertEquals(this.allRooms, anomalies);

        verify(building).getLevels();
        for (int i = 0; i < 4; i++) {
            verify(building.getLevels().get(i)).getRooms();
            for (int j = 0; j < 3; j++) {
                verify(building.getLevels().get(i).getRooms().get(j)).getHeating();
            }
        }
    }
}