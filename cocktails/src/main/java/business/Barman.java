package business;

import cocktail.Cocktail;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Barman {

    private static final float PROFIT_MARGIN_PERCENTAGE = 300;

    private final List<Cocktail> cocktails;

    public Barman() {
        this.cocktails = new ArrayList<>();
    }

    public void getCocktailOrders(Cocktail... cocktails) {
        this.getCocktailOrders(Arrays.asList(cocktails));
    }

    public void getCocktailOrders(List<Cocktail> cocktails) {
        this.cocktails.addAll(cocktails);
    }

    public void closeBar() {
        this.cocktails.clear();
    }

    public String openBar() {
        StringBuilder result = new StringBuilder("Bar is now open. Come in and order your drinks!")
                .append(SystemUtils.LINE_SEPARATOR)
                .append(SystemUtils.LINE_SEPARATOR);
        this.cocktails.forEach(cocktail ->
                result.append(String.format("What can I tell you about %s?", StringUtils.capitalize(cocktail.getName()))
                        .concat(SystemUtils.LINE_SEPARATOR)
                        .concat(cocktail.getInfo())
                        .concat(SystemUtils.LINE_SEPARATOR)
                        .concat(SystemUtils.LINE_SEPARATOR)
                        .concat("Wanna try? Let's follow the recipe!")
                        .concat(cocktail.prepare())
                        .concat(String.format("It's just %.2f €. Tips are welcome. Hope you like it!", this.getRetailPrice(cocktail)))
                        .concat(SystemUtils.LINE_SEPARATOR)
                        .concat(SystemUtils.LINE_SEPARATOR)));
        return result.toString();
    }

    private float getRetailPrice(Cocktail cocktail) {
        return Math.round(cocktail.getCost() * (PROFIT_MARGIN_PERCENTAGE / 100));
    }
}
