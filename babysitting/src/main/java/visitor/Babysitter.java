package visitor;

import visitable.Baby;
import visitable.Preschooler;
import visitable.Toddler;

public class Babysitter implements Visitor {

    @Override
    public void visit(Baby baby) {
        System.out.println(baby.toString()
                + "\n[BABYSITTER] The baby is crying. I'll cradle " + baby.getThirdPronoun() + ".");
        baby.cradle();
    }

    @Override
    public void visit(Toddler toddler) {
        System.out.println(toddler.toString()
                + "\n[BABYSITTER] The toddler teeth hurt. I'll give " + toddler.getThirdPronoun() + " a pacifier.");
        toddler.suckPacifier();
    }

    @Override
    public void visit(Preschooler preschooler) {
        System.out.println(preschooler.toString()
                + "\n[BABYSITTER] The preschooler is bored. I'll bring " + preschooler.getThirdPronoun() + " a game.");
        preschooler.play();
    }
}