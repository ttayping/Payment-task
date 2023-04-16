package org.hibernate.practice.model;

import java.time.LocalDate;

public class Card {
    private Long cardId;
    private Long panNumber;
    private LocalDate expireDate;
    private Integer cvv;
    private String cardType;
}
