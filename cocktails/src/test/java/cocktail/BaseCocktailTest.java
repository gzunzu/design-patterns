package cocktail;

import business.Recipe;
import business.Vessel;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

abstract public class BaseCocktailTest {

    protected Cocktail cocktail;

    @BeforeEach
    final void init() {
        this.cocktail = this.getTestedCocktailInstance();
    }

    protected abstract Cocktail getTestedCocktailInstance();

    @Test
    final void getNameTest() {
        String result = this.cocktail.getName();

        assertThat(result).isEqualTo(this.getTestedCocktailName());
    }

    protected abstract String getTestedCocktailName();

    @Test
    final void getVesselTest() {
        Vessel result = this.cocktail.getVessel();

        assertThat(result).isEqualTo(this.getTestedCocktailVesselTest());
    }

    protected abstract Vessel getTestedCocktailVesselTest();

    @Test
    final void getInfoTest() {
        String result = this.cocktail.getInfo();

        assertThat(result)
                .contains(this.TestedCocktailDescription())
                .contains(String.format("You'll have to wait around %.1f minutes while we make it for you.", this.getTestedCocktailProcessingMinutes()));
        if (this.cocktail.isMocktail()) {
            assertThat(result).contains("It's a mocktail! That means you'll find 0 % alcohol on it.");
        } else {
            assertThat(result).doesNotContain("It's a mocktail! That means you'll find 0 % alcohol on it.");
        }
        if (this.cocktail.isIced()) {
            assertThat(result).contains("It's a cold drink. Ice is used in its elaboration, so don't take too much time to finish it.");
            assertThat(result).doesNotContain("It's a non iced drink. Relax and take your time to enjoy it.");
        } else {
            assertThat(result).contains("It's a non iced drink. Relax and take your time to enjoy it.");
            assertThat(result).doesNotContain("It's a cold drink. Ice is used in its elaboration, so don't take too much time to finish it.");
        }
        if (this.cocktail.isSugarFree()) {
            assertThat(result).contains("It has no added sugar.");
            assertThat(result).doesNotContain("Some ingredients have added sugar. You'll like that sweet taste.");
        } else {
            assertThat(result).contains("Some ingredients have added sugar. You'll like that sweet taste.");
            assertThat(result).doesNotContain("It has no added sugar.");
        }
        if (this.cocktail.isGlutenFree()) {
            assertThat(result).contains("It's suitable for celiacs.");
            assertThat(result).doesNotContain("Some ingredients have gluten.");
        } else {
            assertThat(result).contains("Some ingredients have gluten.");
            assertThat(result).doesNotContain("It's suitable for celiacs.");
        }
        if (this.cocktail.isVegan()) {
            assertThat(result).contains("It's vegan.");
            assertThat(result).doesNotContain("Its elaboration requires the use of some animal source ingredients.");
        } else {
            assertThat(result).contains("Its elaboration requires the use of some animal source ingredients.");
            assertThat(result).doesNotContain("It's vegan.");
        }
        if (this.cocktail.hasCuriousFact()) {
            assertThat(result).contains(this.cocktail.tellCuriousFacts());
        }
        if (this.cocktail.isRecommended()) {
            assertThat(result).contains(this.cocktail.recommend());
        }
    }

    protected abstract String TestedCocktailDescription();

    protected abstract float getTestedCocktailProcessingMinutes();

    @Test
    final void prepareTest() {
        String result = this.cocktail.prepare();

        this.basicPrepareResultAssertion(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"specialRequest", StringUtils.EMPTY, " "})
    final void prepareWithSpecialRequestTest(String specialRequest) {
        String result = this.cocktail.prepare(specialRequest);

        this.basicPrepareResultAssertion(result);
        if (StringUtils.isNotBlank(specialRequest)) {
            assertThat(result).contains(specialRequest);
        }
    }

