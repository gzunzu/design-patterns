package nutritionist.patient;

import nutritionist.patient.AustralianPatient;
import nutritionist.patient.EnglishPatient;
import nutritionist.patient.GermanPatient;
import nutritionist.patient.ItalianPatient;
import nutritionist.patient.Patient;

public class PatientFactory {

    public static Patient getPatient(String name, String countryCode) {
        switch(countryCode.toLowerCase()) {
            case "gb": case "gbr":
                return new EnglishPatient(name);
            case "de": case "deu":
                return new GermanPatient(name);
            case "au": case "aus":
                return new AustralianPatient(name);
            case "it": case "ita":
                return new ItalianPatient(name);
            default:
                return null;
        }
    }
}