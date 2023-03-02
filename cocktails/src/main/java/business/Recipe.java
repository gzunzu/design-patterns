package business;

import ingredient.AlcoholicBeverage;
import ingredient.Condiment;
import ingredient.Garnish;
import ingredient.Ice;
import ingredient.Juice;
import ingredient.Soda;
import ingredient.UncategorizedDrink;
import org.apache.commons.lang3.SystemUtils;

import java.util.ArrayList;

public class Recipe {

    private final ArrayList<Step> steps = new ArrayList<>();

    public Recipe addAlcoholicBeverage(AlcoholicBeverage alcoholicBeverage, float amount, String instructions) {
        this.steps.add(new Step(alcoholicBeverage, amount, instructions));
        return this;
    }

    public Recipe addAlcoholicBeverage(AlcoholicBeverage alcoholicBeverage, float amount) {
        this.steps.add(new Step(alcoholicBeverage, amount));
        return this;
    }

    public Recipe addGarnish(Garnish garnish, float amount, String instructions) {
        this.steps.add(new Step(garnish, amount, instructions));
        return this;
    }

    public Recipe addGarnish(Garnish garnish, float amount) {
        this.steps.add(new Step(garnish, amount));
        return this;
    }

    public Recipe addIce(Ice ice, float amount, String instructions) {
        this.steps.add(new Step(ice, amount, instructions));
        return this;
    }

    public Recipe addIce(Ice ice, float amount) {
        this.steps.add(new Step(ice, amount));
        return this;
    }

    public Recipe addIce(Ice ice, String instructions) {
        this.steps.add(new Step(ice, instructions));
        return this;
    }

    public Recipe addIce(Ice ice) {
        this.steps.add(new Step(ice));
        return this;
    }

    public Recipe addInstruction(String instruction) {
        this.steps.add(new Step(instruction));
        return this;
    }

    public Recipe addJuice(Juice juice, float amount, String instructions) {
        this.steps.add(new Step(juice, amount, instructions));
        return this;
    }

    public Recipe addJuice(Juice juice, float amount) {
        this.steps.add(new Step(juice, amount));
        return this;
    }

    public Recipe addSoda(Soda soda, float amount, String instructions) {
        this.steps.add(new Step(soda, amount, instructions));
        return this;
    }

    public Recipe addSoda(Soda soda, float amount) {
        this.steps.add(new Step(soda, amount));
        return this;
    }

    public Recipe addCondiment(Condiment condiment, String instructions) {
        this.steps.add(new Step(condiment, instructions));
        return this;
    }

    public Recipe addCondiment(Condiment condiment) {
        this.steps.add(new Step(condiment));
        return this;
    }

    public Recipe addUncategorizedDrink(UncategorizedDrink uncategorizedDrink, float amount, String instructions) {
        this.steps.add(new Step(uncategorizedDrink, amount, instructions));
        return this;
    }

    public Recipe addUncategorizedDrink(UncategorizedDrink uncategorizedDrink, float amount) {
        this.steps.add(new Step(uncategorizedDrink, amount));
        return this;
    }

    public boolean containsAlcohol() {
        return this.steps.stream()
                .anyMatch(Step::hasAlcohol);
    }

    public boolean containsIce() {
        return this.steps.stream()
                .anyMatch(Step::hasIce);
    }

    public boolean containsAnyNonVeganIngredient() {
        return this.steps.stream()
                .anyMatch(Step::hasAnimalSourceComponents);
    }

    public boolean containsAddedSugar() {
        return this.steps.stream()
                .anyMatch(Step::hasAddedSugar);
    }

    public boolean containsGluten() {
        return this.steps.stream()
                .anyMatch(Step::hasGluten);
    }

    public String follow() {
        StringBuilder result = new StringBuilder(SystemUtils.LINE_SEPARATOR);
        this.steps.forEach(step -> result.append(String.format("[Step %d] %s%n",
                this.steps.indexOf(step) + 1,
                step.toString())));
        return result.toString();
    }

    public double getCost() {
        return this.steps.stream()
                .mapToDouble(Step::getCost)
                .sum();
    }
}
