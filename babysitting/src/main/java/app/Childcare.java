package app;


import lombok.extern.slf4j.Slf4j;
import utils.Gender;
import visitable.Baby;
import visitable.Child;
import visitable.Preschooler;
import visitable.Toddler;
import visitor.Babysitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Slf4j
class Childcare {

    private final Babysitter babysitter = new Babysitter();
    private final ArrayList<Child> children = new ArrayList<>();

    public static void main(String[] args) {
        Childcare childcare = new Childcare();
        childcare.addChildren(
                new Baby("Emma", Gender.FEMALE, new Random().nextInt(15 - 1) + 1),
                new Toddler("Victor", Gender.MALE, new Random().nextInt(20 - 1) + 1),
                new Preschooler("Dan", Gender.NON_BINARY, (new Random().nextInt(10 - 1) + 1) * 10)
        );
        childcare.takeCare();
    }

    void addChildren(Child... children) {
        Collections.addAll(this.children, children);
    }

    void takeCare() {
        this.children.forEach(child -> log.info(child.accept(this.babysitter)));
    }
}