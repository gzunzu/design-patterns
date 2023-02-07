package visitor;

import visitable.Baby;
import visitable.Preschooler;
import visitable.Toddler;

public class Babysitter implements Visitor {

    @Override
    public String visit(Baby baby) {
        return baby.toString()
                + "\n[BABYSITTER] The baby is crying. I'll cradle " + baby.getGender().getObjectivePronoun() + ".\n"
                + baby.cradle();
    }

    @Override
    public String visit(Toddler toddler) {
        return toddler.toString()
                + "\n[BABYSITTER] The toddler teeth hurt. I'll give " + toddler.getGender().getObjectivePronoun() + " a pacifier.\n"
                + toddler.suckPacifier();
    }

    @Override
    public String visit(Preschooler preschooler) {
        return preschooler.toString()
                + "\n[BABYSITTER] The preschooler is bored. I'll bring " + preschooler.getGender().getObjectivePronoun() + " a game.\n"
                + preschooler.play();
    }
}