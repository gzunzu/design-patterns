package patient;

public class PatientFactory {

    public static Patient getPatient(String name, String countryCode) {
        return switch (countryCode.toLowerCase()) {
            case "gb", "gbr" -> new EnglishPatient(name);
            case "de", "deu" -> new GermanPatient(name);
            case "au", "aus" -> new AustralianPatient(name);
            case "it", "ita" -> new ItalianPatient(name);
            default -> null;
        };
    }
}