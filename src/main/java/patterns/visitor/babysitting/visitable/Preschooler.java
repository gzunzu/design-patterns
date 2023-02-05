package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitor.Visitor;

public class Preschooler extends Child {

    private final int numbersKnown;

    public Preschooler(String name, Gender gender, int numbersKnown) {
        super(name, gender);
        this.numbersKnown = numbersKnown;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void play() {
        System.out.println(this.name + " se divierte jugando.");
    }

    @Override
    public String toString() {
        return super.toString() + " de preescolar y ya sabe contar hasta " + this.numbersKnown + ".";
    }
}