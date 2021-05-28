package babysitting.visitable;

import babysitting.ext.Sex;
import babysitting.visitor.Visitor;

public class Preschooler extends Child {
    
    private final int NUMBERS_KNOWN;

    public Preschooler(String name, Sex sex, int numbersKnown) {
        super(name, sex);
        this.NUMBERS_KNOWN = numbersKnown;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public void play() {
        System.out.println(this.NAME + " disfruta jugando.");
    }

    @Override
    public String toString() {
        return super.toString() + " de preescolar y ya sabe contar hasta " + this.NUMBERS_KNOWN + ".";
    }
}