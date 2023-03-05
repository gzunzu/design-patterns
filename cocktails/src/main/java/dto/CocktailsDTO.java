package dto;

import cocktail.BloodyMary;
import cocktail.Cocktail;
import cocktail.MaiTai;
import cocktail.SanFrancisco;
import cocktail.TequilaShot;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CocktailsDTO {

    @PositiveOrZero
    final int bloodyMaryCount;

    @PositiveOrZero
    final int maiTaiCount;

    @PositiveOrZero
    final int sanFranciscoCount;

    @PositiveOrZero
    final int tequilaShotCount;

    public List<Cocktail> getCocktails() {
        List<Cocktail> cocktails = new ArrayList<>();
        for (int i = 0; i < this.bloodyMaryCount; i++) {
            cocktails.add(new BloodyMary());
        }
        for (int i = 0; i < this.maiTaiCount; i++) {
            cocktails.add(new MaiTai());
        }
        for (int i = 0; i < this.sanFranciscoCount; i++) {
            cocktails.add(new SanFrancisco());
        }
        for (int i = 0; i < this.tequilaShotCount; i++) {
            cocktails.add(new TequilaShot());
        }
        return cocktails;
    }
}
