package adapter;

import lombok.AllArgsConstructor;
import payment.ElectronicPayment;
import payment.NonElectronicPayment;

@AllArgsConstructor
public class MoneyConverter implements ElectronicPayment {

    private NonElectronicPayment nonElectronicPayment;

    @Override
    public boolean isChargeable(Float price) {
        return this.nonElectronicPayment.hasEnoughFounds(price);
    }

    @Override
    public String charge(Float price, String reason) {
        return "[MONEY CONVERTER (ADAPTER)] OK, old-fashioned. Give me your non-electronic money and I'll make it for you.\n"
                + this.nonElectronicPayment.charge(price)
                + "\n[MONEY CONVERTER (ADAPTER)] Thanks. I'll make the online payment for you to the machine.";
    }
}
