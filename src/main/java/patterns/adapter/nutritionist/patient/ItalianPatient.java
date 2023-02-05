package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.RandomWeightHelper;

public class ItalianPatient extends Patient implements MetricUnitsUser {

    private final float kilograms;

    public ItalianPatient(String name) {
        super(name, "italiano/a");
        this.kilograms = RandomWeightHelper.KILOGRAMS.getWeight();
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