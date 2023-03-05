package cocktail;

import business.Recipe;
import business.Vessel;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public abstract class Cocktail {

    @Getter
    protected final String name;

    protected final String description;

    private final float basePrice;

    private final Recipe recipe;

    private final float processingMinutes;

    private final Vessel vessel;

    protected Cocktail(String name, String description, float basePrice, float processingMinutes) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.processingMinutes = processingMinutes;
        this.recipe = this.getRecipe();
        this.vessel = this.getVessel();
    }

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

    protected abstract Recipe getRecipe();

    protected abstract Vessel getVessel();

    protected abstract boolean isShaken();

    private String shake() {
        return this.isShaken() ? "Shaking everything!" : StringUtils.EMPTY;
    }

    protected abstract boolean isFlamed();

    private String flame() {
        return this.isFlamed() ? "Don't call the firefighters! We are just flaming your drink!" : StringUtils.EMPTY;
    }

    protected abstract boolean isServedWithAcrobatics();

    protected abstract String doAcrobatics();

    protected abstract boolean wannaTellJokeAfterServing();

    protected abstract String tellJoke();

    protected abstract boolean hasCuriousFact();

    protected abstract String tellCuriousFacts();

    protected abstract boolean isRecommended();

    protected abstract String recommend();

    private String complySpecialRequest(String specialRequest) {
        return String.format("I will also attend your special request for: «%s».", specialRequest);
    }

    public final String getInfo() {
        return this.description
                .concat(SystemUtils.LINE_SEPARATOR)
                .concat(this.isMocktail() ? "It's a mocktail! That means you'll find 0 % alcohol on it.".concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat((this.isIced() ?
                        "It's a cold drink. Ice is used in its elaboration, so don't take too much time to finish it."
                        : "It's a non iced drink. Relax and take your time to enjoy it.").concat(SystemUtils.LINE_SEPARATOR))
                .concat((this.isSugarFree() ?
                        "It has no added sugar." : "Some ingredients have added sugar. You'll like that sweet taste.").concat(SystemUtils.LINE_SEPARATOR))
                .concat((this.isGlutenFree() ?
                        "It's suitable for celiacs." : "Some ingredients have gluten.").concat(SystemUtils.LINE_SEPARATOR))
                .concat((this.isVegan() ?
                        "It's vegan." : "Its elaboration requires the use of some animal source ingredients.").concat(SystemUtils.LINE_SEPARATOR))
                .concat((this.hasCuriousFact() ? this.tellCuriousFacts().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY))
                .concat(this.isRecommended() ? this.recommend().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(String.format("You'll have to wait around %.1f minutes while we make it for you.", this.processingMinutes));
    }

    public final String prepare() {
        return this.prepare(StringUtils.EMPTY);
    }

    public final String prepare(String specialRequest) {
        return this.recipe.follow()
                .concat(this.isShaken() ? this.shake().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(StringUtils.isNotBlank(specialRequest) ? this.complySpecialRequest(specialRequest).concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(this.isServedWithAcrobatics() ? this.doAcrobatics().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(String.format("Now we pour your drink into a %s.%n", this.vessel.getName()))
                .concat(this.isFlamed() ? this.flame().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY)
                .concat(this.wannaTellJokeAfterServing() ? this.tellJoke().concat(SystemUtils.LINE_SEPARATOR) : StringUtils.EMPTY);
    }

    public final double getCost() {
        return (this.basePrice + this.recipe.getCost());
    }
}