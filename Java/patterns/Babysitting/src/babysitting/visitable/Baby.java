package babysitting.visitable;

import babysitting.ext.Gender;
import babysitting.visitor.Visitor;

public class Baby extends Child {
    
    private final int WEEKS;

    public Baby(String name, Gender gender, int weeks) {
        super(name, gender);
        this.WEEKS = weeks;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public void cradle() {
        System.out.println("A " + this.NAME + " le encanta que l" + this.GENDER.LETTER + " acunen.");
    }

    @Override
    public String toString() {
        return super.toString() + " recién nacid" + this.GENDER.LETTER +  ". Solo tiene " + this.WEEKS + " semanas.";
    }
}