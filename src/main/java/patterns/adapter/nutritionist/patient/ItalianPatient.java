package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.Helper;

public class ItalianPatient extends Patient implements MetricUnitsUser {

    private final float kilograms;

    public ItalianPatient(String name) {
        super(name, "italiano/a");
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