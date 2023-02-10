package payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankCheque implements NonElectronicPayment {

    @JsonProperty("debtor")
    private String debtor;

    @Override
    public Boolean hasEnoughFounds(Float price) {
        return Boolean.TRUE;
    }

    @Override
    public String charge(Float price) {
        return String.format("[BANK CHEQUE PAYER] Take this %.2f € worth cheque signed by «" + this.debtor + "».", price);
    }
}
