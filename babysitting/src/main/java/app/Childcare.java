package app;


import utils.Gender;
import visitable.Baby;
import visitable.Child;
import visitable.Preschooler;
import visitable.Toddler;
import visitor.Babysitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Childcare {

    private final Babysitter babysitter = new Babysitter();
    private final ArrayList<Child> children = new ArrayList<>();

    public static void main(String[] args) {
        Childcare childcare = new Childcare();
        childcare.addChildren(
                new Baby("Emma", Gender.FEMALE, new Random().nextInt(15 - 1) + 1),
                new Toddler("Victor", Gender.MALE, new Random().nextInt(20 - 1) + 1),
                new Preschooler("Paula", Gender.FEMALE, (new Random().nextInt(10 - 1) + 1) * 10)
        );
        childcare.takeCare();
    }

    void addChildren(Child... children) {
        Collections.addAll(this.children, children);
    }

    void takeCare() {
        this.children.forEach(child -> child.accept(this.babysitter));
    }
}