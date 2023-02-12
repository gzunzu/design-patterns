# Vending machine \[Adapter pattern]

## Description

Module Vending machine is a simple implementation of the Adapter pattern. This is one of the most simple
design patterns: it acts as a bridge between two incompatible interfaces.

Our office recently acquired a new [`vending machine`](src/main/java/office/VendingMachine.java). It's
one of the ultimate ones and offers great products, but its `buy` method only
admits [`electronic payment`](src/main/java/payment/ElectronicPayment.java).
We have some old-fashioned workers in the office that don't like or are not used to these technologies and stick with
[`non-electronic payment`](src/main/java/payment/NonElectronicPayment.java); and the
bosses are worried about for them to feel left apart. We cannot change how the office works, and they won't
buy another office, this is a new expensive one.

````java
public class VendingMachine {
    public String buy(Product product, ElectronicPayment payment) {
        // Machine operations to sell the product and claim the price.
    }
}
````

The [`receptionist`](src/main/java/office/Receptionist.java), who is popular and friendly with all co-workers
and whose working place is close to the vending machine,
offered to act as an intermediate for
the [`non-electronic payers`](src/main/java/payment/NonElectronicPayment.java).
Everytime anybody come to the machine, he will ask them what type of payer they are. If it is the case of a
[`non-electronic payer`](src/main/java/payment/NonElectronicPayment.java),
he'll ask them for the money, whichever type it is; and then he'll make
the [`electronic payment`](src/main/java/payment/ElectronicPayment.java)
through the office online system for them.

So, all the [`receptionist`](src/main/java/office/Receptionist.java) has to do is to use
a [`money converter`](src/main/java/adapter/MoneyConverter.java),
which is the so-called **Adapter class**. It acts as a «translator»
or a bridge: it is an [`electronic payer`](src/main/java/payment/ElectronicPayment.java), so it is able to pay through
the [`office`](src/main/java/office/VendingMachine.java) system;
and it also «wraps» the [`non-electronic payer`](src/main/java/payment/NonElectronicPayment.java) payment method
in management to take the same amount of money when the [`vending machine`](src/main/java/office/VendingMachine.java) asks for it,
using the methods the [`vending machine`](src/main/java/office/VendingMachine.java) is not
built to understand, because it does not know how to interact
with [`non-electronic payers`](src/main/java/payment/NonElectronicPayment.java). Fortunately, he understands how
both parts work.

````java
public class MoneyConverter implements ElectronicPayment {

    private NonElectronicPayment nonElectronicPayment;

    @Override
    public Boolean isChargeable(Float price) {
        // Code to adapt using for the nonElectronicPayment; calling itsmethods, if it's necessary.
    }

    @Override
    public String charge(Float price, String reason) {
        // Code to adapt for the nonElectronicPayment; calling its methods, if it's necessary.
    }
}
````

## Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).