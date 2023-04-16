package org.hibernate.practice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "operations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(name = "account_card")
    private Long accountCard;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "date")
    private LocalDate date;

    @Override
    public String toString() {
        return "Operation{" +
                "accountId=" + accountId +
                ", accountCard=" + accountCard +
                ", merchantName='" + merchantName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
