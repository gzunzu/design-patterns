package nutritionist.patient;

import nutritionist.ext.Helper;

public class AustralianPatient extends Patient implements ImperialUnitsUser {
    
    private final float POUNDS;
    
    public AustralianPatient(String name) {
        super(name, "australiana/o");
        this.POUNDS = Helper.getRandomKilogramsWeight();
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