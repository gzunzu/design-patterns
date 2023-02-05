package patterns.adapter.nutritionist.patient;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Patient {

    private final String name;
    private final String citizenship;

    @Override
    public String toString() {
        return this.name;
    }

    public String getIntroduction() {
        return "[Paciente] Me llamo " + this.name + ", soy " + this.citizenship + " y peso " + this.getWeightAndUnit() + ".";
    }

    public abstract String getWeightAndUnit();
}