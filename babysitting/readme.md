## Babysitting \[Visitor pattern\]

Module **Babysitting** is a simple implementation of the Visitor pattern, which allow
us to add new operations to an existing object without modifying or even knowing about
the already implemented ones.

In this example we have the class Babysitter as a Visitor. The Visitor interface has an
overloaded **visit** method with different param types. In their implementation, they
should have different behaviours based on the type of object given as argument. Back to
our example, we can guess that our babysitter should not attend the same way a newborn
baby, a toddler or a preschooler.

So, each one of the implementations of **visit** method gets a different type of object
and that is what allows our babysitter to take care of each type of child in different ways.
Also, every type of child must implement the **Visitable** interface. This is because all this
types must have their own **accept** method, whose implementation is always the same
in every type: they call the Visitor **visit** method, passing its own instance as param (this):

```
 @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
```

At this point, you can see that implementations of **Visitable** are completely isolated from each
other. In this example, they all inherit from a Child class, but realize that this is unnecessary and not
referred from the Visitable class in any way. Also, the different operations Visitor implementation
have for each Visitable are independent of each other. If we want to add another operation for
teenagers, we just have to create the class Teenager as a Visitable, adding the code mentioned
above and add a new declaration of the **visit** method in the **Visitor** interface receiving
a Teenager as param, which will force as to generate its implementation in Babysitter.