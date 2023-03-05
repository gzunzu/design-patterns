package cocktail;

import business.Vessel;

class BloodyMaryTest extends BaseCocktailTest {

    @Override
    protected Cocktail getTestedCocktailInstance() {
        return new BloodyMary();
    }

    @Override
    protected String getTestedCocktailName() {
        return "bloody mary";
    }

    @Override
    protected Vessel getTestedCocktailVesselTest() {
        return Vessel.PINT_GLASS;
    }

    @Override
    protected String TestedCocktailDescription() {
        return "A tasteful mix of strong flavours which will arise your energy to the maximum level.";
    }

    @Override
    protected float getTestedCocktailProcessingMinutes() {
        return 5f;
    }

    @Override
    protected float getTestedCocktailCost() {
        return 2f;
    }

    @Override
    protected boolean isTestedCocktailShaken() {
        return true;
    }

    @Override
    protected boolean isTestedCocktailFlamed() {
        return false;
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
        return false;
    }

    @Override
    protected boolean doesTestedCocktailHaveRecommendation() {
        return true;
    }
}