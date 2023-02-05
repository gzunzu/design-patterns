package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.RandomWeightHelper;

public class AustralianPatient extends Patient implements ImperialUnitsUser {

    private final float pounds;

    public AustralianPatient(String name) {
        super(name, "australiana/o");
        this.pounds = RandomWeightHelper.KILOGRAMS.getWeight();
    }

    @Override
    public float getWeightInPounds() {
        return this.pounds;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.pounds) + " libras";
    }
}