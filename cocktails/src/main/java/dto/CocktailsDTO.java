package dto;

import cocktail.BloodyMary;
import cocktail.Cocktail;
import cocktail.SanFrancisco;
import cocktail.TequilaShot;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CocktailsDTO {

    final int tequilaShotCount;

    final int sanFranciscoCount;

    final int bloodyMaryCount;

    public List<Cocktail> getCocktails() {
        List<Cocktail> cocktails = new ArrayList<>();
        for (int i = 0; i < this.tequilaShotCount; i++) {
            cocktails.add(new TequilaShot());
        }
        for (int i = 0; i < this.sanFranciscoCount; i++) {
            cocktails.add(new SanFrancisco("Can I have your phone number, cutie? <3"));
        }
        for (int i = 0; i < this.sanFranciscoCount; i++) {
            cocktails.add(new BloodyMary());
        }
        return cocktails;
    }
}
