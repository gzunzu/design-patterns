package dto;

import channels.Channel;
import channels.Takeaway;
import channels.Telephone;
import channels.Web;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ChannelsDTO {

    @JsonProperty("web")
    private List<Web> webOrders;

    @JsonProperty("telephone")
    private List<Telephone> telephoneOrders;

    @JsonProperty("takeaway")
    private List<Takeaway> takeawayOrders;

    public List<Channel> getChannels() {
        ArrayList<Channel> channels = new ArrayList<>();
        channels.addAll(this.webOrders);
        channels.addAll(this.telephoneOrders);
        channels.addAll(this.takeawayOrders);
        return channels;
    }
}
