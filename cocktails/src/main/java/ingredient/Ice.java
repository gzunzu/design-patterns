package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
@Getter
public enum Ice implements Ingredient {
    BALLS("ice balls"),
    CRASHED("crashed ice"),
    CUBES("ice cubes"),
    DRY("dry ice");

    private final String name;

    @Override
    public boolean hasAddedSugar() {
        return false;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }

    private static final float BASE_PRICE = 0f;

    @Override
    public float getCostPerUnit() {
        return BASE_PRICE;
    }

    @Override
    public String getMeasurementUnit() {
        return StringUtils.EMPTY;
    }

    @Override
    public boolean isVegan() {
        return true;
    }
}
