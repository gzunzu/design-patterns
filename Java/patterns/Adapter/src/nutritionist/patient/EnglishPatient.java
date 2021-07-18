package nutritionist.patient;

import nutritionist.ext.Helper;

public class EnglishPatient extends Patient implements ImperialUnitsUser {

    private final float POUNDS;

    public EnglishPatient(String name) {
        super(name, "inglés/a");
        this.POUNDS = Helper.getRandomPoundsWeight();
    }

    @Override
    public float getWeigthInPounds() {
        return this.POUNDS;
    }

    @Override
    public String getWeightAndUnit() {
        return String.format("%.2f", this.POUNDS) + " libras";
    }
}