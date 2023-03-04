package business;

import ingredient.AlcoholicBeverage;
import ingredient.Ice;
import ingredient.Ingredient;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Step {

    private final Ingredient ingredient;

    private final float quantity;

    private final String instruction;

    public Step(Ingredient ingredient, float quantity, String instruction) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.instruction = instruction;
    }

    public Step(Ingredient ingredient, float quantity) {
        this(ingredient, quantity, null);
    }

    public Step(Ingredient ingredient, String instruction) {
        this(ingredient, 0f, instruction);
    }

    public Step(Ingredient ingredient) {
        this(ingredient, 0f);
    }

    public Step(String instruction) {
        this(null, 0f, instruction);
    }

    public boolean hasAlcohol() {
        return Objects.nonNull(this.ingredient) && this.ingredient instanceof AlcoholicBeverage;
    }

    public boolean hasIce() {
        return Objects.nonNull(this.ingredient) && this.ingredient instanceof Ice;
    }

    public boolean hasAnimalSourceComponents() {
        return Objects.nonNull(this.ingredient) && !this.ingredient.isVegan();
    }

    public boolean hasAddedSugar() {
        return Objects.nonNull(this.ingredient) && this.ingredient.hasAddedSugar();
    }

    public boolean hasGluten() {
        return Objects.nonNull(this.ingredient) && this.ingredient.hasGluten();
    }

    public float getCost() {
        return Objects.nonNull(this.ingredient) ? this.ingredient.getCostPerUnit() * this.quantity : 0f;
    }

    private String getHowTo() {
        return StringUtils.isBlank(this.instruction) ? StringUtils.EMPTY : " | How to: ".concat(this.instruction);
    }

    @Override
    public String toString() {
        if (Objects.isNull(this.ingredient)) {
            return this.instruction;
        } else {
            return String.format("Add %s %s of %s.%s",
                    this.quantity > 0 ? String.format("%.0f", this.quantity) : "a little",
                    this.ingredient.getMeasurementUnit().getSymbol(),
                    this.ingredient.getName(),
                    this.getHowTo());
        }
    }
}
