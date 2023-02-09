package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import patient.Patient;
import patient.impl.AustralianPatient;
import patient.impl.EnglishPatient;
import patient.impl.GermanPatient;
import patient.impl.ItalianPatient;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class PatientFactory {

    public static Patient getPatient(String name, String countryISOcode) {
        countryISOcode = Objects.nonNull(countryISOcode) ? countryISOcode.toUpperCase() : StringUtils.EMPTY;

        return switch (countryISOcode) {
            case "AU", "AUS" -> new AustralianPatient(name);
            case "IT", "ITA" -> new ItalianPatient(name);
            case "DE", "DEU" -> new GermanPatient(name);
            default -> new EnglishPatient(name);
        };
    }
}