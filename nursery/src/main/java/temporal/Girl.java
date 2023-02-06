package temporal;

class Girl extends Baby {

    Girl(String name) {
        super(Gender.GIRL, name);
    }

    String draw() {
        return this.getName() + " juega dibujando.";
    }

    @Override
    String pee() {
        return this + " y se sienta para hacer pis.";
    }
}