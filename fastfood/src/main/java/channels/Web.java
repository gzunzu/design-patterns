package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Web extends TelematicChannel implements Promoted {

    private static final boolean PROMOTED = true;
    @Getter
    private final String channelName = "web";
    @JsonProperty("email")
    private String email;

    public Web(String location, String email) {
        super(location);
        this.email = email;
    }

    private String readForm() {
        return String.format("We'll notify you through an e-mail to «%s» when the delivery worker is about to arrive.", this.email);
    }

    @Override
    public boolean isPromoActive() {
        return PROMOTED;
    }

    @Override
    public String announcePromo() {
        return "We are offering 2*1 in pizzas this week!";
    }

    @Override
    String getCommand() {
        return this.readForm();
    }
}