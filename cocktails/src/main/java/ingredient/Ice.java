package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Ice implements Ingredient {
    BALLS("ice balls", MeasurementUnit.BALL),
    CRASHED("crashed ice", MeasurementUnit.BIT),
    CUBES("ice cubes", MeasurementUnit.BLOCK),
    DRY("dry ice", MeasurementUnit.BLOCK);

    private static final float BASE_PRICE = 0f;

    private final String name;

    private final MeasurementUnit measurementUnit;

    @Override
    public boolean hasAddedSugar() {
        return false;
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
    public boolean isVegan() {
        return true;
    }
}
