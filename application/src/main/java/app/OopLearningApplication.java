package app;

import lombok.extern.slf4j.Slf4j;
import utils.Gender;
import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;
import visitor.Babysitter;

import java.util.Random;

@Slf4j
public class OopLearningApplication {

    private static void executeBabysittingExample() {
        log.info("\n---An example execution of the Babysitter module code---\n ");
        final Babysitter BABYSITTER = new Babysitter();
        BABYSITTER.admit(
                new Baby("Emma", Gender.FEMALE, new Random().nextInt(15 - 1) + 1),
                new Toddler("Victor", Gender.MALE, new Random().nextInt(20 - 1) + 1),
                new Preschooler("Dan", Gender.NON_BINARY, (new Random().nextInt(10 - 1) + 1) * 10),
                new Dog("Toby", true)
        );
        log.info(BABYSITTER.takeCare());
        BABYSITTER.finishWork();
    }

    public static void main(String[] args) {
        executeBabysittingExample();
    }
}
