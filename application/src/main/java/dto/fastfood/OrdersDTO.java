package dto.fastfood;

import channels.Phone;
import channels.Takeaway;
import channels.Web;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class OrdersDTO implements Serializable {

    @JsonProperty("web")
    private List<Web> webOrders;

    @JsonProperty("phone")
    private List<Phone> phoneOrders;

    @JsonProperty("takeaway")
    private List<Takeaway> takeawayOrders;
}
