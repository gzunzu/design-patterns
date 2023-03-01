package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Soda implements Ingredient {
    COKE("coke", true),
    GINGER_ALE("ginger ale", true),
    LEMON("lemon soda", true),
    LIME("lime soda", true),
    NO_FLAVOR("soda", true),
    ORANGE("orange soda", true),
    SEVEN_UP("seven up", true),
    SPRITE("sprite", true),
    TONIC("tonic", true);

    private static final float BASE_PRICE = 0.001f;

    private static final MeasurementUnit MEASUREMENT_UNIT = MeasurementUnit.MILLILITERS;

    private final String name;

    private final boolean isVegan;

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
        return false;
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
