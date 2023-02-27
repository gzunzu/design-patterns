package cocktails;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Cocktail {

    protected final float basePrice;

    protected final boolean isFlamed;

    protected List<Step> recipe;

    final boolean isMocktail() {
        return this.recipe.stream().anyMatch(step -> step.getIngredient() instanceof AlcoholicBeverage);
    }

    final Ice hasIce() {
        return this.recipe.stream().filter(step -> step.getIngredient() instanceof Ice)
                .map(step -> (Ice) step.getIngredient())
                .filter(ice -> !ice.equals(Ice.NONE)).findFirst().orElse(Ice.NONE);
    }

    final String addIce() {
        Ice ice = this.hasIce();
        return !ice.equals(Ice.NONE) ? String.format("Now we cool it with some ice %s.", StringUtils.capitalize(ice.name())) : StringUtils.EMPTY;
    }

    final boolean isFlamed() {
        return this.isFlamed;
    }

    final String flame() {
        return this.isFlamed ? "Don't call the firefighters! We are just flaming your drink!" : StringUtils.EMPTY;
    }

    protected abstract String doAcrobatics();

    protected abstract String serveDrink();

    protected String addAlcoholicDrinks() {
        StringBuilder result = new StringBuilder();
        if (this.isMocktail()) {
            result.append("This is an alcohol free cocktail (mocktail)!");
        } else {
            result.append("Here's the list of alcoholic components of this cocktail:")
                    .append(SystemUtils.LINE_SEPARATOR);
            this.recipe.stream().filter(step -> step.getIngredient() instanceof AlcoholicBeverage)
                    .map(step -> (AlcoholicBeverage) step.getIngredient())
                    .forEach(alcoholicBeverage -> result.append(String.format("%-20s | %d ml",
                            StringUtils.capitalize(alcoholicBeverage.name()),
                            alcoholicBeverage.getMeasurementUnit())));
        }
        return result.toString();
    }

    protected String getJuices() {
        StringBuilder result = new StringBuilder("Here's the list of juices of this cocktail:")
                .append(SystemUtils.LINE_SEPARATOR);
        this.recipe.stream().filter(step -> step.getIngredient() instanceof Juice)
                .map(step -> (Juice) step.getIngredient())
                .forEach(juice -> result.append(String.format("%-20s | %d ml",
                        StringUtils.capitalize(juice.name()),
                        juice.getMeasurementUnit())));
        return result.toString();
    }

    public String elaborate() {
        return StringUtils.EMPTY;
    }
}