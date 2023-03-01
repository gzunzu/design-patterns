package cocktails;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Cocktail {

    private static final float PROFIT_MARGIN_PERCENTAGE = 300;

    private final String name;

    private final float basePrice;

    protected final Recipe recipe;

    protected final boolean isMocktail() {
        return !this.recipe.containsAlcohol();
    }

    protected final boolean isIced() {
        return this.recipe.containsIce();
    }

    protected final boolean isVegan() {
        return !this.recipe.containsAnyNonVeganIngredient();
    }

    protected final boolean isSugarFree() {
        return !this.recipe.containsAddedSugar();
    }

    protected final boolean isGlutenFree() {
        return !this.recipe.containsGluten();
    }

    protected abstract boolean isFlamed();

    final String flame() {
        return this.isFlamed() ? "Don't call the firefighters! We are just flaming your drink!" : StringUtils.EMPTY;
    }

    protected abstract String doAcrobatics();

    protected abstract String tellJoke();

    protected float getPrice() {
        return (this.basePrice + this.recipe.getCost()) * (PROFIT_MARGIN_PERCENTAGE / 100);
    }

    public final String prepare() {
        return StringUtils.EMPTY;
    }
}