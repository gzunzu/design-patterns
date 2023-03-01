package ingredient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Condiment implements Ingredient {
    ANISE(true, false, true),
    BLACK_PEPPER(false, false, true),
    BROWN_SUGAR(true, false, true),
    CELERY_SALT(false, false, true),
    CINNAMON(true, false, true),
    CORIANDER(false, false, true),
    CUMIN(false, false, true),
    HORSERADISH(false, false, true),
    PAPRIKA(false, false, true),
    SALT(false, false, true),
    TABASCO(false, false, true),
    WHITE_SUGAR(true, false, true),
    WORCESTERSHIRE(false, true, false);

    private static final float BASE_PRICE = 0f;

    private static final MeasurementUnit MEASUREMENT_UNIT = MeasurementUnit.PINCH;

    private final boolean hasAddedSugar;

    private final boolean hasGluten;

    private final boolean isVegan;

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
        return this.hasGluten;
    }

    @Override
    public boolean isVegan() {
        return this.isVegan;
    }

    @Override
    public float getCostPerUnit() {
        return BASE_PRICE;
    }

    @Override
    public MeasurementUnit getMeasurementUnit() {
        return MEASUREMENT_UNIT;
    }
}
