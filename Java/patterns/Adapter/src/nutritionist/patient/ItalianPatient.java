package nutritionist.patient;

import nutritionist.ext.Helper;

public class ItalianPatient extends Patient implements MetricUnitsUser {

    private final float KILOGRAMS;
    
    public ItalianPatient(String name) {
        super(name, "italiano/a");
        this.KILOGRAMS = Helper.getRandomKilogramsWeight();
    }

    @Override
    public float getWeightInKilograms() {
        return this.KILOGRAMS;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.KILOGRAMS) + " kilos";
    }
}