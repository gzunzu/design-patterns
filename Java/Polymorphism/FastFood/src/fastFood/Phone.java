package fastFood;

class Phone extends TelematicChannel {
    
    private final String PHONE_NUMBER;
    private static final String CHANNEL_NAME = "telefónico";
    
    Phone(String location, String phoneNumber) {
        super(location);
        this.PHONE_NUMBER = phoneNumber;
    }
    
    private void answerCall() {
        System.out.println("Te llamaremos al nº de teléfono " + this.PHONE_NUMBER + " cuando todo esté listo.");
    }

    @Override
    protected String getName() {
        return Phone.CHANNEL_NAME;
    }

    @Override
    void getCommand() {
        this.answerCall();
    }
}