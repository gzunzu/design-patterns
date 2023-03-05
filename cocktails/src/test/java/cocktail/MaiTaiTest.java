package cocktail;

import business.Vessel;

class MaiTaiTest extends BaseCocktailTest {

    @Override
    protected Cocktail getTestedCocktailInstance() {
        return new MaiTai();
    }

    @Override
    protected String getTestedCocktailName() {
        return "mai tai";
    }

    @Override
    protected Vessel getTestedCocktailVesselTest() {
        return Vessel.ROCKS_GLASS;
    }

    @Override
    protected String TestedCocktailDescription() {
        return "A tropical flavour with the sweetest and most juicy touch.";
    }

    @Override
    protected float getTestedCocktailProcessingMinutes() {
        return 4f;
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
        return false;
    }

    @Override
    protected boolean doesTestedCocktailHaveCuriousFacts() {
        return true;
    }

    @Override
    protected boolean doesTestedCocktailHaveRecommendation() {
        return false;
    }
}