class Store extends Channel implements Promo {
    
    private final String CLIENT_NAME;
    private static final String CHANNEL_NAME = "tienda";
    
    Store(String clientName) {
        this.CLIENT_NAME = clientName;
    }
    
    private void takeNote() {
        System.out.println("Te avisamos enseguida para venir al mostrador, " + this.CLIENT_NAME + ".");
    }

    @Override
    protected void serveClient() {
        this.takeNote();
    }

    @Override
    public void announcePromo() {
        System.out.println("¡Hoy tenemos promoción en hamburgesas!");
    }
    
    @Override
    protected String getName() {
        return Store.CHANNEL_NAME;
    }
}