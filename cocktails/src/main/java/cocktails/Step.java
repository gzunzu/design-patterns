package cocktails;

import ingredient.Ingredient;
import ingredient.Spice;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class Step {

    @Getter
    private final Ingredient ingredient;

    @Getter
    private final float amount;

    private String instructions;

    public Step(Ingredient ingredient, float amount, String instructions) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.instructions = instructions;
    }

    public Step(Ingredient ingredient, float amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public Step(Spice spice, String instructions) {
        this.ingredient = spice;
        this.amount = 0f;
        this.instructions = instructions;
    }

    public Step(Spice spice) {
        this(spice, 0f);
    }

    public String getInstructions() {
        return StringUtils.isBlank(this.instructions) ? StringUtils.EMPTY : " | How to: ".concat(this.instructions);
    }
}
