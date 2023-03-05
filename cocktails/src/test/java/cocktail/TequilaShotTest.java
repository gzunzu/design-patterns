package cocktail;

import business.Vessel;

class TequilaShotTest extends BaseCocktailTest {

    @Override
    protected Cocktail getTestedCocktailInstance() {
        return new TequilaShot();
    }

    @Override
    protected String getTestedCocktailName() {
        return "tequila shot";
    }

    @Override
    protected Vessel getTestedCocktailVesselTest() {
        return Vessel.SHOT_GLASS;
    }

    @Override
    protected String TestedCocktailDescription() {
        return "Just tequila, salt and lemon. Simple, classic and hot.";
    }

    @Override
    protected float getTestedCocktailProcessingMinutes() {
        return 1.5f;
    }

    @Override
    protected float getTestedCocktailCost() {
        return 0.5f;
    }

    @Override
    protected boolean isTestedCocktailShaken() {
        return false;
    }

    @Override
    protected boolean isTestedCocktailFlamed() {
        return true;
    }

    @Override
    protected boolean isTestedCocktailServedWithAcrobatics() {
        return false;
    }

    @Override
    protected boolean doesTestedCocktailHaveJoke() {
        return true;
    }

    @Override
    protected boolean doesTestedCocktailHaveCuriousFacts() {
        return true;
    }

    @Override
    protected boolean doesTestedCocktailHaveRecommendation() {
        return true;
    }
}