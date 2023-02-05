package patterns.visitor.babysitting;

import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitable.Baby;
import patterns.visitor.babysitting.visitable.Child;
import patterns.visitor.babysitting.visitable.Preschooler;
import patterns.visitor.babysitting.visitable.Toddler;
import patterns.visitor.babysitting.visitor.Babysitter;

import java.util.ArrayList;
import java.util.Collections;

class Childcare {

    private final Babysitter BABYSITTER = new Babysitter();
    private final ArrayList<Child> CHILDREN = new ArrayList<>();

    void addChildren(Child... children) {
        Collections.addAll(this.CHILDREN, children);
    }

    void takeCare() {
        this.CHILDREN.forEach((child) -> child.accept(this.BABYSITTER));
    }

    public static void main(String[] args) {
        Childcare childcare = new Childcare();
        childcare.addChildren(
                new Baby("Emma", Gender.FEMALE, 3),
                new Toddler("Víctor", Gender.MALE, 8),
                new Preschooler("Paula", Gender.FEMALE, 100)
        );
        childcare.takeCare();
    }
}