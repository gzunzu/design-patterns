package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.Helper;

public class GermanPatient extends Patient implements MetricUnitsUser {

    private final float KILOGRAMS;

    public GermanPatient(String name) {
        super(name, "alemán/a");
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