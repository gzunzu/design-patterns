package babysitting.visitable;

import babysitting.ext.Gender;
import babysitting.visitor.Visitor;

public class Toddler extends Child {
    
    private final int TEETH_COUNT;

    public Toddler(String name, Gender gender, int teethCount) {
        super(name, gender);
        this.TEETH_COUNT = teethCount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public void suckPacifier() {
        System.out.println("A " + this.NAME + " le calma el chupete.");
    }

    @Override
    public String toString() {
        return super.toString() + " y le está saliendo su " + (this.TEETH_COUNT + 1) + ".º diente.";
    }
}