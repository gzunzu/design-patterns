package visitable;

import org.apache.commons.lang3.StringUtils;
import utils.Gender;
import visitor.Visitor;

public class Baby extends Child {

    private final int weeks;

    public Baby(String name, Gender gender, int weeks) {
        super(name, gender);
        this.weeks = weeks;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void cradle() {
        System.out.println(this.name + " loves being cradled.");
    }

    @Override
    public String toString() {
        return super.toString() + " " + StringUtils.capitalize(this.getPronoun())
                + " is just a(n) " + this.weeks + " weeks old newborn.";
    }
}