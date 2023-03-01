package ingredient;

public enum Juice implements Ingredient {
    APPLE,
    CANTALOUPE,
    CARROT,
    COCONUT,
    CUCUMBER,
    CRANBERRY,
    LEMON,
    MANGO,
    MORA,
    ORANGE,
    PINEAPPLE,
    POMEGRANATE,
    RASPBERRY,
    STRAWBERRY,
    TOMATO;

    @Override
    public String getName() {
        return this.name().toLowerCase().replace("_", " ").concat(" juice");
    }

    private static final float BASE_PRICE = 1f;

    private static final String MEASUREMENT_UNIT = "ml";

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

    @Override
    public boolean hasAddedSugar() {
        return false;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }
}
