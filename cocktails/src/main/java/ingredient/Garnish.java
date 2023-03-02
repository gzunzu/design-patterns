package ingredient;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@SuppressWarnings("java:S1192")
public enum Garnish implements Ingredient {
    CHERRY("cherry", MeasurementUnit.UNIT),
    CELERY_STALK("celery stalk", MeasurementUnit.UNIT),
    LEMON_PEEL("lemon", MeasurementUnit.PEEL),
    LEMON_SLICE("lemon", MeasurementUnit.SLICE),
    LEMON_WEDGE("lemon", MeasurementUnit.WEDGE),
    LIME_WEDGE("lime", MeasurementUnit.WEDGE),
    MINT("mint", MeasurementUnit.LEAF),
    OLIVES("olives", MeasurementUnit.UNIT),
    ORANGE_PEEL("orange", MeasurementUnit.PEEL),
    ORANGE_SLICE("orange", MeasurementUnit.SLICE),
    PARSLEY("parsley", MeasurementUnit.SPRIG),
    PEPPERMINT("peppermint", MeasurementUnit.LEAF),
    PINEAPPLE_SLICE("pineapple", MeasurementUnit.SLICE),
    PINEAPPLE_WEDGE("pineapple", MeasurementUnit.WEDGE),
    RASPBERRY("raspberry", MeasurementUnit.UNIT),
    STRAW("straw", MeasurementUnit.UNIT),
    STRAWBERRY("strawberry", MeasurementUnit.UNIT),
    UMBRELLA("decorative umbrella", MeasurementUnit.UNIT);

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
