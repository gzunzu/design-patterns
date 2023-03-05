package channels;

class TelephoneTest extends BaseTelematicChannelTest {

    private static final String LOCATION = "location";

    private static final String PHONE_NUMBER = "phoneNumber";

    @Override
    protected String[] getTestedChannelWelcome() {
        return new String[]{"Hello. You're calling to your favourite fast food restaurant. What do you want to order?"};
    }

    @Override
    protected String getTestedChannelName() {
        return "telephonic";
    }

    @Override
    protected String[] getTestedChannelFarewell() {
        return new String[]{"We''ll call you back to the number ", PHONE_NUMBER, "when everything is ready. Stick close to your phone!"};
    }

    @Override
    protected boolean getTestedChannelPromoIsActive() {
        return false;
    }

    @Override
    protected String getTestedChannelPromo() {
        return null;
    }

    @Override
    protected TelematicChannel getTestedTelematicChannelInstance() {
        return new Telephone(LOCATION, PHONE_NUMBER);
    }

    @Override
    protected TelematicChannel getNoArgsConstructorTestedTelematicChannelInstance() {
        return new Telephone();
    }

    @Override
    protected String getTestedChannelLocation() {
        return LOCATION;
    }

    @Override
    protected String getTestedTelematicChannelGetCommand() {
        return "OK, everything you asked for is noted.";
    }
}