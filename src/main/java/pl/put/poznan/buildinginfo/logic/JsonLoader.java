package pl.put.poznan.buildinginfo.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {

    public JsonLoader() {
    }

    public List<ILocation> loadLocationsFromJson(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(jsonFilePath);
        CollectionType buildingListType = objectMapper.getTypeFactory().constructCollectionType(List.class, Building.class);
        List<Building> buildings = objectMapper.readValue(file, buildingListType);

        List<ILocation> locations = new ArrayList<>();

        if (buildings != null) {
            for (Building building : buildings) {
                if (building != null) {
                    locations.add(building);
                    if (building.getLevels() != null) {
                        for (Level level : building.getLevels()) {
                            locations.add(level);
                            if (level.getRooms() != null) {
                                locations.addAll(level.getRooms());
                            }
                        }
                    }
                }
            }
        }
        return locations;
    }
}
