## Babysitting \[Visitor pattern\]

#### Explanation

Module **Babysitting** is a simple implementation of the Visitor pattern, which allow
us to add new operations to an existing object without modifying or even knowing about
the already implemented ones.

In this example we have the class [`Babysitter`](src/main/java/visitor/Babysitter.java) as
a [`Visitor`](src/main/java/visitor/Visitor.java). The Visitor interface has an
overloaded `visit` method with different param types. In their implementation, they
should have different behaviours based on the type of object given as argument. Back to
our example, we can guess that our babysitter should not attend the same way a newborn
baby, a toddler or a preschooler.

So, each one of the implementations of `visit` method gets a different type of object
and that is what allows our babysitter to take care of each type of child in different ways.
Also, every type of child must implement the [`Visitable`](src/main/java/visitable/Visitable.java) interface.
This is because all these types must have their own `accept` method, whose implementation is always the same
whichever their class is: they receive a [`Visitor`](src/main/java/visitor/Visitor.java) instance as argument,
and they use it to invoke the `visit` method and passing its own instance as param (`this`):

```
class AnyClass implements Visitable {

    // Attributes and other methods declarations.

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
```

At this point, you can see that **implementations of Visitable** have the same implementation
for the `accept` method, but apart from that they are **isolated from each other**, and they could be completely different.
In this example, they all inherit from a Child [`Child`](src/main/java/visitable/Child.java) class, but keep in mind that this is unnecessary and not
referred from the Visitable class in any way, it's just for giving a common context to the example.
We could have a Dog class implementing the [`Visitable`](src/main/java/visitable/Visitable.java) interface.
Just keep in mind that in that case, your Babysitter would be forced to take care of animals, because
she'd be required to have an implementation the `visit(Dog dog)` method as long as you declare on
[`Visitor`](src/main/java/visitor/Visitor.java). Also, **Visitor
implementation operations** for each [`Visitable`](src/main/java/visitable/Visitable.java) implementation
**are independent of each other**.

Another possible scenario could be to amplify the example by adding an operation for
teenagers: we just have to create the class Teenager as a [`Visitable`](src/main/java/visitable/Visitable.java), adding on it the code mentioned
above, and then we write a new declaration of the visit method in the [`Visitor`](src/main/java/visitor/Visitor.java) interface receiving
a Teenager as param, which will force as to generate its implementation in Babysitter. You can try!

```
public interface Visitor {
    
    // Previous visit method declarations.

    String visit(Teenager teenager);
}
```

#### Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).
- Use of **icu4j** library to generate ordinals in text may be of interest.