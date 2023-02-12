package dto.vendingmachine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import payment.BankCheque;
import payment.Cash;
import payment.DebitCard;

import java.util.List;

@NoArgsConstructor
@Data
@SuppressWarnings("java:S1948")
public class PaymentMethodsDTO {

    @JsonProperty("bankCheques")
    private List<BankCheque> bankCheques;

    @JsonProperty("cashes")
    private List<Cash> cashes;

    @JsonProperty("debitCards")
    private List<DebitCard> debitCards;
}
