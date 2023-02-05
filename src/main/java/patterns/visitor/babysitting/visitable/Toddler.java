package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitor.Visitor;

public class Toddler extends Child {

    private final int teethCount;

    public Toddler(String name, Gender gender, int teethCount) {
        super(name, gender);
        this.teethCount = teethCount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void suckPacifier() {
        System.out.println("A " + this.name + " le calma el chupete.");
    }

    @Override
    public String toString() {
        return super.toString() + " y le está saliendo su " + (this.teethCount + 1) + ".º diente.";
    }
}