package visitor;

import lombok.Data;
import visitable.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class Babysitter implements Visitor {

    private final ArrayList<Visitable> visitables;

    public Babysitter() {
        this.visitables = new ArrayList<>();
    }

    public <T extends Visitable> void admit(List<T> visitables) {
        this.visitables.addAll(visitables);
    }

    public <T extends Visitable> void admit(T... visitables) {
        Collections.addAll(this.visitables, visitables);
    }

    public void reject(Visitable... visitables) {
        this.visitables.removeAll(Arrays.asList(visitables));
    }

    public void shuffle() {
        Collections.shuffle(this.visitables);
    }

    public void finishWork() {
        this.visitables.clear();
    }

    public String takeCare() {
        String result = "\n";
        for (Visitable visitable : visitables) {
            result += visitable.accept(this);
        }
        return result;
    }

    @Override
    public String visit(Baby baby) {
        return baby.toString()
                + "\n[BABYSITTER] The baby is crying. I'll cradle "
                + baby.getGender().getObjectivePronoun() + ".\n"
                + baby.cradle()
                + "\n";
    }

    @Override
    public String visit(Toddler toddler) {
        return toddler.toString()
                + "\n[BABYSITTER] The toddler teeth hurt. I'll give "
                + toddler.getGender().getObjectivePronoun() + " a pacifier.\n"
                + toddler.suckPacifier()
                + "\n";
    }

    @Override
    public String visit(Preschooler preschooler) {
        return preschooler.toString()
                + "\n[BABYSITTER] The preschooler is bored. I'll bring "
                + preschooler.getGender().getObjectivePronoun() + " a game.\n"
                + preschooler.play()
                + "\n";
    }

    @Override
    public String visit(Dog dog) {
        String result = dog.toString()
                + "\n[BABYSITTER] The dog is ";

        if (dog.isClean()) {
            result += "clean. Let's go for a walk.\n" + dog.walk();
        } else {
            result += "dirty. Let's have a bath.\n";
            dog.bath();
            result += dog.bark();
        }

        return result + "\n";
    }
}