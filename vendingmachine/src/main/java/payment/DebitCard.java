package payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DebitCard implements ElectronicPayment {

    @JsonProperty("founds")
    private float founds;

    @JsonProperty("isActive")
    private Boolean isActive;

    @Override
    public Boolean isChargeable(Float price) {
        return this.isActive && price <= this.founds;
    }

    @Override
    public String charge(Float price, String reason) {
        this.founds -= price;
        return String.format("[DEBIT CARD PAYER] I just received a notification of a %.2f € charge with reason " + reason + ".", price);
    }
}
