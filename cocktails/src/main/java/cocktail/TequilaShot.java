package cocktail;

import business.Recipe;
import business.Vessel;
import ingredient.AlcoholicBeverage;
import ingredient.Condiment;
import ingredient.Garnish;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("java:S1845")
public class TequilaShot extends Cocktail {

    private static final String NAME = "tequila shot";

    private static final String DESCRIPTION = "Just tequila, salt and lemon. Simple, classic and hot.";

    private static final float BASE_PRICE = 0.5f;

    private static final float PROCESSING_MINUTES = 1.5f;

    public TequilaShot() {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES);
    }

    @Override
    protected Recipe getRecipe() {
        return new Recipe()
                .addAlcoholicBeverage(AlcoholicBeverage.TEQUILA, 40f)
                .addCondiment(Condiment.SALT, String.format("Put some %s in your hand and get ready to lick it after taking the shot.", Condiment.SALT.getName()))
                .addGarnish(Garnish.LEMON_SLICE,
                        1f,
                        String.format("You have to bite the %s after taking the shot and licking the salt. Be quick!", Garnish.LEMON_SLICE.getName()));
    }

    @Override
    protected Vessel getVessel() {
        return Vessel.SHOT_GLASS;
    }

    @Override
    protected boolean isShaken() {
        return false;
    }

    @Override
    protected boolean isFlamed() {
        return true;
    }

    @Override
    protected boolean isServedWithAcrobatics() {
        return false;
    }

    @Override
    protected String doAcrobatics() {
        return null;
    }

    @Override
    protected boolean wannaTellJokeAfterServing() {
        return true;
    }

    @Override
    protected String tellJoke() {
        return "Viva Mexico!";
    }

    @Override
    protected boolean hasCuriousFact() {
        return true;
    }

    @Override
    protected String tellCuriousFacts() {
        return "Did you know tequila is made from the heart –or «piñas»– of a plant named " +
                "«blue agave» that takes between 8 and 12 years to grow?";
    }

    @Override
    protected boolean isRecommended() {
        return true;
    }

    @Override
    protected String recommend() {
        return String.format("%ss are a really efficient way to lose your inhibitions and get quickly drunk.", StringUtils.capitalize(this.name));
    }
}
