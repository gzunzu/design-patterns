package visitable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.Gender;

@AllArgsConstructor
@Getter
public abstract class Child implements Visitable {

    protected final String name;

    protected final Gender gender;

    @Override
    public String toString() {
        return this.name + " is a " + this.gender.getName() + ".";
    }
}