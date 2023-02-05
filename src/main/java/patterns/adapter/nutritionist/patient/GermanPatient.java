package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.Helper;

public class GermanPatient extends Patient implements MetricUnitsUser {

    private final float kilograms;

    public GermanPatient(String name) {
        super(name, "alemán/a");
        this.kilograms = Helper.getRandomKilogramsWeight();
    }

    @Override
    public float getWeightInKilograms() {
        return this.kilograms;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.kilograms) + " kilos";
    }
}