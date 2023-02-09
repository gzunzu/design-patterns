package patient.impl;

import com.neovisionaries.i18n.CountryCode;
import patient.MetricUnitsUser;
import patient.Patient;
import utils.RandomWeightHelper;

public class GermanPatient extends Patient implements MetricUnitsUser {

    private final float kilograms;

    public GermanPatient(String name) {
        super(name, CountryCode.DE);
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