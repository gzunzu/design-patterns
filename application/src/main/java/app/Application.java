package app;

import app.Example.Module;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@Log4j2
public class Application {

    private static void manageArgs(String[] args) {
        if (ArrayUtils.isEmpty(args)) {
            Arrays.stream(Module.values()).forEach(module -> log.info(module.getFunctionResult()));
        } else {
            Arrays.stream(args).forEach(arg -> {
                Optional<Module> optionalModule = Module.getByName(arg);
                if (optionalModule.isPresent()) {
                    log.info(optionalModule.get().getFunctionResult());
                } else {
                    log.warn("There's no available example for such «{}» nonexistent module. " +
                            "Please, verify typing of module name given as execution argument.", arg);
                }
            });
        }
    }

    public static void main(String[] args) {
        manageArgs(args);
    }
}
