package patient.impl;

import com.neovisionaries.i18n.CountryCode;
import patient.MetricUnitsUser;
import patient.Patient;
import utils.RandomWeightHelper;

public class ItalianPatient extends Patient implements MetricUnitsUser {

    private final float kilograms;

    public ItalianPatient(String name) {
        super(name, CountryCode.IT);
        this.kilograms = RandomWeightHelper.KILOGRAMS.getWeight();
    }

    @Override
    public float getWeightInKilograms() {
        return this.kilograms;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.kilograms) + " kilograms";
    }
}