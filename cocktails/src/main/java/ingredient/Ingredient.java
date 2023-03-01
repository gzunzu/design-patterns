package ingredient;

public interface Ingredient {

    String getName();

    float getCostPerUnit();

    MeasurementUnit getMeasurementUnit();

    boolean isVegan();

    boolean hasAddedSugar();

    boolean hasGluten();
}
