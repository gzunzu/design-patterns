package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Web extends TelematicChannel implements Promoted {

    private static final String CHANNEL_NAME = "online";

    private static final boolean PROMOTED = true;
    @JsonProperty("email")
    private String email;

    public Web(String location, String email) {
        super(location);
        this.email = email;
    }

    @Override
    public String welcome() {
        return String.format("You are accessing to your favourite restaurant website. " +
                "Please, accept our Cookies and add the products you want to the chart.%n");
    }

    @Override
    public String getChannelName() {
        return CHANNEL_NAME;
    }

    @Override
    public boolean isActive() {
        return PROMOTED;
    }

    @Override
    public String announcePromo() {
        return String.format("We are offering 3*2 in pizzas this week!%n");
    }

    @Override
    String getCommand() {
        return this.readForm();
    }

    private String readForm() {
        return String.format("Checking every product you ordered is available. " +
                "Wait a second and don't reload this page.%n");
    }

    @Override
    public String farewell() {
        return String.format("We'll notify you through an e-mail sent to «%s» "
                        + "when the delivery worker is about to arrive.%n"
                , this.email);
    }
}