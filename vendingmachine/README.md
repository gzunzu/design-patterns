## Vending machine \[Adapter pattern]

#### Description

Module Vending machine is a simple implementation of the Adapter pattern. This is one of the most simple
design patterns: it acts as a bridge between two incompatible interfaces.

Our office recently acquired a new [`vending machine`](src/main/java/machine/VendingMachine.java). It's
one of the ultimate ones and offers great products, but its `buy` method only
admits [`electronic payment`](src/main/java/payment/ElectronicPayment.java).
We have some old-fashioned workers in the office that don't like or are not used to these technologies and stick with
[`non-electronic payment`](src/main/java/payment/NonElectronicPayment.java); and the
bosses are worried about for them to feel left apart. We cannot change how the machine works, and they won't
buy another machine, this is a new expensive one.

````
public class VendingMachine {
    public String buy(Product product, ElectronicPayment payment) {
        // Machine operations to sell the product and claim the price.
    }
````

The receptionist, who is popular and friendly with all co-workers and whose working place is close to the machine,
offered to act as a [`money converter`](src/main/java/patient/ImperialUnitsUser.java) for
the [`non-electronic payers`](src/main/java/payment/NonElectronicPayment.java).
So everytime some [`non-electronic payer`](src/main/java/payment/NonElectronicPayment.java) want to buy something,
he interferes asking them for the money, whatever type is; and then he goes making
the [`electronic payment`](src/main/java/payment/ElectronicPayment.java)
through the machine online system.

So, what the [`money converter`](src/main/java/patient/ImperialUnitsUser.java) class does is to act as a «translator»
or a bridge: it is an [`electronic payer`](src/main/java/payment/ElectronicPayment.java), so it is able to pay through
the [`machine`](src/main/java/machine/VendingMachine.java) system;
and it also «wraps» the [`non-electronic payer`](src/main/java/payment/NonElectronicPayment.java) method of a partner
in order to ask take the money when the [`machine`](src/main/java/machine/VendingMachine.java) asks for it,
using the methods the [`machine`](src/main/java/machine/VendingMachine.java) is not
built to understand, because it does not know how to interact
with [`non-electronic payers`](src/main/java/payment/NonElectronicPayment.java).

#### Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).