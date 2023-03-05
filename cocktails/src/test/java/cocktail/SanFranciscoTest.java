package cocktail;

import business.Recipe;
import business.Vessel;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SanFranciscoTest {

    @Mock
    private SanFrancisco cocktail;

    @BeforeEach
    void init() {
        this.cocktail = new SanFrancisco();
    }

    @Test
    void getName() {
        String result = this.cocktail.getName();

        assertThat(result).isEqualTo("san francisco");
    }

    @Test
    void getVessel() {
        Vessel result = this.cocktail.getVessel();

        assertThat(result).isEqualTo(Vessel.COLLINS_GLASS);
    }

    @Test
    void getInfo() {
        String result = this.cocktail.getInfo();

        assertThat(result)
                .contains("A fruity, large and very sweet sip.")
                .contains(String.format("You'll have to wait around %.1f minutes while we make it for you.", 4f));
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

    @Test
    void prepare() {
        String result = this.cocktail.prepare();

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
        if (this.cocktail.hasCuriousFact()) {
            assertThat(result).contains(this.cocktail.tellCuriousFacts());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"specialRequest", StringUtils.EMPTY, " "})
    void prepareWithSpecialRequest(String specialRequest) {
        String result = this.cocktail.prepare(specialRequest);

        assertThat(result)
                .contains("Shaking everything!")
                .contains(String.format("Now we pour your drink into a %s.", this.cocktail.getVessel().getName()))
                .contains(specialRequest)
                .contains(this.cocktail.doAcrobatics());
        if (StringUtils.isNotBlank(specialRequest)) {
            assertThat(result).contains(specialRequest);
        }
    }

    @Test
    void getRecipe() {
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
    void getCost() {
        double result = this.cocktail.getCost();

        assertThat(result).isGreaterThanOrEqualTo(1.5f);
    }

    @Test
    void isShaken() {
        boolean isPropertyActive = this.cocktail.isShaken();

        assertThat(isPropertyActive).isTrue();
    }

    @Test
    void isFlamed() {
        boolean isPropertyActive = this.cocktail.isFlamed();

        assertThat(isPropertyActive).isFalse();
    }

    @Test
    void doAcrobatics() {
        boolean isPropertyActive = this.cocktail.isServedWithAcrobatics();
        String resultOfPropertyMethod = this.cocktail.doAcrobatics();

        assertThat(isPropertyActive).isTrue();
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    @Test
    void tellJoke() {
        boolean isPropertyActive = this.cocktail.wannaTellJokeAfterServing();
        String resultOfPropertyMethod = this.cocktail.tellJoke();

        assertThat(isPropertyActive).isFalse();
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    @Test
    void tellCuriousFacts() {
        boolean isPropertyActive = this.cocktail.hasCuriousFact();
        String resultOfPropertyMethod = this.cocktail.tellCuriousFacts();

        assertThat(isPropertyActive).isFalse();
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }

    @Test
    void recommend() {
        boolean isPropertyActive = this.cocktail.isRecommended();
        String resultOfPropertyMethod = this.cocktail.recommend();

        assertThat(isPropertyActive).isFalse();
        if (isPropertyActive) {
            assertThat(resultOfPropertyMethod).isNotBlank();
        } else {
            assertThat(resultOfPropertyMethod).isNullOrEmpty();
        }
    }
}