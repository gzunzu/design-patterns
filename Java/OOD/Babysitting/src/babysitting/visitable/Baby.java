package babysitting.visitable;

import babysitting.ext.Sex;
import babysitting.visitor.Visitor;

public class Baby extends Child {
    
    private final int WEEKS;

    public Baby(String name, Sex sex, int weeks) {
        super(name, sex);
        this.WEEKS = weeks;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public void cradle() {
        System.out.println("A " + this.NAME + " le encanta que l" + this.SEX.LETTER + " acunen.");
    }

    @Override
    public String toString() {
        return super.toString() + " recién nacid" + this.SEX.LETTER +  ". Solo tiene " + this.WEEKS + " semanas.";
    }
}