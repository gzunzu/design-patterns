package app;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum Example {
    BABYSITTING("babysitting", Application::executeBabysittingExample),
    FAST_FOOD("fastfood", Application::executeFastFoodExample),
    VEHICLES("vehicles", Application::executeVehiclesExample),
    VENDING_MACHINE("vendingmachine", Application::executeVendingMachineExample);
    private final String moduleName;

    @Getter
    private final Runnable method;

    static Optional<Example> getFunctionByModuleName(String moduleName) {
        return Arrays.stream(Example.values())
                .filter(example -> example.moduleName.equalsIgnoreCase(moduleName))
                .findAny();
    }
}