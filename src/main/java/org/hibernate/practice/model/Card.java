package org.hibernate.practice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    @Column(name = "account_iban")
    private String accountIban;
    @Column(name = "pan_number")
    private Long panNumber;
    @Column(name = "card_balance")
    private Double cardBalance;

}
