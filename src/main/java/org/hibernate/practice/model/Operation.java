package org.hibernate.practice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "operations")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @NotNull
    @Column(name = "card_pan")
    private String cardPan;
    @NotNull
    @Column(name = "merchant_name")
    private String merchantName;
    @NotNull
    @Column(name = "amount")
    private Double amount;
    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Override
    public String toString() {
        return "Operation{" +
                "accountId=" + accountId +
                ", cardPan=" + cardPan +
                ", merchantName='" + merchantName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
