package patterns.adapter.nutritionist.patient;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Patient {

    private final String NAME;
    private String citizenship;

    @Override
    public String toString() {
        return this.NAME;
    }

    public String getIntroduction() {
        return "[Paciente] Me llamo " + this.NAME + ", soy " + this.citizenship + " y peso " + this.getWeightAndUnit() + ".";
    }

    public abstract String getWeightAndUnit();
}