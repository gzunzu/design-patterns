package dto;

import cocktail.BloodyMary;
import cocktail.Cocktail;
import cocktail.MaiTai;
import cocktail.SanFrancisco;
import cocktail.TequilaShot;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CocktailsDTOTest {

    private CocktailsDTO cocktailsDTO;

    @BeforeEach
    void init() {
        this.cocktailsDTO = new CocktailsDTO(4, 1, 3, 2);
    }

    @Test
    void getCocktails() {
        List<Cocktail> result = this.cocktailsDTO.getCocktails();

        Condition<Cocktail> bloodyMaryInstanceCondition = new Condition<>(
                cocktail -> cocktail instanceof BloodyMary,
                "Instance of Bloody Mary cocktail");

        Condition<Cocktail> sanFranciscoInstanceCondition = new Condition<>(
                cocktail -> cocktail instanceof SanFrancisco,
                "Instance of San Francisco cocktail");

        Condition<Cocktail> maiTaiInstanceCondition = new Condition<>(
                cocktail -> cocktail instanceof MaiTai,
                "Instance of Mai Tai cocktail");

        Condition<Cocktail> tequilaShotInstanceCondition = new Condition<>(
                cocktail -> cocktail instanceof TequilaShot,
                "Instance of Tequila Shot cocktail");

        assertThat(result)
                .hasSize(10)
                .haveExactly(4, bloodyMaryInstanceCondition)
                .haveExactly(3, sanFranciscoInstanceCondition)
                .haveExactly(1, maiTaiInstanceCondition)
                .haveExactly(2, tequilaShotInstanceCondition);
    }
}