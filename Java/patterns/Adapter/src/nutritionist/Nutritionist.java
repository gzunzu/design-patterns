package nutritionist;

import nutritionist.patient.ImperialUnitsUser;

/**
 * Suponemos que el nutricionista solo tiene preparadas sus herramientas para trabajar con 
 * unidades de medida del sistema inglés, también conocido como imperial.
 */
class Nutritionist {
    
    private ImperialUnitsUser patient;

    public void setPatient(ImperialUnitsUser patient) {
        this.patient = patient;
    }
    
    public String getPatientWeight() {
        if (this.patient == null) {
            return "[Nutricionista] No tengo un paciente en la consulta. Recepcionista, haz pasar a algún paciente.";
        } else {
            return "[Nutricionista] Efectivamente, pesas " + String.format("%.2f", this.patient.getWeigthInPounds()) + " libras.";
        }
    }
}