package cocktails;

public enum AlcoholicBeverage implements Ingredient {
    ABSINTHE,
    BEER,
    BRANDY,
    COGNAC,
    GIN,
    RUM,
    SAKE,
    TEQUILA,
    VERMOUTH,
    VODKA,
    WHISKEY,
    WINE;

    private static final float BASE_PRICE = 2f;

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