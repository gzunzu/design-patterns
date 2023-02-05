package patterns.adapter.nutritionist;


import lombok.Setter;
import patterns.adapter.nutritionist.patient.ImperialUnitsUser;

/**
 * Suponemos que el nutricionista solo tiene preparadas sus herramientas para trabajar con
 * unidades de medida del sistema inglés, también conocido como imperial.
 */
@Setter
class Nutritionist {

    private ImperialUnitsUser patient;

    public String getPatientWeight() {
        if (this.patient == null) {
            return "[Nutricionista] No tengo un paciente en la consulta. Recepcionista, haz pasar a algún paciente.";
        } else {
            return "[Nutricionista] Efectivamente, pesas " + String.format("%.2f", this.patient.getWeightInPounds()) + " libras.";
        }
    }
}