    private void basicPrepareResultAssertion(String result) {
        assertThat(result)
                .contains(String.format("Now we pour your drink into a %s.", this.cocktail.getVessel().getName()));
        if (this.cocktail.isShaken()) {
            assertThat(result).contains("Shaking everything!");
        } else {
            assertThat(result).doesNotContain("Shaking everything!");
        }
        if (this.cocktail.isFlamed()) {
            assertThat(result).contains("Don't call the firefighters! We are just flaming your drink!");
        } else {
            assertThat(result).doesNotContain("Don't call the firefighters! We are just flaming your drink!");
        }
        if (this.cocktail.isServedWithAcrobatics()) {
            assertThat(result).contains(this.cocktail.doAcrobatics());
        }
        if (this.cocktail.wannaTellJokeAfterServing()) {
            assertThat(result).contains(this.cocktail.tellJoke());
        }
    }

    @Test
    final void getRecipeTest() {
        Recipe result = this.cocktail.getRecipe();

        if (this.cocktail.isMocktail()) {
            assertThat(result.containsAlcohol()).isFalse();
        } else {
            assertThat(result.containsAlcohol()).isTrue();
        }
        if (this.cocktail.isIced()) {
            assertThat(result.containsIce()).isTrue();
        } else {
            assertThat(result.containsIce()).isFalse();
        }
        if (this.cocktail.isSugarFree()) {
            assertThat(result.containsAddedSugar()).isFalse();
        } else {
            assertThat(result.containsAddedSugar()).isTrue();
        }
        if (this.cocktail.isGlutenFree()) {
            assertThat(result.containsGluten()).isFalse();
        } else {
            assertThat(result.containsGluten()).isTrue();
        }
        if (this.cocktail.isVegan()) {
            assertThat(result.containsAnyNonVeganIngredient()).isFalse();
        } else {
            assertThat(result.containsAnyNonVeganIngredient()).isTrue();
        }
    }

    @Test
    final void getCostTest() {
        double result = this.cocktail.getCost();

        assertThat(result).isGreaterThanOrEqualTo(this.getTestedCocktailCost());
    }

    protected abstract float getTestedCocktailCost();

    @Test
    final void isShakenTest() {
        boolean isPropertyActive = this.cocktail.isShaken();

        if (this.isTestedCocktailShaken()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
    }

    protected abstract boolean isTestedCocktailShaken();

    @Test
    final void isFlamedTest() {
        boolean isPropertyActive = this.cocktail.isFlamed();

        if (this.isTestedCocktailFlamed()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
    }

    protected abstract boolean isTestedCocktailFlamed();

    @Test
    final void doAcrobaticsTest() {
        boolean isPropertyActive = this.cocktail.isServedWithAcrobatics();
        String resultOfPropertyMethod = this.cocktail.doAcrobatics();

        if (this.isTestedCocktailServedWithAcrobatics()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
        assertThat(resultOfPropertyMethod).isNotBlank();
    }

    protected abstract boolean isTestedCocktailServedWithAcrobatics();

    @Test
    final void tellJokeTest() {
        boolean isPropertyActive = this.cocktail.wannaTellJokeAfterServing();
        String resultOfPropertyMethod = this.cocktail.tellJoke();

        if (this.doesTestedCocktailHaveJoke()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    protected abstract boolean doesTestedCocktailHaveJoke();

    @Test
    final void tellCuriousFactsTest() {
        boolean isPropertyActive = this.cocktail.hasCuriousFact();
        String resultOfPropertyMethod = this.cocktail.tellCuriousFacts();

        if (this.doesTestedCocktailHaveCuriousFacts()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    protected abstract boolean doesTestedCocktailHaveCuriousFacts();

    @Test
    final void recommendTest() {
        boolean isPropertyActive = this.cocktail.isRecommended();
        String resultOfPropertyMethod = this.cocktail.recommend();

        if (this.doesTestedCocktailHaveRecommendation()) {
            assertThat(isPropertyActive).isTrue();
        } else {
            assertThat(isPropertyActive).isFalse();
        }
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    protected abstract boolean doesTestedCocktailHaveRecommendation();
}
