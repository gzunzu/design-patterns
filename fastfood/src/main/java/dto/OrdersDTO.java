package dto;

import channels.Takeaway;
import channels.Telephone;
import channels.Web;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@SuppressWarnings("java:S1948")
public class OrdersDTO implements Serializable {

    @JsonProperty("web")
    private List<Web> webOrders;

    @JsonProperty("telephone")
    private List<Telephone> telephoneOrders;

    @JsonProperty("takeaway")
    private List<Takeaway> takeawayOrders;
}
