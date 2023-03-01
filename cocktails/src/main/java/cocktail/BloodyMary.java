package cocktail;

import ingredient.AlcoholicBeverage;
import ingredient.Condiment;
import ingredient.Decoration;
import ingredient.Ice;
import ingredient.Juice;

@SuppressWarnings("java:S1845")
public class BloodyMary extends Cocktail {

    private static final String NAME = "bloody mary";

    private static final String DESCRIPTION = "A tasteful mix of strong flavours which will arise your energy to the maximum level.";

    private static final float BASE_PRICE = 2f;

    private static final float PROCESSING_MINUTES = 5f;

    public BloodyMary() {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES);
    }

    public BloodyMary(String specialRequest) {
        super(NAME, DESCRIPTION, BASE_PRICE, PROCESSING_MINUTES, specialRequest);
    }

    @Override
    protected Recipe getRecipe() {
        return new Recipe()
                .addDecoration(Decoration.LEMON_WEDGE,
                        1f,
                        String.format("Rub the %s along the rim of a %s.", Decoration.LEMON_WEDGE.getName(), this.getVessel().getName()))
                .addCondiment(Condiment.CELERY_SALT,
                        String.format("Roll the outer edge of the %s in %s until fully coated.", this.getVessel().getName(), Condiment.CELERY_SALT.getName()))
                .addIce(Ice.CRASHED, String.format("Fill the %s with %s.", this.getVessel().getName(), Ice.CRASHED.getName()))
                .addDecoration(Decoration.LEMON_WEDGE, 1f)
                .addDecoration(Decoration.LIME_WEDGE,
                        1f,
                        String.format("Squeeze the %s and the %s into a shaker and drop them in.", Decoration.LEMON_WEDGE.getName(), Decoration.LIME_WEDGE.getName()))
                .addAlcoholicBeverage(AlcoholicBeverage.VODKA, 60f)
                .addJuice(Juice.TOMATO, 120f)
                .addCondiment(Condiment.HORSERADISH)
                .addCondiment(Condiment.TABASCO)
                .addCondiment(Condiment.WORCESTERSHIRE)
                .addCondiment(Condiment.BLACK_PEPPER)
                .addCondiment(Condiment.PAPRIKA)
                .addCondiment(Condiment.CELERY_SALT)
                .addIce(Ice.CUBES, 3f, "Put all the above into the shaker and shake gently.")
                .addDecoration(Decoration.PARSLEY, 3f)
                .addDecoration(Decoration.OLIVES, 2f)
                .addDecoration(Decoration.LIME_WEDGE, 1f)
                .addDecoration(Decoration.CELERY_STALK, 1f);
    }

    @Override
    protected Vessel getVessel() {
        return Vessel.PINT_GLASS;
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
    protected String doAcrobatics() {
        return null;
    }

    @Override
    protected boolean wannaTellJokeAfterServing() {
        return true;
    }

    @Override
    protected String tellJoke() {
        return "Do you want me to ask the DJ to play Lady Gaga's «Bloody Mary»?";
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
        return true;
    }

    @Override
    protected String recommend() {
        return "This one usually satisfies those who like spicy flavours. Everything but smooth.";
    }
}
