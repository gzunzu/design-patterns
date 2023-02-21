package app;

import business.Store;
import dto.OrdersDTO;
import dto.PaymentMethodsDTO;
import dto.VisitableDTO;
import lombok.extern.log4j.Log4j2;
import management.Service;
import office.Receptionist;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.JsonHelper;
import vehicle.VehicleFactory;
import visitor.Babysitter;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
@Log4j2
public class Application {

    private static final String BASE_RESOURCES_PATH = "application/src/main/resources/";

    static void executeBabysittingExample() {
        log.info("\n---An example execution of the Babysitter module---\n ");

        VisitableDTO visitableDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "babysitting/visitables.json", VisitableDTO.class);
        assert Objects.nonNull(visitableDTO);

        final Babysitter babysitter = new Babysitter();
        babysitter.admit(visitableDTO.getBabies());
        babysitter.admit(visitableDTO.getToddlers());
        babysitter.admit(visitableDTO.getPreschoolers());
        babysitter.admit(visitableDTO.getDogs());
        babysitter.shuffle();
        log.info(babysitter.takeCare());
        babysitter.finishWork();
    }

    static void executeVehiclesExample() {
        log.info("\n---An example execution of the Vehicle module---\n ");

        Store store = new Store();

        store.addVehicles(
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COMMON_FAMILIAR, "BLUE"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.PRACTICAL_WORKERS, "GREY"),
                VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COOL_SPORTS, "RED")
        );

        log.info(Store.showAvailableModels().concat(store.showVehicles()));
        store.deleteVehicles();
        Store.deleteModels();
    }

    static void executeFastFoodExample() {
        log.info("\n---An example execution of the Fast food module---\n ");

        OrdersDTO ordersDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "fastfood/orders.json", OrdersDTO.class);
        assert Objects.nonNull(ordersDTO);

        final Service service = new Service();
        service.addOrders(ordersDTO.getWebOrders());
        service.addOrders(ordersDTO.getTelephoneOrders());
        service.addOrders(ordersDTO.getTakeawayOrders());
        service.shuffle();
        log.info(service.processOrders());
        service.finishWork();
    }

    static void executeVendingMachineExample() {
        log.info("\n---An example execution of the Vending machine module---\n ");

        PaymentMethodsDTO paymentMethodsDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "vendingmachine/payments.json", PaymentMethodsDTO.class);
        assert Objects.nonNull(paymentMethodsDTO);

        final Receptionist receptionist = new Receptionist();
        receptionist.add(paymentMethodsDTO.getBankCheques());
        receptionist.add(paymentMethodsDTO.getDebitCards());
        receptionist.add(paymentMethodsDTO.getCashes());
        receptionist.shuffle();
        log.info(receptionist.assistCoworkers());
        receptionist.finishWork();
    }

    private static void manageArgs(String[] args) {
        if (ArrayUtils.isEmpty(args)) {
            Arrays.stream(Example.values()).forEach(example -> example.getMethod().run());
        } else {
            Arrays.stream(args).forEach(arg -> {
                Optional<Example> optionalExample = Example.getFunctionByModuleName(arg);
                if (optionalExample.isPresent()) {
                    optionalExample.get().getMethod().run();
                } else {
                    log.error("There's no example available for such «{}» called module. " +
                                    "Please, verify typing of module name given as execution argument.",
                            arg,
                            new NoSuchElementException()
                    );
                }
            });
        }
    }

    public static void main(String[] args) {
        manageArgs(args);
    }
}
