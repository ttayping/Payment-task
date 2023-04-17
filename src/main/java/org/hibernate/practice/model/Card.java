package org.hibernate.practice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cards")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    @NotNull
    @Column(name = "account_iban",unique = true)
    private String accountIban;
    @NotNull
    @Column(name = "pan_number",unique = true)
    private String panNumber;
    @NotNull
    @Column(name = "card_balance")
    private Double cardBalance;

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", accountIban='" + accountIban + '\'' +
                ", panNumber='" + panNumber + '\'' +
                ", cardBalance=" + cardBalance +
                '}';
    }
}
