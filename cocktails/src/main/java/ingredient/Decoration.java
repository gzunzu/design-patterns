package ingredient;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@SuppressWarnings("java:S1192")
public enum Decoration implements Ingredient {
    LEMON_PEEL("lemon", "peel(s)"),
    LEMON_SLICE("lemon", "slice(s)"),
    MINT("mint", "leaf(s)"),
    OLIVES("olives", "piece(s)"),
    ORANGE_PEEL("orange", "peel(s)"),
    ORANGE_SLICE("orange", "slice(s)"),
    PEPPERMINT("peppermint", "leaf(s)"),
    RASPBERRY("raspberry", "piece(s)"),
    STRAWBERRY("strawberry", "piece(s)");

    private final String name;

    private final String measurementUnit;

    @Override
    public boolean hasAddedSugar() {
        return false;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }

    private static final float BASE_PRICE = 0.2f;

    @Override
    public float getCostPerUnit() {
        return BASE_PRICE;
    }

    @Override
    public boolean isVegan() {
        return true;
    }
}
