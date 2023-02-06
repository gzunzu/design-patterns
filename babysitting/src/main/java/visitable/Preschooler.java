package visitable;

import org.apache.commons.lang3.StringUtils;
import utils.Gender;
import visitor.Visitor;

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
        System.out.println(this.name + " is now having fun playing.");
    }

    @Override
    public String toString() {
        return super.toString() + " " + StringUtils.capitalize(this.getPronoun())
                + " is a preschooler who already knows how to count up to " + this.numbersKnown + ".";
    }
}