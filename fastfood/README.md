## Fast food \[Dependency injection]

#### Description

Module Fast food is an example of the Dependency injection pattern. This is for sure one of the most
common patterns used in OOP programming, because it helps us to reach a high level of **decoupling**.

This one is about a food selling business. They can take orders from different channels
and, as you can guess, each [`channel`](src/main/java/channels/Channel.java) has its own particularities. Eg, if you order from a
[`telematic channel`](src/main/java/channels/TelematicChannel.java), it is easy to understand that they will always need al least your location
for delivering. And, additionally, each one of these will need its own specifications, like an e-mail for [`web`](src/main/java/channels/Web.java)
or a phone number for [`telephone`](src/main/java/channels/Telephone.java) clients. But, if you'd rather to pass by and pick up your food,
they still have the [`takeaway`](src/main/java/channels/Takeaway.java) traditional channel, in which they will only requiere a name
to shout when your meal is ready.

So, as you can see, [`channels`](src/main/java/channels/Channel.java) have some functions in common, but they also have
differences. Everything could be easily solved with inheritance relationships for now. But, how cool would it be to
have promos? The owners approve the idea, but they are interested in promoting some channels, not all of them. And... those promoted are the
[`takeaway`](src/main/java/channels/Takeaway.java) and the [`web`](src/main/java/channels/Web.java), not in the same inheritance
hierarchy line. No problem! We can declare [`Promoted`](src/main/java/channels/Promoted.java) as an interface in which every
promoted channel will be able to check if its offer is active and to tell the promo:

```java
interface Promoted {

    boolean isPromoActive();

    String announcePromo();
}

````

The most interesting details of these example come next. If we are willing to be good developers –and we are, for sure–, we have to be organized
and don't mess our code. If you think about this scenario in real life, people who deliver the orders don't have to know about the details of the
promos or the available channels, as well as people who manage one channel doesn't have to know about the others.
In every business, the tasks are divided and isolated as much as possible, so that an internal change in any area/department
should not affect the other ones.

Back to our code, you can
see we have an  [`Order`](src/main/java/management/Order.java) class. Its responsibility is just to process the orders and keep a counter updated.
Of course, this class has a dependency with a [`Channel`](src/main/java/channels/Channel.java), but whichever the
concrete implementation is, it is capable of running the order, just basing the steps on the interface methods, which are the necessary minimums
for a [`Channel`](src/main/java/channels/Channel.java) to implement for being operative. Every specific task each channel wants to
add would be internal and could be put within the implementation of the common methods.
The best part is that the [`Order`](src/main/java/management/Order.java) class doesn't know how many channels there are, the specific
methods they use to operate, or even their names!

We can find a similar behaviour
about [`Promoted`](src/main/java/channels/Promoted.java) channels. We know they exist, but we don't know and don't care
which ones are or what they do when they have a Promo. When the time comes for us to `process` the order, we just call the
interface methods that let those channels «do their thing», and then we come back to the common procedure for every channel:

```java
public class Order {

    // Other constants, attributes and methods.

    public String process() {
        this.updateOrdersCounter();
        return new StringBuilder()
                .append(this.channel.welcome())
                .append(this.channel instanceof Promoted promo && promo.isActive() ? promo.announcePromo() : StringUtils.EMPTY) // Checking promos
                .append(this.getOrderNumber())
                .append(this.channel.serveClient())
                .append(this.channel.farewell())
                .append(SystemUtils.LINE_SEPARATOR)
                .toString();
    }
}

````

Notice that this code complies very well with the Open/Closed principle. If we want to add any
new [`channel`](src/main/java/channels/Channel.java),
promoted or not, or modify the existing ones about their particular required data or their promos, we don't need to change
the already existing code in [`Order`](src/main/java/management/Order.java) or [`Channel`](src/main/java/channels/Channel.java)
classes, least of all their implementations. We could've leaned on inheritance hierarchy relations for the channels, but remember
that this is only recommended when the inheritors share common attributes. In this case, we put that in practice with the
[`TelematicChannel`](src/main/java/channels/TelematicChannel.java) for simplifying the `location` attribute management,
but always remember Java doesn't support multiple inheritance, so it's usually a better choice to use an interface whenever
it's possible.

Wrapping up: the fact that an [`Order`](src/main/java/management/Order.java) always receives a reference to
the channel in the constructor –injected dependency– makes it possible to standardize the logic of processing
every order whichever channel it came from. This is the key of this **Dependency injection pattern** and a sign of
well planned structured and **low coupled code**.

#### Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).
- Use of **icu4j** library to generate ordinals in text may be of interest.