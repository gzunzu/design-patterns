package payment;

public interface ElectronicPayment {

    Boolean isChargeable(Float price);

    String charge(Float price, String reason);
}
