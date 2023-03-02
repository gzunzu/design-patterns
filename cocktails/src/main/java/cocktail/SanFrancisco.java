package cocktail;

import business.Recipe;
import business.Vessel;
import ingredient.Condiment;
import ingredient.Garnish;
import ingredient.Ice;
import ingredient.Juice;
import ingredient.UncategorizedDrink;

@SuppressWarnings("java:S1845")
public class SanFrancisco extends Cocktail {

    private static final String NAME = "san francisco";

    private static final String DESCRIPTION = "A fruity, large and very sweet sip.";

    private static final float BASE_PRICE = 1.5f;

    private static final float PROCESSING_MINUTES = 4f;

    public SanFrancisco() {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES);
    }

    public SanFrancisco(String specialRequest) {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES, specialRequest);
    }

    @Override
    protected Recipe getRecipe() {
        return new Recipe()
                .addJuice(Juice.ORANGE, 75f)
                .addJuice(Juice.PEACH, 75f)
                .addJuice(Juice.PINEAPPLE, 75f)
                .addUncategorizedDrink(UncategorizedDrink.GRENADINE, 40f)
                .addIce(Ice.CRASHED)
                .addCondiment(Condiment.WHITE_SUGAR, String.format("Put some %s in the shaker along with the juices. Also, once served in the %s, put %s covering the rim.",
                        Condiment.WHITE_SUGAR.getName(),
                        this.getVessel().getName(),
                        Condiment.WHITE_SUGAR.getName()))
                .addGarnish(Garnish.ORANGE_PEEL,
                        1f,
                        String.format("Curl the %s and put it on top of the floating %s. ", Garnish.ORANGE_PEEL.getName(), Ice.CRASHED.getName()))
                .addGarnish(Garnish.STRAW, 1f);
    }

    @Override
    protected Vessel getVessel() {
        return Vessel.COLLINS_GLASS;
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
        return true;
    }

    @Override
    protected String doAcrobatics() {
        return "Watch me while I do some tricks throwing the shaker over the air to mix everything perfectly! ";
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
        return false;
    }

    @Override
    protected String tellCuriousFacts() {
        return null;
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
