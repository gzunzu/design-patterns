package patterns.dependencyinjection.fastfood;

class Web extends TelematicChannel implements Promo {

    private static final String CHANNEL_NAME = "web";

    private final String email;

    Web(String location, String email) {
        super(location);
        this.email = email;
    }

    private void readForm() {
        System.out.println("Te enviaremos un e-mail a " + email + " cuando el repartidor esté cerca.");
    }

    @Override
    public void announcePromo() {
        System.out.println("¡Hoy tenemos promoción en pizzas!");
    }

    @Override
    protected String getName() {
        return CHANNEL_NAME;
    }

    @Override
    void getCommand() {
        this.readForm();
    }
}