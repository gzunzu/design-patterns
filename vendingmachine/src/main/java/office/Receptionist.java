package office;

import adapter.MoneyConverter;
import dto.PaymentMethodsDTO;
import org.apache.commons.lang3.tuple.Pair;
import payment.ElectronicPayment;
import payment.NonElectronicPayment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receptionist {

    private final List<Pair<Product, ElectronicPayment>> purchases;

    private final VendingMachine vendingMachine;

    public Receptionist() {
        this.purchases = new ArrayList<>();
        this.vendingMachine = new VendingMachine();
    }

    public void add(PaymentMethodsDTO paymentMethodsDTO) {
        paymentMethodsDTO.getElectronicPaymentMethods()
                .forEach(element -> this.add(Product.getRandomProduct(), element));
        paymentMethodsDTO.getNonElectronicPaymentMethods()
                .forEach(element -> this.add(Product.getRandomProduct(), element));
    }

    private void add(Product product, ElectronicPayment electronicPayer) {
        this.purchases.add(Pair.of(product, electronicPayer));
    }

    private void add(Product product, NonElectronicPayment nonElectronicPayer) {
        this.purchases.add(Pair.of(product, new MoneyConverter(nonElectronicPayer)));
    }

    public void shuffle() {
        Collections.shuffle(this.purchases);
    }

    public void finishWork() {
        this.purchases.clear();
    }

    public String assistCoworkers() {
        StringBuilder result = new StringBuilder();
        this.shuffle();
        for (Pair<Product, ElectronicPayment> purchase : this.purchases) {
            result.append(this.vendingMachine.buy(purchase.getLeft(), purchase.getRight()));
        }
        return result.toString();
    }
}
