package visitable;

import lombok.AllArgsConstructor;
import utils.Gender;

@AllArgsConstructor
public abstract class Child implements Visitable {

    protected final String name;

    protected final Gender gender;

    public String getPronoun() {
        return this.gender.getPronoun();
    }

    public String getPossessivePronoun() {
        return this.gender.getPossessivePronoun();
    }

    public String getThirdPronoun() {
        return this.gender.getThirdPronoun();
    }

    @Override
    public String toString() {
        return this.name + " is a " + this.gender.getName() + ".";
    }
}