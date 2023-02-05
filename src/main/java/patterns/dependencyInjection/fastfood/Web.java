package patterns.dependencyinjection.fastfood;

class Web extends TelematicChannel implements Promo {

    private final String email;
    private static final String CHANNEL_NAME = "web";

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
        return Web.CHANNEL_NAME;
    }

    @Override
    void getCommand() {
        this.readForm();
    }
}