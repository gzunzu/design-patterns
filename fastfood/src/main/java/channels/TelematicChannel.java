package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class TelematicChannel extends Channel {

    @JsonProperty("location")
    protected String location;

    @Override
    protected String serveClient() {
        return String.format("%n%s%n%s%n", this.confirmShipment(), this.getCommand());
    }

    abstract String getCommand();

    String confirmShipment() {
        return "Your order will be sent to " + this.location + ".";
    }
}
