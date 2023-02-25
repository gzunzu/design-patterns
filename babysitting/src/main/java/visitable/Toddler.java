package visitable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.icu.text.RuleBasedNumberFormat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import utils.Gender;
import visitor.Visitor;

import java.util.Locale;

@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Toddler extends Child {

    @JsonProperty("teethCount")
    private int teethCount;

    public Toddler(String name, Gender gender, int teethCount) {
        super(name, gender);
        this.teethCount = teethCount;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String suckPacifier() {
        return this.name + " is calming down while sucking the pacifier.";
    }

    @Override
    public String toString() {
        RuleBasedNumberFormat formatter
                = new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);
        //noinspection SpellCheckingInspection
        return super.toString() + " " + StringUtils.capitalize(this.gender.getSubjectivePronoun())
                + " is a toddler and " + this.gender.getPossessivePronoun() + " "
                + formatter.format(this.teethCount, "%spellout-ordinal") + " tooth is coming out.";
    }
}