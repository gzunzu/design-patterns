package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UncategorizedDrink implements Ingredient {
    GRENADINE(true, false, true),
    ICED_TEA(true, false, true),
    MILK(false, false, false),
    ORGEAT_SYRUP(true, false, true),
    TEA(true, false, false);

    private static final float BASE_PRICE = 0.002f;

    private static final MeasurementUnit MEASUREMENT_UNIT = MeasurementUnit.MILLILITERS;

    private final boolean isVegan;

    private final boolean hasGluten;

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
        return this.hasGluten;
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
