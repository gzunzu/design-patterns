package payment;

public interface NonElectronicPayment {

    Boolean hasEnoughFounds(Float price);

    String charge(Float price);
}
