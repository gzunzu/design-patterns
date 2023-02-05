package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitor.Visitor;

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
        System.out.println("A " + this.name + " le encanta que l" + this.gender.letter + " acunen.");
    }

    @Override
    public String toString() {
        return super.toString() + " recién nacid" + this.gender.letter + ". Solo tiene " + this.weeks + " semanas.";
    }
}