package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitor.Visitor;

public class Preschooler extends Child {

    private final int NUMBERS_KNOWN;

    public Preschooler(String name, Gender gender, int numbersKnown) {
        super(name, gender);
        this.NUMBERS_KNOWN = numbersKnown;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void play() {
        System.out.println(this.NAME + " se divierte jugando.");
    }

    @Override
    public String toString() {
        return super.toString() + " de preescolar y ya sabe contar hasta " + this.NUMBERS_KNOWN + ".";
    }
}