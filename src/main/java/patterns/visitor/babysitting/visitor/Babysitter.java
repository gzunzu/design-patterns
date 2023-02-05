package patterns.visitor.babysitting.visitor;

import patterns.visitor.babysitting.visitable.Baby;
import patterns.visitor.babysitting.visitable.Preschooler;
import patterns.visitor.babysitting.visitable.Toddler;

public class Babysitter implements Visitor {

    @Override
    public void visit(Baby baby) {
        System.out.println(baby.toString() + "\n[BABYSITTER] El bebé llora. Lo acunaré.");
        baby.cradle();
    }

    @Override
    public void visit(Toddler toddler) {
        System.out.println(toddler.toString() + "\n[BABYSITTER] Al bebé le duelen los dientes. Le daré un chupete.");
        toddler.suckPacifier();
    }

    @Override
    public void visit(Preschooler preschooler) {
        System.out.println(preschooler.toString() + "\n[BABYSITTER] Parece que " + preschooler.getGenderReference()
                + " se aburre. Le daré un juego.");
        preschooler.play();
    }
}