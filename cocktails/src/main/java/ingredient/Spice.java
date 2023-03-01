package ingredient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Spice implements Ingredient {
    ANISE(true),
    BLACK_PEPPER(false),
    BROWN_SUGAR(true),
    CINNAMON(true),
    CORIANDER(false),
    CUMIN(false),
    PAPRIKA(false),
    SALT(false),
    WHITE_SUGAR(true);

    private final boolean hasAddedSugar;

    private static final float BASE_PRICE = 0.05f;

    private static final String MEASUREMENT_UNIT = "pinch";

    @Override
    public String getName() {
        return this.name().toLowerCase().replace("_", " ");
    }

    @Override
    public boolean hasAddedSugar() {
        return this.hasAddedSugar;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }

    @Override
    public float getCostPerUnit() {
        return BASE_PRICE;
    }

    @Override
    public String getMeasurementUnit() {
        return MEASUREMENT_UNIT;
    }

    @Override
    public boolean isVegan() {
        return true;
    }
}
