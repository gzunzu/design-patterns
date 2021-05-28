package babysitting.visitor;

import babysitting.visitable.Baby;
import babysitting.visitable.Preschooler;
import babysitting.visitable.Toddler;

public class Babysitter implements Visitor {

    @Override
    public void visit(Baby baby) {
        System.out.println(baby.toString() + "\n[BABYSITTER] El bebé llora. Lo acunaré.");
        baby.cradle();
    }

    @Override
    public void visit(Toddler toddler) {
        System.out.println(toddler.toString() + "\n[BABYSITTER] Al bebé le duelen los dientes. Le daré el chupete.");
        toddler.suckPacifier();
    }

    @Override
    public void visit(Preschooler preescholer) {
        System.out.println(preescholer.toString() + "\n[BABYSITTER] Parece que " + preescholer.getSEX().ARTICLE
                + " " + preescholer.getSEX().LETTER + " se aburre. Le daré un juego.");
        preescholer.play();
    }
}