package visitor;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SystemUtils;
import visitable.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
@Data
public class Babysitter implements Visitor {

    private final ArrayList<Visitable> visitables;

    public Babysitter() {
        this.visitables = new ArrayList<>();
    }

    public <T extends Visitable> void admit(List<T> visitables) {
        if (CollectionUtils.isNotEmpty(visitables)) {
            this.visitables.addAll(visitables);
        }
    }

    public void admit(Visitable... visitables) {
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
        StringBuilder result = new StringBuilder(SystemUtils.LINE_SEPARATOR);
        for (Visitable visitable : visitables) {
            result.append(visitable.accept(this))
                    .append(SystemUtils.LINE_SEPARATOR);
        }
        return result.toString();
    }

    @Override
    public String visit(Baby baby) {
        return String.format("%s%n[BABYSITTER] The baby is crying. I'll cradle %s.%n%s%n",
                baby.toString(),
                baby.getGender().getObjectivePronoun(),
                baby.cradle());
    }

    @Override
    public String visit(Toddler toddler) {
        return String.format("%s%n[BABYSITTER] The toddler teeth hurt. I'll give %s a pacifier.%n%s%n",
                toddler.toString(),
                toddler.getGender().getObjectivePronoun(),
                toddler.suckPacifier());
    }

    @Override
    public String visit(Preschooler preschooler) {
        return String.format("%s%n[BABYSITTER] The preschooler is bored. I'll bring %s a game.%n%s%n",
                preschooler.toString(),
                preschooler.getGender().getObjectivePronoun(),
                preschooler.play());
    }

    @Override
    public String visit(Dog dog) {
        StringBuilder result = new StringBuilder(dog.toString())
                .append(SystemUtils.LINE_SEPARATOR)
                .append("[BABYSITTER] The dog is ");

        if (dog.isClean()) {
            result.append(String.format("clean. Let's go for a walk.%n%s", dog.walk()));
        } else {
            dog.bath();
            result.append(String.format("dirty. Let's have a bath.%n%s", dog.bark()));
        }

        return result
                .append(SystemUtils.LINE_SEPARATOR)
                .toString();
    }
}