## Babysitting \[Visitor pattern\]

#### Description

Module **Babysitting** is a simple implementation of the Visitor pattern, which allows
us to add new operations to an existing object without modifying or even knowing about
the already implemented ones.

In this example we have the class [`Babysitter`](src/main/java/visitor/Babysitter.java) as
a [`Visitor`](src/main/java/visitor/Visitor.java). The Visitor interface has an
overloaded `visit` method with different param types. In their implementation, they
should have different behaviours based on the type of object given as argument. Back to
our example, we can guess that our babysitter should not attend the same way a newborn
baby and a preschooler.

```
public class Babysitter implements Visitor {
    
    // Previous attributes and methods.

    @Override
    public String visit(Baby baby) {
        // Actions to do for taking care of a baby.
    }
    
    @Override
    public String visit(Preschooler preschooler) {
        // Actions to do for taking care of a preschooler.
    }
}
```

So, each one of the implementations of `visit` method gets a different type of object
and that is what allows our babysitter to take care of them in different ways.
Also, every type of object we want the [`Visitor`](src/main/java/visitor/Visitor.java) –Babysitter–
to take care of must implement the [`Visitable`](src/main/java/visitable/Visitable.java) interface.
This is because all these types must have their own `accept` method, whose implementation is always the same
whichever their class is: they receive a [`Visitor`](src/main/java/visitor/Visitor.java) instance as argument,
and they use it to invoke the `visit` method passing its own instance as param (`this`):

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
for the `accept` method, but apart from that similarity they are **isolated from each other**, and they
could be completely different, in fact. You may be thinking: _«Oh! Why not create a parent abstract class,
such as [`Child`](src/main/java/visitable/Child.java), for the [`Visitable`](src/main/java/visitable/Visitable.java) classes,
and declarate there an `accept` method, which is indeed the same for all the inheritors?»_. Then, how would you differ
the actions to take from the [`Visitor`](src/main/java/visitor/Visitor.java) class? Well, you could still use the same
structure, creating an overloaded method with a different param, one for each [`Child`](src/main/java/visitable/Child.java)
inheritor, right? OK, this could be a solution. Is it the best one? Probably not. Why is it so much better to use an Interface?
First of all, let's examine this example closely: does every implementation of [`Visitable`](src/main/java/visitable/Visitable.java)
inherit from [`Child`](src/main/java/visitable/Child.java) class? No! Luckily, our babysitter is also able to take care of any
[`Dog`](src/main/java/visitable/Dog.java). And we know dogs doesn't have much in common with children, so
they cannot have the same parent class. Always remember Java doesn't support multiple inheritance relations.

Another nice advantage is that you could modify the `accept` method implementation for each specific class.
Imagine we want to evaluate any private access status of the [`Visitable`](src/main/java/visitable/Visitable.java)
implementation before «accepting» the [`Visitor`](src/main/java/visitor/Visitor.java). Being private, the
[`Visitor`](src/main/java/visitor/Visitor.java) can not check it before invoking the `visit` method, so  
the [`Visitable`](src/main/java/visitable/Visitable.java) implementation will be in charge of evaluating its own
requirements to call back `Visitor.visit(this)` or not.

Also, using an Interface, since you add `implements Visitable` in the[`Visitable`](src/main/java/visitable/Visitable.java)
concrete class, you are forced to add the implementation of the `accept` method, that will claim for the declaration of `visit` method
on the [`Visitor`](src/main/java/visitor/Visitor.java) interface, and then you'll have to develop it over every implementation.
So, somehow, having this structure, with the first action we are triggering every necessary step to complete the puzzle
of this solution. It's not just easy, it's secure for us to not forget any fragment of code and, above all, it is a perfect example
of the Open/Closed SOLID principle. The code is easily expandable for adding operations with new
[`Visitable`](src/main/java/visitable/Visitable.java) classes.

Indeed, another possible scenario could be to amplify the example by adding an operation for
teenagers. How do yu feel about it? Go try!

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