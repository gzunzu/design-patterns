class Phone extends TelematicChannel {

    private static final String CHANNEL_NAME = "telefónico";

    private final String phoneNumber;

    Phone(String location, String phoneNumber) {
        super(location);
        this.phoneNumber = phoneNumber;
    }

    private void answerCall() {
        System.out.println("Te llamaremos al nº de teléfono " + this.phoneNumber + " cuando todo esté listo.");
    }

    @Override
    protected String getName() {
        return CHANNEL_NAME;
    }

    @Override
    void getCommand() {
        this.answerCall();
    }
}