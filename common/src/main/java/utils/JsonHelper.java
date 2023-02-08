package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JsonHelper {

    public ObjectMapper readJson(String filePath) {
        ObjectMapper objectMapper = null;
        try {
            byte[] mapData = Files.readAllBytes(Paths.get("babysitting/exampledata.json"));
            Map<String, String> myMap = new HashMap<String, String>();

            objectMapper = new ObjectMapper();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objectMapper;
    }
}
