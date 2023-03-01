package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UncategorizedDrink implements Ingredient {
    GRENADINE(true, true),
    ICED_TEA(true, true),
    MILK(false, false),
    TEA(true, false);

    private static final float BASE_PRICE = 0.002f;

    private static final MeasurementUnit MEASUREMENT_UNIT = MeasurementUnit.MILLILITERS;

    private final boolean isVegan;

    private final boolean hasAddedSugar;

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
    public MeasurementUnit getMeasurementUnit() {
        return MEASUREMENT_UNIT;
    }
}
