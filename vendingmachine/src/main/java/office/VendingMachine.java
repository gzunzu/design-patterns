package office;

import payment.ElectronicPayment;

public class VendingMachine {

    public String buy(Product product, ElectronicPayment payment) {
        String response = "\n[MACHINE] You have selected «" + product.getName().toUpperCase()
                + "». Please, pay through our highly secure online system.\n";
        if (payment.isChargeable(product.getPrice())) {
            response += payment.charge(product.getPrice(), "«Vending machine's " + product.getName() + "»");
            response += String.format("%n[MACHINE] Payment of %.2f € received. Enjoy your %s!"
                    , product.getPrice(), product.getName());
        } else {
            response = String.format("%n[MACHINE] Unable to charge %.2f €. Please, check your founds " +
                            "and make sure your electronic payment method is enabled."
                    , product.getPrice());
        }
        return response + "\n";
    }
}
