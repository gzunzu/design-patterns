class Phone extends TelematicChannel {
    
    private final String PHONE_NUMBER;
    private static final String CHANNEL_NAME = "telefónico";
    
    Phone(String location, String phoneNumber) {
        super(location);
        this.PHONE_NUMBER = phoneNumber;
    }
    
    private void answerCall() {
        System.out.println("Llamada recibida desde el nº de teléfono " + this.PHONE_NUMBER + ".");
    }

    @Override
    protected void serveCustomer() {
        this.answerCall();
        this.confirmShipment();
    }

    @Override
    protected String getName() {
        return Phone.CHANNEL_NAME;
    }
}