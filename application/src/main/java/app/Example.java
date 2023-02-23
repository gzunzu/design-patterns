package app;

import business.Store;
import dto.OrdersDTO;
import dto.PaymentMethodsDTO;
import dto.VisitableDTO;
import lombok.AllArgsConstructor;
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
        VisitableDTO visitableDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "babysitting/visitables.json", VisitableDTO.class);
        Assert.notNull(visitableDTO, "The VisitableDTO provided shouldn't be null.");

        final Babysitter babysitter = new Babysitter();
        babysitter.admit(visitableDTO.getVisitables());
        babysitter.shuffle();

        final String result = "\n---An example execution of the Babysitting module---\n "
                .concat(babysitter.takeCare());

        babysitter.finishWork();

        return result;
    };

    public static final Supplier<String> FAST_FOOD_SUPPLIER = () -> {
        OrdersDTO ordersDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "fastfood/orders.json", OrdersDTO.class);
        Assert.notNull(ordersDTO, "The OrdersDTO provided shouldn't be null.");

        final Service service = new Service();
        service.addOrders(ordersDTO.getWebOrders());
        service.addOrders(ordersDTO.getTelephoneOrders());
        service.addOrders(ordersDTO.getTakeawayOrders());
        service.shuffle();

        final String result = "\n---An example execution of the Fast food module---\n "
                .concat(service.processOrders());

        service.finishWork();

        return result;
    };

    public static final Supplier<String> VEHICLES_SUPPLIER = () -> {
        Store store = new Store();

        store.addVehicles(
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COMMON_FAMILIAR, "BLUE"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.PRACTICAL_WORKERS, "GREY"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COOL_SPORTS, "RED")
        );

        final String result = "\n---An example execution of the Vehicles module---\n "
                .concat(Store.showAvailableModels())
                .concat(store.showVehicles());

        store.deleteVehicles();
        Store.deleteModels();

        return result;
    };

    public static final Supplier<String> VENDING_MACHINE_SUPPLIER = () -> {

        PaymentMethodsDTO paymentMethodsDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "vendingmachine/payments.json", PaymentMethodsDTO.class);
        Assert.notNull(paymentMethodsDTO, "The PaymentMethodsDTO provided shouldn't be null.");

        final Receptionist receptionist = new Receptionist();
        receptionist.add(paymentMethodsDTO.getBankCheques());
        receptionist.add(paymentMethodsDTO.getDebitCards());
        receptionist.add(paymentMethodsDTO.getCashes());
        receptionist.shuffle();

        final String result = "\n---An example execution of the Vending machine module---\n "
                .concat(receptionist.assistCoworkers());

        receptionist.finishWork();

        return result;
    };

    @AllArgsConstructor
    enum Module {
        BABYSITTING("babysitting", BABYSITTING_SUPPLIER),
        FAST_FOOD("fastfood", FAST_FOOD_SUPPLIER),
        VEHICLES("vehicles", VEHICLES_SUPPLIER),
        VENDING_MACHINE("vendingmachine", VENDING_MACHINE_SUPPLIER);

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