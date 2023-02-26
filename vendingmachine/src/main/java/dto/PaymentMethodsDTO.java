package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import payment.BankCheque;
import payment.Cash;
import payment.DebitCard;
import payment.ElectronicPayment;
import payment.NonElectronicPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor
public class PaymentMethodsDTO {

    @JsonProperty("bankCheques")
    private List<BankCheque> bankCheques;

    @JsonProperty("cashes")
    private List<Cash> cashes;

    @JsonProperty("debitCards")
    private List<DebitCard> debitCards;

    public List<NonElectronicPayment> getNonElectronicPaymentMethods() {
        return Stream.concat(this.bankCheques.stream(), this.cashes.stream()).toList();
    }

    public List<ElectronicPayment> getElectronicPaymentMethods() {
        return new ArrayList<>(this.debitCards);
    }
}
