package patient.impl;


import com.neovisionaries.i18n.CountryCode;
import patient.ImperialUnitsUser;
import patient.Patient;
import utils.RandomWeightHelper;

public class AustralianPatient extends Patient implements ImperialUnitsUser {

    private final float pounds;

    public AustralianPatient(String name) {
        super(name, CountryCode.AU);
        this.pounds = RandomWeightHelper.POUNDS.getWeight();
    }

    @Override
    public float getWeightInPounds() {
        return this.pounds;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.pounds) + " pounds";
    }
}