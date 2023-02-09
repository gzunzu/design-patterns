package patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neovisionaries.i18n.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import utils.Salute;

@AllArgsConstructor
@Data
public abstract class Patient {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("citizenship")
    private final CountryCode citizenship;

    public String getIntroduction() {
        return "[PATIENT] " + Salute.random().getText()
                + ". My name is " + this.name + ", I'm from " + this.citizenship.getName()
                + " and my weight might be around " + this.getWeightAndUnit() + ".";
    }

    public abstract String getWeightAndUnit();
}