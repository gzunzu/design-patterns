package cocktails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SuppressWarnings("java:S1192")
public enum Ice implements Ingredient {
    BALLS("pieces"),
    CRASHED("gr"),
    CUBES("pieces"),
    DRY("pieces"),
    NONE("none");

    private static final float BASE_PRICE = 0f;

    @Getter
    private final String measurementUnit;

    @Override
    public float getPricePerUnit() {
        return BASE_PRICE;
    }
}
