package cocktails;

import ingredient.AlcoholicBeverage;
import ingredient.Decoration;
import ingredient.Ice;
import ingredient.Ingredient;
import ingredient.Juice;
import ingredient.Soda;
import ingredient.Spice;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static java.util.function.Predicate.not;

public class Recipe {

    private final ArrayList<Step> steps = new ArrayList<>();

    public Recipe addAlcoholicBeverage(AlcoholicBeverage alcoholicBeverage, float amount, String description) {
        this.steps.add(new Step(alcoholicBeverage, amount, description));
        return this;
    }

    public Recipe addAlcoholicBeverage(AlcoholicBeverage alcoholicBeverage, float amount) {
        this.steps.add(new Step(alcoholicBeverage, amount));
        return this;
    }

    public Recipe addIce(Ice ice, float amount, String description) {
        this.steps.add(new Step(ice, amount, description));
        return this;
    }

    public Recipe addIce(Ice ice, float amount) {
        this.steps.add(new Step(ice, amount));
        return this;
    }

    public Recipe addDecoration(Decoration decoration, float amount, String description) {
        this.steps.add(new Step(decoration, amount, description));
        return this;
    }

    public Recipe addDecoration(Decoration decoration, float amount) {
        this.steps.add(new Step(decoration, amount));
        return this;
    }

    public Recipe addJuice(Juice juice, float amount, String description) {
        this.steps.add(new Step(juice, amount, description));
        return this;
    }

    public Recipe addJuice(Juice juice, float amount) {
        this.steps.add(new Step(juice, amount));
        return this;
    }

    public Recipe addSoda(Soda soda, float amount, String description) {
        this.steps.add(new Step(soda, amount, description));
        return this;
    }

    public Recipe addSoda(Soda soda, float amount) {
        this.steps.add(new Step(soda, amount));
        return this;
    }

    public Recipe addSpice(Spice spice, String description) {
        this.steps.add(new Step(spice, description));
        return this;
    }

    public Recipe addSpice(Spice spice) {
        this.steps.add(new Step(spice));
        return this;
    }

    public boolean containsAlcohol() {
        return this.steps.stream()
                .map(Step::getIngredient)
                .anyMatch(AlcoholicBeverage.class::isInstance);
    }

    public boolean containsIce() {
        return this.steps.stream()
                .map(Step::getIngredient)
                .anyMatch(Ice.class::isInstance);
    }

    public boolean containsAnyNonVeganIngredient() {
        return this.steps.stream()
                .map(Step::getIngredient)
                .anyMatch(not(not(Ingredient::isVegan)));
    }

    public boolean containsAddedSugar() {
        return this.steps.stream()
                .map(Step::getIngredient)
                .anyMatch(Ingredient::hasAddedSugar);
    }

    public boolean containsGluten() {
        return this.steps.stream()
                .map(Step::getIngredient)
                .anyMatch(Ingredient::hasGluten);
    }

    public String follow() {
        StringBuilder result = new StringBuilder();
        this.steps.forEach(step -> result.append(String.format("[Step %d] Adding %s%s of %s.%s",
                this.steps.indexOf(step) + 1,
                step.getAmount() > 0 ? String.format("%f", step.getAmount()) : "a little",
                StringUtils.isEmpty(step.getIngredient().getMeasurementUnit()) ? StringUtils.EMPTY : StringUtils.leftPad(step.getIngredient().getMeasurementUnit(), 1),
                step.getIngredient().getName(),
                step.getInstructions())));
        return result.toString();
    }

    public float getCost() {
        float result = 0;
        for (Step step : this.steps) {
            result += step.getIngredient().getCostPerUnit() * step.getAmount();
        }
        return result;
    }
}
