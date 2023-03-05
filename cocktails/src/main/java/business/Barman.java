package business;

import cocktail.Cocktail;
import cocktail.SanFrancisco;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Barman {

    private static final float PROFIT_MARGIN_PERCENTAGE = 300;

    private final List<Cocktail> cocktails;

    public Barman() {
        this.cocktails = new ArrayList<>();
    }

    public void getCocktailOrders(List<Cocktail> cocktails) {
        this.cocktails.addAll(cocktails);
    }

    public void closeBar() {
        this.cocktails.clear();
    }

    public String openBar() {
        StringBuilder result = new StringBuilder("Bar is now open. Come in and order your drinks!")
                .append(CharUtils.LF)
                .append(CharUtils.LF);
        this.cocktails.forEach(cocktail ->
                result.append(String.format("What can I tell you about %s?", StringUtils.capitalize(cocktail.getName())))
                        .append(CharUtils.LF)
                        .append(cocktail.getInfo())
                        .append(CharUtils.LF)
                        .append(CharUtils.LF)
                        .append("Wanna try? Let's take a look at the recipe!")
                        .append(cocktail.prepare(cocktail instanceof SanFrancisco ? "Can I have your phone number, cutie? <3" : StringUtils.EMPTY))
                        .append(String.format("It's just %.2f €. Tips are welcome. Hope you like it!", this.getRetailPrice(cocktail)))
                        .append(CharUtils.LF)
                        .append(CharUtils.LF));
        return result.toString();
    }

    private double getRetailPrice(Cocktail cocktail) {
        return Math.round(cocktail.getCost() * (PROFIT_MARGIN_PERCENTAGE / 100));
    }
}
