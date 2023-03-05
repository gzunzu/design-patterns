package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import utils.Salute;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Takeaway implements Channel, Promoted {

    private static final String CHANNEL_NAME = "physical";

    private static final boolean PROMOTED = true;

    public Takeaway(String clientName) {
        this();
        this.clientName = clientName;
    }

    @JsonProperty("clientName")
    private String clientName;

    @Override
    public String welcome() {
        return String.format("%s! Welcome to our restaurant. I'll write down your command.%n",
                Salute.random().getText());
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
        return String.format("We are offering a 40 %% discount in every hamburger today!%n");
    }

    @Override
    public String serveClient() {
        return this.takeNote();
    }

    private String takeNote() {
        return String.format("OK, %s. You can have a seat if you wish " +
                "while we prepare everything.%n", this.clientName);
    }

    @Override
    public String farewell() {
        return String.format("We'll let you know as soon as the order is ready for you to pick it up.%n");
    }
}