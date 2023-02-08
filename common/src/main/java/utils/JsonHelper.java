package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@Slf4j
public abstract class JsonHelper {

    public static Object readJsonFile(String filePath, Class clazz) {
        try {
            return new ObjectMapper().readValue(new File(filePath), clazz);
        } catch (NoSuchFileException nsfe) {
            log.error(nsfe.getMessage());
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
        return null;
    }
}
