package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
    private CreditCard creditCard;
    private String orderId;
    private double amount;  // in dollars
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    @JsonCreator
    public Payment(@JsonProperty("orderId") String orderId,
                   @JsonProperty("creditCard") CreditCard creditCard,
                   @JsonProperty("amount") double amount) {
        this.orderId = orderId;
        this.creditCard = creditCard;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }
}
