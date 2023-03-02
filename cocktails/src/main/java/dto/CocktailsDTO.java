package dto;

import cocktail.BloodyMary;
import cocktail.Cocktail;
import cocktail.MaiTai;
import cocktail.SanFrancisco;
import cocktail.TequilaShot;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CocktailsDTO {

    final int bloodyMaryCount;

    final int maiTaiCount;

    final int sanFranciscoCount;

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
            cocktails.add(new SanFrancisco("Can I have your phone number, cutie? <3"));
        }
        for (int i = 0; i < this.tequilaShotCount; i++) {
            cocktails.add(new TequilaShot());
        }
        return cocktails;
    }
}
