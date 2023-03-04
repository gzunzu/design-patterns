package business;

import ingredient.AlcoholicBeverage;
import ingredient.Condiment;
import ingredient.Garnish;
import ingredient.Ice;
import ingredient.Juice;
import ingredient.MeasurementUnit;
import ingredient.Soda;
import ingredient.UncategorizedDrink;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Log4j2
class RecipeTest {

    private static final float AMOUNT = 2f;
    private static final String INSTRUCTION = "instruction";
    private static final String INGREDIENT_NAME = "ingredient name";
    private static final String MEASUREMENT_UNIT_SYMBOL = "SYMBOL";
    private static AutoCloseable autoCloseable;

    @InjectMocks
    private Recipe recipe;
    @Mock
    private MeasurementUnit measurementUnit;

    @BeforeAll
    static void init() {
        autoCloseable = MockitoAnnotations.openMocks(RecipeTest.class);
    }

    @AfterAll
    static void shutDown() {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            log.error("Error while trying to force close of Mocks opened for class {}.", RecipeTest.class.getSimpleName());
        }
    }

    @Test
    void noArgsConstructor() {
        Recipe recipe = new Recipe();

        assertThat(recipe).isInstanceOf(Recipe.class).isNotNull();
    }

    @Test
    void testAddAlcoholicBeverageWithoutNoInstruction() {
        AlcoholicBeverage ingredient = mock(AlcoholicBeverage.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addAlcoholicBeverage(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL);
        });

    }

    @Test
    void testAddAlcoholicBeverageWithInstruction() {
        AlcoholicBeverage ingredient = mock(AlcoholicBeverage.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addAlcoholicBeverage(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void testAddGarnishWithoutInstruction() {
        Garnish ingredient = mock(Garnish.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addGarnish(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddGarnishWithInstruction() {
        Garnish ingredient = mock(Garnish.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addGarnish(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void testAddIce() {
        Ice ingredient = mock(Ice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addIce(ingredient);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddIceWithAmount() {
        Ice ingredient = mock(Ice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addIce(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddIceWithInstruction() {
        Ice ingredient = mock(Ice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addIce(ingredient, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, INSTRUCTION)
                    .doesNotContain(String.format("%.0f", AMOUNT));
        });
    }

    @Test
    void testAddIceWithAmountAndInstruction() {
        Ice ingredient = mock(Ice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addIce(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void addInstruction() {
        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addInstruction(INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INSTRUCTION)
                    .doesNotContain(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL);
        });
    }

    @Test
    void addJuiceWithoutInstruction() {
        Juice ingredient = mock(Juice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addJuice(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddJuiceWithInstruction() {
        Juice ingredient = mock(Juice.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addJuice(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void addSodaWithoutInstruction() {
        Soda ingredient = mock(Soda.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addSoda(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddSodaWithInstruction() {
        Soda ingredient = mock(Soda.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addSoda(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void addCondimentWithoutInstruction() {
        Condiment ingredient = mock(Condiment.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addCondiment(ingredient);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(String.format("%.0f", AMOUNT), INSTRUCTION);
        });
    }

    @Test
    void testAddCondimentWithInstruction() {
        Condiment ingredient = mock(Condiment.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addCondiment(ingredient, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, MEASUREMENT_UNIT_SYMBOL, INSTRUCTION)
                    .doesNotContain(String.format("%.0f", AMOUNT));
        });
    }

    @Test
    void addUncategorizedDrinkWithoutInstruction() {
        UncategorizedDrink ingredient = mock(UncategorizedDrink.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addUncategorizedDrink(ingredient, AMOUNT);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL)
                    .doesNotContain(INSTRUCTION);
        });
    }

    @Test
    void testAddUncategorizedDrinkWithInstruction() {
        UncategorizedDrink ingredient = mock(UncategorizedDrink.class);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        assertThatNoException().isThrownBy(() -> {
            Recipe result = this.recipe.addUncategorizedDrink(ingredient, AMOUNT, INSTRUCTION);

            assertThat(result).isNotNull();
            assertThat(this.recipe.follow())
                    .contains(INGREDIENT_NAME, String.format("%.0f", AMOUNT), MEASUREMENT_UNIT_SYMBOL, INSTRUCTION);
        });
    }

    @Test
    void containsAlcoholWithAlcoholicBeverage() {
        boolean previousState = this.recipe.containsAlcohol();
        AlcoholicBeverage ingredient = mock(AlcoholicBeverage.class);

        this.recipe.addAlcoholicBeverage(ingredient, AMOUNT);

        assertThat(previousState).isNotEqualTo(this.recipe.containsAlcohol());
        assertThat(this.recipe.containsAlcohol()).isTrue();
    }

    @Test
    void containsAlcoholWithoutAlcoholicBeverage() {
        boolean previousState = this.recipe.containsAlcohol();
        Juice ingredient = mock(Juice.class);

        this.recipe.addJuice(ingredient, AMOUNT);

        assertThat(previousState).isEqualTo(this.recipe.containsAlcohol());
        assertThat(this.recipe.containsAlcohol()).isFalse();
    }

    @Test
    void containsIceWithIce() {
        boolean previousState = this.recipe.containsIce();
        Ice ingredient = mock(Ice.class);

        this.recipe.addIce(ingredient);

        assertThat(previousState).isNotEqualTo(this.recipe.containsIce());
        assertThat(this.recipe.containsIce()).isTrue();
    }

    @Test
    void containsIceWithoutIce() {
        boolean previousState = this.recipe.containsIce();
        Condiment ingredient = mock(Condiment.class);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isEqualTo(this.recipe.containsIce());
        assertThat(this.recipe.containsIce()).isFalse();
    }

    @Test
    void containsAnyNonVeganIngredientWithNonVeganIngredient() {
        boolean previousState = this.recipe.containsAnyNonVeganIngredient();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.isVegan()).thenReturn(false);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isNotEqualTo(this.recipe.containsAnyNonVeganIngredient());
        assertThat(this.recipe.containsAnyNonVeganIngredient()).isTrue();
    }

    @Test
    void containsAnyNonVeganIngredientWithoutNonVeganIngredient() {
        boolean previousState = this.recipe.containsAnyNonVeganIngredient();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.isVegan()).thenReturn(true);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isEqualTo(this.recipe.containsAnyNonVeganIngredient());
        assertThat(this.recipe.containsAnyNonVeganIngredient()).isFalse();
    }

    @Test
    void containsAddedSugarWithAddedSugarIngredient() {
        boolean previousState = this.recipe.containsAddedSugar();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.hasAddedSugar()).thenReturn(true);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isNotEqualTo(this.recipe.containsAddedSugar());
        assertThat(this.recipe.containsAddedSugar()).isTrue();
    }

    @Test
    void containsAddedSugarWithoutAddedSugarIngredient() {
        boolean previousState = this.recipe.containsAddedSugar();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.hasAddedSugar()).thenReturn(false);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isEqualTo(this.recipe.containsAddedSugar());
        assertThat(this.recipe.containsAddedSugar()).isFalse();
    }

    @Test
    void containsGlutenWithGlutenIngredient() {
        boolean previousState = this.recipe.containsGluten();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.hasGluten()).thenReturn(true);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isNotEqualTo(this.recipe.containsGluten());
        assertThat(this.recipe.containsGluten()).isTrue();
    }

    @Test
    void containsGlutenWithoutGlutenIngredient() {
        boolean previousState = this.recipe.containsGluten();
        Condiment ingredient = mock(Condiment.class);
        when(ingredient.hasGluten()).thenReturn(false);

        this.recipe.addCondiment(ingredient);

        assertThat(previousState).isEqualTo(this.recipe.containsGluten());
        assertThat(this.recipe.containsGluten()).isFalse();
    }

    @Test
    void follow() {
        AlcoholicBeverage alcoholicBeverage = mock(AlcoholicBeverage.class);
        when(alcoholicBeverage.getName()).thenReturn("alcohol");
        when(alcoholicBeverage.getMeasurementUnit()).thenReturn(MeasurementUnit.MILLILITERS);
        Condiment condiment = mock(Condiment.class);
        when(condiment.getName()).thenReturn("condiment");
        when(condiment.getMeasurementUnit()).thenReturn(MeasurementUnit.PINCH);
        this.recipe.addAlcoholicBeverage(alcoholicBeverage, 10f, "alcoholicBeverageInstruction");
        this.recipe.addCondiment(condiment, "condimentInstruction");

        String result = this.recipe.follow();

        assertThat(result)
                .contains("[Step 1]", "[Step 2]")
                .contains("alcohol", MeasurementUnit.MILLILITERS.getSymbol(), String.format("%.0f", 10f), "alcoholicBeverageInstruction")
                .contains("condiment", MeasurementUnit.PINCH.getSymbol(), "condimentInstruction")
                .doesNotContain("[Step 3]");
    }

    @Test
    void getCost() {
        double previousResult = this.recipe.getCost();
        Juice juice = mock(Juice.class);
        when(juice.getCostPerUnit()).thenReturn(1.5f);
        Condiment condiment = mock(Condiment.class);
        when(condiment.getCostPerUnit()).thenReturn(0f);
        UncategorizedDrink uncategorizedDrink = mock(UncategorizedDrink.class);
        when(uncategorizedDrink.getCostPerUnit()).thenReturn(2f);
        this.recipe.addJuice(juice, 10f);
        this.recipe.addCondiment(condiment);
        this.recipe.addUncategorizedDrink(uncategorizedDrink, 20f);
        this.recipe.addInstruction(INSTRUCTION);

        double result = this.recipe.getCost();

        assertThat(result).isGreaterThan(previousResult);
        assertThat(result).isEqualTo(10f * 1.5f + 20f * 2f);
    }
}