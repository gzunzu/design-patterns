package app;

import dto.babysitting.VisitableDTO;
import dto.fastfood.OrdersDTO;
import dto.vendingmachine.PaymentMethodsDTO;
import lombok.extern.log4j.Log4j2;
import management.Service;
import office.Receptionist;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.JsonHelper;
import visitor.Babysitter;

@SpringBootApplication
@Log4j2
public class OopLearningApplication {

    private static final String BASE_RESOURCES_PATH = "application/src/main/resources/";

    private static void executeBabysittingExample() {
        log.info("\n---An example execution of the Babysitter module---\n ");

        VisitableDTO visitableDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "babysitting/visitables.json", VisitableDTO.class);

        final Babysitter babysitter = new Babysitter();
        babysitter.admit(visitableDTO.getBabies());
        babysitter.admit(visitableDTO.getToddlers());
        babysitter.admit(visitableDTO.getPreschoolers());
        babysitter.admit(visitableDTO.getDogs());
        babysitter.shuffle();
        log.info(babysitter.takeCare());
        babysitter.finishWork();
    }

    private static void executeFastFoodExample() {
        log.info("\n---An example execution of the Fast food module---\n ");

        OrdersDTO ordersDTO =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "fastfood/orders.json", OrdersDTO.class);

        final Service service = new Service();
        service.addOrders(ordersDTO.getWebOrders());
        service.addOrders(ordersDTO.getPhoneOrders());
        service.addOrders(ordersDTO.getTakeawayOrders());
        service.shuffle();
        log.info(service.processOrders());
        service.finishWork();
    }

    private static void executeVendingMachineExample() {
        log.info("\n---An example execution of the Vending machine module---\n ");

        PaymentMethodsDTO patientFactoryDTOList =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "vendingmachine/payments.json", PaymentMethodsDTO.class);

        final Receptionist receptionist = new Receptionist();
        receptionist.add(patientFactoryDTOList.getBankCheques());
        receptionist.add(patientFactoryDTOList.getDebitCards());
        receptionist.add(patientFactoryDTOList.getCashes());
        receptionist.shuffle();
        log.info(receptionist.assistCoworkers());
        receptionist.finishWork();
    }

    public static void main(String[] args) {
        executeBabysittingExample();
        executeFastFoodExample();
        executeVendingMachineExample();
    }
}
