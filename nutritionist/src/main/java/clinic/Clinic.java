package clinic;


import adapter.MetricUserAdapter;
import patient.ImperialUnitsUser;
import patient.MetricUnitsUser;
import patient.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Clinic {

    private final Nutritionist nutritionist;

    private final List<Patient> patients;

    public Clinic() {
        this.nutritionist = new Nutritionist();
        this.patients = new ArrayList<>();
    }

    public <T extends Patient> void admit(List<T> patients) {
        this.patients.addAll(patients);
    }

    public <T extends Patient> void admit(T... patients) {
        Collections.addAll(this.patients, patients);
    }

    public void reject(Patient... patients) {
        this.patients.removeAll(Arrays.asList(patients));
    }

    public void shuffle() {
        Collections.shuffle(this.patients);
    }

    public void finishWork() {
        this.patients.clear();
    }

    public String seePatients() {
        String diagnosises = "\n";
        for (Patient patient : this.patients) {
            this.acceptPatient(patient);
            diagnosises += "[RECEPTIONIST] Next! Welcome to our clinic Tell me about you.\n"
                    + patient.getIntroduction() + "\n"
                    + this.nutritionist.measureWeight()
                    + "\n";
        }
        return diagnosises;
    }

    private void acceptPatient(Patient patient) {
        if (patient instanceof ImperialUnitsUser imperialUnitsUser) {
            this.nutritionist.setPatient(imperialUnitsUser);
        } else if (patient instanceof MetricUnitsUser metricUnitsUser) {
            this.nutritionist.setPatient(new MetricUserAdapter(metricUnitsUser));
        }
    }
}