package payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cash implements NonElectronicPayment {

    @JsonProperty("change")
    private Float change;

    @Override
    public Boolean hasEnoughFounds(Float price) {
        return this.change >= price;
    }

    @Override
    public String charge(Float price) {
        this.change -= price;
        return String.format("[CASH PAYER] Here you have %.2f € in cash.", price);
    }
}
