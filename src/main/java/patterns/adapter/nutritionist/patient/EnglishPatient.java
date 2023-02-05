package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.RandomWeightHelper;

public class EnglishPatient extends Patient implements ImperialUnitsUser {

    private final float pounds;

    public EnglishPatient(String name) {
        super(name, "inglés/a");
        this.pounds = RandomWeightHelper.POUNDS.getWeight();
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