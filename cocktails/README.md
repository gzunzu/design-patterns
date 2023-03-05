# Cocktails \[Template method\]

## Description

Cocktails module is an example of the Template method **behavioural pattern**. It is based on the use of
abstract classes and methods, so its technical level lacks of any difficulty, and it's very useful when
we need to alter the base algorithm of a method based on the specific instance we are handling. Let's take
a look at it.

Imagine we have a Bar where we are going to offer cocktails to our clients.
How many kinds of cocktails are served around the world? A L-O-T. And every cocktail
elaboration [`recipe`](src/main/java/business/Recipe.java)
has its particularities: some of them have ice, some are shaken, some are decorated with garnish, they may include alcohol or not...
Basically, it's almost an endless tree of ramifications. We cannot use the same guide –code– to serve every cocktail, because
it's not just a matter of different properties whose values could be modified under each specific cocktail; but also different
actions –methods– than should be invoked or not in each case.

But what if we could make a basic «template» considering every possible action, and let inheritors rewrite
that template to adjust to their specific needing? That's our solution here. We create an abstract [`Cocktail`](src/main/java/cocktail/Cocktail.java)
class with the common attributes for every drink, and we also declare as abstract methods the actions that could
require its making of. Eg: some cocktails are flamed after served to burn alcohol –pretty spectacular–, but
this is not always the case. Then, we should add the following code to the [`Cocktail`](src/main/java/cocktail/Cocktail.java) class:

````java
public abstract class Cocktail {
    // Other attributes and methods

    protected abstract boolean isFlamed(); // Implementation must be given in inheritor classes

    private String flame() {
        return this.isFlamed() ? "Don't call the firefighters! We are just flaming your drink!" : StringUtils.EMPTY;
    }
}
````

As you can see, by declaring the `isFlamed()` method as `abstract`, we are forcing inheritors to implement
that method. Then we can use the result of that method in `flame()` method to decide what to do, even «nothing». In
this case, we declare `flame()` as a private method because we assume that this action is implemented
the same way whichever the implementation is. But if we are not sure of that, or we wish to grant inheritors
the option of modifying, this is possible just by changing the access keyword to `protected`. Inheritors
will be able to overwrite the method as long as we don't add the `final` keyword. Therefore, we can pick between:

- `abstract` methods if we want to force inheritors to implement the action or give a returned value.
- `private` or `final` methods when we want to lock the implementation from inheritors to overwrite it.
- `protected` or `public` methods –not final– with a default implementation, but allowing inheritors to overwrite it.

So now we can write a generic code for serving every [`Cocktail`](src/main/java/cocktail/Cocktail.java),
allowing differences over the actions taken to make them just by using the combination of these method modifiers.
That's how we leave our template open for inheritors to specify their needs so they can modify
the base algorithm and introduce specific actions to the basic elaboration guide. After adding some
additional features, the `prepare()` method could end up somewhat like this:

````java
public abstract class Cocktail {
    // Other attributes and methods

    public final String prepare(String specialRequest) {
        return this.recipe.follow()
                .concat(this.isShaken() ? this.shake().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(StringUtils.isNotBlank(specialRequest) ? this.complySpecialRequest(specialRequest).concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(this.isServedWithAcrobatics() ? this.doAcrobatics().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(String.format("Now we pour your drink into a %s.%n", this.vessel.getName()))
                .concat(this.isFlamed() ? this.flame().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(this.wannaTellJokeAfterServing() ? this.tellJoke().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY);
    }
}
````

You can explore the code to see the open actions –methods– let for inheritors to implement. `getInfo()` method
also uses some values retrieved from abstract methods to add particular information about the cocktail, if any available.

## Subjects, technologies and contents

- Use of custom Assertj Condition for assertions in test classes could be of interest.