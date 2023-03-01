package cocktail;

import ingredient.Ingredient;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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

    public String getInstructions() {
        return StringUtils.isBlank(this.instructions) ? StringUtils.EMPTY : " | How to: ".concat(this.instructions);
    }

    @Override
    public String toString() {
        return String.format("Add %s %s of %s.%s",
                this.quantity > 0 ? String.format("%.0f", this.quantity) : "a little",
                this.ingredient.getMeasurementUnit().getSymbol(),
                this.ingredient.getName(),
                this.getInstructions());
    }
}
