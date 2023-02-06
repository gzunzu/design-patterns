package visitable;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.apache.commons.lang3.StringUtils;
import utils.Gender;
import visitor.Visitor;

import java.util.Locale;

public class Toddler extends Child {

    private final int teethCount;

    public Toddler(String name, Gender gender, int teethCount) {
        super(name, gender);
        this.teethCount = teethCount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void suckPacifier() {
        System.out.println(this.name + " is calming down while sucking the pacifier.");
    }

    @Override
    public String toString() {
        RuleBasedNumberFormat formatter
                = new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);
        return super.toString() + " " + StringUtils.capitalize(this.getPronoun())
                + " is a toddler and " + this.getPossessivePronoun() + " "
                + formatter.format(this.teethCount, "%spellout-ordinal") + " tooth is coming out.";
    }
}