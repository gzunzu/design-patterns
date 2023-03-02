package business;

import ingredient.AlcoholicBeverage;
import ingredient.Ice;
import ingredient.Ingredient;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Step {

    @Getter
    private final Ingredient ingredient;

    @Getter
    private final float quantity;

    private final String instructions;

    public Step(Ingredient ingredient, float quantity, String instructions) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.instructions = instructions;
    }

    public Step(Ingredient ingredient, float quantity) {
        this(ingredient, quantity, null);
    }

    public Step(Ingredient ingredient, String instructions) {
        this(ingredient, 0f, instructions);
    }

    public Step(Ingredient ingredient) {
        this(ingredient, 0f);
    }

    public Step(String instructions) {
        this(null, 0f, instructions);
    }

    public String getHowTo() {
        return StringUtils.isBlank(this.instructions) ? StringUtils.EMPTY : " | How to: ".concat(this.instructions);
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

    @Override
    public String toString() {
        if (Objects.isNull(this.ingredient)) {
            return this.instructions;
        } else {
            return String.format("Add %s %s of %s.%s",
                    this.quantity > 0 ? String.format("%.0f", this.quantity) : "a little",
                    this.ingredient.getMeasurementUnit().getSymbol(),
                    this.ingredient.getName(),
                    this.getHowTo());
        }
    }
}
