package visitable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import utils.Gender;
import visitor.Visitor;

@NoArgsConstructor
@Data
public class Preschooler extends Child {

    @JsonProperty("numbersKnown")
    private int numbersKnown;

    public Preschooler(String name, Gender gender, int numbersKnown) {
        super(name, gender);
        this.numbersKnown = numbersKnown;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String play() {
        return this.name + " is now having fun playing.";
    }

    @Override
    public String toString() {
        return super.toString() + " " + StringUtils.capitalize(this.gender.getSubjectivePronoun())
                + " is a preschooler who already knows how to count up to " + this.numbersKnown + ".";
    }
}