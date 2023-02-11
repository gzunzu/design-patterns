## Fast food \[Dependency injection]

#### Description

Module Fast food is an example of the Dependency injection pattern. This is for sure onw of the most
common patterns used in OOP programming, because it helps us to reduce coupling dependencies to minimums.

This one is about a food selling business. They can take orders from different channels
and, as you can guess, each [`channel`](src/main/java/channels/Channel.java) has its own particularities. Eg, if you order from a
[`telematic channel`](src/main/java/channels/TelematicChannel.java), it is easy to understand that they will always need al least your location
for delivering. And, additionally, each one of these will need its own specifications, like an e-mail for [`web`](src/main/java/channels/Web.java)
or a phone number for [`Phone`](src/main/java/channels/Phone.java) clients. But, if you'd rather to pass by and take your food with you,
they still have the [`takeaway`](src/main/java/channels/Takeaway.java) traditional channel, in which they will only requiere a name
to shout when everything is ready for you to go.

So, as you can see, [`Channel`](src/main/java/channels/Channel.java) inheritors have some things in common, but they also have
differences. Everything is easily solved with inheritance relationships for now. But, how cool would it be to
have promos? The owners are willing to go for it, but they are interested in promoting some channels, not all of them. And... those promoted are the
[`takeaway`](src/main/java/channels/Takeaway.java) and the [`web`](src/main/java/channels/Web.java), not in the same inheritance
hierarchy line. No problem! We can declare [`Promoted`](src/main/java/channels/Promoted.java) as an interface in which every
promoted channel will be able to check if its offer is active and to tell the promo:

```java
interface Promoted {

    boolean isPromoActive();

    String announcePromo();
}

````

The most interesting details of these example come next. If we are going to be good developers –and we are, for sure–, we have to be organized
and don't mess our code. If you think about this scenario in real life, people who deliver the orders don't have to know about the
promos, as well as people who manage one channel doesn't have to know about the others. In every business, an internal change
in any area/department should not affect the other ones.

Back to our code, you can
see we have an  [`Order`](src/main/java/management/Order.java) class. Its responsibility is just to process the orders and keep a counter updated.
Of course, this class has a dependency with a [`Channel`](src/main/java/channels/Channel.java), but whichever the
concrete implementation is, it is capable of running the order, giving the global order number and the specific order for that channel.
But... it doesn't know how many channels there are or even their names! We can find a similar behaviour
in [`Channel`](src/main/java/channels/Channel.java)
class: we know [`promoted`](src/main/java/channels/Promoted.java) channels exist, but we don't know and don't care
which ones are. When the time comes for us to `attend` the order, we just call a method that let those channels «do their thing»,
and then we go back to the common procedure for every channel:

```java
public abstract class Channel {

    public String attend(int globalOrderId, int channelOrderId) {
        return this.welcome(globalOrderId, channelOrderId)
                + this.announceChannelPromo() // Here we add the promos' info.
                + this.serveClient();
    }

    // Other methods

    private String announceChannelPromo() { // We let promoted channels check availability and tell their promos.
        return this instanceof Promoted promoted && promoted.isPromoActive() ?
                String.format("%n%s%n", promoted.announcePromo()) : StringUtils.EMPTY;
    }
}

````

So, wrapping up: notice that this code complies with the Open/Closed principle. If we want to add any
new [`channel`](src/main/java/channels/Channel.java),
promoted or not, or modify the existing ones about their particular required data or their promos, we don't need to change
the already existing code in [`Order`](src/main/java/management/Order.java) or [`Channel`](src/main/java/channels/Channel.java)
classes, least of all the other channel inheritors. Also, the fact that an order always receives a reference to
the channel in the constructor –injected dependency– makes it possible to standardize the logic of processing
every order whichever channel it came from. This is a sign of well planned structured and low coupled code.

#### Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).
- Use of **icu4j** library to generate ordinals in text may be of interest.