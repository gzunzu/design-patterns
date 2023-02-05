package patterns.factorymethod.nursery;

abstract class Baby {

    private final String name;
    private final Gender gender;

    protected Baby(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    Gender getGender() {
        return this.gender;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " es " + this.gender.getAlias();
    }

    abstract String pee();
}