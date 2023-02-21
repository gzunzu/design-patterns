# Car dealer \[Builder | Factory method\]

## Description

Module Vehicles is a sample implementation of two **creational** design patterns: Builder and Factory method. This
category of patterns helps us simplify the initialization task when an Object has too many attributes to configure –Builder–
or when creating a new instance usually requieres the same certain group of params –Factory method–.

We have a vehicle selling business. As you probably already know, there are a lot of different vehicles out there; even multiple
models from the same branches. This is because every vehicle has different [`features`](src/main/java/feature/Feature.java).
Those characteristics go from the [`style`](src/main/java/feature/Style.java) (type of vehicle) to the [`extras`](src/main/java/feature/Extra.java)
or the [`colour`](src/main/java/feature/Colour.java). The branches design their [`models`](src/main/java/vehicle/Model.java), usually leaving a few
open options for clients to choose among some of these [`features`](src/main/java/feature/Feature.java),
like the [`fuel`](src/main/java/feature/Fuel.java) used, or even sometimes the number of [`doors`](src/main/java/feature/DoorsCount.java).

### Builder

If you think about it, designing –or configuring– a [`model`](src/main/java/vehicle/Model.java) is a tedious task.
There's a lot of things to decide; so it would be useful to have some help instantiating them. And here is where
the Builder class appears. As a subclass of [`Model`](src/main/java/vehicle/Model.java), we have the `ModelBuilder`class,
with the same attributes, but just one constructor with the minimum required params for a [`Model`](src/main/java/vehicle/Model.java)
to be operative, and `setter` methods for every other configuration we want to add, always **returning** their own instance.
This is the key for the Builder pattern, because we can make a chain with the different `set` invocations, as they all return
the object we are configuring; and then, when we finish, we call the `build()` method, that returns the new instance
of [`Model`](src/main/java/vehicle/Model.java).

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

You can see it working in [`Store`](src/main/java/business/Store.java) class, but it would be as easy as following
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
[`Model`](src/main/java/business/Store.java) class are mostly collections of enum types in order to keep the example
bounded and simple, but realize these could be even much more profitable when we require many `String`, `boolean`
or numeric params, whose order could be hard to read and distinguish in a common Constructor method.

It's important to remember that `ModelBuilder.build()` method invokes [`Model`](src/main/java/vehicle/Model.java) Constructor
method. So, you can use the same `ModelBuilder` instance to create multiple [`models`](src/main/java/vehicle/Model.java)
with the same attributes' values, but notice that you won't get a reference to the same object, but a new instance each time.

### Factory method

Now that we have some defined models, it's time to share them and let people choose the ideal
configuration for their lifestyle. It's at this moment when we realize that's a lot for them. People are not always comfortable
making decisions to buy something, because it raises our stress levels. So it would be nice to have some
«pre-configured packages» with the most popular features, just like the travel agencies do for
saving us the work of planing every step of our holidays. Imagine that you could instantiate a complete
new [`Vehicle`](src/main/java/vehicle/Vehicle.java) by calling a method giving just one param with the «package name».
Well, that's a Factory method pattern, implemented in [`VehicleFactory`](src/main/java/vehicle/VehicleFactory.java) class
in this example. We ask for the pre-configured package and the colour. The package is an enum subclass containing
the reference to the inheritor class of[`Vehicle`](src/main/java/vehicle/Vehicle.java) corresponding to the package,
whose implementation has a complete set of features already defined in the Constructor method
(no need to call setters nor specify params) and it returns an instance. As simple
as it sounds. We can create as much "packages" as inheritors of Vehicle we want to have pre-configured. In this
example, we let the colour election out of the pre-configuration for clients to be able to still pick that feature. As you see,
you can select what you want to configure automatically and what you want to ask for.

Regarding the [`VehicleFactory`](src/main/java/vehicle/VehicleFactory.java) class, you have
to know that this is not the traditional implementation of the static method for getting the desired instance.
This is a totally parametrized version which would never be modified with upcoming new inheritors
of [`Vehicle`](src/main/java/vehicle/Vehicle.java) –new «packages»–, because in that case we would just
add new values to the `VehiclePackage` subclass. It's also more «insecure» or fragile due to the amount of runtime
exceptions we can get by calling a constructor whose reference is obtained from a variable. The most popular
way to implement this method is creating a switch loop, having one `case` clause for each type of instance/inheritor.
For our particular example, this would have been the code:

````java
public class VehicleFactory {

    public static Vehicle getVehicle(@NotBlank String packageName, @NotBlank String colour) {
        switch (packageName) {
            case "common familiar":
                return new CommonFamiliarVehicle(Store.getModelByName("Urban Family"), colour);
            case "practical workers":
                return new PracticalWorkersVehicle(Store.getModelByName("Hard Labourer"), colour);
            case "cool sports":
                return new CoolSportsVehicle(Store.getModelByName("Hot Player"), colour);
            default:
                String errorMessage = String.format("Unrecognized value for pack ame [%s] or colour [%s].", packageName, colour);
                log.error(errorMessage);
                throw new UnsupportedOperationException(errorMessage);
        }
    }
}
````

Of course, you can still end up with a third version somewhere in the middle of these two, combining the use of
the switch loop and the enum class.

## Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Use of `Assert` class's methods for Vehicle features validation throughout instantiation process.