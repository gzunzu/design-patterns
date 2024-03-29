package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class JsonHelper {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
                .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true);
    }

    public static <T> T readJsonFile(String filePath, Class<T> clazz) {
        try {
            return MAPPER.readValue(new File(filePath), clazz);
        } catch (IOException nsfe) {
            log.error(nsfe.getMessage());
        }
        return null;
    }

    public static <T> List<T> readJsonArrayFile(String filePath, Class<T> clazz) {
        try {
            return MAPPER.readValue(new File(filePath),
                    MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException nsfe) {
            log.error(nsfe.getMessage());
        }
        return Collections.emptyList();
    }
}
