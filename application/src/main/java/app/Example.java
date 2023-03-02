package app;

import business.Barman;
import business.Store;
import dto.ChannelsDTO;
import dto.CocktailsDTO;
import dto.PaymentMethodsDTO;
import dto.VisitablesDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import management.Service;
import office.Receptionist;
import org.springframework.util.Assert;
import utils.JsonHelper;
import vehicle.VehicleFactory;
import visitor.Babysitter;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

class Example {

    private static final String BASE_RESOURCES_PATH = "application/src/main/resources/";

    public static final Supplier<String> BABYSITTING_SUPPLIER = () -> {
        final VisitablesDTO visitablesDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "babysitting/visitables.json", VisitablesDTO.class);
        Assert.notNull(visitablesDTO, "The VisitablesDTO provided shouldn't be null.");

        final Babysitter babysitter = new Babysitter();
        babysitter.admit(visitablesDTO);
        babysitter.shuffle();

        final String result = getExampleIntroPhrase(Module.BABYSITTING)
                .concat(babysitter.takeCare());

        babysitter.finishWork();

        return result;
    };

    public static final Supplier<String> COCKTAILS_SUPPLIER = () -> {
        final CocktailsDTO cocktailsDTO = new CocktailsDTO(1, 1, 1, 1);

        final Barman barman = new Barman();
        barman.getCocktailOrders(cocktailsDTO.getCocktails());

        final String result = getExampleIntroPhrase(Module.COCKTAILS)
                .concat(barman.openBar());

        barman.closeBar();

        return result;
    };

    public static final Supplier<String> FAST_FOOD_SUPPLIER = () -> {
        final ChannelsDTO channelsDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "fastfood/orders.json", ChannelsDTO.class);
        Assert.notNull(channelsDTO, "The ChannelsDTO provided shouldn't be null.");

        final Service service = new Service();
        service.addChannels(channelsDTO);
        service.shuffle();

        final String result = getExampleIntroPhrase(Module.FAST_FOOD)
                .concat(service.processOrders());

        service.finishWork();

        return result;
    };

    public static final Supplier<String> VEHICLES_SUPPLIER = () -> {
        final Store store = new Store();

        store.addVehicles(
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COMMON_FAMILIAR, "BLUE"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.PRACTICAL_WORKERS, "GREY"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COOL_SPORTS, "RED")
        );

        final String result = getExampleIntroPhrase(Module.VEHICLES)
                .concat(Store.showAvailableModels())
                .concat(store.showVehicles());

        store.deleteVehicles();
        Store.deleteModels();

        return result;
    };

    public static final Supplier<String> VENDING_MACHINE_SUPPLIER = () -> {
        final PaymentMethodsDTO paymentMethodsDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "vendingmachine/payments.json", PaymentMethodsDTO.class);
        Assert.notNull(paymentMethodsDTO, "The PaymentMethodsDTO provided shouldn't be null.");

        final Receptionist receptionist = new Receptionist();
        receptionist.add(paymentMethodsDTO);
        receptionist.shuffle();

        final String result = getExampleIntroPhrase(Module.VENDING_MACHINE)
                .concat(receptionist.assistCoworkers());

        receptionist.finishWork();

        return result;
    };

    private static String getExampleIntroPhrase(Module module) {
        return String.format("%n<--An example execution of the %s module--->%n%n", module.getName());
    }

    @AllArgsConstructor
    enum Module {
        BABYSITTING("babysitting", BABYSITTING_SUPPLIER),
        COCKTAILS("cocktails", COCKTAILS_SUPPLIER),
        FAST_FOOD("fastfood", FAST_FOOD_SUPPLIER),
        VEHICLES("vehicles", VEHICLES_SUPPLIER),
        VENDING_MACHINE("vendingmachine", VENDING_MACHINE_SUPPLIER);

        @Getter(AccessLevel.PRIVATE)
        private final String name;

        private final Supplier<String> function;

        String getFunctionResult() {
            return this.function.get();
        }

        static Optional<Module> getByName(String moduleName) {
            return Arrays.stream(values())
                    .filter(module -> module.name.equalsIgnoreCase(moduleName))
                    .findAny();
        }
    }
}