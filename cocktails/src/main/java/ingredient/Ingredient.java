package ingredient;

public interface Ingredient {

    String getName();

    float getCostPerUnit();

    String getMeasurementUnit();

    boolean isVegan();

    boolean hasAddedSugar();

    boolean hasGluten();
}
