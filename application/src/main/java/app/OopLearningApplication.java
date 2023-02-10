package app;

import adapter.MoneyConverter;
import dto.babysitting.VisitableDTO;
import dto.vendingmachine.PaymentMethodsDTO;
import lombok.extern.slf4j.Slf4j;
import machine.Product;
import machine.VendingMachine;
import org.apache.commons.lang3.StringUtils;
import payment.ElectronicPayment;
import payment.NonElectronicPayment;
import utils.JsonHelper;
import visitor.Babysitter;

import java.util.List;

@Slf4j
public class OopLearningApplication {

    private static final String BASE_RESOURCES_PATH = "application/src/main/resources/";

    private static void executeBabysittingExample() {
        log.info("\n\n---An example execution of the Babysitter module---\n ");

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

    private static void executeVendingMachineExample() {
        log.info("\n\n---An example execution of the Vending machine module---\n ");
        String output = StringUtils.EMPTY;

        PaymentMethodsDTO patientFactoryDTOList =
                JsonHelper.readJsonFile(BASE_RESOURCES_PATH + "vendingmachine/payments.json", PaymentMethodsDTO.class);


        VendingMachine vendingMachine = new VendingMachine();
        streamPaymentMethodsList(patientFactoryDTOList.getBankCheques(), vendingMachine);
        streamPaymentMethodsList(patientFactoryDTOList.getDebitCards(), vendingMachine);
        streamPaymentMethodsList(patientFactoryDTOList.getCashes(), vendingMachine);
    }

    private static void streamPaymentMethodsList(List list, VendingMachine vendingMachine) {
        list.stream().forEach(element -> {
            if (element instanceof ElectronicPayment electronicPayment) {
                log.info(vendingMachine.buy(Product.getRandomProduct(), electronicPayment));
            } else if (element instanceof NonElectronicPayment nonElectronicPayment) {
                log.info(vendingMachine.buy(Product.getRandomProduct(), new MoneyConverter(nonElectronicPayment)));
            }
        });
    }

    public static void main(String[] args) {
        executeBabysittingExample();
        executeVendingMachineExample();
    }
}
