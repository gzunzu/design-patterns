# EJEMPLO DE PATRÓN FACTORY METHOD

## Description

Here it comes the second part of these example. OK, we have a great way to create [`Model`](src/main/java/vehicle/Model.java)
instances. Now it's time to let people know about these options we offer and waiting for them to pic whichever specific
[`features`](src/main/java/feature/Feature.java) the want for their [`vehicle`](src/main/java/vehicle/Vehicle.java) instance.
As sellers of these products, we know that from the multiple combinations of [`features`](src/main/java/feature/Feature.java)
we offer in each model, people usually want the same ones. E.g.: people who buy a brand-new sports car is rare to
decide for the lowest [`horsepower`](src/main/java/feature/HorsePower.java) option; or people who ask for
a roomy larger model it's hardly picking a 3 [`door set`](src/main/java/feature/DoorsCount.java).

So it would be nice to have some way to quickly get a [`Vehicle`](src/main/java/vehicle/Vehicle.java) instance
with the standard configuration for the most popular [`Model`](src/main/java/vehicle/Model.java) characteristics
acquired by our costumers, don't you think? That's what the Factory method is about.

* Uso de tipo enumerado: **Java Enum**.
* Uso de **Herencia** y **Polimorfismo**.
* Uso de **Streams** para recorrer y filtrar colecciones.
