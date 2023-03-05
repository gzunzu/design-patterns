package channels;

class WebTest extends BaseTelematicChannelTest {

    private static final String EMAIL = "email";

    private static final String LOCATION = "location";

    @Override
    protected String[] getTestedChannelWelcome() {
        return new String[]{"You are accessing to your favourite restaurant website. Please, accept our Cookies and add the products you want to the chart."};
    }

    @Override
    protected String getTestedChannelName() {
        return "online";
    }

    @Override
    protected String[] getTestedChannelFarewell() {
        return new String[]{"We'll notify you through an e-mail sent to «", EMAIL, "» when the delivery worker is about to arrive."};
    }

    @Override
    protected boolean getTestedChannelPromoIsActive() {
        return true;
    }

    @Override
    protected String getTestedChannelPromo() {
        return "We are offering 3*2 in pizzas this week!";
    }

    @Override
    protected TelematicChannel getTestedTelematicChannelInstance() {
        return new Web(LOCATION, EMAIL);
    }

    @Override
    protected TelematicChannel getNoArgsConstructorTestedTelematicChannelInstance() {
        return new Web();
    }

    @Override
    protected String getTestedChannelLocation() {
        return LOCATION;
    }

    @Override
    protected String getTestedTelematicChannelGetCommand() {
        return "Checking every product you ordered is available. Wait a second and don't reload this page.";
    }
}