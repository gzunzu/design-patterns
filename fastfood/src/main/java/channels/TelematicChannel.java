package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
abstract class TelematicChannel implements Channel {

    @JsonProperty("location")
    protected String location;

    protected TelematicChannel(String location) {
        this();
        this.location = location;
    }

    @Override
    public final String serveClient() {
        return this.getCommand().concat(this.confirmShipment());
    }

    private String confirmShipment() {
        return String.format("Your order will be sent to %s.%n", this.location);
    }

    abstract String getCommand();
}
