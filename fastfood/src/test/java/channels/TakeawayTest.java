package channels;

class TakeawayTest extends BaseChannelTest {

    private static final String CLIENT_NAME = "client name";

    @Override
    protected Channel getTestedChannelInstance() {
        return new Takeaway(CLIENT_NAME);
    }

    @Override
    protected String[] getTestedChannelWelcome() {
        return new String[]{"Welcome to our restaurant. I'll write down your command"};
    }

    @Override
    protected String getTestedChannelName() {
        return "physical";
    }

    @Override
    protected String[] getTestedChannelServeClient() {
        return new String[]{"OK, ", CLIENT_NAME, ". You can have a seat if you wish while we prepare everything."};
    }

    @Override
    protected String[] getTestedChannelFarewell() {
        return new String[]{"We'll let you know as soon as the order is ready for you to pick it up."};
    }

    @Override
    protected boolean getTestedChannelPromoIsActive() {
        return true;
    }

    @Override
    protected String getTestedChannelPromo() {
        return "We are offering a 40 % discount in every hamburger today!";
    }
}