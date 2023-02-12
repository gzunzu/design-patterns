package payment;

public interface ElectronicPayment {

    boolean isChargeable(Float price);

    String charge(Float price, String reason);
}
