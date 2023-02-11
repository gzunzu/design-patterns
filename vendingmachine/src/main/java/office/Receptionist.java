package office;

import adapter.MoneyConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import payment.ElectronicPayment;
import payment.NonElectronicPayment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Receptionist {

    private List<Pair<Product, ElectronicPayment>> purchases;

    private VendingMachine vendingMachine;

    public Receptionist() {
        this.purchases = new ArrayList<>();
        this.vendingMachine = new VendingMachine();
    }

    public <T> void add(List<T> list) {
        if (list.stream().allMatch(ElectronicPayment.class::isInstance)) {
            this.add(list.toArray(new ElectronicPayment[list.size()]));
        } else if (list.stream().allMatch(NonElectronicPayment.class::isInstance)) {
            this.add(list.toArray(new NonElectronicPayment[list.size()]));
        }
    }

    private void add(ElectronicPayment... electronicPayers) {
        Arrays.asList(electronicPayers).stream().forEach(payer -> this.add(Product.getRandomProduct(), payer));
    }

    private void add(Product product, ElectronicPayment electronicPayer) {
        this.purchases.add(Pair.of(product, electronicPayer));
    }

    private void add(NonElectronicPayment... nonElectronicPayers) {
        Arrays.asList(nonElectronicPayers).stream().forEach(payer -> this.add(Product.getRandomProduct(), payer));
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
        String result = StringUtils.EMPTY;
        this.shuffle();
        for (Pair purchase : this.purchases) {
            result += this.vendingMachine.buy((Product) purchase.getLeft(), (ElectronicPayment) purchase.getRight());
        }
        return result;
    }
}
