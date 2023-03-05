package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Telephone extends TelematicChannel {

    private static final String CHANNEL_NAME = "telephonic";

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    public Telephone(String location, String phoneNumber) {
        super(location);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String welcome() {
        return String.format("Hello. You're calling to your favourite fast food restaurant. "
                + "What do you want to order?%n");
    }

    @Override
    public String getChannelName() {
        return CHANNEL_NAME;
    }

    @Override
    String getCommand() {
        return this.answerCall();
    }

    private String answerCall() {
        return String.format("OK, everything you asked for is noted.%n");
    }

    @Override
    public String farewell() {
        return String.format("We''ll call you back to the number %s "
                + "when everything is ready. Stick close to your phone!%n", this.phoneNumber);
    }
}