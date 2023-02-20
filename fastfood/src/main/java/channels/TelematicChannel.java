package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class TelematicChannel implements Channel {

    @JsonProperty("location")
    protected String location;

    @Override
    public String serveClient() {
        return this.getCommand().concat(this.confirmShipment());
    }

    abstract String getCommand();

    String confirmShipment() {
        return String.format("Your order will be sent to %s.%n", this.location);
    }
}
