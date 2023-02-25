package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;

import static java.util.Arrays.stream;

@NoArgsConstructor(access = AccessLevel.NONE)
public class LoggerHelper {

    public static void shutDownLogs(Class<?>... classes) {
        stream(classes).forEach(clazz ->
                LogManager.getFactory().shutdown(clazz.getCanonicalName(),
                        clazz.getClassLoader(),
                        false,
                        true));
    }
}
