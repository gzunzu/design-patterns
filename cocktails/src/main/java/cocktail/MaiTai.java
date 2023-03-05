package cocktail;

import business.Recipe;
import business.Vessel;
import ingredient.AlcoholicBeverage;
import ingredient.Garnish;
import ingredient.Ice;
import ingredient.Juice;
import ingredient.UncategorizedDrink;

@SuppressWarnings("java:S1845")
public class MaiTai extends Cocktail {

    private static final String NAME = "mai tai";

    private static final String DESCRIPTION = "A tropical flavour with the sweetest and most juicy touch.";

    private static final float BASE_PRICE = 2f;

    private static final float PROCESSING_MINUTES = 4f;

    public MaiTai() {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES);
    }

    @Override
    protected Recipe getRecipe() {
        return new Recipe()
                .addAlcoholicBeverage(AlcoholicBeverage.RUM, 60f)
                .addAlcoholicBeverage(AlcoholicBeverage.COINTREAU, 15f)
                .addJuice(Juice.LIME, 25f)
                .addUncategorizedDrink(UncategorizedDrink.ORGEAT_SYRUP, 30f)
                .addIce(Ice.CUBES, 3f, "Put all of the previous ingredientes into a shaker and start shaking until cold.")
                .addIce(Ice.CUBES, 4f, String.format("Strain the drink into an ice-filled %s", this.getVessel().getName()))
                .addGarnish(Garnish.MINT, 2f, "Put the following garnishes on top of the drink")
                .addGarnish(Garnish.CHERRY, 1f)
                .addGarnish(Garnish.PINEAPPLE_SLICE, 1f)
                .addGarnish(Garnish.LIME_WEDGE, 1f);
    }

    @Override
    protected Vessel getVessel() {
        return Vessel.ROCKS_GLASS;
    }

    @Override
    protected boolean isShaken() {
        return true;
    }

    @Override
    protected boolean isFlamed() {
        return false;
    }

    @Override
    protected boolean isServedWithAcrobatics() {
        return false;
    }

    @Override
    protected boolean wannaTellJokeAfterServing() {
        return false;
    }

    @Override
    protected String tellJoke() {
        return null;
    }

    @Override
    protected boolean hasCuriousFact() {
        return true;
    }

    @Override
    protected String tellCuriousFacts() {
        return "Do you know Richard Nixon –ex-president of the USA– loved Mai Tai? " +
                "So much, indeed, that it was named the official cocktail of his presidency.";
    }

    @Override
    protected boolean isRecommended() {
        return false;
    }

    @Override
    protected String recommend() {
        return null;
    }
}
