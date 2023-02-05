package patterns.adapter.nutritionist;


import patterns.adapter.nutritionist.patient.ImperialUnitsUser;
import patterns.adapter.nutritionist.patient.MetricUnitsUser;
import patterns.adapter.nutritionist.patient.Patient;
import patterns.adapter.nutritionist.patient.PatientFactory;

class Clinic {

    private final Nutritionist NUTRITIONIST = new Nutritionist();

    private void getNewPatient(Patient patient) {
        System.out.println("[Recepcionista] ¡Siguiente! Adelante, " + patient.getNAME() + ".");
        System.out.println(patient.getIntroduction());
        this.acceptPatient(patient);
        System.out.println(this.NUTRITIONIST.getPatientWeight() + "\n");
    }

    private void acceptPatient(Patient patient) {
        if (patient instanceof ImperialUnitsUser) {
            this.admitPatient((ImperialUnitsUser) patient);
        } else if (patient instanceof MetricUnitsUser) {
            this.admitPatient((MetricUnitsUser) patient);
        }
    }

    private void admitPatient(ImperialUnitsUser patient) {
        this.NUTRITIONIST.setPatient(patient);
    }

    private void admitPatient(MetricUnitsUser patient) {
        this.NUTRITIONIST.setPatient(new MetricUsersAdapter(patient));
    }

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.getNewPatient(PatientFactory.getPatient("Mara", "gb"));
        clinic.getNewPatient(PatientFactory.getPatient("Carlo", "it"));
        clinic.getNewPatient(PatientFactory.getPatient("Astrid", "de"));
        clinic.getNewPatient(PatientFactory.getPatient("Robert", "au"));
    }
}