package cocktails;

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

    private static final float BASE_PRICE = 1.5f;

    private static final String MEASUREMENT_UNIT = "ml";

    @Override
    public float getPricePerUnit() {
        return BASE_PRICE;
    }

    @Override
    public String getMeasurementUnit() {
        return MEASUREMENT_UNIT;
    }
}
