package business;

import ingredient.AlcoholicBeverage;
import ingredient.Ice;
import ingredient.Ingredient;
import ingredient.MeasurementUnit;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Log4j2
class StepTest {

    private static final float QUANTITY = 2f;
    private static final String INGREDIENT_NAME = "ingredient";
    private static final String INSTRUCTION = "instruction";
    private static final float COST_PER_UNIT = 2.5f;
    private static final String MEASUREMENT_UNIT_SYMBOL = "symbol";
    private static AutoCloseable autoCloseable;

    private Step step;
    @Mock
    private Ingredient ingredient;
    @Mock
    private MeasurementUnit measurementUnit;

    @BeforeAll
    static void init() {
        autoCloseable = MockitoAnnotations.openMocks(StepTest.class);
    }

    @AfterAll
    static void shutDown() {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            log.error("Error while trying to force close of Mocks opened for class {}.", RecipeTest.class.getSimpleName());
        }
    }

    @BeforeEach
    void setUp() {
        this.step = new Step(ingredient, QUANTITY, INSTRUCTION);
    }

    @Test
    void allArgsConstructor() {
        final Step result = new Step(this.ingredient, 1f, "instructions");

        assertThat(result).isInstanceOf(Step.class).isNotNull();
    }

    @Test
    void ingredientQuantityConstructor() {
        final Step result = new Step(this.ingredient, 1f);

        assertThat(result).isInstanceOf(Step.class).isNotNull();
    }

    @Test
    void ingredientInstructionConstructor() {
        final Step result = new Step(this.ingredient, "instruction");

        assertThat(result).isInstanceOf(Step.class).isNotNull();
    }

    @Test
    void ingredientConstructor() {
        final Step result = new Step(this.ingredient);

        assertThat(result).isInstanceOf(Step.class).isNotNull();
    }

    @Test
    void hasAlcohol() {
        final boolean result = this.step.hasAlcohol();

        assertThat(result).isEqualTo(this.ingredient instanceof AlcoholicBeverage);
    }

    @Test
    void hasIce() {
        final boolean result = this.step.hasIce();

        assertThat(result).isEqualTo(this.ingredient instanceof Ice);
    }

    @Test
    void hasAnimalSourceComponents() {
        when(this.ingredient.isVegan()).thenReturn(false);

        boolean result = this.step.hasAnimalSourceComponents();

        assertThat(result).isTrue();

        when(this.ingredient.isVegan()).thenReturn(true);

        result = this.step.hasAnimalSourceComponents();

        assertThat(result).isFalse();
    }

    @Test
    void hasAddedSugar() {
        when(this.ingredient.hasAddedSugar()).thenReturn(false);

        boolean result = this.step.hasAddedSugar();

        assertThat(result).isFalse();

        when(this.ingredient.hasAddedSugar()).thenReturn(true);

        result = this.step.hasAddedSugar();

        assertThat(result).isTrue();
    }

    @Test
    void hasGluten() {
        when(this.ingredient.hasGluten()).thenReturn(false);

        boolean result = this.step.hasGluten();

        assertThat(result).isFalse();

        when(this.ingredient.hasGluten()).thenReturn(true);

        result = this.step.hasGluten();

        assertThat(result).isTrue();
    }

    @Test
    void getCost() {
        when(this.ingredient.getCostPerUnit()).thenReturn(COST_PER_UNIT);
        final float result = this.step.getCost();

        assertThat(result).isEqualTo(COST_PER_UNIT * QUANTITY);
    }

    @Test
    void testToStringWithoutIngredient() {
        final Step stepWithoutIngredient = new Step(INSTRUCTION);
        String result = stepWithoutIngredient.toString();

        assertThat(result).isNotBlank().isEqualTo(INSTRUCTION);
    }

    @Test
    void testToStringWithIngredientPositiveQuantityAndInstructions() {
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);
        when(this.ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(this.ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);

        String result = this.step.toString();

        assertThat(result).isNotBlank().containsSubsequence(
                String.format("%.0f", QUANTITY),
                MEASUREMENT_UNIT_SYMBOL,
                INGREDIENT_NAME,
                INSTRUCTION
        );
    }

    @Test
    void testToStringWithIngredientNoQuantityAndInstructions() {
        when(this.ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(this.ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);

        final Step stepWithNoQuantity = new Step(ingredient, 0f);
        final String result = stepWithNoQuantity.toString();

        assertThat(result).isNotBlank().containsSubsequence(
                "a little",
                MEASUREMENT_UNIT_SYMBOL,
                INGREDIENT_NAME);
    }

    @Test
    void testToStringWithoutInstructions() {
        when(this.ingredient.getName()).thenReturn(INGREDIENT_NAME);
        when(this.ingredient.getMeasurementUnit()).thenReturn(this.measurementUnit);
        when(this.measurementUnit.getSymbol()).thenReturn(MEASUREMENT_UNIT_SYMBOL);

        final Step stepWithoutInstructions = new Step(ingredient, QUANTITY);
        final String result = stepWithoutInstructions.toString();

        assertThat(result).isNotBlank()
                .containsSubsequence(
                        String.format("%.0f", QUANTITY),
                        MEASUREMENT_UNIT_SYMBOL,
                        INGREDIENT_NAME)
                .doesNotContain("How to");
    }
}