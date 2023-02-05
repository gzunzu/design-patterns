package patterns.adapter.nutritionist.patient;


import patterns.adapter.nutritionist.ext.Helper;

public class EnglishPatient extends Patient implements ImperialUnitsUser {

    private final float pounds;

    public EnglishPatient(String name) {
        super(name, "inglés/a");
        this.pounds = Helper.getRandomPoundsWeight();
    }

    @Override
    public float getWeigthInPounds() {
        return this.pounds;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.pounds) + " libras";
    }
}