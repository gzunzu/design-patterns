package ingredient;

public enum Juice implements Ingredient {
    APPLE,
    CANTALOUPE,
    CARROT,
    COCONUT,
    CUCUMBER,
    CRANBERRY,
    LEMON,
    LIME,
    MANGO,
    MORA,
    ORANGE,
    PEACH,
    PINEAPPLE,
    POMEGRANATE,
    RASPBERRY,
    STRAWBERRY,
    TOMATO;

    private static final float BASE_PRICE = 0.002f;

    private static final MeasurementUnit MEASUREMENT_UNIT = MeasurementUnit.MILLILITERS;

    @Override
    public String getName() {
        return this.name().toLowerCase().replace("_", " ").concat(" juice");
    }

    @Override
    public float getCostPerUnit() {
        return BASE_PRICE;
    }

    @Override
    public MeasurementUnit getMeasurementUnit() {
        return MEASUREMENT_UNIT;
    }

    @Override
    public boolean isVegan() {
        return true;
    }

    @Override
    public boolean hasAddedSugar() {
        return false;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }
}
