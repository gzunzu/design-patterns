package clinic;

import lombok.Setter;
import patient.ImperialUnitsUser;

import java.util.Objects;

/**
 * Suponemos que el nutricionista solo tiene preparadas sus herramientas para trabajar con
 * unidades de medida del sistema inglés, también conocido como imperial.
 */
@Setter
class Nutritionist {

    private ImperialUnitsUser patient;

    public String measureWeight() {
        if (Objects.isNull(this.patient)) {
            return "[NUTRITIONIST] I'm available for a new patient. Receptionist, please move on to the next one.";
        } else {
            return "[NUTRITIONIST] Your weight is " + String.format("%.2f", this.patient.getWeightInPounds()) + " pounds.";
        }
    }
}