package cocktail;

import business.Vessel;

class SanFranciscoTest extends BaseCocktailTest {

    @Override
    protected Cocktail getTestedCocktailInstance() {
        return new SanFrancisco();
    }

    @Override
    protected String getTestedCocktailName() {
        return "san francisco";
    }

    @Override
    protected Vessel getTestedCocktailVesselTest() {
        return Vessel.COLLINS_GLASS;
    }

    @Override
    protected String TestedCocktailDescription() {
        return "A fruity, large and very sweet sip.";
    }

    @Override
    protected float getTestedCocktailProcessingMinutes() {
        return 4f;
    }

    @Override
    protected float getTestedCocktailCost() {
        return 1.5f;
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
        return true;
    }

    @Override
    protected boolean doesTestedCocktailHaveJoke() {
        return false;
    }

    @Override
    protected boolean doesTestedCocktailHaveCuriousFacts() {
        return false;
    }

    @Override
    protected boolean doesTestedCocktailHaveRecommendation() {
        return false;
    }
}