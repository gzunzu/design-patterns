package temporal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
abstract class Baby {

    private final Gender gender;

    private final String name;

    @Override
    public String toString() {
        return this.name + " es " + this.gender.getAlias();
    }

    abstract String pee();
}