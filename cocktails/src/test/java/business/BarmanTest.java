package business;

import cocktail.Cocktail;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BarmanTest {

    private Cocktail cocktail;

    private Barman barman;

    @BeforeEach
    void init() {
        this.barman = new Barman();
        this.cocktail = mock(Cocktail.class);
        when(this.cocktail.getName()).thenReturn("cocktail name");
        when(this.cocktail.getInfo()).thenReturn("cocktail info");
        when(this.cocktail.prepare(nullable(String.class))).thenReturn("cocktail prepare");
        when(this.cocktail.getCost()).thenReturn(Double.valueOf(1));
    }

    @Test
    void getCocktailOrders() {
        String previousResult = this.barman.openBar();

        assertThatNoException().isThrownBy(() -> {
            this.barman.getCocktailOrders(List.of(this.cocktail));

            String result = this.barman.openBar();

            assertThat(result)
                    .isNotEqualTo(previousResult)
                    .contains(StringUtils.capitalize("cocktail name"), "cocktail info", "cocktail prepare");
        });

        verify(this.cocktail).getName();
        verify(this.cocktail).getInfo();
        verify(this.cocktail).prepare(anyString());
        verify(this.cocktail).getCost();
    }

    @Test
    void closeBar() {
        String initialResult = this.barman.openBar();
        this.barman.getCocktailOrders(List.of(this.cocktail));
        String modifiedResult = this.barman.openBar();

        this.barman.closeBar();
        String result = this.barman.openBar();

        assertThat(result)
                .isEqualTo(initialResult)
                .isNotEqualTo(modifiedResult)
                .doesNotContainIgnoringCase("cocktail name", "cocktail info", "cocktail prepare");
    }

    @Test
    void openBar() {
        String previousResult = this.barman.openBar();
        this.barman.getCocktailOrders(List.of(this.cocktail));

        String result = this.barman.openBar();

        assertThat(result)
                .isNotEqualTo(previousResult)
                .contains(StringUtils.capitalize("cocktail name"), "cocktail info", "cocktail prepare");
    }
}