package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class BuildingTest {

    private Building building;

    @BeforeEach
    void setUp() {
        this.building = new Building("building_id", "building_name", new ArrayList<>());
    }

    @Test
    void getLevelsTest() {
        assertEquals(0, this.building.getLevels().size());
        List<Level> l = this.building.getLevels();
        assertSame(l, this.building.getLevels());
    }

    @Test
    void addLevelTest() {
        Level l = new Level("l_id", "l_name", new ArrayList<>());
        this.building.addLevel(l);
        assertEquals("l_id", this.building.getLevels().get(0).getId());
        assertEquals(1, this.building.getLevels().size());
    }

    @Test
    void removeLevelTest() {
        Level l = new Level("l_id", "l_name", new ArrayList<>());
        this.building.addLevel(l);
        this.building.removeLevel(l);
        assertEquals(0, this.building.getLevels().size());
    }

    @Test
    void getNameTest() {
        assertEquals("building_name", this.building.getName());
    }

    @Test
    void getIdTest() {
        assertEquals("building_id", this.building.getId());
    }
}
