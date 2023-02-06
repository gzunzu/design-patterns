class Boy extends Baby {

    Boy(String name) {
        super(Gender.BOY, name);
    }

    String sing() {
        return this.getName() + " juega cantando.";
    }

    @Override
    String pee() {
        return this + " y hace pis de pie.";
    }
}