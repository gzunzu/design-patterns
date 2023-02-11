package channels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Phone extends TelematicChannel {

    @Getter
    private final String channelName = "phone";

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    public Phone(String location, String phoneNumber) {
        super(location);
        this.phoneNumber = phoneNumber;
    }

    private String answerCall() {
        return String.format("We''ll call you back to the number %s when everything is ready.", this.phoneNumber);
    }

    @Override
    String getCommand() {
        return this.answerCall();
    }
}