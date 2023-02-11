package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Takeaway extends Channel implements Promoted {

    private static final boolean PROMOTED = true;

    @Getter
    private final String channelName = "takeaway";

    @JsonProperty("clientName")
    private String clientName;

    private String takeNote() {
        return "We'll notify you as soon as the order is ready " +
                "for you to take it, " + this.clientName + ".";
    }

    @Override
    protected String serveClient() {
        return String.format("%n%s%n", this.takeNote());
    }

    @Override
    public boolean isPromoActive() {
        return PROMOTED;
    }

    @Override
    public String announcePromo() {
        return "We are offering discounts in every hamburger today!";
    }
}