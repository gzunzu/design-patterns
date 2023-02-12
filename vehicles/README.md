# Car dealer \[Builder | Factory method\]

## Description

Module Car dealer is a sample implementation of the **creational** design pattern Builder. This
category of patterns helps us simplify the initialization task when an Object has too many attributes to configure –Builder–
or when creating a new instance usually requieres the same certain group of params.

We have a vehicle selling business. As you probably already know, there are a lot of different vehicles out there; even multiple
models from the same branches. This is because every vehicle has different [`features`](src/main/java/feature/Feature.java).
Those characteristics go from the [`style`](src/main/java/feature/Style.java) or type of vehicle to the [`extras`](src/main/java/feature/Extra.java)
or the [`colour`](src/main/java/feature/Colour.java). The branches design their [`models`](src/main/java/vehicle/Model.java) letting
the client choose some of these [`features`](src/main/java/feature/Feature.java), like the [`fuel`](src/main/java/feature/Fuel.java)
used, or even sometimes the number of [`doors`](src/main/java/feature/DoorsCount.java).

If you think about it, designing –or configuring– a [`model`](src/main/java/vehicle/Model.java) is a tedious task.
There's a lot of thing to decide; so it would be useful to have some help instantiating them. And here is when
the Builder class appears. As a subclass of [`Model`](src/main/java/vehicle/Model.java), we have the `ModelBuilder`class,
with the same attributes, but just one constructor with the minimum required params for a [`Model`](src/main/java/vehicle/Model.java)
to be operative, and `setter` methods for every other configuration we want to add, always **returning** their own instance.
This is the key for the builder pattern, because we can make a chain with the different `set` invocations, as they all return
the object we are configuring; and then, when we finish, we call the `build()` method, that returns a new instance of
the [`Model`](src/main/java/vehicle/Model.java).

````java
public static class ModelBuilder {

    // Other attributes (same as Model class), a Constructor with Model's required attributes and setter methods.

    public Model build() {
        return new Model(this);
    }
}
````

The last piece of these pattern is to add that Constructor to the [`Model`](src/main/java/vehicle/Model.java) class,
which is the only alteration it will get while implementing this pattern:

````java
public class Model {

    // Other attributes and methods.

    public Model(ModelBuilder modelBuilder) {
        this.name = modelBuilder.getName();
        this.style = modelBuilder.getStyle();
        this.basePrice = modelBuilder.getBasePrice();
        this.availableColours = modelBuilder.getAvailableColours();
        this.availableDoorsCount = modelBuilder.getAvailableDoorsCount();
        this.availableExtras = modelBuilder.getAvailableExtras();
        this.availableFuels = modelBuilder.getAvailableFuels();
        this.availableHorsePowers = modelBuilder.getAvailableHorsePowers();
    }
}
````

You can see it working on [`Store`](src/main/java/business/Store.java) class, but it would be as easy as following
the body of this improvised `createModel()` method:

````java
public class ModelCreator {

    public static Model createModel() {
        return model = new ModelBuilder("Model name", Style.CARGO, 5850f)
                .setAvailableColours(Colour.BLACK, Colour.BLUE, Colour.BROWN)
                .setAvailableFuels(Fuel.GASOLINE, Fuel.DIESEL)
                // Other additional features desired.
                .build();
    }
}
````

So readable, so easy to handle, and if you check the setter methods declared on `ModelBuilder` class you'll see
there's a bunch of useful tools to create or modify the specifications of the object. The characteristics of this
[`Model`](src/main/java/business/Store.java) class are mostly collections of enum types in order to keep the example simple, but
realize these could be even much more profitable when we require `String` or many `boolean` or numeric params,
whose order could be hard to read and distinguish in a common Constructor method.

It's important to remember that `ModelBuilder.build()` method invokes a [`Model`](src/main/java/vehicle/Model.java) Constructor
method. So, you can use the same `ModelBuilder` instance to create various [`models`](src/main/java/vehicle/Model.java)
with the same attributes values, but notice that you won't get a reference to the same object, but a new instance each time.

## Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).