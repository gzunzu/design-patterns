class Web extends TelematicChannel implements Promo {
    
    private final String IP;
    private static final String CHANNEL_NAME = "web";
    
    Web(String location, String ip) {
        super(location);
        this.IP = ip;
    }
    
    private void readForm() {
        System.out.println("Formulario de pedido recibido desde tu IP " + IP + ".");
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